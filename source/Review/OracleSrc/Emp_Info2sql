CREATE OR REPLACE PROCEDURE emp_info2
(
    p_empno IN emp.empno%TYPE,
    p_ename OUT emp.ename%TYPE,
    p_sal OUT emp.sal%TYPE
)
IS
-- %TYPE 데이터형 변수 선언 
    v_empno emp.empno%TYPE;
BEGIN
    dbms_output.ENABLE;
    -- %type 데이터형 변수 사용
    SELECT empno, ename, sal
    INTO v_empno, p_ename, p_sal
    FROM emp
    WHERE empno = p_empno;
    
    -- 결과갑 출력
    dbms_output.put_line('사원번호 : ' || v_empno || chr(10) || chr(13) || '줄바뀜');
    dbms_output.put_line('사원이름 : ' || p_ename);
    dbms_output.put_line('사원급여 : ' || p_sal);    
END;
/