package com.example.sportinate.profile_creation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.profile_creation.UserInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;





public class UserDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_description);


        Button next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(com.example.sportinate.profile_creation.UserDescriptionActivity.this, BrowseActivity.class);
                EditText user_name = (EditText) findViewById(R.id.name_text);
                String message1 = user_name.getText().toString();
                EditText user_descrip = (EditText) findViewById(R.id.description_text);
                String message2 = user_descrip.getText().toString();


               UserInfo user = new UserInfo();

                user.setName(message1);

                user.setDescrip(message2);

                intent.putExtra("key", user);




                intent.putExtra("fragmentNumber", 1);
                startActivity(intent);
            }

        });

    }

}