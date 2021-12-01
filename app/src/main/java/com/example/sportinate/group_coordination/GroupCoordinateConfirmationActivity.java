package com.example.sportinate.group_coordination;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;

import androidx.appcompat.app.AppCompatActivity;

public class GroupCoordinateConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_confirm_kick);

        Button back = findViewById(R.id.manage_back_button2);
        Button kick = findViewById(R.id.remove_user);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupCoordinateConfirmationActivity.this, GroupCoordinateActivity.class);
                startActivity(intent);
            }
        });

        kick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupInfo.deleted_user = true;
                Intent intent = new Intent(GroupCoordinateConfirmationActivity.this, GroupCoordinateActivity.class);
                startActivity(intent);
            }
        });
    }
}
