CREATE OR REPLACE TRIGGER trg_01
    AFTER INSERT
    ON emp01
BEGIN
    dbms_output.put_line('신입사원이 입사했습니다.');
END;
/