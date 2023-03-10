package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentFlavorBinding;
import com.example.myapplication.model.OrderViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlavorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlavorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentFlavorBinding fragmentFlavorBinding;

    public FlavorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlavorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlavorFragment newInstance(String param1, String param2) {
        FlavorFragment fragment = new FlavorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentFlavorBinding.nextButton.setOnClickListener(view1 -> goToNextScreen());
    }

    public void goToNextScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_flavorFragment_to_pickupFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFlavorBinding = FragmentFlavorBinding.inflate(inflater, container, false);
        OrderViewModel orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentFlavorBinding.setViewModel(orderViewModel);
        return fragmentFlavorBinding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        fragmentFlavorBinding = null;
    }
}