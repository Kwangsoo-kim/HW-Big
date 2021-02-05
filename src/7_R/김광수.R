


# 문제 1

# v1
v1<-1:10
v1
# v2
v2<- v1*2
v2
# max_v
max_v <- max(v2)
max_v
# min_v
min_v <- min(v2)
min_v
# avg_v
avg_v <- mean(v2)
avg_v
# sum_v
sum_v <- sum(v2)
sum_v
# v3
v3 <- v2[-5]
v3
# 전체출력
cat( ' v1 =',v1,'\n','v2 =',v2,'\n','v3 =',v3,'\n','max_v =',max_v,'\n','min_v =',min_v,'\n','avg_v =',avg_v,'\n','sum_v =',sum_v)


# 문제 2

# m1
seq(10,38,2)
m1<- matrix(seq(10,38,2),nrow=3,byrow=T)
m1
# m2
m2 <- m1 + 100
m2
# m_max_v
m_max_v <- max(m1)
m_max_v
# m_min_v
m_min_v <- min(m1)
m_min_v
# row_max
row_max <- apply(m1,1,max)
row_max
# col_max 
col_max <- apply(m1,2,max)
col_max
# 전체 출력
cat(' m1 =',m1,'\n','m2 =',m2,'\n','m_max_v =',m_max_v,'\n','m_min_v =',m_min_v,'\n','row_max =',row_max,'\n','col_max =',col_max,'\n')

# 문제 3

#1
(seq(1,9,2))
#2
(rep(1,5))
#3
(rep(c(1,2,3),times=3))
#4
(rep(c(1,2,3,4),each=2))

# 문제 4
v3 <- seq(1,10,3)
v3
names(v3)<- list('A','B','C','D')
#names(v3)<-LETTERS[1:4]
v3

# 문제 5

count <- sample(1:100,7)
count
week.korname <- c('일요일','월요일','화요일','수요일','목요일','금요일','토요일')
week.korname
week.count<-data.frame(week.korname,count)
# 출력
cat(paste(week.korname,count,sep=':'))
# 가장 큰 값의 요일출력
week.count[which.max(week.count$count),1]
# 값이 가장 작은 값의 요일 출력
week.count[which.min(week.count$count),1]
# 50본다 큰 값에 해당하는 요일의 명칭
week.count[which(week.count$count>50),1]

# 문제 6

#m1
n1 <-c(1,2,3)
n2 <-c(4,5,6)
n3 <-c(7,8,9)
m1 <- matrix(c(n1,n2,n3),nrow=3) 
m1

# 문제 7

#m2
n1<-1:9
m2<- matrix(n1,nrow=3,byrow=T)
m2

# 문제 8

#m3
dimnames(m2)<-list(c('row1','row2','row3'),c('col1','col2','col3'))
m3<-m2
m3

# 문제 9

#alpha
alpha <- matrix(c(c('a','c','e'),c('b','d','f')),nrow=2,byrow=T)
alpha
#alpha2
alpha2 <- rbind(alpha,c('x','y','z'))
alpha2
#alpha3
alpha3 <- cbind(alpha,c('s','p'))
alpha3

# 문제 10

#a
a <- array(1:24,dim=c(2,3,4))
a
# (1)
a[2,3,4]
# (2)
a[2,,]
# (3)
a[,1,]
# (4)
a[,,3]
# (5)
(a+100)
# (6)
((a[,,4])*4)
# (7)
a[1,c(2,3),]
# (8)
a[2,,2]<- a[2,,2]+100
a
# (9)
a[,,1]<- a[,,1]-2
a
# (10)
a<-a*10
a
# (11)
a<- NULL
rm(a)

# 문제 11

#df1
df1 <- data.frame(c(1,2,3,4,5),c(2,4,6,8,10))
names(df1)<- list('x','y')
df1

# 문제 12

#df2
df2<- data.frame(c(1,2,3,4,5),c('a','b','c','d','e'),c(6,7,8,9,10))
names(df2)<-list('col1','col2','col3')
df2

# 문제 13

#df3
a<- c('사과','딸기','수박')
b<- c(1800,1500,3000)
c<- c(24,38,13)
df3<- data.frame(a,b,c)
names(df3)<- list('제품명','가격','판매량')
df3

# 문제 14

apply(df3[,2:3],2,mean)

# 문제 15 

name <- c('Potter', 'Elsa', 'Gates', 'Wendy', 'Ben')
gender <- factor(c('M', 'F', 'M', 'F', 'M'))
math <- c(85, 76, 99, 88, 40)
#df4
df4<- data.frame(name,gender,math)
df4
str(df4)

# (a)

df4$stat<-c(76,73,95,82,35)
df4
# (b)
df4$score<- df4$math+df4$stat
df4$grade <- NULL
df4
# (c)
df4$grade <- ifelse(df4$score>=150 , 'A', ifelse(df4$score>=100 , 'B','C'))
df4

# 문제 16
L1 <- list(c('scott'),c(3000))
names(L1)<- list('name','sal')
L1
result1<-L1[[2]]*2

# 문제 17
L2 <-list(c('scott'),c(100,200,300))
L2

# 문제 18
L3 <- list(c(3,5,7), c('A', 'B', 'C'))
L3[[2]][1]<- 'alpha'
L3   

# 문제 19
L4 <- list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
L4
L4[['alpha']]<-L4[['alpha']]+10
L4

# 문제 20

L5<-list(math=list(95, 90), writing=list(90, 85), reading=list(85, 80))
L5
score<-unlist(L5)
score
mean(score)

# 문제 21
#타입
class(iris)
#구조
str(iris)
#차원
dim(iris)
#변수이름
names(iris)
#기본통계량
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width~Species,iris,FUN=c(mean,sd,quantile))

# 문제 22 

orderBy(~-Petal.Length,data=iris)
orderBy(~-Sepal.Width,data=iris)

# 문제 23

table(iris$Species)

# 문제 24 

tapply(Sepal.Length,Species,sum)

# 문제 25

#apply
apply(iris[,-5],2,mean)
#lapply
lapply(iris[,-5],mean)
#sapply
sapply(iris[,-5],mean)
#종별 sepal.length평균
tapply(iris$Sepal.Length,iris$Species,mean)

# 문제 26
iris$Species[which.max(iris$Sepal.Length)]
