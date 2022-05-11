package com.example.cafinder.ui.termsAndConditions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TermsAndConditionsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TermsAndConditionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}