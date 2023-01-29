from .models import *
from django.http import JsonResponse, HttpResponse

def login(request):
    pass

def get_passengers(request):
    result = [p.toJSON() for p in Passenger.objects.all()]
    return JsonResponse(result, safe=False)


def get_questions(request):
    queryset = Question.objects.all().values()
    return JsonResponse({"result": list(queryset)})

def get_flights(request):
    queryset = Flight.objects.all().values()
    return JsonResponse({"result": list(queryset)})

def index(request):

    queryset = AirlineManager.objects.all().values()
    return JsonResponse({"result": list(queryset)})
