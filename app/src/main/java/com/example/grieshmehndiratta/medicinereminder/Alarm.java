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
import android.widget.TimePicker;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    AlarmManager alarm_Manager;
    TimePicker alarm_TimePicker;
    PendingIntent pending_intent;
    boolean SET = false;
    private static String Time_display = "tett 12:30";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarm_Manager=(AlarmManager) getSystemService(ALARM_SERVICE);

        alarm_TimePicker=(TimePicker)findViewById(R.id.Alarm);

        final int[] hour = new int[1];
        final int[] minute = new int[1];
        final String[] hour_string = new String[1];
        final String[] minute_string = new String[1];





        final Calendar calender=Calendar.getInstance();

        final Intent my_intent=new Intent(Alarm.this,Alarm_Receiver.class);

        Button set=findViewById(R.id.Turn_on);
        set.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                SET = true;
                calender.set(Calendar.HOUR_OF_DAY,alarm_TimePicker.getHour());
                calender.set(Calendar.MINUTE,alarm_TimePicker.getMinute());
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
}
