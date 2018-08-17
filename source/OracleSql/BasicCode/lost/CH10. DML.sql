-- 2개 이상의 COLUMN UPDATE
SELECT * FROM EMP01 WHERE ENAME='SCOTT';
UPDATE EMP01
SET DEPTNO=30, JOB='MANAGER'
WHERE ENAME='SCOTT';

UPDATE EMP01
SET HIREDATE = SYSDATE, SAL=50, COMM=4000
WHERE ENAME='SCOTT';

SELECT * FROM DEPT01;
UPDATE DEPT01
SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;

CREATE TABLE SAM02
AS
SELECT ENAME, SAL, HIREDATE, DEPTNO FROM EMP01;

DESC SAM02;
SELECT * FROM SAM02;

UPDATE SAM02
SET SAL = SAL + 1000
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

SELECT * FROM DEPT01;
UPDATE DEPT01
SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT WHERE DEPTNO=40)
WHERE DEPTNO=20;
-- 이름이 KING인 사람의 SAL과 HIREDATE 복사하라
SELECT * FROM SAM02;
UPDATE SAM02
SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM SAM02 WHERE ENAME='KING');

DELETE FROM DEPT01;
ROLLBACK;
SELECT * FROM DEPT01;

DELETE FROM DEPT01 WHERE DEPTNO=60;
-- LOC가 NULL인 컬럼 삭제
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE LOC IS NULL;

SELECT * FROM emp01;
DELETE FROM emp01
where deptno=(select deptno from dept where dname='SALES');