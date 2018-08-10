-- 갱신 트리거
CREATE OR REPLACE TRIGGER trg05
    AFTER UPDATE ON 입고
    FOR EACH ROW
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 + (-:OLD.입고수량 + :NEW.입고수량)
    WHERE 상품코드 = :NEW.상품코드;
END;
/