package com.example.basketballmanagerv3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Constants.SECOND_COLUMN;


public class ListViewAdapterButton extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list;
    Activity activity;

    public ListViewAdapterButton(FragmentActivity activity, ArrayList<HashMap<String,String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    public ListViewAdapterButton(Activity activity, ArrayList<HashMap<String,String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtFirst;
        TextView txtSecond;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.team_list_item_button, null);
            holder = new ViewHolder();

            holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);

            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
            HashMap<String, String> map = list.get(position);

            holder.txtFirst.setText(map.get(FIRST_COLUMN));
            holder.txtSecond.setText(map.get(SECOND_COLUMN));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, position + "position clicked", Toast.LENGTH_SHORT).show();
            }
        });

            return convertView;
        }

    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(int arg0)
    {
        return true;
    }
    }

