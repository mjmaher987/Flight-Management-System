# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models
import json

class AirlineManager(models.Model):
    username = models.CharField(primary_key=True, max_length=250)
    password = models.CharField(max_length=250, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'airline_manager'

class Airline(models.Model):
    name = models.CharField(max_length=250, blank=True, null=True)
    airlinemanagerid = models.ForeignKey(AirlineManager, models.DO_NOTHING, db_column='airlinemanagerid', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'airline'



class Airport(models.Model):
    name = models.CharField(max_length=250, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'airport'


class AirportAirline(models.Model):
    airportid = models.OneToOneField(Airport, models.DO_NOTHING, db_column='airportid', primary_key=True)
    airlineid = models.ForeignKey(Airline, models.DO_NOTHING, db_column='airlineid')

    class Meta:
        managed = False
        db_table = 'airport_airline'
        unique_together = (('airportid', 'airlineid'),)


class Flight(models.Model):
    flightnumber = models.AutoField(primary_key=True)
    date = models.DateTimeField(blank=True, null=True)
    airlineid = models.ForeignKey(Airline, models.DO_NOTHING, db_column='airlineid')

    class Meta:
        managed = False
        db_table = 'flight'

class Survey(models.Model):
    starttime = models.DateTimeField(blank=True, null=True)
    endtime = models.DateTimeField(blank=True, null=True)
    isvalid = models.BooleanField(blank=True, null=True)
    flightnumber = models.ForeignKey(Flight, models.DO_NOTHING, db_column='flightnumber', blank=True, null=True)
    creator = models.ForeignKey(AirlineManager, models.DO_NOTHING, db_column='creator', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'survey'

class AmAmSurvey(models.Model):
    airlinemanager2 = models.OneToOneField(AirlineManager, models.DO_NOTHING, db_column='airlinemanager2')
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='surveyid')
    airlinemanager1 = models.ForeignKey(AirlineManager, models.DO_NOTHING, db_column='airlinemanager1', blank=True, null=True,related_name='+')

    class Meta:
        managed = False
        db_table = 'am_am_survey'
        unique_together = (('airlinemanager2', 'surveyid'),)



class Question(models.Model):
    qnumber = models.IntegerField(primary_key=True)
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='surveyid')
    questiontitle = models.CharField(max_length=250, blank=True, null=True)
    access = models.BooleanField(blank=True, null=True)
    forecetoanswer = models.BooleanField(blank=True, null=True)
    passenger_type = models.CharField(max_length=250, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'question'
        unique_together = (('qnumber', 'surveyid'),)

class DescriptiveQuestion(models.Model):
    qnumber = models.OneToOneField(Question, models.DO_NOTHING, db_column='qnumber', primary_key=True)
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='surveyid')

    class Meta:
        managed = False
        db_table = 'descriptive_question'
        unique_together = (('qnumber', 'surveyid'),)

class Passenger(models.Model):
    passportnumber = models.AutoField(primary_key=True)
    name = models.CharField(max_length=500, blank=True, null=True)
    gender = models.CharField(max_length=250, blank=True, null=True)

    def toJSON(self):
        return {"passportnumber":self.passportnumber,
         "name":self.name,
         "gender":self.gender,
         "id": self.passportnumber
        }

    class Meta:
        managed = False
        db_table = 'passenger'


class Ticket(models.Model):
    ticketnumber = models.AutoField(primary_key=True)
    type = models.CharField(max_length=250, blank=True, null=True)
    cost = models.IntegerField(blank=True, null=True)
    seatnumber = models.IntegerField(blank=True, null=True)
    flightid = models.ForeignKey(Flight, models.DO_NOTHING, db_column='flightid')
    passengerid = models.ForeignKey(Passenger, models.DO_NOTHING, db_column='passengerid')

    class Meta:
        managed = False
        db_table = 'ticket'

class DescriptiveResponse(models.Model):
    responsetime = models.DateTimeField(blank=True, null=True)
    qnumber = models.ForeignKey(DescriptiveQuestion, models.DO_NOTHING, db_column='qnumber', blank=True, null=True)
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='survey_id')
    answer = models.CharField(max_length=250, blank=True, null=True)
    ticketnumber = models.ForeignKey(Ticket, models.DO_NOTHING, db_column='ticketnumber', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'descriptive_response'


class MultipleChoiceQuestion(models.Model):
    qnumber = models.OneToOneField(Question, models.DO_NOTHING, db_column='qnumber', primary_key=True)
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='survey_id')
    choice1 = models.CharField(max_length=250, blank=True, null=True)
    choice2 = models.CharField(max_length=250, blank=True, null=True)
    choice3 = models.CharField(max_length=250, blank=True, null=True)
    choice4 = models.CharField(max_length=250, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'multiple_choice_question'
        unique_together = (('qnumber', 'surveyid'),)


class MultipleChoiceResponse(models.Model):
    responsetime = models.DateTimeField(blank=True, null=True)
    qnumber = models.ForeignKey(Question, models.DO_NOTHING, db_column='qnumber', blank=True, null=True)
    surveyid = models.ForeignKey(Survey, models.DO_NOTHING, db_column='survey_id')
    selected = models.IntegerField(blank=True, null=True)
    passengerid = models.ForeignKey(Passenger, models.DO_NOTHING, db_column='passengerid', blank=True, null=True)
    ticketnumber = models.ForeignKey(Ticket, models.DO_NOTHING, db_column='ticketnumber', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'multiple_choice_response'




class Supervisor(models.Model):
    username = models.CharField(primary_key=True, max_length=250)
    password = models.CharField(max_length=250, blank=True, null=True)
    airportid = models.ForeignKey(Airport, models.DO_NOTHING, db_column='airportid')

    class Meta:
        managed = False
        db_table = 'supervisor'



