CREATE OR REPLACE PACKAGE BODY kk_collection_pkg AS
/************************************************************************
    Procedure Name : kk_collection_main
    Description : main 실행
*************************************************************************/
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
        kk_collection_prc2( p_sum_yymm => p_sum_yymm );
--        -- 3. 일자별 제품별 판매현황(SMProd10)정보를 생성 PGM
        kk_collection_prc3( p_sum_yymm => p_sum_yymm );
--        -- 9. 전체수불마감후 MMSUMM30을 SMSALE에 따라 STCK_QTY 차감 및 마감 처리작업
        kk_collection_end( p_sum_yymm => p_sum_yymm );
        
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
    END kk_collection_prc1;

/************************************************************************
    Project         : KK 영업매출현황
    Module          : 수불관리
    Procedure Name  : kk_collection_prc2
    Description     : 일자별 거래처 제품별 판매현황(SMCP10)정보를 생성
                    - 일별 판매실적 현황(SMSALE)을 읽어 일자별 거래처 제품별 판매현황(SMCP10)정보를 생성
                    - 일별 판매 실적 현황, Danga는 제품(Product) 테이블 JOIN
                    - 사원은 global 변수인 g_in_sawonid 으로 입력
*************************************************************************/
    PROCEDURE kk_collection_prc2
        ( 
            p_sum_yymm  IN  VARCHAR2
        )
    IS
        CURSOR csr_smsale is
            SELECT s.yymmdd, s.customid, s.item_code, s.stck_qty, p.danga, s.sawonid, s.regidate
            FROM smsale S, product P
            WHERE S.item_code = P.item_code
            and substr(s.yymmdd,1,6) = p_sum_yymm;      
    BEGIN
        dbms_output.ENABLE;
        dbms_output.put_line(' KK_COLLECTION_PRC2 p_sum_yymm => ' || p_sum_yymm);
        
        FOR rec_smsale IN csr_smsale LOOP
            INSERT INTO smcp10 VALUES (
                rec_smsale.yymmdd,
                rec_smsale.customid, 
                rec_smsale.item_code,
                rec_smsale.stck_qty,
                rec_smsale.danga,
                g_in_sawonid,
                --s_list.sawonid,
                sysdate
                );
        END LOOP;        
        EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm || '에러발생');
    
    end kk_collection_prc2;        

/************************************************************************
    Project         : KK 영업매출현황
    Module          : 수불관리
    Procedure Name  : kk_collection_prc3
    Description     : 일자별 제품별 판매현황(SMProd10)정보를 생성 
                    - 일별 판매실적 현황(SMSALE)을 읽어 일자별 제품별 판매현황(SMProd10)정보를 생성
                    - 일별 판매 실적 현황, Danga는 제품(Product) 테이블 JOIN
                    - 사원은 global 변수인 g_in_sawonid 으로 입력
*************************************************************************/
    PROCEDURE kk_collection_prc3
        ( 
            p_sum_yymm  IN  VARCHAR2
        )
    IS
        CURSOR csr_smsale2 IS
            SELECT S.yymmdd, S.item_code, SUM(S.stck_qty) stck_qty_sum, round(AVG(p.danga),3) danga_avg
            FROM smsale S, product P
            WHERE S.item_code = P.item_code
            AND substr(S.yymmdd,1,6) = p_sum_yymm
            GROUP BY s.yymmdd, S.item_code;
    BEGIN
        dbms_output.ENABLE;
        dbms_output.put_line(' KK_COLLECTION_PRC3 p_sum_yymm => ' || p_sum_yymm);
        
        FOR rec_smsale2 IN csr_smsale2 LOOP
            INSERT INTO smprod10 VALUES (
                rec_smsale2.yymmdd,
                rec_smsale2.item_code,
                rec_smsale2.stck_qty_sum,
                rec_smsale2.danga_avg,
                g_in_sawonid,
                --s_list.sawonid,
                sysdate
                );
        END LOOP;        
        EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm || '에러발생');
    
    end kk_collection_prc3;     

