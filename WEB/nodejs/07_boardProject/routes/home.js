
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


router.get('/', (request, response) => {
    response.redirect('/home/main');
});

router.get('/main', (request, response) => {
    response.render('home.ejs', {
        message : ""
    });
});

module.exports = router;