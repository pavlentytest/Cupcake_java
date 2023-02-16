package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding fragmentStartBinding;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentStartBinding = FragmentStartBinding.inflate(inflater, container, false);
        return fragmentStartBinding.getRoot();
    }

    public void orderCupcake(int quantity) {
        Toast.makeText(getActivity(), "Ordered "+quantity+" cupcake(s)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentStartBinding.orderOneCupcake.setOnClickListener(view1 -> orderCupcake(1));
        fragmentStartBinding.orderSixCupcakes.setOnClickListener(view6 -> orderCupcake(6));
        fragmentStartBinding.orderTwelveCupcakes.setOnClickListener(view12 -> orderCupcake(12));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentStartBinding = null;
    }
}