var db = require('db');
//  외부로 함수 형식으로 보낼경우
exports.home = function () {
    db.query(`select * from topic`, function (error, topics) {
        var title = 'Welcome';
        var description = 'Hello, Node.js';
        var list = template.list(topics);
        var html = template.html(title, list, `<h2>${title}</h2><p>${description}</p>`, `<a href='/create'>create</a>`);

        response.writeHead(200);
        response.end(html);
    });
}

