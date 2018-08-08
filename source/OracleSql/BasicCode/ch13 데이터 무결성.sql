-- data 무결성(integrity)
select * from dept;

-- 무결성 제약조건 위배 -> 중복된 primary key를 사용하여 insert하였기 때문
INSERT INTO dept VALUES (10, 'TEST', 'SEOUL');
-- 무결성 제약조건 위배 -> primary  key는 NULL값을 가질수 없음
INSERT INTO dept VALUES (NULL, 'TEST', 'SEOUL');

desc dept;

-- Oracle에서 제공하는 data dictionary(사전)으로 constraints  정보 제공
-- primary key, foreign key, domain제약조건 정보제공
DESC user_constraints;

SELECT constraint_name, constraint_type, table_name FROM user_constraints;
-- USER_CONS_COLUMNS : constraints 정보를 column과 연계하여 보여줌
SELECT * FROM user_cons_columns;

-- 필수 입력을 위한 NOT NULL 제약조건
SELECT * FROM emp01;
-- emp에서는 empno가 primary key로 지정되어 null값을 입력하면 에러 발생
SELECT * FROM emp;
INSERT INTO emp VALUES (NULL, NULL, 'SALESMAN', 30, NULL, NULL, NULL, NULL);
-- emp01은 empno가 primary key로 지정되어 있지 않아 null 값을 입력해도 insert됨
INSERT INTO emp01 VALUES (NULL, NULL, 'SALESMAN', 30, NULL, NULL, NULL, NULL);
SELECT * FROM emp01;

DESC emp01;
desc emp;

-- NOT NULL constraint를 지정하는 방법 실습
DROP TABLE emp02;
CREATE TABLE emp02 (
    empno NUMBER(4) NOT NULL,
    ename VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    deptno NUMBER(2)
);

-- empno, ename에 NULL insert
-- NULL 값을 집어넣으면 에러 발생
INSERT INTO emp02 VALUES (NULL, NULL, 'SALESMAN', 10);
desc emp02;

INSERT INTO emp02 VALUES (7499, 'ALLEN', 'SALESMAN', 10);
SELECT * FROM emp02;

-- UNIQUE 제약 조건
DROP TABLE emp03;
CREATE TABLE emp03 (
    empno NUMBER(4) UNIQUE,
    ename VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    deptno NUMBER(2)
);
SELECT * FROM emp03;
INSERT INTO emp03 VALUES (7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM emp03;
INSERT INTO emp03 VALUES (7499, 'JONES', 'MANAGER', 20);

-- constraint 이름을 짓는 방법
DROP TABLE emp04;
CREATE TABLE EMP04( 
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE,
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL, 
    JOB VARCHAR2(9),
    deptno NUMBER(2)
);

SELECT table_name, constraint_name FROM user_constraints WHERE table_name IN('EMP04');

INSERT INTO emp04 VALUES (7499, 'JONES', 'MANAGER', 20);
INSERT INTO emp04 VALUES (7499, 'JONS', 'MANAGER', 20);
SELECT * FROM emp04;
 

-- primary key constraint
DROP TABLE emp05;
CREATE TABLE emp05( 
    empno NUMBER(4) CONSTRAINT emp05_empno_pk PRIMARY KEY,
    ename VARCHAR2(10) CONSTRAINT emp05_ename_nn NOT NULL,
    JOB VARCHAR2(9),
    deptno NUMBER(2)
);

INSERT INTO emp05 VALUES (7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO emp05 VALUES (7499, 'JONES', 'MANAGER', 20);


-- FOREIGN KEY
SELECT * FROM dept;
SELECT * FROM emp;

INSERT INTO emp (empno, ename, deptno) VALUES (8000, 'SYJ', 50);


SELECT table_name, constraint_type, constraint_name, r_constraint_name
from user_constraints where table_name in ('DEPT', 'EMP');

DROP TABLE emp06;
CREATE TABLE emp06 (
    empno NUMBER(4) CONSTRAINT emp06_empno_pk PRIMARY KEY,
    ename VARCHAR2(10) CONSTRAINT emp06_ename_nn NOT NULL,
    JOB VARCHAR2(9),
    deptno number(2) CONSTRAINT emp06_deptno_fk REFERENCES dept(deptno)
);
INSERT INTO emp06 VALUES (7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM emp06;

INSERT INTO emp06 VALUES (7566, 'JONES', 'MANAGER', 50);

DROP TABLE emp07;
CREATE TABLE emp07 (
    empno NUMBER(4) CONSTRAINT emp07_empno_pk PRIMARY KEY,
    ename VARCHAR2(10) CONSTRAINT emp07_ename_nn NOT NULL,
    sal NUMBER(7,2) CONSTRAINT emp07_sal_ck CHECK(sal BETWEEN 500 AND 5000),
    gender varchar2(1) constraint emp07_gender_ck check(gender in ('M', 'F'))
);
-- 500 <= sal <= 5000 사이만 가능 - check error
INSERT INTO emp07 VALUES (7499, 'ALLEN', 200, 'M');
SELECT * FROM emp07;
-- gender가 'M', 'F' 만 가능 - check error
INSERT INTO emp07 VALUES (7499, 'ALLEN', 2000, 'A');

-- DEFAULT 값 부여 방법
DROP TABLE dept01;
CREATE TABLE dept01 (
    deptno NUMBER(4) PRIMARY KEY,
    dname VARCHAR2(14),
    loc varchar2(13) default 'SEOUL'
);

INSERT INTO dept01 (deptno, dname) VALUES (10, 'ACCOUNTING');
select * from dept01;

-- 테이블 레벨방식으로 constraint 지정하기
DROP TABLE emp01;
-- cloumn에 constraint 지정 방식
CREATE TABLE emp01 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9) UNIQUE,
    deptno number(4) references dept(deptno)
);

DROP TABLE emp02;
-- 테이블 레벨 방식으로 constraint 지정
CREATE TABLE emp02 (
    empno NUMBER(4),
    ename VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    deptno NUMBER(4),
    PRIMARY KEY(empno),
    UNIQUE(JOB),
    FOREIGN key(deptno) references dept(deptno)
);

-- primary key가 복합키로 테이블 방식으로 constraint 지정하면서 이름도 같이 지정
CREATE TABLE MEMBER(
    NAME VARCHAR2(10),
    address VARCHAR2(30),
    mphone VARCHAR2(16),
    CONSTRAINT member_combo_pk PRIMARY KEY(NAME, mphone)
);

-- 제약조건 변경하기(alter table로 constraint 변경하기)
drop table emp01;
CREATE TABLE emp01 (
    empno NUMBER(4),
    ename VARCHAR2(10),
    JOB VARCHAR2(9),
    deptno NUMBER(4)
);
-- alter table로 primary key 추가
ALTER TABLE emp01
ADD CONSTRAINT emp01_empno_pk PRIMARY KEY(empno);
-- alter table로 foreign key 추가
ALTER TABLE emp01
ADD CONSTRAINT emp01_deptno_fk FOREIGN KEY(deptno) REFERENCES dept(deptno);
-- alter table의 modify로 not null 추가
ALTER TABLE emp01
modify ename constraint emp01_ename_nn not null;

-- alter table(drop사용)로 constraint 삭제
ALTER TABLE emp01
DROP CONSTRAINT emp01_deptno_fk;

ALTER TABLE emp01
DROP CONSTRAINT emp01_ename_nn;






