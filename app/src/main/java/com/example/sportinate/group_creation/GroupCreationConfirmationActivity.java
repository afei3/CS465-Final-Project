package com.example.sportinate.group_creation;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_search_and_select.BrowseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GroupCreationConfirmationActivity extends AppCompatActivity {

    public GroupInfo group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creation_confirmation);
        group = (GroupInfo) getIntent().getSerializableExtra("group");
        //TODO: send group information to group list

//
//        TextView text = findViewById(R.id.success_message);
//        String message = getResources().getString(R.string.success_text);
//        message = message.replace("SPORT", group.sportName);
//
//        text.setText(message);


        Button create_another_group_button = findViewById(R.id.create_another_group);
        create_another_group_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupCreationConfirmationActivity.this, GroupCreationActivity.class);
                startActivity(intent);
            }
        });


        Button browse_groups_button = findViewById(R.id.browse_groups);
        browse_groups_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupCreationConfirmationActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 2);
                GroupInfo.group_1_create = true;
                startActivity(intent);
            }
        });

    }
}