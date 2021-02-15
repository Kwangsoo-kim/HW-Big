
        
            # # # 데이터 시각화 # # #


# 시각화 : 원본데이터, 분석된 결과 데이터를 그래프로 표현. 사용자에게 효과적으로 정보전달이 목적

# R의 그래픽 시스템 
# (1) base graphics system - 전통적인 함수 이용.정교한 그래프 이용시 노력이 필요하다. 
    # 그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 주의.


# (2) grid graphics system - base graphics system 한계 극복을 위해 탄생한 패키지(ggplot2)
    # 유연한 그래프 환경 제공

library(ggplot2)
ggplot(data=mtcars,aes(x=wt,y=mpg))+ 
    geom_point()+
    labs(title='그래프 첫 예제')+
    geom_smooth()

# 1.2 그래프 함수
    # 고수준 그래프 함수 : plot, barplot,boxplot,hist,pie,...
        # 그래프 함수를 호출할 때 마다, 그래프 영역에 새로운 그래프를 시작
    # 저수준 그래프 함수 : lines, abline(회귀라인), point, text,....
        # 그래프 함수를 호출할 때, 이미 그려진 그래프 위에 점, 라인, 글씨를 추가함.

# 1.3 그래프 파라미터
# (1) par() : 그래프를 조정하거나 특성을 지정
        # par()함수의 리턴값은 실행전의 특성을 리턴한다다

plot(cars)
oldpar <- par(bty='o')
plot(cars)
plot(iris)
par(oldpar) # oldpar 설정으로 복귀
plot(cars)  # 고수준 그래프 함수
fit <- lm(dist~speed,data=cars) #회귀함수 lm()
fit
abline(fit,col=2) # 저수준 그래프 회귀라인인

# par 함수의 다른 파라미터
x<- 1:100
y1<- rnorm(100) # 평균이 0이고 표준편차가 1인 수 100개 추출                         (표준정규분포)
y2<- rnorm(100)+100 # 평균이 100이고 표준편차가 1인수 100개 추출                     (정규분포)
oldpar<- par(mar=c(5,5,5,5)) # 그래프 여백(하,좌,위,우)
plot(x,y1,pch=20,type='b',col='red1',ylim=c(-3,3),yaxt='n',bty='n',ylab='') 
# pch ; 0:네모, 1:원 , 2:세모 3:십자, 4::x,... 문자넣으면 해당문자로
# type; p-점 , l-선 , b-점선동시 , o- 점섬겹치면서 동시에, h-히스토그램 s- 계단모양, n-좌표x
# col ; 1-black, 2-red, 3-green, 4-blue, 5-cyan, 6-purple, 7-yellow..
# ylim,xlim; y축 눈금 x축 눈금 조정 
# yaxt,xaxt ; y,x축 눈금 없애기
# bty; 그래픽 박스 타입 
# ylab,xlab; 라벨 설정 
axis(side=2,at=c(-2,0,2))
    # side; 1하,2좌,3위,4우우
    # at; 위치
?axis
mtext('red line(y1)',side=2,line=2,at=0)
colors()
par(new=TRUE)# 기존 그래프영역을 지우지 않고 덧그림
plot(x,y2,pch=1,type='b',col='blue1',yaxt='n',ylim=c(98,108),bty='n',ylab = 'n')
axis(side=4,at=c(98,100,102))
mtext('blue line(y2)',side=4,line=2,at=100)

par(oldpar) #그래프 영역 설정 원상복구
?par

# 2. 고수준 그래프 함수 
# 2.1 plot ; type에 따라 여러 유형의 그래프를 그림. 산점도 그래프 함수
?plot
plot(cars,main='speed and stopping distance of cars',xlab='speed(mph)',ylab='stopping distances(ft)',las=1)
    #las; 축눈금라벨방향- 0:축과평행, 1:가로, 2:축과수직,3:세로

