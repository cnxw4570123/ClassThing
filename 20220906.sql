CREATE TABLE CHECK_BOOL(
    TEST_COL1 NUMBER(1) CONSTRAINT Ck_TEST_COL1 CHECK(TEST_COL1 = 1 OR TEST_COL1 = 0)
);
INSERT INTO CHECK_BOOL VALUES(1);

SELECT * FROM CHECK_BOOL;

DROP TABLE CHECK_BOOL;

SELECT * FROM YKD_DBA.STUINFO;

CREATE TABLE STUINFO(
    TEST_COL1 NVARCHAR2(5),
    TEST_COL2 NVARCHAR2(13)
);

DROP TABLE STUINFO;

CREATE TABLE MEMBER_TEST(
    MID NVARCHAR2(5),
    MPW NVARCHAR2(5),
    MNAME NVARCHAR2(5),
    MGENDER NUMBER(1),
    MBIRTH DATE,
    MEMAIL NVARCHAR2(13)
);

ALTER TABLE MEMBER_TEST ADD CONSTRAINT PK_MID PRIMARY KEY(MID);

/* 22/09/06 */
/* FORIEGN KEY(외래키)
    : 서로 다른 테이블간의 관계를 정의하는데 사용
    : 특정한 테이블에서 PRIMARY KEY 또는 UNIQUE가 부여된 컬럼을
      다른 테이블의 특정한 컬럼에서 참조

*/

SELECT * FROM MEMBER_TEST;

INSERT INTO MEMBER_TEST VALUES('ABCD', '1111', '정균민', 1, '1996-08-12','cnxw4@naver.com');
INSERT INTO MEMBER_TEST VALUES('ABCE', '1111', '심준호', 1, '1996-08-12','cnxw4@naver.com');
INSERT INTO MEMBER_TEST VALUES('ABCF', '1111', '양현석', 1, '1996-08-12','cnxw4@naver.com');

ALTER TABLE MEMBER_TEST MODIFY MEMAIL NVARCHAR2(50);

COMMIT;

CREATE TABLE SCORE_TEST(
    SCMID NVARCHAR2(20), -- MEMBER_TEST MID 컬럼 참조
    SCSUBJECT NVARCHAR2(10),
    SCSCORE NUMBER
);

SELECT * FROM MEMBER_TEST;

INSERT INTO SCORE_TEST VALUES ('ABCD', 'JAVA', 80);

SELECT * FROM SCORE_TEST;
INSERT INTO SCORE_TEST VALUES ('ABCZ', 'JAVA', 80);

DELETE SCORE_TEST WHERE SCMID = 'ABCZ';

/* FOREIGN KEY 
    SCORE_TEST SCMID 컬럼은 MEMBER_TEST의 MID 컬럼을 참조
*/

ALTER TABLE SCORE_TEST
ADD CONSTRAINT FK_SCMID FOREIGN KEY(SCMID)  REFERENCES MEMBER_TEST(MID);

INSERT INTO SCORE_TEST(SCMID, SCSUBJECT, SCSCORE)
VALUES ('ABCD', 'JAVA', 80);

INSERT INTO SCORE_TEST VALUES ('ABCZ', 'ORACLE', 100);



/* 상품정보 테이블, 주문내역 테이블 */

/* PRODUCT TABLE */
CREATE TABLE PRODUCT(
    PRNUM NUMBER,
    PRNAME NVARCHAR2(20),
    PRPRICE NUMBER,
    PRAMOUNT NUMBER,
    PRTYPE NVARCHAR2(10)
);

