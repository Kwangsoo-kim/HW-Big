from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def home(request):
    #return HttpResponse('<h1>Hello,Django!</h1>')
    return render(request,'home.html') # html부르려면 무조건 templates 폴더에 있어야 인식
