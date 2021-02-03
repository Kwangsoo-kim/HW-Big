

        # 4장. R프로그래밍 : 제어문 , 연산자 ,function      

# 1. 제어문
# 1.1 조건문
# (1) if문
num<-9
if(num%%2==0){
    cat(num,'은 짝수')
}else{
    cat(num,'은 홀수')
}

# (2) ifelse()함수
ifelse(num%%2==0,'짝수','홀수')
nums<-c(10,9,16,17,20)
result<-ifelse(nums%%2==0,'짝','홀')

m<- matrix(c(nums,result),ncol=5,byrow=T,dimnames = list(c('수','홀짝'),c('1회','2회','3회','4회','5회')))
m           

# (3) switch()함수
switch(2,'red','green','blue')
x <- switch(4,'red','green','blue')
x

#사용자로부터 color값을 받아 해당 color를 출력

?readline
colorValue<- as.integer(readline(prompt = '컬러값은 ? (red:1, green:2, blue:3)'))
#readline으로 받는 값은 character값
colorValue
color<- switch(colorValue,'red','green','blue')
color

color<- readline(prompt = '컬러는(red,green,blue)')
colorValue<-switch(color,'red'=1,'green'=2,'blue'=3)
cat('선택한 색상',color,'의 색상값은',colorValue)

# 문. 점수(50~100)를 입력받아 학점을 계산하는 프로그램을 구현해 보세요 
# 100 -> perfect, 90점대 :A 80점대 :B 70점대: C 60점대 :D 50점대 :F
score <- as.integer(readline(prompt = '점수는(50~100)?'))
score
ss<- (score/10)-4
ss
result <- switch(ss,'F','D','C','B','A','perfect')
result

getgrade<-function(){
    score <- as.integer(readline(prompt = '점수는(50~100)?'))
    ss<- (score/10)-4
    result <- switch(ss,'F','D','C','B','A','perfect')
    cat('입력한 점수:',score,'학점:',result)
}
getgrade()

# 1.2 반복문 : for, while, repeat
# (1)for문
1:10
seq(1,10)
seq(10)
x<- c(-2,5,4,8)
for(val in x){
    cat(val,',')
}
count<-0
for(val in x){
    if(val%%2==0){
        count=count+1
    }
}
count
# 10회 반복
for(val in 1:10){
    cat('hi')
}

# factorial 계산 함수를 작성하시오
factorial(3) #3*2*1
?factorial
#fact(3)의 결과 : 3! =6
#fact(-3)의 결과 : 음수값을 위한 팩토리얼은 존재하지 않아요
result= 1
x= 3
for(val in seq(x)){
    result= result*val     
}

result

fact<- function(x){
    if(x==0){
        cat('fact(',0,')의 결과 :',1)
    }else if(x>0){
    result= 1
    for(val in seq(x)){
        result= result*val     
    }
        cat('fact(',x,')의 결과 :',result)
    }else if(x<0){
        cat('음수값을 위한 팩토리얼은 존재하지 않아요')
    }
    
}
fact(0)
fact(1)
fact(2)
fact(3)
fact(4)
fact(5)
getwd() # 현재 working 디렉토리
source('fact.R',encoding = 'utf-8')
fact(10)

# (2)while
i<-1
while(i<6){ # 조건이 참이면 반복
    print(i)
    i=i+1
}

# (3) repeat : 반복
i<-1
repeat{
    if(i>6) break
    print(i)
    i<-i+1
}

# (3) break,next(자바에서 continue)
x<-1
while(x<10){
    x<-x+1
    print(x)
    if(x==3) 
    next
}

# 2. 연산자
# 2.1논리연산자 &,&&,|,||
TRUE & TRUE
x<- c(T,T,F,F)
y<- c(T,F,T,F)
x & y # 모든 요소를 다 체크
x && y # 첫번째 요소만 체크
x|y
x||y

# 2.2 중위연산자
5+8
'+'(5,8)
'%add%' <- function(x,y){
    return(x+y)
}
'%add%'(5,8)
5%add%8
c<-c(10,23,30)
10%in%c # %in% : 매칭연산자
strings <- c('hello','world','R')
strings%in%'R'

# %o% : 외적
# %*% : 내적(행렬의 곱)

a<-c(2,3,4)
b<-c(10,20,30)
a%o%b
a<-c('1','2','3')
b<-c('a','b','c')
outer(a,b,FUN=paste)

matrix.a<-matrix(1:6,nrow=3)
matrix.a
matrix.b<-matrix(1:6,nrow=3)
matrix.b
matrix.a%o%matrix,b #a의 열과 b의행의 수가 맞지않아 실행 불가
solve(matrix.a)


# 3.함수
pow <- function(x,y){
    return(x^y)
}
pow
pow(3,4)
pow(2,8)

#가변 인자 함수 total total(1) total(2,3,4)
total<- function(...){
    args <- list(...)
    sum <- 0
    for(val in args){
        sum <- sum+val
    cat(val,'까지 합:',sum,'\n')
    }
    return(sum)
}
total()
total(1)
total(5)

total(10,2,3,5)

# 재귀호출; 함수 내에서 자기 함수를 호출하는 함수

fact<-function(num){
    if(num<0){
        return()
    }else if (num==1){
        return(1)
    }else {
        return(num*fact(num-1))
    }
}
fact(5)
fact(0)
# fact(3) = 3*fact(2)= 3*2*fact(1)
# fact(num)= num*fact(num-1) (단, num이 1보다 클 때, fact(1)=1)

# 4. R환경
environment()
ls()
f <- function(f_x){
    g <-function(g_x){
        print('g함수 안')
        print(environment())
        print(paste('g 함수 영역에서 변수들',ls()))
    }
    g(5)
    print('f함수 안')
    print(environment())
    cat('f함수 영역에서의 변수들',ls())
}
f(10)

#문 소수찾기 함수
is.pn <- function(x){
    flag =F
    if(x==2){
        return(T)
    }else if(x>1){
        flag=T
        for(i in 2:(x-1)){
            if((x%%i)==0){
                flag=F
                break
            }
        }
    }
    return(flag)
}
is.pn(2)















