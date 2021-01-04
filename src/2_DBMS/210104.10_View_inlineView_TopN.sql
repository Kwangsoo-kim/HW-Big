-- [x] VIEW, INLINE VIEW, TOP-N ����
-- 1 . VIEW : ������ ���̺�          
-- (1) �ܼ���
CREATE OR REPLACE  VIEW EMPv0           
        AS  SELECT EMPNO, ENAME ,JOB, DEPTNO FROM EMP;  -- EMPv0��� VIEW ���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111,'ȫ','IT',40);             -- VIEW �� INSERT������ EMP ���̺� �����.
SELECT * FROM EMPv0;
SELECT * FROM EMP;
UPDATE EMPv0 SET JOB = ' ANALYST' WHERE EMPNO = 1111;
DELETE FROM EMPv0 WHERE EMPNO=1111;
-- EMPv0�̶�� VIEW  =  EMP�� 30�� �μ��ุ
CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMPv0;
SELECT * FROM USER_VIEWS;               -- ������ ��ųʸ� �並 Ȯ��
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ( 1111,'ȫ',NULL,NULL,NULL,NULL,NULL,30);
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ( 1112,'ȫ',NULL,NULL,NULL,NULL,NULL,40);       -- �Է��� �����ϳ� EMPv0���� �Ⱥ���
SELECT * FROM EMPv0;    -- 1111(30�� �μ���)
SELECT * FROM EMP;      -- 1111,1112 �� ����
DELETE FROM EMPv0 WHERE EMPNO<1113;             -- 30�� �μ��� ������ �����͸� ����
DELETE FROM EMP WHERE EMPNO<1113;
COMMIT;
--      EMP ���̺� 30�� �μ��� ������ ���̺� (30�� �μ��� INSERT ����)
CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO = 30
                WITH CHECK OPTION;      -- VIEW�� ��������

SELECT * FROM EMPv0;
INSERT INTO EMPv0  VALUES (1111,'ȫ',NULL,NULL,NULL,NULL,NULL,30);
INSERT INTO EMPv0  VALUES (1111,'ȫ',NULL,NULL,NULL,NULL,NULL,40);       -- CHECK OPTION �ɷ��־� �Ұ�
DELETE FROM EMPv0 WHERE EMPNO=1111;

-- (2) ���պ�
CREATE OR REPLACE VIEW EMPV1
        AS SELECT EMPNO,ENAME,JOB,DNAME FROM DEPT D , EMP E
                WHERE E.DEPTNO =D. DEPTNO;
SELECT * FROM EMPV1;
INSERT INTO EMPV1 VALUES (1111,'ȫ','SALESMAN','RESEARCH');      -- ���մ� INSERT�� �Ұ���.
-- ���պ� ���� DML ��ɾ ��� ����� �� ���� ��� (INSERT �Ұ�)
CREATE OR REPLACE VIEW EMPV2 
        AS SELECT EMPNO, ENAME, DEPTNO FROM EMP
                WITH READ ONLY; -- �б� ���� VIEW . SELECT �� ������
SELECT * FROM EMPV2;
SELECT EMPNO,ENAME,DNAME FROM EMPV2 E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO;
INSERT INTO EMPV2 VALUES (1111,'ȫ',40);         -- INSERT �Ұ�
-- EMP(�̸�,�޿�) 
CREATE OR REPLACE VIEW EMPV3
        AS SELECT  ENAME , SAL FROM EMP;
SELECT * FROM EMPV3;
INSERT INTO EMPV3 VALUES ('ȫ',9000);    -- PRIMARY KEY�� NOT NULL�̶� �����Ұ�.
--EMP(���,�̸�,����=SAL*12)
-- ���������� �ʵ�� Ư�����ڰ� ���� ��� - ��Ī�� �ٷ��ִ� ���
CREATE OR REPLACE VIEW EMPV3
        AS SELECT EMPNO , ENAME ,SAL*12 YEARSAL  FROM EMP;      -- �ʵ���� Ư�����ڰ� �� �� ���� ������ ��Ī�� �����.
