SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;
    annsal NUMBER(7,2);
BEGIN
    -- scott 사원의 전체 정보를 로우 단위로 얻어와 vemp에 저장
    SELECT * INTO vemp FROM emp WHERE ename='SCOTT';
    
    IF (vemp.comm IS NULL) THEN
        annsal := vemp.sal*12;
    ELSE
        annsal := vemp.sal*12 + vemp.comm;
    end if;
    
    dbms_output.put_line('사번  / 이름   / 연봉    ');
    dbms_output.put_line('----------------------------------------');
    dbms_output.put_line(vemp.empno||' / '||vemp.ename||' / '||annsal);
END;
/