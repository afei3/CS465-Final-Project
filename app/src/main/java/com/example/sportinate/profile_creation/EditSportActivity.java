package com.example.sportinate.profile_creation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_search_and_select.BrowseActivity;

public class EditSportActivity extends AppCompatActivity {
    public GroupInfo group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sports);
        group = (GroupInfo) getIntent().getSerializableExtra("group");
        //TODO: send group information to group list

        Button add_sport_button = findViewById(R.id.add_new_sport);
        add_sport_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.sportinate.profile_creation.EditSportActivity.this, profile_creation.class);
                intent.putExtra("fragmentNumber", 2);
                GroupInfo.group_test_bool = true;
                startActivity(intent);
            }
        });

    }
}