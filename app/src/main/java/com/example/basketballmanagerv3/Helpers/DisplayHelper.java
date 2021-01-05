package com.example.basketballmanagerv3.Helpers;

import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.THIRD_COLUMN;

public class DisplayHelper {

    Activity activity;



    ListView text;
    private ArrayList<HashMap<String, String>> list2;
    List<Player> listfirst;
    int j;

    public void show(Activity activity, ListView text, ArrayList<HashMap<String, String>> list2, List<Player> listfirst, int j){

        this.text = text;
        this.list2 = list2;
        this.listfirst = listfirst;
        this.j = j;
        this.activity = activity;

        HashMap<String, String> temp = new HashMap<>();
        temp.put(FIRST_COLUMN, listfirst.get(j).getname());
        temp.put(THIRD_COLUMN, " - "+String.valueOf(listfirst.get(j).getreboff())+" - ");
        temp.put(SECOND_COLUMN, "Offensive Rebound");
        list2.add(temp);
        final ListViewAdapterStats3 adapter = new ListViewAdapterStats3(activity, list2);
        text.setAdapter(adapter);
    }

    public void delete(Activity activity, ListView text, ArrayList<HashMap<String, String>> list2, List<Player> listfirst, int j){

        this.text = text;
        this.list2 = list2;
        this.listfirst = listfirst;
        this.j = j;
        this.activity = activity;

        final ListViewAdapterStats3 adapter = new ListViewAdapterStats3(activity, list2);
        listfirst.get(j).remreboundoff();
        int licznik = adapter.getCount();
        adapter.remove(licznik-1);
        text.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}