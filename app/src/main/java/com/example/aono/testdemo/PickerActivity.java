package com.example.aono.testdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class PickerActivity extends AppCompatActivity {

    private Button mBtnDate;
    private Button mBtnTime;
    private Button mBtnPos;

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mBtnDate.setText(year + "年" + (month+1) + "月" + dayOfMonth + "日");
        }
    };
    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mBtnTime.setText(hourOfDay + ":" + minute);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        mBtnDate = (Button) findViewById(R.id.btn_date);
        mBtnTime = (Button) findViewById(R.id.btn_time);
        mBtnPos = (Button) findViewById(R.id.btn_pos);



        mBtnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
                //其实是可以更改Theme的
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(), dateListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        mBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
                TimePickerDialog dialog = new TimePickerDialog(v.getContext(), timeListener,
                        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                dialog.show();
            }
        });
        mBtnPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

    }
}
