package yzs.itaxi.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzs.commonlibrary.util.ToastUtil;
import yzs.itaxi.R;
import yzs.itaxi.base.BaseActivity;
import yzs.itaxi.data.module.NewsResponse;
import yzs.itaxi.presenter.MainPresenter;
import yzs.map.MapIndexActivity;

@Route(path = "/app/main")
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tv)
    TextView tv;

    @OnClick({R.id.tv, R.id.btn_latest_list})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                mPresenter.saveData("通过mvp 保存数据");
                break;
            case R.id.btn_latest_list:
                mPresenter.latestList("", "");
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initCreate();

    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {

    }


    @Override
    public void showData(String data) {
        tv.setText(data);
        Intent intent = new Intent(this, MapIndexActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatestInfo(NewsResponse newsResponse) {
        ToastUtil.showMessage("search success ：" + newsResponse.getStories().size());
    }

    @Override
    public void showFailInfo(String errorInfo) {
        ToastUtil.showMessage(errorInfo);
    }
}
