package com.example.basketballmanagerv3.Helpers;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.basketballmanagerv3.ChoseFirstFiveActivity;
import com.example.basketballmanagerv3.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;


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
        Button trackGame;
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
            holder.trackGame = (Button) convertView.findViewById(R.id.trackGame);
            holder.trackGame.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(activity, ChoseFirstFiveActivity.class);
                    in.putExtra("team1", list.get(position).get(FIRST_COLUMN));
                    in.putExtra("team2", list.get(position).get(SECOND_COLUMN));
                    in.putExtra("position", position);
                    activity.startActivity(in);
                }
            });

            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
            HashMap<String, String> map = list.get(position);

            holder.txtFirst.setText(map.get(FIRST_COLUMN));
            holder.txtSecond.setText(map.get(SECOND_COLUMN));

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

