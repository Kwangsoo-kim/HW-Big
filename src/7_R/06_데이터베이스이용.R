    

        ### 6장, 데이터베이스 이용 ###

#SQL문으로 데이터프레임과 DB테이블 이용
rm(list=ls(all.names=T))
# 6.1 SQL문을 이용한 데이터 프레임 처리
install.packages('sqldf')
library(sqldf)
# sqldf()함수를 통해 데이터프레임을DB의 테이블처럼 억세스 할 수 있다. 안에 내용물은 대소문자 구분하지않는다. 
sqldf('select*from iris')

# 중복행 제거하여 한번만 출력할때 (iris의 종을 출력)
sqldf('select distinct species from iris')# distinct : 중복제거 
names(table(iris$Species))
library(dplyr)
iris%>%
    group_by(Species)%>%
    summarise()

# 행제한 조건 설정(virginica종만 출력)
sqldf("select * from iris where species = 'virginica'")
iris[iris$Species=='virginica',]
iris%>%
    filter(Species=='virginica')

# 컬럼에 .이 내포한 경우 : `` 
#virginica종이면서 sepal.length가 7.5초과하는 데이터 출력
sqldf("select * from iris where species = 'virginica' and `Sepal.Length` >7.5")
iris[iris$Species=='virginica'&iris$Sepal.Length>7.5,]  
iris%>%
    filter(Species=='virginica'& Sepal.Length>7.5)

# 종별 sepal.Length의 합을 출력
sqldf("select Species,sum(`sepal.length`) sums from iris group by species")
tapply(iris$Sepal.Length,iris$Species,sum)
by(iris$Sepal.Length,iris$Species,sum)
library(doBy)
summaryBy(Sepal.Length~Species,iris,FUN=sum)
aggregate(iris$Sepal.Length,by=list(iris$Species),sum)
iris%>%
    group_by(Species)%>%
    summarise(sums = sum(Sepal.Length))

# 정렬 (sepal.length 길이가 1~5등,6~10등) mysql구문으로 대체 가능 top-n은 어지간한면 limit로. 
sqldf("select * from iris order by `sepal.length` desc")
sqldf("select * from iris order by `sepal.length` desc limit 5")
sqldf("select * from iris order by `sepal.length` desc limit 5,5") # 5번째부터 5개

# sql 함수(mysql함수 위주) 사용 : petal.length,petal.width의 평균과 표준편차(stdev)
sqldf("select avg(`petal.length`) avgpl , stdev(`petal.length`) stdevpl ,avg(`petal.width`) avgpw , stdev(`petal.width`) stdevpw from iris ")

summaryBy(Petal.Length+Petal.Width~iris,iris,FUN=c(mean,sd))


# sql 함수(mysql함수 위주) 사용 : 종에 따른 petal.length,petal.width의 평균과 표준편차
sqldf("select species,avg(`petal.length`) avgpl , stdev(`petal.length`) stdevpl ,avg(`petal.width`) avgpw , stdev(`petal.width`) stdevpw from iris group by species")

summaryBy(Petal.Length+Petal.Width~Species,iris,FUN=c(mean,sd))

sqldf("select round(avg(`petal.length`),2) from iris") # ,뒤 숫자로 소수점 출력 가능

iris%>%
    summarise(mean = round(mean(Petal.Length),2)) # R도 가능.


# 조인 
getwd()
emp <- read.csv('inData/emp.csv')
emp
dept <- read.csv('inData/dept.csv')
dept

#사번 ,이름 , 직책, 월급, 부서번호, 부서이름
sqldf("select empno,ename,job,sal,e.deptno,dname from emp e,dept d where e.deptno = d.deptno")

# 사번, 이름, 부서번호, 부서이름
sqldf("select empno, ename,e.deptno,dname from emp e join dept d on e.deptno=d.deptno")

# 2. 오라클 데이터 베이스 연결 
# 전작업 : 자바를 설치하고 환경설정(JAVA_HOME), 작업디렉토리에  ojbc6.JAR
# 패키지 설치 및 로드 : RJDBC
rm(list=ls())
install.packages('RJDBC')
library(RJDBC)
# 드라이버 클래스 로드 
drv <- JDBC(driverClass = "oracle.jdbc.driver.OracleDriver",classPath = "ojdbc6.jar")
drv
# 데이터베이스 연결
con <- dbConnect(drv,"jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger")
con
# SQL 전송+결과 받기(data.frame으로 돌아온다 . sql문 도출 값을 가져올 수 있다.)
emp <- dbGetQuery(con,"select * from emp")
emp
class(emp)
# 테이블 전체 데이터 조회 
dept <- dbReadTable(con,"dept")
dept

# SQL전송(update,insert delete) - DB 데이터 수정 
dbSendUpdate(con,"insert into dept values (50,'it','seoul')")
dbSendUpdate(con,"UPDATE DEPT SET LOC='inchon' WHERE DEPTNO=50")
dbSendUpdate(con,"DELETE FROM DEPT WHERE DEPTNO=50")

# 데이터베이스 연결 해제 
dbDisconnect(con)

# 드라이버 언로드 : DB연결 해제시 자동 언로드 됨
dbUnloadDriver(drv)


# 3. MySQL 데이터 베이스 연결
# MysQL workbench에서 관리자 계정 사용중이면 입력해주어야 한다
# ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql_native_password BY '비밀번호';
rm(list=ls())
install.packages('RMySQL')
library(RMySQL)
#드라이버로드
drv<- dbDriver('MySQL')
#데이터베이스 연결결
con<- dbConnect(drv,host='127.0.0.1',dbname='kimdb',user='root',password='mysql')
#SQL문장으로 가져오기
rs <- dbSendQuery(con,'select * from personal')
class(rs)
rs
personal <- fetch(rs,n=-1)
personal
class(personal)
#연결해제
dbDisconnect(con)
dbUnloadDriver(drv) #드라이버 언로드는 DB연결 해제시 자동으로 언로드 되기도 한다.
