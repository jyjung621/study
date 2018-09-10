CREATE OR REPLACE PROCEDURE Errcode_Exception
(
    v_deptno IN emp.deptno%TYPE
)
IS
v_emp emp%ROWTYPE;
BEGIN
dbms_output.ENABLE;
-- ERROR발생 for문을 돌려야됨
SELECT * 
INTO v_emp
FROM emp
WHERE deptno = v_deptno;

DBMS_OUTPUT.PUT_LINE('사번 : ' || v_emp.empno);
DBMS_OUTPUT.PUT_LINE('이름 : ' || v_emp.ename);

EXCEPTION

when others then
DBMS_OUTPUT.PUT_LINE('ERR CODE: ' || TO_CHAR(SQLCODE));
DBMS_OUTPUT.PUT_LINE('ERR MESSAGE : ' || SQLERRM);
end;
/

-- 실행
SET SERVEROUTPUT ON;
execute errcode_exception(30);