CREATE OR REPLACE FUNCTION func_sal
    (
        v_empno in number
    )
    RETURN NUMBER
IS
    vsal emp.sal%TYPE;
BEGIN
    UPDATE emp SET sal=sal*1.1
    WHERE empno=v_empno;
    COMMIT;
    
    SELECT sal 
    INTO vsal
    FROM emp
    WHERE empno=v_empno;
    
    RETURN vsal;
END;
/