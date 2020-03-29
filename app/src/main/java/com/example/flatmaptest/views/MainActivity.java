package com.example.flatmaptest.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.flatmaptest.R;
import com.example.flatmaptest.databinding.ActivityMainBinding;
import com.example.flatmaptest.model.MasterDataModel;
import com.example.flatmaptest.viewModel.MainActivityViewModel;
import com.example.flatmaptest.views.adapter.MainActivityAdapter;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.progressCircular.setVisibility(View.VISIBLE);
        callAPI();
    }

    private void callAPI() {
        viewModel.getMasterAPIDataFromRepo().observe(this, new Observer<MasterDataModel>() {
            @Override
            public void onChanged(MasterDataModel masterDataModel) {
                binding.setSingleUserData(masterDataModel.getSingleUserResponse().getData());
                initRecyclerView(masterDataModel);
            }
        });
    }

    private void initRecyclerView(MasterDataModel masterDataModel) {
        binding.recyclerView.setAdapter(new MainActivityAdapter(masterDataModel, this));
        binding.progressCircular.setVisibility(View.GONE);
    }
}
