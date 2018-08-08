-- Transaction : 여러개의 sql문을 한덩어리로 실행 or 취소

-- commit, rollback 실습
drop table dept01;

CREATE TABLE dept01
AS
SELECT * FROM dept;

SELECT * FROM dept01;

DELETE FROM dept01;

-- rollback : transaction에서 insert, update, delete로 처리된 것을
--              처리되기 이전 상태로 환원할 때 사용
ROLLBACK;
SELECT * FROM dept01;

DELETE FROM dept01 WHERE deptno=20;
ROLLBACK;
SELECT * FROM dept01;

-- commit : update, delete, insert sql이 영원히 DB에 반영하게 하는 것
--          나중에 rollback을 하더라도 이전상태로 복귀 불가
commit;
ROLLBACK;
SELECT * FROM dept01;

-- 자동 커밋
DROP TABLE dept03;
CREATE TABLE dept03 AS SELECT * FROM dept;
select * from dept03;

DELETE FROM dept03 WHERE deptno=20;

-- truncate : DDL로, 테이블의 스키마는 유지하되, 모든 행 삭제
TRUNCATE TABLE deptppp;
-- DDL을 실행하면 DDL실행 중 에러가 발생하더라도 rollback 불가함
-- 왜냐하면 DDL실행하기 전에 commit을 내부적으로 실행시킴
ROLLBACK;

SELECT * FROM dept03;

-- savepoint 실습
DROP TABLE dept01;
CREATE TABLE dept01 AS SELECT * FROM dept;
SELECT * FROM dept01;

DELETE FROM dept01 WHERE deptno=40;
COMMIT;
rollback;

DELETE FROM dept01 WHERE deptno=30;
SELECT * FROM dept01;
-- c1이라는 savepoint를 save함
savepoint c1;

DELETE FROM dept01 WHERE deptno=20;
SELECT * FROM dept01;

SAVEPOINT c2;

DELETE FROM dept01 WHERE deptno=10;
SELECT * FROM dept01;

ROLLBACK TO c2;
ROLLBACK TO c1;
SELECT * FROM dept01;

ROLLBACK;
SELECT * FROM dept01;

