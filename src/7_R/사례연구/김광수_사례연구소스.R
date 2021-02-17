


        ### 빅데이터 분석 결과 시각화 사례 연구 소스
library(dplyr)
library(ggplot2)
library(doBy)
library(foreign)
rm(list=ls())
# 1.koweps_hpc10_2015_beta5.sav를 로드하여 변수명 변경
install.packages("foreign")
# 1.1
raw_welfare <- read.spss(file='inData/Koweps/Koweps_hpc10_2015_beta1.sav', to.data.frame = T)
raw_welfare
welfare<-raw_welfare
dim(welfare)
# 1.2
welfare<-welfare[,c('h10_g3','h10_g4','h10_g10','h10_g11','h10_eco9','p1002_8aq1','h10_reg7')]
welfare
# 1.3
names(welfare)<-c('gender','birth','marriage','religion','code_job','income','code_region')
View(welfare)
str(welfare)

# 2. 성별에 따른 월급 차이가 있는지를 분석
  # 성별 이상치 처리
#2.1
welfare$gender<- ifelse(welfare$gender!=1&welfare$gender!=2,NA,welfare$gender)
welfare$gender
#2.2
table(is.na(welfare$gender))
#2.3
welfare$gender<-gsub(1,'male',x=welfare$gender)
welfare$gender<-gsub(2,'female',x=welfare$gender)
welfare$gender<-as.factor(welfare$gender)
welfare$gender
str(welfare)
#2.4
allg<-sum(table(welfare$gender))
m<-table(welfare$gender)[1]
f<-table(welfare$gender)[2]

welfare%>%
    select(gender)%>%
    summarise(female=(f/allg)*100,
              male=(m/allg)*100)

ratio<- (c(f,m)/allg*100)
ratio
pie(ratio,col=c('red','blue'),labels=c('female-45.4%','male-54.5%') ,main='성비')

str(welfare$income)
#2.5
boxplot(welfare$income)$stat
table(is.na(welfare$income))
boxplot(welfare$income)
ggplot(welfare,aes(income))+
    geom_bar(col='red')+
    coord_cartesian(ylim = c(0,150))
welfare$income<- ifelse(welfare$income==0,NA,welfare$income)
welfare$income<- ifelse(welfare$income>1300,NA,welfare$income)
raw_welfare
summaryBy(income~gender,welfare,FUN=c(mean,sd),na.rm=T)
##평균차
welfare%>%
    filter(!is.na(income))%>%
    group_by(gender)%>%
    summarise(mean_income=mean(income))%>%
    ggplot(aes(x=gender,y=mean_income))+
    geom_col(aes(fill=gender))
##표본차
ggplot(welfare,aes(x=gender,y=income))+
    geom_point(aes(col=gender),position="jitter",alpha=0.5)+
    geom_violin()+
    geom_boxplot(width=0.2,aes(col=gender),fill='lightyellow',notch=T)
##통계적 유의미 분석
var.test(income~gender,welfare)
# p-value가 0.05 보다 작음으로 귀무가설을 기각
t.test(income~gender,welfare,var.equal=F)
2.2e-16<0.05
# p-value가 0.05 보다 작음으로 귀무가설을 기각한다. 성별에 따른 월급차이가 있다.

# 3. 나이와 월급의 관계를 분석하여 몇 살 때 월급을 가장 많이 받는지 시각화
# 3.1
boxplot(welfare$income)
boxplot(welfare$birth)
table(is.na(welfare$income))
table(is.na(welfare$birth))
# 3.2
welfare$age<-2015-welfare$birth
# 3.3
ggplot(welfare,aes(x=age,y=income))+
    geom_col(aes(fill=age))
# 3.4 
fit <- lm(income~age,welfare,na.rm=T)
anova(fit)
2.2e-16 < 0.05
# F값이 0.05보다 작음으로 귀무가설을 기각. 나이에 따른 월급의 차이가 있다.

# 4. 연령대에 따른 월급의 차이가 있는지, 있으면 어떤 연령대가 월급이 가장 많은지 분석하시오. 단, 연령대는 30세 이하는 young, 30~60세는 middle, 61세 이상은 old로 분류한다.

#4.1
welfare$agegrade<- ifelse(welfare$age>60,'old',ifelse(welfare$age<31,'young','middle'))
welfare$agegrade<-as.factor(welfare$agegrade)
str(welfare$agegrade)
#4.2
welfare%>%
    group_by(agegrade)%>%
    summarise(n=n())

ggplot(welfare,aes(x=agegrade,fill=agegrade))+
    geom_bar()
#4.3
ggplot(welfare,aes(x=agegrade,y=income))+
    geom_boxplot(aes(fill=agegrade),notch = T)

