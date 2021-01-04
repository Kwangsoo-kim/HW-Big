-- [ XII ] 트랜젝션 명령어 ; COMMIT ; ROLLBACK ; SAVEPOINT

COMMIT;
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01
        AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;   
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK;       -- DELETE 전으로 돌아감, DROP, CREATE 에는 관여못함.
SELECT * FROM DEPT01;
---------------------------------- 새로운 트랜젝션 시작
DELETE FROM DEPT01 WHERE DEPTNO =40;            -- 40번 부서 삭제
COMMIT;         -- 롤백불가
---------------------------------- 새로운 트랜젝션 시작
DELETE FROM DEPT01 WHERE DEPTNO =30;            -- 30번 부서 삭제
SAVEPOINT C1;   -- C1 지점 : 10,20번 부서 존재
DELETE FROM DEPT01 WHERE DEPTNO = 20;           -- 20번 부서 삭제
SELECT * FROM DEPT01;
SAVEPOINT C2;   -- C2 지점 : 10번 부서만 존재
DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01;          -- 데이터 없음
ROLLBACK TO C2; -- C2로 롤백
ROLLBACK TO C1; -- C1으로 롤백
ROLLBACK -- COMMIT 직후로.
COMMIT;
DROP TABLE DEPT01;
