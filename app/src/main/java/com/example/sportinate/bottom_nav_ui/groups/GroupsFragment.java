package com.example.sportinate.bottom_nav_ui.groups;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentGroupsBinding;
import com.example.sportinate.group_search_and_select.Group1LeaveActivity;

public class GroupsFragment extends Fragment {

    private GroupsViewModel groupsViewModel;
    private FragmentGroupsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupsViewModel =
                new ViewModelProvider(this).get(GroupsViewModel.class);

        binding = FragmentGroupsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout grp1_layout = (LinearLayout) root.findViewById(R.id.group1_groups);

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
        View group1 = root.findViewById(R.id.group1_groups);
        //TODO Fix visibility (Sruthi)
        Bundle bundle = getArguments();

        if (bundle != null) {
            int num = bundle.getInt("fragmentNumber");
            if (num == 1) {
                group1.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}