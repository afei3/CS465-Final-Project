package com.example.sportinate.bottom_nav_ui.groups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        Bundle bundle = getActivity().getIntent().getExtras();
//        LinearLayout group1 = (LinearLayout) getView().findViewById(R.id.basketball_group1_groups);
//        System.out.println("SETSETSET");
//        if(bundle != null && bundle.getBoolean("Group1")) {
////            System.out.println("this is" + bundle.getBoolean("EXTRA"));
//            group1.setVisibility(View.VISIBLE);
//            System.out.println("SETSETSET");
////            getSupportFragmentManager().beginTransaction().replace(R.id.container, new GroupsFragment()).commit();
//        }
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}