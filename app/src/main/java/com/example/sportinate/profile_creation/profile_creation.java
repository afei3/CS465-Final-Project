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
import com.example.sportinate.ProfileInfo;
import com.example.sportinate.bottom_nav_ui.profile.ProfileFragment;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class profile_creation extends AppCompatActivity{
    String sport_name ="";
    String date="";
    String skill_level="";
    String start_ampm="";
    String end_ampm="";
    String commitment="";
    String location="";
    ProfileInfo profile = new ProfileInfo();

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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //****** start hour, start minute, start am/pm *****
        EditText startHour = (EditText) findViewById(R.id.start_hour);
        startHour.setText("12");

        startHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


            }
        });

        EditText startMinute = (EditText) findViewById(R.id.start_minute);

        startMinute.setText("00");
        startMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //*** End hour, end minute, end am/pm


        EditText endHour = (EditText) findViewById(R.id.end_hour);

        endHour.setText("01");

        endHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


            }
        });

        EditText endMinute = (EditText) findViewById(R.id.end_minute);

        endMinute.setText("00");
        endMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


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
                location = s.toString();

            }
        });



        Button next_button = findViewById(R.id.next_button1);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=sport_name;
                String text2=date;
                String text3=skill_level;
                String text4=start_ampm;
                String text5=end_ampm;
                String text6=commitment;
                String text7=location;
                FileOutputStream fos=null;

                ProfileFragment.sport_name1 = sport_name;
                ProfileFragment.sport_level1 = skill_level;
                //抛出异常
                try {
                    fos=openFileOutput("user_sport",MODE_PRIVATE);

                    fos.write((text1+" "+text2+" "+text3+" "+text4+" "+text5+" "+text6+" "+text7).getBytes());
                    fos.flush();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent = new Intent(com.example.sportinate.profile_creation.profile_creation.this, profile_creation_comfirm.class);

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
                    skill_level = "New";
                break;
            case R.id.radio_intermediate:
                if (checked)
                    skill_level = "Intermediate";
                break;
            case R.id.radio_advanced:
                if (checked)
                    skill_level = "Advanced";
                break;
            case R.id.radio_expert:
                if (checked)
                    skill_level = "Expert";
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
                    commitment = "Casual";
                break;
            case R.id.radio_competitive:
                if (checked)
                    commitment = "Competitive";
                break;
            case R.id.radio_either:
                if (checked)
                    commitment = "Either";
                break;
        }
    }



}