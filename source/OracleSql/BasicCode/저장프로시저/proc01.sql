-- emp01의 행전체를 삭제하는 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp01;
END;
/