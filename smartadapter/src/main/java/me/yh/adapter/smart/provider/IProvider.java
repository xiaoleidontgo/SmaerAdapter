package me.yh.adapter.smart.provider;

import android.view.View;

/**
 * Created by lyh on 2017/8/8.
 */

public interface IProvider<T> {

    int itemLayoutID();

    void onBindItemData(View view, T t);

    void onClick(View view, int position, T t);

    boolean onLongClick(View view, int position, T t);


}
