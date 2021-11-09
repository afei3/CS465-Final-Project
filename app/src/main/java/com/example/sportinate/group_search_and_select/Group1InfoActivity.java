package com.example.sportinate.group_search_and_select;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Group1InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);

        Button join_button = findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO change to go to feedback screen and then change groups info for user MyGroups visibility (Sruthi)
                //TODO If no profile, takes to sign-in page (Sruthi)
                Intent intent = new Intent (Group1InfoActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 3);
                startActivity(intent);
            }
        });
    }
}