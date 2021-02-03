
        
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












