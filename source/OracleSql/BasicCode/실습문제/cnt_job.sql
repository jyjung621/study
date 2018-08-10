CREATE OR REPLACE PROCEDURE cnt_job
(
    vdeptno OUT emp.deptno%TYPE,
    vjob OUT emp.JOB%TYPE,
    vcnt OUT NUMBER
)
IS
BEGIN
    SELECT deptno, JOB, COUNT(empno) as empno_cnt 
    INTO vdeptno, vjob, vcnt
    FROM emp
    GROUP BY deptno, JOB
    ORDER BY deptno;
    
END;
/
    
--SELECT * FROM dept;
--SELECT * FROM emp;
--
--SELECT D.deptno, D.dname, COUNT(E.empno)
--FROM emp E, dept D
--WHERE E.deptno=D.deptno 
--GROUP BY D.deptno, E.JOB
--order by d.deptno;
--
--SELECT e.deptno, e.job, COUNT(E.empno)
--FROM emp E
--GROUP BY e.deptno, E.JOB
--ORDER BY e.deptno;

