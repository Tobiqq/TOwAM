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

import static com.example.basketballmanagerv3.Helpers.Constants.EIGHTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.ELEVENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FIFTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FOURTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.NINETH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SEVENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SIXTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.TENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.THIRD_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.TWELWETH_COLUMN;


public class ListViewAdapterStats extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list;
    Activity activity;

    public ListViewAdapterStats(FragmentActivity activity, ArrayList<HashMap<String,String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    public ListViewAdapterStats(Activity activity, ArrayList<HashMap<String,String>> list){
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
        TextView txtThird;
        TextView txtFourth;
        TextView txtFivth;
        TextView txtSixth;
        TextView txtSeventh;
        TextView txtEigth;
        TextView txtNineth;
        TextView txtTenth;
        TextView txtElev;
        TextView txtTwel;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.team_list_item3, null);
            holder = new ViewHolder();

            holder.txtFirst = convertView.findViewById(R.id.vs);
            holder.txtSecond = convertView.findViewById(R.id.twopts);
            holder.txtThird = convertView.findViewById(R.id.threepts);
            holder.txtFourth = convertView.findViewById(R.id.onepts);
            holder.txtFivth = convertView.findViewById(R.id.rebo);
            holder.txtSixth = convertView.findViewById(R.id.reba);
            holder.txtSeventh = convertView.findViewById(R.id.steal);
            holder.txtEigth = convertView.findViewById(R.id.block);
            holder.txtNineth = convertView.findViewById(R.id.turn);
            holder.txtTenth = convertView.findViewById(R.id.fouls);
            holder.txtElev = convertView.findViewById(R.id.pkt);;
            holder.txtTwel = convertView.findViewById(R.id.eval);;

            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
            HashMap<String, String> map = list.get(position);

            holder.txtFirst.setText(map.get(FIRST_COLUMN));
            holder.txtSecond.setText(map.get(SECOND_COLUMN));
            holder.txtThird.setText(map.get(THIRD_COLUMN));
            holder.txtFourth.setText(map.get(FOURTH_COLUMN));
            holder.txtFivth.setText(map.get(FIFTH_COLUMN));
            holder.txtSixth.setText(map.get(SIXTH_COLUMN));
            holder.txtSeventh.setText(map.get(SEVENTH_COLUMN));
            holder.txtEigth.setText(map.get(EIGHTH_COLUMN));
            holder.txtNineth.setText(map.get(NINETH_COLUMN));
            holder.txtTenth.setText(map.get(TENTH_COLUMN));
            holder.txtElev.setText(map.get(ELEVENTH_COLUMN));
            holder.txtTwel.setText(map.get(TWELWETH_COLUMN));

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

