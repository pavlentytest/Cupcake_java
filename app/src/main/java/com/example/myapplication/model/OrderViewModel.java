package com.example.myapplication.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class OrderViewModel extends ViewModel {

    public static final double PRICE_PER_CUPCAKE = 100.00;
    public static final double FAST = 1000.00;

    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> quantity  = _quantity; // для View

    private MutableLiveData<String> _flavour = new MutableLiveData<>("");// для Model
    public LiveData<String> flavour  = _flavour; // для View

    private MutableLiveData<String> _date = new MutableLiveData<>("");// для Model
    public LiveData<String> date  = _date; // для View

    private MutableLiveData<Double> _price = new MutableLiveData<Double>(0.0);// для Model
    public LiveData<Double> price  = _price; // для View



    public void set_quantity(int _quantity) {
        Log.d("RRR",_quantity+"");
        this._quantity.setValue(_quantity);
        update_price();
    }

   // public LiveData<Double> getPrice() {
   //     return _price;
   // }

    public void set_flavour(String _flavour) {
        this._flavour.setValue(_flavour);
    }

    public void set_date(String d) {
        this._date.setValue(d);
        update_price();
    }

    public void update_price() {
        double calc = this._quantity.getValue() * PRICE_PER_CUPCAKE;
        Log.d("RRR",dateOptions.get(0) +"; "+_date.getValue());
        if(dateOptions.get(0).equals(_date.getValue()))  {
            calc += FAST;
        }
        this._price.setValue(calc);
        Log.d("ViewModel",this._price.getValue()+"");
    }

    public boolean hasNoFlavourSet() {
        return _flavour.getValue() == null || _flavour.getValue().isEmpty();
    }

    public List<String> dateOptions = getPickupOptions();

    public List<String> getPickupOptions() {
        ArrayList<String> options = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM d", Locale.getDefault());
        Calendar calendar = new GregorianCalendar();
        for(int i=0;i<4;i++) {
            options.add(formatter.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        Log.d("RRR","options[0]="+options.get(0));
        return options;
    }
}
