# 혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요
library(dplyr)
library(doBy)
mpg <- as.data.frame(ggplot2::mpg)
mpg
# Q1
# dplyr 패키지 이용
mpg %>%
    mutate(group = ifelse(displ<=4,'low4',ifelse(displ>=5,'up5',NA))) %>% 
    group_by(group) %>% 
    summarise(avgh=mean(hwy)) %>% 
    filter(!is.na(group))

# Q2
mpg %>% 
    group_by(manufacturer) %>% 
    summarise(avgc=mean(cty)) %>% 
    filter(manufacturer %in% c('audi','toyota')) 


# Q3
mpg %>% 
    group_by(manufacturer) %>% 
    summarise(avgh=mean(hwy)) %>% 
    filter(manufacturer %in% c('chevrolet','ford','honda'))

# apply계열 함수 이용 : tapply,by,summaryBy,aggregate


# Q1.
displ5 <-subset(mpg,select=c(3,9),subset= mpg$displ>=5)
displ4 <-subset(mpg,select=c(3,9),subset= mpg$displ<=4)
mean5<-apply(displ5,2,mean)
mean4<-apply(displ4,2,mean)
result1<-rbind(mean5,mean4)
result<-result1[,2]
names(result)= c('5이상','4이하')
result

df <- mpg[(mpg$displ<=4|mpg$displ>=5),]
df$group <- ifelse(df$displ<=4 , '배기량4이하',ifelse(df$displ>=5,'배기량 5 이상',NA))
tapply(df$hwy,df$group,mean)


# Q2.
aggregate(mpg$displ,by=list(mpg$manufacturer),mean)[c(1,14),]

# Q3.
CFH <- subset(mpg,subset = mpg$manufacturer==c('chevrolet','ford','honda'),select=c(1,9))
CFH
tapply(CFH$hwy,CFH$manufacturer,mean)
by(CFH$hwy,CFH$manufacturer,mean)
summaryBy(hwy~manufacturer,CFH,FUN=mean)
aggregate(CFH$hwy,by=list(CFH$manufacturer),mean)

#혼자서 해보기2

# Q1
# dplyr 패키지 이용
df<- mpg %>% select(class,cty)
head(df)

# Q2
df %>% 
    filter(class %in% c('suv','compact')) %>% 
    group_by(class) %>% 
    summarise(avgc=mean(cty))

# Q3
mpg %>% 
    filter(manufacturer=='audi') %>%
    select(model,hwy) %>% 
    arrange(-hwy) %>% 
    head(5)

# apply계열 함수 이용 : tapply,by,summaryBy,aggregate

# Q1
head(mpg[,c(11,8)])

# Q2
SC1 <- mpg[,c(11,8)]
SC<-subset(SC,subset = SC$class==c('suv','compact'))
tapply(SC$cty,SC$class,mean)
mpg[mpg$class %in% c('suv','compact'),c(11,8)]
tapply(mpg[mpg$class %in% c('suv','compact'),c(11,8)][,2],mpg[mpg$class %in% c('suv','compact'),c(11,8)][,1],mean)

# Q3
audi <- subset(mpg,subset =mpg$manufacturer=='audi',select = c(2,9))
audi
head(orderBy(~-hwy,data=audi),5)

# 혼자서 해보기 3.
# dplyr 패키지 이용
# Q1.
mpg2 <- mpg 
mpg2 %>%
    mutate(cthw=cty+hwy)
# Q2.
mpg2%>%
    muate(avgcthw=cthw/2)

# Q3.
mpg2 %>%
    arrange(-avgcthw)%>%
    head(3)

# Q4.
mpg %>%
    mutate(total=cty+hwy)%>%
    mutate(avgtotal=total/2)%>%
    arrange(-avgtotal)%>%
    head(3)


# apply계열 함수 이용 : tapply,by,summaryBy,aggregate

# Q1.
mpgg <- mpg
mpgg$cthw = mpg$cty+mpg$hwy
mpgg

# Q2. 
mpgg$avgcthw = mpgg$cthw/2

# Q3.
head(orderBy(~-avgcthw,data=mpgg),3)

# 혼자서 하기4
# dplyr 패키지 이용
# Q1.
mpg%>%
    group_by(class)%>%
    summarise(meancty=mean(cty))

# Q2.
mpg%>%
    group_by(class)%>%
    summarise(meancty=mean(cty))%>%
    arrange(-meancty)

# Q3.
mpg%>%
    group_by(manufacturer)%>%
    summarise(meanhwy=mean(hwy))%>%
    arrange(-meanhwy)%>%
    head(3)

# Q4.
mpg%>%
    group_by(manufacturer)%>%
    filter(class=='compact')%>%
    summarise(num=n())%>%
    arrange(-num)
# apply계열 함수 이용 : tapply,by,summaryBy,aggregate
# Q1.
summaryBy(cty~class,mpg)

# Q2.
order1<-summaryBy(cty~class,mpg)
orderBy(~-cty.mean,data=order1)

# Q3.
hw <- summaryBy(hwy~manufacturer,mpg)
head(orderBy(~-hwy.mean,data=hw),3)
# Q4.
compact <- subset(mpg,subset = class=='compact')
compact
compact$manufacturer
compact2<-as.data.frame(table(compact$manufacturer))

orderBy(~-Freq,data=compact2)


#혼자서 해보기 5.
fuel<- NULL
fuel$fl <- c('c','d','e','p','r')
fuel$kind <- c('CNG','diesel','ethanol E85','premium','regular')
fuel$price_fl <- c(2.35,2.38,2.11,2.76,2.22)
fuel<-as.data.frame(fuel)

#Q1
mpg1 <- mpg
mpg1
mpg1 <- left_join(mpg1,fuel[,c(1,3)],by='fl')

#Q2
head(mpg1[,c(2,10,12)],5)

# 혼자서 해보기6 
mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당

#Q1
table(mpg$drv)
mpg$drv <- ifelse(mpg$drv %in% c(4,'f','r'),mpg$drv,NA)
table(is.na(mpg$drv))
      
      
#Q2
result<- boxplot(mpg$cty)
result<- result$stats
result
result[1] # 극단치 기준점 최소값
result[5] # 극단치 기준점 최대값값
mpg$cty <- ifelse(mpg$cty<result[1] | mpg$cty>result[5], NA,mpg$cty)
table(is.na(mpg$cty))
boxplot(mpg$cty)
mpg$cty
median<-median(mpg$cty,na.rm=T)
mpg$cty
mpg$cty <- ifelse(is.na(mpg$cty),median,mpg$cty)
table(is.na(mpg$cty))
mpg$cty
boxplot(mpg$cty)


#Q3
mpg%>%
    filter(!is.na(mpg$drv))%>%
    group_by(drv)%>%
    summarise(meanc=mean(cty))




# 분석 도전
midwest <- as.data.frame(ggplot2::midwest)
midwest

#문 1
midwest$popadults
midwest$poptotal
midwest$perkids<- ((midwest$poptotal-midwest$popadults)/midwest$poptotal)*100
midwest$perkids

#문 2
head(orderBy(~-perkids,data=midwest),5)[,c(2,29)]

#문 3
midwest$pkgrade <- ifelse(midwest$perkids>=40,'large',ifelse(midwest$perkids>=30,'middle','small'))
table(midwest$pkgrade)

#문 4
midwest$perasian <- ((midwest$popasian)/midwest$poptotal)*100
midwest$perasian
tail(orderBy(~-perasian,data=midwest),10)[,c(3,2,31)]
