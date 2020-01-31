package com.maxmanthey.aufgabe4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SachbearbeiterWahlAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] alleSbNamen;

    public SachbearbeiterWahlAdapter(Context c, String[] namen) {
        alleSbNamen = namen;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return alleSbNamen.length;
    }

    @Override
    public Object getItem(int position) {
        return alleSbNamen[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.activity_sachbearbeiter_wahl_detail, null);
        TextView sbUsernameTextView = v.findViewById(R.id.sbUsernameTextView);

        String name = alleSbNamen[position];

        sbUsernameTextView.setText(name);

        return v;
    }
}
