

        ### t-test 분석 vs ANOVA분석


# 두 그룹간 평균의 차이가 통계적으로 유의한지 검증 : t-test분석
# 세 그룹 이상인 집단의 평균 차이가 유의한지 검증 : ANOVA분석

# 1. 두 그룹간의 평균의 차이가 유의한지 분석
ToothGrowth
table(ToothGrowth$supp)
# (1) 도표로 차이의 유의성 표현(tapply,by,summary By,aggregate....평균,분산)
# (2) 그래프로 시각화된 유의성 표현(바이올린도표, 산점도...)
# (3) 통계적으로 유의한지 검증
# 비타민의 종류에 따라 기니피그의 치아 성장에 영향을 미치는지?
ToothGrowth <- rbind(ToothGrowth,ToothGrowth) 
# 데이터표본이 적으면 귀무가설이 기각되기 어려워진다.
nrow(ToothGrowth)
# (1)
library(doBy)
summaryBy(len~supp,data=ToothGrowth,FUN=c(mean,sd))
library(dplyr)
ToothGrowth%>%
    filter(!is.na(supp)& !is.na(len))%>%
    group_by(supp)%>%
    summarise(len.mean = mean(len),
              len.sd = sd(len))

# (2)
ToothGrowth%>%
    group_by(supp)%>%
    summarise(len.mean=mean(len))%>%
    ggplot(aes(x=supp,y=len.mean))+
    geom_col(aes(fill=supp),width = 0.7)

ggplot(ToothGrowth,aes(x=supp,y=len))+
    geom_violin()+
    geom_point(position = "jitter",alpha=0.5,col="red")+
    geom_boxplot(width=0.2,notch=T,aes(fill=supp))

# (3) 통계적인 분석(t-test)
# 일원표본 t-test
table(ToothGrowth$supp,useNA = "ifany") #결측치 빈도까지 출력
table(ToothGrowth$supp,exclude = NULL)
a<-ToothGrowth[ToothGrowth$supp=='OJ','len']
b<-ToothGrowth[ToothGrowth$supp=='VC','len']
t.test(a-b)
t.test(a,b)
# p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 평균이 같다)을 기각한다.
# p-value가 0.05보다 큰 경우 귀무가설을 기각하지 못한다. 

# 이원표본 t-test(등분산성 테스트 -> t-test분석)
# 등분산성 테스트
var.test(len~supp,data=ToothGrowth)
    # p-value가 0.05보다 작은 경우 귀무가설을 기각한다.
#       - 등분산성이 성립되지 않는다.
    # p-value가 0.05보다 큰 경우 귀무가설을 기각하지 못한다.
#       - 등분산성이 성립된다.
t.test(len~supp,data=ToothGrowth, var.equal=T)
    # var.equal=F : 두그룹의 등분산성이 성립되지 않는 경우
# p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 평균이 같다)을 기각한다.
# p-value가 0.05보다 큰 경우 귀무가설을 기각하지 못한다. 



#### 예제 : datasets::sleep , extra(수면량),group(수면제 종류)
# 수면제 group에 따라 수면량의 변화가 있는지 분석하시오.
sleep <-rbind(sleep,sleep) # 표본 320개로 추가
sleep

# (1) 도표로 평균의 차이 나타내기
summaryBy(extra~group,sleep,FUN=c(mean,sd))

# (2) 평균, 표본의 차이를 시각화하기
sleep%>%
    group_by(group)%>%
    summarise(mean_extra= mean(extra))%>%
    ggplot(aes(x=group,y=mean_extra))+
    geom_col(aes(fill=group))

ggplot(sleep,aes(x=group,y=extra))+
    geom_violin()+
    geom_point(aes(col=group),position="jitter",alpha=0.6)+
    geom_boxplot(width=0.2,aes(fill=group),notch=T)
    


# (3) 통계적으로 유의미한 차이를 분석하기
var.test(extra~group,data=sleep)
# p-value가 0.05보다 큼으로, 따라서 귀무가설을 기각하지 못한다.(분산이 같다)
# 등분산성 성립
t.test(extra~group,data=sleep,var.equal=T)
7.771e-14 <0.05
# p-value가 0.05보다 작음으로, 따라서 귀무가설을 기각한다.(평균이 다르다)


# 2. 3개 이상의 집단간 평균의 차이를 비교할 때는 분산 분석(ANOVA)

# (1)aov()
    #iris데이터 셋에서 종에 따라 Sepal.Length의 평균이 다른지
result<-aov(Sepal.Length~Species,data=iris) # Species가 범주형
result
summary(result) # F값 확인
#F값이 0.05보다 작으면 귀무가설을 기각.
#F값이 0.05보다 크면 귀무가설을 기각할 수 없다.

# (2)anova()
    #ggplot2::mtcars 데이터셋에서 cyl의 개수에 따라 mpg의 평균이 다른지
str(mtcars$cyl)
table(mtcars$cyl, useNA = "ifany") # cyl의 가지수와 결측치 확인
# cyl에 따른 그룹이 3개 그룹이고, cyl변수가 연속형 범주여서
fit <-lm(mpg~cyl,data=mtcars) # 회귀선식
anova(fit)
#F값이 0.05보다 작으면 귀무가설을 기각.
#F값이 0.05보다 크면 귀무가설을 기각할 수 없다.


#### 예제 :datasets::Orange ; 오렌지나무의 종류, 연령,둘레
    # 오렌지 나무의 연령에 따른 둘레의 평균이 상이한지 분석하시오
Orange
fit<-lm(circumference~age,Orange)
anova(fit)
#F값이 0.05보다작으니 귀무가설기각 
result<- aov(circumference~age,Orange)
summary(result)










