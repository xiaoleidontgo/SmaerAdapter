package me.yh.adapter.smart.provider;

import android.view.View;

import me.yh.adapter.smart.bean.Footer;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/19.
 */

public class FooterProvider implements IProvider<Footer> {

    View footerView;
    int footerViewID = -1;

    public FooterProvider(View footerView) {
        this.footerView = footerView;
    }

    public FooterProvider(int footerViewID) {
        this.footerViewID = footerViewID;
    }

    @Override
    public int itemLayoutID() {
        if (footerView != null)
            return footerView.getId();
        else
            return footerViewID;
    }

    @Override
    public void onBindItemData(View view, Footer footer) {

    }

    @Override
    public void onClick(View view, int position, Footer footer) {

    }

    @Override
    public boolean onLongClick(View view, int position, Footer footer) {
        return false;
    }
}
