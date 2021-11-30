package com.example.sportinate.bottom_nav_ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentHomeBinding;

import com.example.sportinate.group_search_and_select.Group1InfoActivity;

import com.example.sportinate.group_creation.GroupCreationActivity;
import com.example.sportinate.group_search_and_select.Group2InfoActivity;

import java.util.ArrayList;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View group1 = root.findViewById(R.id.group4);

        if (GroupInfo.group_1_create) {
            group1.setVisibility(View.VISIBLE);
        } else {
            group1.setVisibility(View.GONE);
        }

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
                Intent intent = new Intent(getActivity(), Group1InfoActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout grp2_layout = (LinearLayout) root.findViewById(R.id.group2);

        grp2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Group2InfoActivity.class);
                startActivity(intent);
            }
        });

        SearchView searchView = root.findViewById(R.id.simple_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            View group1_search = root.findViewById(R.id.group1);
            View group2_search = root.findViewById(R.id.group2);
            View group3_search = root.findViewById(R.id.group3);
            View group4_search = root.findViewById(R.id.group4);
            View group5_search = root.findViewById(R.id.group5);

            @Override
            public boolean onQueryTextSubmit(String query) {
                query.toLowerCase(Locale.ROOT);
                if (query.equals("basketball")) {
                    group1_search.setVisibility(View.VISIBLE);
                    group2_search.setVisibility(View.VISIBLE);
                    group3_search.setVisibility(View.GONE);
                    group4_search.setVisibility(View.GONE);
                    group5_search.setVisibility(View.GONE);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Do whatever you need when text changes.
                // This will be fired every time you input any character.
                if (!newText.toLowerCase(Locale.ROOT).equals("basketball")) {
                    group1_search.setVisibility(View.VISIBLE);
                    group2_search.setVisibility(View.VISIBLE);
                    group3_search.setVisibility(View.VISIBLE);
                    group5_search.setVisibility(View.VISIBLE);

                    if (GroupInfo.group_1_create) {
                        group4_search.setVisibility(View.VISIBLE);
                    }
                    else {
                        group4_search.setVisibility(View.GONE);
                    }
                }
                return false;
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