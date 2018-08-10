--(1) 사원의 이름과 직위를 출력하시오. 단, 사원의 이름은 ‘사원이름’, 직위는 ‘사원직위’머리글이 나오도록 출력한다.
--
--(3) 사원 번호와 이름, 현재 급여와 10% 인상된 급여(열 이름은 ‘인상된 급여’)를 출력하시오. 단, 사원 번호순으로 출력한다. 증가된 급여분에 대한 열 이름은 ‘증가액’으로 한다.
--
--(5) 모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하시오. 열 이름은 각각 MAX, MIN, SUM, AVG로 한다. 단, 소수점 이하는 반올림하여 정수로 출력한다.
--
--(7) 사원의 최대 급여와 최소 급여의 차액을 출력하시오.
--

--(9) 평균급여가 가장 높은 부서의 번호를 출력하시오.
--SELECT deptno, AVG(sal) FROM  emp GROUP BY deptno;
@C:\devenv\oracle실습\실습문제\avr_sal.SQL;
VARIABLE res_sal NUMBER;
EXECUTE :res_sal := avr_sal();
print res_sal;

--(11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하시오.
@C:\devenv\oracle실습\실습문제\mgr_notnull.SQL;
VARIABLE res_cnt NUMBER;
EXECUTE :res_cnt := mgr_notnull();
PRINT res_cnt;

--(13) 각 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수
--를 출력하시오.
@C:\devenv\oracle실습\실습문제\cnt_job.SQL;
VARIABLE res_deptno NUMBER;
VARIABLE res_job VARCHAR2;
VARIABLE res_cnt NUMBER;

EXECUTE cnt_job(:res_deptno, :res_job, :res_cnt);

print res_deptno;
PRINT res_job;
print res_cnt;

--(15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오.
--
--(17) 사원의 이름과 사원의 부서를 출력하시오.
--
--(19) 사원 SCOTT보다 급여를 많이 받는 사람의 이름을 출력하시오.



