package yzs.commonlibrary.data.net;


import io.reactivex.subscribers.ResourceSubscriber;
import yzs.commonlibrary.util.AllUtilConfig;
import yzs.commonlibrary.util.LogUtil;

/**
 * Des：rx 使用retrofit 网络请求   请求回调
 * creat by Zishu.Ye on 2017/1/10  14:13
 */
public abstract class NetWorkSubscriber<T> extends ResourceSubscriber<T> {

    public abstract void showErrorInfo(String errorInfo);
    public abstract void showNetResult(T t);

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            showErrorInfo(e.getMessage());
        }else {
            showErrorInfo(ApiException.ERROR_DEFAULT);
        }
        if(AllUtilConfig.LogSwitch){
            LogUtil.e(e.getMessage(), e);
        }
    }

    @Override
    public void onNext(T t) {
        showNetResult(t);
    }
}
