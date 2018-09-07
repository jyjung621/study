create or replace Procedure Dept_Insert
 (
    vdeptno IN dept.deptno%TYPE, 
    vdname IN dept.dname% TYPE,  
    vloc IN dept.loc%TYPE
 )
 Is
 begin
    Insert into dept values(vdeptno , vdname,vloc);
    COMMIT;
 End;