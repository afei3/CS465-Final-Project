package com.example.sportinate.group_creation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.MainActivity;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.util.Arrays;


public class GroupCreationActivity extends AppCompatActivity {
    String sport_name ="";
    String date="";
    String start_ampm="";


    TimeSlot ts = new TimeSlot();
    GroupInfo group = new GroupInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creation);
        getSupportActionBar().setTitle("Create Group");

        //*********group name********
        EditText groupNameText = (EditText) findViewById(R.id.group_name);
        groupNameText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.groupName = s.toString();

            }
        });


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
        sports_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
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


        resetTimeSlot();


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
        date_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //ts.date = (String) parent.getItemAtPosition(position);
                ts.date = Arrays.asList((getResources().getStringArray(R.array.dates_short_array))).get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //****** start hour, start minute, start am/pm *****
        EditText startHour = (EditText) findViewById(R.id.start_hour);


        startHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                ts.startHour = s.toString();

            }
        });

        EditText startMinute = (EditText) findViewById(R.id.start_minute);


        startMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                ts.startMinute = s.toString();

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
        start_time_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                start_ampm = (String) parent.getItemAtPosition(position);
                ts.startAmpm = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //*** End hour, end minute, end am/pm


        EditText endHour = (EditText) findViewById(R.id.end_hour);

        endHour.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                ts.endHour = s.toString();

            }
        });

        EditText endMinute = (EditText) findViewById(R.id.end_minute);

        endMinute.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                ts.endMinute = s.toString();

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
        end_time_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                ts.endAmpm = (String) parent.getItemAtPosition(position);
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

        EditText messageText = (EditText) findViewById(R.id.message);
        messageText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                group.message = s.toString();

            }
        });


        Button back_button = findViewById(R.id.back_button1);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button next_button = findViewById(R.id.next_button1);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check all required fields
                if(group.groupName==null|| group.groupName.equals("")){
                    Toast.makeText(GroupCreationActivity.this, "Please fill out group name", Toast.LENGTH_SHORT).show();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.group_name_layout);
                    ll.requestFocus();

                }else if(group.skillLevel==null){
                    Toast.makeText(GroupCreationActivity.this, "Please select a skill level", Toast.LENGTH_SHORT).show();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.skill_layout);
                    ll.requestFocus();

                }else if(group.timeSlots.isEmpty()){
                    Toast.makeText(GroupCreationActivity.this, "Please fill out group meeting time(s)", Toast.LENGTH_SHORT).show();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.time_layout);
                    ll.requestFocus();

                }else if(group.location==null ||
                        group.location.equals("")){
                    Toast.makeText(GroupCreationActivity.this, "Please fill out location", Toast.LENGTH_SHORT).show();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.location_layout);
                    ll.requestFocus();


                }else if(group.commitment==null){
                    Toast.makeText(GroupCreationActivity.this, "Please select a commitment level", Toast.LENGTH_SHORT).show();
                    LinearLayout ll = (LinearLayout) findViewById(R.id.commitment_layout);
                    ll.requestFocus();


                }else {
                    Intent intent = new Intent(GroupCreationActivity.this, GroupCreationReviewActivity.class);
                    intent.putExtra("group", group);
                    startActivity(intent);
                }
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

    public void onLoc1Clicked(View view){
        EditText text = (EditText) findViewById(R.id.location);
        text.setText(R.string.loc1);


    }

    public void onLoc2Clicked(View view){
        EditText text = (EditText) findViewById(R.id.location);
        text.setText(R.string.loc2);


    }
    public void onLoc3Clicked(View view){
        EditText text = (EditText) findViewById(R.id.location);
        text.setText(R.string.loc3);

    }

    public void resetTimeSlot(){

        Spinner date_spinner = (Spinner) findViewById(R.id.date_spinner);
        ArrayAdapter<CharSequence> date_adapter = ArrayAdapter.createFromResource(this,
                R.array.dates_array, android.R.layout.simple_spinner_item);
        date_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        date_spinner.setAdapter(date_adapter);


        Spinner start_time_spinner = (Spinner) findViewById(R.id.start_time_spinner);
        ArrayAdapter<CharSequence> start_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        start_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        start_time_spinner.setAdapter(start_adapter);

        Spinner end_time_spinner = (Spinner) findViewById(R.id.end_time_spinner);
        ArrayAdapter<CharSequence> end_adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        end_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        end_time_spinner.setAdapter(end_adapter);



        EditText startHour = (EditText) findViewById(R.id.start_hour);
        ts.startHour = "12";
        startHour.setText(ts.startHour);

        EditText startMinute = (EditText) findViewById(R.id.start_minute);
        ts.startMinute ="00";
        startMinute.setText(ts.startMinute);


        EditText endHour = (EditText) findViewById(R.id.end_hour);
        ts.endHour = "01";
        endHour.setText(ts.endHour);

        EditText endMinute = (EditText) findViewById(R.id.end_minute);
        ts.endMinute ="00";
        endMinute.setText(ts.endMinute);

    }

    public void onClearTimeClicked(View view){
        group.clearTimeSlot();
        LinearLayout ll = (LinearLayout)  findViewById(R.id.time_slots);
        ll.removeAllViews();

    }

    public void onAddTimeSlotClicked(View view){


        group.addTimeslot(ts);

        //Add ts textview to time slot layout

        View linearLayout =  findViewById(R.id.time_slots);

        TextView timeTextView = new TextView(this);
        String time="";
        time += ts.date+" "+ts.startHour+":"+ts.startMinute+ts.startAmpm;
        time += " - "+ts.endHour+":"+ts.endMinute+ts.endAmpm;
        timeTextView.setText(time);
        timeTextView.setTextSize(20);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 5, 0, 0);
        timeTextView.setLayoutParams(lp);

        ((LinearLayout) linearLayout).addView(timeTextView);



        ts = new TimeSlot();
        resetTimeSlot();


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