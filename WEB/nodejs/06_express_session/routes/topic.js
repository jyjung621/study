
var express = require('express');
var router = express.Router();

var fs = require('fs');
var path = require('path');
var template = require('../lib/template.js');
var sanitizeHtml = require('sanitize-html');
var auth = require('../lib/auth');

router.get('/create', function (request, response) {
    var title = 'WEB - create';
    var list = template.list(request.list);
    var html = template.HTML(title, list, `
        <form action="/topic/create_process" method="post">
          <p><input type="text" name="title" placeholder="title"></p>
          <p>
            <textarea name="description" placeholder="description"></textarea>
          </p>
          <p>
            <input type="submit">
          </p>
        </form>
      `,
       '', 
       auth.StatusUI(request, response)
       );
    response.send(html);
});

router.post('/create_process', function (request, response) {
    /* var body = '';
    request.on('data', function (data) {
      body = body + data;
    });
    request.on('end', function () {
      var post = qs.parse(body);
      var title = post.title;
      var description = post.description;
      fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
        response.redirect(`/topic/${title}`);
      });
    }); */

    // body-parser 라는 middleware를 사용하여 코드를 더욱 간결하게 만들수 있음
    // post방식으로 받은 data를 request.body로 받을수 있음!!!
    if(!auth.IsOwner(request, response)) {
        console.log('Not login...');
        response.redirect('/');
        return false;
    }
    var post = request.body;
    var title = post.title;
    var description = post.description;
    fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
        response.redirect(`/topic/${title}`);
    });
});

router.get('/update/:pageId', function (request, response) {
    if(!auth.IsOwner(request, response)) {
        console.log('Not login...');
        response.redirect('/');
        return false;
    }
    var filteredId = path.parse(request.params.pageId).base;
    fs.readFile(`data/${filteredId}`, 'utf8', function (err, description) {
        var title = request.params.pageId;
        var list = template.list(request.list);
        var html = template.HTML(title, list,
            `
          <form action="/topic/update_process" method="post">
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
          `<a href="/topic/create">create</a> <a href="/topic/update/${title}">update</a>`,
          auth.StatusUI(request,response) 
        );
        response.send(html);
    });
});

router.post('/update_process', function (request, response) {
    if(!auth.IsOwner(request, response)) {
        console.log('Not login...');
        response.redirect('/');
        return false;
    }
    var post = request.body;
    var id = post.id;
    var title = post.title;
    var description = post.description;
    fs.rename(`data/${id}`, `data/${title}`, function (error) {
        fs.writeFile(`data/${title}`, description, 'utf8', function (err) {
            response.redirect(`/topic/${title}`);
        })
    });
});

router.post('/delete_process', function (request, response) {
    if(!auth.IsOwner(request, response)) {
        console.log('Not login...');
        response.redirect('/');
        return false;
    }
    var post = request.body;
    var id = post.id;
    var filteredId = path.parse(id).base;
    fs.unlink(`data/${filteredId}`, function (error) {
        response.redirect('/');
    });
});


/*
 *  Route Parameters
 * 
 *    Route path: /users/:userId/books/:bookId
 *    Request URL: http://localhost:3000/users/34/books/8989
 *    req.params: { "userId": "34", "bookId": "8989" }
 */
router.get('/:pageId', function (request, response, next) {
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
                ` <a href="/topic/create">create</a>
              <a href="/topic/update/${sanitizedTitle}">update</a>
              <form action="/topic/delete_process" method="post">
                <input type="hidden" name="id" value="${sanitizedTitle}">
                <input type="submit" value="delete">
              </form>`,
              auth.StatusUI(request,response)
            );
            response.send(html);
        }
    });
});


module.exports = router;