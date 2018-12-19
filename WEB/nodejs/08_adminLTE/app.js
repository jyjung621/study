
/****************************************************************************************** 
 *  Define
 ******************************************************************************************/
const express = require('express');
const app = express();
const port = 3000;

// MySql DB
/* var db = require('./lib/db'); */
// compression -> page용량이 클경우 압축해서 관리
/* var compression = require('compression');
var session = require('express-session');
var FileStore = require('session-file-store')(session); */


// router
/* var indexRouter = require('./routes/index');
var boardRouter = require('./routes/board');
var memberRouter = require('./routes/member');
var homeRouter = require('./routes/home');
var bookRouter = require('./routes/book'); */



// 보안강화 Helmet 사용
/* var helmet = require('helmet'); */

/****************************************************************************************** 
 *  Use
 ******************************************************************************************/
/* app.use(compression());
app.use(helmet());
app.use(session({
  secret: 'dfbvhas%#@$dvns',
  resave: false,
  saveUninitialized: true,
  store: new FileStore()
})) */


 /****************************************************************************************** 
 *  Main (router로 정리하였기에....)
 ******************************************************************************************/
/* app.use('/', indexRouter);
app.use('/board', boardRouter);
app.use('/member', memberRouter);
app.use('/home', homeRouter);
app.use('/book', bookRouter); */





 /****************************************************************************************** 
 *  Error Process
 ******************************************************************************************/
// page를 찾을수 없을 경우를 나타낼때
app.use(function (request, response, next) {
  response.status(404).send('Sorry cant find that!');
});

// error handler 내가 원하는 방식으로 꾸미기
app.use(function (err, request, response, next) {
  console.log(err);
  response.status(500).send('Something broke!<br><br>' + err);
});


 /****************************************************************************************** 
 *  listen
 ******************************************************************************************/
// app.listen(port, () => console.log(`Example app listening on port ${port}!`));
app.listen(port, function () {
  return console.log(`Board app listening on port ${port}!`);
});




