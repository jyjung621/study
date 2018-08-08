SELECT * FROM emp;

-- sequence 실습
CREATE SEQUENCE dept_deptno_seq
INCREMENT BY 10
START WITH 10;

-- data dictionary : user_sequences
desc user_sequences;

SELECT sequence_name, min_value, max_value, increment_by, cycle_flag
FROM user_sequences;

-- sequence create하고 나서 최초로는 nextval을 사용해야만 함
-- create하고 나서 최초로 currval을 사용하면 에러 발생
SELECT dept_deptno_seq.NEXTVAL FROM dual;
SELECT dept_deptno_seq.CURRVAL FROM dual;

-- sequence 실무에 적용하기
CREATE SEQUENCE emp_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 100000;

DROP TABLE emp01;
CREATE TABLE emp01 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR(10),
    hiredate date
);
-- constraint name 확인
SELECT constraint_name, column_name, table_name
FROM user_cons_columns
WHERE table_name IN('EMP01');

INSERT INTO emp01 VALUES(emp_seq.NEXTVAL, 'JULIA', sysdate);
INSERT INTO emp01 VALUES(emp_seq.NEXTVAL, 'FORD', sysdate);
SELECT * FROM emp01;

-- sequence 실습
DROP SEQUENCE dept_ex_seq;  -- sequence 삭제
CREATE SEQUENCE dept_ex_seq
START WITH 0
INCREMENT BY 10
MINVALUE 0;

DROP TABLE dept_example;
CREATE TABLE dept_example (
    deptno NUMBER(4) PRIMARY KEY,
    dname VARCHAR(15),
    loc VARCHAR(15)
);

INSERT INTO dept_example VALUES(dept_ex_seq.NEXTVAL, '인사과', '서울');
INSERT INTO dept_example VALUES(dept_ex_seq.NEXTVAL, '경리과', '서울');
INSERT INTO dept_example VALUES(dept_ex_seq.NEXTVAL, '총무과', '대전');
INSERT INTO dept_example VALUES(dept_ex_seq.NEXTVAL, '기술팀', '인천');

select * from dept_example;

select * from user_sequences;

-- sequence 수정
ALTER SEQUENCE dept_deptno_seq
maxvalue 100000;
