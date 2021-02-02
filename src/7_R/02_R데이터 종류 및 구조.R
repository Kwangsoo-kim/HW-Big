###################################################################################
################ 3 장. R 데이터 종류 및 구조 #################

# 1. 데이터 종류 : 기본데이터 타입(문자,숫자,logical) = 스칼라 타입 
        # 팩터, 벡터 ,리스트 ,행렬, 배열, 데이터프레임, 날짜, 특별한값 (결측치..)

# 2. 기본데이터 타입 : character, numeric, logical 
a <- 'Hello'
a <- 'Hello
r'
a
cat(a) # cat : print와 비슷, \n을 수행해준다.
cat('a 값은',a)
b <- 10.1
b <- 10
strb <- as.character(b) # as.*() : *타입으로 형변환 함수
strb
c<-TRUE
c
is.logical(c) # is.*() : *형 이나 값을 물어보는 함수





class(a) # class()함수는 타입을 확인
class(b)
class(strb)
class(c)

str(a) # str() : R의 내부 구조를 간결하게 표시시
str(b)
str(strb)
str(c)

# 3. 특별한 값(NULL,NA;결측치,NaN,Inf)
result<-0
add<- function(a,b){
  result <<-a*5+b # 전역변수 result에 할당
  # return(result)
  return()
}
(temp<-add(1,2))
(temp<-add(a=1,b=2))
(temp<-add(b=10,5)) # 남은변수는 자동으로 할당된다. 지정만 해준다면, 기입순서도 상관없음.
(temp<-add(a=1,b=3)) # NuLL ; Empty Value
is.null(temp) # is.* : *인지 확인

d <- c(2,4,NA,6,NaN,10/0)  # vector(동일자료형 집합)
d

# NA(결측치) 관련 함수
# complete.case() NA없으면 TRUE
na.omit(d) # 결측치 제외
na.pass(d) # NA여부 상관없이 처리
is.na(d) #결측치 여부 TRUE
mean(d) # 평균 계산 불가
?NA
?mean
d<-c(2,3,4,5,NA,12)
mean(d,na.rm=TRUE) # na,rm=TRUE NA 제가하고 평균내기
boxplot(d)
?boxplot

# 4. 팩터(Factor) : 범주형데이터, 명명식, 순서식에서 사용
gender1 <- c('남','남','여')
gender1[3]
class(gender1)
gender1
gender1[4] <- '중성'
gender <- factor(c('남','남','여'),levels=c('남','여'))
class(gender)
gender
gender[3]
gender[4]
gender[4] <- '남'
str(gender)
gender

# 순서식 변수 할당법
level <- factor(c('좋음','보통','보통'),levels=c('싫음','보통','좋음'),ordered=TRUE)
level
level <- ordered(c('좋음','보통','보통'),levels=c('싫음','보통','좋음'))
nlevels(level) # 변수의 범주 갯수 
levels(level) # 변수의 범주들 

class(gender)
gender1 <- as.factor(gender1)   # factor로 변환
class(gender1)
gender1

# 5. 구조형 변수와 복합형 변수 
  #(1) 구조형 변수 : 동일자료형만 가능
        # (ex. 벡터 , 행렬(회귀식 용이) , 배열)
  #(2) 복합형 변수 : 서로 다른 자료형 가질 수 있음
        # (ex. 리스트 , 데이터프레임(csv))

# 6. 벡터 : 동일자료형의 집합
data <- c(11,22,33,'TEST') #숫자,문자 -> 문자
data
data <- c(11,22,33,TRUE) # 숫자 , logical -> 숫자(T:1 , F:0)
data <- c(TRUE,'TEST') # logical, 문자 -> 문자
data

data <- c(1,2,3) # 1 index 부터 시작
data[4] <- 40
data

# 행과 열정보 조회
NROW(data) # 항목갯수(행갯수)
length(data) # 항목갯수
data <- c(1:4)
data
# 특정한 값 조회
names(data) <- c('A열','B열','C열','D열') # INDEX 이름 생성
data
data[1] # 첫번째값
data['A열'] # A열 값 반환
data[c(1,2)] # 첫번째 , 두번째 값 반환
data[c(1:2)] # 첫번째부터 2번째 까지의 값 반환
data[c('A열','B열')] # A열 B열 값 반환
data[-2] # 음수일 경우 2번째값 제외
data[data>2] # 2보다 큰 값만 반환
data[c(TRUE,FALSE,FALSE,TRUE)] # TRUE인 값만 반환
2%in%data # data에 2가 포함되어 있는지 여부 T/F 

