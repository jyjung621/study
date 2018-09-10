CREATE OR REPLACE PACKAGE BODY kk_collection_pkg AS
    PROCEDURE kk_collection_main
        (
            p_sum_yymm  IN  VARCHAR2,
            p_regi_emp_no   IN  VARCHAR2
        )
    IS
    BEGIN
        DELETE mmsum30
        WHERE sum_yymm = p_sum_yymm;
        
        -- 일자별 거래처 제품별 판매현황(SMCP10)정보 해당월 삭제
        DELETE smcp10
        WHERE substr(yymmdd,1,6) = p_sum_yymm;
        
        -- 일자별 제품별 제품별 판매현황(SMProd10)정보 해당월 삭제
        DELETE smprod10
        WHERE substr(yymmdd,1,6) = p_sum_yymm;
        
        -- 일자별 판매실적 오류현황(SMSALE_ERR)정보 해당월 삭제
        DELETE smsale_err
        WHERE yymm = p_sum_yymm;
        
        dbms_output.put_line(' KK_COLLECTION_PRC1 Before p_sum_yymm => ' || p_sum_yymm);
        -- 1. 당월기초 입고 수량을 생성한다.
        kk_collection_prc1( p_sum_yymm );
--        -- 2. 일자별 거래처 제품별 판매현환(SMCP10)정보를 생성 PGM
--        kk_collection_prc2( p_sum_yymm => p_sum_yymm );
--        -- 3. 일자별 제품별 판매현황(SMProd10)정보를 생성 PGM
--        kk_collection_prc3( p_sum_yymm => p_sum_yymm );
--        -- 9. 전체수불마감후 MMSUMM30을 SMSALE에 따라 STCK_QTY 차감 및 마감 처리작업
--        kk_collection_end( p_sum_yymm => p_sum_yymm );
        
        COMMIT;

    END kk_collection_main;
    
    /************************************************************************
    Procedure Name : kk_collection_prc1
    Description : 당월기초 입고 수량을 생성한다.
    *************************************************************************/
    PROCEDURE kk_collection_prc1
        (
            p_sum_yymm  IN  VARCHAR2
        )
    IS
    BEGIN
        dbms_output.ENABLE;
        dbms_output.put_line(' KK_COLLECTION_PRC1 p_sum_yymm => ' || p_sum_yymm);
        
        -----   1) 당월 기초 입고 수량을 생성한다.
        INSERT INTO mmsum30
            (
                sum_yymm,
                item_code,
                item_gubn,
                stck_qty,
                sawonid,
                regidate
            )
        ( SELECT p_sum_yymm,
                    item_code,
                    0,          -- 기초
                    stck_qty,
                    sawonid,
                    sysdate
          FROM mmsum30
          WHERE sum_yymm = to_char(add_months(TO_DATE(p_sum_yymm,'yyyymm'),-1),'yyyymm')
          AND item_gubn = '1'   -- 기말
        );
    END kk_collection_proc1;
           

END kk_collection_pkg;
/        
        