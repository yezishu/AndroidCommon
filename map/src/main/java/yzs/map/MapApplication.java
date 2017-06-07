package yzs.map;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhy.autolayout.config.AutoLayoutConifg;

import yzs.commonlibrary.BuildConfig;
import yzs.commonlibrary.util.AllUtilConfig;

/**
 * Des：map 基本application
 * create by Zishu.Ye on 2017/6/7  15:02
 */
public class MapApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.IS_BUILD_MOUDLE) {
            initBuildModuleConfig();
        }
    }

    /**
     * 加载 分组件编译时候需要加载的配置
     */
    private void initBuildModuleConfig() {
        AllUtilConfig.applicationContext = this;
        AllUtilConfig.DES_Key = "sfasfsdf";
        AllUtilConfig.LogSwitch = BuildConfig.DEBUG;

        //路由框架初始化
        ARouter.init(this);

        initAutoLayout();
    }

    /**
     * 自适应布局框架初始化
     */
    private void initAutoLayout() {
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