-- ���������� �ʵ�� Ư�����ڰ� ���� ��� -  ��Ī�� ���εδ� ���
CREATE OR REPLACE VIEW EMPV3    ( EMPNO,NAME,YEARSAL)
        AS SELECT EMPNO , ENAME ,SAL*12   FROM EMP;     -- ��ü ���̺� ��Ī�� �� ���������.
INSERT INTO EMPV3 VALUES (1115,'ȫ',12000);      -- VIEW ������ �ʵ忡 �����ڰ� ������ INSERT �Ұ���.
-- EMP (��� ,�̸� ,�ݿø��� SAL)
CREATE OR REPLACE VIEW EMPV3
        AS SELECT EMPNO, ENAME , ROUND(SAL,-3) SAL FROM EMP;
SELECT * FROM EMPV3;
INSERT INTO EMPV3 VALUES (1115,'ȫ',1000);       -- VIEW ������ �ʵ忡 �Լ��� ����� ��� INSERT �Ұ���.
-- �μ���ȣ ,�ּұ޿� ,�ִ�޿�, �μ������ ������ DEPTV1 VIEW ����
CREATE OR REPLACE VIEW DEPTV1 (DEPTNO , MINSAL , MAXSAL , AVGSAL)
        AS  SELECT DEPTNO,MIN(SAL),MAX(SAL),ROUND(AVG(SAL),1) 
                FROM EMP GROUP BY  DEPTNO;              
INSERT INTO DEPTV1 VALUES (40,700,9000,4000);   -- VIEW ������ �ʵ忡 �Լ��� ����� ��� INSERT �Ұ���.
SELECT * FROM DEPTV1;
-- �μ���ȣ, �μ��� ,�ּұ޿� ,�ִ�޿� ,�μ����
SELECT DEPT.DEPTNO, DNAME , MINSAL ,MAXSAL ,AVGSAL 
        FROM DEPTV1, DEPT
                WHERE DEPTV1.DEPTNO=DEPT.DEPTNO;
DESC DEPTV1;
-- EMP(�ߺ��� ���ŵ� JOB , DEPTNO)
SELECT DISTINCT JOB , DEPTNO FROM EMP ORDER BY JOB;      -- ������
CREATE OR REPLACE VIEW EMPV3
        AS SELECT DISTINCT JOB , DEPTNO FROM EMP ORDER BY JOB;
SELECT * FROM EMPV3;
INSERT INTO EMPV3 VALUES ('CLERK',10);  -- VIEW ������ DISTINCT�� ����� ��� DML ���� �Ұ���.

        
-- 2 . INLINE VIEW : SQL�� �����ϴ� ������ ��ɾ���� ������ �� , FROM���� �ִ� ���������� ��Ī.
-- �޿��� 2000�� �ʰ��ϴ� ����� ��ձ޿�
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
SELECT AVG(SAL) FROM (SELECT * FROM EMP WHERE SAL>2000);
-- �̸� ,�޿� ,�μ���ȣ ,�ش����� �μ���� �޿�( SELECT �� �������� �̿�)
SELECT ENAME, SAL ,DEPTNO, (SELECT ROUND(AVG (SAL)) FROM EMP WHERE DEPTNO = E.DEPTNO) AVG 
        FROM EMP E;
-- �̸� ,�޿� ,�μ���ȣ ,�ش����� �μ���� �޿�(INLINE VIEW �̿�)
SELECT ENAME, SAL, DEPTNO FROM EMP;     -- (1)
SELECT DEPTNO ,ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;       -- (2)
SELECT ENAME ,SAL ,E.DEPTNO ,S.AVGSAL
        FROM EMP E,(SELECT DEPTNO ,ROUND(AVG(SAL)) AVGSAL FROM EMP GROUP BY DEPTNO) S
                WHERE E.DEPTNO=S.DEPTNO;
-- �̸�, �޿� ,�μ���ȣ ,�ش����� �μ���� (�μ���պ��� ���� �޴� ������)
SELECT ENAME ,SAL ,E.DEPTNO ,S.AVGSAL
        FROM EMP E,(SELECT DEPTNO ,ROUND(AVG(SAL)) AVGSAL FROM EMP GROUP BY DEPTNO) S
                WHERE E.DEPTNO=S.DEPTNO
                AND E.SAL>S.AVGSAL;

