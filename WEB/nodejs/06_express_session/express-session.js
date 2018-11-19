var express = require('express')
var parseurl = require('parseurl')
var session = require('express-session')
// file을 이용하여 session 보관
var FileStore = require('session-file-store')(session);

var app = express()

// session middleware는 request의 properties로 session을 넣어줌
app.use(session({
    secret: 'keyboard cat',
    resave: false,
    saveUninitialized: true,
    store: new FileStore()
}))

app.get('/', function (req, res, next) {
    console.log(req.session);
    if (req.session.num === undefined) {
        req.session.num = 1;
    } else {
        req.session.num = req.session.num + 1;
    }
    res.send(`Views : ${req.session.num}`);
});

app.listen(3000, function () {
    console.log('3000!')
});