SET SERVEROUTPUT ON
DECLARE

BEGIN
    FOR N IN 1..5 LOOP
        dbms_output.put_line(N);
    END LOOP;
END;
/