-- 3. TOP-N ���� (TOP 1 ~ 10 ��, TOP 11~20�� , TOP 6~ 10��)
-- ROWNUM : EMP ���̺��� ������ ����. ���̺��� ���� ������ ����
SELECT ROWNUM, ENAME ,SAL FROM EMP WHERE DEPTNO=30;
SELECT ROWNUM, ENAME ,SAL  FROM EMP ORDER BY SAL;
SELECT ROWNUM, ENAME , SAL FROM (SELECT * FROM EMP ORDER BY SAL);
SELECT ROWNUM, ENAME ,SAL FROM (SELECT * FROM EMP ORDER BY SAL)
        WHERE ROWNUM<6; --1~5�� 
SELECT ROWNUM, ENAME ,SAL FROM (SELECT * FROM EMP ORDER BY SAL)
        WHERE ROWNUM BETWEEN 6 AND 10;   -- 6~10�� ���� �� ������ �ȳ���.
-- �Լ��� �̿��� RANK ���
SELECT RANK() OVER(ORDER BY SAL) RANK,
        DENSE_RANK() OVER (ORDER BY SAL) D_RANK,
        ROW_NUMBER() OVER (ORDER BY SAL) N_RANK,
        ENAME ,SAL
        FROM EMP;
-- TOP-N ����
SELECT ROWNUM,ENAME, SAL
        FROM (SELECT * FROM EMP ORDER BY SAL)
        WHERE ROWNUM BETWEEN 1 AND 5;  -- TOP 6~10���� �Ұ�
SELECT RN,ENAME,SAL
        FROM (SELECT ROWNUM RN, ENAME , SAL
                FROM (SELECT *  FROM EMP ORDER BY SAL DESC))
        WHERE RN BETWEEN 6 AND 10;      -- TOP-N ����
-- �̸� ���ĺ� ������� 6~10�� ���� ���(�̸�,��� ,JOB,MGR,HIREDATE
SELECT RN , ENAME,EMPNO,JOB,MGR,HIREDATE
        FROM (SELECT ROWNUM RN, ENAME,EMPNO,JOB,MGR,HIREDATE
                FROM (SELECT * FROM EMP ORDER BY ENAME))
        WHERE RN BETWEEN 6 AND 10;


-- <�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
        AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO
        WITH READ ONLY;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
        AS SELECT W.ENAME WNAME, M.ENAME MNAME FROM EMP W, EMP M 
        WHERE W.MGR=M.EMPNO
        WITH READ ONLY;
SELECT * FROM WORKER_MANAGER_VU;
        
-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���) ? ģ������
SELECT DEPTNO,SSAL, ROWNUM RANK
        FROM (SELECT DEPTNO ,SUM(SAL) SSAL FROM EMP GROUP BY DEPTNO ORDER BY SSAL DESC) ;
                        
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT DEPTNO, SSAL, RANK
        FROM(SELECT DEPTNO,SSAL, ROWNUM RANK
                FROM (SELECT DEPTNO ,SUM(SAL) SSAL FROM EMP GROUP BY DEPTNO ORDER BY SSAL DESC)) 
        WHERE RANK BETWEEN 2 AND 3;
        
-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
        FROM EMP ORDER BY HIREDATE DESC;
        
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT RN, EMPNO, ENAME,HIREDATE
        FROM(SELECT ROWNUM RN,EMPNO,ENAME,HIREDATE
                FROM(SELECT EMPNO, ENAME, HIREDATE
                                 FROM EMP ORDER BY HIREDATE DESC))
        WHERE RN BETWEEN 1 AND 5;
        
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� 
SELECT RN, EMPNO, ENAME,HIREDATE
        FROM(SELECT ROWNUM RN,EMPNO,ENAME,HIREDATE
                FROM(SELECT EMPNO, ENAME, HIREDATE
                                 FROM EMP ORDER BY HIREDATE DESC))
        WHERE RN BETWEEN 6 AND 10;


























