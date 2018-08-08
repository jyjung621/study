SET SERVEROUTPUT ON
DECLARE
-- %type 속성으로 컬럼 단위 레퍼런스 변수 선언
    vempno emp.empno%TYPE;
    vename emp.ename%TYPE;
BEGIN
    dbms_output.put_line('사번  /  이름');
    dbms_output.put_line('---------------------');
    
    SELECT empno, ename INTO vempno, vename
    FROM emp 
    WHERE ename='SCOTT';
    
    -- 레퍼런스 변수에 저장된 값을 출력
    dbms_output.put_line(vempno || ' / ' || vename);
END;
/