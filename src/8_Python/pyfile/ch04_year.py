# -*- coding: utf-8 -*-
"""
태어난 연도를 입력받아, 나이와 성인(20살 이상)인지 청소년(15~19살)인지
아동(14살이하)인지 출력하시오.
"""
import sys
if len(sys.argv)==1:
    birth= int(input('테어난 연도를 입력해주세요(4자리) : '))
else:
    birth = int(sys.argv[1])
    
age=2021-birth+1

if age>=20:
    group='성인'
elif 15<=age<=19:
    group='청소년'
else:
    group='아동'
print('{}년도 생이신 당신은 {}살이고 {}입니다'.format(birth,age,group))