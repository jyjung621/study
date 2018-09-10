CREATE OR REPLACE PROCEDURE update_sal
    (
        v_empno IN NUMBER
    )
IS
BEGIN
    UPDATE emp
    SET sal = sal * 1.1
    WHERE empno = v_empno;
    COMMIT;
END update_sal;
/

SELECT * FROM emp;

execute update_sal(7499);