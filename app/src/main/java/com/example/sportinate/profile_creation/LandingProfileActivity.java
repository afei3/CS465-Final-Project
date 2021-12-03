package com.example.sportinate.profile_creation;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.ProfileInfo;
import com.example.sportinate.R;
import com.example.sportinate.TimeSlot;
import com.example.sportinate.bottom_nav_ui.profile.ProfileFragment;
import com.example.sportinate.group_creation.GroupCreationActivity;
import com.example.sportinate.group_creation.GroupCreationReviewActivity;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.profile_creation.UserInfo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class LandingProfileActivity extends AppCompatActivity{

    private Button btnPhone;
    private ImageView imageView;

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0;

    private TextView tv;
    private Bitmap bm_photo = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_profile);
        getSupportActionBar().setTitle("Make Profile");



        Button next_button = findViewById(R.id.next_button1);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user_name = (EditText) findViewById(R.id.user_name);
                String message1 = user_name.getText().toString();
                EditText user_email = (EditText) findViewById(R.id.user_email);
                String message3 = user_email.getText().toString();
                EditText user_descrip = (EditText) findViewById(R.id.message);
                String message2 = user_descrip.getText().toString();

                //check all required fields
                if(message1.equals("") || message3.equals("") ){
                    Toast.makeText(LandingProfileActivity.this, "Please fill out all required fields", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = new Intent(com.example.sportinate.profile_creation.LandingProfileActivity.this, profile_creation.class);
                    UserInfo user = new UserInfo();

                    user.setName(message1);

                    user.setDescrip(message2);

                    intent.putExtra("key", user);

                    BrowseActivity.user_name = message1;
                    BrowseActivity.user_descrip = message2;
                    BrowseActivity.user_email = message3;
                    BrowseActivity.user_photo = bm_photo;

                    startActivity(intent);
                }
            }
        });

        Button back_button = findViewById(R.id.back_button1);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user_name = (EditText) findViewById(R.id.user_name);
                String message1 = user_name.getText().toString();
                EditText user_email = (EditText) findViewById(R.id.user_email);
                String message3 = user_email.getText().toString();
                EditText user_descrip = (EditText) findViewById(R.id.message);
                String message2 = user_descrip.getText().toString();

                //check all required fields
                if(message1.equals("") || message3.equals("") ){
                    Toast.makeText(LandingProfileActivity.this, "Please fill out all required fields", Toast.LENGTH_SHORT).show();

                }else {
                    finish();

                    Intent intent = new Intent(com.example.sportinate.profile_creation.LandingProfileActivity.this, BrowseActivity.class);
                    intent.putExtra("fragmentNumber", 1);



                    UserInfo user = new UserInfo();

                    user.setName(message1);

                    user.setDescrip(message2);

                    intent.putExtra("key", user);

                    BrowseActivity.user_name = message1;
                    BrowseActivity.user_descrip = message2;
                    BrowseActivity.user_email = message3;
                    BrowseActivity.user_photo = bm_photo;
                    startActivity(intent);
                }
            }
        });




        btnPhone = (Button) findViewById(R.id.choose_photo);
        imageView = (ImageView) findViewById(R.id.imageView);
        //tv = (TextView) findViewById(R.id.img_path);
        btnPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                setImage();

            }

        });

    }

    private void setImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, IMAGE_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        ContentResolver resolver = getContentResolver();

        if (requestCode == IMAGE_CODE) {

            try {

                Uri originalUri = data.getData();

                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                bm_photo = bm;

                imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 200, 200));

                String[] proj = { MediaStore.Images.Media.DATA };


                Cursor cursor = managedQuery(originalUri, proj, null, null, null);


                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                btnPhone.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                //String path = cursor.getString(column_index);
                //tv.setText(path);
            } catch (IOException e) {
                Log.e("TAG-->Error", e.toString());

            }

            finally {
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }



}


