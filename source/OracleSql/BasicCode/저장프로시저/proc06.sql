CREATE OR REPLACE PROCEDURE cursor_sample02
IS
    vdept dept%rowtype;
    CURSOR c1 IS SELECT * FROM dept;
BEGIN
    dbms_output.put_line('부서번호 / 부서명 / 지역명');
    dbms_output.put_line('------------------------------');
    
    FOR vdept IN c1 LOOP
        EXIT WHEN c1%notfound;
        dbms_output.put_line(vdept.deptno||' '||vdept.dname||' '||vdept.loc);
    END LOOP;
END;
/