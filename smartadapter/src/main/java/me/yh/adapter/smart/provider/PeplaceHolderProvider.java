package me.yh.adapter.smart.provider;

import android.view.View;

import me.yh.adapter.smart.bean.ReplaceHolder;

/**
 * Created by lyh on 2017/8/18.
 * 在列表为空数据时，展示的数据集
 */

public class PeplaceHolderProvider implements IProvider<ReplaceHolder> {

    @Override
    public int itemLayoutID() {
        return 0;
    }

    @Override
    public void onBindItemData(View view, ReplaceHolder replaceHolder) {

    }

    @Override
    public void onClick(View view, int position, ReplaceHolder replaceHolder) {

    }

    @Override
    public boolean onLongClick(View view, int position, ReplaceHolder replaceHolder) {

        return true;
    }
}
