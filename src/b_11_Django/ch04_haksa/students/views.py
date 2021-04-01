from django.shortcuts import render
from students.models import Student

def listAll(request):
    qs = Student.objects.all()
    context = {'student_list':qs}
    return render(request,'students/studentListAll.html',context)