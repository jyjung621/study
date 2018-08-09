CREATE OR REPLACE FUNCTION cal_bonus
(
    vempno IN emp.empno%TYPE
)
RETURN NUMBER
IS
    vsal NUMBER(7,2);
BEGIN
    SELECT sal INTO vsal from emp where empno = vempno;   
    return (vsal * 200);
END;
/