var http = require('http');
// requre('url') -> url을 사용
var url = require('url');
var qs = require('querystring');
var path = require('path');
// 모듈화  --> 리펙토링 진행
var template = require('./lib/template.js');
var db = require('./lib/db');
var topic = require('./lib/topic');



var app = http.createServer(function (request, response) {
  var _url = request.url;
  var queryData = url.parse(_url, true).query;
  var pathname = url.parse(_url, true).pathname;

  if (pathname === '/') {
    // home page
    if (queryData.id === undefined) {
      topic.home;

      // id 선택한 page
    } else {
      db.query(`select * from topic`, function(error, topics) {
        if(error) {
          throw error;
        }
        //console.log(topics);
        db.query(`select * from topic left join author on topic.author_id=author.id where topic.id=?`, [queryData.id], function(error2, topic) {
          if(error2) {
            throw error2;
          }
          //console.log(topic);
          var title = topic[0].title;
          var description = topic[0].description;
          var list = template.list(topics);
          var html = template.html(title, list, 
              `<h2>${title}</h2><p>${description}</p><p>by ${topic[0].name}</p>`,
              `<a href='/create'>create</a>
              <a href='/update?id=${queryData.id}'>update</a>
              <form action="delete_process" method="post" onsubmit="확실?">
                <input type="hidden" name="id" value="${queryData.id}">
                <input type="submit" value="delete">
              </form>`
            );
    
          response.writeHead(200);
          response.end(html);
        });
      });

    }
    // 글 생성 Form
  } else if (pathname === '/create') {
    db.query(`select * from topic`, function(error, topics) {
      if(error) {
        throw error;
      }
      db.query('select * from author', function(error2, authors) {
        var title = 'Create';
        var list = template.list(topics);
        var html = template.html(title, list, 
          `<form action="/create_process" method="post">
            <p><input type="text" name="title" placeholder="title"></p>
            <p><textarea name="description" placeholder="description"></textarea></p>
            <p>
              ${template.authorSelect(authors, '')}
            </p>
            <p><input type="submit" value="완료"></p>
          </form>`, 
          ``
          );
      
        response.writeHead(200);
        response.end(html);
      });
    });

    // 글 생성 Process
  } else if (pathname === '/create_process') {
    var body = '';

    //  웹브라우저가 post 방식으로 전송 할 경우, 조각조각 받기 위한 방법 (callback 이용)
    request.on('data', function (data) {
      body += data;
      // Too much POST data, kill the connection!
      // 1e6 === 1 * Math.pow(10, 6) === 1 * 1000000 ~~~ 1MB
      if (body.length > 1e6) {
        request.connection.destroy();
      }
    });
    //  정보 수신이 끝날때 end 실행
    request.on('end', function () {
      var post = qs.parse(body);  // post -> { title: '123', description: '1234' }
      // 내용을 파일로 생성
      db.query('insert into topic (title, description, created, author_id) values (?,?,now(),?)',
        [post.title, post.description, post.author], 
        function(error, result) {
          if(error) {
            throw error;
          }
          response.writeHead(302, { Location: `/?id=${result.insertId}` });
          response.end();
        });
      
    });

    //  글 제목 및 내용 수정 Form
  } else if (pathname === '/update') {
    db.query(`select * from topic`, function(error, topics) {
      if(error) {
        throw error;
      }
      db.query(`select * from topic where id=?`, [queryData.id], function(error2, topic) {
        if(error2) { 
          throw error2;
        }
        db.query('select * from author', function(error2, authors) {
          var list = template.list(topics);
          var html = template.html(topic[0].title, list, 
            `<form action="/update_process" method="post">
              <input type="hidden" name="id" value="${topic[0].id}">
              <p><input type="text" name="title" placeholder="title" value="${topic[0].title}"></p>
              <p><textarea name="description" placeholder="description">${topic[0].description}</textarea></p>
              <p>${template.authorSelect(authors, topic[0].author_id)}</p>
              <p><input type="submit" value="완료"></p>
            </form>`, 
            `<a href='/create'>create</a> <a href='/update?id=${topic[0].id}'>update</a>`
          ); 

        response.writeHead(200);
        response.end(html);
        });
      });
    });
    //  글 제목 및 내용 수정 Process
  } else if (pathname === '/update_process') {
    var body = '';

    request.on('data', function (data) {
      body += data;
      if (body.length > 1e6) {
        request.connection.destroy();
      }
    });

    request.on('end', function () {
      var post = qs.parse(body);
      // join update example
      // update topic t inner join author a on t.author_id=a.id set t.title=?, t.description=?, t.author_id=? where t.id=?
      db.query('update topic set title=?, description=?, author_id=? where id=?', 
        [post.title, post.description, post.author, post.id], 
        function(error, result) {
          if(error) {
            throw error;
          }
          response.writeHead(302, { Location: `/?id=${post.id}` });
          response.end();
        });
    });



    // 글 삭제 기능 Process
  } else if (pathname === '/delete_process') {
    var body = '';

    request.on('data', function (data) {
      body += data;
      if (body.length > 1e6) {
        request.connection.destroy();
      }
    });

    request.on('end', function () {
      var post = qs.parse(body);
      var id = post.id;
      var filterdId = path.parse(id).base;

      db.query('delete from topic where id=?', [post.id], function(error, result) {
        response.writeHead(302, { Location: `/` });
        response.end();
      })
    });

  } else {
    response.writeHead(404);
    response.end('Not found');
  }


});
//  port 번호 : 3000
app.listen(3000);