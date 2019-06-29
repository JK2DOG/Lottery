package com.peng.lottery.base;


import android.support.annotation.NonNull;

import com.peng.lottery.app.utils.ToastUtil;

import javax.inject.Inject;

/**
 * @author Peng
 * Created by Peng on 2017/12/12.
 * Fragment的基类（MVP模式）
 */

public abstract class BaseFragment<P extends BasePresenter> extends SimpleBaseFragment implements IView {

    /**
     * 当前Fragment所对应的业务操作类
     */
    @Inject
    protected P mPresenter;

    @Override
    protected void init() {
        super.init();
        initInject();
        if (mPresenter != null) {
            mPresenter.bindView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unbindView();
        }
    }

    @Override
    public void pageLoading() {

    }

    @Override
    public void pageEmpty() {

    }

    @Override
    public void pageError(int errorCode) {

    }

    @Override
    public void showToast(@NonNull String message) {
        ToastUtil.showToast(mActivity, message);
    }

    /**
     * 初始化dagger2注入
     */
    public abstract void initInject();
}
