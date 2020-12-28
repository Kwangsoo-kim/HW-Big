-- [ IV ] �������Լ�
-- �Լ� = �������Լ� + �׷��Լ�
SELECT HIREDATE, TO_CHAR(HIREDATE,'YY"��"MM"��"DD"��" DY"����" ')  
        FROM EMP;  -- ������ �Լ�
        
SELECT ENAME, INITCAP(ENAME)
        FROM EMP;  -- ������ �Լ�

SELECT SUM(SAL) 
        FROM EMP;  --�׷��Լ� 
        
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;  -- �׷��Լ�

-- EX. ���ڰ����Լ�, �����Լ�, ��¥�Լ�, ����ȯ�Լ�, NVL�Լ�, DECODE, ETC....
-- (1) �����Լ�
DESC DUAL;  -- ����Ŭ���� �����ϴ� 1�� 1��¥��  DUMMY TABLE
SELECT ABS(-9) 
        FROM DUAL;  -- ���밪
SELECT FLOOR(34.5678) 
        FROM DUAL;  -- �Ҽ������� ����
SELECT FLOOR(34.5678*10)/10 
        FROM DUAL;  -- �Ҽ��� ���ڸ����� ����
SELECT TRUNC(34.5678) 
        FROM DUAL; -- �Ҽ������� ����
SELECT TRUNC(34.5678,1) 
        FROM DUAL;  -- �Ҽ��� ���ڸ����� ����
SELECT TRUNC(34.5678,-1) 
        FROM DUAL;  -- ���� �ڸ����� ����
-- EMP ���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL,-2) 
        FROM EMP;
SELECT CEIL(34.5678)
        FROM DUAL;  -- �Ҽ������� �ø�
SELECT ROUND(34.5678)
        FROM DUAL;--  �Ҽ������� �ݿø�
SELECT ROUND(34.5678,1)
        FROM DUAL;-- �Ҽ��� ���ڸ����� �ݿø�
SELECT ROUND(34.5678,-1)
        FROM DUAL;-- ���� �ڸ����� �ݿø�
        
SELECT FLOOR(10/4) 
        FROM DUAL;
SELECT MOD(9,2) 
        FROM DUAL;  -- ������ ����
SELECT MOD('9',2)
        FROM DAUL;  -- 9/2�� �������� ����
-- Ȧ���޿� �Ի��� ������� ��� �ʵ带 ���
SELECT *
        FROM EMP 
        WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

-- (2) ���ڰ����Լ�
SELECT UPPER ('asdASD') 
        FROM DUAL;  -- �빮�ڷ�
SELECT LOWER('asdASD')
        FROM DUAL;  -- �ҹ��ڷ�
SELECT INITCAP('ASDasd')
        FROM DUAL; -- ù���ڸ� �빮�ڷ� �������� �ҹ���
 -- JOB�� MANAGER�� ������ ��� �ʵ� ���
 SELECT * 
        FROM EMP
        WHERE UPPER(JOB) = 'MANAGER';
SELECT EMPNO, INITCAP(ENAME)
        FROM EMP;
-- ���ڿ���       
SELECT 'AB'||'CD'||'EF'||'GH' 
        FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'),CONCAT('EF','GH'))
        FROM DUAL;  -- ���빰 �ΰ��� ���ᰡ��
-- XXX�� XX�� (�̸��� JOB�̴�)
SELECT ENAME || ' �� ' || JOB || ' �̴� '
        FROM EMP;
SELECT CONCAT(CONCAT(ENAME,' �� '),CONCAT(JOB,' �̴�'))
        FROM EMP;  -- ������ �־ �� �Ⱦ�
-- SUBSTR(STR,������ġ,���ڰ���)  **ù��° ��ġ�� 1
-- SUBSTRB(STR,������ġ,���ڹ���Ʈ��)
SELECT SUBSTR('WELCOM TO ORCLE',3,2)
        FROM DUAL;  -- 3��° ����2�� (LC)