# 2행 3열로 그래프 영역분리하고 type속성에 따른 그래프 그리기
oldpar<-par(mfrow=c(2,3))
plot(cars,type='p',main='p타입입') # 일반적인 산점도
plot(cars,type='l',main='L타입') # 추세선
plot(cars,type='b',main='b타입') # 선과 점 겹치지않게 
plot(cars,type='c',main='c타입') # 끊기는 선
plot(cars,type='s',main='s타입') # 계단타입
plot(cars,type='n',main='n타입') # 내용없음
plot(cars,type='o',main='o타입') # 선과 점 겹치게
par(oldpar)

# 2.2 barplot : 막대그래프

barplot(VADeaths,main='버지니아주 사망율',font=2,border='gray',legend=rownames(VADeaths),angle=c(10,30,50,70,120),density=100,col=topo.colors(5),beside=T)
#legend(오른쪽 상단 범례.)
#angle(막대그래프 마다 빗금.)
#density(막대그래프 안에 칠 할 선 수),
#beside(막대그래프 모양 변경)

# 2.3 boxplot : 사분위수 그래프 
InsectSprays
boxplot(InsectSprays$count)
boxplot(count~spray,data=InsectSprays,col='tan1')
tapply(InsectSprays$count,InsectSprays$spray,median)

# 2.4 histogram :히스토그램(도수분포표)
x <-c(1,1,2,2,2,3,4,4)
hist(x)
h <-hist(x,breaks=c(0,1,2,3,4))
    # breaks ; 구간
h
text(h$mids,h$counts,h$counts,adj=c(0,0),col='red')
text(h$mids,h$counts,h$counts,adj=c(1,0),col='blue')
text(h$mids,h$counts,h$counts,adj=c(0,1),col='green')
text(h$mids,h$counts,h$counts,adj=c(1,1),col='purple')
    #adc : 위치 재조정
islands # 주요 대륙 넓이 정보 
class(islands)
is.vector(islands)
hist(sqrt(islands),breaks=c(2,35,70,100,140))

# 2.5 pie 
pie.sales <-c(0.1,0.3,0.2,0.15,0.1,0.15)
sum(pie.sales)
names(pie.sales) <- c('c','java','python','r','oracle','hadoop')
pie.sales
pie(pie.sales) #반시계 반향으로
pie(pie.sales,clockwise = T,col=c('red','orange','yellow','green','white','cornsilk')) #시계방향으로

# 2.6 mosaicplot
Titanic
class(Titanic)
mosaicplot(Titanic,color=T)
mosaicplot(~Sex+Age+Survived, data=Titanic, color=T)

# 3. 저수준 그래프 함수
# 3.1 points
plot(-4:4,-4:4, type='n')
points(rnorm(100),rnorm(100),col='blue',pch=5)
rnorm(100) # 평균이 0이고 표준편차가 1인 표준정규분포데이터 100개 난수 생성 

# 3.2 lines
plot(cars,main='speed&distance')
fit <- lm(dist~speed,cars)
fit # y = 3.932*x  -17.579
lines(cars$speed, 3.932*cars$speed-17.579,col='blue')

# 3.3 abline : 회귀식선
abline(fit, col='red' ,lty='dashed')
    # lty : 라인의 스타일 
?abline
?par

# 3.4 text(x,y,출력할 텍스트, 그 외 옵션들)
plot(1:5,1:5,type='n')
text(3,3,'A',adj=c(0,0),col='red')
text(3,3,'A',adj=c(-5,-5),col='blue')
text(2,4,expression(hat(beta)==(X^t*X)^{-1}*(x^t*y),cex2))



# 4. ggplot2 패키지 함수
library(ggplot2)
# 1: 그래프초기화(데이터셋, 변수설정) - 그 자체로는 그래프 표현 x 
# 2: 그래프의 결과물에 대응하는 geom함수
# 3: 제목, 부제목 ,캡션 ,축이름 등 부가 요소를 추가가

