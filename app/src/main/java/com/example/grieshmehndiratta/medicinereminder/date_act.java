package com.example.grieshmehndiratta.medicinereminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date_act extends AppCompatActivity {

    Calendar calendar;
    Button setBtn;
    AlarmManager alarm_Manager;
    DatePicker datePicker;
    PendingIntent pending_intent;
    boolean SET = false;
    private static String Time_display = "test 12:30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_alarm );
        alarm_Manager = (AlarmManager) getSystemService( ALARM_SERVICE );
        datePicker = (DatePicker) findViewById( R.id.Date_Picker );



    }

    /*void showDate(){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = String.valueOf( day )+"/"+ String.valueOf( month )+"/"+String.valueOf( year );
        Log.e("Date = ",date);
    }*/
}

       /* final int[] Year = new int[1];
        final int[] Month = new int[1];
        final int[] Day = new int[1];
        final String[] Year_string = new String[1];
        final String[] Month_string = new String[1];
        final String[] Day_string = new String[1];
        int inputDate=2012012;
        DateFormat df=new SimpleDateFormat( "yyyyMMdd" );
        Date date= null;
        try {
            date = df.parse(String.valueOf( inputDate ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s=date.format(date);




        final Calendar calender = Calendar.getInstance();

        final Intent my_intent=new Intent(Alarm.this,Alarm_Receiver.class);

        Button set = findViewById(R.id.Turn_on);
        set.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                SET = true;
               *//* calender.set(Calendar.YEAR,Date_Picker.getYear());
                calender.set(Calendar.DAY_OF_MONTH,Date_Picker.getMonth());
                calender.set(Calendar.,Date_Picker.);*//*
                //set date
                //Calendar.set(Calendar.)
                hour[0] =alarm_TimePicker.getHour();
                minute[0] =alarm_TimePicker.getMinute();
                hour_string[0] =String.valueOf( hour[0]);
                minute_string[0]=String.valueOf( minute[0] );

                Time_display = hour_string[0]+":"+minute_string[0];

                pending_intent=PendingIntent.getBroadcast(Alarm.this,0,my_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarm_Manager.set(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),pending_intent);
            }
        });
        Button cancel=findViewById(R.id.Turn_off);



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alarm_Manager.cancel(pending_intent);

            }
        });

    }
    String Time_Show()
    {
        Log.e("calling",Time_display );
        return Time_display;

    }

    public boolean check_alarm(){

        return SET;
    }
    
    
    
    
    
    
    
    
    
    
    
    Button set, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_act);
        set = findViewById(R.id.set_button);
        cancel = findViewById(R.id.cancel_button);

    }
}
*/