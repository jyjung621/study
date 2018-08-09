SET SERVEROUTPUT ON
DECLARE
    N NUMBER := 1;
BEGIN
    LOOP    
        dbms_output.put_line(N);
        N := N+1;
        IF (N > 5) THEN
            EXIT;
        END IF;
    END LOOP;
END;
/
    