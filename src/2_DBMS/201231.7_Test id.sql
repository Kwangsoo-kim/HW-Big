SSELECT * FROM TAB;
SELECT * FROM DBA_TABLES;               -- DBA 권한이 아니기 대문에 접근불가
SELECT * FROM USER_TABLES;              -- 내 계정이 가지고 있는 테이블 정보
SELECT * FROM ALL_TABLES;               -- 접근 가능한 테이블 정보
SELECT * FROM ALL_TABLES WHERE TABLE_NAME = 'EMP';
SELECT * FROM SCOTT.EMP;                        -- SCOTT꺼
EXIT;                           --접속해제

SELECT * FROM SCOTT.EMP;                      -- 권한 박탈 후 접속 불가