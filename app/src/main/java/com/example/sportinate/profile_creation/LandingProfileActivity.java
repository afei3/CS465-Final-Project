package com.example.sportinate.profile_creation;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.ProfileInfo;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.bottom_nav_ui.profile.ProfileFragment;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.profile_creation.UserInfo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class LandingProfileActivity extends AppCompatActivity{

    private Button btnPhone;
    private ImageView imageView;

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0;

    private TextView tv;
    private Bitmap bm_photo = null;


    String sport_name ="";
    String date="";
    String skill_level="";
    String start_ampm="";
    String end_ampm="";
    String commitment="";
    String location="";
    ProfileInfo profile = new ProfileInfo();



    TimeSlot ts = new TimeSlot();
    GroupInfo group = new GroupInfo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_profile);
        getSupportActionBar().setTitle("Make Profile");





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
        date_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
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
        start_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        end_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                ts.endAmpm = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
                if (text3 == "")
                    text3 = "Unknown";
                if (text6 == "")
                    text6 = "Either";
                String text7="Arc";
                //if (text7 == "")
                //    text7 = "ARC";
                //FileOutputStream fos=null;

                ProfileFragment.sport_name1 = sport_name;
                ProfileFragment.sport_level1 = skill_level;
                profile_creation.sport1 = text1;
                profile_creation.level1 = text3;
                profile_creation.commitment1 = text6;
                profile_creation.location1 = text7;

                EditSportActivity.sportId +=1;

                Intent intent = new Intent(com.example.sportinate.profile_creation.LandingProfileActivity.this, profile_creation_comfirm.class);

                EditText user_name = (EditText) findViewById(R.id.user_name);
                String message1 = user_name.getText().toString();
                EditText user_descrip = (EditText) findViewById(R.id.message);
                String message2 = user_descrip.getText().toString();


                UserInfo user = new UserInfo();

                user.setName(message1);

                user.setDescrip(message2);

                intent.putExtra("key", user);

                BrowseActivity.user_name = message1;
                BrowseActivity.user_descrip = message2;
                BrowseActivity.user_photo = bm_photo;



                startActivity(intent);
            }
        });

        Button back_button = findViewById(R.id.back_button1);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                Intent intent = new Intent(com.example.sportinate.profile_creation.LandingProfileActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 2);
                startActivity(intent);
            }
        });




        btnPhone = (Button) findViewById(R.id.choose_photo);
        imageView = (ImageView) findViewById(R.id.imageView);
        //tv = (TextView) findViewById(R.id.img_path);
        btnPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                setImage();

            }

        });

    }

    private void setImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, IMAGE_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        ContentResolver resolver = getContentResolver();

        if (requestCode == IMAGE_CODE) {

            try {

                Uri originalUri = data.getData();

                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                bm_photo = bm;

                imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 200, 200));

                String[] proj = { MediaStore.Images.Media.DATA };


                Cursor cursor = managedQuery(originalUri, proj, null, null, null);


                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                btnPhone.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                //String path = cursor.getString(column_index);
                //tv.setText(path);
            } catch (IOException e) {
                Log.e("TAG-->Error", e.toString());

            }

            finally {
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

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

//    public void onLoc1Clicked(View view){
//        EditText text = (EditText) findViewById(R.id.location);
//        text.setText(R.string.loc1);
//
//
//    }
//
//    public void onLoc2Clicked(View view){
//        EditText text = (EditText) findViewById(R.id.location);
//        text.setText(R.string.loc2);
//
//
//    }
//    public void onLoc3Clicked(View view){
//        EditText text = (EditText) findViewById(R.id.location);
//        text.setText(R.string.loc3);
//
//    }

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
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 5, 0, 0);
        timeTextView.setLayoutParams(lp);

        ((LinearLayout) linearLayout).addView(timeTextView);



        ts = new TimeSlot();
        resetTimeSlot();


    }



}


