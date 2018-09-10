CREATE OR REPLACE PROCEDURE forcursor_test
IS
    CURSOR dept_sum IS
        SELECT b.dname, COUNT(A.empno) cnt, SUM(A.sal) salary
        FROM emp A, dept b
        WHERE A.deptno = b.deptno
        GROUP BY b.dname;
BEGIN
    -- Cursor를 for문에서 실행시킴
    FOR emp_list IN dept_sum LOOP
        dbms_output.put_line('부서명 : ' || emp_list.dname);
        dbms_output.put_line('사원수 : ' || emp_list.cnt);
        dbms_output.put_line('급여합계 : ' || emp_list.salary);
    END LOOP;
    
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(SQLERRM || '에러발생');

END;
/

-- 실행방법
SET SERVEROUTPUT ON;
execute forcursor_test;