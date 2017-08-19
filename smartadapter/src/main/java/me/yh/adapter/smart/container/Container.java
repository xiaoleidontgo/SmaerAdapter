package me.yh.adapter.smart.container;

import android.view.View;

import me.yh.adapter.smart.provider.IProvider;
import me.yh.adapter.smart.type.TypeJudgment;

/**
 * Created by lyh on 2017/8/8.
 * <p>
 * 列表数据条目类型容器
 */

public interface Container {

    /**
     * 根据key->条目类型的方式注册多条目
     *
     * @param itemTypeKey
     * @param provider
     */
    void putItemType(String itemTypeKey, IProvider provider);

    /**
     * 根据同一对象的不同type注册多条目
     */
    void putTypeJudgment(Class clazz, TypeJudgment judgment);

    void putHeader(int headerViewID);

    void putHeader(View headerView);

    void putFooter(int footerViewID);

    void putFooter(View footerView);

    int getItemTypeCount();

    IProvider getItemProvider(String key);

    TypeJudgment getTypeJudgment(Class clazz);

    IProvider getItemProvider(int viewType);

    int getHeaderCount();

    int getFooterCount();


    void putEmptyReplaceHolderPage(int layoutID);

    void putEmptyReplaceHolderPage(View replaceView);


}
