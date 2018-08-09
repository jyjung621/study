-- 패키지 작성 및 실행
-- 패키지 컴파일 -> DB 저장
@C:\devenv\oracle실습\패키지트리거\pack01.SQL
-- 1. cal_bonus 함수 사용
-- return 받을 변수 선언
VARIABLE var_res NUMBER;
-- 실행 (함수)
EXECUTE :var_res := exam_pack.cal_bonus(7788);
-- 출력
PRINT var_res;
-- 2. cursor_sample02 procedure 사용
-- 실행 (커서)
EXECUTE exam_pack.cursor_sample02;


-- dbms_output 패키지 (sys)
-- 1. system에서 oracle에서 제공하는 패키지 정보를 dba_objects에서 제공
DESC dba_objects;
-- dba에서 오라클이 제공하는 dbms_로 시작하는 패키지 조회
SELECT object_name FROM dba_objects
WHERE object_type='PACKAGE' 
AND object_name LIKE 'DBMS_%'
ORDER BY object_name;

-- desc를 이용하여 dbms_output 패키지 안에 있는 함수, 프로시저 정보 조회
desc dbms_output;


-- 트리거 실습 1
@C:\devenv\oracle실습\패키지트리거\trig01.SQL

DROP TABLE emp01;
CREATE TABLE emp01 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(20),
    JOB VARCHAR2(20)
);
SELECT * FROM emp01;
DELETE FROM emp01;

SET SERVEROUTPUT ON
INSERT INTO emp01 VALUES (1,'전원지','화가');


-- 트리거 실습 2
-- 급여정보 자동추가
DROP TABLE sal01;
CREATE TABLE sal01 (
    salno NUMBER(4) PRIMARY KEY,
    sal NUMBER(7,2),
    empno NUMBER(4) REFERENCES emp01(empno)
);

DROP SEQUENCE sal01_salno_seq;
CREATE SEQUENCE sal01_salno_seq;

@C:\devenv\oracle실습\패키지트리거\trig02.SQL

INSERT INTO emp01 VALUES(2, '전수빈', '프로그래머');
INSERT INTO emp01 VALUES(3, '김수빈', '요리사');
SELECT * FROM emp01;
SELECT * FROM sal01;

-- 트리거 3 실습 : 사원 테이블에서 사원이 삭제될 때, 급여테이블에서 해당사원 행을 자동 삭제
-- 급여 정보를 자동삭제
DELETE FROM emp01 WHERE empno=2; -- 무결성 제약조건 위배 (자식레코드)
-- 트리거 생성 (자식 레코드 자동삭제 트리거)
@C:\devenv\oracle실습\패키지트리거\trig03.SQL
DELETE FROM emp01 WHERE empno=2;
SELECT * FROM emp01;
SELECT * FROM sal01;

-- 트리거 삭제
DROP TRIGGER trg_03;


-- trigger 실습 (상품, 입고 테이블 실습)
CREATE TABLE 상품(
    상품코드 CHAR(6) PRIMARY KEY,
    상품명 VARCHAR2(12) NOT NULL,
    제조사 VARCHAR(12),
    소비자가격 NUMBER(8),
    재고수량 NUMBER DEFAULT 0
);

CREATE TABLE 입고(
    입고번호 NUMBER(6) PRIMARY KEY,
    상품코드 CHAR(6) REFERENCES 상품(상품코드),
    입고일자 DATE DEFAULT SYSDATE,
    입고수량 NUMBER(6),
    입고단가 NUMBER(8),
    입고금액 NUMBER(8)
);

-- 상품 정보 등록
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
    VALUES('A00001','세탁기', 'LG', 500); 
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
    VALUES('A00002','컴퓨터', 'LG', 700);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
    VALUES('A00003','냉장고', '삼성', 600);

SELECT * FROM 상품;

-- 입고 트리거 생성
@C:\devenv\oracle실습\패키지트리거\trig04.SQL
-- 상품 입고 정보 등록
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
    VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
    VALUES(2, 'A00002', 10, 450, 4500);

SELECT * FROM 상품;
SELECT * FROM 입고;