mtcars
ggplot(data=mtcars,aes(x=wt,y=mpg))+
    geom_point(aes(size=mpg,color=cyl))+        #산점도
    labs(title="wt& Fuel consumpation", 
         x= "weight(1,000lbs)",
         y= "Fuel consumption (miles per gallon)",
         subtitle="(차량 무게와 연비와의 관계)",
         caption = "출처 : mpg datasets")

# x축 iris$petal.length, y축 iris$petal.width의 산점도 
# 점의 색은 종에 따라 다르게 그리시오 

ggplot(data=iris,aes(x=Petal.Length,y=Petal.Width))+
    geom_point(aes(color=Species))+
    scale_color_manual(values = c('black','red','orange'))+
    labs(title="iris 데이터의 산점도",
         x = "꽃잎 길이",
         y = "꽃잎 너비")+
    coord_cartesian(ylim=c(0,2))+
    geom_smooth()

head(airquality)
# airquality$Ozone 과 airquality$Solar.R 과의 관계를 표현하는 산점도 
    # 월별 점의 색깔을 달리 표현합니다. 

ggplot(data=airquality,aes(x=Ozone,y=Solar.R))+
    geom_point(aes(color=Month))+
    labs(title='오존량과 태양복사량과의 관계')+
    geom_smooth(method = "lm")

ggplot(data=mtcars, aes(x=wt,y=mpg))+
    geom_point(shape=25,color='blue',bg='red',size=3,stroke=2)+
# shape ; par에서 pch와 같다
# stroke ; 테두리 두께, size ; 크기 
geom_smooth(method='lm',color='red',size=2,linetype=2)+
    geom_text(label=rownames(mtcars),hjust=0,vjust=0,size=3,nudge_y=0.5)+
    labs(x="차량 무게 (1,000lbs)",
         y="연비",
         title="차량 무게와 연비와의 관계",
         subtitle="(부제목)",
         caption="참조:datasets의 mtcats")

# 4.2 히스토그램
rm(list=ls())
head(mtcars)
dim(mtcars)
str(mtcars)
mtcars$cyl <- factor(mtcars$cyl,levels=c(4,6,8),
                     labels=c('4 cylinders',
                              '6 cylinders',
                              '8 cylinders'))

ggplot(data=mtcars,aes(x=mpg))+
    geom_histogram()+
    facet_grid(cyl~.)+  # 3개의 패널에 그리는 함수. 그룹화
    labs(title="cyl에 따른 연비 히스토그램",x="연비",y="개수")

# 연속형 변수는 히스토그램으로 나타낸다.(범주형의 도수분포에는 사용불가)
ggplot(data=mtcars,aes(x=cyl))+
    geom_histogram() # cyl데이터가 범주형이라 에러난다. 범주형은 bar등 사용

# ggplot2::mpg 데이터셋에서 displ의 도수분포표 출력(class에 따라 그래프의 색상을 달리 표현함)
str(mpg$displ)
ggplot(data=mpg,aes(x=displ))+
    geom_histogram(aes(fill=class))+
    theme(axis.text.x = element_text(color = 'red4', size=12),
          axis.line = element_line(color="black", size=2),
          axis.text.y = element_blank(),
          panel.background = element_rect(fill="lightblue",linetype = "solid"),plot.background = element_rect(fill='green'))

## aes()안에는 적용할 변수만 기입가능 나머지는 aes  밖으로 뺀다.
ggplot(mpg,aes(x=displ))+
    geom_histogram(aes(fill=class),
                   binwidth = 0.1)+ #binwidth bin 간격
    labs(title="Histogram with Auto Bining",
         subtitle = "(Engine Displacement across Vehicle Classes)")+
    theme(legend.position = "bottom")   # 범례 위치 조정

ggplot(mpg,aes(x=displ))+
    geom_histogram(aes(fill=class),bins=5,color='black')


# 4.3 상자도표 (boxplot)
boxplot(iris$Sepal.Length)$stat # 이상치 처리하기 위해 사용 
ggplot(iris,aes(y=Sepal.Length))+
    geom_boxplot()

