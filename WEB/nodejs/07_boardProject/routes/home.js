
var express = require('express');
var router = express.Router();
var app = express();
var ejs = require('ejs');
var db = require('../lib/db');
var bodyParser = require('body-parser');

// var md = require('../lib/memberDao');


app.engine('ejs', ejs.renderFile);
router.use(bodyParser.json());
router.use(bodyParser.urlencoded({ extended: false }));

router.get('/sampleView', (req, res) => {
    res.render('basicForm1.ejs');
});

router.get('/', (request, response) => {
    response.redirect('/home/main');
});

router.get('/admin', (request, response) => {
    request.session.is_logined = true;
    request.session.nickname = "Admin";
    request.session.grade = 0;
    request.session.userId = "admin@admin.com";
    response.render('home.ejs', {
        is_logined : request.session.is_logined,
        nickname : request.session.nickname,
        grade : request.session.grade,
        userId : request.session.userId
    });
});

router.get('/main', (request, response) => {
    response.render('home.ejs', {
        is_logined : request.session.is_logined,
        nickname : request.session.nickname
    });
});

module.exports = router;