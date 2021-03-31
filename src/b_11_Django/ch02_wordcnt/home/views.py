from django.shortcuts import render
from django.http import HttpResponse


def index(request):
    msg = 'My massage는 Hello,Django !'
    return render(request,'home/index.html',{'msg':msg})


def test(request):
    return HttpResponse('<h1 style="color:red;">테스트</h1><h2>페이지</h2>')

def intId(request,id):
    msg = '숫자 ID는 '+ str(id)
    type = '숫자'
    return render(request,'home/showId.html',{'msg':msg,'type':type})

def strId(request,id):
    msg = '문자 ID는'+id
    type = '문자'
    return render(request,'home/showId.html',{'msg':msg,'type':type})