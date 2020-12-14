package com.example.basketballmanagerv3.Helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basketballmanagerv3.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    List<String> listplayer1;
    List<String> listplayer1number;

    public RecyclerAdapter(List<String> listplayer1) {
        this.listplayer1 = listplayer1;
    }
    public RecyclerAdapter(List<String> listplayer1, List<String> listplayer1number) {
        this.listplayer1 = listplayer1;
        this.listplayer1number = listplayer1number;;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(listplayer1number.get(position));
        holder.textView.setText(listplayer1.get(position));
    }

    @Override
    public int getItemCount() {
        return listplayer1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView, rowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), listplayer1.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}















