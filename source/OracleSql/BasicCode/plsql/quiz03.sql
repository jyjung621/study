SET SERVEROUTPUT ON
DECLARE
    vdept dept%rowtype;
BEGIN
    dbms_output.put_line('부서번호 / 부서명 / 지역명');
    dbms_output.put_line('---------------------------------');
    
    --변수 cnt는 1부터 1씩 증가하다가 4에 도달하면 반복문에서 벗어남
    FOR cnt IN 1..4 LOOP
        SELECT * INTO vdept FROM dept WHERE deptno = 10*cnt;
        dbms_output.put_line(vdept.deptno||' / '||vdept.dname||' / '||vdept.loc);
    END LOOP;
END;
/