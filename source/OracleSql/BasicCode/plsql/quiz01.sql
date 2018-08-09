SET SERVEROUTPUT ON
DECLARE
    -- %rowtype 속성으로 로우 전체를 저장할 수 있는 레퍼런스 변수 선언
    vemp emp%rowtype;
    annsal NUMBER(7,2);
BEGIN
    dbms_output.put_line('사번  / 이름   / 연봉    ');
    dbms_output.put_line('----------------------------------------');
    
    -- scott 사원의 전체 정보를 로우 단위로 얻어와 vemp에 저장
    SELECT * INTO vemp FROM emp WHERE ename = 'SCOTT';
    
    -- 커미션이  null일 경우 0으로 변경해야 올바른 연봉 계산
    IF(vemp.comm is NULL) THEN
        vemp.comm := 0;
    END IF;
    
    
    -- 스칼라 변수에 연봉을 계산할 결과를 저장
    annsal := vemp.sal*12 + vemp.comm;
    -- 결과출력
    dbms_output.put_line(vemp.empno||' / '||vemp.ename||' / '||annsal);
END;
/

