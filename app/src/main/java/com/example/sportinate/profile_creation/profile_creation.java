package com.example.sportinate.profile_creation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;

public class profile_creation extends AppCompatActivity{
    String sport_name ="";
    String date="";
    String skill_level="";
    String start_ampm="";
    String end_ampm="";
    String commitment="";
    String message="";
    GroupInfo group = new GroupInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_profile_creation);


        //******Sport spinner ********
        Spinner sports_spinner = (Spinner) findViewById(R.id.sports_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sports_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sports_spinner.setAdapter(adapter);
        //Add listener for responding info
        sports_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                sport_name = (String) parent.getItemAtPosition(position);
                group.sportName = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //******Date spinner********
        Spinner date_spinner = (Spinner) findViewById(R.id.date_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> date_adapter = ArrayAdapter.createFromResource(this,
                R.array.dates_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        date_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        date_spinner.setAdapter(date_adapter);
        //Add listener for responding info
        date_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                date = (String) parent.getItemAtPosition(position);
                group.date = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //****** start hour, start minute, start am/pm *****
        EditText startHour = (EditText) findViewById(R.id.start_hour);
        group.startHour = "12";
        startHour.setText(group.startHour);

        startHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.startHour = s.toString();

            }
        });

        EditText startMinute = (EditText) findViewById(R.id.start_minute);
        group.startMinute ="00";
        startMinute.setText(group.startMinute);
        startMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.startMinute = s.toString();

            }
        });

        Spinner start_time_spinner = (Spinner) findViewById(R.id.start_time_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> start_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        start_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        start_time_spinner.setAdapter(start_adapter);
        //Add listener for responding info
        start_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                start_ampm = (String) parent.getItemAtPosition(position);
                group.startAmpm = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //*** End hour, end minute, end am/pm


        EditText endHour = (EditText) findViewById(R.id.end_hour);
        group.endHour = "01";
        endHour.setText(group.endHour);

        endHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.endHour = s.toString();

            }
        });

        EditText endMinute = (EditText) findViewById(R.id.end_minute);
        group.endMinute ="00";
        endMinute.setText(group.endMinute);
        endMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.endMinute = s.toString();

            }
        });

        Spinner end_time_spinner = (Spinner) findViewById(R.id.end_time_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> end_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        end_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        end_time_spinner.setAdapter(end_adapter);
        //Add listener for responding info
        end_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                end_ampm = (String) parent.getItemAtPosition(position);
                group.endAmpm = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        EditText locationText = (EditText) findViewById(R.id.location);
        locationText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.location = s.toString();

            }
        });



        Button next_button = findViewById(R.id.next_button1);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String name=nameET.getText().toString();
//                String id=idET.getText().toString();
//                String floor=floorET.getText().toString();
//                String text1=text1ET.getText().toString();
//                String text2=text2ET.getText().toString();
//                String text3=text3ET.getText().toString();
//                String text4=text4ET.getText().toString();
//                FileOutputStream fos=null;
//                //抛出异常
//                try {
//                    fos=openFileOutput("login",MODE_APPEND);
//
//                    fos.write((name+" "+id+" "+floor+" "+text1+" "+text2+" "+text3+" "+text4).getBytes());
//                    fos.flush();
//                }catch (FileNotFoundException e){
//                    e.printStackTrace();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }finally {
//                    if(fos!=null){
//                        try {
//                            fos.close();
//                        }catch (IOException e){
//                            e.printStackTrace();
//                        }
//                    }

                Intent intent = new Intent(com.example.sportinate.profile_creation.profile_creation.this, profile_creation_comfirm.class);
                intent.putExtra("group", group);
                startActivity(intent);
            }
        });




    }

    //****** Skill level radio button
    public void onSkillRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_new:
                if (checked)
                    group.skillLevel = "New";
                break;
            case R.id.radio_intermediate:
                if (checked)
                    group.skillLevel = "Intermediate";
                break;
            case R.id.radio_advanced:
                if (checked)
                    group.skillLevel = "Advanced";
                break;
            case R.id.radio_expert:
                if (checked)
                    group.skillLevel = "Expert";
                break;
        }
    }

    //****** commitment level radio button
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_casual:
                if (checked)
                    group.commitment = "Casual";
                break;
            case R.id.radio_competitive:
                if (checked)
                    group.commitment = "Competitive";
                break;
            case R.id.radio_either:
                if (checked)
                    group.commitment = "Either";
                break;
        }
    }



}