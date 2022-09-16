/* 2022-09-08 */

/*  */
-- COMM 컬럼이 NULL이 아닌 직원들의 정보 조회

SELECT *
FROM EMP
WHERE COMM IS NOT NULL;

SELECT *
FROM EMP
WHERE DEPTNO != 30;

-- 직무가 SALESMAN이거나 MANAGER인 직원들의 정보를 조회

SELECT *
FROM EMP
WHERE JOB = 'SALESMAN' OR JOB = 'MANAGER';


SELECT *
FROM EMP
WHERE JOB IN('SALESMAN', 'MANAGER');

SELECT *
FROM EMP
WHERE DEPTNO NOT IN(20, 10);

-- 직무가 SALESMAN이거나 MANAGER인 직원들 중에서 급여가 2500이상인 직원들의 정보를 조회

-- 직무가 SALESMAN인 직원들 + 직무가 MANAGER이면서 급여가 2500이상인 직원들
SELECT *
FROM EMP
WHERE (JOB = 'SALESMAN' OR JOB = 'MANAGER') AND SAL >= 2500;

SELECT *
FROM EMP
WHERE (JOB IN ('SALESMAN', 'MANAGER')) AND SAL >= 2500;

/* 그룹함수
   COUNT, SUM, AVG, MAX, MIN
*/

/* COUNT */
-- EMP 전체 직원의 수
SELECT COUNT(JOB)
FROM EMP;

SELECT ENAME
FROM EMP;

SELECT COUNT(ENAME)
FROM EMP;

/* SUM */
-- 직원들의 급여 총합

SELECT SUM(SAL)
FROM EMP;

/* AVG */

SELECT AVG(SAL)
FROM EMP;


/* MAX, MIN */
SELECT MAX(SAL)
FROM EMP;

SELECT MIN(SAL)
FROM EMP;


-- 부서별 인원수
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO;

-- 직무별 인원수
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
ORDER BY COUNT(*) ASC;

-- 부서별 급여의 총합
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

SELECT DEPTNO
FROM EMP;

SELECT SUM(SAL)
FROM EMP;

SELECT DEPTNO, SUM(SAL)
FROM EMP;
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다

-- 부서별 직무별 인원수

SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO DESC;

-- 부서별 직무별 인원수 및 급여의 총합 3000이상
SELECT DEPTNO, JOB, COUNT(*), SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING SUM(SAL) >= 3000;

-- GROUP -> 게시판 만들어서 작성을 하면 카테고리별로 나눠지는 테이블 만들 수도 있지만
-- 전체 게시판만들고 카테고리 별로 그룹 짜서하는 경우도 있다.
-- WHERE나 GROUP 사용
-- 상품 판매 -> COUNT로 인기 상품 순으로 정렬

/* 평균 급여가 3000 이상인 직무 조회 */
SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) >= 3000;

/* 직원수가 3명 이상인 직무 조회 */
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
HAVING COUNT(*) >= 3;

-- 직무별 최소 급여 조회 - 'PRESIDENT' 제외

SELECT JOB AS 직무, MIN(SAL) AS 최소금액
FROM EMP
WHERE JOB != 'PRESIDENT'
GROUP BY JOB;

SELECT JOB AS 직무, MIN(SAL) AS 최소금액
FROM EMP
GROUP BY JOB
HAVING JOB != 'PRESIDENT';

SELECT JOB AS 직무, MIN(SAL) AS 최소금액
FROM EMP
WHERE JOB != 'PRESIDENT'
GROUP BY JOB
HAVING MIN(SAL) >1000
ORDER BY JOB DESC;

-- 입사 연도월별 직원 수
SELECT TO_CHAR(HIREDATE,'YYYY-MM'), COUNT(*)||'명'
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
ORDER BY TO_CHAR(HIREDATE, 'YYYY-MM') ASC;


/* ORDER BY 정렬 */
SELECT *
FROM EMP
ORDER BY DEPTNO DESC, SAL DESC;

/* 직무가 'SALESMAN'이 아닌 직원들을 대상으로
직무별 급여 합계가 5000이상인 직무와 급여의 합계 조회
급여의 총합을 기준으로 내림차순 정렬 */

SELECT JOB AS 직무, SUM(SAL) AS "급여 합계"
FROM EMP
WHERE JOB NOT IN('SALESMAN')
GROUP BY JOB
HAVING SUM(SAL) >= 5000
ORDER BY SUM(SAL) DESC;


/* 직무별 평균 연봉, 직원수 조회
단 평균 연봉이 20000이상인 직무 그룹만 조회
평균 연봉을 기준으로 오름차순 정렬 */

SELECT JOB AS 직무, AVG(SAL * 12) AS "평균 연봉", COUNT(*)||'명' AS "직원 수"
FROM EMP
GROUP BY JOB
HAVING AVG(SAL * 12) >= 20000
ORDER BY AVG(SAL * 12) DESC;

SELECT TO_CHAR(HIREDATE,'YYYY')||'년 ' ||TO_CHAR(HIREDATE,'MM')||'월'
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY')||'년 '||TO_CHAR(HIREDATE,'MM')||'월' 
ORDER BY TO_CHAR(HIREDATE,'YYYY')||'년'||TO_CHAR(HIREDATE,'MM')||'월' ASC;





















