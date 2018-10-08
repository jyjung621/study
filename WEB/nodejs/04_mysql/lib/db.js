// MySql reference
var mysql = require('mysql');
// mysql connection info
var db = mysql.createConnection({
    host      : 'localhost',
    user      : 'ruin',
    password  : '1234',
    database  : 'opentutorials'
  });

  
// Real connection
db.connect();

// 외부에서 실행가능 하게 함
module.exports = db;