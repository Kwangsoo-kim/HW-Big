
# 5.1 dplyr을 이용한 데이터 전처리

# 1. 외부파일 read/write
# 1.1 엑셀파일 읽어오기 - readx1 패키지 이용
install.packages('readxl')
library(readxl)
getwd()
exam <- read_excel("D:/kks/note/07_R/inData/exam.xlsx")
exam<- as.data.frame(exam)
head(exam)
nrow(exam)
exam[21,] <- data.frame(id=21,class=1,math=90,english=90,science=99)
tail(exam)
exam$tot <- exam$math+exam$english+exam$science # 파생변수 추가!
mean(exam$tot)
exam$grade <- ifelse(exam$tot>mean(exam$tot), '상','하') # 파생변수 추가!
apply(exam[,3:6],2,mean)

data <- read_excel('inData/data_ex.xls',col_names = F)
data
colnames(data) <- c('id','gender','age','area')
data <- as.data.frame(data)
data
# 1.2 데이터 쓰기 (파일(csv)로 쓰기 vd. 변수만 쓰기)
write.csv(exam,'outData/exam.csv',row.names = F) # 파일로 쓰기
save(exam,file='outData/exam.rda') # exam 변수를 파일로 저장
rm(list=ls(all.names = T)) # 모든 변수 삭제
load('outData/exam.rda') # 메모리에 올라감
exam

# 2. 데이터 파악하기
mpg <- ggplot2::mpg
mpg <- as.data.frame(mpg)
mpg

#head() 앞부분 tail() 뒷부분 view() = edit() 뷰창에서 데이터 확인용
#dim() 차원 str()구조 y()
head(mpg)
edit(mpg)
view(mpg)
dim(mpg)
y(mpg) # 최소값, 1사분위수 ,중위수 ,3사분위수 , 최대값값
# 변수명 바꾸기 (cty -> city, hwy -> highway)
install.packages('dplyr')
library(dplyr)
mpg <-rename(mpg,city=cty,highway=hwy)
colnames(mpg)
# 파생변수 (계산식으로)
mpg$total <- (mpg$city+mpg$highway)/2
head(mpg)
# 파생변수 (조건식으로)
install.packages('vioplot')
library(vioplot)   
par(mfrow=c(1,3)) #시각화 그래프를 1행3열로
vioplot(mpg$total, col='blue') # 바이올린플롯
boxplot(mpg$total) # 박스플롯
hist(mpg$total)    # 히스토그램
par(mfrow=c(1,1)) # 플롯 공간 원상복귀

mean(mpg$total)
mpg$test <- ifelse(mpg$total>=mean(mpg$total), 'PASS','FAIL')
table(mpg$test) #빈도표
library(ggplot2)
qplot(mpg$test)
hist(mpg$total) # 히스토그램

# 혼자분석하기!
midwest <- ggplot2::midwest
midwest <- as.data.frame(midwest)
    # 데이터 파악하기 , 파생변수 만들기 
head(midwest)
# 문제 1
y(midwest)
dim(midwest)
str(midwest)
view(midwest)
# 문제 2
midwest<- rename(midwest,total=poptotal,asian=popasian)
colnames(midwest)
# 문제 3

midwest$perasian <- (midwest$asian/midwest$total) *100
midwest$perasian
hist(midwest$perasian)
boxplot(midwest$perasian)
vioplot(midwest$perasian)
# 문제 4
mean(midwest$perasian)
midwest$meanasian <- ifelse(midwest$perasian> mean(midwest$perasian), 'large','small')
midwest$meanasian

# 문제 5
qplot(midwest$meanasian)
table(midwest$meanasian)


# 3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기
# 3.1 조건에 맞는 데이터 추출하기 :filter() '%>%의 단축키 ctrl+shift+m
exam <- read.csv('inData/exam.csv')
exam
exam %>%            #dplyr 패키지는 $>$기호를 이용하여 함수들을 나열하는 방식 
    filter(class==1) 
exam %>%
    filter(class %in% c(1,2,3))

# class가 1이고, 영어상적이 88이상인 데이터 추출
exam %>% 
    filter(class==1 & english>=8)


# 3.2 필요한 변수 추출하기 : ()
exam %>% 
    (class,english,math) #존재하는 항목만 기입가능. 변형x
exam %>% 
    (-math) # - 붙이면 그것만 제외하고 나머지 출력 
# class가 1과 2의 행중에서 영어,수학 데이터만 출력
exam %>% 
    filter(class %in% c(1,2)) %>% 
    (english,math)
# class가 1,2,3행에서 영,수 데이터만 앞 5개 추출
exam %>% 
    filter(class %in% c(1,2,3)) %>% 
    (english,math) %>% 
    head(5)

