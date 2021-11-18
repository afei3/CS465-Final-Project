package com.example.sportinate.bottom_nav_ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.EditText;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentProfileBinding;
import com.example.sportinate.group_search_and_select.Group1LeaveActivity;
import com.example.sportinate.profile_creation.UserDescriptionActivity;
import com.example.sportinate.profile_creation.UserInfo;
import com.example.sportinate.profile_creation.profile_creation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    public static String user_name1;
    public static String user_descrip1;


    public static String sport_name1;
    public static String sport_level1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Bundle bundle = getArguments();
        if (bundle != null ) {
            TextView user_name = root.findViewById(R.id.name_text);
            String str = bundle.getString("name");
            user_name.setText(str);

            TextView descrip_name = root.findViewById(R.id.description_text);
            String str2 = bundle.getString("descrip");
            descrip_name.setText(str2);
        }

        TextView user_name = root.findViewById(R.id.name_text);
        user_name.setText(user_name1);
        TextView descrip_name = root.findViewById(R.id.description_text);
        descrip_name.setText(user_descrip1);

        TextView sport_1 = root.findViewById(R.id.sport_list);
        if(sport_name1 != null) {
            String input = sport_name1 + ": " + sport_level1;
            sport_1.setText(input);
            sport_1.setVisibility(View.VISIBLE);
        }
        //sport_1.setText("input");
//        final TextView textView = binding.textProfile;
//        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        LinearLayout description = (LinearLayout) root.findViewById(R.id.user_description);
//
//        description.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Group1LeaveActivity.class);
//                startActivity(intent);
//            }
//        });

//        Button user_edit_button = root.findViewById(R.id.user_edit);
//        user_edit_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(com.example.sportinate.profile_creation.profile_creation_comfirm.this, profile_creation.class);
//                startActivity(intent);
//            }
//        });

//        FileInputStream fis=null;
//        byte[] buffer=null;
//        try {
//            fis=openFileInput("user_description");
//            buffer=new  byte[fis.available()];
//            fis.read(buffer);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if(fis!=null){
//                try {
//                    fis.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        TextView user_name=(TextView)root.findViewById(R.id.name_text);
//        TextView descrip_name=(TextView)root.findViewById(R.id.description_text);
//
//
//
//        String data=new String(buffer);
//        String name=data.split(" ")[0];
//        String desc=data.split(" ")[1];
//
//
//
//        user_name.setText(name);
//        descrip_name.setText(desc);

        Button sprot_edit = root.findViewById(R.id.sprot_edit);
        sprot_edit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.sportinate.profile_creation.EditSportActivity.class);
            startActivity(intent);
        });

        Button user_edit = root.findViewById(R.id.user_edit);
        user_edit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.sportinate.profile_creation.UserDescriptionActivity.class);
            startActivity(intent);
        });

        return root;
    }


//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//        View root = binding.getRoot();
//        View name = root.findViewById(R.id.name_text);
//        View descrip = root.findViewById(R.id.description_text);

//        Bundle bundle = getArguments();
//
//        name.setVisibility(View.VISIBLE);
//
//        descrip.setVisibility(View.VISIBLE);



//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


