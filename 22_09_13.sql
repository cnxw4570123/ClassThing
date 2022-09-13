/* 22-09-13 */
SELECT * FROM EMP;
SELECT * FROM DEPT;

/* JOIN : 두개 이상의 테이블을 연결하여 데이터를 조회 */

SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

/* 부서명이 'REASEARCH' 인 직원 정보 조회 */

SELECT *
FROM DEPT, EMP
WHERE EMP.DEPTNO = DEPT.DEPTNO AND DEPT.DNAME = 'RESEARCH';

SELECT *
FROM EMP INNER JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO
WHERE DEPT.DNAME = 'RESEARCH';

SELECT EMP.*, DEPT.LOC
FROM EMP INNER JOIN DEPT ON DEPT.DNAME = 'RESEARCH'
WHERE DEPT.DEPTNO = EMP.DEPTNO;

-- 직원이름이 'MARRTIN'인 직원의 직원 번호, 직원이름, 부서명, 부서위치
SELECT EMP.EMPNO, EMP.ENAME, DEPT.DNAME, DEPT.LOC
FROM EMP, DEPT
WHERE (EMP.DEPTNO = DEPT.DEPTNO) AND EMP.ENAME = 'MARTIN';

-- 부서위치가 'NEW YORK'인 직원들의 이름, 직무 조회
SELECT EMP.ENAME, EMP.JOB
FROM EMP, DEPT
WHERE (EMP.DEPTNO = DEPT.DEPTNO) AND DEPT.LOC = 'NEW YORK';

SELECT EMP.ENAME, EMP.JOB
FROM EMP INNER JOIN DEPT ON DEPT.LOC = 'NEW YORK'
WHERE (EMP.DEPTNO = DEPT.DEPTNO);

-- COMM이 있는 직원의 이름, 부서명 조회
SELECT EMP.ENAME, DEPT.DNAME
FROM EMP, DEPT
WHERE (EMP.DEPTNO = DEPT.DEPTNO) AND EMP.COMM IS NOT NULL;

-- OUTER JOIN 겹치지 않는 부분만 보여줌.

-- 각 부서별 인원수

SELECT EMP.DEPTNO, DEPT.DNAME, COUNT(*)
FROM EMP, DEPT
WHERE (EMP.DEPTNO = DEPT.DEPTNO)
GROUP BY EMP.DEPTNO, DEPT.DNAME;


SELECT EMP.DEPTNO, DEPT.DNAME
FROM DEPT
LEFT OUTER JOIN ( SELECT EMP.DEPTNO, COUNT(*) AS DEPTCOUNT
                  FROM EMP
                  GROUP BY EMP.DEPTNO ) EMP
ON DEPT.DEPTNO = EMP.DEPTNO;

-- 부서위치(DEPT.LOC)가 'NEW YORK'인 직원들의 이름(EMP.ENAME), 직무(ENAME.JOB) 조회
-- JOIN 없이 사용

SELECT EMP.ENAME, EMP.JOB
FROM EMP
WHERE EMP.DEPTNO = (SELECT DEPTNO
                    FROM DEPT
                    WHERE LOC = 'NEW YORK');

SELECT DEPTNO
FROM DEPT
WHERE LOC = 'NEW YORK'; -- 결과: 부서번호 10번

SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 10;

SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                FROM DEPT);

-- ORA-01722: 수치가 부적합합니다
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DNAME
                FROM DEPT);

-- ORA-00913: 값의 수가 너무 많습니다
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO, DNAME
                FROM DEPT
                WHERE LOC = 'NEW YORK');
                
-- 'KING'과 같은 부서에서 근무하는 직원들의 이름, 직무 조회
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM EMP
                WHERE ENAME = 'KING');
-- 급여가 1500인 직원과 같은 직무의 직원들의 이름 조회
SELECT ENAME
FROM EMP
WHERE JOB = (SELECT JOB
             FROM EMP
             WHERE SAL = 1500);

SELECT JOB, COUNT(*)
FROM EMP
WHERE JOB = (SELECT JOB
             FROM EMP
             WHERE SAL = 1500)
GROUP BY JOB;

-- 급여가 1500인 직원과 다른 직무의 직원들의 이름 조회

SELECT ENAME
FROM EMP
WHERE JOB NOT IN (SELECT JOB
             FROM EMP
             WHERE SAL = 1500);

SELECT E.ENAME
FROM EMP E
WHERE JOB != 'SALESMAN';

/* 급여가 1000 미만인 직원 근무하는 부서의 직원이름, 급여, 부서번호 조회 */
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                 FROM EMP
                 WHERE SAL <= 1000)
ORDER BY DEPTNO DESC, SAL DESC;

/* 급여가 1000 미만인 직원 근무하는 부서의 부서번호 및 부서별 인원수 조회 */
SELECT DEPTNO, COUNT(*)
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                FROM EMP
                WHERE SAL <= 1000)
GROUP BY DEPTNO;

/* 평균 급여가 2000이상인 부서의 부서이름, 위치 조회 */
SELECT DNAME, LOC
FROM DEPT 
WHERE DEPTNO IN (SELECT DEPTNO
                   FROM EMP
                   GROUP BY DEPTNO
                   HAVING AVG(SAL) >= 2000);

SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000;
/* 급여를 3000이상 받는 직원과 같은 부서에서 근무하는 직원이름, 급여, 부서이름 조회 */
SELECT E.ENAME, E.SAL, D.DNAME
FROM EMP E, DEPT D
WHERE (E.DEPTNO = D.DEPTNO) AND  E.DEPTNO IN (SELECT DEPTNO
                                              FROM EMP
                                              WHERE SAL >= 3000);











