/************************************************************************
    Project         : KK 영업매출현황
    Module          : 수불관리
    Procedure Name  : kk_collection_end
    Description     : 일자별 제품별 판매현황(SMProd10)정보를 생성 
                    - 일별 판매실적 현황(SMSALE)을 읽어 일자별 제품별 판매현황(SMProd10)정보를 생성
                    - 일별 판매 실적 현황, Danga는 제품(Product) 테이블 JOIN
                    - 사원은 global 변수인 g_in_sawonid 으로 입력
*************************************************************************/
    PROCEDURE kk_collection_end
        ( 
            p_sum_yymm  IN  VARCHAR2
        )
    IS
    ----- MMSUMM30을 SMSALE에 대하여 yymmdd, item_code별 수량 합계 차감
        CURSOR csr_store_remain IS
            SELECT substr(S.yymmdd,1,6) yymm,
                    S.item_code         item_code,
                    SUM(S.stck_qty)     s_stck_qty,
                    AVG(M.stck_qty)     m_stck_qty
            FROM ( SELECT * FROM smsale
                    WHERE substr(yymmdd,1,6) = p_sum_yymm
                 ) S,   -- 일별 판매 실적현황
                 ( SELECT * FROM mmsum30
                    WHERE sum_yymm = p_sum_yymm
                    AND item_gubn = '0'    -- 기초 재고에 한해
                 ) M    -- 창고 재고 테이블
            WHERE S.item_code = M.item_code
            GROUP BY substr(S.yymmdd,1,6), S.item_code;
    BEGIN
        dbms_output.ENABLE;
        dbms_output.put_line(' KK_COLLECTION_END p_sum_yymm => ' || p_sum_yymm);
        
        FOR rec_store_remain IN csr_store_remain LOOP
            -- 만약 창고 기초재고가 판매량보다 크다면 기말재고 입력
            IF rec_store_remain.m_stck_qty > rec_store_remain.s_stck_qty THEN
                INSERT INTO mmsum30
                    (   sum_yymm,
                        item_code,
                        item_gubn,
                        stck_qty,
                        sawonid,
                        regidate
                    )
                VALUES
                    (   rec_store_remain.yymm,
                        rec_store_remain.item_code,
                        '1',                            -- 기말재고
                        rec_store_remain.m_stck_qty - rec_store_remain.s_stck_qty,
                        g_in_sawonid,
                        sysdate
                    );
            ELSE    -- rec_store_remain.m_stck_qty < rec.store_remain.s_stck_qty
                INSERT INTO smsale_err
                    (   yymm,
                        item_code,
                        mmsum30_qty,
                        smsale_qty,
                        sawonid,
                        regidate
                    )
                VALUES
                    (   rec_store_remain.yymm,
                        rec_store_remain.item_code,
                        rec_store_remain.m_stck_qty,    -- 기초재고
                        rec_store_remain.s_stck_qty,    -- 판매수량
                        g_in_sawonid,
                        sysdate
                    );
                    g_prod_cnt := rec_store_remain.m_stck_qty - rec_store_remain.s_stck_qty;
                    dbms_output.put_line(rec_store_remain.yymm || '년월에 ' || rec_store_remain.item_code || ' 재고부족 양 => ' || g_prod_cnt);
                    dbms_output.put_line('재고 부족양 => ' || g_prod_cnt);
            END IF;
        END LOOP;
        
        EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm || '에러발생');
        
    end kk_collection_end;
        
END kk_collection_pkg;
/        


--SELECT * FROM smsale;
--SELECT * FROM smcp10;
--desc smcp10;
--
--delete from smcp10;
--execute kk_collection_main('201802','s003');
--
--SELECT S.yymmdd, S.item_code, S.stck_qty, p.danga, S.regidate
--FROM smsale S, product P
--WHERE S.item_code = P.item_code
--group by s.item_code;
--
--SELECT S.yymmdd, S.item_code, SUM(S.stck_qty) stck_qty_sum, round(AVG(p.danga),3) danga_avg
--FROM smsale S, product P
--WHERE S.item_code = P.item_code
--GROUP BY s.yymmdd, S.item_code;
--
        