# 종별 Sepal.Length의 차이가 있는지를 보고 싶을 때 
tapply(iris$Sepal.Length,iris$Species,mean) # 도표 표현
ggplot(iris, aes(y=Sepal.Length, x=Species))+   # 시각화 표현 
    geom_boxplot(aes(fill=Species),col="dimgray")+
    scale_fill_manual(values = c("green4","pink","khaki"))


library(RColorBrewer)
display.brewer.all()
pal <- brewer.pal(11,'PiYG')

ggplot(iris,aes(y=Sepal.Length, x= Species))+
    geom_boxplot(aes(fill=Species),col="dimgray")+
    scale_fill_manual(values=pal)

install.packages("gapminder")
library(gapminder)
table(gapminder$country)
dim(gapminder)
head(gapminder)
tapply(gapminder$gdpPercap,gapminder$continent,mean)

# 대륙별 GDP 차이가 있는지
boxplot(gapminder$gdpPercap~gapminder$continent)
ggplot(gapminder,aes(x=continent,y=gdpPercap))+
    geom_boxplot(aes(fill=continent))+
    coord_cartesian(ylim=c(0,30000))+
    scale_fill_manual(values = pal)

# 교수의 직급별( 조교수, 부교수 , 정교수) 연봉이 상이한지 
install.packages("car")
library(car)
head(Salaries)

ggplot(Salaries,aes(x=rank,y=salary))+
    geom_boxplot(aes(col=rank),fill="lightgreen", notch =T)+
        # notch =T : 중위수에 대해서 95% 신뢰구간 표현, 신뢰구간이 겹치는지 파악. 겹치면 상이하지 않다고 보고 겹치치 않으면 상이하다고 본다.
    geom_point(position = "jitter",col="brown",alpha=0.2,pch=10)+
 # position = "jitter" : 산점도를 분산해서 표시.
    geom_rug(col="red",sides="l") # 곽측값의 밀도 상태. 분포도


# mtcars 데이터 cyl개수에 따른 연비 mpg의 95% 중위수 신뢰구간을 표현한 상자도표를 시각화하시오
head(mtcars)
ggplot(mtcars,aes(x=cyl,y=mpg))+
    geom_boxplot(aes(fill=cyl),notch=T)+
    scale_fill_manual(values = c("red","orange","yellow"))


# 4.4 바이올린 도표 (boxplot의 단점 보완,밀도도표가 추가된 느낌)
# 합창부 단원의 키와 성악부 part의 관계
singer<- lattice::singer
singer
ggplot(singer,aes(x=voice.part,y=height))+
    geom_boxplot()

ggplot(singer,aes(x=voice.part,y=height))+
    geom_violin(fill="honeydew2")+
    geom_boxplot(width=0.2,fill="green")

# 4.5 밀도도표
# mtcars  실린더 수에 따른 연비의 밀도 도표

ggplot(mtcars,aes(x=mpg,fill=cyl))+
    geom_density()+
    labs(title="밀도도표",
         x="Miles per Gallon")+
    theme(legend.position = c(0.8,0.8))


# 4.6 추세선 ( 시계열에서 데이터의 흐름을 표현)
economics
colnames(economics)
# 시간(date)에 따른 실업률(unemploy)
ggplot(economics,aes(x=date,y=unemploy))+
    geom_line()+   # 추세선
    geom_smooth()   # 적합도선

# 4.7 막대그래프 (geom_bar함수 , geom_col 함수)
# 도수분포표; 막대도표,히스토그램 
    # 히스토그램 : 연속형 자료를 계급으로 나누어 계급별 도수를 나타냄
                # geom_histogram() 함수
    # 막대그래프 : 범주형 자료의 빈도를 나타냄
                # geom_bar(),geom_col()


# mpg데이터셋에서 manufacturer 별로 도수분포표를 나타내자
ggplot(mpg,aes(x=manufacturer))+
    geom_bar(stat="count")+ # stat = "count" 빈도를 시각화. 생략가능
    
