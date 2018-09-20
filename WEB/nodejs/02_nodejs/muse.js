/**
 * 
 *  Module Example
 * 
 */


// var M = {
//     v:'v',
//     f:function() {
//         console.log(this.v);
//     }
// }
// M.f();

// module로 선언안 객체를 가져와서 사용
var part = require('./mpart.js');

console.log(part);
part.f();
