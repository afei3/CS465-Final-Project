package com.example.sportinate.bottom_nav_ui.groups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportinate.R;
import com.example.sportinate.databinding.FragmentGroupsBinding;

public class GroupsFragment extends Fragment {

    private GroupsViewModel groupsViewModel;
    private FragmentGroupsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupsViewModel =
                new ViewModelProvider(this).get(GroupsViewModel.class);

        binding = FragmentGroupsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        View group1 = getView().findViewById(R.id.basketball_group1_groups);
        //TODO Fix visibility (Sruthi)
        Bundle bundle = this.getArguments();
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