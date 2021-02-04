
        
        ## 5장 . 데이터 전처리

# 1. 파일 입출력

# 1.1 시스템 인코딩 조회
Sys.getlocale()

# 1.2 write.table : 데이터를 파일에 저장
iris
class(iris)
write.table(iris,file='outData/iris2.csv',sep=',',row.names = F)
InsectSprays
str(InsectSprays)
write.table(InsectSprays,file='outData/insect.csv',sep=',',row.names = F)


# 1.3 read.table : 파일을 읽어 데이터프레임 형태로 저장
irisData <- read.table('outData/iris.csv',header = T,sep=',')
?quote
head(irisData)
tail(irisData)
str(irisData)
irisData$Species<-as.factor(irisData$Species)
irisData
str(irisData)
irisData$Species<-factor(irisData$Species,levels=c("setosa","versicolor","virginica"))
irisData
str(irisData)

# 1.4 write.csv
write.csv(iris,file='outData/iris1.csv') # quote=F 더블커테이션 제거
# 1.5 read.csv
newData<-read.csv(file='outData/iris1.csv') #stringasfactor=T : char들을 펙터로 변환시켜줌.
newData
str(newData)
newData$X <- NULL

# 1.6 cat : 분석 결과 등을 저장할 때
irisSummary <- summary(newData)
irisSummary
class(irisSummary)
irisSummary[1,]
nrow(irisSummary)
cat('iris 요약 :','\n',file='outData/irisSummary.txt')
for(i in 1:6){
    cat(irisSummary[i,],'\n',file='outData/irisSummary.txt',append=TRUE)
}
# cat('iris 요약 : ','\n',irisSummary,file='outData/irisSummary.txt',append=T,Encoding='utf-8')


# 2. apply계열 함수 적용
# 2.1 apply : 
# iris 데이터의 열별(평균,합계,분산,표준편차,최소값,최대값)
    # apply(대상자료료,1또는2,함수이름)
iris[,1:4]
iris
apply(iris[,1:4],1,mean) # 행별 평균
apply(iris[,-5],2,mean) # 열별 평균
# setosa,versicolor,verginica 종을 분류하고 각각의 열별 평균 구하기
subset(iris,iris$Species=='setosa')
apply(subset(iris,iris$Species=='setosa')[,-5],2,mean)
apply(subset(iris,iris$Species=='versicolor')[,-5],2,mean)
apply(subset(iris,iris$Species=='virginica')[,-5],2,mean)

apply(iris[,-5],2,sd) #열별 표준편차
# 분산 = 표준편차*표준편차
apply(iris[,-5],2,sum)#열별 합계
apply(iris[,-5],2,median) #열별 중앙값
apply(iris[,-5],2,min) # 열별 최소값
apply(iris[,-5],2,max) # 열별 최대값

str(InsectSprays)
# InsectSprays에서 count의 표준편차
sd(InsectSprays$count)

name<-c('김','홍','박','이','윤')
kor<-c(90,50,70,60,100)
eng<-c(100,40,50,60,70)
mat<-c(90,91,50,64,80)
student <- data.frame(name,kor,eng,mat)
student
# 학생별 평균 , 과목별 평균
apply(student[,-1],1,mean) #학생별
apply(student[,-1],2,mean) #과목별
apply(student[-1],2,quantile)

# 2.2 lapply : list apply (결과도 list)
x<- list(a=1:10,beta=exp(-3:3),logic=c(T,F,F,T))
exp(-3:3) # e의 -3승부터 e의 3승까지 출력되는 지수함수
x
lapply(x,mean)
lapply(x,quantile)
lapply(x,quantile,1:3/4)

# 2.3 sapply : lapply와 유사하나 결과가 행렬이나 벡터로 봔환
sapply(x,mean)
sapply(x,quantile)
sapply(x,quantile,1:3/4)

fivenum(0:10)
i39 <- sapply(c(3:9),seq)
i39
sapply(i39, fivenum)
lapply(i39,fivenum)

# 문, iris 데이터를 lapply와 sapply를 이용하여 sepal.length~ petal.width까지의 평균을 구해라
irisList <- as.list(iris[,1:4])
irisList

lapply(iris[,-5],mean)
sapply(iris[,-5],mean)
apply(iris[,-5],2,mean)

