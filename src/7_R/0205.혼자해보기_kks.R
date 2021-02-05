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