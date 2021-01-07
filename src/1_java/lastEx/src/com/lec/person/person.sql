DROP TABLE PERSON;
DROP TABLE JOB;
DROP SEQUENCE SEQ_PERSON;
CREATE TABLE JOB(
        JNO NUMBER(2) PRIMARY KEY,
        JNAME VARCHAR2(100)
);

CREATE SEQUENCE SEQ_PERSON
        START WITH 1
        INCREMENT BY 1
        MAXVALUE 99999
        MINVALUE 1
        NOCYCLE
        NOCACHE;

CREATE TABLE PERSON(
        NO NUMBER(2) PRIMARY KEY,
        PNAME VARCHAR2(100) NOT NULL,
        JNO NUMBER(2) REFERENCES JOB(JNO),
        KOR NUMBER(3) NOT NULL,
        ENG NUMBER(3) NOT NULL,
        MAT NUMBER(3) NOT NULL
        
);

SELECT * FROM JOB;
SELECT * FROM PERSON;
SELECT SEQ_PERSON.CURRVAL FROM DUAL; 
INSERT INTO JOB VALUES (10,'���');
INSERT INTO JOB VALUES (20,'����');
COMMIT;
INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,'���켺',(SELECT JNO FROM JOB WHERE JNAME='���'),80,90,80);
ROLLBACK;
INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,'���켺',(SELECT JNO FROM JOB WHERE JNAME='���'),90,80,81);
INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,'�ڼ���',(SELECT JNO FROM JOB WHERE JNAME='���'),80,90,80);
INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL,'�����',(SELECT JNO FROM JOB WHERE JNAME='����'),20,90,90);
ROLLBACK;

--2 
SELECT PNAME ||'('||NO||'��)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM
        FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO
                        AND JNAME ='���'
                                ORDER BY SUM DESC;      -- FROM���� �� ��������
SELECT ROWNUM RANK, S.*
        FROM (SELECT PNAME ||'('||NO||'��)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM
        FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO
                        AND JNAME ='���'
                                ORDER BY SUM DESC) S;

--3
SELECT ROWNUM RANK, S.*
        FROM (SELECT PNAME ||'('||NO||'��)' PNAME,JNAME,KOR,ENG,MAT,KOR+ENG+MAT SUM
        FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO
                                ORDER BY SUM DESC) S;
SELECT JNO FROM JOB WHERE JNAME= '���'