from .models import *
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse, HttpResponse

def login(request):
    pass

def get_passengers(request):
    result = [p.toJSON() for p in Passenger.objects.all().order_by('id')]
    return JsonResponse(result, safe=False)

@csrf_exempt
def update_passenger(request):
    data = json.loads(request.body)
    if('id' in data):
        p = Passenger.objects.get(id = data['id'])
        p.name = data['name']
        p.gender = data['gender']
        p.passportnumber = data['passportNumber']
        p.save()
    else:
        p = Passenger.objects.create(name=data['name'], passportnumber=data['passportNumber'],gender=data['gender'])
        p.save()
    return HttpResponse()


def get_questions(request):
    queryset = Question.objects.all().values()
    return JsonResponse({"result": list(queryset)})

def get_flights(request):
    queryset = Flight.objects.all().values()
    return JsonResponse({"result": list(queryset)})

def index(request):

    queryset = AirlineManager.objects.all().values()
    return JsonResponse({"result": list(queryset)})
