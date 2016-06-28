package com.globalbit.utils.countriesspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.globalbit.utils.countriesspinner.library.CountriesArrayList;
import com.globalbit.utils.countriesspinner.library.CountriesSpinner;
import com.globalbit.utils.countriesspinner.library.CountriesSpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CountriesSpinner myspinner=(CountriesSpinner)findViewById(R.id.spinner);
    }
}
