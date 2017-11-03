package com.example.admin.googleplacesapplication.view.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.googleplacesapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyItemListAdapter extends RecyclerView.Adapter<MyItemListAdapter.ViewHolder> {

    private static final String TAG = "MyItemListAdapter";
    Context context;
    List<String> items = new ArrayList<>();

    public MyItemListAdapter(Context context, List<String> itemList) {
        this.context = context;
        this.items = itemList;
    }

    @Override
    public MyItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate( R.layout.list_item, parent, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(MyItemListAdapter.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}