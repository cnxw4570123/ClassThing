SELECT * FROM PRODUCT;

SELECT PDTYPE FROM PRODUCT
GROUP BY PDTYPE;
/* 22-09-15 */
/* 1. 회원정보 테이블 생성
   2. 주문정보 테이블 생성 */
CREATE TABLE MEMBERS(
    MID NVARCHAR2(20),
    MPW NVARCHAR2(20),
    MNAME NVARCHAR2(5),
    MGENDER NVARCHAR2(1),
    MDATE DATE,
    MEMAIL NVARCHAR2(50)
);

/* 회원 아이디 PRIMARY KEY 부여 */
ALTER TABLE MEMBERS
ADD CONSTRAINT PK_MID PRIMARY KEY(MID);

/* 비밀번호, 이름 NOT NULL */
ALTER TABLE MEMBERS
MODIFY MPW NOT NULL;

ALTER TABLE MEMBERS
MODIFY MNAME NOT NULL;

/* 주문정보 테이블 - ORDERLIST */
CREATE TABLE ORDERLIST(
    ODNUM NUMBER,           -- 주문번호
    ODMID NVARCHAR2(20),    -- 주문자 아이디 FK(MEMBERS-ID)
    ODDATE DATE,            -- 주문일
    ODPDCODE NVARCHAR2(10), -- 주문한 상품코드 FK(PRODUCT - PDCODE)
    ODQTY NUMBER            -- 주문 수
);

/* 주문번호(ODNUM) 컬럼에 PK 부여*/
ALTER TABLE ORDERLIST
ADD CONSTRAINT PK_ODNUM PRIMARY KEY(ODNUM);
/* 주문자와 상품코드에 FK 부여 */
ALTER TABLE ORDERLIST
ADD CONSTRAINT FK_ODMID FOREIGN KEY(ODMID) REFERENCES MEMBERS(MID);

ALTER TABLE ORDERLIST
ADD CONSTRAINT FK_ODPDCODE FOREIGN KEY(ODPDCODE) REFERENCES PRODUCT(PDCODE);

SELECT * FROM PRODUCT;
SELECT * FROM ORDERLIST;

SELECT * FROM PRODUCT
WHERE PDTYPE = '식품';

/* 1. 회원가입 >> 2. 로그인 >> 3. 상품목록조회 >> 4. 상품상세페이지 >> 5. 주문요청 >> 6. 주문정보 저장 */

-- 1. 아이디 중복체크
SELECT * FROM MEMBERS
WHERE MID = 'ADFG';
-- 2. 사용가능 아이디로 확인 되면 회원정보를 INSERT
INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MDATE, MEMAIL)
VALUES('jgm', '1234', '정균민', '남', TO_DATE('1996-08-12', 'YYYY-MM-DD'), 'cnxw4@naver.com');
COMMIT;
SELECT * FROM MEMBERS;
-- 3. 회원가입이 완료되었습니다.

/* [2]로그인 */
-- 1. 사용자로부터 아이디, 비밀번호를 입력 받는다.
-- 2. 아이디, 비밀번호가 일치하는 회원정보가 있는지 확인
SELECT * FROM MEMBERS
WHERE MID = 'jgm' AND MPW = '1234';
-- 3. 회원정보가 확인되면 '로그인' 처리

/* [3]상품목록 조회 */
-- PRODUCT 테이블에서 상품의 정보를 조회 >> 출력
SELECT PDCODE, PDNAME, PDPRICE
FROM PRODUCT;

/* [4]상품상세페이지 */
/* 
상품이름 : 제로사이다
상품가격 : 2000원
재고 : 123개 남음

사용자는 수량 선택 >> 구매하기 버튼 클릭 >> 주문 요청 >> 주문정보 테이블에 주문 정보를 INSERT
*/

-- 주문번호, 주문자 아이디, 주문일, 주문한 상품코드, 주문수량
/* 주문번호 : 자동 생성 */
SELECT NVL(MAX(ODNUM), 0)
FROM ORDERLIST;
SELECT * FROM ORDERLIST; -- 현재 주문번호의 최대값
-- 새 주문번호는 최대값 + 1
/* 주문자 아이디 : 로그인된 회원의 아이디 */
/* 주문일 : SYSDATE */
/* 주문한 상품코드 : 선택한 상품코드 */
/* 주문수량 : 사용자가 입력한 값 */
-- 로그인된 아이디 'jgm', 상품코드 : P1234, 주문수량 3
INSERT INTO ORDERLIST(ODNUM, ODMID, ODDATE, ODPDCODE, ODQTY)
VALUES((SELECT NVL(MAX(ODNUM), 0) + 1 FROM ORDERLIST), 'jgm', SYSDATE, 'P1234', 3);

INSERT INTO ORDERLIST(ODNUM, ODMID, ODDATE, ODPDCODE, ODQTY)
VALUES((SELECT NVL(MAX(ODNUM), 0) + 1 FROM ORDERLIST), 'jgm', SYSDATE, 'P0012', 3);

INSERT INTO ORDERLIST(ODNUM, ODMID, ODDATE, ODPDCODE, ODQTY)
VALUES((SELECT NVL(MAX(ODNUM), 0) + 1 FROM ORDERLIST), 'jgm', SYSDATE, 'P3030', 3);
COMMIT;

/* 구매된 상품의 재고 수정 */

SELECT * FROM ORDERLIST;
SELECT * FROM PRODUCT;
SELECT * FROM MEMBERS;

UPDATE PRODUCT
SET PDAMOUNT = PDAMOUNT - (SELECT ODQTY
                           FROM ORDERLIST
                           WHERE ODPDCODE = 'P1234')
WHERE PDCODE = 'P1234';
ROLLBACK;

-- 주문내역 조회
-- 주문자, 상품명, 가격, 주문수 , 결제금액, 주문일
SELECT M.MNAME AS 주문자, P.PDNAME AS 상품명, P.PDPRICE AS 가격,
O.ODQTY AS 주문수, P.PDPRICE * O.ODQTY AS 결제금액, TO_CHAR(O.ODDATE, 'YYYY-MM-DD') AS 주문일
FROM MEMBERS M, PRODUCT P, ORDERLIST O
WHERE (M.MID = O.ODMID) AND (P.PDCODE = O.ODPDCODE);





























































































