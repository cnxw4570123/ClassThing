-- 한줄 주석
/*
여러줄
주석
*/

-- 계정 생성
-- CREATE USER 아이디 IDENTIFIED BY "비밀번호";
-- 공통 사용자 해제
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER c##TESTID IDENTIFIED BY "1111"; --F9

CREATE USER TESTID02 IDENTIFIED BY "1111";

-- JGM_DEV 계정 생성
CREATE USER JGM_DEV IDENTIFIED BY "1111";

-- JGM_DEV 계정 DB 접속 시도 - 접속 권한 X
-- 관리자 계정으로 JGM_DEV 계정 접속권한 부여
-- GRANT 부여할 권한 TO 계정명;
GRANT CREATE SESSION TO JGM_DEV;