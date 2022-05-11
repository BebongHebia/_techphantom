package com.example.cafinder.ui.contactAndSupport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactAndSupportViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactAndSupportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Contact and Support fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}