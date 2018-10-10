var http = require('http');
var fs = require('fs');
// requre('url') -> url을 사용
var url = require('url');
var qs = require('querystring');
var path = require('path');

// 모듈화  --> 리펙토링 진행
var template = require('./lib/template.js');

// 출력에 대한 보안대책 (sanitize-html)
var sanitizeHtml = require('sanitize-html');



var app = http.createServer(function (request, response) {
  var _url = request.url;
  var queryData = url.parse(_url, true).query;
  var pathname = url.parse(_url, true).pathname;

  if (pathname === '/') {
    // home page
    if (queryData.id === undefined) {
      /*
        .readdir() => file목록을 읽어옴
        자동으로 list 생성할수 있게 할수 있음
      */
      fs.readdir('./data', function (error, filelist) {
        var title = 'Welcome';
        var description = 'Hello, Node.js';
        // list를 file목록에서 읽어와서 자동으로 생성되게 함
        var list = template.list(filelist);
        // html code 생성
        var html = template.html(title, list, `<h2>${title}</h2><p>${description}</p>`, `<a href='/create'>create</a>`
        );

        response.writeHead(200);
        response.end(html);
      })

      // id 값 선택한 page
    } else {
      fs.readdir('./data', function (error, filelist) {
        // 경로를 숨기기 위한 방안
        var filterdId = path.parse(queryData.id).base;
        /*
            파일을 읽어서 본문 전달
            .readFile(filePath, encode, function)로 파일을 읽어와서 ${description} 을 통하여 전달
        */
        fs.readFile(`./data/${filterdId}`, 'utf8', function (err, description) {
          var title = queryData.id;
          // sanitize --> 내가 사용하는 변수가 소독되었는지 확인
          // script와 같은 Tag들이 있으면 작동 시키지 않음
          var sanitizedTitle = sanitizeHtml(title);
          // allowedTags:[] => 허용하고자 하는 태그
          var sanitizedDescription = sanitizeHtml(description, {
            allowedTags:['h1']
          });
          var list = template.list(filelist);
          var html = template.html(title, list, `<h2>${sanitizedTitle}</h2><p>${sanitizedDescription}</p>`, `<a href='/create'>create</a> 
              <a href='/update?id=${sanitizedTitle}'>update</a> 
              <form action="delete_process" method="post" onsubmit="확실?">
                <input type="hidden" name="id" value="${sanitizedTitle}">
                <input type="submit" value="delete">
              </form>`  // 삭제 기능은 link가 아닌 form 형식으로 하는게 좋다!
          );
          response.writeHead(200);
          response.end(html);
        });
      });
    }
    //  페이지를 못 찾을 경우
  } else if (pathname === '/create') {
    fs.readdir('./data', function (error, filelist) {
      var title = 'WEB - create';
      var list = template.list(filelist);
      var html = template.html(title, list, `
      <form action="/create_process" method="post">
        <p><input type="text" name="title" placeholder="title"></p>
        <p><textarea name="description" placeholder="description"></textarea></p>
        <p><input type="submit" value="완료"></p>
      </form>
      `, '');

      response.writeHead(200);
      response.end(html);
    })

    // 글 생성
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
      var title = post.title;
      var description = post.description;

      // 내용을 파일로 생성
      fs.writeFile(`./data/${title}`, description, 'utf-8', function (err) {
        // 200 -> 성공  302 -> 다른곳으로 이동
        // location: `/?id=${title}`  -> 이곳으로 바로 이동
        response.writeHead(302, { Location: `/?id=${title}` });
        response.end();
      });
    });

    //  글 제목 및 내용 수정
  } else if (pathname === '/update') {
    fs.readdir('./data', function (error, filelist) {
      var filterdId = path.parse(queryData.id).base;
      fs.readFile(`./data/${filterdId}`, 'utf8', function (err, description) {
        var title = queryData.id;
        var list = template.list(filelist);
        var html = template.html(title, list
          , `<form action="/update_process" method="post">
              <input type="hidden" name="id" value="${title}">
              <p><input type="text" name="title" placeholder="title" value="${title}"></p>
              <p><textarea name="description" placeholder="description">${description}</textarea></p>
              <p><input type="submit" value="완료"></p>
            </form>`
          , `<a href='/create'>create</a> <a href='/update?id=${title}'>update</a>`
        );
        response.writeHead(200);
        response.end(html);
      });
    });


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
      var id = post.id;
      var title = post.title;
      var description = post.description;

      fs.rename(`./data/${id}`, `./data/${title}`, function (error) {
        fs.writeFile(`./data/${title}`, description, 'utf-8', function (err) {
          response.writeHead(302, { Location: `/?id=${title}` });
          response.end();
        });
      });
    });

    // 글 삭제 기능
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

      fs.unlink(`./data/${filterdId}`, function (error) {
        response.writeHead(302, { Location: `/` });
        response.end();
      });
    });

  } else {
    response.writeHead(404);
    response.end('Not found');
  }




});
//  port 번호 : 3000
app.listen(3000);