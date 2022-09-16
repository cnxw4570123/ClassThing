/* 22-09-14 */
/* UPDATE : 데이터 수정 */
SELECT* FROM EMP;
SELECT* FROM DEPT;
INSERT INTO EMP VALUES(8000, '정균민', 'SALESMAN', 7698,SYSDATE,2000,1000, 30);
COMMIT;
/*
UPDATE 테이블명
SET 컬럼명 수정할 값
WHERE 수정할 레코드를 지정하기위한 조건
*/

UPDATE EMP
SET SAL = 5000; -- 13개 행 이(가) 업데이트되었습니다.
ROLLBACK;

UPDATE EMP
SET SAL = 3000
WHERE JOB = 'SALESMAN';

-- 직원 이름이 'FORD' 인 직원의 급여를 3500으로 수정
UPDATE EMP
SET SAL = 3500
WHERE ENAME = 'FORD';
COMMIT;


-- COMM이 있는 직원들의 COMM 값을 1000으로 수정
UPDATE EMP
SET COMM = 1000
WHERE COMM IS NOT NULL;

-- 직무가 'MANAGER' 직원의 급여를 500인상
UPDATE EMP
SET SAL = SAL + 500
WHERE JOB = 'MANAGER';
ROLLBACK;
SELECT * FROM EMP
WHERE JOB = 'MANAGER';

-- 이름이 'FORD'인 직원과 같은 부서에서 근무하는 직원들의 급여를 1200인상

UPDATE EMP
SET SAL = SAL + 1200
WHERE DEPTNO = (SELECT DEPTNO
                FROM EMP
                WHERE ENAME = 'FORD');
                
/* DELETE : 데이터 삭제 */
/*
DELETE FROM 테이블명
WHERE 삭제할 레코드를 지정하기 위한 조건
*/

DELETE FROM EMP;
SELECT * FROM EMP;
ROLLBACK;

-- 부서번호가 30번인 직원들 삭제
DELETE FROM EMP
WHERE DEPTNO = 30;

-- 부서번호 10을 부서번호 50으로 수정
UPDATE DEPT
SET DEPTNO = 50
WHERE DEPTNO = 10;
-- ORA-02292: 무결성 제약조건(SYS.FK_DEPTNO)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE DEPT
WHERE DEPTNO = 10;
-- ORA-02292: 무결성 제약조건(SYS.FK_DEPTNO)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE FROM DEPT
WHERE DEPTNO = 40;
ROLLBACK;

-- 전체 직원의 평균 급여보다 적은 급여를 받는 직원들의 정보를 삭제
DELETE FROM EMP
WHERE SAL < (SELECT AVG(SAL)
             FROM EMP);
             

/* 계좌 정보 테이블 */
CREATE TABLE BANKINFO(
    ACCOUNT_NUMBER NVARCHAR2(10), -- 계좌번호
    CLIENT_NAME NVARCHAR2(5), -- 고객명
    BALANCE NUMBER -- 잔액
);

ALTER TABLE BANKINFO
ADD CONSTRAINT PK_ACCNUM PRIMARY KEY(ACCOUNT_NUMBER);
ALTER TABLE BANKINFO
MODIFY CLIENT_NAME NOT NULL;

/* [1] 계좌생성 - BANKINFO테이블에 INSERT */
-- ** 계좌번호 중복확인
-- 1. 사용자로 부터 계좌번호 입력 받는다. '11-11'
/* 계좌 번호 중복 확인을 위한 SQL 작성 */
SELECT *
FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';

-- 조회되는 레코드가 있을 경우 >> 계좌번호 중복
-- 조회되는 레코드가 없을 경우 >> 사용가능한 계좌번호

-- 2. 사용자로부터 이름과 초기 금액을 입력받는다. 
-- 이름 : 'ABC', 초기금액 : 10000원

-- 3. 계좌정보를 INSERT
INSERT INTO BANKINFO VALUES('11-11', 'ABC', 10000);

/* [2] 입금 - UPDATE문 */
-- 1. 사용자로 부터 입금할 계좌번호를 입력받는다. >> '11-11';
-- 2. 등록된 계좌번호인지 확인 처리
SELECT *
FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';
/* 조회되는 레코드가 있을 경우 >> 입금처리 진행
   조회되는 레코드가 없을 경우 >> '없는 계좌입니다' 입금처리 중단 */

-- 3. 계좌번호가 확인되면
--    사용자로부터 입금할 금액을 입력 받는다. >> 20000원

