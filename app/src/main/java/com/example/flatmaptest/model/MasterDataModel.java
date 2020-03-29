package com.example.flatmaptest.model;

import com.example.flatmaptest.model.multiUser.AllUserResponse;

public class MasterDataModel {
    private SingleUserResponse singleUserResponse;
    private AllUserResponse allUserResponse;

    public SingleUserResponse getSingleUserResponse() {
        return singleUserResponse;
    }

    public void setSingleUserResponse(SingleUserResponse singleUserResponse) {
        this.singleUserResponse = singleUserResponse;
    }

    public AllUserResponse getAllUserResponse() {
        return allUserResponse;
    }

    public void setAllUserResponse(AllUserResponse allUserResponse) {
        this.allUserResponse = allUserResponse;
    }

    @Override
    public String toString() {
        return "MasterDataModel{" +
                "singleUserResponse=" + singleUserResponse +
                ", allUserResponse=" + allUserResponse +
                '}';
    }
}
