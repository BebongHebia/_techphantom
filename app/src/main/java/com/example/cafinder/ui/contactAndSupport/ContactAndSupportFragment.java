package com.example.cafinder.ui.contactAndSupport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cafinder.R;
import com.example.cafinder.databinding.FragmentContactAndSupportBinding;
import com.example.cafinder.databinding.FragmentGalleryBinding;
import com.example.cafinder.ui.gallery.GalleryViewModel;

public class ContactAndSupportFragment extends Fragment {

    private ContactAndSupportViewModel contactAndSupportViewModel;
    private FragmentContactAndSupportBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactAndSupportViewModel =
                new ViewModelProvider(this).get(ContactAndSupportViewModel.class);

        binding = FragmentContactAndSupportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textContactAndSupport;
        contactAndSupportViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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