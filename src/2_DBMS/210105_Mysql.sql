-- 계정생성, 권한부여, 권한박탈, 계정삭제(DCL)
-- DDL(제약조건,시퀀스없음), DML(OUTER JOIN, AND;&&  OR;|| , 일부단일행함수)
-- JAVA에서서 쓸 데이터 넣고 연습해보기
show tables; -- sql developer에선 select * from tab;
show databases;	-- database들의 리스트
-- DCL
create user user01 identified by 'password';
grant all on *.* to user01;		-- grant all privileges on *.* to user01; 와 동일
flush privileges;
revoke all on *.* from user01;	-- 권한박탈
drop user user01;		-- 계정삭제
-- 데이터베이스로 들어감
show databases;
create database kimdb;	-- 새로운 kimdb 데이터베이스가 생성
show databases;
use kimdb;		-- kimdb 데이터베이스로 들어가는 명령어
select database();		-- 현재 들어와 있는 데이터베이스
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,	-- null 포함 가능. null 값이 아닐 경우 유일한 값
    sal numeric(7,2) check(sal>0),
    hiredate datetime default now(),	-- now = sysdate
    comm numeric(7,2) default 0
);
drop table if exists emp;
create table emp(
	empno numeric(4) ,
    ename varchar(20) not null,
    nickname varchar(20) ,	
    sal numeric(7,2) ,
    hiredate datetime default now(),	-- now = sysdate
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)		-- null , default 못내림
);
insert into emp(empno,ename,nickname,sal)
	values (1111,'홍','천사',9000);
select * from emp;
drop table emp;
-- Major(mCode;시퀀스처럼pk,mName,mOfiice)
create table Major(
	mCode int primary key auto_increment,		-- auto_increment일 경우 int
    mName varchar(20),
    mOffice varchar(30)
);
-- Student(sNo,sName,mCode)
create table Student(
	sNo numeric(4) ,
    sName varchar(20),
	mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode)
    -- mCode int references Major(mCode)사용 불가능   Mysql에서는 foreign key를 옆에다 쓰면 안되고 아래로 내려야한다.
);
drop table student;
drop table major;

select * from major;
select * from student;
insert into major(mName,mOffice) values ('컴공','704호');
insert into major(mName,mOffice) values ('경영','702호');
insert into major(mName,mOffice) values ('빅데이터','701호');
insert into major(mName,mOffice) values ('기계','705호');
insert into student values (1111,'홍',1);
insert into student values (1112,'김',2);
insert into student values (1113,'박',2);
insert into student values (1114,'이',5);		-- foreign key 연결상태라 실행불가
select * from student;
select sNo,sName,m.mcode,mName,mOffice
	from student s ,major m
		where s.mcode = m.mcode;
-- right outer join
select sno,sname,m.mcode,mname,moffice
	from student s right outer join major m
		on s.mcode = m.mcode;		-- from 절에 right/left outer join 입력하고 , where 절이 아닌 on 절에 조건.

-- 자바(JDBC) 수업시간에 쓸 테이블
drop table if exists division;
create table division(
	dno int primary key,	-- 부서번호
    dname varchar(20),		-- 부서이름
    phone varchar(20),		-- 부서전화
    position varchar(20)	-- 부서위치    
);
drop table if exists personal;
create table personal(
	pno		int,					-- 사번
    pname	varchar(20) not null,	-- 사원명
    job		varchar(20) not null,	-- 직객
    manager	int,					-- 상사의 사번
    startdate date,					-- 입사일
	pay		int,					-- 급여
    bonus 	int,					-- 상여금
    dno		int,					-- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)
);
select * from division;
select * from personal;
desc division;
insert into division values (10,'finance','02-716-1006','신촌');
insert into division values (20,'research','02-712-2006','용산');
insert into division values (30,'sales','02-710-3006','동작');
insert into division values (40,'marketing','02-711-4006','강남');
commit;

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
commit;

