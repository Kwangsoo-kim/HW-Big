-- [III] JOIN  : 테이블을 2개 이상 연결하여 검색
SELECT *FROM EMP WHERE ENAME ='SCOTT';          -- 부서번호 : 20

SELECT * FROM DEPT;

-- CROSS JOIN(FROM절에 테이블 2개 이상, 조건없이 출력)
SELECT *FROM EMP,DEPT  WHERE ENAME ='SCOTT';

-- EQUI JOIN (공통 필드인 DEPTNO 값이 일치되는 조건만 JOIN) 
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;

SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;

-- 모든 사원의 이름, 부서명, 부서번호 출력
-- 테이블 엘리아스(별명)을 쓰면 무조건 엘리아스를 사용해야함. 컬럼이 겹칠때는 한 테이블의 귀속임을 나타내 주어야함.
SELECT ENAME "NAME",DNAME,E.DEPTNO FROM EMP E,DEPT D  WHERE E.DEPTNO=D.DEPTNO;

-- 중복 테이블 안봅는법
SELECT E. *,DNAME,LOC  FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;

-- 사번, 이름 ,부서번호 , 부서이름 , 근무지
SELECT EMPNO, ENAME, E.DEPTNO,DNAME,LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO;

-- 급여가 2000이상인 직원의 이름, 업무 , 급여, 부서명, 근무지 출력
SELECT ENAME,JOB,SAL,DNAME,LOC FROM EMP E,DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;

-- LOC이 CHICAGO 인 사원의 이름, 업무 , 부서명 ,근무지 출력
SELECT ENAME,JOB,DNAME,LOC FROM EMP E,DEPT D 
        WHERE E.DEPTNO = D.DEPTNO AND LOC='CHICAGO';

-- 부서번호가 10 또는 20인 사원의 이름, 업무, 근무지 출력(급여순)
SELECT ENAME,JOB,LOC FROM EMP E,DEPT D 
        WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10,20) 
        ORDER BY SAL;

-- 이름,급여,상여,연봉((급여+COMM)*12), 부서명, 근무지 출력
SELECT ENAME, SAL ,COMM,(SAL+NVL(COMM,0))*12 연봉,DNAME,LOC FROM EMP E,DEPT D 
        WHERE E.DEPTNO = D.DEPTNO;

--  JOB이 SALESMAN이고 또는 MANAGER 인 사원의 이름,급여,상여,연봉((급여+COMM)*12), 부서명, 근무지 출력(연봉이 큰 순)
SELECT ENAME,SAL,COMM,(SAL+NVL(COMM,0))*12 연봉, DNAME, LOC FROM EMP E, DEPT D 
        WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') 
        ORDER BY 연봉 DESC;

-- COMM이 NULL이고 급여가 1200이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명을 출력 (부서명순, 급여큰순 정렬)
SELECT ENAME,SAL,HIREDATE,E.DEPTNO,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
                AND COMM IS NULL AND SAL>=1200
                ORDER BY DNAME, SAL DESC;
                
                
    -- EQUI JOIN 예제
    
--	뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT ENAME,SAL FROM EMP E,DEPT D 
        WHERE  E.DEPTNO=D.DEPTNO AND LOC ='NEW YORK';

--	ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO AND DNAME ='ACCOUNTING';
--	직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME,DNAME FROM EMP E,DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--	Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL,E.DEPTNO,LOC FROM EMP E,DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
        

-- NON- EQUI JOIN 
SELECT ENAME,SAL FROM EMP WHERE ENAME='SCOTT';
SELECT * FROM SALGRADE;
SELECT ENAME, SAL,GRADE,LOSAL,HISAL FROM EMP, SALGRADE
        WHERE ENAME = 'SCOTT' AND SAL>=LOSAL AND SAL<=HISAL;
-- 모든 사원의 사번, 이름, JOB, 상사사번, 급여, 급여등급(1등급,2등급)..
SELECT EMPNO, ENAME ,JOB ,MGR ,SAL ,GRADE||'등급' FROM EMP,SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL;
        
