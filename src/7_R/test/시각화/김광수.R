# ex01
## datasets::cars데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도(신뢰구간 그래프)를 나타내시오
##(단, 속도가 5부터 20까지 제동거리 0부터 100까지만 그래프에 나타냄).
str(cars)
ggplot(cars,aes(x=speed,y=dist))+
    geom_point()+
    geom_smooth(method = lm)+
    coord_cartesian(xlim=c(5,20),ylim = c(0,100))
ggsave("ex01.png")

# ex02
##  gapminder::gapminder 데이터 셋을 이용하여 1인당국내총생산에 대한 기대수명의 산점도를 대륙별 다른 색으로 나타내시오.
library(gapminder)
str(gapminder)
ggplot(gapminder,aes(x=gdpPercap,y=lifeExp,col=continent))+
    geom_point()
ggsave("ex02.png")    

# ex03
## gapminder::gapminder 데이터 셋을 이용하여 개대 수명이 70을 초과하는 데이터에 대해 대륙별 데이터 갯수.
gapminder%>%
    filter(lifeExp>70)%>%
    ggplot(aes(x=continent,fill=continent))+
    geom_bar()+
    labs(title='기대수명이 70을 초과하는 데이터 빈도(대륙별)',
        x='대륙',
         y='빈도')
ggsave("ex03.png") 

# ex04
## gapminder::gapminder 데이터 셋을 이용하여 기대수명이 70을 초과하는 데이터에 대해 대륙별 나라 갯수.
gapminder%>%
    filter(lifeExp>70)%>%
    group_by(continent,country)%>%
    summarise(n=n())%>%
    group_by(continent)%>%
    summarise(n=n())%>%
    ggplot(aes(x=continent,y=n,fill=continent))+
    geom_bar(stat="identity")+
    labs(title="기대수명이 70을 초과하는 대륙별 나라 빈도",
         y="나라 빈도")
ggsave("ex04.png")

# ex05 
## gapminder::gapminder 데이터 셋을 이용하여 대륙별 기대수명의 사분위수를 시각화
ggplot(gapminder,aes(x=continent,y=lifeExp))+
    geom_boxplot(aes(col=continent))+
    coord_cartesian(ylim=c(40,80))+
    labs(title="대륙별 기대수명의 사분위수")
ggsave("ex05.png")

# ex06
## gapminder::gapminder 데이터 셋을 이용하여 년도별로 gdp와 기대수명과의 관계를 산점도를 그리고 대륙별 점의 색상을 달리 시각화
ggplot(gapminder,aes(x=gdpPercap,y=lifeExp))+
    geom_point(aes(col=continent))+
    facet_wrap(~year)+
    coord_cartesian(xlim=c(1e+03,1e+04))+
    labs(title="GDP와 기대수명과의 관계")
ggsave("ex06.png")

# ex07
## gapminder::gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각화하시오(북한:Korea, Dem. Rep. 한국:Korea, Rep. substr(str, start, end)함수 이용)
gapminder$country <- factor(gapminder$country, levels=c("Korea, Rep.","Korea, Dem. Rep."))

gapminder%>%
    filter(country %in% c("Korea, Rep.","Korea, Dem. Rep.") )%>%
    ggplot(aes(x=year,y=gdpPercap))+
    geom_point(aes(pch=country,col=country))+
    scale_color_manual(values = c("red","blue"))+
    scale_shape_manual(values = c(3,16))+
    theme(legend.position =c(0.2,0.8))+
    labs(title="GDP의 변화(한국과 북한)")

## filter(substr(country, 1, 5)=='Korea') %>% 아래와 같음.
## filter(country %in% c("Korea, Rep.","Korea, Dem. Rep.") )%>% 
ggsave("ex07.png") 

# ex08
## gapminder::gapminder 데이터 셋을 이용하여 한중일 4개국별 GDP 변화를 산점도와 추세선으로 시각화 하시오.
gapminder%>%
    filter(country %in% c("Korea, Rep.","Korea, Dem. Rep.","China","Japan"))%>%
    ggplot(aes(x=year,y=gdpPercap,col=country))+
    geom_point()+
    geom_line()+
    labs(title="한중일 4개국의 GDP변화의 산점도와 추세선")
ggsave("ex08.png")

# ex09
##gapminder::gapminder 데이터 셋에서 한중일 4개국별 인구변화 변화를 산점도와 추세선으로 시각화 하시오.
gapminder%>%
    filter(country %in% c("Korea, Rep.","Korea, Dem. Rep.","China","Japan"))%>%
    ggplot(aes(x=year,y=pop,col=country))+
    geom_point()+
    geom_line()+
    scale_y_continuous(labels=scales::comma)+
    labs(title="한중일 4개국의 인구 변화의 산점도와 추세선")
ggsave("ex09.png")

# ex10
##Ggplot2::economic 데이터 셋의 개인 저축률(psavert)가 시간에 따라 어떻게 변해 왔는지알아보려 한다. 시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 시각화하시오

ggplot(economics,aes(x=date,y=psavert))+
    geom_line(col='red',size=2)+
    geom_smooth(col='red')+
    labs(title="개인저축률 시계열 그래프")
ggsave("ex10.png")













