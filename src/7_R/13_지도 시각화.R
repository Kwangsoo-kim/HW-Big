

        ### 13. 지도 시각화


# 1. 미국 주별 강력 범죄율 시각화
USArrests
# (1) 패키지 준비
install.packages('ggiraphExtra') # 지도 시각화 패키지
library(ggiraphExtra)
install.packages('mapproj') 
library(mapproj)
install.packages('maps')
library(maps)
library(ggplot2)
library(dplyr)
library(tibble) # 행이름을 변수로 하기 위한 작업

# (2) 행이름을 변수로
crime <- rownames_to_column(USArrests,var="state")
class(crime)
str(crime)
head(crime)
crime$state <- tolower(crime$state) #주명을 소문자로

# (3) 미국 지도 주 정보 가져오기
state_map <- map_data('state')

# (4) 지도 시각화
ggChoropleth(data=crime,        # 지도에 표현할 데이터
             aes(fill=Murder,   # 지도에 채울 변수
                 map_id=state), # 지역 변수
             map=state_map,     # 위도 경도 지도 데이터
             interactive = T)   # 인터렉티브 속성   


# 2. 대한민국 시도별 인구, 결핵 환자 수 단계 구분도 만들기
rm(list=ls())
install.packages("stringi")
install.packages("devtools")
devtools::install_github('cardiomoon/kormaps2014')
library(kormaps2014)
head(korpop1)
# korpop1 : 2015년 센서스 데이터(시도별)
# korpop2 : 2015년 센서스 데이터(시군구별)
# korpop3 : 2015년 세서스 데이터(읍면동별)

str(changeCode(korpop1)) # utf-8로 인코딩 된 데이터를 CP949로 변환 후 출력
library(dplyr)
korpop1 <- rename(korpop1,
                  pop=총인구_명,
                  name=행정구역별_읍면동)

# korpop1$name ; UTF-8을 CP949로 
korpop1$name <- iconv(korpop1$name,'UTF-8','CP949')

# 지도 시각화
str(changeCode(korpop1))
head(kormap1)
head(changeCode(kormap1))
head(changeCode(korpop1[,c('name','pop','code')]))
ggChoropleth(data=korpop1,
             aes(fill=pop,
                 map_id=code,
                 tooltip=name),
             map=kormap1,
             interactive = T)

# 결핵 환자 수 지도 시각화

# UTF-8을 CP949로
tbc$name1 <- iconv(tbc$name1,'UTF-8','CP949')
tbc$name <- iconv(tbc$name,'UTF-8','CP949')
head(tbc)

#지도 시각화
ggChoropleth(data=tbc,
             aes(fill=NewPts,
                 map_id=code,
                 tooltip=name),
             map=kormap1,
             interactive = T)

# 한국행정지도(2014)팩키지 kormaps2014안내
# https://rpubs.com/cardiomoon/222145













