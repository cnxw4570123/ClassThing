/* 22-09-16 */

-- 1. 회원가입
INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MDATE, MEMAIL)
VALUES('TESTID', '1234', '정균민', '남', TO_DATE('1996-08-12', 'YYYY-MM-DD'), 'cnxw4@naver.com');
COMMIT;

-- 2. 로그인
SELECT *
FROM MEMBERS
WHERE MID = 'TESTID' AND MPW = '1111';
-- 조회되는 회원정보가 있을 경우 로그인 처리 ( TESTID )

-- 3. 전체상품목록조회
SELECT PDCODE, PDNAME, PDPRICE
FROM PRODUCT;

-- [샌드위치] 상품 선택 >> 상세 페이지로 이동
SELECT * FROM PRODUCT
WHERE PDCODE = 'P0012';
-- [샌드위치] 상품코드 'P0012'

-- 4. 상품상세정보 조회

SELECT * FROM ORDERLIST;
-- 5. 상품 주문 요청 3개 주문
INSERT INTO ORDERLIST VALUES((SELECT NVL(MAX(ODNUM), 0) + 1 FROM ORDERLIST),
'TESTID', SYSDATE, 'P0012', 3);
ROLLBACK;
COMMIT;

-- 주문 상품의 재고 수정
UPDATE PRODUCT
SET PDAMOUNT = PDAMOUNT - 3
WHERE PDCODE = 'P0012';

-- 6. 주문내역 확인 :: [TESTID] 회원의 전체 주문 내역 조회

SELECT M.MNAME AS 주문자, P.PDNAME AS 상품명, P.PDPRICE AS 가격,
O.ODQTY AS 주문수, P.PDPRICE * O.ODQTY AS 결제금액, TO_CHAR(O.ODDATE, 'YYYY-MM-DD') AS 주문일
FROM MEMBERS M, PRODUCT P, ORDERLIST O
WHERE (M.MID = O.ODMID) AND (P.PDCODE = O.ODPDCODE)
      AND O.ODMID = 'TESTID' AND TO_CHAR(O.ODDATE,'YYYY-MM-DD') = '2022-09-15';
  
  
/* [주문취소] */
-- 주문자 'TESTID', P 
-- 1. ORDERLIST테이블의 취소한 주문 내역을 삭제
-- 2. PRODUCT 테이블에 주문취소된 상품의 재고 수정

UPDATE PRODUCT
SET PDAMOUNT = PDAMOUNT + (SELECT ODQTY FROM ORDERLIST WHERE ODCODE = 4)
WHERE PDCODE = 'P0012' AND ODMID = 'TESTID';

DELETE FROM ORDERLIST
WHERE ODNUM = 4;
  
SELECT * FROM ORDERLIST;
SELECT * FROM PRODUCT WHERE PDCODE = 'P0012';
COMMIT;
      
/* 상품검색 : 이름 */      
SELECT * FROM PRODUCT WHERE PDNAME = '이름';

/* 판매중인 상품 목록 : 상품 종류 */
SELECT * FROM PRODUCT WHERE PDTYPE = '상품 종류';
/* 재고가 남아있는 상품 목록 */
SELECT * FROM PRODUCT WHERE PDAMOUNT > 0;
SELECT * FROM PRODUCT
WHERE PDCODE = 'PTEST';
      
      
      
      
      
      









































































































































































