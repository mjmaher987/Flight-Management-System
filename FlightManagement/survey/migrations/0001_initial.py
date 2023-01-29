# Generated by Django 4.0.6 on 2023-01-29 09:30

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Airline',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'airline',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AirlineManager',
            fields=[
                ('username', models.CharField(max_length=250, primary_key=True, serialize=False)),
                ('password', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'airline_manager',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Airport',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'airport',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AmAmSurvey',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
            ],
            options={
                'db_table': 'am_am_survey',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DescriptiveResponse',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('responsetime', models.DateTimeField(blank=True, null=True)),
                ('answer', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'descriptive_response',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Flight',
            fields=[
                ('flightnumber', models.AutoField(primary_key=True, serialize=False)),
                ('date', models.DateTimeField(blank=True, null=True)),
            ],
            options={
                'db_table': 'flight',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='MultipleChoiceResponse',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('responsetime', models.DateTimeField(blank=True, null=True)),
                ('selected', models.IntegerField(blank=True, null=True)),
            ],
            options={
                'db_table': 'multiple_choice_response',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Passenger',
            fields=[
                ('passportnumber', models.AutoField(primary_key=True, serialize=False)),
                ('name', models.CharField(blank=True, max_length=250, null=True)),
                ('gender', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'passenger',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Question',
            fields=[
                ('qnumber', models.IntegerField(primary_key=True, serialize=False)),
                ('questiontitle', models.CharField(blank=True, max_length=250, null=True)),
                ('access', models.BooleanField(blank=True, null=True)),
                ('forecetoanswer', models.BooleanField(blank=True, null=True)),
                ('passenger_type', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'question',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Supervisor',
            fields=[
                ('username', models.CharField(max_length=250, primary_key=True, serialize=False)),
                ('password', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'supervisor',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Survey',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('starttime', models.DateTimeField(blank=True, null=True)),
                ('endtime', models.DateTimeField(blank=True, null=True)),
                ('isvalid', models.BooleanField(blank=True, null=True)),
            ],
            options={
                'db_table': 'survey',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Ticket',
            fields=[
                ('ticketnumber', models.AutoField(primary_key=True, serialize=False)),
                ('type', models.CharField(blank=True, max_length=250, null=True)),
                ('cost', models.IntegerField(blank=True, null=True)),
                ('seatnumber', models.IntegerField(blank=True, null=True)),
            ],
            options={
                'db_table': 'ticket',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AirportAirline',
            fields=[
                ('airportid', models.OneToOneField(db_column='airportid', on_delete=django.db.models.deletion.DO_NOTHING, primary_key=True, serialize=False, to='survey.airport')),
            ],
            options={
                'db_table': 'airport_airline',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DescriptiveQuestion',
            fields=[
                ('qnumber', models.OneToOneField(db_column='qnumber', on_delete=django.db.models.deletion.DO_NOTHING, primary_key=True, serialize=False, to='survey.question')),
            ],
            options={
                'db_table': 'descriptive_question',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='MultipleChoiceQuestion',
            fields=[
                ('qnumber', models.OneToOneField(db_column='qnumber', on_delete=django.db.models.deletion.DO_NOTHING, primary_key=True, serialize=False, to='survey.question')),
                ('choice1', models.CharField(blank=True, max_length=250, null=True)),
                ('choice2', models.CharField(blank=True, max_length=250, null=True)),
                ('choice3', models.CharField(blank=True, max_length=250, null=True)),
                ('choice4', models.CharField(blank=True, max_length=250, null=True)),
            ],
            options={
                'db_table': 'multiple_choice_question',
                'managed': False,
            },
        ),
    ]