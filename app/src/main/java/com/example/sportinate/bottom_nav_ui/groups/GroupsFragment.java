package com.example.sportinate.bottom_nav_ui.groups;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentGroupsBinding;
import com.example.sportinate.group_search_and_select.Group1LeaveActivity;

public class GroupsFragment extends Fragment {

    private GroupsViewModel groupsViewModel;
    private FragmentGroupsBinding binding;
    //private LinearLayout root_layout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //TODO: Dynamically create group cards
        //root_layout = (LinearLayout)  inflater.inflate(R.layout.fragment_groups, container, false);


        /*for (int i = 0; i < GroupInfo.joined_groups.size(); i++) {
            LinearLayout imageView = (LinearLayout) getView().findViewById(R.id.group1_groups);
            LinearLayout a = new LinearLayout(root_layout.getContext());
            imageView.addView(a);
            System.out.println(i);

        }*/
        groupsViewModel =
                new ViewModelProvider(this).get(GroupsViewModel.class);

        binding = FragmentGroupsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        LinearLayout grp1_layout = (LinearLayout) root.findViewById(R.id.group1);

        grp1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Group1LeaveActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        View root = binding.getRoot();
        View group1 = root.findViewById(R.id.group1);
        View group2 = root.findViewById(R.id.group4);

        View none_coord = root.findViewById(R.id.none_coordinating);
        View none_join = root.findViewById(R.id.none_joined);

        if (GroupInfo.group_test_bool) {
            group2.setVisibility(View.VISIBLE);
            none_coord.setVisibility(View.GONE);
        } else {
            group2.setVisibility(View.GONE);
            none_coord.setVisibility(View.VISIBLE);
        }
        if (GroupInfo.test_bool) {
            group1.setVisibility(View.VISIBLE);
            none_join.setVisibility(View.GONE);
        } else {
            group1.setVisibility(View.GONE);
            none_join.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}