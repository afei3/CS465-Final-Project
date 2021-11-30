package com.example.sportinate.group_search_and_select;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Group2InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group2_info);

        getSupportActionBar().setTitle("Group Information");
        Button join_button = findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO make group 2 show up in My Groups page
                GroupInfo.group_2_join = true;
                Intent intent = new Intent (Group2InfoActivity.this, Group1FeedbackActivity.class);
                startActivity(intent);
            }
        });
    }
}