-- 4. 해당 계좌에 입금 처리
UPDATE BANKINFO
SET BALANCE = BALANCE + 20000
WHERE ACCOUNT_NUMBER = '11-11';
-- 1 행 이(가) 업데이트되었습니다.
COMMIT;

-- 5. 입금처리 후 잔액 확인
SELECT BALANCE
FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';

/* [3] 출금 - UPDATE */
-- 1. 사용자로부터 출금하고자 하는 계좌번호를 입력받는다. >> '11-11'
-- 2. 등록된 계좌번호인지 확인 처리
SELECT *
FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';
/* 조회되는 레코드가 있을 경우 >> 출금처리 진행
   조회되는 레코드가 없을 경우 >> '없는 계좌입니다' 출금처리 중단 */
-- 출금 금액이 충분한지 확인
-- 3. 계좌번호가 확인 되면
--    사용자로부터 출금할 금액을 입력받는다. >> 50000원
SELECT BALANCE
FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';


-- 4. 현재 잔액 >= 출금액 :: 출금 UPDATE
UPDATE BANKINFO
SET BALANCE = BALANCE - 50000
WHERE ACCOUNT_NUMBER = '11-11'; 
--    현재 잔액 <  출금액 :: '잔액이 부족합니다' 출금처리 중단
UPDATE BANKINFO
SET BALANCE = BALANCE - 50000
WHERE ACCOUNT_NUMBER = '11-11' AND BALANCE >= 50000;

-- 5. 출금처리 후 잔액 확인
SELECT BALANCE FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';

/* [4] 잔액 - SELECT */
-- 1. 사용자로부터 잔액조회할 계좌번호를 입력받는다. >> '11-11'
-- 2. 등록된 계좌번호 인지 확인 처리
SELECT * FROM BANKINFO
WHERE ACCOUNT_NUMBER = '11-11';
/* 조회되는 레코드가 있을 경우 >> BALANCE 컬럼 값 출력
   조회되는 레코드가 없을 경우 >> '없는 계좌입니다' 중단 */

/* 회원제 쇼핑몰 */

/* 상품정보 테이블 - PRODUCT */
CREATE TABLE PRODUCT(
    PDCODE NCHAR(5),      -- 상품코드
    PDNAME NVARCHAR2(30), -- 상품이름
    PDPRICE NUMBER,       -- 상품가격
    PDAMOUNT NUMBER,      -- 상품수량
    PDTYPE NVARCHAR2(10)  -- 상품종류
);
DROP TABLE PRODUCT;
-- PRIMARY KEY - 상품코드
ALTER TABLE PRODUCT
ADD CONSTRAINT PK_PDCODE PRIMARY KEY(PDCODE);

-- 상품코드:'P0001', 상품이름:펩시제로콜라, 1500, 50개, 탄산음료
-- 상품코드:'P0002', 상품이름:제로사이다, 1300, 30개, 탄산음료

INSERT INTO PRODUCT VALUES('P0001', '펩시제로콜라', 1500, 50, '탄산음료');
INSERT INTO PRODUCT(PDCODE) VALUES('A0001');

/* CHECK PDCODE컬럼의 첫글자는 'P'를 사용 */
ALTER TABLE PRODUCT
ADD CONSTRAINT CK_PDCODE CHECK( SUBSTR(PDCODE,0,1) = 'P' );
ROLLBACK;
ALTER TABLE PRODUCT
MODIFY PDNAME NOT NULL;
ALTER TABLE PRODUCT
MODIFY PDPRICE NOT NULL;
ALTER TABLE PRODUCT
MODIFY PDAMOUNT NOT NULL;
ALTER TABLE PRODUCT
MODIFY PDTYPE NOT NULL;

SELECT * FROM PRODUCT;

INSERT INTO YKD_DBA.PRODUCT VALUES('P1001', '아이스티레몬', 1200, 20, '음료');
INSERT INTO YKD_DBA.PRODUCT VALUES('P1002', '아이스티복숭아', 1200, 30, '음료');
INSERT INTO YKD_DBA.PRODUCT VALUES('P2301', '모두의 아두이노', 15000, 5, '책');
COMMIT;
SELECT * FROM YKD_DBA.PRODUCT;

UPDATE YKD_DBA.PRODUCT
SET PDPRICE = 500000
WHERE PDCODE = 'P0831';
COMMIT;


















































