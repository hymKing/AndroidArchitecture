package com.hym.mvp;

import android.os.Bundle;
import android.app.Activity;

import com.hym.mvp.View.IBaseView;
import com.hym.mvp.presenter.BasePresenter;
/**
 * baseActivity中设定presenter的泛型，限定presenter的开发规范
 * @author hym
 * @version 1.0.0
 * create at 2017/4/13
 */
public abstract  class BaseActivity<P extends BasePresenter> extends Activity implements IBaseView {


    protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
    protected abstract P createPresenter();
}
