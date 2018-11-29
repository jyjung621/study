-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- moneybook Table Create SQL
CREATE TABLE moneybook
(
    `bookNo`      INT(8)           NOT NULL    COMMENT '번호', 
    `bookName`    VARCHAR(45)      NOT NULL    COMMENT '가계부이름', 
    `userId`      VARCHAR(45)      NOT NULL    COMMENT '사용자', 
    `kinds`       varchar(2)       NULL        DEFAULT '0' COMMENT '0:주  1:세부', 
    `parentBook`  INT(8)      	   NULL        COMMENT '상위가계부', 
    `meno`        VARCHAR(4000)    NULL        COMMENT '메모', 
    `regDate`     DATETIME         NULL        COMMENT '등록일', 
    PRIMARY KEY (bookNo, bookName, userId)
);

ALTER TABLE moneybook COMMENT '가계부';


-- payment Table Create SQL
CREATE TABLE payment
(
    `paymentNo`    INT(8)         NOT NULL    COMMENT '번호', 
    `userId`       VARCHAR(45)    NOT NULL    COMMENT '사용자', 
    `paymentName`  VARCHAR(45)    NOT NULL    COMMENT '결제수단이름', 
    `kinds`        varchar(2)     NULL        COMMENT '분류를 위한 필드', 
    `company`      VARCHAR(45)    NULL        COMMENT '은행 or 카드사', 
    `payDate`      DATE           NULL        COMMENT '결제일', 
    `account`      VARCHAR(45)    NULL        COMMENT '체크 & 신용 카드의 경우  통장(계좌)로 연결필요', 
    PRIMARY KEY (paymentNo, userId, paymentName)
);

ALTER TABLE payment COMMENT '결제수단';


-- financy Table Create SQL
CREATE TABLE financy
(
    `financyNo`     INT(8)           NOT NULL    COMMENT '번호', 
    `userId`        VARCHAR(45)      NOT NULL    COMMENT '사용자', 
    `categoryName`  VARCHAR(45)      NULL        DEFAULT 'temp' COMMENT '카테고리', 
    `paymentName`   VARCHAR(45)      NULL        DEFAULT '현금' COMMENT '결제수단', 
    `price`         INT              NULL        COMMENT '금액', 
    `history`       VARCHAR(2000)    NULL        COMMENT '지출내역', 
    `bookName`      VARCHAR(45)      NULL        COMMENT '가계부이름', 
    `regDate`       DATETIME         NULL        COMMENT '지출일시', 
    `isIncome`      VARCHAR(2)       NULL        DEFAULT '0' COMMENT '0:지출  1:수입', 
    PRIMARY KEY (financyNo, userId)
);

ALTER TABLE financy COMMENT '재정(지출/수입)';


-- board Table Create SQL
CREATE TABLE board
(
    `boardNo`  int(8)           NOT NULL    COMMENT '번호', 
    `title`    varchar(200)     NOT NULL    COMMENT '제목', 
    `content`  varchar(4000)    NOT NULL    COMMENT '내용', 
    `hits`     int(4)           NULL        DEFAULT 0 COMMENT '조회수', 
    `likeCnt`  int(4)           NULL        DEFAULT 0 COMMENT '좋아요', 
    `userId`   varchar(45)      NOT NULL    COMMENT '작성자', 
    `regDate`  DATETIME         NOT NULL    COMMENT '작성일', 
    PRIMARY KEY (boardNo)
);

ALTER TABLE board COMMENT '게시판';


-- user Table Create SQL
CREATE TABLE user
(
    `userNo`    INT(8)         NOT NULL    COMMENT '번호', 
    `userId`    VARCHAR(45)    NOT NULL    COMMENT 'email 형식', 
    `passwd`    varchar(20)    NOT NULL    COMMENT '비밀번호', 
    `nickname`  VARCHAR(45)    NOT NULL    COMMENT '닉네임', 
    `phone`     varchar(20)    NULL        COMMENT '연락처', 
    `grade`     varchar(10)    NULL        DEFAULT '3' COMMENT '0:관리자 1~3:개인등급', 
    `regDate`   DATETIME       NULL        COMMENT '가입일', 
    PRIMARY KEY (userNo, userId, nickname)
);

