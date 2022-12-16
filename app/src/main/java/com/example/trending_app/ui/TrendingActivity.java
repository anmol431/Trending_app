package com.example.trending_app.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.trending_app.R;
import com.example.trending_app.databinding.ActivityTrendingMainBinding;
import com.example.trending_app.utils.AppUtil;
import com.example.trending_app.viewmodel.TrendingViewModel;

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
        binding.setViewModel(viewModel);

        if (AppUtil.getConnectivityStatus(getApplicationContext()) != 0) {
            viewModel.deleteData();
        }

        setAdapter();
        callingApi();
        observeData();
        setListener();
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
        viewModel.getAllData().observe(this, list -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            adapter.submitList(list);
            if (list.size() > 0) {
                viewModel.error.set(View.GONE);
            }
        });
    }

    private void setListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.deleteData();
            callingApi();
        });

        binding.btnRetry.setOnClickListener(v -> callingApi());
    }
}