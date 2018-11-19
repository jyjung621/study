
/****************************************************************************************** 
 *  Define
 ******************************************************************************************/
/*
 * express 실습
 */
const express = require('express');
const app = express();
const port = 3000;
var fs = require('fs');

/**
 *  middleware 사용해보기
 */
// body-parser : post 방식으로 받은 데이터를 간편하게 처리 
var bodyParser = require('body-parser');
// compression
var compression = require('compression');

/**
 *  Router 를 사용하여 코드 정리하기
 */
var indexRouter = require('./routes/index');
var topicRouter = require('./routes/topic');
var authRouter = require('./routes/auth');

/**
 *  보안강화 Helmet 사용해보기
 */
var helmet = require('helmet');

/**
 *  세션 사용
 */
var session = require('express-session');
// file을 이용하여 session 보관
var FileStore = require('session-file-store')(session);

/****************************************************************************************** 
 *  Use
 ******************************************************************************************/
/**
 *  middleware use
 *    main 페이지가 실행될 때마다, 사용자가 요청한 middleware 실행됨
 */
app.use(bodyParser.urlencoded({ extended: false }));
app.use(compression());
app.use(express.static('public'));
app.use(helmet());

app.use(session({
    secret: 'dfbvhas%#@$dvns',
    resave: false,
    saveUninitialized: true,
    store: new FileStore()
}))


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


 /****************************************************************************************** 
 *  Main (router로 정리하였기에....)
 ******************************************************************************************/
// /topic 으로 시작하는 주소에 topicRouter라는 middleware를 적용 한다는 의미
app.use('/', indexRouter);
app.use('/topic', topicRouter);
app.use('/auth', authRouter);



 /****************************************************************************************** 
 *  Error Process
 ******************************************************************************************/
// page를 찾을수 없을 경우를 나타낼때
app.use(function (request, response, next) {
  response.status(404).send('Sorry cant find that!');
});

// error handler 내가 원하는 방식으로 꾸미기
app.use(function (err, request, response, next) {
  response.status(500).send('Something broke!');
});


 /****************************************************************************************** 
 *  listen
 ******************************************************************************************/
// app.listen(port, () => console.log(`Example app listening on port ${port}!`));
app.listen(port, function () {
  return console.log(`Example app listening on port ${port}!`);
});




