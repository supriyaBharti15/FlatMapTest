package com.example.flatmaptest.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.flatmaptest.model.MasterDataModel;
import com.example.flatmaptest.repositiory.MainActivityRepo;

public class MainActivityViewModel extends ViewModel {
    public LiveData<MasterDataModel> getMasterAPIDataFromRepo() {
        return MainActivityRepo.getInstance().callMasterAPI();
    }
}
