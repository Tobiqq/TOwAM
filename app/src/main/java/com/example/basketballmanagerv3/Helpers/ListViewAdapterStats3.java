package com.example.basketballmanagerv3.Helpers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.basketballmanagerv3.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.THIRD_COLUMN;


public class ListViewAdapterStats3 extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list;
    Activity activity;

    public ListViewAdapterStats3(FragmentActivity activity, ArrayList<HashMap<String,String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    public ListViewAdapterStats3(Activity activity, ArrayList<HashMap<String,String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }


    public void remove(int position){
        list.remove(list.get(position));;
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
        TextView txtThird;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.team_list_item5, null);
            holder = new ViewHolder();

            holder.txtFirst = convertView.findViewById(R.id.name);
            holder.txtSecond = convertView.findViewById(R.id.action);
            holder.txtThird = convertView.findViewById(R.id.ilosc);

            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
            HashMap<String, String> map = list.get(position);

            holder.txtFirst.setText(map.get(FIRST_COLUMN));
            holder.txtSecond.setText(map.get(SECOND_COLUMN));
            holder.txtThird.setText(map.get(THIRD_COLUMN));

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


