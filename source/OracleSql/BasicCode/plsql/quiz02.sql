SET SERVEROUTPUT ON
DECLARE
    dan NUMBER := 5;
    I NUMBER := 1;
BEGIN
    LOOP
        dbms_output.put_line(dan||' x '||I||' = '||(dan*I));
        I := I+1;
        IF (I > 9) THEN
            EXIT;
        END IF;
    END LOOP;
END;
/