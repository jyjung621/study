CREATE OR REPLACE PROCEDURE dept_search
(
    p_empno IN emp.empno%TYPE
)
IS
    v_deptno emp.deptno%TYPE;
BEGIN
    dbms_output.enable;
    
    SELECT deptno
    INTO v_deptno 
    FROM emp
    WHERE empno = p_empno;
    
    IF v_deptno = 10 THEN
        dbms_output.put_line('ACCOUNTING 부서 사원입니다.');
    ELSIF v_deptno = 20 THEN
        dbms_output.put_line('RESEARCH 부서 사원입니다.');
    ELSIF v_deptno = 30 THEN
        dbms_output.put_line('SALES 부서 사원입니다.');
    ELSIF v_deptno = 40 THEN
        dbms_output.put_line('OPERATIONGS 부서 사원입니다.');
    ELSE
        dbms_output.put_line('부서가 이상해요...');
    END IF;
    
    EXCEPTION
        WHEN no_data_found THEN
            dbms_output.put_line('부서가 없네요...');

END;
/

-- 실행 방법
SET SERVEROUTPUT ON;
EXECUTE dept_search(1234);


    