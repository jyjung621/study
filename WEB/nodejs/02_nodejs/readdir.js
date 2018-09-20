var testFolder = './data/';
var fs = require('fs');

/*  
    파일 목록 알아보기
    .readdir() 이용 => 배열로 나타내줌
    
    출력 : [ 'CSS', 'HTML', 'JavaScript' ]
*/

fs.readdir(testFolder, function(error, filelist) {
    console.log(filelist);
})