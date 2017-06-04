package yzs.itaxi.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import yzs.commonlibrary.base.BaseRxPresenter;
import yzs.commonlibrary.base.CommonBaseRxMvpActivity;

/**
 * Des：BaseActivity
 * create by Zishu.Ye on 2017/5/31  9:44
 */
public abstract class BaseActivity<P extends BaseRxPresenter>  extends CommonBaseRxMvpActivity<P> {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

}
