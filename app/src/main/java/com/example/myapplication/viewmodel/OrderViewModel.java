package com.example.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {

    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);
    LiveData<Integer> quantity  = _quantity;
}
