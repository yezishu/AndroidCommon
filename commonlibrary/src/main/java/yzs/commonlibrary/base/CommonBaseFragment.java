package yzs.commonlibrary.base;


import android.support.v4.app.Fragment;

/**
 * Created by wxj on 2015/11/24 0024.
 * Fragment基类
 */
public abstract class CommonBaseFragment extends Fragment {
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


//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
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
