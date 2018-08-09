CREATE OR REPLACE PROCEDURE del_ename
    (vename emp01.ename%TYPE)   -- 매개변수
IS
BEGIN
    DELETE FROM emp01 WHERE ename=vename;
END;
/