SET SERVEROUTPUT ON
DECLARE
    -- 테이블 타입(특정 컬럼의 배열타입)을 정의
    TYPE ename_table_type IS TABLE OF emp.ename%TYPE INDEX BY BINARY_INTEGER;
    TYPE job_table_type IS TABLE OF emp.JOB%TYPE INDEX BY BINARY_INTEGER;
    
    -- 테이블 타입으로 변수 선언
    ename_table ename_table_type;
    job_table job_table_type;
    
    i binary_integer:=0;
BEGIN
    -- emp 테이블에서 사원이름과 직급을 얻어옴
    FOR K IN (SELECT ename, JOB FROM emp) LOOP
        I := I+1;
        ename_table(I) := K.ename;
        job_table(I) := K.JOB;
    END LOOP;
    -- 테이블에 저장된 내용을 출력
    FOR j IN 1..I LOOP
        dbms_output.put_line(rpad(ename_table(j),12) 
            || ' / ' || rpad(job_table(j),9));
    END LOOP;

END;
/