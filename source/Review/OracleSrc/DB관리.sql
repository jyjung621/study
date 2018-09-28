---------------------------------------------------------
-- DB 관리
--  1. TableSpace
--  2. DB Backup (전체)
--  3. DB Restore (전체)
--  4. DB Backup (부분)
--  5. DB Restore (부분)
---------------------------------------------------------

--------------------------------------------------------------------------------

-- 1. TableSpace --
-- 'C:\DevEnv\tablespace'  디렉토리 생성하고 TEST

-- sys에서 실행
-- 물리적 공간 할당
CREATE TABLESPACE user1 DATAFILE 'C:\DevEnv\tablespace\user1.ora' SIZE 100M;
CREATE TABLESPACE user2 DATAFILE 'C:\DevEnv\tablespace\user2.ora' SIZE 100M;
CREATE TABLESPACE user3 DATAFILE 'C:\DevEnv\tablespace\user3.ora' SIZE 100M;

-- scott에서 실행
CREATE TABLE DEPT2
(	
    "DEPTNO" NUMBER(2,0), 
    "DNAME" VARCHAR2(14 BYTE), 
    "LOC" VARCHAR2(13 BYTE)  
) TABLESPACE "USER1" ;

-- sys에서 실행
-- scott2 생성시 user2에 할당하고 dba권한 부여
CREATE USER scott2 IDENTIFIED BY tiger
DEFAULT TABLESPACE user2;
GRANT dba TO scott2;

-- scott2에서 실행 -> user2공간에 생성됨
CREATE TABLE DEPT3
(	
    "DEPTNO" NUMBER(2,0), 
    "DNAME" VARCHAR2(14 BYTE), 
    "LOC" VARCHAR2(13 BYTE)  
);

--------------------------------------------------------------------------------

-- 2. DB Backup --
-- 'C:\DevEnv\orabackup' 디렉토리 생성후 TEST

-- sys에서 실행
-- 오라클 상에서 backup 할 디렉토리 생성  가상 :  mdbackup2  물리 : 'C:\DevEnv\orabackup'
CREATE OR REPLACE DIRECTORY mdbackup2 AS 'C:\DevEnv\orabackup';
-- scott3에게 mdbackup2 디렉토리에 관한 read write 권한 부여 
GRANT READ, WRITE ON DIRECTORY mdbackup2 TO scott3;

-- cmd에서 실행
-- 'C:\DevEnv\orabackup' 디렉토리로 이동후
-- EXPDP scott3/tiger DIRECTORY=mdbackup2 DUMPFILE=scott3.dmp 

