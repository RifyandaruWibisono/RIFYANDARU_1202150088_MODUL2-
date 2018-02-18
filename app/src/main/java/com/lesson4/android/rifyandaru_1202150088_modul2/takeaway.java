package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class takeaway extends AppCompatActivity {
    private EditText TIME;
    private EditText DATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeaway);
        TIME = (EditText) findViewById(R.id.time);
        DATE = (EditText) findViewById(R.id.date);
        Intent A = getIntent();
        Toast tampil1 = Toast.makeText(this, A.getStringExtra("toast"), Toast.LENGTH_SHORT);
        tampil1.show();
        //menunjukkan fragmen saat edittext di klik.
        TIME.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showTimePickerDialog(view);
            }
        });

        DATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });
    }

    private void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"date Picker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" +
                day_string + "/" + year_string);
        DATE.setText(dateMessage);
    }

    private void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "time picker");
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);
        TIME.setText(timeMessage);
    }

    public void pilihPesan(View view) {
        Intent intent = new Intent(this, menumakan.class);
        startActivity(intent);
    }

}
