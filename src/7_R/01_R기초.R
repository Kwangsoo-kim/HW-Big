###################################################################################
################ 2 장. R Language 기초 #################


# 1. 도움말 기능 
iris
edit(iris)
?iris   # 도움말 출력
help(iris) # 도움말 출력
# 1.2 검색기능
??iris
help.search('iris')
# 1.3 패키지 도움말
library(help='datasets')
# 1.4 함수 도움말
methods(as) #형변환 함수들
as.integer(1.25)
?as.integer
example("as.integer") #예제 출력하기

data <- c(10,20,30)
mean(data) #평균균
?mean
example(mean)

# 1.5 정보조회
attributes(iris) #열이름, 행이름 , 타입

# 1.6 주석과 자동완성
주석은 #
#자동완성은 TAB
R.version

# 2. 패키지
#R내에 기본패키지외의 패키지는 다운받을 수 있다.
# 2.1 패키지 설치 
  # 설치 : install.packages("패키지명")
  # 설치된 패키지를 메모리에 로드 library("패키지명")
  # 패키지 내의 데이터나 함수들 사용가능
  # 패키지 언로드 : dedach("pakage:패키지명",unload=TRUE)
iris
detach("package:datasets",unload=TRUE)
iris
install.packages("arules")
library("arules")
?apriori
detach("package:arules",unload = TRUE)

# 데이터의 경우는 메모리에 패키지 로드 없이 사용가능
data(iris,package="datasets")
iris

#변수들 다 삭제
ls()
rm(list=ls())

# 3. 변수
# 변수 : 특수문자 중 ,,_ 사용가능
# 할당 : <-, <<-
result <- 0 # 전역변수 result
class(result) # 타입 확인
add <- function(a, b){
  #result <- a+b # 지역변수
  result <<- a+b # 전역변수에 할당
  return(result)
}
add(10,20)
result

# 변수목록 조회
x<- 10
y<- 10
(z<-x+y)
ls() # 변수들 출력(히든 변수 미포함)
ls(all.names = TRUE) # 히든변수 포함

# 4. 출력
result
print(result)
(z<-z+10)
paste('Hello','world')
paste('result 값은',result)
paste('Hello','word',sep=',')
1:3
paste(1:3)
paste(c(1,2,3),c('하나','둘','셋'),sep='은')
paste(c(1,2,3),c('하나','둘','셋'),sep='은',collapse='/')

month.name
(nth<-paste(1:12,c('st','nd','rd',rep('th',9)), sep=''))
paste(month.name,nth,sep=':',collapse=';')

# 5. 변수 삭제
rm(z) # z 변수 삭제
rm(list=ls()) # 선언변수 삭제
rm(list=ls(all.names =TRUE)) # 히든변수까지 삭제

# 6. R확장자
# ~.R : R 스크립트 파일(R실행코드 저장)
# ~.RData : R 작업공간
# ~.Rhistory : 콘솔창에 실행한 R명령어들의 history 저장

# 문.  kor에 '한국','일본','미국'
      #usa에 'Korea','Japan','America'
      # 출력은 한국:korea, 일본:Japan , 미국:America
            # "한국:korea" "일본:Japan" "미국:America"

kor<-c('한국','일본','미국')
usa<-c('Korea','Japan','America')
paste(kor,usa,sep=':')
paste(kor,usa,sep=':',collapse = ',')

# 문2. MASS::Cars93 데이터를 출력해 보세요
data(Cars93,package='MASS')
Cars93
edit(Cars93)