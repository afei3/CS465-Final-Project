package com.example.sportinate.profile_creation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_search_and_select.BrowseActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditSportActivity extends AppCompatActivity {
    public GroupInfo group;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sports);
        group = (GroupInfo) getIntent().getSerializableExtra("group");



        //TODO: send group information to group list
        FileInputStream fis=null;
        byte[] buffer=null;
        try {
            fis=openFileInput("user_3");
            buffer=new  byte[fis.available()];
            fis.read(buffer);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        if (buffer != null) {
            TextView text1TV = (TextView) findViewById(R.id.sport_name1);
            //TextView text2TV=(TextView)findViewById(R.id.date);
            TextView text3TV = (TextView) findViewById(R.id.sport_level1);
            //TextView text4TV=(TextView)findViewById(R.id.text1);
            //TextView text5TV=(TextView)findViewById(R.id.text2);
            TextView text6TV = (TextView) findViewById(R.id.sport_commitment1);
            TextView text7TV = (TextView) findViewById(R.id.sport_location1);
            ImageView image1TV = (ImageView) findViewById(R.id.sport_image1);

            String data = new String(buffer);
            String text1 = data.split(" ")[0];
            //String text2=data.split(" ")[1];
            String text3 = data.split(" ")[2];
            //String text4=data.split(" ")[3];
            //String text5=data.split(" ")[4];
            String text6 = data.split(" ")[5];
            String text7 = data.split(" ")[6];


            text1TV.setText(text1 + ":");

            text3TV.setText("Level: " + text3);

            text6TV.setText("Commitment: " + text6);
            text7TV.setText("Location: " + text7);


            View sport1 = findViewById(R.id.sport1);
            sport1.setVisibility(View.VISIBLE);
        }



        Button add_sport_button = findViewById(R.id.add_new_sport);
        add_sport_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.sportinate.profile_creation.EditSportActivity.this, profile_creation.class);
                intent.putExtra("fragmentNumber", 2);
                startActivity(intent);
            }
        });

        Button edit_sport_button1 = findViewById(R.id.Edit1);
        edit_sport_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.sportinate.profile_creation.EditSportActivity.this, profile_creation.class);
                intent.putExtra("fragmentNumber", 2);

                startActivity(intent);
            }
        });


    }
}