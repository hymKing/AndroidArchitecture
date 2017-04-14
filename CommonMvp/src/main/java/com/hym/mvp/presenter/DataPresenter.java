package com.hym.mvp.presenter;

import android.os.AsyncTask;

import com.hym.mvp.View.IShowDataActView;
import com.hym.mvp.model.IDataModel;
import com.hym.mvp.model.DataModelImp;

/**
 * File description here
 *
 * @author hym
 * @version 1.0.0
 * @since 2017-04-10 17:20
 */

public class DataPresenter extends BasePresenter<IShowDataActView> {
    IDataModel mDataModelImp=new DataModelImp();
    public void getData(){
        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                return  mDataModelImp.getData();
            }

            @Override
            protected void onPostExecute(String s) {
                getView().updateUI(s);
            }
        }.execute();

    }
}
