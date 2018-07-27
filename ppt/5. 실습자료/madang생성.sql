/* �ý��� �������� ���� */
DROP USER madang CASCADE;

CREATE USER madang 
IDENTIFIED BY madang
Default Tablespace users
Temporary Tablespace temp
profile default;

GRANT Connect, RESOURCE TO madang;
-- GRANT create view, create synonym to madang;

ALTER USER madang ACCOUNT unlock;

/* ���⼭ ���ʹ� ����������� ���� */
conn madang/madang

DROP TABLE Book;

CREATE TABLE Book (
bookid  NUMBER(2) PRIMARY KEY,
bookname VARCHAR2(40),
publisher VARCHAR2(40),
price NUMBER(8)
);

INSERT INTO Book VALUES(1, '�౸�� ����','�½�����', 7000);
INSERT INTO Book VALUES(2, '�౸�ƴ� ����','������', 13000);
INSERT INTO Book VALUES(3, '�౸�� ����','���ѹ̵��', 22000);
INSERT INTO Book VALUES(4, '���� ���̺�','���ѹ̵��', 35000);
INSERT INTO Book VALUES(5, '�ǰ� ����','�½�����', 8000);
INSERT INTO Book VALUES(6, '���� �ܰ躰���','�½�����', 6000);
INSERT INTO Book VALUES(7, '�߱��� �߾�','�̻�̵��', 20000);
INSERT INTO Book VALUES(8, '�߱��� ��Ź��','�̻�̵��', 13000);
INSERT INTO Book VALUES(9, '�ø��� �̾߱�','�Ｚ��', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions','Pearson', 13000);

select * from Book;


DROP TABLE Customer;

CREATE TABLE Customer (
custid  NUMBER(2) PRIMARY KEY,
name  VARCHAR2(40),
address VARCHAR2(50),
phone VARCHAR2(20)
);

INSERT INTO Customer VALUES(1, '������','���� ��ü��Ÿ', '000-5000-0001');
INSERT INTO Customer VALUES(2, '�迬��','���ѹα� ����', '000-6000-0001');
INSERT INTO Customer VALUES(3, '��̶�','���ѹα� ������', '000-7000-0001');
INSERT INTO Customer VALUES(4, '�߽ż�','�̱� �ػ罺', '000-8000-0001');
INSERT INTO Customer VALUES(5, '�ڼ���','���ѹα� ����', NULL);

select * from Customer;


DROP TABLE Orders;

CREATE TABLE Orders (
orderid NUMBER(2) PRIMARY KEY,
custid  NUMBER(2) REFERENCES Customer(custid),
bookid  NUMBER(2) REFERENCES Book(bookid),
salesprice  NUMBER(8),
orderdate DATE
);

INSERT INTO Orders VALUES(1, 1, 1, 6000, TO_DATE('2014-07-01', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(2, 1, 3, 21000, TO_DATE('2014-07-03', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(3, 2, 5, 8000, TO_DATE('2014-07-03', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(4, 3, 6, 6000, TO_DATE('2014-07-04', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(5, 4, 7, 20000, TO_DATE('2014-07-05', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(6, 1, 2, 12000, TO_DATE('2014-07-07', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(7, 4, 8, 13000, TO_DATE('2014-07-07', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(8, 3, 10, 12000, TO_DATE('2014-07-08', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(9, 2, 10, 7000, TO_DATE('2014-07-09', 'yyyy-mm-dd'));
INSERT INTO Orders VALUES(10, 3, 8, 13000, TO_DATE('2014-07-10', 'yyyy-mm-dd'));

select * from Orders;


DROP TABLE Imported_Book;

CREATE TABLE Imported_Book (
bookid  NUMBER,
bookname  VARCHAR2(40),
publisher VARCHAR2(40),
price NUMBER(8)
);

INSERT INTO Imported_Book VALUES(21, 'Zen Golf', 'Pearson', 12000);
INSERT INTO Imported_Book VALUES(22, 'Soccer Skills', 'Human Kinetics', 15000);

select * from Imported_Book;

-- Commit : 
COMMIT;

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = "Book";


----------------------------------------------------------
select bookname, publisher, price
from book
where bookname LIKE '%�౸�� ����';

select * from User_Objects;



DROP USER goodsinfo;

create table goodsinfo(
code char(5) not null primary key,
name varchar2(30) not null,
price NUMBER(8) not null,
maker varchar2(20)
);

insert into goodsinfo values ('10001','?���??��TV',350000,'LG');
insert into goodsinfo values ('10002','DVD ?��?��?��?��',250000,'LG');
insert into goodsinfo values ('10003','?���??�� 카메?��',210000,'?��?��');
insert into goodsinfo values ('10004','컬러 ?��?��?��?��',300000,'?��?��리버');

select * from goodsinfo;

commit;

----------------- 1/11(?��)
Create Table NewBook (
bookid number,
bookname Varchar2(20),
publisher varchar2(20),
price number
);
