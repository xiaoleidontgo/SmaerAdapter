package me.yh.adapter.smart.provider;

import android.view.View;

import me.yh.adapter.smart.bean.Header;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/19.
 */

public class HeaderProvider implements IProvider<Header> {

    View headerView;
    int headerViewID = -1;

    public HeaderProvider(View headerView) {
        this.headerView = headerView;
    }

    public HeaderProvider(int headerViewID) {
        this.headerViewID = headerViewID;
    }

    @Override
    public int itemLayoutID() {
        if (headerView != null)
            return headerView.getId();
        else
            return headerViewID;
    }

    @Override
    public void onBindItemData(View view, Header header) {

    }

    @Override
    public void onClick(View view, int position, Header header) {

    }

    @Override
    public boolean onLongClick(View view, int position, Header header) {
        return false;
    }
}
