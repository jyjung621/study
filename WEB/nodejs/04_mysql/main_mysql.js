var http = require('http');
// requre('url') -> url을 사용
var url = require('url');
// 모듈화  --> 리펙토링 진행
var db = require('./lib/db');
var topic = require('./lib/topic');
var author = require('./lib/author');



var app = http.createServer(function (request, response) {
  var _url = request.url;
  var queryData = url.parse(_url, true).query;
  var pathname = url.parse(_url, true).pathname;

  if (pathname === '/') {
    // home page
    if (queryData.id === undefined) {
      topic.home(request, response);

      // id 선택한 page
    } else {
      db.query(`select * from topic`, function (error, topics) {
        if (error) {
          throw error;
        }

        topic.page(request, response);
      });

    }
    // 글 생성 Form
  } else if (pathname === '/create') {
    topic.create(request, response);

    // 글 생성 Process
  } else if (pathname === '/create_process') {
    topic.create_process(request, response);

    //  글 제목 및 내용 수정 Form
  } else if (pathname === '/update') {
    topic.update(request, response);

    //  글 제목 및 내용 수정 Process
  } else if (pathname === '/update_process') {
    topic.update_process(request, response);
    // 글 삭제 기능 Process
  } else if (pathname === '/delete_process') {
    topic.delete_process(request, response);

  } else if(pathname === '/author') {
    author.home(request, response);
  } else if(pathname === '/author/create_proecss') {
    author.create_process(request, response);
  } else if(pathname === '/author/update') {
    author.update(request, response);
  } else if(pathname === '/author/update_process') {
    author.update_process(request, response);
  } else if(pathname === '/author/delete_process') {
    author.delete_process(request, response);

  } else {
    response.writeHead(404);
    response.end('Not found');
  }


});
//  port 번호 : 3000
app.listen(3000);