# 2.4 vapply : sapply에 FUN의 모든 값이 특별 value타입과 호환되는지 확인 후 출력함
vapply(irisList,mean,numeric(1))
vapply(i39,fivenum,c(numeric(1),numeric(1),numeric(1),numeric(1),numeric(1)))

citis<-c('seoul','busan','new york','tokyo')
citis
nchar(citis[1:4])
sapply(citis,nchar)
lapply(citis,nchar)
vapply(citis,nchar,numeric(1))


# mapply : apply 처럼 보이나 여러개의 인자를 함수에 전달
rep(c(1,2,3),3)
x<- c(1,2,3,4)
mean(x)
mapply(rep,x=1:4,times=4:1) #rep(1,4) rep(2,3) rep(3,2) rep(4,1)
?mapply


# 직업별 수입
job<-c(3,3,5,2,2,3,5,3,4,4,6,3)
income<-c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust<-data.frame(job,income)
cust
income.avg <- c(900,0,3500,3600,3700,3800,3900,4000)
income.avg
names(income.avg)<-0:7
income.avg
income.avg[2]
zero2mean <- function(job,income){
    return(ifelse(income==0,income.avg[as.character(job)],income))
}
zero2mean(cust$job,cust$income)
cust$income1<-mapply(zero2mean,cust$job,cust$income)
cust$income1
cust


# 3. 데이터 그룹화 함수 적용

# 3.1 tapply : 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length,iris$Species,mean)
tapply(iris$Sepal.Length,iris$Species,sd)
boxplot(iris$Sepal.Length~iris$Species)

# 직업군별 평균 income을 출력
cust$job <- factor(cust$job,levels=0:7)
cust$job
tapply(cust$income,cust$job,mean)
tapply(cust$income1,cust$job,mean) # 값이 없는 그룹은 NA
tapply(cust$income1,cust$job,mean, default=-1) #default 값은 NA값을 대체

datasets::InsectSprays
str(InsectSprays)
# spray의 종류에 따른 살충효과를 점검해보세요 
tapply(InsectSprays$count,InsectSprays$spray,mean)
tapply(InsectSprays$count,InsectSprays$spray,sd)
boxplot(InsectSprays$count~InsectSprays$spray)

# tapply단점 : 한번에 두개 이상의 함수를 처리하지 못한다. 한번에 두개 이상의 열을 처리하지 못한다. 

# 3.2 by : 그룹화 처리를 위한 apply (함수를 2개 이상 사용 가능)
by(iris[,1:2],iris[,5],min)
by(iris[,1:4],iris$Species,summary)
cust
# cust의 직업별 평균을 income과 income2를 한꺼번에 
by(cust[,2:3],cust$job,summary)

# 3.3 doby 패키지
install.packages('doBy')
library(doBy) # 따옴표 생략가능 
summaryBy(Sepal.Length+Sepal.Width~Species,iris) # 함수명은 default mean
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width~Species,iris,FUN=c(mean,sd))

# 문. emp.csv파일의 데이터를 받아 부서별 급여, 상여금을 비교하시오

emp <- read.table('inData/emp.csv',header=T,sep=',')
emp

emp$deptno <- as.factor(emp$deptno)
str(emp)
emp
by(emp[,6:7],emp$deptno,summary)
summaryBy(sal+comm~deptno,emp, na.rm=T,FUN=c(mean,sd)) # na.rm=T NA값 무시
## summaryBy(emp$sal+emp$comm~emp$deptno,emp)

# (2) orderBy : 정렬
orderBy(~Sepal.Length,data=iris) # 앞에 정렬 기준을 둔다. 기본적으로 오름차순
orderBy(~-Sepal.Length,data=iris) # fomula앞에 - 붙이면 내림차순순
orderBy(~Species+Sepal.Length, data=iris) # 1차적으로 Species 순 2차적으로sepal.length순

# 종별,Sepal.Length 오름차순으로 정렬한 데이터를 Sepal.Length,Sepal.Width,species만 출력

orderBy(~Species+Sepal.Length,data=iris)[,c(1,2,5)]

# 문. emp 데이터셋에서 월급이 적은 순으로 ename,sal을 추출

orderBy(~sal,data=emp)[,c('ename','sal')]
# 문. 월급이 적은 순 5명만 ename,sal
orderBy(~sal,data=emp)[1:5,c('ename','sal')]

