SET SERVEROUTPUT ON
DECLARE
    -- record type 정의
    TYPE emp_record_type IS RECORD (
        v_empno emp.empno%TYPE,
        v_ename emp.ename%TYPE,
        v_job   emp.JOB%TYPE,
        v_deptno emp.deptno%type
    );
    
    -- 레코드로 변수 선언
    emp_record emp_record_type;
    
BEGIN
    -- scott 사원의 정보를 레코드 변수에 저장
    SELECT empno, ename, job, deptno INTO emp_record
    FROM emp 
    WHERE ename=upper('SCOTT');
    
    -- 레코드 변수에 저장된 사원 정보를 출력
    dbms_output.put_line('사원번호 : ' || to_char(emp_record.v_empno));
    dbms_output.put_line('이   름 : ' || to_char(emp_record.v_ename));
    dbms_output.put_line('담당업무 : ' || to_char(emp_record.v_job));
    dbms_output.put_line('부서번호 : ' || to_char(emp_record.v_deptno));
    
END;
/