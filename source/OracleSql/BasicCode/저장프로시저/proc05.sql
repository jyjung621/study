CREATE OR REPLACE PROCEDURE cursor_sample01
IS
    vdept dept%rowtype;
    -- c1 : cursor 이름
    CURSOR c1
    IS
    SELECT * FROM dept; -- 항상 select문 써야함
BEGIN
    dbms_output.put_line('부서번호 / 부서명 / 지역명');
    dbms_output.put_line('-------------------------------');
    
    OPEN c1;
        LOOP
            -- fetch : 한개의 row를 읽어옴
            FETCH c1 INTO vdept.deptno, vdept.dname, vdept.loc;
            -- exit when : exit 하라는 명령어 (c1이 읽어올게 없을경우)
            EXIT WHEN c1%notfound;
            dbms_output.put_line(vdept.deptno||' '||vdept.dname||' '||vdept.loc);
        END LOOP;
    CLOSE c1;
END;
/