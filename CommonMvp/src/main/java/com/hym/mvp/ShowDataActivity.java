package com.hym.mvp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hym.mvp.View.IShowData2ActView;
import com.hym.mvp.View.IShowDataActView;
import com.hym.mvp.presenter.DataPresenter;
import com.hym.mvp.presenter.DataPresenter2;

public class ShowDataActivity extends BaseActivity<DataPresenter> implements IShowDataActView,IShowData2ActView {
    DataPresenter2 mDataPresenter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show_data);
        presenter.getData();
        mDataPresenter2= new DataPresenter2();
        addPlusPresenter(mDataPresenter2);
        mDataPresenter2.getData();

    }

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter();
    }


    @Override
    public void updateUI(String txt) {
        ((TextView)findViewById(R.id.tv)).setText(txt);
    }

    @Override
    public void showToast(String txt) {
        Toast.makeText(this,"presenter 2 更新ui",0).show();
    }
}
