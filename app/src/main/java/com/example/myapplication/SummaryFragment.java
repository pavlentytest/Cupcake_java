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
import com.example.myapplication.databinding.FragmentSummaryBinding;

public class SummaryFragment extends Fragment {

    private FragmentSummaryBinding fragmentSummaryBinding;

    public SummaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSummaryBinding.sendButton.setOnClickListener(view1 -> sendOrder());
    }

    public void sendOrder() {
        Toast.makeText(getActivity(), "Send Order", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSummaryBinding = FragmentSummaryBinding.inflate(inflater, container, false);
        return fragmentSummaryBinding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        fragmentSummaryBinding = null;
    }
}