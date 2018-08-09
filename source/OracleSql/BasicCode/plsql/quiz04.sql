SET SERVEROUTPUT ON
DECLARE
    v_cnt NUMBER := 1;
    v_str VARCHAR2(10) := NULL;
BEGIN
    WHILE (v_cnt <= 5) LOOP
        v_str := v_str || '*';
        dbms_output.put_line(v_str);
        v_cnt := v_cnt+1;
    END LOOP;
END;
/