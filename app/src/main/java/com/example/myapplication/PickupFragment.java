package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentPickupBinding;
import com.example.myapplication.databinding.FragmentStartBinding;
import com.example.myapplication.model.OrderViewModel;

import java.util.Objects;

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
        Navigation.findNavController(requireView()).navigate(R.id.action_pickupFragment_to_summaryFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentPickupBinding = FragmentPickupBinding.inflate(inflater, container, false);
        OrderViewModel orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentPickupBinding.setViewModel(orderViewModel);
        return fragmentPickupBinding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        fragmentPickupBinding = null;
    }
}