str(iris)
summary(iris)
iris[1:10,1, drop=F]
a<-subset(iris,subset=(Species=='virginica' ))
b<-subset(iris,subset=(Species=='setosa'))
a
b
rbind(a,b)
b[,1:2]

x<- c(12000,26000,18000)
y<- c(5,4,9)
z<- c(7,3,2)
B<-rbind(y,z)
B
dimnames(B)<-list(c('갑','을'),c('A작업','B작업','C작업'))
B
A<- matrix(x,nrow=1,ncol=3)
A
dimnames(A)<-list(c('시급'),c('A작업','B작업','C작업'))
A
t(A)

B%*%t(A)
