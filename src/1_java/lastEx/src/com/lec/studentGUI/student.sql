DROP TABLE MAJOR;
DROP TABLE STUDENT;
DROP SEQUENCE SNO_SEQ;
CREATE TABLE MAJOR(
        MNO NUMBER(3) PRIMARY KEY,
        MNAME VARCHAR2(100) NOT NULL UNIQUE
);
CREATE TABLE STUDENT(
        SNO NUMBER(7) PRIMARY KEY,
        SNAME VARCHAR2(100) ,
        MNO NUMBER(3) REFERENCES MAJOR(MNO),
        SCORE NUMBER(3) DEFAULT 0,
        EXPEL NUMBER(1) default 0
);
CREATE SEQUENCE SNO_SEQ
        START WITH 1
        INCREMENT BY 1
        MAXVALUE 999
        MINVALUE 1
        NOCYCLE
        NOCACHE;
        
 -- EX       
SELECT TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')) FROM DUAL;
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '���켺',(SELECT MNO FROM MAJOR WHERE MNAME='��������'),90,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '��켺',(SELECT MNO FROM MAJOR WHERE MNAME='�濵������'),50,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '�̿켺',(SELECT MNO FROM MAJOR WHERE MNAME='�濵������'),70,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '��켺',(SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'),60,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '�̼�',(SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'),100,1);
                                                        



SELECT MNO FROM MAJOR WHERE MNAME='��������'; 

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
	INSERT INTO MAJOR VALUES (1, '��������');
	INSERT INTO MAJOR VALUES (2, '�濵������');
	INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
	INSERT INTO MAJOR VALUES (4, '����Ʈ����');
	INSERT INTO MAJOR VALUES (5, '�ΰ�������');	
COMMIT;

SELECT SNO,SNAME,MNAME,SCORE FROM STUDENT S , MAJOR M WHERE S.MNO=M.MNO AND  SNO = 2021001;

-- SwingStudentMng���� �ʿ��� Query
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) : DAO���� public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;

-- 1. �й��˻� (sNo, sName, mName, score) : DAO���� public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO,SNAME,MNAME,SCORE 
        FROM STUDENT S , MAJOR M 
                WHERE S.MNO=M.MNO 
                        AND  SNO = ?;
                        
-- 2. �̸��˻� (sNo, sName, mName, score)  : DAO���� public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO,SNAME,MNAME,SCORE 
        FROM STUDENT S , MAJOR M        
                WHERE S.MNO=M.MNO 
                        AND  SNAME =?;
                        
-- 3. �����˻� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- ��� : 1 ���켺(2021001) ��������(1) 90 
SELECT ROWNUM RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND MNAME ='��������'
                                        ORDER BY SCORE DESC) S;



-- 4. �л��Է� : DAO���� public int insertStudent(String sName, String mName, int score)
--              DAO���� public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT (SNO,SNAME,MNO,SCORE)
        VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                        '���',(SELECT MNO FROM MAJOR WHERE MNAME='��������'),90);

-- 5. �л����� : DAO���� public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO���� public int updateStudent(StudentSwingDto dto)
UPDATE STUDENT SET SNO = 2021002, SNAME ='���ο�', MNO =( SELECT MNO FROM MAJOR WHERE MNAME='�濵������'), SCORE=30 WHERE SNO =?;
       
-- 6. �л���� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudents()
-- ��� : 1 ���켺(2021001) ��������(1) 90
SELECT ROWNUM RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MNAME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=0
                                ORDER BY SCORE DESC) S;

-- 7. ���������  (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudentsExpel()
-- ��� : 1 ������(2021004) ��ǻ�Ͱ���(3) 10

SELECT ROWNUM RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MANME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=1
                                ORDER BY SCORE DESC) S;

-- 8. ����ó�� : DAO���� public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL = 1;
