package yzs.commonlibrary.base;

import android.support.v7.app.AppCompatActivity;

/**
 * wxj-2016-5-20
 * 继承自IJHealthCommon,用来作为本项目的基类
 */
public abstract class CommonBaseAppCompatActivity extends AppCompatActivity {



    /**
     * 通用初始化方法
     */
    public abstract void init();

    /**
     * onCreate中的view初始化
     */
    public abstract void initView();


    /**
     * onCreate中的数据初始化
     */
    public abstract void initData();

    /**
     * onCreate中的监听初始化
     */
    public abstract void initListener();

//    protected abstract void initProgressDialog();
//
//    protected abstract void showProgressDialog();
//
//    /**
//     * dismiss方法会释放对话框所占的资源，而hide方法不会
//     */
//    protected abstract void hideProgressDialog();
//
//    protected abstract void dismissProgressDialog();


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        dismissProgressDialog();
//    }



    /**
     * 一句话调用的书写模板
     */
    public void initCreate() {
        init();
        initView();
        initData();
        initListener();
    }
}
