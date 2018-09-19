/*
 *  동기 VS 비동기
 */


// console.log('A');
// var fs = require('fs');

// // readFileSync (동기)
// var result = fs.readFileSync('01_syntax/sample.txt', 'utf-8');

// console.log(result);
// console.log('C');


/*
 * 출력   A
 *        b
 *        C
 */


console.log('A');
var fs = require('fs');

// readFile (비동기)
fs.readFile('01_syntax/sample.txt', 'utf-8', function(err, result) {
    console.log(result);
});
console.log('C');

/*
 * 출력   A
 *        C
 *        b
 */



