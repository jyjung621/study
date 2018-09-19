/*
 * Callback
 */

function a() {
    console.log('A');
}

// JavaScript 에서는 함수는 값으로 인식함
var b = function() {
    console.log('B');
}

a();
// 변수가 가지고 있는 함수를 실행가능
b();


// callback 사용 방법
function slowfunc(callback) {
    callback();
}
slowfunc(b);