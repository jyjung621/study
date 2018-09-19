/*
    함수
*/

f123();
console.log('-----');
f123();

//  기본적인 함수 구성
function f123() {
    console.log(1);
    console.log(2);
    console.log(3);
}
function blk() {
    console.log('-----');
}


blk();
console.log(sum(1,4));

// 함수의 입/출력
function sum(first, second) {
    return first+second;
}