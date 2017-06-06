package yzs.commonlibrary.thridparty.autolayout;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Des：添加自适应处理的 multi item 快速适配器
 * creat by Zishu.Ye on 2016/8/30  10:37
 */
public abstract class AutoMultiItemQuickAdapter<T extends MultiItemEntity, K extends AutoViewHolder> extends BaseMultiItemQuickAdapter<T,K>{

    private AutoQuickAdapter.OnItemClickListenerAuto itemClickListenerAuto;
    private AutoQuickAdapter.OnItemChildClickListenerAuto itemChildClickListenerAuto;
    private AutoQuickAdapter.RequestLoadMoreListenerAuto loadMoreListenerAuto;

    public AutoMultiItemQuickAdapter(List<T> data) {
        super(data);
    }

    /**
     * 重载此方法为了统一适配器做分页加载最后一页的底部样式
     */
    @Override
    public void loadMoreEnd() {
        super.loadMoreEnd(true);
    }

    /**
     * 重载此方法为了统一适配器做分页加载最后一页的底部样式
     * @param gone  boolean
     */
    @Override
    public void loadMoreEnd(boolean gone) {
        super.loadMoreEnd(true);
    }

    /**
     * 用于下拉刷新时清空 适配数据
     */
    public void setNewData() {
        super.setNewData(new ArrayList<T>());
    }

    /**
     * 注册item 点击事件
     * @param listener  封装的监听回调
     */
    public void setOnItemClickListener(final AutoQuickAdapter.OnItemClickListenerAuto listener) {
        this.itemClickListenerAuto=listener;
        super.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                itemClickListenerAuto.onItemClick(adapter,view,position);
            }
        });
    }

    /**
     * 弃用 原本库的注册item点击事件。
     * 改为使用封装过的 OnItemClickListenerAuto
     * @param listener  lis
     */
    @Deprecated
    @Override
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        super.setOnItemClickListener(listener);
    }

    /**
     * 注册item Child 点击事件
     * @param listener  封装的监听回调
     */
    public void setOnItemChildClickListener(final AutoQuickAdapter.OnItemChildClickListenerAuto listener) {
        this.itemChildClickListenerAuto=listener;
        super.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                itemChildClickListenerAuto.onItemChildClick(adapter,view,position);
            }
        });
    }

    /**
     * 弃用 原本库的注册item点击事件。
     * 改为使用封装过的 OnItemChildClickListenerAuto
     * @param listener  lis
     */
    @Deprecated
    @Override
    public void setOnItemChildClickListener(OnItemChildClickListener listener) {
        super.setOnItemChildClickListener(listener);
    }

    /**
     * 注册上拉加载更多事件
     * @param recyclerView  recyclerView
     * @param listener      封装的监听回调
     */
    public void setOnLoadMoreListener(RecyclerView recyclerView, final AutoQuickAdapter.RequestLoadMoreListenerAuto listener){
        loadMoreListenerAuto =listener;
        super.setOnLoadMoreListener(new RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMoreListenerAuto.onLoadMoreRequested();
            }
        },recyclerView);
    }

    /**
     * 弃用 原本库的注册item点击事件。
     * 改为使用封装过的 RequestLoadMoreListenerAuto
     * @param requestLoadMoreListener   lis
     * @param recyclerView              rv
     */
    @Deprecated
    @Override
    public void setOnLoadMoreListener(RequestLoadMoreListener requestLoadMoreListener, RecyclerView recyclerView) {
        super.setOnLoadMoreListener(requestLoadMoreListener, recyclerView);
    }

}
