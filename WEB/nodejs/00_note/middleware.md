
 
 Express Middleware
    
  - middleware는 순차적으로 실행된다.

  - 남이 많든 middleware 사용해보기
    1. body-parser
        post 방식으로 받은 데이터를 간편하게 처리하기 위한 방법
        > npm install body-parser --save

    2. compression
        용량이 많은 page의 data를 압축해서 관리
        > npm install compression --save

  - 내가 직접  middleware 만들어보기
    - middleware의 기본구성
    <pre><code>var myLogger = function (req, res, next) {
            console.log('LOGGED')
            next()
        }
        app.use(myLogger)
    </code></pre>
  - 정적인 파일을 사용하기
    1. image파일 사용
    <pre><code>app.use(express.static('public'));  // public디렉토리 안에서 static파일을 찾음
    </code></pre>
