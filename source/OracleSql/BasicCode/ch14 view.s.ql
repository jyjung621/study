-- view 실습
CREATE TABLE dept_copy AS SELECT * FROM dept;
CREATE TABLE emp_copy AS SELECT * FROM emp;

SELECT * FROM dept_copy;
SELECT * FROM emp_copy;

SELECT empno, ename, deptno FROM emp_copy WHERE deptno=30;
-- view 생성
CREATE VIEW emp_view30
AS
SELECT empno, ename, deptno FROM emp_copy WHERE deptno=30;
-- 위의 create view 실행시, 권한불충분 에러 발생
-- system(admin)에서 scott에게 view 생성 권한을 부여해주어야 함
-- 1. system(hanbit)으로 이동
-- 2. grant로 권한 부여
GRANT CREATE VIEW TO scott;
-- 3. scott으로 돌아와서 view 생성해보기
CREATE VIEW emp_view30
AS
SELECT empno, ename, deptno FROM emp_copy WHERE deptno=30;

SELECT * FROM emp_view30;
desc emp_view30;

-- 20번 부서에 소속된 사원들의 사번, 이름, 부서번호, 상관번호를 출력하는 뷰 정의
CREATE VIEW emp_view20
AS
SELECT empno, ename, deptno, mgr FROM emp_copy WHERE deptno=20;

SELECT * FROM emp_view20;

-- view에 대한 data dictionary : user_views
DESC user_views;
select view_name, text from user_views;

-- view에 insert 실행
-- 문제점 : insert 하게될경우, 원본 table의 속성들 중 
--         view의 속성들만 값이 들어가고 나머지 속성들에는 null로 채워지게됨
INSERT INTO emp_view30 VALUES (111, 'AAAA', 30);
SELECT * FROM emp_view30;
SELECT * FROM emp_copy;

-- 단순 뷰의 컬럼에 별칭(view의 컬럼명을 alias로 지정) 부여하기
DESC emp_view30;
CREATE OR REPLACE VIEW emp_view(사원번호, 사원명, 급여, 부서번호)
AS
select empno, ename, sal, deptno from emp_copy;

SELECT * FROM emp_view;

SELECT * FROM emp_view WHERE 부서번호=30;

-- 복합 view 만들기
CREATE VIEW emp_view_dept
AS
SELECT E.empno, E.ename, E.sal, E.deptno, D.dname, D.loc 
FROM emp E, dept D
WHERE E.deptno = D.deptno
ORDER BY empno DESC;

SELECT * FROM emp_view_dept;
SELECT * FROM emp_view_dept WHERE loc='DALLAS';

-- 각 부서별 최대 급여 & 최소 급여를 출력하는 SAL_VIEW 생성
CREATE VIEW sal_view
AS
SELECT D.dname, max(e.sal) as MAX_SAL, min(e.sal) as MIN_SAL
FROM emp E, dept D
WHERE E.deptno = D.deptno
GROUP BY D.dname
ORDER BY D.dname ASC;

SELECT * FROM sal_view;
SELECT view_name, text FROM user_views;

-- 뷰 삭제하기
DROP VIEW sal_view;

-- view 수정을 위한 [or replace] 옵션 (기존 3속성 -> 5속성)
SELECT * FROM emp_view30;
CREATE OR REPLACE VIEW emp_view30
AS
SELECT empno, ename, sal, comm, deptno
FROM emp_copy
where deptno=30;

SELECT * FROM emp_view30;

-- 위의 view에 컬럼 별칭 추가
SELECT * FROM emp_view20;
CREATE OR REPLACE VIEW emp_view20 (EMP_NO, EMP_NAME, DEPT_NO, MANAGER)
AS
SELECT empno, ename, deptno, mgr
FROM emp_copy
where deptno=20;

SELECT * FROM emp_view20;

-- force 옵션으로 기본 테이블 없이 뷰 생성
create or replace view employees_view
AS
SELECT empno, ename, deptno
FROM employees
WHERE deptno=30;    -- employees가 존재하지 않는다는 에러 발생

create or replace force view employees_view
AS
SELECT empno, ename, deptno
FROM employees
WHERE deptno=30;    -- 컴파일 오류와 함께 뷰 생성됨

select * from employees_view;

-- with check option 사용 실습
select * from emp_view30;

SELECT * FROM emp_view30 WHERE sal>=1200;
update emp_view30 set deptno=20 where sal>=1200;

CREATE OR REPLACE VIEW view_chk20
AS
SELECT empno, ename, sal, comm, deptno
FROM emp_copy
WHERE deptno=20 WITH CHECK OPTION;

update view_chk20 set deptno=30 where sal>=1200;

select * from view_chk20;

-- with read only option 실습
CREATE OR REPLACE VIEW view_read20
AS
SELECT empno, ename, sal, comm, deptno
FROM emp_copy
WHERE deptno=20 WITH READ ONLY;

select * from view_read20;

update view_read20 set deptno=30 where sal>=1200;

-- rownum 실습하기
-- rowid : 해당 행(row)이 하드디스크의 주소를 의미
-- rownum : 행 insert 된 순서(select등 조회시 보여주는 순서)
SELECT ROWID, ROWNUM, empno, ename, hiredate
FROM emp
ORDER BY hiredate;

-- 입사일이 빠른 순서대로 top-5 출력하기
SELECT rownum, empno, ename, hiredate
FROM emp
ORDER BY hiredate;  
-- rownum이 hiredate의 순서와 일치하지 않아 top-5를 구할수 없음
-- 해결책 : view와 rownum을 이용하여 top-5 구하는 것이 가능함
--         view table을 만들면 rownum은 새로 생성됨
CREATE OR REPLACE VIEW view_hire
AS
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate;  

SELECT ROWNUM, empno, ename, hiredate
FROM view_hire;     -- rownum과 hiredate의 순서 일치

SELECT ROWNUM, empno, ename, hiredate
FROM view_hire
where rownum<=5;    -- top-5 구하기

