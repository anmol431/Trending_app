package com.example.tiles_app.ui;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.tiles_app.R;
import com.example.tiles_app.databinding.ActivityTrendingMainBinding;
import com.example.tiles_app.viewmodel.TrendingViewModel;

public class TrendingActivity extends AppCompatActivity {
    private ActivityTrendingMainBinding binding;
    private TrendingListAdapter adapter;
    private TrendingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trending_main);
        binding.setLifecycleOwner(this);

        viewModel = new ViewModelProvider(this).get(TrendingViewModel.class);

        viewModel.init(this);

        setAdapter();
        callingApi();
        observeData();

        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.deleteTiles();
            callingApi();
        });
    }

    private void callingApi() {
        binding.swipeRefreshLayout.setRefreshing(true);
        adapter.clearList();
        viewModel.getTrendingData();
    }

    private void setAdapter() {
        adapter = new TrendingListAdapter();
        binding.rcvList.setAdapter(adapter);
    }

    private void observeData() {
        viewModel.getAllData().observe(this, tilesList -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            adapter.submitList(tilesList);
        });
    }


}