--    ;;; 
--    Export: Release 11.2.0.1.0 - Production on 금 9월 28 14:41:45 2018
--    
--    Copyright (c) 1982, 2009, Oracle and/or its affiliates.  All rights reserved.
--    ;;; 
--    접속 대상: Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
--    With the Partitioning, OLAP, Data Mining and Real Application Testing options
--    "SCOTT3"."SYS_EXPORT_SCHEMA_01" 시작 중: scott3/******** directory=mdbackup2 dumpfile=scott3.dmp 
--    BLOCKS 메소드를 사용하여 예측 진행 중...
--    객체 유형 SCHEMA_EXPORT/TABLE/TABLE_DATA 처리 중
--    BLOCKS 메소드를 사용한 총 예측: 448 KB
--    객체 유형 SCHEMA_EXPORT/USER 처리 중
--    객체 유형 SCHEMA_EXPORT/SYSTEM_GRANT 처리 중
--    객체 유형 SCHEMA_EXPORT/ROLE_GRANT 처리 중
--    객체 유형 SCHEMA_EXPORT/DEFAULT_ROLE 처리 중
--    객체 유형 SCHEMA_EXPORT/PRE_SCHEMA/PROCACT_SCHEMA 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/TABLE 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/INDEX/INDEX 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/CONSTRAINT/CONSTRAINT 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/INDEX/STATISTICS/INDEX_STATISTICS 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/COMMENT 처리 중
--    객체 유형 SCHEMA_EXPORT/PACKAGE/PACKAGE_SPEC 처리 중
--    객체 유형 SCHEMA_EXPORT/PACKAGE/COMPILE_PACKAGE/PACKAGE_SPEC/ALTER_PACKAGE_SPEC 처리 중
--    객체 유형 SCHEMA_EXPORT/PACKAGE/PACKAGE_BODY 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/CONSTRAINT/REF_CONSTRAINT 처리 중
--    . . "SCOTT3"."CUSTOMER"                         8.554 KB       4행이 엑스포트됨
--    . . "SCOTT3"."MMSUM30"                          7.320 KB       8행이 엑스포트됨
--    . . "SCOTT3"."PRODUCT"                          6.835 KB       4행이 엑스포트됨
--    . . "SCOTT3"."SAWON"                            7.601 KB       3행이 엑스포트됨
--    . . "SCOTT3"."SMCP10"                           7.695 KB       5행이 엑스포트됨
--    . . "SCOTT3"."SMPROD10"                         7.234 KB       4행이 엑스포트됨
--    . . "SCOTT3"."SMSALE"                           7.234 KB       5행이 엑스포트됨
--    . . "SCOTT3"."SMSALE_ERR"                           0 KB       0행이 엑스포트됨
--    마스터 테이블 "SCOTT3"."SYS_EXPORT_SCHEMA_01"이(가) 성공적으로 로드됨/로드 취소됨
--    ******************************************************************************
--    SCOTT3.SYS_EXPORT_SCHEMA_01에 대해 설정된 덤프 파일:
--      C:\DEVENV\ORABACKUP\SCOTT3.DMP
--    "SCOTT3"."SYS_EXPORT_SCHEMA_01" 작업이 14:42:19에서 성공적으로 완료됨

-- 성공 후 --> export.log & SCOTT3.dmp 파일 생성

--------------------------------------------------------------------------------

-- 3. DB Restore

-- scott3에서 실행 -> table하나 날려봄 .. 미리 백업해놓은상태
DROP TABLE smprod10;
-- cmd에서 실행
-- 'C:\DevEnv\orabackup' 디렉토리로 이동후
-- 복구 실행
-- IMPDP scott3/tiger DIRECTORY=mdbackup2 DUMPFILE=scott3.dmp 
--    
--    ;;; 
--    IMPORT: RELEASE 11.2.0.1.0 - production ON 금 9월 28 14:47:17 2018
--
--    Copyright (c) 1982, 2009, Oracle and/or its affiliates.  All rights reserved.
--    ;;; 
--    접속 대상: Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
--    With the Partitioning, OLAP, Data Mining and Real Application Testing options
--    마스터 테이블 "SCOTT3"."SYS_IMPORT_FULL_01"이(가) 성공적으로 로드됨/로드 취소됨
--    "SCOTT3"."SYS_IMPORT_FULL_01" 시작 중: scott3/******** directory=mdbackup2 dumpfile=scott3.dmp 
--    객체 유형 SCHEMA_EXPORT/USER 처리 중
--    ORA-31684: 객체 유형 USER:"SCOTT3"이(가) 존재함
--    객체 유형 SCHEMA_EXPORT/SYSTEM_GRANT 처리 중
--    객체 유형 SCHEMA_EXPORT/ROLE_GRANT 처리 중
--    객체 유형 SCHEMA_EXPORT/DEFAULT_ROLE 처리 중
--    객체 유형 SCHEMA_EXPORT/PRE_SCHEMA/PROCACT_SCHEMA 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/TABLE 처리 중
--    ORA-39151: "SCOTT3"."SMSALE_ERR" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."CUSTOMER" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."PRODUCT" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."SAWON" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."MMSUM30" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."SMSALE" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    ORA-39151: "SCOTT3"."SMCP10" 테이블이 존재합니다. skip의 table_exists_action으로 인해 모든 종속 메타 데이터와 데이터를 건너 뜁니다.
--    객체 유형 SCHEMA_EXPORT/TABLE/TABLE_DATA 처리 중
--    . . "SCOTT3"."SMPROD10"                         7.234 KB       4행이 임포트됨
--    객체 유형 SCHEMA_EXPORT/TABLE/INDEX/INDEX 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/CONSTRAINT/CONSTRAINT 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/INDEX/STATISTICS/INDEX_STATISTICS 처리 중
--    객체 유형 SCHEMA_EXPORT/TABLE/COMMENT 처리 중
--    객체 유형 SCHEMA_EXPORT/PACKAGE/PACKAGE_SPEC 처리 중
--    ORA-31684: 객체 유형 PACKAGE:"SCOTT3"."KK_COLLECTION_PKG"이(가) 존재함
--    객체 유형 SCHEMA_EXPORT/PACKAGE/COMPILE_PACKAGE/PACKAGE_SPEC/ALTER_PACKAGE_SPEC 처리 중
--    객체 유형 SCHEMA_EXPORT/PACKAGE/PACKAGE_BODY 처리 중
--    ORA-31684: 객체 유형 PACKAGE_BODY:"SCOTT3"."KK_COLLECTION_PKG"이(가) 존재함
--    객체 유형 SCHEMA_EXPORT/TABLE/CONSTRAINT/REF_CONSTRAINT 처리 중
--    "SCOTT3"."SYS_IMPORT_FULL_01" 작업이 10 오류와 함께 14:47:22에서 완료됨
--    

-- 성공 후, import.log 파일 생성

-- table 복구 점검  -->  복구확인 완료
SELECT * FROM smprod10;
--------------------------------------------------------------------------------

-- 4. DB Backup (부분) --

-- cmd에서 실행
-- 'C:\DevEnv\orabackup' 디렉토리로 이동후
-- smsal table 하나만 백업하기
-- EXP scott3/tiger FILE=smsal.dmp tables=smsale
-- 성공 후 --> smsale.dmp  생성

-- smsal table 하나만 백업하기
-- EXP scott3/tiger FILE=smcp10.dmp tables=smcp10
-- 성공 후 --> smcp10.dmp  생성

--------------------------------------------------------------------------------

-- 5. DB Restore (부분) --
-- scott3에서 실행 -> smsale table 날려봄 .. 미리 백업해놓은상태
DROP TABLE smsale;
-- cmd에서 실행
-- 'C:\DevEnv\orabackup' 디렉토리로 이동후
-- 복구 실행
-- IMP scott3/tiger FILE=smsale.dmp TABLES=smsale
-- 성공 후 -> smsale table 점검 -> 완료
SELECT * FROM smsale;

--------------------------------------------------------------------------------

-- Tip. 꿀팁 --

-- 부분 백업 및 복구를 일일히 하기 귀찮고 힘들기 때문에....
-- window에서는 .bat 파일을 만들어서 실행해줌

-- scott3_exp.bat
--    EXP scott3/tiger FILE=smcp10.dmp tables=smcp10
--    EXP scott3/tiger FILE=smprod.dmp tables=smprod
--    EXP scott3/tiger FILE=product.dmp TABLES=product
--
-- .bat 파일 실행하면 실행한 디렉토리로 알아서 백업됨

--------------------------------------------------------------------------------
