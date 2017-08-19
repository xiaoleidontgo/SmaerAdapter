package me.yh.adapter.smart.builder;


import android.view.View;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import me.yh.adapter.smart.SmartAdapter;
import me.yh.adapter.smart.container.Container;
import me.yh.adapter.smart.container.ItemTypeContainer;
import me.yh.adapter.smart.provider.IProvider;
import me.yh.adapter.smart.type.TypeJudgment;

/**
 * Created by lyh on 2017/8/16.
 */


public class SmartAdapterBuilder implements SmartBuilder {

    private List<Object> items;
    private Container container;

    public SmartAdapterBuilder() {
        container = new ItemTypeContainer();
    }

    @Override
    public SmartAdapterBuilder registerItem(Class clazz, IProvider provider) {
        container.putItemType(clazz.getSimpleName(), provider);
        return this;
    }

    @Override
    public <T> SmartAdapterBuilder registerItem(Class clazz, TypeJudgment<T> judgment) {
        container.putTypeJudgment(clazz, judgment);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerEmptyPage(int emptyLayoutId) {
        container.putEmptyReplaceHolderPage(emptyLayoutId);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerEmptyPage(View emptyView) {
        container.putEmptyReplaceHolderPage(emptyView);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerHeader(int headerLayoutId) {
        container.putHeader(headerLayoutId);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerHeader(View headerView) {
        container.putHeader(headerView);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerFooter(int footerLayoutId) {
        container.putFooter(footerLayoutId);
        return this;
    }

    @Override
    public SmartAdapterBuilder registerFooter(View footerView) {
        container.putFooter(footerView);
        return this;
    }

    @Override
    public SmartAdapterBuilder bindData(List<Object> itemData) {
        items = itemData;
        return this;
    }

    @Override
    public SmartAdapter create() {
        SmartAdapter adapter = new SmartAdapter(items, container);
        container = null;
        items = null;
        return adapter;
    }

}