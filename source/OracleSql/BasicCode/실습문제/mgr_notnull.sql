CREATE OR REPLACE FUNCTION mgr_notnull
RETURN NUMBER
IS
    cnt NUMBER(2,0);
BEGIN
    SELECT COUNT(empno) into cnt FROM emp
    WHERE mgr IS NOT NULL;
    
    return cnt;
END;
/


--SELECT COUNT(empno) FROM emp
--WHERE mgr IS NOT NULL;
