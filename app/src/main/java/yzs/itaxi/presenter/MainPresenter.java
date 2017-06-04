package yzs.itaxi.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import yzs.commonlibrary.base.BaseRxPresenter;
import yzs.commonlibrary.base.constant.URLs;
import yzs.commonlibrary.data.net.NetWorkSubscriber;
import yzs.commonlibrary.data.net.RetrofitUtils;
import yzs.itaxi.data.module.NewsResponse;
import yzs.itaxi.data.service.IMainService;
import yzs.itaxi.view.main.MainContract;

/**
 * Des：Mvp P 层具体实现类
 * create by Zishu.Ye on 2017/5/31  10:48
 */
public class MainPresenter extends BaseRxPresenter<MainContract.View> implements MainContract.Presenter{

    IMainService iMainService;

    public MainPresenter(MainContract.View view) {
        super(view);
        iMainService = RetrofitUtils.getInstance()
                .getRetrofit(URLs.WEB_COMMON_URL)
                .create(IMainService.class);
    }

    @Override
    public void saveData(String data) {
        mView.showData(data);
    }

    @Override
    public void latestList(String userName, String passWord) {
        addDisposable(iMainService.search()
//                .map(new HttpResultFunc<String>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new NetWorkSubscriber<NewsResponse>(){
                    @Override
                    public void showErrorInfo(String errorInfo) {
                        mView.showFailInfo(errorInfo);
                    }

                    @Override
                    public void showNetResult(NewsResponse s) {
                        mView.showLatestInfo(s);
                    }
                }));
    }
}
