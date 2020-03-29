package com.example.flatmaptest.networkCall;

import com.example.flatmaptest.BuildConfig;
import com.example.flatmaptest.model.SingleUserResponse;
import com.example.flatmaptest.model.multiUser.AllUserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServices {
    @GET(BuildConfig.API_GET_SINGLE_USER)
    Observable<SingleUserResponse> getSingleUserData(@Path("id") String id);

    @GET(BuildConfig.API_GET_MULTI_USER)
    Observable<AllUserResponse> getMultiUserData(@Query("page") String page);
}