#4.4
result<- aov(income~agegrade,welfare)
result
summary(result)
2e-16<0.05
# F 값이 0.05 보다 작으므로 귀무가설을 기각. 연령대별로 월급차이가 있다.

#5 성별에 따른 월급의 차이는 연령대 별로 다른지 분석
#5.1
table(welfare$gender,exclude = NULL)
table(welfare$agegrade,exclude = NULL)
table(welfare$income,exclude = NULL)
#5.2
welfare%>%
    filter(!is.na(income))%>%
    select(agegrade,gender,income)%>%
    group_by(agegrade,gender)%>%
    summarise(mean=mean(income),
              sd=sd(income),
              cnt=n())
#5.3 
welfare%>%
    filter(!is.na(income))%>%
    select(agegrade,gender,income)%>%
    group_by(agegrade,gender)%>%
    summarise(mean=mean(income))%>%
    ggplot(aes(x=agegrade,y=mean))+
    geom_bar(stat="identity",aes(fill=gender),position = "dodge")

#6 나이에 따른 월급 변화를 성별을 분리하여 시각화
#6.1
welfare%>%
  filter(!is.na(income))%>%
  group_by(age,gender)%>%
  summarise(meanincome=mean(income),
            sdincome=sd(income),
            medianincome=median(income),
            minincome=min(income),
            maxincome=max(income),
            cnt=n())

View(welfare%>%
  filter(!is.na(income))%>%
  group_by(age,gender)%>%
  summarise(meanincome=mean(income)))


#6.2
welfare%>%
  filter(!is.na(income))%>%
  group_by(age,gender)%>%
  summarise(meanincome=mean(income))%>%
  ggplot(aes(x=age,y=meanincome))+
  geom_line(aes(col=gender))
ggsave("6.2.png")

#7 직업별 월급의 차이가 나는지 분석하고, 만약 월급의 차이가 나면 어떤 직업이 월급이 가장 많은지 상위 10개 직업군만 시각화
#7.1
welfare%>%
  filter(!is.na(income))%>%
  group_by(code_job)%>%
  summarise(mean=mean(income),
            sd=sd(income),
            cnt=n())%>%
  arrange(-mean)

#7.2
table(welfare$code_job,useNA = "ifany")
result<- aov(income~code_job,data=welfare,na.rm=T)
summary(result)
2e-16>0.05
#F값이 0.05보다 작음으로 귀무가설을 기각. 직웝별 월급 차이가 난다고 본다.
welfare%>%
  filter(!is.na(income))%>%
  group_by(code_job)%>%
  summarise(mean=mean(income),
            sd=sd(income),
            cnt=n())%>%
  arrange(-mean)%>%
  head(10)
welfare2<-welfare%>%
  filter(!is.na(income))%>%
  group_by(code_job)%>%
  summarise(mean=mean(income),
            sd=sd(income),
            cnt=n())%>%
  arrange(-mean)%>%
  head(10)
welfare2$code_job[]=c("금속 재료 공학 기술자 및 시험원",'의료진료 전문가','이회의원 고위공무원 및 공공단체임원','보험 및 금융 관리자','채관원 및 환금원','행정 및 경영지원 관리자','문화 예술 디자인 및 영상 관련 관리자','연구 교육 및 법률 관련 관리자','건설 전기 및 생산 관련 관리자','석유 및 화학물 가공장치 조직원')
welfare2
ggplot(welfare2,aes(x=reorder(code_job,mean),y=mean))+
  geom_bar(stat="identity")+
  coord_flip()+
  labs(title="상위 소득 10개 직업군",
       x= "직업",
       y= "평균소득")
ggsave("7.2.png")

#7.3
welfare%>%
  filter(!is.na(income))%>%
  group_by(code_job)%>%
  summarise(mean=mean(income),
            sd=sd(income),
            cnt=n())%>%
  arrange(-mean)%>%
  tail(10)

welfare3 <-welfare%>%
  filter(!is.na(income))%>%
  group_by(code_job)%>%
  summarise(mean=mean(income),
            sd=sd(income),
            cnt=n())%>%
  arrange(-mean)%>%
  tail(10)
welfare3$code_job[]=c('판매관련 단순 종사원','음식관련 단순 종사원','의료 복지 관련 서비스 종사자','농립어업관련 단순 종사원','작물재배 종사자','약사 및 한약사','청소원 및 환경 미화원','기타 서비스관련 단순 종사원','임업관련 종사자','가사 및 육아 도우미')
welfare3
ggplot(welfare3,aes(x=reorder(code_job,mean),y=mean))+
  geom_bar(stat="identity")+
  coord_flip()+
  labs(title="하위 소득 10개 직업군",
       x= "직업",
       y= "평균소득")
ggsave("7.3.png")

#8  성별로 어떤 직업이 가장 많을지 분석하시오.
#8.1
welfare%>%
  filter(gender=='female')%>%
  group_by(code_job)%>%
  summarise(n=n())%>%
  arrange(-n)%>%
  head(11)
