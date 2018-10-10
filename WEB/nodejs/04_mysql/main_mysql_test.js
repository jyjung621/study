var http = require('http');
var fs = require('fs');

var mysql = require('mysql');

var db = mysql.createConnection({
  host      : 'localhost',
  user      : 'ruin',
  password  : '1234',
  database  : 'opentutorials'
});

db.connect();

var app = http.createServer(function(request,response){
    var url = request.url;
    if(request.url == '/'){
      url = '/mysql_test.html';
    }
    if(request.url == '/favicon.ico'){
      return response.writeHead(404);
    }

    db.query(`select * from topic where id=1`, function (error, topics) {
      if(error) {
        console.log('error -> ' + error);
        throw error;
      }
      console.log('-----topics-----\n' + topics[0].title);
    });


    response.writeHead(200);
    response.end(fs.readFileSync(__dirname + url));
 
});
app.listen(3000);