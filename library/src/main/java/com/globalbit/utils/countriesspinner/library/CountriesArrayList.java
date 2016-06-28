package com.globalbit.utils.countriesspinner.library;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by alex on 01/06/2016.
 */
public class CountriesArrayList extends ArrayList<CountryItem> {

    public CountriesArrayList(Context context)
    {
        String[] countriesArray=context.getResources().getStringArray(R.array.CountryCodes);
        for(String s : countriesArray) {
            String[] countryStr=s.split(",");
            if(countryStr!=null&&countryStr.length==2)
            {
                CountryItem item=new CountryItem();
                item.setCountryCode("+"+countryStr[0]);
                item.setCountryShortName(countryStr[1].toLowerCase());
                this.add(item);
            }
        }
    }

    public CountriesArrayList(String[] countriesArray)
    {
        for(String s : countriesArray) {
            String[] countryStr=s.split(",");
            if(countryStr!=null&&countryStr.length==2)
            {
                CountryItem item=new CountryItem();
                item.setCountryCode("+"+countryStr[0]);
                item.setCountryShortName(countryStr[1].toLowerCase());
                this.add(item);
            }
        }
    }
}
