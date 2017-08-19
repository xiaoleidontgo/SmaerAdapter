package me.yh.adapter.smart.builder;

import android.view.View;

import java.util.List;

import me.yh.adapter.smart.SmartAdapter;
import me.yh.adapter.smart.provider.IProvider;
import me.yh.adapter.smart.type.TypeJudgment;

/**
 * Created by lyh on 2017/8/11.
 */

public interface SmartBuilder {

    SmartAdapterBuilder registerItem(Class clazz, IProvider provider);

    <T> SmartAdapterBuilder registerItem(Class clazz,TypeJudgment<T> judgment);

    SmartAdapterBuilder registerEmptyPage(int emptyLayoutId);

    SmartAdapterBuilder registerEmptyPage(View emptyView);

    SmartAdapterBuilder registerHeader(int headerLayoutId);

    SmartAdapterBuilder registerHeader(View headerView);

    SmartAdapterBuilder registerFooter(int footerLayoutId);

    SmartAdapterBuilder registerFooter(View footerView);

    SmartAdapterBuilder bindData(List<Object> itemDatas);

    SmartAdapter create();

}
