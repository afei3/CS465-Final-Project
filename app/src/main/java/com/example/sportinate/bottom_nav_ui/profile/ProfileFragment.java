package com.example.sportinate.bottom_nav_ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentProfileBinding;
import com.example.sportinate.group_search_and_select.Group1LeaveActivity;
import com.example.sportinate.profile_creation.profile_creation;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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

        Button sprot_edit = root.findViewById(R.id.sprot_edit);
        sprot_edit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.sportinate.profile_creation.EditSportActivity.class);
            startActivity(intent);
        });





        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}