# NA제외 
fjob<-welfare%>%
  filter(gender=='female' & !is.na(code_job))%>%
  group_by(code_job)%>%
  summarise(n=n())%>%
  arrange(-n)%>%
  head(10)
fjob$code_job[] <- c('작물재배 종사자','청소원 및 환경 미화원','매장 판매 종사자','제조관련 단순 종사원','화계 및 경리 사무원','음식서비스 종사자','주방장 및 조리사','가사 및 육아 도우미','의료 복지 관련 서비스 종사자','음식관련 단순 종사원')
fjob
#8.2
welfare%>%
  filter(gender=='male')%>%
  group_by(code_job)%>%
  summarise(n=n())%>%
  arrange(-n)%>%
  head(11)
# NA제외 
mjob<-welfare%>%
  filter(gender=='male' & !is.na(code_job))%>%
  group_by(code_job)%>%
  summarise(n=n())%>%
  arrange(-n)%>%
  head(10)
mjob$code_job<- c('작물재배 종사자','자동차 운전원','경영관련 사무원','영업 종사자','매장 판매 종사자','제조관련 단순 종사원','청소원 및 환경 미화원','건설 및 광업 단순 종사원','경비원 및 검표원','행정사무원')
mjob

#9 종교 유무에 따른 이혼률을 분석하시오

#9.1
table(welfare$religion ,useNA = 'ifany')
#9.2
welfare$religion<- ifelse(welfare$religion==1,'종교-유','종교-무')
welfare$religion<- as.factor(welfare$religion)
#9.3
ggplot(welfare,aes(x=religion))+
  geom_bar(aes(fill=religion))
#9.4
table(welfare$marriage, useNA = 'ifany')
welfare$marriage_group <- ifelse(welfare$marriage==1,'기혼',ifelse(welfare$marriage==3,'이혼',NA))
welfare$marriage_group<-as.factor(welfare$marriage_group)
table(welfare$marriage_group, useNA = 'ifany')
#9.5
welfare%>%
  filter(!is.na(marriage_group))%>%
  select(marriage_group,religion)%>%
  group_by(religion,marriage_group)%>%
  summarise(total=n())

ratiomd<-welfare%>%
  filter(!is.na(marriage_group))%>%
  select(marriage_group,religion)%>%
  group_by(religion,marriage_group)%>%
  summarise(total=n())

ratiomd <- ratiomd%>%
  mutate(percent=(total/sum(total))*100)
ratiomd

#9.6
ratiomd

welfare%>%
  filter(!is.na(marriage_group))%>%
  select(marriage_group,religion)%>%
  group_by(religion,marriage_group)%>%
  summarise(pct=n()/sum(table(welfare$marriage_group))*100)%>%
  ggplot(aes(x=religion,y=pct))+
  geom_bar(stat="identity",aes(fill=marriage_group),position = 'dodge')

#차이가 미비한것으로 보인다.


#10 지역별 연령대 비율을 분석하시오. 노년층이 많은 지역은 어디인지 출력하시오.

#10.1
table(welfare$code_region, useNA = "ifany")
table(welfare$agegrade, useNA = "ifany")

#10.2
welfare$region <- ifelse(welfare$code_region==1,'서울',ifelse(welfare$code_region==2,'인천/경기',ifelse(welfare$code_region==3,'부산/경남/울산',ifelse(welfare$code_region==4,'대구/경북',ifelse(welfare$code_region==5,'대전/충남',ifelse(welfare$code_region==6,'강원/충북','광주/전남/전북/제주도'))))))
welfare$region<- as.factor(welfare$region)
welfare$region

#10.3
ratiogr<-welfare%>%
  group_by(region,agegrade)%>%
  summarise(total=n())

ratiogr<-ratiogr%>%
  mutate(percent=(total/sum(total)*100))

ratiogr

ggplot(ratiogr,aes(x=region,y=percent))+
    geom_bar(stat="identity",aes(fill=agegrade),position = "dodge")

#10.4

# 노년층 비율이 높은 곳
ratiogr%>%
  filter(agegrade=='old')%>%
  arrange(-percent)%>%
  ggplot(aes(x=reorder(region,percent),y=percent,fill=region))+
  geom_bar(stat="identity")+
  coord_flip()+
  labs(title="노년층의 비율이 높은 지역",
         x= "지역",
       y="노년층 비율")

# 노년층 개체가 많은 지역
ratiogr%>%
  filter(agegrade=='old')%>%
  arrange(-total)%>%
  ggplot(aes(x=reorder(region,total),y=total,fill=region))+
  geom_bar(stat="identity")+
  coord_flip()+
  labs(title="노년층의 수가 높은 지역",
       x= "지역",
       y="노년층 수")