SELECT SUBSTRB('WELCOM TO ORACLE',3,2)
        FROM DUAL;  -- 3��° ���� 2BYTE (����� ����)
SELECT SUBSTR('�����ͺ��̽�',4,3)
        FROM DUAL;  -- 4��° ���� 3��(���̽�)
SELECT SUBSTRB('�����ͺ��̽�',4,3)
        FROM DUAL;  -- 4��° ���� 3BYTE (��)
-- ����� �ѹ��ڰ� 1BYTE, �ѱ� �ѹ��ڰ� 3BYTE ** ORACLE���� ����
-- 9���� �Ի��� ����� ��� �ʵ带 ���
SELECT *
        FROM EMP
        WHERE SUBSTR(HIREDATE,4,2)='09';
SELECT SUBSTR('02-716-9999',-4,4)
        FROM DUAL;  -- ������ ���� ������ �� �ִ�.
-- 9�Ͽ� �Ի���  ����� ��� �ʵ带 ���
SELECT *
        FROM EMP
        WHERE SUBSTR(HIREDATE,-2,2) ='09';
SELECT LENGTH('ABCD')
        FROM DUAL;  -- ���� ���� : 4
SELECT LENGTHB('ABCD')
        FROM DUAL;  -- ���� BYTE �� : 4
SELECT LENGTH('����Ŭ')
        FROM DUAL;  -- ���� ���� : 3
SELECT LENGTHB('����Ŭ')
        FROM DUAL;  -- ���� BYTE ���� : 3
-- INSTR(STR, ã������) : STR���� ã�� ������ ù��° ��ġ (������ 0)
SELECT INSTR('ABCABC','B')
        FROM DUAL;         -- 2
-- INSTR(STR, ã������,ã�� ���� �� ��ġ) : STR���� ã�� ������ ù��° ��ġ (������ 0)     
SELECT INSTR('ABCABC','B',3)
        FROM DUAL;        -- 5
-- 9���� �Ի��� ���(INSTR���)
SELECT *
        FROM EMP
        WHERE INSTR(HIREDATE,'09')=4;
--9�Ͽ� �Ի��� ���(INSTR���)
SELECT*
        FROM EMP
        WHERE INSTR(HIREDATE,'09')=7;
-- LPAD,RPAD(����, �ڸ���, '*') : ���ڸ� �ڸ� �� ��ŭ Ȯ���ϰ� ����,������ ���ڸ��� *�� ä��.
SELECT LPAD('ORACLE' ,20,'#')
        FROM DUAL;
SELECT RPAD('ORACLE' , 20, '*')
        FROM DUAL;
SELECT ENAME, LPAD(SAL,6,'*')
        FROM EMP;
-- ���, S****(�̸��� �� �� ���ڸ� ����ϰ� �������� *) ���
SELECT EMPNO,RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') NAME
        FROM EMP;
