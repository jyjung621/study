CREATE OR REPLACE TRIGGER trg_03
    AFTER DELETE ON emp01
    FOR EACH ROW
BEGIN
    -- :old -> 현재 테이블에 있는 행(row)을 뜻함
    --          삭제될 emp01의 해당 row를 뜻함
    delete from sal01 where empno = :old.empno;
END;
/