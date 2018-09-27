CREATE TABLE member1
(
    ID  VARCHAR2(10)
    constraint pk_member1_id primary key,
    PASSWORD VARCHAR2(20),
    NAME VARCHAR2(100),
    reg_date DATE
); --TABLESPACE "system";

INSERT INTO scott.member1 
    (
        ID,
        PASSWORD,
        NAME,
        reg_date
    )
    VALUES
    (
        'aa',
        '1234',
        '김유신',
        TO_DATE('18/09/18', 'RR/MM/DD')
    );
    