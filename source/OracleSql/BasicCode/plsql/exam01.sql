SET SERVEROUTPUT ON
DECLARE 
    vempno NUMBER(4);
    vename VARCHAR2(10);
BEGIN
    vempno := 7788;
    vename := 'SCOTT';
    dbms_output.put_line('사번/    이름');
    dbms_output.put_line('---------------------');
    dbms_output.put_line(vempno || ' / ' || vename);
end;