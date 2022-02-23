package com.connort6.viewerr;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private Context context;
    private DataInterface dataInterface;

    public interface DataInterface{
        void dataLoaded(List<DataModel> dataModels);
    }

    public Operations(Context context, DataInterface dataInterface) {
        this.context = context;
        this.dataInterface = dataInterface;
    }




    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            List<DataModel> dataList = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                dataList.add(new DataModel("asdasd", 555.55));
            }
            dataInterface.dataLoaded(dataList);
        }
    };

    public void load(){
        new Thread(runnable).start();
    }
}
