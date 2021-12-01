package com.example.sportinate.group_coordination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.MainActivity;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;

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
        setContentView(R.layout.activity_coordinate_group);
    }
}
