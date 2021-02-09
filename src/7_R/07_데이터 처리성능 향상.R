

        ### 7. 데이터 처리성능 향상 ###

# plyr패키지(apply계열) , 데이터 구조변경(melt,cast), 데이터테이블

detach('package:dplyr',unload=T)
# 1.plyr패키지 : 데이터 분할, 함수적용 등을 사용하는 함수 포함. 
    # apply(),lapply(),sapply() 등을 보강할 수 있다.
install.packages('plyr')
library(plyr)
#xyply(.data,.group.....) ex.adply,ddply
apply(iris[,1:4],2,mean)
apply(iris[,1:4],2,function(col){mean(col)})
sapply(iris[,1:4],mean)
sapply(iris[,1:4],function(col){mean(round(col))})
x <- data.frame(v1=c(4,9,16),v2=c(16,81,196))
x
apply(x,2,function(col){mean(sqrt(col))})
# adply == apply(),sapply().... 비슷
adply(.data=iris[,1:4],.margin=2,function(col){sum(col)})

# ddply == summaryBy() 비슷
ddply(.data=iris,.(Species),function(group){data.frame(SLmean=mean(group$Sepal.Length),SWmean = mean(group$Sepal.Width))})

#summarise : 뒤에 나오는 변수들만 출력
ddply(iris,.(Species),summarise,SLmean=mean(Sepal.Length),SWmean=mean(Sepal.Width))
#transform : 기존에 iris 데이터와 뒤에나오는 변수들 출력
ddply(iris,.(Species),transform,SLmean=mean(Sepal.Length),SWmean=mean(Sepal.Width))

dfx <- data.frame(group=c(rep('A',8),rep('B',15),rep('C',6)),gender=sample(c('M','F'),size=29,replace = T),age= round(runif(29,min=18,max=54))) 
dfx
library(doBy)
ddply(dfx, .(group,gender),summarise,mean=round(mean(age),2),sd=round(sd(age),2))
summaryBy(age~group+gender,dfx,FUN=c(mean,sd))

# 2. 데이터 구조 변경 (melt,cast함수)

str(airquality)
install.packages('reshape2')
library(reshape2)
airquality.melt <- melt(airquality,id=c('Month','Day'),na.rm=TRUE)
airquality.melt
airquality[airquality$Month==5 & airquality$Day==1,]
subset(airquality,Month==5 & Day==1)
#melt를 통해 바뀐 구조 
airquality.melt[airquality.melt$Month==5&airquality.melt$Day--1,]
subset(airquality.melt,Month==5 & Day==5)

#melt된 데이터를 원상복구 : dcast vs acast
airquality.dc <- dcast(airquality.melt,Month+Day~variable) # Month,Day가 변수로 
airquality.dc

airquality.ac <- acast(airquality.melt,Month+Day~variable) # Month,Day가 행이름으로 변경됨
airquality.ac

# 3. 데이터 테이블 : 짧ㄱ고 유연한 구문 사용을 위해 데이터프레임에서 상속받음
flights_df <- read.csv('inData/flights14.csv')
head(flights_df)
flights_df

library(readxl)
exam<- read_excel('inData/exam.xlsx')
class(exam)
exam
install.packages('data.table')  #fread() : csv파일을 데이터 테이블로 받는 함수
library(data.table)
flights <- fread('inData/flights14.csv')
class(flights)
head(flights)

# flights_df(데이터 프레임), flights(데이터프레임,데이터테이블)

#1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul<- flights_df[flights_df$month==5 & flights_df$origin=='JFK',]
#2. 처음 두 행을 resul에 얻는다
resul <- head(resul,2)
#3. origin으로 오름차순, desc로 내림차순으로 정렬하여 출력
# 오름차
orderBy(~origin,flights_df)
# 내림차
flights_df%>%
    arrange(desc(origin))
#4. arr_delay열만 출력
flights_df[,"arr_delay"]
#5. year열부터 dep_time열까지 출력
colnames(flights_df)
flights_df[,1:4]
#6. year열과 dep_time열 출력
flights_df[,c(1,4)]
#7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
delay<-flights_df[,c('arr_delay','dep_delay')]
colnames(delay) <- c('delay_arr','delay_dep')
colnames(delay)
#8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
library(dplyr)
flights_df%>%
    filter(arr_delay<0 & dep_delay<0)%>%
    summarise('비행 횟수'=n())
#9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
flights_df%>%
    filter(month==6 & origin=='JFK')%>%
    summarise(mean_arr=mean(arr_delay),
              mean_dep=mean(dep_delay))
#10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
flights_df%>%
    filter(month==6 & origin=='JFK')%>%
    summarise(mean_arr=mean(arr_delay),
              mean_dep=mean(dep_delay))
#11. JFK 공항의 6월 운항 횟수
flights_df%>%
    filter(month==6)%>%
    summarise('운항횟수'=n())
#12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flights_df[flights_df$month==6,c('arr_delay','dep_delay')]
#13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
colnames(flights_df)
flights_df[flights_df$month==6,c(-5,-7)]
#14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
table(flights_df$origin)
#15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
AAF<- flights_df[flights_df$carrier=='AA',]
table(AAF$origin)
#16. origin, dest별로 비행횟수 출력
table(flights_df$origin)
table(flights_df$dest)
#17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
AAF<- flights_df[flights_df$carrier=='AA',]
table(AAF$origin)
table(AAF$dest)
#18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
library(doBy)
summaryBy(arr_delay+dep_delay~origin+dest+month,AAF,FUN=mean)
#19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
flights_df$depup0 <- ifelse(flights_df$dep_delay>0, T,F) 
flights_df$arrup0 <- ifelse(flights_df$arr_delay>0, T,F)
table(flights_df$depup0)
table(flights_df$arrup0)
#20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
summaryBy(dep_delay~month,flights_df,FUN=max)



















