/*
 * express 실습
 */

const express = require('express');
const app = express();
const port = 3000;
var fs = require('fs');
var qs = require('querystring');
var path = require('path');
var template = require('./lib/template.js');
var sanitizeHtml = require('sanitize-html');

/**
 *  middleware 사용해보기
 */
// body-parser : post 방식으로 받은 데이터를 간편하게 처리 
var bodyParser = require('body-parser');
// compression
var compression = require('compression');

/**
 *  middleware use
 *    main 페이지가 실행될 때마다, 사용자가 요청한 middleware 실행됨
 */
app.use(bodyParser.urlencoded({ extended: false }));
app.use(compression());
app.use(express.static('public'));
/* 
app.use(function (request, response, next) {
  fs.readdir('./data', function (error, filelist) {
    request.list = filelist;
    next(); // next에 그 다음에 호출되어야 할 middleware가 담겨 있음 -> () 실행
  });
}); // 결과 -> [ 'CSS','Express','HTML' ]
 */

// process처리과정(post방식)에서 글 목록을 불러오는 것은 비효율 적이므로 
// 동작하지 않게 하기위하여 get에서만 동작하도록 변경
// '*' -> 모든항목에 해당
app.get('*', function (request, response, next) {
  fs.readdir('./data', function (error, filelist) {
    request.list = filelist;
    next();
  });
});


/*
 *  function 사용 방법
 */
// app.get('/', (req, res) => res.send('Hello World!'));
app.get('/', function (request, response) {
  //fs.readdir('./data', function (error, filelist) {
  var title = 'Welcome';
  var description = 'Hello, Node.js';
  // 내가 만든 middleware를 통하여 filelist -> request.list로 대체할수 있음
  var list = template.list(request.list);
  var html = template.HTML(title, list,
    `<h2>${title}</h2><p>${description}</p>
     <img src="/images/hello.jpg" style="width:300px; display:block; margin-top:20px;">
    `,
    `<a href="/create">create</a>`
  );
  response.send(html);
  //});
});

/*
 *  Route Parameters
 * 
 *    Route path: /users/:userId/books/:bookId
 *    Request URL: http://localhost:3000/users/34/books/8989
 *    req.params: { "userId": "34", "bookId": "8989" }
 */
app.get('/page/:pageId', function (request, response, next) {
  var filteredId = path.parse(request.params.pageId).base;
  fs.readFile(`data/${filteredId}`, 'utf8', function (err, description) {
    if (err) {
      next(err);
    } else {
      var title = request.params.pageId;
      var sanitizedTitle = sanitizeHtml(title);
      var sanitizedDescription = sanitizeHtml(description, {
        allowedTags: ['h1']
      });
      var list = template.list(request.list);
      var html = template.HTML(sanitizedTitle, list,
        `<h2>${sanitizedTitle}</h2>${sanitizedDescription}`,
        ` <a href="/create">create</a>
            <a href="/update/${sanitizedTitle}">update</a>
            <form action="/delete_process" method="post">
              <input type="hidden" name="id" value="${sanitizedTitle}">
              <input type="submit" value="delete">
            </form>`
      );
      response.send(html);
    }
  });
});

app.get('/create', function (request, response) {
  var title = 'WEB - create';
  var list = template.list(request.list);
  var html = template.HTML(title, list, `
      <form action="/create_process" method="post">
        <p><input type="text" name="title" placeholder="title"></p>
        <p>
          <textarea name="description" placeholder="description"></textarea>
        </p>
        <p>
          <input type="submit">
        </p>
      </form>
    `, '');
  response.send(html);
});

app.post('/create_process', function (request, response) {
  /* var body = '';
  request.on('data', function (data) {
    body = body + data;
  });
  request.on('end', function () {
    var post = qs.parse(body);
    var title = post.title;
    var description = post.description;
    fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
      response.redirect(`/page/${title}`);
    });
  }); */

  // body-parser 라는 middleware를 사용하여 코드를 더욱 간결하게 만들수 있음
  // post방식으로 받은 data를 request.body로 받을수 있음!!!
  var post = request.body;
  var title = post.title;
  var description = post.description;
  fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
    response.redirect(`/page/${title}`);
  });
});

app.get('/update/:pageId', function (request, response) {
  var filteredId = path.parse(request.params.pageId).base;
  fs.readFile(`data/${filteredId}`, 'utf8', function (err, description) {
    var title = request.params.pageId;
    var list = template.list(request.list);
    var html = template.HTML(title, list,
      `
        <form action="/update_process" method="post">
          <input type="hidden" name="id" value="${title}">
          <p><input type="text" name="title" placeholder="title" value="${title}"></p>
          <p>
            <textarea name="description" placeholder="description">${description}</textarea>
          </p>
          <p>
            <input type="submit">
          </p>
        </form>
        `,
      `<a href="/create">create</a> <a href="/update?id=${title}">update</a>`
    );
    response.send(html);
  });
});

app.post('/update_process', function (request, response) {
  var post = request.body;
  var id = post.id;
  var title = post.title;
  var description = post.description;
  fs.rename(`data/${id}`, `data/${title}`, function (error) {
    fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
      response.redirect(`/page/${title}`);
    })
  });
});

app.post('/delete_process', function (request, response) {
  var post = request.body;
  var id = post.id;
  var filteredId = path.parse(id).base;
  fs.unlink(`data/${filteredId}`, function (error) {
    response.redirect('/');
  });
});

// page를 찾을수 없을 경우를 나타낼때
app.use(function (request, response, next) {
  response.status(404).send('Sorry cant find that!');
});

// error handler 내가 원하는 방식으로 꾸미기
app.use(function (err, request, response, next) {
  response.status(500).send('Something broke!');
});

// app.listen(port, () => console.log(`Example app listening on port ${port}!`));
app.listen(port, function () {
  return console.log(`Example app listening on port ${port}!`);
});




