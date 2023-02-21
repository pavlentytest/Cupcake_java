package com.example.myapplication.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {

    public static final double PRICE_PER_CUPCAKE = 100.00;

    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> quantity  = _quantity; // для View

    private MutableLiveData<String> _flavour = new MutableLiveData<>("");// для Model
    public LiveData<String> flavour  = _flavour; // для View

    private MutableLiveData<Double> _price = new MutableLiveData<Double>(0.0);// для Model
   // public LiveData<Double> price  = _price; // для View

    public void set_quantity(int _quantity) {
        Log.d("RRR",_quantity+"");
        this._quantity.setValue(_quantity);
        update_price();
    }

    public LiveData<Double> getPrice() {
        return _price;
    }

    public void set_flavour(String _flavour) {
        this._flavour.setValue(_flavour);
    }

    public void update_price() {
        double calc = this._quantity.getValue() * PRICE_PER_CUPCAKE;
        this._price.setValue(calc);
        Log.d("ViewModel",this._price.getValue()+"");
    }

}
