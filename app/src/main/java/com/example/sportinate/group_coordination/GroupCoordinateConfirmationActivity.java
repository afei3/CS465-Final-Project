package com.example.sportinate.group_coordination;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_search_and_select.Group1LeaveActivity;
import com.example.sportinate.group_search_and_select.Group1LeaveFeedbackActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GroupCoordinateConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_confirm_kick);
        getSupportActionBar().setTitle("Manage Users");

        Button back = findViewById(R.id.manage_back_button);
        View kick = findViewById(R.id.delete);
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
                alertDialog();
            }
        });
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to remove this user?");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
//                        GroupInfo.group_1_join = false;
                        GroupInfo.deleted_user = true;
                        Intent intent = new Intent(GroupCoordinateConfirmationActivity.this, GroupCoordinateActivity.class);
                        startActivity(intent);
                    }
                });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}
