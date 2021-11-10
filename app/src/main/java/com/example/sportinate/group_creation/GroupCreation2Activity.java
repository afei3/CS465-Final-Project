package com.example.sportinate.group_creation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.sportinate.R;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.AdapterView.OnItemSelectedListener;

public class GroupCreation2Activity extends AppCompatActivity {
    String sport_name ="";
    String date="";
    String start_ampm="";
    String end_ampm="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creation2);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            sport_name= bundle.getString("sport_name");
        }

        TextView sportName = (TextView) findViewById(R.id.sport_name);
        sportName.setText(sport_name);

        Spinner date_spinner = (Spinner) findViewById(R.id.date_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dates_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        date_spinner.setAdapter(adapter);
        //Add listener for responding info
        date_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                date = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        EditText startHour = (EditText) findViewById(R.id.start_hour);
        String start_hour = startHour.getText().toString();

        EditText startMinute = (EditText) findViewById(R.id.start_minute);
        String start_minute = startMinute.getText().toString();

        Spinner start_time_spinner = (Spinner) findViewById(R.id.start_time_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> start_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        start_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        start_time_spinner.setAdapter(start_adapter);
        //Add listener for responding info
        start_time_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                start_ampm = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        EditText endHour = (EditText) findViewById(R.id.end_hour);
        String end_hour = endHour.getText().toString();

        EditText endMinute = (EditText) findViewById(R.id.end_minute);
        String end_minute = endMinute.getText().toString();

        Spinner end_time_spinner = (Spinner) findViewById(R.id.end_time_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> end_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        end_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        end_time_spinner.setAdapter(end_adapter);
        //Add listener for responding info
        end_time_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                end_ampm = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }
}