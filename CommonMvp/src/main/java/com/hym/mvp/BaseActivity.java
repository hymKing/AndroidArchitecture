package com.hym.mvp;

import android.os.Bundle;
import android.app.Activity;

import com.hym.mvp.View.IBaseView;
import com.hym.mvp.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * baseActivity中设定presenter的泛型，限定presenter的开发规范
 * @author hym
 * @version 1.0.0
 * create at 2017/4/13
 */
public abstract  class BaseActivity<P extends BasePresenter> extends Activity implements IBaseView {


    protected P presenter;
    /**
     * 附加的presenter集合
     */
    protected List<BasePresenter> plusPresenters=new ArrayList<BasePresenter>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        presenter.attachView(this);
    }
    /**
     * 添加附件的presenter
     * @param presenter
     */
    public void addPlusPresenter(BasePresenter presenter){
        plusPresenters.add(presenter);
        presenter.attachView(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        for (BasePresenter presenter : plusPresenters) {
            presenter.detachView();
        }
    }
    protected abstract P createPresenter();
}
