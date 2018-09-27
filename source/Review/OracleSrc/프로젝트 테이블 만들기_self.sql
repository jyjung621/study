/**************************************************************************
 *  Scott3 사용자 생성 및 DBA 권한 부여
 **************************************************************************/
 -- sys 계정에서 시작
CREATE USER scott3 IDENTIFIED BY tiger;
GRANT dba TO scott3;

-- scott3 사용자로 이동
CONN scott3/tiger;

/**************************************************************************
 *  Customer 테이블 생성 & 데이터 삽입
 **************************************************************************/

-- customer table 생성
DROP TABLE customer;
CREATE TABLE customer (
    customid        VARCHAR2(4),                -- 거래처 번호
    CONSTRAINT pk_customid PRIMARY KEY(customid),
    customnm        VARCHAR2(20),               -- 거래처 이름
    customowner     VARCHAR2(20),               -- 거래처 대표 이름
    custombirthday  VARCHAR2(8),                -- 거래처 대표 생일
    customgender    VARCHAR2(1),                -- 거래처 대표 성별
    customaddr      VARCHAR2(50),               -- 거래처 주소
    customtel       VARCHAR2(20),               -- 거래처 전화
    matchsawon      VARCHAR2(4),                -- 거래처 담당사원
    regidat         DATE                        -- 거래처 등록일자
    );

-- comment 삽입
comment on column customer.customid        IS '거래처 번호';
COMMENT ON COLUMN customer.customnm        IS '거래처 이름';
COMMENT ON COLUMN customer.customowner     IS '거래처 대표 이름';
comment on column customer.custombirthday  IS '거래처 대표 생일';
COMMENT ON COLUMN customer.customgender    IS '거래처 대표 성별';
COMMENT ON COLUMN customer.customaddr      IS '거래처 주소';
COMMENT ON COLUMN customer.customtel       IS '거래처 전화';
comment on column customer.matchsawon      IS '거래처 담당사원';
COMMENT ON COLUMN customer.regidat         IS '거래처 등록일자';
-- 주석제거
-- COMMENT ON COLUMN table.column         IS '';

desc customer;
SELECT * FROM customer;

-- data 삽입
INSERT INTO customer VALUES (
    1001, '영화상사', '김영화', '19760108', '1',
    '서울 서초동', '010-1111-2222', 's001', sysdate
);
INSERT INTO customer VALUES (
    1002, '뮤즈컴', '안예은', '19961208', '2',
    '서울 강남구', '010-3333-5555', 's002', sysdate
);
INSERT INTO customer VALUES (
    1003, '뮤지칼', '김준수', '19981108', '1',
    '서울 강남구', '010-1234-5555', 's003', sysdate
);
INSERT INTO customer VALUES (
    1004, '뮤즈컴', '손흥민', '19760108', '1',
    '서울 강남구', '010-3333-5678', 's001', sysdate
);
SELECT * FROM customer;



/**************************************************************************
 *  Product 테이블 생성 & 데이터 삽입
 **************************************************************************/

-- Product table 만들기
DROP TABLE product;

CREATE TABLE product 
( 
    item_code           VARCHAR2(4),             -- 제품 번호
    CONSTRAINT pk_item_code PRIMARY KEY(item_code),
    itemname            VARCHAR2(20),           -- 제품 이름
    danga               NUMBER(8),              -- 단가
    special             VARCHAR2(100),          -- 제품 특징
    regidate            DATE                    -- 등록일자
);

COMMENT ON COLUMN product.item_code IS '제품 번호';
COMMENT ON COLUMN product.itemname  IS '제품 이름';
COMMENT ON COLUMN product.danga     IS '단가';
COMMENT ON COLUMN product.special   IS '제품 특징';
COMMENT ON COLUMN product.regidate  IS '등록일자';

desc product;
select * from product;

INSERT INTO product VALUES (
    'A001', '마이크', 15000, '고성능 제품', sysdate
);
INSERT INTO product VALUES (
    'A002', '스피커', 6000, '우수 제품', sysdate
);
INSERT INTO product VALUES (
    'B001', '축구복', 25600, '방수용 제품', sysdate
);
INSERT INTO product VALUES (
    'B002', '축구공', 15800, '고탄력 제품', sysdate
);


/**************************************************************************
 *  Smsale 테이블 생성 & 데이터 삽입
 **************************************************************************/

DROP TABLE smsale;
--CREATE TABLE smsale
--(
--    yymmdd          VARCHAR2(8),
--        CONSTRAINT pk_yymmdd PRIMARY KEY(yymmdd),
--    customid        VARCHAR2(4),
--        CONSTRAINT fk_customid FOREIGN KEY(customid)
--        REFERENCES customer(customid),
--    item_code       VARCHAR2(4),
--        CONSTRAINT fk_item_code FOREIGN KEY(item_code)
--        REFERENCES product(item_code),
--    stck_qty        NUMBER(8),
--    sawonid         VARCHAR2(4),
--    regidate        DATE
--);
CREATE TABLE smsale
(
    yymmdd          VARCHAR2(8),                     -- 판매 년월일
    customid        VARCHAR2(4)                      -- 거래처 번호
        -- 이름이 같을경우 컬럼 표시 안해도 됨
        CONSTRAINT fk_customid REFERENCES customer,
    item_code       VARCHAR2(4)                      -- 제품 번호
        CONSTRAINT fk_item_code REFERENCES product,
    stck_qty        NUMBER(8),                       -- 수량
    sawonid         VARCHAR2(4),                     -- 사원
    regidate        DATE                             -- 등록일자
);

-- 복합키 설정 방법
ALTER TABLE smsale
    add constraint pk_smsale primary key(yymmdd, customid, item_code);
        
COMMENT ON COLUMN smsale.yymmdd     IS '판매 년월일';
COMMENT ON COLUMN smsale.customid   IS '거래처 번호';
COMMENT ON COLUMN smsale.item_code  IS '제품 번호';
COMMENT ON COLUMN smsale.stck_qty   IS '수량';
COMMENT ON COLUMN smsale.sawonid    IS '사원';
COMMENT ON COLUMN smsale.regidate   IS '등록일자';   


