package com.hym.mvp;

import android.os.Bundle;
import android.widget.TextView;

import com.hym.mvp.View.IShowDataActView;
import com.hym.mvp.presenter.DataPresenter;

public class ShowDataActivity extends BaseActivity<DataPresenter> implements IShowDataActView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show_data);
        presenter.getData();

    }

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter();
    }


    @Override
    public void updateUI(String txt) {
        ((TextView)findViewById(R.id.tv)).setText(txt);
    }
}
