from django.urls import path
from . import views

app_name='students'
urlpatterns=[
    path('listAll/',views.listAll,name='listAll')



]