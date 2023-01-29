from django.urls import path
from . import views

urlpatterns = [
    path('login', views.login, name='login'),
    path('get_questions', views.get_questions),
    path('get_flights', views.get_flights),
    path('get_passengers', views.get_passengers),
]