--연습문제
-- Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.
SELECT ENAME,SAL,GRADE,E.DEPTNO,DNAME,LOC FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
-- 이름, 급여, 입사일, 급여등급
SELECT ENAME,SAL,HIREDATE,GRADE FROM EMP,SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL;
-- 이름, 급여, 입사일, 급여등급, 부서명, 근무지
SELECT ENAME,SAL,HIREDATE,GRADE,DNAME,LOC FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO =D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--	이름, 급여, 등급, 부서코드, 근무지. 단 comm 이 null아닌 경우
SELECT ENAME, SAL ,GRADE,E.DEPTNO,LOC FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
--	이름, 급여, 급여등급, 연봉, 부서명, 부서별 출력, 부서가 같으면 연봉순. 연봉=(sal+comm)*12 comm이 null이면 0
SELECT ENAME,SAL,GRADE,SAL*12+NVL(COMM,0) 연봉,DNAME FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL ORDER BY 연봉;
--	이름, 업무, 급여, 등급, 부서코드, 부서명 출력. 급여가 1000~3000사이. 정렬조건 : 부서별, 부서같으면 업무별, 업무같으면 급여 큰순
SELECT ENAME,JOB,SAL,GRADE,E.DEPTNO,DNAME FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000 ORDER BY DNAME ,JOB,SAL DESC;
--	이름, 급여, 등급, 입사일, 근무지. 81년에 입사한 사람. 등급 큰순
SELECT ENAME,SAL,GRADE,HIREDATE,LOC FROM EMP E,DEPT D,SALGRADE
        WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE LIKE '81/%' ORDER BY GRADE DESC;
        
-- SELF JOIN
SELECT WORKER.EMPNO,WORKER.ENAME,WORKER.MGR,MANAGER.EMPNO,MANAGER.ENAME 
        FROM EMP WORKER, EMP MANAGER
        WHERE WORKER.ENAME ='SMITH' AND WORKER.MGR=MANAGER.EMPNO;
SELECT WORKER.EMPNO,WORKER.ENAME,MANAGER.ENAME FROM EMP WORKER,EMP MANAGER
        WHERE WORKER.MGR=MANAGER.EMPNO;         -- EMPNO에 NULL값이 없으므로 13명
-- SMITH의 상사는 FORD다 출력
SELECT W.ENAME||'의 상사는 ' ||M.ENAME||'다' FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;
        
-- 예제      
-- 상사의 이름이 'KING'인 사원들의 이름과 JOB 출력
SELECT W.ENAME,W.JOB FROM EMP W,EMP M 
        WHERE W.MGR=M.EMPNO 
        AND M.ENAME = 'KING';
-- SCOTT과 동일한 부서번호에서 근무하는 사람의 이름 출력
SELECT W.ENAME FROM EMP W, EMP S
        WHERE  W.DEPTNO=S.DEPTNO 
        AND S.ENAME ='SCOTT'
        AND W.ENAME!='SCOTT';
-- SCOTT과 동일한 근무지에서 근무하는 사람의 이름 출력
INSERT INTO DEPT VALUES (50, 'IT','DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) 
        VALUES (9999,'HONG',50);
SELECT W.ENAME FROM EMP W, EMP S,DEPT D, DEPT L
        WHERE S.DEPTNO =D.DEPTNO 
        AND S.ENAME = 'SCOTT' 
        AND W.DEPTNO =L.DEPTNO 
        AND D.LOC = L.LOC 
        AND W.ENAME !='SCOTT';
        
        
        
-- OUTER JOIN   : 조인 조건에 만족하지 않은 행까지 나타나게
SELECT W.EMPNO, W.ENAME, M.ENAME 
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME,'--CEO--') 
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
SELECT W.EMPNO, W.ENAME, M.ENAME 
        FROM EMP W, EMP M
        WHERE W.MGR(+)=M.EMPNO 
                AND W.EMPNO IS NULL;         -- 말단사원
SELECT * FROM EMP;
SELECT * FROM DEPT; 
SELECT E.*, DNAME FROM EMP E, DEPT D
        WHERE E.DEPTNO(+) = D.DEPTNO;
        
