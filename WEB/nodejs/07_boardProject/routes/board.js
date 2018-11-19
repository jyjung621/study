
var express = require('express');
var router = express.Router();
var app = express();
var ejs = require('ejs');
var db = require('../lib/db');
var bodyParser = require('body-parser');


app.engine('ejs', ejs.renderFile);
router.use(bodyParser.json());
router.use(bodyParser.urlencoded({ extended: false }));



router.get('/list', function(request, response) {
    
    db.query('select * from board', function(err, data) {
        if(err) {
            throw err;
        }

       /*  console.log('data --> ' + data);
        console.log('data[0].content --> ' + data[0].content); */

        response.render('boardList.ejs', {
            title : "boardList",
            list : data
        });
    });
});

router.get('/writeForm', function(request, response) {
    var title = "writeForm";
    var memberId = "rucy";

    response.render('boardWriteForm.ejs', {
        title : title,
        memberId : memberId
    });
});

router.post('/writePro', function(request, response) {
    var title = request.body.title;
    console.log("title -> " + title);
    var content = request.body.content;
    console.log("content -> " + content);
    var writer = request.body.memberId;
    console.log("writer -> " + writer);
    db.query('select count(*) cnt from board', function(err1, cnt) {
        console.log('cnt --> ' + cnt[0].cnt);
        var boardNo = cnt[0].cnt + 1;
        if(err1) {
            console.log('writePro err1 ... ');
            throw err1;
        }
        db.query('insert into board (boardNo, title, content, memberId, regDate) values (?, ?, ?, ?, sysdate())',[boardNo,title,content,writer], function(err2,data) {
            if(err2) {
                console.log('writePro err2 ... ');
                throw err2;
            }
        });
    });

    response.redirect('/board/list');
});

module.exports = router;