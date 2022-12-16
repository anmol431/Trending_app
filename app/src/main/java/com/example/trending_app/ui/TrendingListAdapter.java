package com.example.trending_app.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending_app.R;
import com.example.trending_app.databinding.ItemTrendingListBinding;
import com.example.trending_app.model.TrendingData;

import java.util.ArrayList;
import java.util.List;

public class TrendingListAdapter extends RecyclerView.Adapter<TrendingListAdapter.MyViewHolder> {
    private final ArrayList<TrendingData> trendingData;
    private LayoutInflater layoutInflater;
    private int mExpandedPosition = -1;

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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.binding.setTrendingData(trendingData.get(position));

        holder.binding.setIsExpand(false);

        final boolean isExpanded = position == mExpandedPosition;
        holder.binding.setIsExpand(isExpanded);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(v -> {
            mExpandedPosition = isExpanded ? -1 : position;
            notifyDataSetChanged();
        });

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