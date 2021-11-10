package com.example.sportinate.bottom_nav_ui.home;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.MainActivity;
import com.example.sportinate.R;
import com.example.sportinate.bottom_nav_ui.groups.GroupsFragment;
import com.example.sportinate.databinding.FragmentHomeBinding;
import com.example.sportinate.group_search_and_select.BrowseActivity;
import com.example.sportinate.group_search_and_select.GroupInfoActivity;
import com.example.sportinate.group_creation.GroupCreationActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button createGroupButton= (Button) root.findViewById(R.id.create_new_group_btn);
        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GroupCreationActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout grp1_layout = (LinearLayout) root.findViewById(R.id.group1);

        grp1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GroupInfoActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}