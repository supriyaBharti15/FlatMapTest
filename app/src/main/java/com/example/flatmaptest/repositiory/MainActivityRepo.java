package com.example.flatmaptest.repositiory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.flatmaptest.model.MasterDataModel;
import com.example.flatmaptest.model.SingleUserResponse;
import com.example.flatmaptest.model.multiUser.AllUserResponse;
import com.example.flatmaptest.networkCall.RetrofitCall;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivityRepo {
    private MutableLiveData<MasterDataModel> mutableLiveData = new MutableLiveData<>();
    private MasterDataModel masterDataModel = new MasterDataModel();
    private static MainActivityRepo activityRep;

    public static MainActivityRepo getInstance() {
        if (activityRep == null) {
            activityRep = new MainActivityRepo();
        }
        return activityRep;
    }

    /*
    1. First Step
     */
    private Observable<MasterDataModel> getSingleUserObservable() {
        return RetrofitCall.getRetrofitServices().getSingleUserData("2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<SingleUserResponse, ObservableSource<MasterDataModel>>() {
                    @Override
                    public ObservableSource<MasterDataModel> apply(SingleUserResponse singleUserResponse) throws Exception {
                        masterDataModel.setSingleUserResponse(singleUserResponse);
                        final int delay = new Random().nextInt(5);
                        return Observable.just(masterDataModel).delay(delay, TimeUnit.SECONDS);
                    }
                });
    }

    /*
    2. Second Step
     */

    private Observable<MasterDataModel> getAllUSerObservable(final MasterDataModel masterDataModel) {
        return RetrofitCall.getRetrofitServices().getMultiUserData("posts")
                .map(new Function<AllUserResponse, MasterDataModel>() {
                    @Override
                    public MasterDataModel apply(AllUserResponse allUserResponse) throws Exception {
                        masterDataModel.setAllUserResponse(allUserResponse);
                        return masterDataModel;
                    }
                });
    }

    /*
    3. Thirs steps
     */
    public LiveData<MasterDataModel> callMasterAPI() {
        getSingleUserObservable()
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<MasterDataModel, ObservableSource<MasterDataModel>>() {
                    @Override
                    public ObservableSource<MasterDataModel> apply(MasterDataModel masterDataModel) throws Exception {
                        return getAllUSerObservable(masterDataModel);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MasterDataModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MasterDataModel masterDataModel) {
                        mutableLiveData.setValue(masterDataModel);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return mutableLiveData;
    }
}
