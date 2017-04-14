package com.hym.mvp.presenter;

import com.hym.mvp.View.IBaseView;

import java.lang.ref.WeakReference;

/**
 * File description here
 *
 * @author hym
 * @version 1.0.0
 * @since 2017-04-13 15:36
 */

public class BasePresenter<V extends IBaseView>{
    private WeakReference<V> viewRef;


    /**
     * 界面创建，Presenter与界面取得联系
     */
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    /**
     * 获取界面的引用
     */
    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * 判断界面是否销毁
     */
    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    /**
     * 界面销毁，Presenter与界面断开联系
     */
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
