package com.connort6.viewerr;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel implements Operations.DataInterface {

    private MutableLiveData<List<DataModel>> dataList1 = new MutableLiveData<List<DataModel>>();
    private MutableLiveData<List<DataModel>> dataList2 = new MutableLiveData<List<DataModel>>();
    private Operations operations;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
         operations = new Operations(application,this);
    }

    public MutableLiveData<List<DataModel>> getDataList1() {
        return dataList1;
    }

    public MutableLiveData<List<DataModel>> getDataList2() {
        //TODO add breakpoint here
        return dataList2;
    }


    public void load(){
        operations.load();
    }

    @Override
    public void dataLoaded(List<DataModel> dataModels) {
        dataList1.postValue(new ArrayList<>(dataModels));
        dataList2.postValue(new ArrayList<>(dataModels));
    }
}
