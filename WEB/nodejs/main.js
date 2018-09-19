var http = require('http');
var fs = require('fs');
// requre('url') -> url을 사용
var url = require('url');


function templateHTML(title, list, body) {
  var template = `
    <!doctype html>
    <html>
    <head>
      <title>WEB1 - ${title}</title>
      <meta charset="utf-8">
    </head>
    <body>
      <h1><a href="/">WEB</a></h1>  
      ${list}
      <a href='/create'>create</a>
      ${body}
    </body>
    </html>
    `;

  return template;
}

function templateList(filelist) {
  var list = '<ul>';
  for (var i = 0; i < filelist.length; i++) {
    list += `<li><a href='/?id=${filelist[i]}'>${filelist[i]}</a></li>`;
  }
  list += '</ul>';

  return list;
}


var app = http.createServer(function (request, response) {
  var _url = request.url;
  var queryData = url.parse(_url, true).query;
  var pathname = url.parse(_url, true).pathname;

  if (pathname === '/') {
    if (queryData.id === undefined) {
      /*
        .readdir() => file목록을 읽어옴
        자동으로 list 생성할수 있게 할수 있음
      */
      fs.readdir('./data', function (error, filelist) {
        var title = 'Welcome';
        var description = 'Hello, Node.js';
        // list를 file목록에서 읽어와서 자동으로 생성되게 함
        var list = templateList(filelist);
        // html code 생성
        var template = templateHTML(title, list, `<h2>${title}</h2><p>${description}</p>`);

        response.writeHead(200);
        response.end(template);
      })

    } else {
      fs.readdir('./data', function (error, filelist) {
        /*
            파일을 읽어서 본문 전달
            .readFile(filePath, encode, function)로 파일을 읽어와서 ${description} 을 통하여 전달
        */
        fs.readFile(`./data/${queryData.id}`, 'utf8', function (err, description) {
          var title = queryData.id;
          var list = templateList(filelist);
          var template = templateHTML(title, list, `<h2>${title}</h2><p>${description}</p>`);
          response.writeHead(200);
          response.end(template);
        });
      });
    }
    //  페이지를 못 찾을 경우
  } else if (pathname === '/create') {
    fs.readdir('./data', function (error, filelist) {
      var title = 'WEB - create';
      var list = templateList(filelist);
      var template = templateHTML(title, list, `
      <form action="http://localhost:3000/process_create" method="post">
        <p><input type="text" name="title" placeholder="title"></p>
        <p><textarea name="description" placeholder="description"></textarea></p>
        <p><input type="submit" value="완료"></p>
      </form>
      `);

      response.writeHead(200);
      response.end(template);
    })

  } else {
    response.writeHead(404);
    response.end('Not found');
  }




});
//  port 번호 : 3000
app.listen(3000);