# 3.3 정렬하기 : arrange()
exam %>% arrange(math) # 오름차순 정렬 
exam %>% arrange(-math) # 내림차순 정렬 
exam %>% arrange(desc(math)) # -math 를 desc(math)로 써도 된다

exam %>%  arrange(class, -math) # 추가 조건은 연속 나열하면된다. 

#id가 1부터 10인 학생의 영어,수학성적을 기준으로 오름차순 정렬하고 top 6명 출력
exam %>% 
    filter(id==(1:10)) %>% 
    (english,math) %>% 
    arrange(english) %>% 
    head

# 파생변수 추가 : mutate
exam %>% 
    mutate(total = math + english+science)  # 잠깐 분석 할 때만 사용
exam %>% # 파생변수를 한꺼번에 두개 이상 추가해서 분석
    mutate(total = math + english+science, avg = round(math+english+science)/3)%>%  head
head(exam)
# 추가한 파생변수를 dplyr 코드에 바로 활용
exam %>% 
    mutate(total=math+english+science,
          avg=round((math+english+science)/3)) %>% 
    (-id) %>% 
    arrange(desc(total)) %>% 
    head

# 3.5 요약하기 : summarise()
    # summarise안에 들어갈 수 있는 요약함수들 : mean , sd, sum ,min, max, median ,n
exam %>% 
    summarise(mean_math=mean(math))
exam %>% 
    summarise(mean_math=mean(math),
              mean_eng=mean(english),
              sd_math= sd(math),
              sd_eng=sd(english))

# 3.6 진단별로 요약하기 : group_by()+summarise()
exam %>% 
    group_by(class) %>% 
    summarise(mean_math=mean(math),
              n=n(),
              max_eng=max(english)) %>% 
    arrange(mean_math)# n = 개수 

# 클래스별 수학, 영어, 과학의 평균

exam %>% 
    group_by(class) %>% 
    summarise(mean_math=mean(math),
              mean_english=mean(english),
              mean_science=mean(science))

library(doBy)
summaryBy(math+english+science~class,exam)

# mpg
mpg <- as.data.frame(mpg)
mpg

# mpg 회사별로 'suv 자동차의 도시 및 고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고, 1~5위 까지 출력하기
mpg %>% 
    group_by(manufacturer
             ) %>%
    filter(class=='suv') %>% 
    mutate(total=(cty+hwy)/2) %>% 
    ise(avgtotal=mean(total)) %>% 
    arrange(-avgtotal) %>% 
    head(5)

# 혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요

mpg <- as.data.frame(ggplot2::mpg)
mpg
# Q1
mpg %>%
    mutate(group = ifelse(displ<=4,'low4',ifelse(displ>=5,'up5',NA))) %>% 
    group_by(group) %>% 
    ise(avgh=mean(hwy)) %>% 
    filter(!is.na(group))
    
# Q2
mpg %>% 
    group_by(manufacturer) %>% 
    ise(avgc=mean(cty)) %>% 
    filter(manufacturer %in% c('audi','toyota')) 
    

# Q3
mpg %>% 
    group_by(manufacturer) %>% 
    ise(avgh=mean(hwy)) %>% 
    filter(manufacturer %in% c('chevrolet','ford','honda'))

#혼자서 해보기2

# Q1
df<- mpg %>% 
    select(class,cty)
head(df)

# Q2
df %>% 
    filter(class %in% c('suv','compact')) %>% 
    group_by(class) %>% 
    ise(avgc=mean(cty))

# Q3
mpg %>% 
    filter(manufacturer=='audi') %>%
    select(model,hwy) %>% 
    arrange(-hwy) %>% 
    head(5)

# 4. 데이터 합치기 
    # 열 합치기 : cbind, left_join
    # 행 합치기 : rbind, bind_rows
    # cf. merge 
# 4.1 열 합치기(가로 합치기)
test1 <- data.frame(id=c(1,2,3,4,5),midterm=c(70,80,90,95,99))
test2 <- data.frame(id=c(1,2,3,4,5),final=c(90,80,70,60,99),
                    teacherid=c(1,1,2,2,3))
teacher <- data.frame(teacherid=c(1,2,3),teachername=c('kim','park','ryu'))
cbind(test1,test2)
merge(test1,test2)
left_join(test1,test2,by='id')
left_join(test2,teacher,by='teacherid')
merge(test2,teacher,by='teacherid')

# 4.2 행 합치기 (세로 합치기)

group_a <- data.frame(id=c(1,2,3,4,5),test=c(60,70,80,90,95))
group_b <- data.frame(id=c(6,7,8,9,10),test=c(90,95,94,93,92))
rbind(group_a,group_b) # 두 데이터 프레임의 변수가 같을 경우 사용가능
bind_rows(group_a,group_b)
group_a <- data.frame(id=c(1,2,3,4,5),test1=c(60,70,80,90,95))
group_b <- data.frame(id=c(6,7,8,9,10),test2=c(90,95,94,93,92))
rbind(group_a,group_b) # 변수 이름이 달라서 안된다
bind_rows(group_a,group_b) # 작동은하나 빈 자리는 NA값 
merge(group_a,group_b,all=T) # all=T 없으면 작동 x

