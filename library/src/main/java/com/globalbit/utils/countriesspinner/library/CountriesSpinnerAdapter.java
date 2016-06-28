package com.globalbit.utils.countriesspinner.library;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by alex on 01/06/2016.
 */
public class CountriesSpinnerAdapter extends ArrayAdapter<CountryItem> {
    private ArrayList<CountryItem> mCountries;
    private Context mContext;
    private boolean mShowFlag;
    private boolean mShowCountryName;
    private boolean mShowCountryCode;


    public CountriesSpinnerAdapter(Context context, ArrayList<CountryItem> objects, boolean showFlag, boolean showCountryName, boolean showCountryCode) {
        super(context, -1, objects);
        mContext=context;
        mCountries=objects;
        mShowFlag=showFlag;
        mShowCountryName=showCountryName;
        mShowCountryCode=showCountryCode;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.spinner_item,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.mTextViewCountryName=(TextView)convertView.findViewById(R.id.txtViewCountryName);
            holder.mImageViewCountryFlag=(ImageView)convertView.findViewById(R.id.imgViewCountryFlag);
            holder.mTextViewCountryCode=(TextView)convertView.findViewById(R.id.txtViewCountryCode);
            convertView.setTag(holder);
        }

        CountryItem item=mCountries.get(position);
        ViewHolder holder=(ViewHolder)convertView.getTag();
        if(mShowFlag) {
            holder.mImageViewCountryFlag.setVisibility(View.VISIBLE);
            int resourceId=mContext.getResources().getIdentifier("drawable/" + item.getCountryShortName(), null, mContext.getPackageName());
            if(resourceId!=0)
                Picasso.with(mContext).load(resourceId).into(holder.mImageViewCountryFlag);
            else
                Picasso.with(mContext).load(-1).into(holder.mImageViewCountryFlag);
        }
        else {
            holder.mImageViewCountryFlag.setVisibility(View.GONE);
        }

        if(mShowCountryName) {
            holder.mTextViewCountryName.setVisibility(View.VISIBLE);
            holder.mTextViewCountryName.setText(GetCountryZipCode(item.getCountryShortName()));
        }
        else {
            holder.mTextViewCountryName.setVisibility(View.GONE);
        }

        if(mShowCountryCode) {
            holder.mTextViewCountryCode.setVisibility(View.VISIBLE);
            holder.mTextViewCountryCode.setText(item.getCountryCode());
        }
        else {
            holder.mTextViewCountryCode.setVisibility(View.GONE);
        }

        return  convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.spinner_item,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.mTextViewCountryName=(TextView)convertView.findViewById(R.id.txtViewCountryName);
            holder.mImageViewCountryFlag=(ImageView)convertView.findViewById(R.id.imgViewCountryFlag);
            holder.mTextViewCountryCode=(TextView)convertView.findViewById(R.id.txtViewCountryCode);
            convertView.setTag(holder);
        }

        CountryItem item=mCountries.get(position);
        ViewHolder holder=(ViewHolder)convertView.getTag();
        if(mShowFlag) {
            holder.mImageViewCountryFlag.setVisibility(View.VISIBLE);
            int resourceId=mContext.getResources().getIdentifier("drawable/" + item.getCountryShortName(), null, mContext.getPackageName());
            if(resourceId!=0)
                Picasso.with(mContext).load(resourceId).into(holder.mImageViewCountryFlag);
            else
                Picasso.with(mContext).load(-1).into(holder.mImageViewCountryFlag);
        }
        else {
            holder.mImageViewCountryFlag.setVisibility(View.GONE);
        }

        if(mShowCountryName) {
            holder.mTextViewCountryName.setVisibility(View.VISIBLE);
            holder.mTextViewCountryName.setText(GetCountryZipCode(item.getCountryShortName()));
        }
        else {
            holder.mTextViewCountryName.setVisibility(View.GONE);
        }

        if(mShowCountryCode) {
            holder.mTextViewCountryCode.setVisibility(View.VISIBLE);
            holder.mTextViewCountryCode.setText(item.getCountryCode());
        }
        else {
            holder.mTextViewCountryCode.setVisibility(View.GONE);
        }

        return  convertView;
    }

    /*public View getCustomView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.spinner_item,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.mTextViewCountryName=(TextView)convertView.findViewById(R.id.txtViewCountryName);
            holder.mImageViewCountryFlag=(ImageView)convertView.findViewById(R.id.imgViewCountryFlag);
            holder.mTextViewCountryCode=(TextView)convertView.findViewById(R.id.txtViewCountryCode);
            convertView.setTag(holder);
        }

        CountryItem item=mCountries.get(position);
        ViewHolder holder=(ViewHolder)convertView.getTag();
        if(mShowFlag) {
            holder.mImageViewCountryFlag.setVisibility(View.VISIBLE);
            int resourceId=mContext.getResources().getIdentifier("drawable/" + item.getCountryShortName(), null, mContext.getPackageName());
            if(resourceId!=0)
                Picasso.with(mContext).load(resourceId).into(holder.mImageViewCountryFlag);
            else
                Picasso.with(mContext).load(-1).into(holder.mImageViewCountryFlag);
        }
        else {
            holder.mImageViewCountryFlag.setVisibility(View.GONE);
        }

        if(mShowCountryName) {
            holder.mTextViewCountryName.setVisibility(View.VISIBLE);
            holder.mTextViewCountryName.setText(GetCountryZipCode(item.getCountryShortName()));
        }
        else {
            holder.mTextViewCountryName.setVisibility(View.GONE);
        }

        if(mShowCountryCode) {
            holder.mTextViewCountryCode.setVisibility(View.VISIBLE);
            holder.mTextViewCountryCode.setText(item.getCountryCode());
        }
        else {
            holder.mTextViewCountryCode.setVisibility(View.GONE);
        }

        return  convertView;
    }*/

    private String GetCountryZipCode(String ssid){
        Locale loc = new Locale("", ssid);
        return loc.getDisplayCountry().trim();
    }

    public int setCurrentCountry()
    {
        int index=-1;
        TelephonyManager tm = (TelephonyManager)getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String countryCode = tm.getSimCountryIso();
        for(int i=0; i<mCountries.size(); i++ ) {
            CountryItem country=mCountries.get(i);
            if(country.getCountryShortName().toLowerCase().equals(countryCode)) {
                index=i;
                break;
            }
        }
        return  index;
    }

    public int setCountryByCode(String code) {
        int index=-1;
        for(int i=0; i<mCountries.size(); i++ ) {
            CountryItem country=mCountries.get(i);
            if(country.getCountryCode().equals("+"+code)) {
                index=i;
                break;
            }
        }
        return  index;
    }

    static  class ViewHolder {
        ImageView mImageViewCountryFlag;
        TextView mTextViewCountryName;
        TextView mTextViewCountryCode;

    }
}
