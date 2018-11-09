
var express = require('express');
var router = express.Router();

var template = require('../lib/template.js');

/*
 *  function 사용 방법
 */
// app.get('/', (req, res) => res.send('Hello World!'));
router.get('/', function (request, response) {
    //fs.readdir('./data', function (error, filelist) {
    var title = 'Welcome';
    var description = 'Hello, Node.js';
    // 내가 만든 middleware를 통하여 filelist -> request.list로 대체할수 있음
    var list = template.list(request.list);
    var html = template.HTML(title, list,
      `<h2>${title}</h2><p>${description}</p>
       <img src="/images/hello.jpg" style="width:300px; display:block; margin-top:20px;">
      `,
      `<a href="/topic/create">create</a>`
    );
    response.send(html);
    //});
  });

  module.exports = router;