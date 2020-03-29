package com.example.flatmaptest.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.flatmaptest.R;
import com.example.flatmaptest.databinding.ActivityMainBinding;
import com.example.flatmaptest.model.MasterDataModel;
import com.example.flatmaptest.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        callAPI();
    }

    private void callAPI() {
        viewModel.getMasterAPIDataFromRepo().observe(this, new Observer<MasterDataModel>() {
            @Override
            public void onChanged(MasterDataModel masterDataModel) {
                binding.setSingleUserData(masterDataModel.getSingleUserResponse().getData());
            }
        });
    }
}
