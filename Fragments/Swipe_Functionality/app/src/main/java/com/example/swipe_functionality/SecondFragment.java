package com.example.swipe_functionality;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        TextView tv = (TextView) v.findViewById(R.id.textView1);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment  f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}