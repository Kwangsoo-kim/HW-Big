

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

