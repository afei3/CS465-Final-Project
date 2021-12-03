package com.example.sportinate.group_coordination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.MainActivity;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.bottom_nav_ui.groups.GroupsFragment;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;
import com.example.sportinate.group_search_and_select.Group1FeedbackActivity;

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

public class GroupCoordinateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Group Coordination");
        if (GroupInfo.deleted_user) {
            setContentView(R.layout.activity_coordinate_kicked);
        } else {
            setContentView(R.layout.activity_coordinate_group);
        }

        Button back = findViewById(R.id.manage_back_button);
        Button edit_group_button = findViewById(R.id.manage_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupCoordinateActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 3);
                startActivity(intent);
            }
        });

        edit_group_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupCoordinateActivity.this, GroupCoordinateConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }

}