# (3) sampleBy : 샘플링

sampleBy(~Species,data=iris,frac=0.1) # group별 20%씩 표본 추출. 추출값은 랜덤(비복원추출- 중복이 없음)
sampleBy(~Species,data=iris,frac=0.1,replace = T) #복원 추출 - 중복가능
sampleBy(~Species,data=iris,frac=0.1,systematic = T) # 계층적 추출- 추출값을 기준에 따라 선별


##### 벡터 샘플링
idx<- sample(1:150,70)
idx
iris[idx,] # 전체에서 70개 임의로 샘플링


# 4. formula 
## lm() 선형회귀식 도출 함수(독립변수,종속변수 연속적 변수에서 사용가능)
x <- c(1,2,3,4,5) # 공부량 , 독립변수
y <- c(20,41,59,81,99) # 점수, 종속변수 - 회귀분석 :lm() 함수 이용
y1 <- c('F','F','F','P','P') # 당락여부, 종속변수 - 로지스틱회귀 : glm() 함수 이용
fit<-lm(y~x)
fit
plot(x,y,col='blue')
lines(x,x*19.8+0.6,col='red')
abline(fit,lty='dashed')

# 독립변수가 2개
x1 <- c(1,2,3,4,5) # 공부량
x2 <- c(10,20,3,4,5) # 기출문제 푼 개수
y <- c(50,70,63,84,95) # 종속변수

fit<- lm(y~x1+x2) # x1과 x2 사이의 상관관계가 없다가 전제여야 한다. 
fit

#cars
cars
?cars # 속도에 따른 제동거리의 관계를 회귀식으로 도출
fit <-  lm(cars$dist~cars$speed)
fit
plot(cars$speed,cars$dist)
abline(fit,col='red')
lines(cars$speed,cars$speed*3.932-17.579, col='blue')

# 5. 데이터 분리
# 5.1 split
iris.species <- split(iris,iris$Species) # list형태로 분리
iris.species
iris.species$versicolor
iris.sepal <- split(iris,iris$Sepal.Length>5)
iris.sepal
iris.sepal['FALSE']

# 5.2 subset
# 문. setosa 종 중 sepal.length,petal.length 열 출력
sp<-subset(iris,subset=(iris$Species=='setosa'),select = c('Sepal.Length','Petal.Length'))
sp
#문. setosa 종 중 sepal.length,sepal.width,petal.length,petal.width 열 출력
setosa <- subset(iris,subset=(iris$Species=='setosa'),select= -5 ) 
setosa
#문. setosa 중 sepal.length가 4이상인 데이터 
sl4up <- subset(iris,subset=(iris$Species=='setosa' & iris$Sepal.Length>=4))
sl4up

# 6. 데이터 합치기 
# 컬럼합치기 cbind()
# 행 합치기 rbind()
# 병합하기 merge()
# 6.1 cbind() 
student.a <- data.frame(name=c('yi','kim'),score=c(100,90))
student.a
student.b <- data.frame(id=c(100,101),gener=c('여','남'))
student.b
student <- cbind(student.a,student.b)
student

# 6.2 rbind() 
student.a <- data.frame(name=c('yi','kim'),score=c(100,90))
student.b <- data.frame(name=c('park','yun'),score=c(99,91))
student <- rbind(student.a,student.b)
student

# 6.3 merge() 
student.a <- data.frame(name=c('yun','kim'),kor=c(100,90))
student.b <- data.frame(name=c('yi','kim'),eng=c(90,89),mat=c(70,90))
student <- merge(student.a,student.b,all=T) # all=T 결측치NA로 전부출력
student

# 7. 데이터 정렬
# sort() ; 정렬된 데이터 반환/ order() ; 정렬된 데이터의 index 반환
data <-c(10,30,50,90,50,1,3,6)
sort(data) # 오름차순
sort(iris$Sepal.Length,decreasing = T) #decreasing = T 내림차순 
names(data)<- 1:8
data
order(data) # 데이터의 오름차순 index 반환 
## sort(data) = data[order(data)]

# iris 데이터를 sepal.length를 기준으로 내림차순 정렬
order(iris$Sepal.Length,decreasing = T)
iris[order(iris$Sepal.Length,decreasing = T),]