ALTER TABLE user COMMENT '회원';

ALTER TABLE `opentutorials`.`user` 
CHANGE COLUMN `userNo` `memberNo` INT(8) NOT NULL COMMENT '번호' ,
CHANGE COLUMN `userId` `memberId` VARCHAR(45) NOT NULL COMMENT 'email 형식' , RENAME TO  `opentutorials`.`member` ;


-- category Table Create SQL
CREATE TABLE category
(
    `categoryNo`  INT(8)         NOT NULL    COMMENT '번호', 
    `userId`      VARCHAR(45)    NOT NULL    COMMENT '사용자', 
    `kinds`       varchar(2)     NULL        DEFAULT '0' COMMENT '0:수입  1:지출  2:부채  3:저축/투자', 
    `name`        VARCHAR(45)    NULL        COMMENT '이름', 
    PRIMARY KEY (categoryNo, userId)
);


-- debt Table Create SQL
CREATE TABLE debt
(
    `debtNo`        INT(8)         NOT NULL    COMMENT '번호', 
    `userId`        VARCHAR(45)    NOT NULL    COMMENT '사용자', 
    `categoryName`  VARCHAR(45)    NULL        DEFAULT 'temp' COMMENT '대출기관', 
    `paymentName`   VARCHAR(45)    NULL        DEFAULT '대출' COMMENT '결재수단', 
    `price`         INT            NULL        COMMENT '금액', 
    `history`       VARCHAR(45)    NULL        COMMENT '부채내역', 
    `bookName`      VARCHAR(45)    NULL        COMMENT '가계부이름', 
    `debtMonths`    INT(2)         NULL        COMMENT '할부개월', 
    `payCnt`        INT(2)         NULL        DEFAULT 0 COMMENT '납부횟수', 
    `account`       VARCHAR(45)    NULL        COMMENT '결제계좌', 
    `payDate`       DATE           NULL        COMMENT '결제일', 
    `regDate`       DATETIME       NULL        COMMENT '부채일시', 
    PRIMARY KEY (debtNo, userId)
);

ALTER TABLE debt COMMENT '부채';


-- mapmoneypay Table Create SQL
CREATE TABLE mapmoneypay
(
    `userId`       VARCHAR(45)    NOT NULL    COMMENT '사용자', 
    `paymentName`  VARCHAR(45)    NOT NULL    COMMENT '결제수단', 
    `bookName`     VARCHAR(45)    NOT NULL    COMMENT '가계부이름'
);

ALTER TABLE mapmoneypay COMMENT '가계부_결재수단_매핑';

ALTER TABLE mapmoneypay ADD CONSTRAINT FK_mapmoneypay_paymentName_payment_paymentName FOREIGN KEY (paymentName)
 REFERENCES payment (paymentName)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE mapmoneypay ADD CONSTRAINT FK_mapmoneypay_bookName_moneybook_bookName FOREIGN KEY (bookName)
 REFERENCES moneybook (bookName)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- budget Table Create SQL
CREATE TABLE budget
(
    `budgetNo`    INT            NOT NULL    COMMENT '번호', 
    `userId`      VARCHAR(45)    NOT NULL    COMMENT '사용자', 
    `budgetName`  VARCHAR(45)    NOT NULL    COMMENT '예산이름', 
    `bookName`    VARCHAR(45)    NULL        COMMENT '가계부이름', 
    `price`       VARCHAR(45)    NULL        COMMENT '예산금액', 
    `startDay`    DATE           NULL        COMMENT '시작일', 
    `endDay`      DATE           NULL        COMMENT '종료일', 
    `isRepeat`    varchar(2)     NULL        DEFAULT '0' COMMENT '0:안함  1:함', 
    PRIMARY KEY (budgetNo, userId, budgetName)
);

ALTER TABLE budget COMMENT '예산';