-- 예제
-- SMITH의 매니저는 FORD 입니다/ KING의 매니저는 無 입니다.
SELECT W.ENAME|| ' 의 매니저는 ' ||NVL(M.ENAME,'無') || ' 입니다 ' 
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO(+);


-- 총 연습문제
--PART 1
--1. 이름, 직속상사
SELECT W.ENAME , M.ENAME 직속상사
        FROM EMP W , EMP M
        WHERE W.MGR=M.EMPNO;
--2. 이름, 급여, 업무, 직속상사
SELECT W.ENAME , W.SAL, W.JOB , M.ENAME 직속상사
         FROM EMP W , EMP M
        WHERE W.MGR=M.EMPNO;
--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT W.ENAME , W.SAL, W.JOB , NVL(M.ENAME,'없음') 직속상사
         FROM EMP W , EMP M
        WHERE W.MGR=M.EMPNO(+);
--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME, W.SAL , DNAME, M.ENAME 직속상사
        FROM EMP W, EMP M, DEPT D
        WHERE W.MGR=M.EMPNO
                AND W.DEPTNO = D.DEPTNO;
--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME,W.SAL,W.DEPTNO,DNAME,LOC,M.ENAME
        FROM EMP W, EMP M, DEPT D
        WHERE W.MGR=M.EMPNO(+)
                AND W.DEPTNO =D.DEPTNO;
--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT W.ENAME , W.SAL ,GRADE, M.ENAME 
        FROM EMP W, EMP M, SALGRADE
        WHERE W.MGR =M.EMPNO
                AND W.SAL BETWEEN LOSAL AND HISAL
                AND W.SAL>=2000;
--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT W.ENAME,W.SAL,GRADE,DNAME,M.ENAME
        FROM EMP W, EMP M, SALGRADE,DEPT D
        WHERE W.MGR=M.EMPNO
                AND W.DEPTNO = D.DEPTNO
                AND W.SAL BETWEEN LOSAL AND HISAL;     
--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT W.ENAME, W.SAL , GRADE , DNAME, (W.SAL+NVL(W.COMM,0))*12 연봉,M.ENAME 직속상사
        FROM EMP W,EMP M, DEPT D, SALGRADE
        WHERE W.MGR=M.EMPNO
                AND W.DEPTNO=D.DEPTNO
                AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
SELECT W.ENAME, W.SAL , GRADE , DNAME, (W.SAL+NVL(W.COMM,0))*12 연봉,M.ENAME 직속상사
        FROM EMP W,EMP M, DEPT D, SALGRADE
        WHERE W.MGR=M.EMPNO
                AND W.DEPTNO=D.DEPTNO
                AND W.SAL BETWEEN LOSAL AND HISAL
                        ORDER BY  DNAME, W.SAL DESC;

--  PART2
--1.EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME , E.DEPTNO, DNAME 
         FROM EMP E,DEPT D
         WHERE E.DEPTNO =D.DEPTNO;
--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력
SELECT ENAME, JOB,SAL,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
                AND D.LOC = 'NEW YORK';
--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME , DNAME, LOC 
        FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                AND COMM IS NOT NULL ;
--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME,JOB,DNAME,LOC 
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
                AND ENAME LIKE '%L%';
--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO,ENAME,E.DEPTNO,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                ORDER BY ENAME ;
--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO,ENAME,SAL,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                AND SAL>=2000
                        ORDER BY SAL DESC;
--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO,ENAME,JOB,SAL,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                AND JOB='MANAGER'
                AND SAL>=2500
                        ORDER BY EMPNO;
--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO,ENAME,JOB,SAL,GRADE
        FROM EMP E, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL
                ORDER BY SAL DESC;
--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT W.ENAME, M.ENAME
        FROM EMP W, EMP M
        WHERE W.MGR =M.EMPNO(+);
--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT W.ENAME , M.ENAME , MM.ENAME
        FROM EMP W, EMP M , EMP MM
        WHERE W.MGR=M.EMPNO
                AND M.MGR=MM.EMPNO;
--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT W.ENAME , M.ENAME , MM.ENAME
        FROM EMP W, EMP M , EMP MM
        WHERE W.MGR=M.EMPNO(+)
                AND M.MGR=MM.EMPNO(+);