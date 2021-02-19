

        ### 12장 웹 데이터 수집 

# 1. 정적 웹 크롤링 - 단일 페이지 크롤링 (rvest 패키지 사용)
install.packages("rvest")
library(rvest)
url <- 'https://movie.naver.com/movie/point/af/list.nhn'
text <- read_html(url,encoding ='CP949')
text
# 영화 제목 : .movie
nodes <- html_nodes(text,'.movie')
title <- html_text(nodes)
title

# 영화에 대한 페이지
movieInfo <- html_attr(nodes,'href')
movieInfo <- paste0(url,movieInfo)
movieInfo

# 평점 : .list_netizen_score em
nodes <- html_nodes(text,'.list_netizen_score em')
point <- html_text(nodes)
point

# 영화 리뷰 : .title
nodes <- html_nodes(text,'.title')
nodes
review <- html_text(nodes)
review <- gsub('\t','',review)
review <- gsub('\n','',review)
review
review <- unlist(strsplit(review,'중[0-9]{1,2}'))[seq(2,20,2)]
review <- gsub('신고','',review)
review

page <- cbind(title,movieInfo)
page <- cbind(page,point)
page <- cbind(page,review)
View(page)

# csv 파일로 out
write.csv(page,"outData/movie_review.csv")
write.csv(page,"outData/movie_review1.csv", row.names = F) #행번호 삭제 


# 여러 페이지 정적 웹 크롤링
home <- 'https://movie.naver.com/movie/point/af/list.nhn'
site <- 'https://movie.naver.com/movie/point/af/list.nhn?&page='
movie.review <- NULL

for(i in 1:100){
    url <-paste0(site,i);
    text <- read_html(url,encoding = 'CP949')
    #영화제목
    nodes <- html_nodes(text,'.movie')
    title <- html_text(nodes)
    # 영화에 대한 페이지
    movieInfo <- html_attr(nodes,'href')
    movieInfo <- paste0(home,movieInfo)
    # 평점 : .list_netizen_score em
    nodes <- html_nodes(text,'.list_netizen_score em')
    point <- html_text(nodes)
    # 영화 리뷰 : .title
    nodes <- html_nodes(text,'.title')
    review <- html_text(nodes)
    review <- gsub('\t','',review)
    review <- gsub('\n','',review)
    review <- unlist(strsplit(review,'중[0-9]{1,2}'))[seq(2,20,2)]
    review <- gsub('신고','',review)
    page <- cbind(title,movieInfo)
    page <- cbind(page,point)
    page <- cbind(page,review)
    movie.review <- rbind(movie.review,page)
}
write.csv(movie.review,'outData/movie_review100page.csv')

class(movie.review)
str(movie.review)
movie.review<- as.data.frame(movie.review,stringsAsFactors = F)
head(movie.review)
# 1~ 100까지 크롤링 한 영화들 중 평점이 높은 10개를 시각화 하시오.
movie.review$point <- as.integer(movie.review$point)
movie.review%>%
    group_by(title)%>%
    summarise(mean=mean(point),cnt=n())%>%
    arrange(-mean,cnt)%>%
    head(10)%>%
    ggplot(aes(x=mean,y=title))+
    geom_col()

# 영화 리뷰 내용만 뽑아 최빈 단어 10개. 워드 클라우드 시각화

review <- str_replace_all(movie.review$review,'\\W',' ')
review <- str_replace_all(review,'[ㄱ-ㅎ]',' ')
review <- str_replace_all(review,'[0-9]',' ')
head(review)
nouns <- extractNoun(review)
class(nouns)
wordcount<- table(unlist(nouns))
df_word<- as.data.frame(wordcount,stringsAsFactors = F)
head(df_word)
df_word<- rename(df_word,word=Var1,freq=Freq)
df_word <- df_word%>%
            filter(nchar(word)>1)
head(df_word)

top10 <- df_word%>%
            arrange(-freq)%>%
            head(10)
# top20 그래프
ggplot(top10,aes(x=freq,y=reorder(word,freq)))+
    geom_col(fill='gray')+
    geom_text(aes(label=freq),hjust=1)
# 워드 클라우드
pal<-brewer.pal(8,'Dark2')
set.seed(1234)
wordcloud(words=df_word$word,
          freq =df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(4,1),
          colors = pal)



# 2. 동적 웹크롤링(셀레니움 패키지 이용) : 스크롤다운, 로그인이후...
# 특정 폴더 생성후 3개의 파일을 다운받아 압축을 풀고 셀레니움 서버 가동

# 필요한 패키지 다운로드와 로드
library(httr)
library(rvest)
install.packages("RSelenium")
library(RSelenium)

# # # # 셀레니움 동적 웹 크롤링 준비 


# 예제 1. 특정부분에 text를 입력한 후 엔터한 결과를 크롤링

remDr <- remoteDriver(port=4445L,
                      browserName='chrome')
remDr$open()
remDr$navigate('https://www.youtube.com')


# 서치창 가져오기
welElem <- remDr$findElement(using = 'css',
                             '#search')
welElem$sendKeysToElement(list('과학 다큐 비욘드', key='enter'))

# 현재 페이지의 소스 가져오기
html <- remDr$getPageSource()[[1]] 
html <- read_html(html)

# '#video-title' css안의 text 가져오기
youtube_title <- html%>%
    html_nodes('#video-title')%>%
    html_text()
head(youtube_title)

# 문자 정제제
youtube_title <- gsub('\n','',youtube_title)
youtube_title <- trimws(youtube_title) #텍스트 앞뒤 스페이스 제거
head(youtube_title)

# url
youtube_title_url <- html%>%
    html_nodes('#video-title')%>%
    html_attr('href')

youtube_title_url <- ifelse(is.na(youtube_title_url),'',paste0('https://www.youtube.com',youtube_title_url))

head(youtube_title_url)

# youtube_title만 text파일로 out
write.table(youtube_title,
            file='outData/과학다큐결과.txt',
            sep=',',
            row.names=F,
            quote=F)

#csv
result <- cbind(youtube_title,youtube_title_url)
write.csv(result,
          file='outData/과학다큐결과.csv',
          row.names=F)

# 예제2. 마우스를 스크롤 다운한 후 크롤링(댓글)

remDr <- remoteDriver(port=4445L,
                      browserName='chrome')
remDr$open()
remDr$navigate('https://youtu.be/tZooW6PritE')

btn <- remDr$findElement(using='css selector',
                         value='.html5-main-video')
btn$clickElement() # 메인 동영상 플레이 멈춤

# 마우스 스크롤 다운
remDr$executeScript('window.scrollTo(0,23000)')

# 현재 페이지의 html 소스 가져오기
html <- remDr$getPageSource()[[1]]
html <- read_html(html)

# 댓글만 추출
comments <- html%>%
    html_nodes('#content-text')%>%
    html_text()
head(comments)

# 저장
write.table(comments,
            file='outData/댓글.txt',
            sep=',',
            row.names=F,
            quote=F)



































