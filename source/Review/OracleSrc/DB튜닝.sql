---------------------------------------------------------
-- DB 튜닝
--  ... 튜닝 관련 공부도... 필요할듯...
---------------------------------------------------------

-- 최적의 join방식으로 변경
ALTER SESSION SET optimizer_mode=RULE;
ALTER SESSION SET optimizer_mode=choose;


-- scott 에서 실행
SELECT E.empno, E.ename, E.JOB, D.deptno, D.dname
FROM emp E, dept D
WHERE E.deptno = D. deptno;



