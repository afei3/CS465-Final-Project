package com.example.sportinate.group_creation;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;

public class GroupCreationReviewActivity extends AppCompatActivity {

    public GroupInfo group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creation_review);
        getSupportActionBar().setTitle("Review Group");

        group = (GroupInfo) getIntent().getSerializableExtra("group");
        TextView groupName = findViewById(R.id.review_group_name);
        groupName.setText(group.groupName);


        TextView sportName = findViewById(R.id.review_sport_name);
        sportName.setText(group.sportName);

        TextView skillLevel = findViewById(R.id.review_skill);
        skillLevel.setText(group.skillLevel);

        String time ="";
        ArrayList<TimeSlot> time_arr = group.timeSlots;
        int margin =0;

        for(int i=0; i<time_arr.size(); i++){
            TimeSlot ts = time_arr.get(i);
            time += ts.date+" "+ts.startHour+":"+ts.startMinute+ts.startAmpm;
            time +=" - "+ts.endHour+":"+ts.endMinute+ts.endAmpm;
            if(i<time_arr.size()) {
                time += " \n ";

            }
            margin+=120;



        }
        TextView timeTitle = findViewById(R.id.time_title);
//        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        params.setMargins(0,10,0,margin);
//        timeTitle.setLayoutParams(params);

        TextView timeText = findViewById(R.id.review_time);
        timeText.setText(time);


        TextView location = findViewById(R.id.review_location);
        location.setText(group.location);

        TextView commitment = findViewById(R.id.review_commitment);
        commitment.setText(group.commitment);

        TextView message = findViewById(R.id.review_message);

        message.setText(group.message);


        Button back_button = findViewById(R.id.back_button2);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button next_button = findViewById(R.id.next_button2);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupCreationReviewActivity.this, GroupCreationConfirmationActivity.class);
                intent.putExtra("group", group);
                startActivity(intent);
            }
        });



    }
}