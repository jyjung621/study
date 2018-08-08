--4. [사원 데이터베이스] 다음은 scott 데이터베이스에 저장된 사원 데이터베이스다.
-- 다음 질문에 대해 SQL 문을 작성하시오(부록 B의 scott 계정을 준비하였다면 예제 데이터베이스가 생성되어 있다).

--Dept는 부서 테이블로 deptno(부서번호), dname(부서이름), loc(위치, location)으로 구성되
--어 있다. Emp는 사원 테이블로 empno(사원번호), ename(사원이름), job(업무), MGR(팀장
--번호, manager), hiredate(고용날짜), sal(급여, salary), comm(커미션금액, commission),
--deptno(부서번호)로 구성되어 있다. 밑줄 친 속성은 기본키이고 Emp의 deptno는 Dept의
--deptno를 참조하는 외래키이다.
--
--Dept(deptno NUMBER(2), dname VARCHAR2(14), loc VARCHAR2(13))
--Emp(empno NUMBER(4), ename VARCHAR2(10), job VARCHAR2(9), mgr NUMBER(4),
--hiredate DATE, sal NUMBER(7,2), comm NUMBER(7,2), deptno NUMBER(2))
--
SELECT * FROM EMP;
SELECT * FROM DEPT;

--(1) 사원의 이름과 직위를 출력하시오.
-- 단, 사원의 이름은 ‘사원이름’, 직위는 ‘사원직위’머리글이 나오도록 출력한다.
SELECT ENAME 사원이름, JOB 직위 FROM EMP;
--(2) 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하시오.
SELECT DEPTNO, ENAME, SAL FROM EMP
WHERE DEPTNO=30;
--(3) 사원 번호와 이름, 현재 급여와 10% 인상된 급여(열 이름은 ‘인상된 급여’)를 출력하시오.
-- 단, 사원 번호순으로 출력한다. 증가된 급여분에 대한 열 이름은 ‘증가액’으로 한다.
SELECT EMPNO, ENAME, SAL 현재급여, SAL*1.1 인상된급여, SAL*0.1 증가액
FROM EMP ORDER BY EMPNO;
--(4) ‘S’로 시작하는 모든 사원과 부서번호를 출력하시오.
SELECT DEPTNO, ENAME FROM EMP
WHERE ENAME LIKE 'S%';
--(5) 모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하시오.
-- 열 이름은 각각 MAX, MIN, SUM, AVG로 한다. 단, 소수점 이하는 반올림하여 정수로 출력한다.
SELECT MAX(SAL) MAX, MIN(SAL) MIN, SUM(SAL) SUM, ROUND(AVG(SAL), 0) AVG
FROM EMP;
--(6) 업무이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하시오.
-- 열 이름은 각각 ‘업무’와 ‘업무별 사원수’로 한다.
SELECT D.DEPTNO 업무, COUNT(E.EMPNO)
FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO;
--(7) 사원의 최대 급여와 최소 급여의 차액을 출력하시오.
SELECT MAX(SAL)-MIN(SAL) 최대최소차액
FROM EMP;
--(8) 30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력하시오.
SELECT COUNT(EMPNO), SUM(SAL), ROUND(AVG(SAL),2)
FROM EMP
WHERE DEPTNO=30;
--(9) 평균급여가 가장 높은 부서의 번호를 출력하시오.


--(10) 세일즈맨을 제외하고, 각 업무별 사원들의 총 급여가 3000 이상인 각 업무에 대해서
-- 업무명과 각 업무별 평균 급여를 출력하되, 평균급여의 내림차순으로 출력하시오.
SELECT JOB FROM EMP
WHERE SAL >= 3000;

SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING SAL >= 3000;
-- ***************

--(11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하시오.
SELECT COUNT(EMPNO)
FROM EMP
WHERE MGR IS NOT NULL;

--(12) Emp 테이블에서 이름, 급여, 커미션 금액, 총액(sal + comm)을 구하여 총액이 많은
-- 순서대로 출력하시오. 단, 커미션이 NULL인 사람은 제외한다.
SELECT ENAME, SAL, COMM, SAL+COMM 총액
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY (SAL+COMM) DESC;

--(13) 각 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수
--를 출력하시오.


--(14) 사원이 한 명도 없는 부서의 이름을 출력하시오.



--(15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오.
--
--(16) 사원번호가 7400 이상 7600 이하인 사원의 이름을 출력하시오.
SELECT ENAME FROM EMP
WHERE EMPNO BETWEEN 7400 AND 7600;
--(17) 사원의 이름과 사원의 부서를 출력하시오.
SELECT E.ENAME, D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = (SELECT DEPTNO FROM DEPT);
--(18) 사원의 이름과 팀장의 이름을 출력하시오.
--
--(19) 사원 SCOTT보다 급여를 많이 받는 사람의 이름을 출력하시오.
--
--(20) 사원 SCOTT가 일하는 부서번호 혹은 DALLAS에 있는 부서번호를 출력하시오.
