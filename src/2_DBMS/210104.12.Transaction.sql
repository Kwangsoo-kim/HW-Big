-- [ XII ] Ʈ������ ��ɾ� ; COMMIT ; ROLLBACK ; SAVEPOINT

COMMIT;
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01
        AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;   
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK;       -- DELETE ������ ���ư�, DROP, CREATE ���� ��������.
SELECT * FROM DEPT01;
---------------------------------- ���ο� Ʈ������ ����
DELETE FROM DEPT01 WHERE DEPTNO =40;            -- 40�� �μ� ����
COMMIT;         -- �ѹ�Ұ�
---------------------------------- ���ο� Ʈ������ ����
DELETE FROM DEPT01 WHERE DEPTNO =30;            -- 30�� �μ� ����
SAVEPOINT C1;   -- C1 ���� : 10,20�� �μ� ����
DELETE FROM DEPT01 WHERE DEPTNO = 20;           -- 20�� �μ� ����
SELECT * FROM DEPT01;
SAVEPOINT C2;   -- C2 ���� : 10�� �μ��� ����
DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01;          -- ������ ����
ROLLBACK TO C2; -- C2�� �ѹ�
ROLLBACK TO C1; -- C1���� �ѹ�
ROLLBACK -- COMMIT ���ķ�.
COMMIT;
DROP TABLE DEPT01;
