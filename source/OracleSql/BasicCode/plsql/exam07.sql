SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;
    vdname VARCHAR2(14);
BEGIN
    dbms_output.put_line('사번  / 이름   / 부서명');
    dbms_output.put_line('----------------------------');
    
    SELECT * INTO vemp FROM emp WHERE ename='SCOTT';
    
    IF (vemp.deptno=10) THEN
        vdname := 'ACCOUNTING';
    ELSIF (vemp.deptno=20) THEN
        vdname := 'RESEARCH';
    ELSIF (vemp.deptno=30) THEN
        vdname := 'SALES';
    ELSIF (vemp.deptno=40) THEN
        vdname := 'OPERATIONS';
    END IF;
    
    dbms_output.put_line(vemp.empno||' / '||vemp.ename||' / '||vdname);
END;
/