package yzs.commonlibrary.base.config;

import android.app.Application;

import yzs.commonlibrary.util.LogUtil;

/**
 * Des：全局 application 实例类
 * create by Zishu.Ye on 2017/8/4  15:06
 */
public class App {

    public static final Application INSTANCE;

    static {
        Application app = null;
        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null)
                throw new IllegalStateException("Static initialization of Applications must be on main thread.");
        } catch (final Exception e) {
            LogUtil.e("Failed to get current application from AppGlobals." + e.getMessage());
            try {
                app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (final Exception ex) {
                LogUtil.e("Failed to get current application from ActivityThread." + e.getMessage());
            }
            e.printStackTrace();
        } finally {
            INSTANCE = app;
        }
    }
}
