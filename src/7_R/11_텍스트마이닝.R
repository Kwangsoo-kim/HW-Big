


            ### 11장 텍스트 마이닝
# 문자로 된 비정형 데이터로 부터 가치있는 정보를 얻어내는 분석
# 텍스트 마이닝 시 가장 먼저 할 일은 형태소 분석 


 

install.packages("rJava")
install.packages("memoise")
install.packages("devtools")
install.packages("hash")
install.packages("tau")
install.packages("Sejong")
## https://cran.r-project.org/web/packages/KoNLP/index.html -> archive -> KoNLP_0.80.2.tar.gz 다운로드 받아 수동설치
# 우측의 pakages -> install 도구사용
# scala-library-2.11.8.jar.을 KoNLP 폴더의 java에 복사
library(KoNLP)
Sys.getenv("JAVA_HOME")
useNIADic() #사전 설정
extractNoun('대한민국의 영토는 한반도와 그 부속 도시로 한다')
extractNoun('의미있는 하루 하루, 알차고 환희찬 하루 감사해요')

# 1. 힙합 가사 텍스트 마이닝
# 1.1 텍스트 마이닝 할 텍스트 로드
txt<- readLines('inData/hiphop.txt') # 비정형 데이터
txt

# 1.2 특수문자 제거
# gsub(oldStr,newStr,string)
# str_replace_all(string,oldStr,newStr)
library(stringr)
temp <- gsub('\\W',' ',txt) # \\W 문자제외 나머지 특수문자들.
txt <- str_replace_all(txt,'\\W',' ')
table(temp==txt)

# 1.3 명사 추출
head(txt)
noun <- extractNoun(txt) # 명사만 추출 list형태로 반환
class(noun)
unlist(noun)
wordcount<- table(unlist(noun)) # 워드카운트
df_word <- as.data.frame(wordcount,stringsAsFactors = F) # stringsAsFactors 문자를 factor타입으로 안바꾸려고
head(df_word,20)
library(dplyr)
df_word<- rename(df_word, word=Var1,freq=Freq)
str(df_word)
df_word <- df_word%>%
    filter(nchar(word)>=2) #nchar 문자수 반환 
df_word

# 자주 사용되는 단어 빈도표 top20 만들기
top20 <- df_word[order(-df_word$freq),][1:20,]

top20 <- df_word%>%
    arrange(-freq)%>%
    head(20)
top20
library(ggplot2)
# 자두 사용되는 단어 top20 빈도표
ggplot(top20,aes(x=reorder(word,freq),y=freq))+
    geom_bar(stat='identity',fill='gray')+
    coord_flip()+
    geom_text(aes(label=freq),hjust=1)

library(RColorBrewer)

# 워드클라우드 
# 1. 비정형 text 데이터 확보
# 2. 패키지 설치 및 로드 (wordcloud)
# 3. 확보된 text 데이터 읽어오기
# 4. 명사 추출
# 5. 필요없는 데이터 삭제
# 6. 워드카운트 생성
# 7. wordcloud 함수 이용,생성

install.packages("wordcloud")
library(wordcloud)

# seed값 설정하면, 랜던값이 동일하게 나온다. 
set.seed(1234)
##round(runif(6,min=1,max=45))
pal <- brewer.pal(8,'Dark2')
wordcloud(words = df_word$word, # 뿌릴 단어
          freq = df_word$freq,  # 단어 빈도
          min.freq = 2,         # 최소 단어 빈도
          max.word = 200,       # 나타낼 최대 단어 수
          random.order = F,     # 최빈 단어를 중앙 배치
          rot.per = 0.1,        # 회전 단어 비율
          scale = c(2,0.1),     # 단어 크기 범위
          colors = pal)         # 단어 색상

pal <- brewer.pal(9,'Blues')[5:9]
set.seed(1234)
wordcloud(words = df_word$word, # 뿌릴 단어
          freq = df_word$freq,  # 단어 빈도
          min.freq = 2,         # 최소 단어 빈도
          max.word = 2000,       # 나타낼 최대 단어 수
          random.order = F,     # 최빈 단어를 중앙 배치
          rot.per = 0.1,        # 회전 단어 비율
          scale = c(2,0.1),     # 단어 크기 범위
          colors = pal)         # 단어 색상

# 2. 국정원 트윗 텍스트 마이닝 
rm(list=ls())
twitter <- read.csv('inData/twitter.csv',header = T,stringsAsFactors = F,fileEncoding = 'UTF-8')
twitter <- rename(twitter,no=번호,id=계정이름,date=작성일,tw=내용)
colnames(twitter)


# 필요없는 단어 삭제하기 
twitter$tw <- str_replace_all(twitter$tw,'\\W',' ')
twitter$tw <- str_replace_all(twitter$tw,'[ㄱ-ㅎ]',' ')
twitter$tw <- str_replace_all(twitter$tw,'  ',' ')
twitter$tw

nouns <- extractNoun(twitter$tw)
nouns<-unlist(nouns)
wordcount <- table(nouns)
df_word <- as.data.frame(wordcount,stringsAsFactors = F)
str(df_word)

df_word <- rename(df_word,word=nouns,freq=Freq)
head(df_word)
# 출현단어 중 2글자 이상만 분석
df_word <- df_word%>%
            filter(nchar(word)>=2)
head(df_word)
# 최빈 단어 top20 뽑기
top20<-df_word%>%
        arrange(-freq)%>%
        head(20)
# top20 그래프
ggplot(top20,aes(x=reorder(word,freq),y=freq))+
    geom_bar(stat="identity",fill='gray')+
    coord_flip()+
    geom_text(aes(label=freq),hjust=1)
# 워드클라우드 그리기
pal<-brewer.pal(8,'Blues')
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 5,
          max.words = 300,
          random.order = F,
          rot.per = 0.1,
          scale=c(3,0.3),
          colors = pal)



rm(list=ls())
twitter <- read.csv('inData/twitter.csv',header = T,stringsAsFactors = F,fileEncoding = 'UTF-8')
twitter <- rename(twitter,no=번호,id=계정이름,date=작성일,tw=내용)
sort(table(twitter$id))

# 글 게시 수가 150회 이상 트윗한 게시물에 대해 최빈 top 20개 단어를 출력하고 그래프를 출력, 그리고 워드클라우드를 완성하시오
twit150 <- twitter$tw[order(table(twitter$id)>=150)]
str(twit150)
twit150 <- str_replace_all(twit150,'\\W',' ')
twit150 <- str_replace_all(twit150,'[ㄱ-ㅎ]',' ')
twit150 <- str_replace_all(twit150,'  ',' ')
head(twit150)
nouns <- extractNoun(twit150)
wordcount <- table(unlist(nouns))
df_word <- as.data.frame(wordcount,stringsAsFactors = F)
str(df_word)
df_word <- rename(df_word,word=Var1,freq=Freq)

df_word%>%
    filter(nchar(word)>1)%>%
    arrange(-freq)%>%
    head(20)%>%
    ggplot(aes(x=freq,y=reorder(word,freq)))+
    geom_col(fill='gray')+
    geom_text(aes(label=freq),hjust=1)

set.seed(1234)
df_word<- df_word%>%
    filter(nchar(word)>1)


wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 5,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(2.5,0.3),
          colors = pal)






























