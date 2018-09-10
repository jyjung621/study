CREATE OR REPLACE PROCEDURE table_test
    (
        v_deptno IN emp.deptno%TYPE
    )
IS
    -- 각 컬럼에서 사용할 테이블 선언
    TYPE empno_table IS TABLE OF emp.empno%TYPE
    INDEX BY BINARY_INTEGER;
    TYPE ename_table IS TABLE OF emp.ename%TYPE
    INDEX BY BINARY_INTEGER;
    TYPE sal_table IS TABLE OF emp.sal%TYPE
    INDEX BY BINARY_INTEGER;
    
    -- 테이블타입으로 변수를 선언해서 사용
    empno_tab empno_table;
    ename_tab ename_table;
    sal_tab sal_table;
    I BINARY_INTEGER := 0;
BEGIN
    dbms_output.enable;
    
    FOR emp_list IN(SELECT empno, ename, sal
                    FROM emp WHERE deptno = v_deptno) LOOP
    /* emp_list는 자동선언되는 binary_integer형 변수로 1씩 증가함
        emp_list대신 다른 문자열 사용가능 */
        
        i := i + 1;
        
        -- 테이블 변수에 검색된 결과를 넣음
        empno_tab(I) := emp_list.empno;
        ename_tab(I) := emp_list.ename;
        sal_tab(I) := emp_list.sal;
    end loop;
    
    -- 1부터 i까지 for문 실행
    FOR cnt IN 1..I LOOP
        -- table변수에 넣은 값 출력
        dbms_output.put_line('사원번호 : ' || empno_tab(cnt));
        dbms_output.put_line('사원이름 : ' || ename_tab(cnt));
        dbms_output.put_line('사원급여 : ' || sal_tab(cnt));
    END LOOP;
END;
/


-- 실행 방법
SET SERVEROUTPUT ON;
execute table_test(20);



        
    