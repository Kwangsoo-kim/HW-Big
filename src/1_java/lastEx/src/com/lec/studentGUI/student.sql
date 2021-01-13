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
                                                        '정우성',(SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'),90,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '김우성',(SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'),50,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '이우성',(SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'),70,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '장우성',(SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'),60,0);
INSERT INTO STUDENT  VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                                                        '싱성',(SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'),100,1);
                                                        



SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'; 

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
	INSERT INTO MAJOR VALUES (1, '빅데이터학');
	INSERT INTO MAJOR VALUES (2, '경영정보학');
	INSERT INTO MAJOR VALUES (3, '컴퓨터공학');
	INSERT INTO MAJOR VALUES (4, '소프트웨어');
	INSERT INTO MAJOR VALUES (5, '인공지능학');	
COMMIT;

SELECT SNO,SNAME,MNAME,SCORE FROM STUDENT S , MAJOR M WHERE S.MNO=M.MNO AND  SNO = 2021001;

-- SwingStudentMng에서 필요한 Query
-- 0. 첫화면에 전공이름들 콤보박스에 추가(mName) : DAO에서 public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;

-- 1. 학번검색 (sNo, sName, mName, score) : DAO에서 public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO,SNAME,MNAME,SCORE 
        FROM STUDENT S , MAJOR M 
                WHERE S.MNO=M.MNO 
                        AND  SNO = ?;
                        
-- 2. 이름검색 (sNo, sName, mName, score)  : DAO에서 public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO,SNAME,MNAME,SCORE 
        FROM STUDENT S , MAJOR M        
                WHERE S.MNO=M.MNO 
                        AND  SNAME =?;
                        
-- 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- 출력 : 1 정우성(2021001) 빅데이터학(1) 90 
SELECT ROWNUM RANK,S.*
        FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME,SCORE
                FROM STUDENT S,MAJOR M
                        WHERE S.MNO=M.MNO
                                AND MNAME ='빅데이터학'
                                        ORDER BY SCORE DESC) S;



-- 4. 학생입력 : DAO에서 public int insertStudent(String sName, String mName, int score)
--              DAO에서 public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT (SNO,SNAME,MNO,SCORE)
        VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(SNO_SEQ.NEXTVAL,'000')),
                        '상신',(SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'),90);

-- 5. 학생수정 : DAO에서 public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO에서 public int updateStudent(StudentSwingDto dto)
UPDATE STUDENT SET SNO = 2021002, SNAME ='김인우', MNO =( SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'), SCORE=30 WHERE SNO =?;
       
-- 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> getStudents()
-- 출력 : 1 정우성(2021001) 빅데이터학(1) 90
SELECT ROWNUM RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MNAME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=0
                                ORDER BY SCORE DESC) S;

-- 7. 제적자출력  (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> getStudentsExpel()
-- 출력 : 1 김제적(2021004) 컴퓨터공학(3) 10

SELECT ROWNUM RANK,S.*
FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MANME,SCORE
        FROM STUDENT S,MAJOR M
                WHERE S.MNO=M.MNO
                        AND EXPEL=1
                                ORDER BY SCORE DESC) S;

-- 8. 제적처리 : DAO에서 public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL = 1;
