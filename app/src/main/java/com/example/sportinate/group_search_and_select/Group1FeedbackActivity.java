package com.example.sportinate.group_search_and_select;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sportinate.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Group1FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group1_feedback);

        Button view_groups_button = findViewById(R.id.view_groups);
        view_groups_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO change groups info for user MyGroups visibility
                Intent intent = new Intent (Group1FeedbackActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 3);
                startActivity(intent);
            }
        });

        Button browse_groups_button = findViewById(R.id.browse_groups);
        browse_groups_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO change groups info for user MyGroups visibility
                Intent intent = new Intent (Group1FeedbackActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 2);
                startActivity(intent);
            }
        });
    }
}