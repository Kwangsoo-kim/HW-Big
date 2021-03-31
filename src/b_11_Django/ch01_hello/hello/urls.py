from django.urls import path
from . import views #.은 현재폴더 의미

urlpatterns = [
    path('',views.home, name='home')
]
