
var express = require('express');
var router = express.Router();

var fs = require('fs');
var path = require('path');
var template = require('../lib/template.js');
var sanitizeHtml = require('sanitize-html');

var authData = {
    email: 'rucy@gmail.com',
    password: '1234',
    nickname: 'rucy'
}

router.get('/login', function (request, response) {
    var title = 'WEB - login';
    var list = template.list(request.list);
    var html = template.HTML(title, list, `
        <form action="/auth/login_process" method="post">
          <p><input type="text" name="email" placeholder="email"></p>
          <p><input type="password" name="pwd" placeholder="password"></p>
          <p>
            <input type="submit" value="login">
          </p>
        </form>
      `, '');
    response.send(html);
});

router.post('/login_process', function (request, response) {
    // body-parser 라는 middleware를 사용하여 코드를 더욱 간결하게 만들수 있음
    // post방식으로 받은 data를 request.body로 받을수 있음!!!
    console.log('login_process....');
    var post = request.body;
    var email = post.email;
    var password = post.pwd;
    if(email === authData.email && password === authData.password) {
        // 인증 성공!!
        console.log('login success!!');
        request.session.is_logined = true;
        request.session.nickname = authData.nickname;
        request.session.save(function() {
            response.redirect(`/`);
        });        
    } else {
        response.send('Who?!?!')
    }
});

router.get('/logout', function (request, response) {
    request.session.destroy(function(err) {
        response.redirect('/');
    });
});

module.exports = router;