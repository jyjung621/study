-- 대전(영희)가 SCOTT 직원을 삭제
DELETE FROM emp01 WHERE ename='SCOTT';
select * from emp01;

-- 서울본사에서 SCOTT에 대하여 update를 하는 중
-- 무한루프상태(deadlock)에 있어서, 
-- deadlock을 풀기 위하여 rollback을 실행해야만 함
rollback;