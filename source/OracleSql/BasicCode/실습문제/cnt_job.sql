--(13) 각 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수
--를 출력하시오.
CREATE OR REPLACE PROCEDURE cnt_job
IS
    vemp emp%rowtype;  
    cnt number;
    CURSOR c1
    IS
    SELECT E.deptno, E.JOB, E.empno
    FROM emp E;
BEGIN
    dbms_output.put_line('부서번호 / 업무명 / 인원수');
    dbms_output.put_line('------------------------------');
    
    FOR vemp IN c1 LOOP
        EXIT WHEN c1%notfound;
        dbms_output.put_line(vemp.deptno||' '||vemp.job||' '||vemp.empno);
    END LOOP;
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
----
--SELECT e.deptno, e.job, COUNT(E.empno)
--FROM emp E
--GROUP BY e.deptno, E.JOB
--ORDER BY e.deptno;
--
