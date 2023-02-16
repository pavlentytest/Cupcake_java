package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentPickupBinding;
import com.example.myapplication.databinding.FragmentStartBinding;

public class PickupFragment extends Fragment {

    private FragmentPickupBinding fragmentPickupBinding;

    public PickupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentPickupBinding.nextButton.setOnClickListener(view1 -> goToNextScreen());
    }

    public void goToNextScreen() {
        Toast.makeText(getActivity(), "Next", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentPickupBinding = FragmentPickupBinding.inflate(inflater, container, false);
        return fragmentPickupBinding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        fragmentPickupBinding = null;
    }
}