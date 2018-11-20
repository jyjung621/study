
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
    response.redirect('/member/loginForm');
});

router.get('/loginForm', (request, response) => {
    response.render('memberLoginForm.ejs', {
        message : ""
    });
});


router.post('/loginPro', (request, response) => {
    var body = request.body;
   
    db.query("select * from member where email=?",[body.email], (err, rs) => {
        if(err) {
            console.log('loginPro select error : ' + err);
            throw err;
        }
        // console.log('rs --> ' + rs[0]);
        if(!rs[0]) {
            console.log('회원 정보 없음...');
            return response.render('memberLoginForm.ejs', {
                message : "로그인 실패(회원정보 없음)" 
            });
        } else {
            if(body.passwd === rs[0].passwd) {
                console.log('로그인... 성공!!');
                return response.redirect('/home');
            } else {
                console.log('로그인... 실패 (비밀번호 오류)');
                return response.render('memberLoginForm.ejs', {
                    message : "로그인 실패(비밀번호 재확인)" 
                });
            }
        }
    });
});

router.get('/joinForm', (request, response) => {
    response.render('memberJoinForm.ejs');
});

router.post('/joinPro', (request, response) => {
    var body = request.body;

    db.query("insert into member values (?,?,?,?,'3',sysdate())",[body.email, body.passwd, body.nickName, body.telNum], (err, rs) => {
        if(err) {
            console.log('joinPro insert error : ' + err);
            throw err;
        }
        return response.redirect('loginForm');
    });
});




module.exports = router;