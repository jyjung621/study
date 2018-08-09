CREATE OR REPLACE PROCEDURE sel_empno
(
    vempno IN emp.empno%TYPE,
    vename OUT emp.ename%TYPE,
    vsal OUT emp.sal%TYPE,
    vjob OUT emp.JOB%TYPE
)
IS
BEGIN
    SELECT ename, sal, JOB INTO vename, vsal, vjob
    FROM emp
    WHERE empno=vempno;
END;
/
    