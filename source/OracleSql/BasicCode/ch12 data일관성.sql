-- 데이터 읽기의 일관성과 락(lock)
DROP TABLE emp01;
CREATE TABLE emp01 AS SELECT * FROM emp;
SELECT * FROM emp01;

-- 서울본사에서 SCOTT 직원에 대하여 update
update emp01 set sal=200 where ename='SCOTT';

-- 대전에서 rollback을 한 후에 deadlock에서 벗어나 update가 성공적 수행됨