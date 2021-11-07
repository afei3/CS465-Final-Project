package com.example.sportinate.bottom_nav_ui.groups;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroupsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroupsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is groups fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}