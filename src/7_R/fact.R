fact<- function(x){
    if(x==0){
        cat('fact(',0,')의 결과 :',1)
    }else if(x>0){
        result= 1
        for(val in seq(x)){
            result= result*val     
        }
        cat('fact(',x,')의 결과 :',result)
    }else if(x<0){
        cat('음수값을 위한 팩토리얼은 존재하지 않아요')
    }
    
}