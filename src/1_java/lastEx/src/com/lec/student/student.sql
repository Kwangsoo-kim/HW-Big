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
                                                        '정우성',(SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'),90,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '김우성',(SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'),50,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '이우성',(SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'),70,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '장우성',(SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'),60,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '성우성',(SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'),100,1);
-- 1
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '정우성',(SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'),90,0);
-- 2

SELECT ROWNUM||'등' RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND MNAME ='빅데이터학'
                                        ORDER BY SCORE DESC) S;
-- 3
SELECT ROWNUM||'등' RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND EXPEL=0
                                ORDER BY SCORE DESC) S;

-- 4
SELECT ROWNUM||'등' RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=1
                                ORDER BY SCORE DESC) S;


SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'; 

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
	INSERT INTO MAJOR VALUES (1, '빅데이터학');
	INSERT INTO MAJOR VALUES (2, '경영정보학');
	INSERT INTO MAJOR VALUES (3, '컴퓨터공학');
	INSERT INTO MAJOR VALUES (4, '소프트웨어');
	INSERT INTO MAJOR VALUES (5, '인공지능학');	
COMMIT;