# iris 데이터를 sepal.length(내림차순),sepal.width(오름차순)

iris[order(-iris$Sepal.Length,iris$Sepal.Width),]


# emp 데이터 셋에서 월급이 많은 순으로 ename,sal을 추출

emp[order(-emp$sal),c('ename','sal')]

# emp 데이터셋에서 월급이 많은 top 5명의 ename, sal을 추출

emp[order(-emp$sal)[1:5],c('ename','sal')]

# emp 데이터셋에서 월급이 적은 top 5명의 ename, sal을 추출

emp[order(emp$sal)[1:5],c('ename','sal')]


# 8. 데이터 프레임 이름 생략하기 
# 8.1 with절, within절 
iris.temp <- iris
iris.temp[c(1,3),1]<-NA
# 종별 중앙값
mps <- tapply(iris.temp$Sepal.Length, iris.temp$Species,median, na.rm=T)
mps
split(iris.temp$Sepal.Length,iris.temp$Species) # 결과는 list
mps <-sapply(split(iris.temp$Sepal.Length,iris.temp$Species),median,na.rm=T)
mps
iris.temp$Sepal.Length2 <- ifelse(is.na(iris.temp$Sepal.Length), mps[iris.temp$Species], iris.temp$Sepal.Length)

head(iris.temp[,c('Sepal.Length','Sepal.Length2')])
iris.temp$Sepal.Length2 <- NULL
# with 절은 Sepal.Length의 결측치가 대치된 결과값을 반환
# within 절은 Sepal.Length의 결측치가 대치된 데이터 프레임 셋이 반환
iris.temp2<- within(iris.temp,{
    mps <- tapply(Sepal.Length, Species, median,na.rm=T)
    Sepal.Length <- ifelse(is.na(Sepal.Length),mps[Species],Sepal.Length)
}) 
iris.temp2
head(iris.temp)
iris.tmep$Sepal.Length


# 8.2 attach(), detach()
attach(iris) # 이부분 아래는 iris$를 생략해도 되는 구간
summary(Species)
Sepal.Length
tapply(Petal.Length,Species,mean)
detach(iris)

# 9. 데이터 집계계
# 9.1 table
table(iris$Species)
emp= read.csv('inData/emp.csv',header=T)
table(emp$ename) # factor 변수가 아니라면 집계가 무의미하다.
table(emp$deptno)

head(InsectSprays)
# InsectSprays 데이터 셋에서 spary별 집계
table(InsectSprays$spray)
# emp 데이터 셋에서 deptno 별 집계
emp$deptno <-factor(emp$deptno,levels=seq(10,40,10))
str(emp$deptno)
table(emp$deptno)

# 9.2 aggregate : 데이터를 하위집합으로 분할하고 요약 통계 계산
aggregate(iris[,1:4],by=list(iris$Species),mean)

# 보험회사의 고객들이 보험금을 청구하는 데이터에서 고객별 입원일 조회하려
cust_id <- c(5936,5936,5936,1043,8545,4734,9416,20267,2778,9019,9019,9019,6989,3372,1274,21906,3362,3362,16781,294)
hosp_day <- c(2,2,2,6,0,4,0,23,29,13,13,13,13,0,0,13,0,12,23,0)
data_claim <- data.frame(cust_id,hosp_day)
data_claim
day_per_cust <- aggregate(data_claim$hosp_day,by=list(data_claim$cust_id),sum)
day_per_cust
names(day_per_cust)<- c('cust_id','day')
day_per_cust[order(day_per_cust$day),]

## 같은 결과
# 대상열이 하나이상 가능, FUN은 하나만 
aggregate(data_claim$hosp_day,by=list(data_claim$cust_id),sum)
# 대상열 하나만 가능
tapply(data_claim$hosp_day,data_claim$cust_id,sum) 
library(doBy)
#FUN을 두개 이상 가능
summaryBy(hosp_day~cust_id,data=data_claim,FUN=c(sum,mean))

# 10. 조건으로 색인찾기 : which()
subset(iris,iris$Species=='setosa') # 조건으로 데이터 추출
which(iris$Species=='setosa') # 조건으로 색인 추출출
iris[which(iris$Species=='setosa'),]
which.max(iris$Sepal.Length)
iris[which.max(iris$Sepal.Length),] # sepal.length가 제일 큰 행




