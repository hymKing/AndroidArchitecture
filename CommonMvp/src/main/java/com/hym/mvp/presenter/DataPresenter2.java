package com.hym.mvp.presenter;

import android.os.AsyncTask;

import com.hym.mvp.View.IShowData2ActView;
import com.hym.mvp.View.IShowDataActView;
import com.hym.mvp.model.DataModelImp;
import com.hym.mvp.model.IDataModel;

/**
 * File description here
 *
 * @author hym
 * @version 1.0.0
 * @since 2017-04-10 17:20
 */

public class DataPresenter2 extends BasePresenter<IShowData2ActView> {
    IDataModel mDataModelImp=new DataModelImp();
    public void getData(){
        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                return  mDataModelImp.getData();
            }

            @Override
            protected void onPostExecute(String s) {
                getView().showToast("这是第二个presenter执行的结果");
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }
}
