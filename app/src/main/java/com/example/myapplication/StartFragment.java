package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentStartBinding;
import com.example.myapplication.model.OrderViewModel;

import java.util.Objects;

public class StartFragment extends Fragment {

    private FragmentStartBinding fragmentStartBinding;
    private OrderViewModel orderViewModel;

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
        orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        return fragmentStartBinding.getRoot();
    }

    public void orderCupcake(int quantity) {
        orderViewModel.set_quantity(quantity);
        if(orderViewModel.hasNoFlavourSet()) {
            orderViewModel.set_flavour(getResources().getString(R.string.chocolate));
        }
        Navigation.findNavController(requireView()).navigate(R.id.action_startFragment_to_flavorFragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentStartBinding.orderOneCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderCupcake(1);
            }
        });
        fragmentStartBinding.orderSixCupcakes.setOnClickListener(view6 -> orderCupcake(6));
        fragmentStartBinding.orderTwelveCupcakes.setOnClickListener(view12 -> orderCupcake(12));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentStartBinding = null;
    }
}