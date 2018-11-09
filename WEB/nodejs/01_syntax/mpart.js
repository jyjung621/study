

var M = {
    v:'v',
    f:function() {
        console.log(this.v);
    }
}


// mpart.js 에 있는 M이라는 객체를 밖에서 사용가능 하게 함
module.exports = M;