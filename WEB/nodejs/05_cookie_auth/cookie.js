var http = require('http');
var cookie = require('cookie');

http.createServer(function(request, response) { 
    // cookie 값 알아보기  request.headers.cookie
    console.log(request.headers.cookie);

    var cookies = {};
    if(request.headers.cookie !== undefined) {
        // 쿠키 정보를 json 형식으로 읽어오는 방법
        var cookies = cookie.parse(request.headers.cookie);
    }
    
    console.log(cookies);
    response.writeHead(200, {
        'Set-Cookie' : [
            'yummy_cookie=choco1', 
            'tasty_cookie=strawberry',
            `Permanent=cookies; Max-Age=${60*60}`,
            'Secure=Secure; Secure',        // https 로 통신 할 경우 보안체계 발동
            'HttpOnly=HttpOnly; HttpOnly',  // JavaScript 로 쿠키 값을 가져가지 못하게 함
            'Path=Path; Path=/cookie',      // Path 지정을 하면, 그 디렉토리 아래에서만 쿠키 사용 가능
            'Domain=Domain; Domain=o2.org' 
        ]
    });
    response.end('Cookie!!');
}).listen(3000);