-- (9)평균급여가 가장 높은 부서의 번호를 출력하시오.
CREATE OR REPLACE FUNCTION avr_sal
RETURN NUMBER
IS
    avr_sal NUMBER(7,2);
    v_deptno number(2,0);
BEGIN
    SELECT D.deptno--, round(AVG(sal),0) 
    INTO v_deptno--, avr_sal  
    FROM dept D, emp E
    WHERE E.deptno=D.deptno
    group by d.deptno
    HAVING AVG(sal)>=ALL(SELECT (AVG(sal)) FROM emp GROUP BY deptno);
        
    return v_deptno;
END;
/

--SELECT D.deptno--, round(AVG(sal),0) 
--FROM dept D, emp E
--WHERE E.deptno=D.deptno
--GROUP BY D.deptno
--HAVING AVG(sal)>=ALL(SELECT (AVG(sal)) FROM emp GROUP BY deptno);

--CREATE OR REPLACE FUNCTION cal_bonus
--(
--    vempno IN emp.empno%TYPE
--)
--RETURN NUMBER
--IS
--    vsal NUMBER(7,2);
--BEGIN
--    SELECT sal INTO vsal from emp where empno = vempno;   
--    return (vsal * 200);
--END;
--/