-- 인덱스 사용하기 전과 사용후의 속도 비교
drop table emp01;

create table emp01
AS
select * from emp;

SELECT * FROM emp01;

-- 1. emp, emp01에 인덱스 설정여부 확인
-- primary key는 index가 설정되어 있음
-- (즉, oracle 내부적으로 primary key에 대한 B-tree 생성)
SELECT table_name, index_name, column_name
FROM user_ind_columns
WHERE table_name IN ('EMP', 'EMP01');   

SELECT * FROM emp01;
INSERT INTO emp01 SELECT * FROM emp01;

INSERT INTO emp01(empno, ename)
values (1111,'SYJ');

SELECT DISTINCT empno, ename
FROM emp01
where ename='SYJ';

-- 인덱스 설정 (index create)
-- create index를 특정 테이블의 컬럼에 create 한다는 의미는
-- B-tree를 내부적으로 만든다는 의미
CREATE INDEX idx_emp01_ename
ON emp01(ename);

-- index 삭제하기
DROP INDEX idx_emp01_ename;

-- 인덱스 재성성(b-tree 인덱스를 재생성)
ALTER INDEX idx_emp01_ename REBUILD;

-- 인덱스 종류 (고유 인덱스, 비고유 인덱스)
DROP TABLE dept01;
CREATE TABLE dept01
AS
SELECT * FROM dept WHERE 1=0;

INSERT INTO dept01 VALUES(10, '인사과', '서울');
INSERT INTO dept01 VALUES(20, '총무과', '대전');
INSERT INTO dept01 VALUES(30, '교육팀', '대전');

-- 고유 인덱스 생성
-- (중복값을 가지지 않은 deptno에 대해서 고유 인덱스 생성가능)
CREATE UNIQUE INDEX idx_dept01_deptno
ON dept01(deptno);
-- loc은 중복된 값을 갖고 있어 unique index 설정 불가
CREATE UNIQUE INDEX idx_dept01_loc
ON dept01(loc);
-- loc은 unique를 빼고 (중복 인덱스)index 생성은 가능
CREATE INDEX idx_dept01_loc
ON dept01(loc);

-- 결합 인덱스 생성 (두개 이상의 컬럼에 대하여 인덱스 생성)
-- deptno, dname에 대하여 결합인덱스 생성
CREATE INDEX idx_dept01_com
ON dept01(deptno, dname);

-- 함수 기반 인덱스 정의하기
CREATE INDEX idx_emp01_annsal
ON emp01(sal*12);

SELECT index_name, column_name
FROM user_ind_columns
WHERE table_name='EMP01';


