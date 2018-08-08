SELECT * FROM emp;
-- where 조건문은 관계연산자의 selection과 동일함
SELECT * FROM emp WHERE deptno=10;

-- select의 연산순위 where조건을 통해 selection하여 
-- 해당 row들을 가져오고, 두번째로 특정 속성을 가져오는 projection을 수행
SELECT empno, ename, job FROM emp WHERE deptno=10;

SELECT empno, ename, sal FROM emp WHERE sal <= 1500;

SELECT empno, ename, sal from emp WHERE ename='FORD';
-- Ford로 검색하면 결과가 안나옴, 이유는 데이터가 ename이
-- FORD로 데이터가 들어가 있기 때문에... 대소문자 구분함
SELECT empno, ename, sal FROM emp WHERE ename='Ford';

SELECT empno, ename, sal FROM emp WHERE ename='SCOTT';

SELECT * FROM emp WHERE hiredate <= '1982/01/01';

SELECT * FROM emp WHERE deptno=10 AND JOB='MANAGER';

SELECT * FROM emp WHERE deptno=10 OR JOB='MANAGER';

SELECT * FROM emp WHERE NOT deptno=10;
SELECT * FROM emp WHERE deptno <> 10;
SELECT * FROM emp WHERE deptno != 10;

SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;

SELECT * FROM emp WHERE comm=300 OR comm=500 OR comm=1400;

SELECT empno, sal FROM emp WHERE empno=7521 or empno=7654 or empno=7844;

SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE sal<2000 OR sal>3000;

SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE hiredate BETWEEN '1987/01/01' AND '1987/12/31';

SELECT * FROM emp WHERE comm IN(300, 500, 1400);

SELECT empno, sal FROM emp WHERE empno IN(7521, 7654, 7844);

-- NOT IN은 NULL값을 갖고 있는 행은 제외함
SELECT * FROM emp WHERE comm NOT IN(300,500,1400);

SELECT empno, ename FROM emp WHERE empno!=7521 AND empno!=7654 AND empno!=7844;

select empno, ename from emp WHERE empno not in(7521,7654,7844);

SELECT * FROM emp WHERE ename like 'F%';

-- %의 의미 : 글자가 0개부터 ~ 문자열 끝
SELECT * FROM emp WHERE ename LIKE 'J%';

SELECT * FROM emp WHERE ename LIKE '%A%';
SELECT * FROM emp WHERE ename LIKE '%N';

SELECT empno, ename FROM emp WHERE ename LIKE 'K%';
SELECT empno, ename FROM emp WHERE ename LIKE '%K%';
SELECT empno, ename from emp WHERE ename like '%K';

-- _의 의미 : 글자 1개를 의미, 어떤 문자가 나와도 됨
SELECT * FROM emp WHERE ename LIKE '_A%';
SELECT * FROM emp WHERE ename LIKE '__A%';

SELECT * FROM emp WHERE ename NOT LIKE '%A%';

-- comm=null 로 검색했을 때, 결과값이 없음
-- 이유는 null이 ?, 무한대 값이기 때문에 = 연산자 사용 불가
SELECT * FROM emp WHERE comm=NULL;

SELECT * FROM emp WHERE comm IS NULL;

SELECT * FROM emp WHERE comm IS NOT NULL;

SELECT * FROM emp WHERE mgr IS NULL;

-- ORDER BY : 출력되는 행들을 정렬,
-- ASC(ascending) : 오름차순, DESC(descending) : 내림차순
SELECT * FROM emp ORDER BY sal ASC;
-- default 값 : 오름차순
SELECT * FROM emp ORDER BY sal;
SELECT * FROM emp ORDER BY sal DESC;

SELECT empno, ename, JOB, hiredate FROM emp ORDER BY hiredate ASC;

SELECT empno, ename FROM emp ORDER BY empno ASC;

-- sal 값이 같을 경우, ename 오름차순 정렬
SELECT * FROM emp ORDER BY sal desc, ename asc;

SELECT empno, hiredate, ename, sal FROM emp order by deptno asc, hiredate desc; 



