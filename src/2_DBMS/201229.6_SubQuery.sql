-- [VI] SUB QUERY " QUERY�ȿ� QUERY�� ����
-- 1. �������� ����
-- ��������    (1)   �����༭������(�������� ����� ������)  = > >= < <= != ��밡��
--                 (2)   ������ ��������(�������� ����� ������)  IN ANY ALL EXISTS ��밡��
-- SCOTT�� �ٹ��ϴ� �μ��̸� ���
SELECT DNAME,ENAME
        FROM EMP E, DEPT D
                WHERE E.DEPTNO=D.DEPTNO
                        AND ENAME = 'SCOTT';
SELECT DEPTNO 
        FROM EMP 
        WHERE ENAME='SCOTT';   -- ��������
SELECT DNAME 
        FROM DEPT
        WHERE DEPTNO=(
                                        SELECT DEPTNO 
                                        FROM EMP 
                                        WHERE ENAME='SCOTT'
                                );   -- ��������
                                        
                                        
-- JOB�� 'MANAGER'�� ����� �μ��̸�
SELECT DEPTNO 
        FROM EMP 
        WHERE JOB ='MANAGER';   -- �����༭������
        
SELECT DNAME 
        FROM DEPT
        WHERE DEPTNO IN(
                                        SELECT DEPTNO 
                                        FROM EMP 
                                        WHERE JOB ='MANAGER'
                                        );  -- �������� 
                                        
-- 2. ������ ��������
-- ȸ�翡�� �޿��� ���� ���� �޴� ����� �̸��� �޿��� ����϶�
SELECT MAX(SAL) FROM EMP;       -- ��������(������)
SELECT ENAME,SAL
        FROM EMP
        WHERE SAL=(SELECT MAX(SAL) FROM EMP);   -- ��������
-- SCOTT�� ���� �μ���ȣ�� ����̸� ���
SELECT DEPTNO
        FROM EMP
        WHERE ENAME ='SCOTT';
SELECT ENAME
        FROM EMP
        WHERE DEPTNO = (
                                        SELECT DEPTNO
                                        FROM EMP
                                        WHERE ENAME ='SCOTT') 
                AND ENAME !='SCOTT';
-- SCOTT�� ���� �ٹ����� ����̸� ��� (50�� DALLAS �μ� ȫ�浿 �Է� �� ����)
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP (EMPNO,ENAME,DEPTNO) VALUES (9999,'HONG',50);


SELECT LOC
        FROM DEPT D, EMP E
                WHERE E.DEPTNO = D.DEPTNO
                        AND ENAME ='SCOTT';     -- ��������

SELECT ENAME 
        FROM EMP E , DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                AND LOC = (
                                SELECT LOC
                                        FROM DEPT D, EMP E
                                        WHERE E.DEPTNO = D.DEPTNO
                                                AND ENAME ='SCOTT'
                                        )
                AND ENAME !='SCOTT';

-- SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿� ���� ���
SELECT DEPTNO
        FROM EMP
                WHERE ENAME='SCOTT';   -- ��������
SELECT SUM(SAL)
        FROM EMP
                WHERE DEPTNO = (
                                                SELECT DEPTNO
                                                FROM EMP
                                                WHERE ENAME='SCOTT'
                );      -- ��������
-- SCOTT�� ������ JOB�� ���� ����� ��� ������ ���
SELECT * FROM EMP
        WHERE JOB=(
                                SELECT JOB
                                        FROM EMP
                                        WHERE ENAME ='SCOTT'
                                        )
                        AND ENAME !='SCOTT';
                        
-- DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ�� �Է�
ROLLBACK;       -- DML ��ɾ� ���
SELECT ENAME , DEPTNO
        FROM EMP
        WHERE DEPTNO=(
                                SELECT DEPTNO
                                        FROM DEPT
                                        WHERE LOC = 'DALLAS');
-- SALES �μ��� �ٹ��ϴ� ������ �̸�, �޿� ���
SELECT ENAME , SAL
        FROM EMP
                WHERE DEPTNO=(
                                                SELECT DEPTNO
                                                        FROM DEPT
                                                        WHERE DNAME='SALES'
                                                );
-- 'KING'�� ���ӻ���� ����� �̸��� �޿�
SELECT ENAME ,SAL
        FROM EMP
        WHERE MGR =(
                                SELECT EMPNO
                                        FROM EMP
                                        WHERE ENAME ='KING'
                                );
-- ��� �޿� ���ϸ� �޴� ����� �̸�, �޿� ���
SELECT ENAME , SAL
        FROM EMP
        WHERE SAL<=(
                                SELECT AVG(SAL)
                                        FROM EMP
                                );
-- SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���(���߿���������)
SELECT * FROM EMP
        WHERE (JOB,DEPTNO) = (
                                                SELECT JOB,DEPTNO
                                                        FROM EMP
                                                        WHERE ENAME ='SCOTT'
                                                )
                                        AND ENAME !='SCOTT';


-- �� ������ ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME ,SAL ,HIREDATE
        FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE)FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
        FROM EMP
        WHERE SAL = (SELECT MIN(SAL)FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL ,DEPTNO
        FROM EMP
        WHERE SAL> (SELECT AVG(SAL)FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME ,SAL ,DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
                AND SAL<(SELECT AVG(SAL)FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME ,SAL,HIREDATE, GRADE
        FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL
                AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� 
    --�޿��� ū �� ����
SELECT ENAME ,SAL,HIREDATE, GRADE , DNAME
        FROM EMP E, SALGRADE , DEPT D
        WHERE SAL BETWEEN LOSAL AND HISAL
                AND E.DEPTNO =D.DEPTNO
                AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
                        ORDER BY SAL DESC;
--7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO , ENAME ,SAL
        FROM EMP
        WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
--8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO , ENAME ,HIREDATE
        FROM EMP
        WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME ='MILLER');
--9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO , ENAME , SAL
        FROM EMP
        WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� 
        -- ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO , ENAME , SAL
        FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK' )
                AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698)
                AND ENAME !='CLARK';

--11.  �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� 
    --  ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO , ENAME , SAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO =D.DEPTNO
                AND DNAME = (SELECT DNAME FROM EMP A,DEPT B WHERE A.DEPTNO=B.DEPTNO AND ENAME = 'CLARK' )
                AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698)
                AND ENAME !='CLARK';

--12.  ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME , HIREDATE
        FROM EMP
                WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--13.  ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸��� ���
        --(�� �޿��� ���� ������ ����Ͽ���.)

SELECT EMPNO , ENAME
        FROM EMP
        WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
                ORDER BY SAL DESC;
                
        
        
-- 3. ������ �������� ; IN, ALL, ANY=SOME, EXISTS
-- (1) IN ; �������� ��� �� �ϳ��� ��ġ�ϸ� ��
-- �μ����� �Ի����� ���� ���� ����� �μ���ȣ,�̸�, �Ի��� ���
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;   -- ���� ����
SELECT DEPTNO , ENAME ,HIREDATE 
        FROM EMP
        WHERE (DEPTNO,HIREDATE) IN(SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
-- �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ������� ��� ���� 
SELECT * FROM EMP
        WHERE DEPTNO IN (SELECT  DEPTNO FROM EMP WHERE SAL>=3000);

-- (2) ALL
-- 30�� �μ� �ִ� �޿����� �޿��� �� ���� �޴� ����� ����
SELECT * FROM EMP
        WHERE SAL>(SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP
        WHERE SAL>ALL(SELECT SAL FROM EMP WHERE DEPTNO=30);

-- (3) ANY=SOME
SELECT * FROM EMP
        WHERE SAL >(SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP
        WHERE SAL>ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);

-- (4) EXISTS ; ���������� ����� �����ϸ� ��
-- ���Ӻ��ϰ� �ִ� �������� ���, �̸� ,�޿� ���
SELECT EMPNO , ENAME, SAL
        FROM EMP M
        WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO=MGR);
-- ���ܻ���� ��� �ʵ� ���� ���
SELECT * FROM EMP M
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO=MGR); 
        
-- źź������

