from django.contrib import admin

from .models import Question, Flight

admin.site.register(Question)
admin.site.register(Flight)