# Q1. 시험점수 변수들 만들고 출력하고 전체 평균을 구한 후 출력
    # 80,60,70,50,90,미응시
    # yi,kim,yun,lim,lee,park
score<-c(80,60,70,50,90,NA)
print(paste('시험점수는',score))
cat(paste('시험점수는',score,collapse='\n'))
avg <- (mean(score,na.rm = TRUE))
avg
names(score) <- c('yi','kim','yun','lim','lee','park')
score
class(score) # class함수 이용시 벡터 요소 하나하나의 타입만 출력
is.vector(score) # 벡터인지?
is.vector(data)
is.vector(gender)

# 6.1 character()
charArr <- character() # charArr length가 0인 벡터
is.vector(charArr)
length(charArr)
charArr<- character(5)
charArr
charArr[1] <-'안녕';charArr[2]<-'R';charArr[3]<-'수업중'
# 6.2 numeric()
intArr<-numeric() # intArr length가 0인 벡터
class(intArr)
is.vector((intArr))
intArr[1]<-1
intArr[2]<-2
intArr[3]<-3
intArr[5]<-5
intArr # 중간 값을 할당안해주면 NA로 채워진다. 
# 6.3 logical()
logicArr = logical(2) # length 2인 벡터
logicArr
class(logicArr)
logicArr[1]<- TRUE
logicArr[3]<- FALSE
logicArr # 할당안한 값은 FALSE

# 6.4 seq() : 순서 객체를 만드는 함수
?seq
a <-seq(from=1,to=10)
a <-seq(from=1,to=10,by=2)  #앞에 변수 제거가능
a <- 1:10
is.vector(a)
a<-seq(10,-10,-2)
is.vector(a)
a<-seq(0,1,0.1)
is.vector(a)
seq(1,9,by=pi)

# 6.5 rep() : 반복 객체를 만드는 함수
a<-rep(1:4,each=2) # 2개씩 each
is.vector(a)
a<-rep(1:4,c(1,2,3,4)) 
a
a<-rep(1:4,times=2)
a

# 6.6 벡터의 연산(+,-,*,/,결합,교집합,차집합)

a<-c(1,2,3)
b<-c(10,20,30)
a+b
a-b
a^b # a의 b승
a%%b # 나머지 연산자
d <- c(a,b) # 벡터의 결합
d
a<-c(1,2,3)
b<-c('Hello','R')
c<-c(T,F)
(z<-c(a,b,c)) # 타입이 다르면 논리순으로 형변환 
is.vector(z)

a<-append(a,c(4,5,6))
a<-append(a,7)
length(a)

# 6.7 벡터의 집합연산


a<-c(1,2,3,4,5,6)
b<-c(2,4,6,8,10,12)
union(a,b) # 합집합
intersect(a,b) # 교집합
setdiff(a,b) # 차집합
setequal(a,b) #비교 , 두 벡터가 동일하면 T
setequal(a,c(intersect(a,b),setdiff(a,b)))

# 7. List
student<-list(name='홍길동',age=25)
student
studentvector <-unlist(student) # unlist 하면 vector로 변환됨. 스트링으로 변환
studentvector
class(studentvector)
is.vector(studentvector)
s<-c('홍길동',25)
names(s)<-c('name','age')
s
student<-as.list(s) # as.list 로 list로 변경 가능
student
student['name']
student$name
student[1] # $name [1] 홍길동
student[[1]] [1] 홍길동
student$age <- NULL # age 제거
student
NROW(student)
length(student)

# 8.행렬(Matrix)
colmatrix <- matrix(1:15,nrow=5,ncol=3) # 5행 3열 짜리 행렬
colmatrix
?matrix
colmatrix <- matrix(1:15,nrow=5,byrow=FALSE)
colmatrix
rowmatrix <- matrix(1:15,nrow=5,ncol=3,byrow=T,dimnames=list(c('R1','R2','R3','R4','R5'),c('c1','c2','c3')))
rowmatrix
dim(rowmatrix) # 행과 열의 수
nrow(rowmatrix) # 행수만
ncol(rowmatrix) # 열수만
dim(rowmatrix)<-c(3,5) # 3행 5열로 변경
rowmatrix 
dimnames(rowmatrix)
rownames(rowmatrix) #행이름
colnames(rowmatrix) #열이름
# 행이름과 열이름 수정

dimnames(rowmatrix)<-list(c('1월','2월','3월','4월','5월'),c('kim','lee','choi'))
rowmatrix 

# 행렬의 곱을 이용하여 선형회귀식 도출

