package com.example.sportinate.bottom_nav_ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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

//        LinearLayout background = (LinearLayout) root.findViewById(R.id.background_layout);
////        close
//        grp1_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                hideKeyboard(getActivity());
//            }
//        });

        SearchView searchView = root.findViewById(R.id.simple_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            View group1_search = root.findViewById(R.id.group1);
            View group2_search = root.findViewById(R.id.group2);
            View group3_search = root.findViewById(R.id.group3);
            View group4_search = root.findViewById(R.id.group4);
            View group5_search = root.findViewById(R.id.group5);
            View no_results_text = root.findViewById(R.id.no_results);
            View create_new_group_btn = root.findViewById(R.id.create_new_group_btn);

            @Override
            public boolean onQueryTextSubmit(String query) {
                hideKeyboard(getActivity());
                query = query.toLowerCase();
                if (query.equals("basketball")) {
                    group1_search.setVisibility(View.VISIBLE);
                    group2_search.setVisibility(View.VISIBLE);
                    group3_search.setVisibility(View.GONE);
                    group4_search.setVisibility(View.GONE);
                    group5_search.setVisibility(View.GONE);
                    no_results_text.setVisibility(View.GONE);
                    create_new_group_btn.setVisibility(View.GONE);
                }
                else if (query.equals("flingers")) {
                    group1_search.setVisibility(View.GONE);
                    group2_search.setVisibility(View.GONE);
                    group3_search.setVisibility(View.GONE);
                    group4_search.setVisibility(View.GONE);
                    group5_search.setVisibility(View.VISIBLE);
                    no_results_text.setVisibility(View.GONE);
                    create_new_group_btn.setVisibility(View.GONE);
                }
                else {
                    group1_search.setVisibility(View.GONE);
                    group2_search.setVisibility(View.GONE);
                    group3_search.setVisibility(View.GONE);
                    group4_search.setVisibility(View.GONE);
                    group5_search.setVisibility(View.GONE);
                    no_results_text.setVisibility(View.VISIBLE);
                    create_new_group_btn.setVisibility(View.GONE);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                create_new_group_btn.setVisibility(View.VISIBLE);
                newText = newText.toLowerCase();
                if (!newText.equals("basketball") && !newText.equals("flingers")) {
                    group1_search.setVisibility(View.VISIBLE);
                    group2_search.setVisibility(View.VISIBLE);
                    group3_search.setVisibility(View.VISIBLE);
                    group5_search.setVisibility(View.VISIBLE);
                    no_results_text.setVisibility(View.GONE);

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

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}