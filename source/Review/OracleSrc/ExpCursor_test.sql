CREATE OR REPLACE PROCEDURE expcursor_test
(
    v_deptno IN dept.deptno%TYPE
)
IS
    CURSOR dept_avg IS
        SELECT b.dname, COUNT(A.empno) cnt, round(AVG(A.sal),3) salary
        FROM emp A, dept b
        WHERE A.deptno = b.deptno AND b.deptno = v_deptno
        GROUP BY b.dname;
    
    -- 커서를 패치하기 위한 변수 선언
    v_dname dept.dname%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
BEGIN
    -- 커서의 오픈
    OPEN dept_avg;
    
    -- 커서의 패치
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;
    
    dbms_output.put_line('부서명 : ' || v_dname);
    dbms_output.put_line('사원수 : ' || emp_cnt);
    dbms_output.put_line('평균급여 : ' || sal_avg);
    
    -- 커서의 클로즈
    CLOSE dept_avg;
    
    EXCEPTION 
        WHEN OTHERS THEN
            dbms_output.put_line(SQLERRM || '에러발생');

END;
/


-- 실행 방법
SET SERVEROUTPUT ON;
EXECUTE expcursor_test(30);