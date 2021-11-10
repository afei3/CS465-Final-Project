package com.example.sportinate.group_search_and_select;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sportinate.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Group1LeaveActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group1_leave);

        Button leave_button = findViewById(R.id.leave_button);
        leave_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //TODO pulls up alert
        //TODO group disappears from My Groups page
        switch (v.getId()){
            case R.id.leave_button:
                alertDialog();
                break;
        }
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to leave this group?");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //TODO new activity comes up saying you have left the group
                        Intent intent = new Intent (Group1LeaveActivity.this, Group1LeaveFeedbackActivity.class);
                        startActivity(intent);
                    }
                });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO alert goes away
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}