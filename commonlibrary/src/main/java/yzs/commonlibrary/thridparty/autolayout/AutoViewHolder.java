package yzs.commonlibrary.thridparty.autolayout;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Des：
 * creat by Zishu.Ye on 2017/3/24  15:59
 */
public class AutoViewHolder extends BaseViewHolder {
    public AutoViewHolder(View view) {
        super(view);
        AutoUtils.auto(view);
    }
}