DROP TABLE PRODUCT;
/* 제약조건 부여 */
ALTER TABLE PRODUCT
ADD CONSTRAINT PK_PRNUM PRIMARY KEY(PRNUM);
/* 상품정보 등록 */
INSERT INTO PRODUCT(PRNUM,PRNAME, PRPRICE, PRAMOUNT, PRTYPE)
VALUES (1, '콜라', 1500, 20, '음료');
INSERT INTO PRODUCT(PRNUM,PRNAME, PRPRICE, PRAMOUNT, PRTYPE)
VALUES (2, '사이다', 1300, 10, '음료');
INSERT INTO PRODUCT(PRNUM,PRNAME, PRPRICE, PRAMOUNT, PRTYPE)
VALUES (3, '꼬북칩', 1500, 20, '과자');
INSERT INTO PRODUCT(PRNUM,PRNAME, PRPRICE, PRAMOUNT, PRTYPE)
VALUES (4, '빈츠', 2500, 20, '과자');
INSERT INTO PRODUCT(PRNUM,PRNAME, PRPRICE, PRAMOUNT, PRTYPE)
VALUES (5, '바나나킥', 2000, 20, '과자');
SELECT * FROM PRODUCT;
COMMIT;

/* ORDERLIST TABLE(주문내역) */
CREATE TABLE ORDERLIST(
    ODNUM NUMBER,          -- 주문번호
    ODPEOPLE NVARCHAR2(5), -- 주문자
    ODPRNUM  NUMBER,       -- 상품번호(PRODUCT테이블의 PRNUM 참조)
    ODQTY NUMBER,          -- 주문수
    ODDATE DATE            -- 주문일
);

ALTER TABLE ORDERLIST
ADD CONSTRAINT FK_ODPRNUM FOREIGN KEY(ODPRNUM) REFERENCES PRODUCT(PRNUM);
    
INSERT INTO ORDERLIST(ODNUM, ODPEOPLE, ODPRNUM, ODQTY, ODDATE)
VALUES(1, '정균민', 1, 5, SYSDATE);

INSERT INTO ORDERLIST(ODNUM, ODPEOPLE, ODPRNUM, ODQTY, ODDATE)
VALUES(2, '이현우', 3, 2, SYSDATE);

INSERT INTO ORDERLIST(ODNUM, ODPEOPLE, ODPRNUM, ODQTY, ODDATE)
VALUES(3, '최준영', 4, 1, SYSDATE);

SELECT * FROM ORDERLIST;

/* 주문내역 조회 */
SELECT *
FROM ORDERLIST, PRODUCT
WHERE ORDERLIST.ODPRNUM = PRODUCT.PRNUM;
/* PRODUCT테이블 삭제 시도  */
DROP TABLE PRODUCT;
-- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
/* PRODUCT테이블 데이터 삭제 시도  */
DELETE FROM PRODUCT;
-- ORA-02292: 무결성 제약조건(JGM.FK_ODPRNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다

/*
DEFAULT : 컬럼에 입력되는 데이터가 없어도 미리 설정된 값으로 자동 입력
CHECK : 특정한 범위의 값만 입력 가능하도록 하는 제약
*/

CREATE TABLE DEFAULT_TEST(
    MID NVARCHAR2(5),
    MPW NVARCHAR2(10)
);

INSERT INTO DEFAULT_TEST(MID)
VALUES('AA');
-- 1 행 이(가) 삽입되었습니다. MPW컬럼 값은 NULL 입력

SELECT * FROM DEFAULT_TEST;

ALTER TABLE DEFAULT_TEST
MODIFY MPW DEFAULT '1234';
INSERT INTO DEFAULT_TEST(MID)
VALUES('BB');
INSERT INTO DEFAULT_TEST(MID, MPW)
VALUES('CCC', DEFAULT);
SELECT *FROM DEFAULT_TEST;

CREATE TABLE CHECK_TEST(
    MID NVARCHAR2(5),
    MPW NVARCHAR2(10)
);
/* 비밀번호는 최소 4자리 이상 */
ALTER TABLE CHECK_TEST
ADD CONSTRAINT CK_MPW CHECK(LENGTH(MPW) >= 4 );

INSERT INTO CHECK_TEST(MID, MPW) VALUES('WWWW', '123');

/*
데이터 입력 페이지에서 데이터 입력 >> 데이터베이스로 전송

회원가입 페이지
회원 정보 입력 >> 입력한 회원 정보 DB 전송 >> INSERT문 수행 >> ORA-02290: 체크 제약조건(JGM.CK_MPW)이 위배되었습니다

회원가입 페이지에서
회원 정보 입력 비밀번호 자리수가 부족 회원 정보 DB 전송 중지


*/