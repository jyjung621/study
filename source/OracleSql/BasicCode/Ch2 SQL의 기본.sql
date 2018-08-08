-- tab : table의 약어
-- 아래 명령어 -> scott이 갖고 있는 전체 테이블 조회하는 sql문
-- tab : data dictionary중의 하나임
-- data dictionary : Oracle이 갖고 있는 테이블 리스트로, 
--                   사용자가 만든 database 정보를 관리함
select * from tab;


select * from dept;

-- desc : describe의 약어, table의 column 정보를 제공
--        즉, table의 컬럼이름, null여부, data type정보 제공
desc dept;

desc emp;

-- select + 조회하고자하는 column이름 + from + 테이블이름;
-- * : 모든 column
select * from dept;
select * from emp;
-- select 다음에는 보고자하는 column들을 지정하는데,
-- 이것은 관계연산자인 projection과 같음
select empno, ename from emp;
-- emp에서 이름, 급여, 입사일자를 가져오라
select ename, sal, hiredate from emp;

-- 산술연산 (+, -, *, /)
select ename, sal, sal*12 from emp;
-- sal*12+comm 연산결과 :  comm이 NULL이면 전체가 NULL로 나옴
-- NULL의 의미 : ? 또는 무한대
select ename, sal, job, comm, sal*12, sal*12+comm from emp;

-- NVL(변수이름, NULL일때 저장할 값) :  oracle 내부 함수로,
--      NULL이면 함수의 두번째 인자로 지정된 값으로 변환
--      NVL(comm, 0) --> comm이 NULL이면 0으로 값을 치환
select ename, sal, job, comm, sal*12, sal*12+NVL(comm, 0) from emp;

select ename, sal*12+NVL(comm, 0) from emp;

-- column이름의 별칭을 AS 다음에 줄 수 있음
select ename, sal*12+NVL(comm, 0) AS ANNSAL from emp;
-- column이름 뒤에 AS 없이 별칭을 줄 수 있음
select ename, sal*12+NVL(comm, 0) ANNSAL from emp;
-- 별칭 줄 때 " "으로 줄 수 있음
select ename, sal*12+NVL(comm, 0) "A n n s a l" from emp;
select ename, sal*12+NVL(comm, 0) AS "연봉" from emp;

SELECT deptno "부서번호", dname "부서명" from dept;

SELECT ename, ' is a ', job FROM emp;
-- || --> concatenation이라하고, 컴럼 출력값을 합쳐주는 효과
SELECT ename || ' is a ' || job FROM emp;

SELECT deptno from emp;
-- DISTINCT : 중복된 컬럼값을 제거하고, 한개만 보여줌
SELECT DISTINCT deptno from emp;
