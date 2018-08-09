-- pl/sql 기본 실습

-- procedure (pl/sql 문법으로 만든 프로그램)를 실행하려면
-- 반드시 출력결과값이 보여지도록 환경 설정 필요
SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('hello, world!');
END;
/

-- 2. 외부파일 실행
@C:\devenv\oracle실습\plsql\exam01.SQL

-- 3. 레퍼런스 데이터타입 실습
@C:\devenv\oracle실습\plsql\exam02.SQL

-- 4. 테이블타입 실습
@C:\devenv\oracle실습\plsql\exam03.SQL

-- 5. record type 실습
@C:\devenv\oracle실습\plsql\exam04.SQL
@C:\devenv\oracle실습\plsql\exam05.SQL

-- scott 연봉계산하기 (quiz)
@C:\devenv\oracle실습\plsql\quiz01.SQL
-- scott 연봉계산하기 (if-else)
@C:\devenv\oracle실습\plsql\exam06.SQL
-- 부서번호로 부서명 찾기 (if-else)
@C:\devenv\oracle실습\plsql\exam07.SQL

-- 반복문 실습 (basic loop)
@C:\devenv\oracle실습\plsql\exam08.SQL
-- 반복문 실습 (quiz 구구단 출력)
@C:\devenv\oracle실습\plsql\quiz02.SQL

-- 반복문 실습 (for loop)
@C:\devenv\oracle실습\plsql\exam09.SQL
-- 반복문 실습 (quiz for loop)
@C:\devenv\oracle실습\plsql\quiz03.SQL

-- 반목문 실습 (while loop)
@C:\devenv\oracle실습\plsql\exam10.SQL
-- 반목문 실습 (quiz 별 while loop)
@C:\devenv\oracle실습\plsql\quiz04.SQL