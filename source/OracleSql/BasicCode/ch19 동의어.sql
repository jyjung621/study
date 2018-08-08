SELECT * FROM madang.book;
SELECT * FROM user_tab_privs_made;

select 10*5 from sys.dual;

select * from system.systbl;

-- 비공개 동의어 생성 (scott이 system에서 부여한 권한을 이용)
CREATE SYNONYM psystbl FOR SYSTEM.systbl;
SELECT * FROM psystbl;

-- 공개 동의어 생성 (system에서 만들어야함)
CREATE PUBLIC SYNONYM pubdept FOR scott.dept;   -- sys에서 실행
GRANT SELECT ON scott.dept TO madang;

-- madang 사용자로 이동하여 select로 pubdept 조회
select * from pubdept;