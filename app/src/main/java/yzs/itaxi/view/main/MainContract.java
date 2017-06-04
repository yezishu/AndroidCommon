package yzs.itaxi.view.main;

import yzs.commonlibrary.base.BasePresenter;
import yzs.commonlibrary.base.BaseView;
import yzs.itaxi.data.module.NewsResponse;

/**
 * Des：google mvp 框架 view 和p关联类
 * create by Zishu.Ye on 2017/5/31  10:49
 */
public interface MainContract {

    interface View extends BaseView {
        void showData(String data);

        /**
         * @param newsResponse    news
         */
        void showLatestInfo(NewsResponse newsResponse);
    }

    interface Presenter extends BasePresenter {
        void saveData(String data);

        /**
         * 登录
         * @param userName  u
         * @param passWord  p
         */
        void latestList(String userName, String passWord);
    }
}
