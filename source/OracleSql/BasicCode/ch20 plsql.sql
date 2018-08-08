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
select ename, job, sal from emp;