package com.globalbit.utils.countriesspinner.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by alex on 06/06/2016.
 */
public class CountriesSpinner extends Spinner {
    private CountriesSpinnerAdapter mCountriesSpinnerAdapter;
    private boolean mShowFlags=true;
    private boolean mShowNames=true;
    private boolean mShowCodes=true;


    public CountriesSpinner(Context context) {
        super(context);
        setup();
    }

    public CountriesSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(attrs,0);
    }

    public CountriesSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttributes(attrs,defStyleAttr);
    }

    private void setAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CountriesSpinner, defStyleAttr, 0);
        try {
            mShowFlags = ta.getBoolean(R.styleable.CountriesSpinner_show_flags, true);
            mShowNames = ta.getBoolean(R.styleable.CountriesSpinner_show_names, true);
            mShowCodes = ta.getBoolean(R.styleable.CountriesSpinner_show_codes, true);
        } finally {
            ta.recycle();
        }
        setup();
    }

    private void setup() {
        CountriesArrayList countries=new CountriesArrayList(getContext());
        mCountriesSpinnerAdapter=new CountriesSpinnerAdapter(getContext(),countries,mShowFlags,mShowNames,mShowCodes);
        int index=mCountriesSpinnerAdapter.setCurrentCountry();
        this.setAdapter(mCountriesSpinnerAdapter);
        if(index!=-1) {
            this.setSelection(index);
        }

    }

    public void setCountryByCode(String code) {
        int index=mCountriesSpinnerAdapter.setCountryByCode(code);
        if(index!=-1) {
            this.setSelection(index);
        }
    }


}
