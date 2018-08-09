SET SERVEROUTPUT ON
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE (N <= 5) LOOP
        dbms_output.put_line(N);
        N := N+1;
    END LOOP;
END;
/