-- ���, S****(�̸��� �� �� ���ڸ� ����ϰ� �������� *)  80/12/**(�Ի���) ���
SELECT EMPNO,RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') NAME
         ,RPAD(SUBSTR(HIREDATE,1,6),LENGTH(HIREDATE),'*') HIRENAME 
        FROM EMP;
-- ���, ******H(�̸��� �� �� ���ڸ� ����ϰ� �������� *)  80/12/**(�Ի���) ���
SELECT EMPNO,LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME),'*') NAME
        ,RPAD(SUBSTR(HIREDATE,1,6),LENGTH(HIREDATE),'*') HIRENAME 
        FROM EMP;        
-- �̸��� ������ �ڸ��� R�� ��� ���(INSTR, SUBSTR, LIKE)
SELECT * 
        FROM EMP
        WHERE ENAME LIKE '__R%';
SELECT *
        FROM EMP
        WHERE SUBSTR(ENAME,3,1)='R';
SELECT *
        FROM EMP
        WHERE INSTR(ENAME,'R')=3;

-- TRIM
SELECT TRIM('                ORACLE   DB        ')
        FROM DUAL;
SELECT LTRIM('                ORACLE   DB        ')
        FROM DUAL;
SELECT RTRIM('                ORACLE   DB        ')
        FROM DUAL;
-- REPLACE (STR,��ü �� �ܾ�, ��ü �� �ܾ�)
SELECT REPLACE(ENAME,'A','XX')
        FROM EMP;
        
-- (3) ��¥ ���� �����, �Լ�
SELECT SYSDATE 
        FROM DUAL;   -- ���� �ý��ۿ� ����� ��¥, �ð��� �� ���ԵǾ��ִ�.
SELECT TO_CHAR(SYSDATE,'YY-MM-DD HH24:MI:SS')
        FROM DUAL;
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ����
        FROM DUAL;
-- 14�� ��
SELECT SYSDATE+14
        FROM DUAL;
-- �̸�, �Ի��� , �ٹ����� ���
SELECT ENAME , HIREDATE, TRUNC(SYSDATE-HIREDATE) �ٹ�����
        FROM EMP;
-- �̸�, �Ի���, �ٹ��ּ�, �ٹ����� ���
SELECT ENAME,HIREDATE,TRUNC((SYSDATE-HIREDATE)/7) �ٹ��ּ�
        , TRUNC((SYSDATE-HIREDATE)/365) �ٹ�����
        FROM EMP;
-- MONTHS_BETWEEN() Ư���� �� ���� ������ ������         
-- �̸� ,�Ի��� ,�ٹ�����
SELECT ENAME,HIREDATE,FLOOR(MONTHS_BETWEEN(SYSDATE,HIREDATE)) �ٹ�����
        FROM EMP;
-- ADD_MONTHS(Ư������, ������) Ư���� ��¥�κ��� ��� ���� ����
-- �̸�, �Ի���, �����Ⱓ ������(�����Ⱓ�� 6����)
SELECT ENAME, HIREDATE,ADD_MONTHS(HIREDATE,6)
        FROM EMP;
-- NEXT_DAY(Ư����¥,' �� ') Ư����¥�κ��� ó�� �����ϴ� ������
SELECT NEXT_DAY(SYSDATE, '��') "�̹��� �����"
        FROM DUAL;
-- LAST_DAY(Ư����¥) : Ư����¥�� ���� ����
-- �̸�, �Ի���, ���޳�(������ ����)
SELECT ENAME,HIREDATE,LAST_DAY(HIREDATE)
        FROM EMP;
--ROUND : ��¥ �ݿø�, TRUNC : ��¥ ����                   
SELECT ROUND(SYSDATE,'YEAR')  -- ����� ������ yy�� 1�� 1��
        FROM DUAL;
SELECT ROUND(SYSDATE-30, 'MONTH')  -- ��� ������ 1��
        FROM DUAL;
SELECT ROUND(SYSDATE,'DAY') -- ��� ����� �Ͽ���
        FROM DUAL;       
SELECT ROUND(SYSDATE)  --��� ����� 0��
        FROM DUAL;
--ROUND : ��¥ �ݿø�, TRUNC : ��¥ ����                   
SELECT TRUNC(SYSDATE,'YEAR')  -- ����� ���� yy�� 1�� 1��
        FROM DUAL;
SELECT TRUNC(SYSDATE-30, 'MONTH')  -- ��� ���� 1��
        FROM DUAL;
SELECT TRUNC(SYSDATE,'DAY') -- ��� ���� �Ͽ���
        FROM DUAL;        
SELECT TRUNC(SYSDATE) -- ��� ���� 0��
        FROM DUAL;        
        
-- EX1. �̸�,�Ի���, �Ի��ϴ��� 1��
SELECT ENAME, HIREDATE ,TRUNC(HIREDATE,'MONTH') "�Ի�� 1��"
        FROM EMP;
-- EX2. �̸�, �Ի���, ���޳�(25��)
SELECT ENAME, HIREDATE,ROUND(HIREDATE-9,'MONTH')+24 ���޳�
        FROM EMP;
-- EX3. �̸�, �Ի���, SAL(����),�̶����� ���� ������
SELECT ENAME, HIREDATE,SAL,SAL*FLOOR(MONTHS_BETWEEN(SYSDATE,HIREDATE)) ������
        FROM EMP;
-- EX4. �̸�, �Ի���, SAL,COMM. �̶����� ���� ����(SAL*12+COMM)
SELECT ENAME, HIREDATE,SAL ,NVL(COMM,0),(SAL*12+NVL(COMM,0))* FLOOR(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12) ������
        FROM EMP;
        

-- (4) ����ȯ�Լ�
-- TO_CHAR(��¥, ����) : ��¥���� ���Ͽ� �°� �������� ����ȯ
        -- YY(�⵵) MM(��) MON(���̸�) DD(��) DY(����) 
        -- HH24(0~23��) AM(����/����) HH(0~11��) MI(��) SS(��)
SELECT ENAME, TO_CHAR(HIREDATE,'YYYY"��"MM"��"DD"��"')FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YY"��" MON DD"��" AM HH"��"MI"��"SS"��"') FROM DUAL;
-- TO_CHAR(����, ����) : ���ڰ��� ���Ͽ� �°� �������� ����ȯ
        -- ���ϳ� 0 : �ڸ���. �ڸ����� ���� ������ 0���� ä��
        -- ���ϳ� 9 : �ڸ���. �ڸ����� ���� ������ ä���� ����
        -- ���ϳ� $ : ��ȭ���� $�� ���ھտ� �ٴ´�
        -- ���ϳ� L : ������ȭ������ ���ھտ� ����
SELECT ENAME,TO_CHAR(SAL,'L999,999') SAL FROM EMP;
SELECT ENAME,TO_CHAR(SAL,'L000,000') SAL FROM EMP;
-- TO_DATE(����,����) : ���ڸ� ���Ͽ� ���ڰ� ��¥������ ��ȯ
-- 81/05/01 ~ 83/05/01 ���̿� �Ի��� ���� ���
SELECT * FROM EMP
        WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01';
SELECT * FROM EMP
        WHERE HIREDATE 
        BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');
-- 2020�� 11�� 30�� ���� ������� ��¥���� ���(�ý����� ��¥�� ������ �𸥴�)
SELECT TRUNC(SYSDATE-TO_DATE('20201130','YYYYMMDD')) FROM DUAL;
-- TO_NUMBER(����, ����) : ���ڸ� ���Ͽ� �°� ���������� ��ȯ
SELECT TO_NUMBER('1,000','9,999')FROM DUAL;  -- �������ϸ� �� �� ����.


-- (5) NULL�����Լ� : NVL(NULL�� ���� �ִ� ������, NULL�̸� ����� ��)
                                -- �Ű����� 2���� Ÿ���� ��ġ�ؾ��Ѵ�.
-- ����̸�, ���ӻ���� �̸�(���ӻ�簡 ������ CEO�� ���)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') 
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO(+);
-- ����̸�, ���ӻ���� ���(���ۻ�簡 ������ CEO�� ���)
SELECT ENAME , NVL(TO_CHAR(MGR),'CEO') MGR
        FROM EMP; 
        
-- (6) DECODE(������, ��1, ���1, ��2, ���2, ...., ��N ,���N,�׿� ���)
-- �̸� , �μ���ȣ, �μ��̸�
SELECT ENAME, D.DEPTNO, DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME,DEPTNO,
        DECODE(DEPTNO, 10, 'ACCOUNTING',20,'RESEARCH',30,'SALES',40,'OPERATIONS','ETC')  "DNAME"
        FROM EMP;
SELECT ENAME,DEPTNO,
        CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                WHEN  20 THEN 'RESEARCH'
                WHEN  30 THEN ' SALES'
                WHEN  40 THEN 'OPERATIONS'
                ELSE 'ETC'
        END "DNAME"
        FROM EMP;

--�̸�, �޿�, �λ����޿�
        --JOB�� ���� 'ANALYST' 10%�λ� , 'MANAGER' 20%�λ�, 'PRESIDENT' 30%�λ�, 'SALESMAN' 40%�λ�,'CLERK' �λ���� 
SELECT ENAME , SAL,
        CASE JOB WHEN 'ANALYST' THEN SAL*1.1
                        WHEN 'MANAGER' THEN SAL*1.2
                        WHEN 'PRESIDENT' THEN SAL*1.3
                        WHEN 'SALESMAN' THEN SAL*1.4
                        WHEN 'CLERK' THEN SAL
                        ELSE SAL
        END "�λ����޿�"
        FROM EMP;
SELECT ENAME, SAL,
        DECODE(JOB, 'ANALYST',SAL*1.1,'MANAGER',SAL*1.2,'PRESIDENT',SAL*1.3,'SALESMAN',SAL*1.4, SAL) �λ�޿�
        FROM EMP;
        
-- (7) �� �� EXTRACT, ������ ���
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR FROM EMP;
SELECT TO_CHAR(HIREDATE,'YYYY') FROM EMP;
SELECT EXTRACT (MONTH FROM HIREDATE) MONTH FROM EMP;
SELECT TO_CHAR(HIREDATE,'MM') FROM EMP;
-- LEVEL, START WITH (�ֻ��� ������ ����), CONNECT BY PRIOR(������ ��������)
SELECT LEVEL, LPAD('         ',LEVEL*2)||ENAME NAME, MGR FROM EMP
        START WITH MGR IS NULL
                CONNECT BY PRIOR EMPNO=MGR ORDER BY LEVEL;





-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB , SAL , SAL*1.15 "New Salary", SAL*1.15 - SAL Increase
        FROM EMP;
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME , HIREDATE , NEXT_DAY(ADD_MONTHS(HIREDATE,6), '������')  �� FROM EMP;
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME , HIREDATE, FLOOR(MONTHS_BETWEEN (SYSDATE,HIREDATE)) ������,SAL,FLOOR(MONTHS_BETWEEN (SYSDATE,HIREDATE))*SAL �޿��Ѱ�
        FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL,15,'*') FROM EMP;
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE,'DY') ���� FROM EMP;
--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) ���ڼ�, JOB 
        FROM EMP
        WHERE LENGTH(ENAME)>=6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM,'0') ���ʽ�, SAL+NVL(COMM,'0') �޿����ʽ�
        FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME,2,3) FROM EMP;
--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE
        FROM EMP
        WHERE TO_CHAR(HIREDATE,'MM') =12;
        
SELECT EMPNO, ENAME, HIREDATE
        FROM EMP
        WHERE EXTRACT(MONTH FROM HIREDATE) =12;
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT LPAD(EMPNO,4) EMPNO, LPAD(' ',10)||(ENAME) ENAME, LPAD(SAL,10,'*') �޿�
        FROM EMP;
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT LPAD(EMPNO,4) EMPNO, ENAME, LPAD(' ',10)||TO_CHAR(HIREDATE,'YYYY-MM-DD') �Ի���
        FROM EMP;
--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$999,999') �޿�
        FROM EMP
        WHERE DEPTNO =20;
-- 14. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��.
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO , ENAME, SAL ,
        CASE WHEN SAL BETWEEN 0 AND 1000 THEN'E'
                WHEN SAL BETWEEN 1001 AND 2000 THEN'D'
                WHEN SAL BETWEEN 2001 AND 3000 THEN'C'
                WHEN SAL BETWEEN 3001 AND 4000 THEN'B'
                WHEN SAL BETWEEN 4001 AND 5000 THEN'A'
        END ���
        FROM EMP 
                ORDER BY SAL;
      
        
SELECT EMPNO, ENAME ,SAL ,
        DECODE(TRUNC((SAL-1)/1000), 0 ,'E',1,'D',2,'C',3,'B',4,'A') ���
        FROM EMP;































