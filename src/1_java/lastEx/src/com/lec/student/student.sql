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
        SCORE NUMBER(3) ,
        EXPEL NUMBER(1) default 0
);
CREATE SEQUENCE SNO_SEQ
        START WITH 1
        INCREMENT BY 1
        MAXVALUE 999
        MINVALUE 1
        NOCYCLE
        NOCACHE;
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
                                                        '���켺',(SELECT MNO FROM MAJOR WHERE MNAME='��������'),100,1);
-- 1
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '���켺',(SELECT MNO FROM MAJOR WHERE MNAME='��������'),90,0);
-- 2

SELECT ROWNUM||'��' RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND MNAME ='��������'
                                        ORDER BY SCORE DESC) S;
-- 3
SELECT ROWNUM||'��' RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND EXPEL=0
                                ORDER BY SCORE DESC) S;

-- 4
SELECT ROWNUM||'��' RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=1
                                ORDER BY SCORE DESC) S;


SELECT MNO FROM MAJOR WHERE MNAME='��������'; 

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
	INSERT INTO MAJOR VALUES (1, '��������');
	INSERT INTO MAJOR VALUES (2, '�濵������');
	INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
	INSERT INTO MAJOR VALUES (4, '����Ʈ����');
	INSERT INTO MAJOR VALUES (5, '�ΰ�������');	
COMMIT;