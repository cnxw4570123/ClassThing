-- 한줄 주석
/*
여러줄
주석
*/

-- 계정 생성
-- CREATE USER 아이디 IDENTIFIED BY "비밀번호";
-- 공통 사용자 해제
ALTER SESSION SET "_ORACLE_SCRIPT" =TRUE;
CREATE USER c##TESTID IDENTIFIED BY "1111"; --F9

CREATE USER TESTID02 IDENTIFIED BY "1111";

-- JGM_DEV 계정 생성
CREATE USER JGM_DEV IDENTIFIED BY "1111";

-- JGM_DEV 계정 DB 접속 시도 - 접속 권한 X
-- 관리자 계정으로 JGM_DEV 계정 접속권한 부여
-- GRANT 부여할 권한 TO 계정명;
GRANT CREATE SESSION TO JGM_DEV;

CREATE USER TESTID02 IDENTIFIED BY "1111";

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER JGM_DEV IDENTIFIED BY "1111";

/* 계정 생성 >> 권한 부여 */

/* 권한 회수 >> 계정 삭제 */
REVOKE CREATE SESSION FROM JGM_DEV;
-- REVOKE 성공

/* 계정 삭제*/
DROP USER JGM_DEV;
-- 삭제후 접속 시도 >> 상태: -테스트 실패: ORA-01017: 사용자명/비밀번호가 부적합, 로그온할 수 없습니다. 


-- 계정 생성 >> 개발자 계정에 접속 권한 부여
-- 개발자 계정으로 접속 >> 테이블 생성.
/* 1. 개발자 계정 생성*/
CREATE USER JGM_DEV IDENTIFIED BY "1111"; --관리자 계정으로 실행

/* 2. 접속 권한 부여*/
GRANT CREATE SESSION TO JGM_DEV; -- 관리자 계정으로 실행
/* 3. 개발자 계정으로 접속*/
/* 4. 테이블 생성*/
CREATE TABLE TEST_TBL(
    TEST_COL1 NUMBER,
    TEST_COL2 NVARCHAR2(5)
);


GRANT CREATE TABLE TO JGM_DEV;
/* 개발자 계정으로 접속  */
CREATE TABLE TEST_TBL(
    TEST_COL1 NUMBER,
    TEST_COL2 NVARCHAR2(5)
);
INSERT INTO TEST_TBL VALUES(100, '테스트'); -- JGM_DEV 계정으로 실행
    -- ORA-01950: 테이블스페이스 'USERS'에 대한 권한이 없습니다.
    
/* 8. JGM_DEV 계정에 테이블스페이스 'USERS'에 대한 권한 부여*/

-- alter user jgm_dev identified by "1234"; 비밀번호 변경

ALTER USER JGM_DEV
QUOTA UNLIMITED ON USERS;

/* 9. 생성된 테이블에 데이터 입력 재시도*/
INSERT INTO TEST_TBL VALUES(100, '테스트'); -- JGM_DEV 계정으로 실행
    -- 1 행 이(가) 삽입되었습니다.
    
COMMIT; -- JGM_DEV 계정으로 실행
    -- 커밋 완료
    
/* 관리자 계정으로 접속 */
/* JGM_DEV2 계정 생성 */

CREATE USER JGM_DEV2 IDENTIFIED BY "1111"
QUOTA UNLIMITED ON USERS;

/* 권한 부여(접속, 테이블 생성)*/
GRANT CREATE SESSION, CREATE TABLE TO JGM_DEV2;

CREATE TABLE TEST_TBL2(
    TEST_COL1 NUMBER
);

COMMIT;

/* 관리자 계정으로 접속, JGM_DEV, JGM_DEV2 */
ALTER USER JGM_DEV
QUOTA 0 ON USERS; -- 관리자 계정으로 실행

/* ROLE */

CREATE USER JGM_DEV3 IDENTIFIED BY "1111"
QUOTA UNLIMITED ON USERS; -- 관리자 계정으로 실행

GRANT CONNECT TO JGM_DEV3; --CONNECT :: CREATE SESSION
GRANT RESOURCE TO JGM_DEV3; -- RESOURCE

--JGM_DEV3으로 접속
CREATE TABLE TEST_TBL(
    TEST_COL1 NUMBER,
    TEST_COL2 NVARCHAR2(5)
);
INSERT INTO TEST_TBL VALUES(100, '테스트');

/* 관리자 권한으로 */
SELECT * FROM DBA_SYS_PRIVS
WHERE GRANTEE = 'RESOURCE';

/* JGM_DEV 계정 삭제 */
DROP USER JGM_DEV CASCADE;
DROP USER JGM_DEV2 CASCADE;
DROP USER JGM_DEV3 CASCADE;

/* JGM_DBA 계정 생성 */
CREATE USER JGM_DBA IDENTIFIED BY "1111";
GRANT DBA TO JGM_DBA;

/* JGM_DBA 계정으로 접속 */

CREATE TABLE TEST_TBL(
    TEST_COL NUMBER
);
INSERT INTO TEST_TBL VALUES(100);
