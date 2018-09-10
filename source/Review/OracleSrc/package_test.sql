CREATE OR REPLACE PACKAGE emp_info AS
    PROCEDURE all_emp_info; -- 모든 사원의 사원 정보
    PROCEDURE all_sal_info; -- 모든 사원의 급여 정보
    -- 특정 부서의 사원 정보
    PROCEDURE dept_emp_info (v_deptno IN NUMBER) ;
    -- 특정 부서의 급여 정보
    PROCEDURE dept_sal_info (v_deptno IN NUMBER) ;
END emp_info;
/


-----------------------------------------------------------

CREATE OR REPLACE PACKAGE BODY emp_info AS
    -- 모든 사원의 사원 정보
    PROCEDURE all_emp_info
    IS
        CURSOR emp_cursor IS
            SELECT empno, ename, to_char(hiredate, 'RRRR/MM/DD') hiredate
            FROM emp
            ORDER BY hiredate;
    BEGIN
        FOR aa IN emp_cursor LOOP
            DBMS_OUTPUT.PUT_LINE('사번 : ' || aa.empno);
            DBMS_OUTPUT.PUT_LINE('성명 : ' || aa.ename);
            dbms_output.put_line('입사일 : ' || aa.hiredate);
        END LOOP;
        
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line(sqlerrm||'에러 발생 ');
    END all_emp_info;

    -- 모든 사원의 급여 정보
    PROCEDURE all_sal_info
    IS
        CURSOR emp_cursor IS
            SELECT round(avg(sal),3) avg_sal, max(sal) max_sal, min(sal) min_sal
            FROM emp;
    BEGIN
        FOR aa IN emp_cursor LOOP
            DBMS_OUTPUT.PUT_LINE('전체급여평균 : ' || aa.avg_sal);
            DBMS_OUTPUT.PUT_LINE('최대급여금액 : ' || aa.max_sal);
            DBMS_OUTPUT.PUT_LINE('최소급여금액 : ' || aa.min_sal);
        END LOOP;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE(SQLERRM||'에러 발생 ');
    END all_sal_info;

    --특정 부서의 사원 정보
    PROCEDURE dept_emp_info (v_deptno IN NUMBER)
    IS
        CURSOR emp_cursor IS
            SELECT empno, ename, to_char(hiredate, 'RRRR/MM/DD') hiredate
            FROM emp
            WHERE deptno = v_deptno
            ORDER BY hiredate;
    BEGIN
        FOR aa IN emp_cursor LOOP
            DBMS_OUTPUT.PUT_LINE('사번 : ' || aa.empno);
            DBMS_OUTPUT.PUT_LINE('성명 : ' || aa.ename);
            dbms_output.put_line('입사일 : ' || aa.hiredate);
        END LOOP;
    
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE(SQLERRM||'에러 발생 ');
    END dept_emp_info;

    --특정 부서의 급여 정보
    PROCEDURE dept_sal_info (v_deptno IN NUMBER)
    IS
        CURSOR emp_cursor IS
        SELECT round(avg(sal),3) avg_sal, max(sal) max_sal, min(sal) min_sal
        FROM emp
        WHERE deptno = v_deptno;
    BEGIN
        FOR aa IN emp_cursor LOOP
            DBMS_OUTPUT.PUT_LINE('전체급여평균 : ' || aa.avg_sal);
            DBMS_OUTPUT.PUT_LINE('최대급여금액 : ' || aa.max_sal);
            DBMS_OUTPUT.PUT_LINE('최소급여금액 : ' || aa.min_sal);
        END LOOP;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE(SQLERRM||'에러 발생 ');
    END dept_sal_info;

END emp_info;
/


---------------------------------------


EXEC emp_info.all_emp_info;
EXEC emp_info.all_sal_info;
EXEC emp_info.dept_emp_info(10);
EXEC emp_info.dept_sal_info(10);
