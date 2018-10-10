

 
 ##Package Manager
 ------------
 
  - NPM  
    > nodejs에서 많이 사용됨
    > PM2검색하면 homepage 나옴
  - 설치방법
      <pre><code>npm install pm2 -g</code><pre>
 
  - 실행방법
    <pre><code>pm2 start main.js
      pm2 list
      pm2 stop main
      pm2 stop    
      pm2 restart 
      pm2 delete 
 
      pm2 start main.js --watch  ==> 감시하고 있다가 변경사항있으면 자동으로 반영
 
      pm2 log ==> error나 변경사항 확인가능
 
      ** 이 방식으로 해야 서버가 꺼졌다 켜지지 않음
      pm2 start main.js --watch --ignore-watch="data/*" --no-daemon
      pm2 start main.js --watch --ignore-watch="data/*  sessions/*" --no-daemon
                                             띄워쓰기해서 여러 디렉토리 선택가능
    </code></pre>
 
  - package 관리
    <pre><code>
      npm init  ==>  package.json 생성
 
      npm install -S  ==> 내 프로젝트 내에서만 적용
                  -g  ==> 전역에서 적용
    </code></pre>
 
  - sanitize-html  
    > 출력에 대한 보안대책(점차 많은 사람들이 사용중)
    >           npm sanitize html 구글링
  
  - 설치방법
      <pre><code>npm install -S sanitize-html    // node_modules 디렉토리에 생성</code></pre>
 
  - 사용법  
    > 구글링 참조
 