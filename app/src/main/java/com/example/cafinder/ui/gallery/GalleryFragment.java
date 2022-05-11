package com.example.cafinder.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cafinder.ClientDashboard;
import com.example.cafinder.R;
import com.example.cafinder.databinding.FragmentGalleryBinding;

import org.w3c.dom.Text;

public class GalleryFragment extends Fragment {

    private String myString;
    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    Button viewBookingButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;






    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }











}