-- �μ����� ���� �޿��� ���� �޴� ����� ���, �̸� ,�޿� ,�μ���ȣ
SELECT EMPNO, ENAME, SAL ,DEPTNO
        FROM EMP
        WHERE (DEPTNO,SAL) IN  (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO , DNAME, LOC
        FROM DEPT 
        WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
-- ������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO , ENAME , JOB ,HIREDATE, SAL, GRADE
        FROM EMP, SALGRADE
                WHERE SAL BETWEEN LOSAL AND HISAL
                        AND SAL>=3000
                        AND (GRADE,SAL) IN(SELECT GRADE,MAX(SAL) 
                                                        FROM EMP,SALGRADE 
                                                        WHERE SAL BETWEEN LOSAL AND HISAL 
                                                                GROUP BY GRADE)
                                        ORDER BY GRADE;                                                                                                                                                       
-- �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER FROM EMP;




SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER ,EMPNO, ENAME ,JOB , MGR, HIREDATE,SAL,NVL(COMM,0) ��
        FROM EMP
                WHERE SAL IN(SELECT MAX(SAL) FROM EMP WHERE TO_CHAR(HIREDATE,'MM') BETWEEN 01 AND 03)
                        OR SAL IN(SELECT MAX(SAL) FROM EMP WHERE TO_CHAR(HIREDATE,'MM') BETWEEN 04 AND 06)
                        OR SAL IN(SELECT MAX(SAL) FROM EMP WHERE TO_CHAR(HIREDATE,'MM') BETWEEN 07 AND 09)
                        OR SAL IN(SELECT MAX(SAL) FROM EMP WHERE TO_CHAR(HIREDATE,'MM') BETWEEN 10 AND 12)
                                ORDER BY QUARTER;
                
-- SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME ,SAL,JOB 
        FROM EMP
        WHERE SAL> ALL(SELECT SAL FROM EMP WHERE JOB= 'SALESMAN')
                AND JOB != 'SALESMAN';
-- SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME,SAL ,JOB 
        FROM EMP
        WHERE SAL> ANY(SELECT SAL FROM EMP WHERE JOB= 'SALESMAN')	;
--������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT EMPNO , ENAME, SAL , HIREDATE
        FROM EMP
        WHERE HIREDATE IN (SELECT MAX(HIREDATE) FROM EMP WHERE SAL <3000 );
--������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME ,SAL ,JOB ,DEPTNO 
        FROM EMP
        WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB ='SALESMAN')
                AND DEPTNO != 20;
                
-- �����༭������ ��������
-- 14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ����
    --��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT EMPNO , ENAME, SAL
        FROM EMP
                WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
                        ORDER BY EMPNO; 
-- 15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ���
SELECT ENAME , JOB ,SAL
        FROM EMP 
                 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT��
SELECT ENAME ,SAL
        FROM EMP
                WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING');
-- 17. ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME,JOB
        FROM EMP E, DEPT D
                WHERE E.DEPTNO =D.DEPTNO
                        AND DNAME =(SELECT DNAME FROM DEPT WHERE DNAME ='SALES');
-- 18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ���
SELECT * FROM EMP
        WHERE SAL>ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);
       
SELECT * FROM EMP
        WHERE SAL>(SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ���
SELECT ENAME, JOB
        FROM EMP
                WHERE DEPTNO= 10
                AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);
-- 20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ���
SELECT * FROM EMP
        WHERE (SAL,JOB) IN (SELECT SAL,JOB FROM EMP WHERE ENAME = 'FORD')
                AND ENAME =  'FORD';
-- 21. �̸��� JONES�� ������ JOB�� ���ų� 
    --������ FORD ���� �̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�.
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME, JOB ,DEPTNO, SAL
        FROM EMP
                WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME ='JONES')
                        OR SAL>(SELECT SAL FROM EMP WHERE ENAME='FORD')
                                ORDER BY ENAME,SAL DESC;
-- 22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME,JOB,SAL 
        FROM EMP
                WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME = 'WARD')
                        AND ENAME !='SCOTT' AND ENAME !='WARD';
-- 23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB
        FROM EMP
                WHERE JOB IN(SELECT JOB FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');
-- 24. ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO , ENAME , SAL
        FROM EMP
                WHERE EMPNO IN(SELECT EMPNO
                                                FROM EMP
                                                WHERE SAL > (SELECT AVG(SAL)  FROM EMP WHERE DEPTNO=10)
                                                AND DEPTNO= 10)
                        OR  EMPNO IN(SELECT EMPNO
                                                FROM EMP
                                                WHERE SAL > (SELECT AVG(SAL)  FROM EMP WHERE DEPTNO=20)
                                                AND DEPTNO= 20)
                        OR  EMPNO IN(SELECT EMPNO
                                                FROM EMP
                                                WHERE SAL > (SELECT AVG(SAL)  FROM EMP WHERE DEPTNO=30)
                                                AND DEPTNO= 30);
                                                
SELECT EMPNO, ENAME, SAL
        FROM EMP E
                WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE DEPTNO =E.DEPTNO);
-- 25. ��� ���̺��� �� ������ ������ �� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT DEPTNO, ENAME,SAL
        FROM EMP E
                WHERE SAL<(SELECT AVG(SAL)FROM EMP WHERE JOB=E.JOB);
-- 26 ��� ���̺��� ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB , ENAME, EMPNO, DEPTNO
        FROM EMP M
                WHERE EXISTS(SELECT EMPNO FROM EMP W WHERE  M.EMPNO=W.MGR)
                        ORDER BY DEPTNO ;

-- 27. ��� ���̺��� ���� ����� �����ȣ, �̸�, ����, �μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO , ENAME , JOB ,DEPTNO
        FROM EMP M
                WHERE NOT EXISTS(SELECT EMPNO FROM EMP W WHERE M.EMPNO = W.MGR);