x<- c(2,4) # 공부량
y<- c(40,60) # 점수
X<- matrix(c(x,rep(1,NROW(x))),nrow=2,ncol=2)
X
Y=matrix(y,ncol=1)
Y
# X%*%ab = Y
# solve(X) %*% X %*%ab = solve(X) %*%Y
ab <- solve(X)%*%Y
ab
ab[1] # x의 기울기
ab[2] # 절편
plot(x,y)
lines(x,y)
lines(x,x*ab[1]+ab[2])


x<- c(32,64,96,118,126,144,152.5,158) # 독립변수
y<- c(18,24,61.5,49,52,105,130.3,125) # 종속변수
Q<- matrix(c(x,rep(1,NROW(x))),ncol = 2)
W<- matrix(y,ncol=1)
Q
W
# Q%*%ab = W
# 전치행렬 곱해서 정방행렬
t(Q)
G <- t(Q)%*%Q  # 정방행렬 G
G

# Q %*% ab = W 
# t(Q) %*% Q %*% ab = t(Q) %*% W
# ab = solve(t(Q)%*%Q) %*% W  

ab = solve(G)%*%t(Q)%*%W
ab
ab
plot(x,y)
lines(x,x*ab[1]+ab[2])

# 다변량에서의 회귀분석 도출


x1<-c(60,65,55) #몸무게
x2<-c(5.5,5.0,6.0)#키
x3<-c(1,0,1)  #흡연유무
y<-c(66,74,78)
X<-matrix(c(x1,x2,x3),ncol=3)
Y<-matrix(y,ncol=1)
X
Y
# X %*% ab= Y
# solve(X) %*% X %*% ab = solve(X) %*% Y
# ab = solve(X) %*% Y
ab = solve(X) %*% Y
ab

# 80kg, 6.5ft, 금연 = 기대수명?
80*ab[1] + 6.5*ab[2] + 0*ab[3]

# 행렬 연산(+,*,-,/,%%,..,%*%)
a <- matrix(1:4,nrow=2,ncol=2)
a
b<-matrix(seq(10,40,10),nrow=2,ncol=2)
b
a+b
a*b
a^b
a%%b
a%*%b
payMatrix<-matrix(c(12000,26000,18000),ncol=3)
dimnames(payMatrix) <- list(c('시급'),c('철수','영희','말자'))
payMatrix # 1행 3열
workerMatrix <-matrix(c(c(5,4,9),c(7,3,2)),ncol=2)
dimnames(workerMatrix) <- list(c('철수','영희','말자'),c('1월','2월'))
workerMatrix # 3행 2열 

cost <- payMatrix %*% workerMatrix # 1x3 %*% 3x2 => 1x2
dimnames(cost)<-list(c('인건비'),c('1월','2월'))
cost

 # 9.배열
dataArray <- array(1:24,dim=c(3,4,2)) #3행 4열 2면 3차원 배열
dataArray
dim(dataArray) # 차원의 크기 조회
nrow(dataArray) # 행수 조회
NROW(dataArray)
ncol(dataArray) # 열수 조회
NCOL(dataArray)
length(dataArray) # 요소의 개수
dimnames(dataArray)<- list(c('1행','2행','3행'),c('1열','2열','3열','4열'),c('1면','2면'))
dataArray
dim(dataArray) <- c(2,6,2) #reshape
dataArray
dim(dataArray) <- c(4,6)
dataArray
attr(dataArray,'dim')<- c(6,4)
dataArray

  # 10. 데이터 프레임 ******************
  # (1) 데이터 프레임 생성
student_id<- c('21211','21212','21213','21214')
student_name<- c('jin','eric','den','kei')
student_eng<- c(60,85,90,95)
student_kor<- c(100,95,95,80)
student_gender <- c('남','여','남','여')
student_data<- data.frame(student_id,student_name,student_kor,student_eng,student_gender)

student_data
  # (2)데이터프레임 열 추가 및 삭제
student_data$mat<-c(100,100,99,98)
student_data
student_data$student_id<-NULL # 열 삭제
student_data
class(student_gender)
  # (3) 열의 형변환
student_data$student_gender<-as.factor(student_data$student_gender)
class(student_data$student_gender)
str(student_data) # 구조 보기
summary(student_data)
  # (4) 열이름 변경
student_data

install.packages("reshape")
library('reshape')
student <- rename(student_data,c('student_name'='Name'))
student <- rename(student,c('student_kor'='kor','student_eng'='eng','student_gender'='gender'))
student

names(student_data)<- c('name','kor','eng','gender','mat')
student_data

  # (5) 데이터 프레임 합치기 
    # 행으로 합치기 rbind
newStudent<-rbind(student_data,student)
newStudent
    # 열로 합치기 cbind
