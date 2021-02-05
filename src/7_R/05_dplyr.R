
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
#dim() 차원 str()구조 summary()
head(mpg)
edit(mpg)
view(mpg)
dim(mpg)
summary(mpg) # 최소값, 1사분위수 ,중위수 ,3사분위수 , 최대값값
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
summary(midwest)
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


# 3.2 필요한 변수 추출하기 : select()
exam %>% 
    select(class,english,math) #존재하는 항목만 기입가능. 변형x
exam %>% 
    select(-math) # - 붙이면 그것만 제외하고 나머지 출력 
# class가 1과 2의 행중에서 영어,수학 데이터만 출력
exam %>% 
    filter(class %in% c(1,2)) %>% 
    select(english,math)
# class가 1,2,3행에서 영,수 데이터만 앞 5개 추출
exam %>% 
    filter(class %in% c(1,2,3)) %>% 
    select(english,math) %>% 
    head(5)

# 3.3 정렬하기 : arrange()
exam %>% arrange(math) # 오름차순 정렬 
exam %>% arrange(-math) # 내림차순 정렬 
exam %>% arrange(desc(math)) # -math 를 desc(math)로 써도 된다

exam %>%  arrange(class, -math) # 추가 조건은 연속 나열하면된다. 

#id가 1부터 10인 학생의 영어,수학성적을 기준으로 오름차순 정렬하고 top 6명 출력
exam %>% 
    filter(id==(1:10)) %>% 
    select(english,math) %>% 
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
    select(-id) %>% 
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
    summarise(avgtotal=mean(total)) %>% 
    arrange(-avgtotal) %>% 
    head(5)

# 혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요

mpg <- as.data.frame(ggplot2::mpg)
mpg
# Q1
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

#혼자서 해보기2

# Q1
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
