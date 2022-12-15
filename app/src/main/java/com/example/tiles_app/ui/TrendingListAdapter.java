package com.example.tiles_app.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiles_app.R;
import com.example.tiles_app.databinding.ItemTrendingListBinding;
import com.example.tiles_app.model.TrendingData;

import java.util.ArrayList;
import java.util.List;

public class TrendingListAdapter extends RecyclerView.Adapter<TrendingListAdapter.MyViewHolder> {
    private final ArrayList<TrendingData> trendingData;
    private LayoutInflater layoutInflater;

    public TrendingListAdapter() {
        trendingData = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitList(List<TrendingData> list) {
        trendingData.addAll(list);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearList() {
        trendingData.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemTrendingListBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_trending_list, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.binding.setTrendingData(trendingData.get(position));

        Glide.with(holder.binding.getRoot().getContext())
               .load(trendingData.get(position).getAvatar()).into(holder.binding.ivAvatar);

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return trendingData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemTrendingListBinding binding;

        MyViewHolder(final ItemTrendingListBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}