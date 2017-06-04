package yzs.commonlibrary.base;

/**
 * Des：
 * create by Zishu.Ye on 2017/5/31  11:57
 */
public abstract class CommonBaseRxMvpFragment <P extends BasePresenter> extends CommonBaseFragment {

    /**
     * Mvp对应P
     */
    public P mPresenter;

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null)
            mPresenter.subscribe();//调用p层订阅
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null)
            mPresenter.unSubscribe();//调用p层取消订阅
    }

    /**
     * P层初始化
     */
    public abstract void initPresenter();

    @Override
    public void init() {
        initPresenter();
    }
}
