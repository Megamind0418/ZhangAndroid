package com.superhaha.sinaweibo.mvp.view.impl;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.superhaha.sinaweibo.mvp.presenter.MvpPresenter;
import com.superhaha.sinaweibo.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/11/6.
 */

public abstract class MvpFragment<P extends MvpPresenter>extends Fragment implements MvpView {
    private P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.presenter = bindPresenter();
        if (this.presenter != null) {
            this.presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter != null) {
            this.presenter.detachView();
            this.presenter = null;
        }
    }
}