# 5. 데이터 정제하기 - 결측치(NA),이상치
# 5.1 결측치 정제하기 
df <- data.frame(name=c('kim','yi','yun','Ma','park'),gender=c('M','F',NA,'M','F'),score=c(5,4,3,4,NA),income=c(2000,3000,4000,4500,4600))
df
is.na(df)
dim(df)
table(is.na(df))
table(is.na(df$gender))
table(is.na(df$score))

na.omit(df) # 결측치가 하나라도있으면 그행 모두 제거. 간편하지만, 같은 행의 분석에 필요한 열의 정보까지 손실된다는 단점이 있다.

df%>%
    filter(!is.na(score))%>%
    summarise(mean_score=mean(score))

mean(df$score,na.rm=T) #결측치를 제거하고 평균을 냄
tapply(df$score,df$gender,mean,na.rm=T) #결측치를 제거하고 평균을 냄

# 결측치를 대체하기 (평균값, 중앙값)
x <- c(1,1,2,2,3,3,3,4,4,5,5,100)
mean(x)
median(x)

exam <- read.csv('inData/exam.csv',header = T)
exam
table(is.na(exam))
exam[c(3,8,15),'math']<- NA # 인위적으로 결측치 넣기
exam[c(1,2),'english']<- NA # 인위적으로 결측치 넣기
exam
table(is.na(exam))
apply(exam[3:5],2,mean,na.rm=T)
tapply(exam[,3],exam$class,mean)
exam %>%
    summarise(math=mean(math,na.rm=T),
              english=mean(english,na.rm=T),
              science=mean(science,na.rm=T))

# 결측치들을 중앙값으로 대체
exam$math #결측치 확인
exam$math <- ifelse(is.na(exam$math),median(exam$math,na.rm=T),exam$math) # mean 대치시에는 round 해주자
exam$math #결측치 대체됨

exam$english
exam$english <- ifelse(is.na(exam$english),round(mean(exam$english,na.rm=T)),exam$english)
exam$english

table(is.na(exam))

exam <- read.csv('inData/exam.csv')
exam[c(1,3,8),'math'] <- NA
exam[1:2,'english']<- NA
exam[1,'science']<- NA
exam

## 결측치 대체 방법 1 ##
median <- round(apply(exam[3:5],2,median,na.rm=T))
median['math']
median['english']
median['science']
exam <- within(exam, { # 결측치 대체하기 위한 블록
    math<- ifelse(is.na(math), median['math'],math)
    english <- ifelse(is.na(english),median['english'],english)
    science <- ifelse(is.na(science),median['science'],science)
})
is.na(exam)
head(exam)
colSums(is.na(exam)) # 변수별 결측치 갯수 확인


## 결측치 대체 방법 2 ##(dplyr)
colSums(is.na(exam))
median <- round(apply(exam[3:5],2,median,na.rm=T))
exam <- exam %>%
    mutate(
    math=ifelse(is.na(math), median['math'],math),
    english=ifelse(is.na(english),median['english'],english),
    science=ifelse(is.na(science),median['science'],science) 
    )
colnames(exam)<-c('id','class','math','english','science')
exam

# 5.2 이상치 정제
    # 극단적인 이상치(정상범위 기준에서 벗어난 값)
    # 논리적인 이상치(성별에 남여가 아닌 값)
    # 이상치는 결측치로 대체

#논리적인 이상치

outlier<- data.frame(gender=c(1,2,1,3,2),score=c(90,95,100,99,101))
table(outlier$gender)
# gender 1은 남, 2는 여, 3은 이상치 처리
outlier$gender <- ifelse(outlier$gender!=1&outlier$gender!=2,NA,outlier$gender)
outlier
# score 가 100 초과하는 경우 이상치 처리
outlier$score <- ifelse(outlier$score >100,NA,outlier$score)
outlier

# (2) 정상범위 기준으로 많이 벗어난 이상치 : 상하위 0.3% 또는 평균+3*표준편차 

mpg <- as.data.frame(ggplot2::mpg)
mpg$hwy
mean(mpg$hwy) +3*sd(mpg$hwy)
mean(mpg$hwy) -3*sd(mpg$hwy)
boxplot(mpg$hwy)
# stats : boxplot의 통계치
result <- boxplot(mpg$hwy)$stats
result

#극단치 기준점
result[1]
result[5]
mpg$hwy <- ifelse(mpg$hwy>result[5] | mpg$hwy<result[1], NA,mpg$hwy)
table(is.na(mpg$hwy))
mpg$hwy
















