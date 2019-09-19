package almotech.co.androidtemplate.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import almotech.co.androidtemplate.R;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {

    List<String> feed_item_list = new ArrayList<>();
    Activity activity;

    public AdapterClass(List<String> feed_item) {
        this.feed_item_list = feed_item;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.adapter_structure, viewGroup, false);
        return new AdapterClass.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final String currentItem = feed_item_list.get(i);



    }



    @Override
    public int getItemCount() {
        return feed_item_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
