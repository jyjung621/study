-- 서브쿼리 기본
-- 1. 단일행 서브쿼리 : 서브쿼리 결과가 하나의 행(값)만 있는 경우를 말함
--                   연산자 =, >, <, >=, <= 등을 사용할 수 있음

-- SCOTT이 속한 부서명을 출력
SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO
                                       FROM EMP
                                       WHERE ENAME='SCOTT');
                                
-- 1. SCOTT과 같은 부서에서 근무하는 사원의 이름과 부서번호를 출력하시오
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO
                                              FROM EMP
                                              WHERE ENAME='SCOTT');
-- 2. SCOTT과 동일한 직급을 가진 사원을 출력하시오
SELECT * FROM EMP WHERE JOB = (SELECT JOB
                               FROM EMP
                               WHERE ENAME='SCOTT');
                               
-- 3. SCOTT의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하시오
SELECT ENAME, SAL FROM EMP
WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME='SCOTT');

-- 4. DALLAS에서 근무하는 사원의 이름, 부서번호를 출력하시오
SELECT ENAME, DEPTNO FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

-- 5. SALES 부서에서 근무하는 모든 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

-- 6. 직속상관이 KING인 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');

-- 단일행 서브쿼리에서 그룹함수인 AVG 사용
-- 회사 전체 직원 평균 급여보다 높은 사람들의 이름, 급여는?
SELECT ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP); 

-- 급여가 3000이상을 갖는 부서들의 직원이름, 급여, 부서번호 출력
-- 다중행 서브쿼리 연산자 IN
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE DEPTNO IN(SELECT DISTINCT DEPTNO FROM EMP WHERE SAL>=3000);

SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE DEPTNO =(SELECT DISTINCT DEPTNO FROM EMP WHERE SAL>=3000);
-- WHERE DEPTNO = 10 OR DEPTNO = 20

-- 부서별로 가장 급여를 많이 받는 사원번호, 이름, 급여, 부서번호 출력(IN 연산자이용)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- 직급이 MANAGER인 사람이 속한 부서의 부서번호와 부서명, 지역을 출력
SELECT DEPTNO, DNAME, LOC FROM DEPT
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');

-- SAL > ALL : SAL값이 ALL 안에 포함된 어떤 값보다 큰 경우
SELECT ENAME, SAL FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);
-- ALL 대신에 MAX 사용해도 결과는 동일
SELECT ENAME, SAL FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

-- 영업사원들 보다 급여를 많이 받는 사원들의 이름과 급여, 직급(담당업무)를 출력
-- 단, 영업사원 제외
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
-- ALL 대신에 MAX 사용해도 결과는 동일
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');

-- ANY : 최소값인 MIN과 같음
SELECT ENAME, SAL FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);
-- WHERE SAL > 1600 OR SAL > 1250 OR SAL > 950

-- ANY 대신에 MIN 사용해도 결과는 동일
SELECT ENAME, SAL FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 영업사원들의 최소급여보다 많이 받는 직원들의 이름, 급여, 직급 출력하시오
-- 단, 영업사원은 출력제외
SELECT ENAME, SAL, JOB FROM EMP
WHERE (SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN'))
AND (JOB <> 'SALESMAN');