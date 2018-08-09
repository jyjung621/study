CREATE OR REPLACE TRIGGER trg_02
    AFTER INSERT
    ON emp01
    -- for each row : emp01에 insert가 될때마다 begin~end 사이 내용 실행
    FOR EACH ROW
BEGIN
    -- :new -> emp01에서 새로 insert되는 행(row)을 뜻함
    INSERT INTO sal01 VALUES(sal01_salno_seq.NEXTVAL, 100, :NEW.empno);
END;
/