-- DML(select,update,delete,insert)
select * from division;
select * from personal;
-- 연습문제
-- 1. 사번, 이름, 급여를 출력
select pno, pname ,pay 
	from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal
	where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno,pname,dno
	from personal
		where dno in(10,20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno,pname,pay
	from personal
		where bonus is null
			order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno,pname,p.dno,pay
	from personal p, division d
		where p.dno=d.dno
			order by p.dno,pay desc;
-- 6. 사번, 이름, 부서명
select pno,pname,dname
	from personal p , division d
		where p.dno=d.dno;
-- 7. 사번, 이름, 상사이름
select w.pno,w.pname ,m.pname 상사
	from personal w,personal m
		where w.manager=m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno,w.pname,m.pname 상사
	from personal w left outer join personal m
		on w.manager=m.pno;
-- 8-1. 사번, 이름, 상사이름(상사가 없는 사람도 출력.상사가 없을경우 없다고 츨력)
select w.pno,w.pname,ifnull(m.pname,'없다') 상사		-- NVL 말고 ifnull 혹은 if(m.pname is null, '없다',m.pname) 을 사용 삼항연산자랑 비슷.
	from personal w left outer join personal m
		on w.manager=m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname
	from personal
		where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno,w.pname,w.pay,dname,m.pname
	from personal w,personal m, division d
		where w.manager=m.pno
			&& w.dno=d.dno;
-- 11. 부서코드, 급여합계, 최대급여
select dno,sum(pay),max(pay)
	from personal
		group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)) avg, count(*)
	from personal p, division d
		where p.dno=d.dno
			group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno,sum(pay),count(*)
	from personal
		group by dno
			having count(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno,pname,pay
	from personal
		where pay = (select max(pay) from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname,pay,dno
	from personal
		where pay > (select avg(pay) from personal);
-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pno,pname,pay,dname
	from personal p,division d
		where pay = (select max(pay) from personal)
			order by dname, pay desc;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
		-- sub query 사용
select pname,pay,dno,(select round(avg(pay)) from personal b where a.dno=b.dno) avg
	from personal a
		where pay > (select avg(pay) from personal b where a.dno=b.dno);
        -- inline view 사용
select pname,pay,p.dno,round(avgpay)
	from personal p , (select dno, avg(pay) avgpay from personal group by dno) s
		where p.dno=s.dno && pay>s.avgpay;
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname,pay,dname
	from personal p, division d
		where p.dno=d.dno
			&& startdate = (select min(startdate) from personal);
-- 19. 이름, 급여, 해당부서평균(반올림)
select pname,pay,(select round(avg(pay)) from personal b where a.dno=b.dno) avg		-- round((select avg(pay) from personal b where a.dno=b.dno)) 서브쿼리는 괄호를 한번 더 해준다
	from personal a;
        -- inline view 사용
select pname,pay,round(avgpay)
	from personal p , (select dno, avg(pay) avgpay from personal group by dno) s
		where p.dno=s.dno;    
    
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname , pay , dname,(select round(avg(pay)) from personal b where a.dno=b.dno) avg
	from personal a, division d
		where a.dno=d.dno;
        
        
-- Oracle에서의 단일행함수 = MySQL 컬럼함수의 차이점
select concat(pname,'은',job,'이다') from personal;
select round(356.98,1);	-- from절이 없어서도 실행가능 (orcle은 dual사용)
select year(startdate),month(startdate),pname from personal;		-- extract 대용
select monthname(startdate) from personal;	-- 월 이름 추출
select dayname(startdate) from personal;	-- 요일 이름 추출
-- date_format에서 포맷 글자
-- %y(년도 2자리), %Y(년도 4자리)
-- %M(월이름), %m(월 앞에0)
-- %b(짧은 월 이름), %c(월수)
-- %e(일), %d(앞에0)
-- %H (24시간), %h(12시간), %p(오전,오후), %i(분), %s(초)
select date_format(now(),'%y년%c월%d일 %p %h시 %i분%s초');
-- personal 이름, 입사일(1980년 1월 9일)순으로 출력
select pname,date_format(startdate,'%Y년 %c월 %e일') date from personal;
-- 시스템으로부터 현재 날짜, 시간
select sysdate();
select now();
-- 시스템으로 부터 현재 날짜만
select current_date();
select curdate();
-- 시스템으로 부터 현재 시간만
select current_time();
select curtime();
-- format()
select format(pay,1) from personal;		-- 숫자가 소수점 1자리, 3자리마다 ,
select format(pay,0) from personal;		-- 3자리마다 ,
-- personal 이름, 급여, 급여3000이상인지 아닌지 여부
select pname,pay,if(pay>=3000, '높다','낮다') 이프
	from personal;

-- TOP-N 구문
select pname,pay 
	from personal
		order by pay desc;
-- limit n(1등~n등까지)
select pname,pay
	from personal
		order by pay desc limit 5;
-- limit n1,n2(n1번째 부터 n2개)	n1번째의 처음은 0번째
-- ex) 4~6등까지 limit 3,3
select pname,pay
	from personal
		order by pay desc limit 3,3;
-- 6~9등까지 limit 5,4
select pname,pay
	from personal
		order by pay desc limit 5,4;
-- 1~3등까지
select pname,pay
	from personal
		order by pay desc limit 3;
	













