-- dual :  table이름, oracle에서 제공하는 dummy table
desc dual;

SELECT * FROM dual;

SELECT -10, ABS(-10) FROM dual;
-- floor : 소수점 이하 버리기
SELECT 34.5678, floor(34.5678) FROM dual;

-- round : 소수점 반올림
SELECT 34.5678, round(34.5678) FROM dual;
SELECT 34.5678, round(34.5678, 2) FROM dual;
SELECT 34.5678, round(34.5678, -1) FROM dual;
-- TRUNC : 소수점 특정자리수 이하 버리기
SELECT TRUNC(34.5678, 2), TRUNC(34.5678, -1), TRUNC(34.5678) FROM dual;
-- MOD : 나머지 구하기
SELECT MOD(27, 2), MOD(27, 5), MOD(27, 7) FROM dual;

-- emp table에서 사번이 홀수인 직원만 출력
SELECT * from emp where mod(empno, 2)=1;

SELECT 'Welcome to Oracle', UPPER('Welcome to Oracle') FROM dual;
SELECT 'Welcome to Oracle', LOWER('Welcome to Oracle') FROM dual;

SELECT empno, ename, JOB FROM emp WHERE JOB='manager';
SELECT empno, ename, JOB FROM emp WHERE JOB=UPPER('manager');
SELECT empno, ename, JOB FROM emp WHERE LOWER(JOB)='manager';

-- LENGTH : 영문(1바이트), 한글(3바이트)에 무관하게 글자 수를 나타냄
SELECT LENGTH('Oracle'), LENGTH('오라클') FROM dual;
-- lengthb : 바이트수로 알려줌
SELECT lengthb('Oracle'), lengthb('오라클') FROM dual;

-- oracle에서는 index가 1부터 시작
SELECT substr('Welcome to Oracle', 4, 3) FROM dual;
SELECT substr('Welcome to Oracle', -4, 3) FROM dual;
SELECT substr(hiredate, 1, 2) 년도, substr(hiredate, 4, 2) 달 FROM emp;

SELECT * FROM emp WHERE substr(hiredate,4,2)='09';

SELECT * FROM emp WHERE substr(hiredate,1,2)='87';
SELECT * FROM emp WHERE substr(ename,-1,1)='E';

SELECT instr('WELCOME TO ORACLE', 'O') FROM dual;
SELECT instr('WELCOME TO ORACLE', 'O', 6, 2) FROM dual;

select * from emp WHERE instr(ename, 'R')=3;
SELECT * from emp WHERE ename like('___R%');

SELECT lpad('Oracle', 20, '#') FROM dual;
SELECT rpad('Oracle', 20, '#') FROM dual;

SELECT LTRIM('     Oracle          ') FROM dual;
SELECT RTRIM('     Oracle          ') FROM dual;
SELECT TRIM('     Oracle          ') FROM dual;

SELECT TRIM('a' FROM 'aaaaOracleaaaaaaaaaaaa') FROM dual;

SELECT sysdate FROM dual;

SELECT sysdate-1 어제, sysdate 오늘, sysdate+1 내일 FROM dual;

SELECT round(sysdate-hiredate,4) 근무일수 FROM emp;

SELECT hiredate, round(hiredate, 'MONTH') FROM emp;

SELECT hiredate, TRUNC(hiredate, 'MONTH') FROM emp;

SELECT ename, sysdate, hiredate, months_between(sysdate, hiredate) FROM emp;
SELECT ename, sysdate, hiredate, TRUNC(months_between(sysdate, hiredate)) FROM emp;

SELECT ename, hiredate, TRUNC(add_months(hiredate,6)) FROM emp;

SELECT sysdate, next_day(sysdate, '수요일') FROM dual;

SELECT hiredate,'  ', last_day(hiredate) FROM emp;

SELECT sysdate, to_char(sysdate, 'yyyy-mm-dd') FROM dual;

SELECT hiredate, to_char(hiredate, 'yyyy/mm/dd day')FROM emp;

SELECT hiredate, to_char(hiredate, 'yy/mon/dd dy') FROM emp;

select to_char(sysdate, 'yyyy/mm/dd, hh24:mi:ss') from dual;

SELECT to_char(1230000) FROM dual;

select ename, sal, to_char(sal, 'l999,999') from emp;

SELECT to_char(123456, '000000000'), to_char(123456, '999,999,999') FROM dual;

SELECT ename, hiredate FROM emp WHERE hiredate=TO_DATE(19810220, 'yyyymmdd');

SELECT to_number('20,000', '99,999') - to_number('10,000', '99,999') FROM dual;

select ename, sal, comm, sal*12+comm, nvl(comm, 0), sal*12+nvl(comm, 0) from emp order by job;

SELECT * FROM emp;
select empno, ename, mgr, nvl(mgr, 'CEO') from emp; 

SELECT ename, deptno, 
                decode(deptno, 10, 'accounting',
                               20, 'research',
                               30, 'sales',
                               40, 'operations')
                AS dname
from emp;
                