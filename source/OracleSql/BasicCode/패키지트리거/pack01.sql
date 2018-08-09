-- package의 각 function & cursor 선언
CREATE OR REPLACE PACKAGE exam_pack 
IS
    FUNCTION cal_bonus
    (
        vempno IN emp.empno%TYPE
    )
    RETURN NUMBER;
    
    PROCEDURE cursor_sample02;
END;
/

-- package의 각 function & cursor 선언 내용 기술
CREATE OR REPLACE PACKAGE BODY exam_pack
is
    FUNCTION cal_bonus
    (   
        vempno IN emp.empno%TYPE
    )
    RETURN NUMBER
    IS
        vsal NUMBER(7,2);
    BEGIN
        SELECT sal INTO vsal FROM emp WHERE empno=vempno;
        RETURN (vsal * 200);
    END;
    
    PROCEDURE cursor_sample02
    IS
        vdept dept%rowtype;
        CURSOR c1 IS SELECT * FROM dept;
    BEGIN
        dbms_output.put_line('부서번호 / 부서명 / 지역명');
        dbms_output.put_line('-------------------------------');
        
        FOR vdept IN c1 LOOP
            EXIT WHEN c1%notfound;
            dbms_output.put_line(vdept.deptno||' '||vdept.dname||' '||vdept.loc);
        END LOOP;
    END;
END;
/