student
id=data.frame(student_id)
id
names(id)<- ('id')

student<-cbind(id,student)
student

student <- rbind(student,student)
student
  # 부분 데이터 조회
student[1,1] #1행1열
student[1,] #1행 데이터
student[,1] #1열 데이터
student[c(1:3),] #1~3행 데이터
student[,c(2,3,4,6)] #2,3,4,6열 데이터
student[c(-2,-4,-6),] #2,4,6행 외의 모든 데이터
student[,c(-1,-5)] # 1,5열 제외 모든 데이터
student[c(1:3),c(-1,-5)] #1~3행의 1,5열 제외 데이터 
  # 국어점수가 90점 이상인 데이터
subset(student,subset=(student_kor>=90))
subset(student,student$mat>99)
subset(student,select=c(1:4)) # 1~4열 모든 데이터 
subset(student,select=c(-1:-4)) # 1~4열 제외 모든 데이터
subset(student,select=c('name','kor','mat'))
   # 수학점수가 99점 이상인 여학생만 출력
subset(student,subset=(student_gender=='여'& mat>=99))
  # 처음 5행만
student[c(1:5),]
head(student)
# 처음 3행만
head(student,3)

edit(student)

emp<- read.csv(file.choose()) # 탐색기에서 선택한 scv파일을 emp변수에 할당
emp
head(emp)
class(emp)
typeof(emp)


# 1. 직원이름만 출력하기 
subset(emp,select='ename',drop=F) #데이터 프레임 형태로 반환
# 2. 직원이름, job, sal
subset(emp,select=c('ename','job','sal'))
# 3. 이름이 KING인 직원의 empno, job, hiredate, sal
subset(emp,subset=(ename=='KING'))
# 4. sal이 2000이상인 직원의 empno,ename,sal 
subset(emp,select = c('ename','empno','sal'),subset=(sal>=2000))
# 5. sal이 2000이상 3000이하인 직원의 ename, sal
subset(emp, subset=(sal>=2000 & sal<=3000),select=c('ename','sal'))


# 11. 타입 판별 및 타입 변환
head(emp)
tail(emp)
class(emp) # emp의 타입 
str(emp)
emp$deptno <-as.factor(emp$deptno)
str(emp)

class(iris)
edit(iris)
str(iris)
iris$Species <- as.character(iris$Species)
str(iris)
iris$Species <- as.factor(iris$Species)
str(iris)
levels(iris$Species)

  # 타입판별 
class(iris$Species)
is.factor(iris$Species)
str(iris$Species)


# 12. 문자열과 날짜 
name <- 'eric'
length(name) # 요소 갯수
nchar(name) # 문자 갯수

names<- c('eric','jin','larray','curly')
nchar(names) # 요소 마다 갯수 
length(names)

# 하위 문자열 추출하기 : substr
?substr

substr('ABCDEF',1,4) # 1~4번째 문자까지 출력
substr('ABCDEF',4,10) # 없는 번재 문자는 ""로 처리 
substr(names,1,2) # names 안에 각각의 문자 1~2번째 까지 추출

# name 안에 각각의 이름의 맨 마지막 자리의 앞 글자, 맨 마지막 글자
substr(names,nchar(names)-1,nchar(names))

# 문자열 연결하기 : paste, paste0
names<- c('eric','larray','curly')
paste(names,'loves','starts')
paste(names,'loves','starts',sep='_',collapse = ', and ')
paste0(names,'loves','starts') # 딱 달라붙음 

# 문.
name<- c('yun','lim','lee')
hobby<- c('swim','sleep','eat')
# 결과 yun의 취미는 swim이고 , lim의 취미는 sleep이고 , lee의 취미는 eat

cat(paste(name,sep='의 취미는 ',hobby,collapse='이고 , '))

# 문자열 분할 (구분자 분할하기)
path <- 'home/hadoop/data/speech.csv'
strsplit(path,'/') # /로 분할

customerInfo <- 'jin@gmail.com,010-9999-8888,seoul korea'
strsplit(customerInfo,',010-9999-8888')
customers <- c('jin@gmail.com,010-9999-8888,seoul korea',
               'yun@naver.com,02-304-2930,pusan korea',
               'lee@daum.net,011-504-5930,pusan korea')
strsplit(customers,'[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}')

# 문자열 대체 : sub(oldstr,newstr,String)
            # : gsub(oldstr,newstr,String)

s<-'Curly is the smart one. Curly is funny, too.'
sub('Curly','Eric',s) # 맨앞에 하나만 대체
gsub('Curly','Eric',s) # 전부 대체
gsub(' ','',s) #스페이스 없애기 