str(mpg)

ggplot(mpg,aes(x=manufacturer,fill=class))+
    geom_bar()+
    theme(legend.position = "bottom", axis.text.x=element_text(angle = 45,vjust=0.7))+
    scale_fill_manual(values = cm.colors(7))+
    labs(title="제조사 별 class 빈도표")

# 다이아몬드 품질별 데이터 
colnames(diamonds)
dim(diamonds)
table(diamonds$cut)
# 다이아몬드 품질(cut)별 빈도수 시각화 
ggplot(diamonds,aes(x=cut,fill=cut,col=cut))+
    geom_bar(stat="count")+
    scale_fill_manual(values = topo.colors(5))+
    scale_color_manual(values = rainbow(5))

# 다이아몬드 품질별 색상 개수
table(diamonds$cut,diamonds$color)
library(dplyr)

ggplot(diamonds,aes(x=cut,fill=color))+
    geom_bar()
    
    
    
diamonds%>%
    group_by(cut,color)%>%
    summarise(n=n())%>%
    ggplot(aes(x=cut,fill=color,y=n))+
    geom_bar(stat="identity") # y값 있을때 stat="identity"를 입력해줘야 출력된다.

diamonds%>%
    group_by(cut,color)%>%
    summarise(n=n())%>%
    ggplot(aes(x=cut,fill=color,y=n))+
    geom_col() # geom_col y값이 존재할때 사용 

# cut별, color별 막대그래프

diamonds%>%
    group_by(cut,color)%>%
    summarise(n=n())%>%
    ggplot(aes(x=cut,fill=color,y=n))+
    geom_bar(stat="identity",position="dodge") 

diamonds%>%
    group_by(cut,color)%>%
    summarise(n=n())%>%
    ggplot(aes(x=cut,fill=color,y=n))+
    geom_col(position = "dodge") 

# 다이아몬드 품질별, table별 빈도수 시각화
diamonds%>%
    group_by(cut,table)%>%
    summarise(n=n())%>%
    ggplot(aes(x=table,y=n,fill=cut))+
    geom_bar(stat="identity")+
    facet_wrap(~cut)+ # cut별로 시각하를 달리 그림
    coord_cartesian(ylim=c(0,3000),xlim=c(50,80))



# 다이아몬드 품질(cut)별 table의 종류 개수
diamonds%>%
    group_by(cut,table)%>%
    summarise(n=n())%>%
    group_by(cut)%>%
    summarise(n=n())%>%
    ggplot(aes(x=cut,y=n,fill=cut))+
    geom_bar(stat="identity")

diamonds%>%
    group_by(cut)%>%
    summarise(n=n_distinct(table))%>%
    ggplot(aes(x=cut,y=n,fill=cut))+
    geom_bar(stat="identity")              

# 4.8 그래프를 파일에 저장
# (1)
jpeg("iris.jpg") #iris.jpg 그림파일 생성
boxplot(iris$Sepal.Length)
dev.off()
getwd()

png("iris.png",width=300,height=150)
ggplot(iris,aes(x=Sepal.Length,y=Sepal.Width))+
    geom_point()+
    facet_wrap(~Species)
dev.off()


# ggplot2 그래프에서만 저장할 수 있는 방법
ggplot(iris,aes(x=Petal.Width,y=Petal.Length,col=Species))+
    geom_point(aes(size=Petal.Width),pch=19,alpha=0.5)
ggsave('outData/iris.jpg')

# 4.9 차트 분할 출력
install.packages("gridExtra")
library(gridExtra)
g1<-ggplot(iris,aes(x=Petal.Width,y=Petal.Length))+geom_point()
g2<-ggplot(iris,aes(x=Sepal.Width,y=Sepal.Length))+geom_point()

grid.arrange(g1,g2,ncol=2)

# 5. 산점도 행렬 

plot(iris[-5])
pairs(iris[-5],panel=panel.smooth)













         