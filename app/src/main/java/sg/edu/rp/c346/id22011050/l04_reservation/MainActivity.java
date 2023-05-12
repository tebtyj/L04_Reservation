package sg.edu.rp.c346.id22011050.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnconfirm;
    Button btnclear;
    EditText etName;
    EditText etPhone;
    EditText etPax;
    RadioGroup rgpreferredArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnconfirm = findViewById(R.id.buttonConfirm);
        btnclear = findViewById(R.id.buttonClear);
        etName = findViewById(R.id.entName);
        etPhone=findViewById(R.id.entPhone);
        etPax = findViewById(R.id.entPax);
        rgpreferredArea = findViewById(R.id.preferredArea);


        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                 String getname = etName.getText().toString().trim();
                 String getphone = etPhone.getText().toString().trim();
                 String getpax = etPax.getText().toString().trim();
                 int hour = tp.getCurrentHour();
                 int min = tp.getCurrentMinute();
                 int day = dp.getDayOfMonth();
                 int month = dp.getMonth();
                 int year = dp.getYear();
                 String date= day+"/"+(month+1)+"/"+year;
                 int checkRadioButton = rgpreferredArea.getCheckedRadioButtonId();
                 if (getname.isEmpty() && getphone.isEmpty() &&getpax.isEmpty()){
                     Toast.makeText(MainActivity.this, "Cannot be booked. Please fill up all required information", Toast.LENGTH_LONG).show();
                 }else{
                     Toast.makeText(MainActivity.this,"Name: "+getname,Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity.this, "Phone: "+getphone, Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity.this, "Number of People: "+getpax, Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity.this, "Time: "+hour+":"+min, Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity.this, "Date: "+date, Toast.LENGTH_SHORT).show();
                    if(checkRadioButton == R.id.radioButtonSmoker){
                        Toast.makeText(MainActivity.this, "Table Area: Smoking Area", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Table Area: Non-Smoking Area",Toast.LENGTH_SHORT).show();
                    }


                 }
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                int yr = 2020;
                int date = 1;
                int mon = 5;
                dp.updateDate(yr,mon,date);
                etName.setText("");
                etPhone.setText("");
                etPax.setText("");
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker v, int hourOfDay, int minute) {
                if (tp.getCurrentHour()<8){
                    tp.setCurrentHour(8);
                    tp.setCurrentMinute(00);
                    Toast.makeText(MainActivity.this, "We are only open during 8am-8pm", Toast.LENGTH_SHORT).show();
                }else if (tp.getCurrentHour()>20){
                    tp.setCurrentHour(20);
                    tp.setCurrentMinute(00);
                    Toast.makeText(MainActivity.this, "We are only open during 8am-8pm", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}