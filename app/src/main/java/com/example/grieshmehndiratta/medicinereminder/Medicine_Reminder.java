package com.example.grieshmehndiratta.medicinereminder;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Medicine_Reminder extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Button b_time,b_date;
    Alarm alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine__reminder);

        final FloatingActionButton FButton=findViewById(R.id.Action);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        db = new DatabaseHelper(Medicine_Reminder.this);
        alarm = new Alarm();
        displayAll();


        FButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                open_dialog_box();
            }
        });
    }
    void open_dialog_box() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Medicine_Reminder.this);
        LayoutInflater inflater = Medicine_Reminder.this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_box, null);
        b_time =  dialogView.findViewById(R.id.time_button);
        b_date =  dialogView.findViewById(R.id.Date);

        b_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Medicine_Reminder.this,Alarm.class);
                startActivity(intent);
            }
        });

        b_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Medicine_Reminder.this,date_act.class);
                startActivity(intent);
            }
        });
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("Enter text below");





        dialogBuilder.setPositiveButton("Add Task", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton)
            {

                    db.insert("abc", alarm.Time_Show(),"12/12/12");
                    Log.e("Time",alarm.Time_Show());
                    displayAll();
                    Toast.makeText(Medicine_Reminder.this, "Item Created", Toast.LENGTH_SHORT).show();

            }
        });


        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }








    public void displayAll(){
//        db.insert("ABC,","12:00","12/12/12");
        Cursor cursor = db.fetchAll();
        if(cursor != null && cursor.moveToNext()){
           do {
                list.add(cursor.getString(1)+cursor.getString(2)+cursor.getString(3));
            }while (cursor.moveToNext());
            adapter = new ArrayAdapter<>(Medicine_Reminder.this,
                    android.R.layout.simple_list_item_1,list);
            listView.setAdapter(adapter);
        }else{
            Toast.makeText(Medicine_Reminder.this, "Empty List", Toast.LENGTH_SHORT).show();
        }
    }
}
