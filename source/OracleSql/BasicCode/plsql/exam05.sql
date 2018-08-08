SET SERVEROUTPUT ON
DECLARE
    vempno  NUMBER(4);
    vename  VARCHAR2(20);
    vdeptno emp.deptno%TYPE;
    vdname  VARCHAR2(20):=NULL;
BEGIN
    SELECT empno, ename, deptno INTO vempno, vename, vdeptno
    FROM emp
    WHERE empno=7788;
    
    IF(vdeptno=10) THEN
        vdname := 'ACCOUNTING';
    END IF;
    IF(vdeptno=20) THEN
        vdname := 'RESEARCH';
    END IF;
    IF(vdeptno=30) THEN
        vdname := 'SALES';
    END IF;
    IF(vdeptno=40) THEN
        vdname := 'OPERATIONS';
    END IF;
    
    dbms_output.put_line('사번    이름      부서명');
    dbms_output.put_line(vempno || '    ' || vename || '    ' || vdname);
    
END;
/