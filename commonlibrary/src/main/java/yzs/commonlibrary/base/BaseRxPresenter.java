package yzs.commonlibrary.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Des：扩展google mvp框架产生出来的P基类
 * 用于统一处理Rx 生命周期
 * create by Zishu.Ye on 2017/5/31  10:38
 */
public class BaseRxPresenter<V extends BaseView> implements BasePresenter {

    private CompositeDisposable mDisposables;

    public V mView;

    public BaseRxPresenter(V view) {
        this.mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if (mDisposables != null)
            mDisposables.clear();
    }

    /**
     * 添加一个订阅到 订阅合集中 compositeSubscription
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
        mDisposables.add(disposable);
    }

}
