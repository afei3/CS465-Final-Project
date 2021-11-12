package com.example.sportinate.group_creation;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GroupCreationReviewActivity extends AppCompatActivity {

    public GroupInfo group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creation_review);

        group = (GroupInfo) getIntent().getSerializableExtra("group");

        TextView sportName = findViewById(R.id.review_sport_name);
        sportName.setText(group.sportName);

        TextView skillLevel = findViewById(R.id.review_skill);
        skillLevel.setText(group.skillLevel);

        String time ="";
        time += group.date+" "+group.startHour+":"+group.startMinute+group.startAmpm;
        time +=" - "+group.endHour+":"+group.endMinute+group.endAmpm;


        TextView timeText = findViewById(R.id.review_time);
        timeText.setText(time);


        TextView location = findViewById(R.id.review_location);
        location.setText(group.location);

        TextView commitment = findViewById(R.id.review_commitment);
        commitment.setText(group.commitment);

        TextView message = findViewById(R.id.review_message);
        message.setText(group.message);


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