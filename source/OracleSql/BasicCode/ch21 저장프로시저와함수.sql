DROP TABLE emp01;
CREATE TABLE emp01 AS SELECT * FROM emp;

select * from emp01;

-- DELETE FROM emp01;
-- emp01의 행전체를 삭제하는 저장 프로시저를 만들어서 테스트
-- 1. proc01.sql을 데이터베이스에 저장 (compile->프로시저등록)
@C:\devenv\oracle실습\저장프로시저\proc01.SQL
-- 2. 실행
EXECUTE del_all;
-- 오류에 대한 정보 확인
SHOW ERROR;

-- 매개 변수를 가지는 저장 프로시저 실습
@C:\devenv\oracle실습\저장프로시저\proc02.SQL
EXECUTE del_ename('SMITH');
EXECUTE del_ename('ALLEN');
SELECT * FROM emp01; 

-- 매개 변수 INOUT 실습
@C:\devenv\oracle실습\저장프로시저\proc03.SQL
-- return 받을 변수 선언
VARIABLE var_ename VARCHAR2(15);
VARIABLE var_sal NUMBER;
VARIABLE var_job VARCHAR2(9);
-- 실행
EXECUTE sel_empno(7788, :var_ename, :var_sal, :var_job);
-- 출력
PRINT var_ename;
PRINT var_sal;
PRINT var_job;

-- 저장함수 실습
@C:\devenv\oracle실습\저장프로시저\proc04.SQL
-- return 받을 변수 선언
VARIABLE var_res NUMBER;
-- 실행
EXECUTE :var_res := cal_bonus(7788);
-- 출력
print var_res;

-- cursor 실습 (부서 테이블의 모든 내용 조회)
@C:\devenv\oracle실습\저장프로시저\proc05.SQL
-- 실행
EXECUTE cursor_sample01;

-- cursor 실습 (for loop)
@C:\devenv\oracle실습\저장프로시저\proc06.SQL
EXECUTE cursor_sample02;

set serveroutput on

