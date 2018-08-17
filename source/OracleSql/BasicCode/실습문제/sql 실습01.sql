-- madang 서점 DB 추가하기
-- madang생성.sql 을 이용하여 만들기

-- madang에 존재하는 table
SELECT * FROM book;
SELECT * FROM customer;
SELECT * FROM goodinfo;
SELECT * FROM imported_book;
SELECT * FROM newbook;
SELECT * FROM orders;

-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 sql 문을 작성
-- (1) 도서번호가 1인 도서의 이름
SELECT bookid, bookname FROM book WHERE bookid=1;

--(2) 가격이 20,000원 이상인 도서의 이름
SELECT price, bookname FROM book WHERE price >= 20000;

--(3) 박지성의 총 구매액
SELECT SUM(salesprice) 총구매액 FROM orders 
WHERE custid=(SELECT custid FROM customer WHERE NAME='박지성');

SELECT SUM(SALESPRICE) 총구매액 FROM ORDERS, CUSTOMER
WHERE orders.custid=customer.custid
AND NAME='박지성';

SELECT SUM(salesprice) 총구매액 FROM orders, customer
WHERE orders.custid=customer.custid
AND customer.NAME LIKE '박지성';

--(4) 박지성이 구매한 도서의 수
SELECT COUNT(orderid) 총구매수 FROM orders
WHERE custid=(SELECT custid FROM customer WHERE NAME='박지성');

SELECT COUNT(orderid) 총구매수 FROM orders, customer
WHERE orders.custid=customer.custid
AND NAME='박지성';

SELECT COUNT(*) FROM customer, orders
WHERE customer.custid = orders.custid
AND customer.NAME LIKE '박지성';

--(5) 박지성이 구매한 도서의 출판사 수
-- distinct : 컬럼의 종복되는 값을 제외시켜줌
SELECT COUNT(DISTINCT publisher) FROM book, customer, orders
WHERE customer.custid=orders.custid AND orders.bookid=book.bookid
AND customer.NAME LIKE '박지성';

--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
SELECT book.bookname, book.price, book.price-orders.salesprice "discount" FROM book, customer, orders
WHERE customer.custid=orders.custid AND orders.bookid=book.bookid
AND customer.NAME LIKE '박지성';

--(7) 박지성이 구매하지 않은 도서의 이름
SELECT bookname FROM book b1
WHERE NOT EXISTS 
(
    SELECT bookname FROM customer c1, orders o1
    WHERE c1.custid=o1.custid AND o1.bookid=b1.bookid AND c1.NAME LIKE '박지성'
);


--2. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--
--(1) 마당서점 도서의 총 개수(종류)
SELECT COUNT(*) FROM book;

--(2) 마당서점에 도서를 출고하는 출판사의 총 개수
SELECT COUNT(DISTINCT publisher) FROM book;

--(3) 모든 고객의 이름, 주소
SELECT * FROM customer;
SELECT NAME, address FROM customer;

--(4) 2014년 7월 4일~7월 7일 사이에 주문받은 도서의 주문번호
SELECT * FROM orders;
SELECT orderid FROM orders WHERE orderdate BETWEEN '20140704' AND '20140707';

--(5) 2014년 7월 4일~7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
SELECT orderid FROM orders WHERE orderdate NOT BETWEEN '20140704' AND '20140707';

--(6) 성이 ‘김’ 씨인 고객의 이름과 주소
SELECT * FROM customer;
SELECT NAME, address FROM customer WHERE NAME LIKE '김%';

--(7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
SELECT NAME, address FROM customer WHERE NAME LIKE '김%아';

--(8) 주문하지 않은 고객의 이름(부속질의 사용)
SELECT NAME FROM customer WHERE NAME NOT IN (
SELECT name FROM customer, orders WHERE orders.custid = customer.custid
);

--(9) 주문 금액의 총액과 주문의 평균 금액
SELECT * FROM orders;
SELECT SUM(salesprice), AVG(salesprice) FROM orders;

--(10) 고객의 이름과 고객별 구매액
select * from orders;
SELECT NAME, SUM(salesprice) FROM orders o1, customer c1
WHERE o1.custid=c1.custid
GROUP BY NAME;

--(11) 고객의 이름과 고객이 구매한 도서 목록
SELECT NAME, bookname FROM book b1, customer c1, orders o1
WHERE b1.bookid=o1.bookid AND o1.custid=c1.custid;

--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
SELECT * FROM book b1, orders o1
WHERE b1.bookid=o1.bookid
and b1.price-o1.salesprice in 
(
    SELECT MAX(b1.price-o1.salesprice) 
    FROM book b1, orders o1
    WHERE b1.bookid=o1.bookid
);

--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
SELECT c1.NAME, round(AVG(o1.salesprice)) FROM customer c1, orders o1
WHERE c1.custid=o1.custid
GROUP BY NAME
HAVING AVG(o1.salesprice) > (
    SELECT AVG(salesprice) FROM orders
    );

