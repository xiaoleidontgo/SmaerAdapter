package me.yh.adapter.smart.container;

import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.yh.adapter.smart.bean.Footer;
import me.yh.adapter.smart.provider.FooterProvider;
import me.yh.adapter.smart.bean.Header;
import me.yh.adapter.smart.provider.HeaderProvider;
import me.yh.adapter.smart.provider.IProvider;
import me.yh.adapter.smart.type.TypeJudgment;

/**
 * Created by lyh on 2017/8/8.
 * <p>
 * 保持列表的条目类型种类
 */

public class ItemTypeContainer implements Container {

    int headerCount = 0;
    int footerCount = 0;

    /**
     *
     */
    HashMap<String, IProvider> itemTypeMap = new HashMap<>();

    /**
     *
     */
    HashMap<Class, TypeJudgment> judgmentMap = new HashMap<>();

    /**
     * 列表可能需要的表现状态页面
     */
    HashMap<String, Integer> statusMap = new HashMap<>();

    final static String EMPTY = "empty_page";


    @Override
    public void putItemType(String itemTypeKey, IProvider provider) {
        itemTypeMap.put(itemTypeKey, provider);
    }

    @Override
    public void putTypeJudgment(Class clazz, TypeJudgment judgment) {
        judgmentMap.put(clazz, judgment);
    }


    @Override
    public void putHeader(int headerViewID) {
        HeaderProvider headerProvider = new HeaderProvider(headerViewID);
        itemTypeMap.put(Header.class.getSimpleName() + headerCount++, headerProvider);
    }

    @Override
    public void putHeader(View headerView) {
        HeaderProvider headerProvider = new HeaderProvider(headerView);
        itemTypeMap.put(Header.class.getSimpleName() + headerCount++, headerProvider);
    }

    @Override
    public void putFooter(int footerViewID) {
        FooterProvider footerProvider = new FooterProvider(footerViewID);
        itemTypeMap.put(Footer.class.getSimpleName() + footerCount++, footerProvider);
    }

    @Override
    public void putFooter(View footerView) {
        FooterProvider footerProvider = new FooterProvider(footerView);
        itemTypeMap.put(Footer.class.getSimpleName() + footerCount++, footerProvider);
    }

    @Override
    public int getItemTypeCount() {
        return itemTypeMap.size();
    }

    @Override
    public IProvider getItemProvider(String key) {
        return itemTypeMap.get(key);
    }

    @Override
    public TypeJudgment getTypeJudgment(Class clazz) {
        return judgmentMap.get(clazz);
    }


    @Override
    public IProvider getItemProvider(int viewType) {
        Iterator iter = itemTypeMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
//            Object key = entry.getKey();
            IProvider provider = (IProvider) entry.getValue();
            if (provider.itemLayoutID() == viewType) {
                return provider;
            }
        }
        return null;
    }

    @Override
    public int getHeaderCount() {
        return headerCount;
    }

    @Override
    public int getFooterCount() {
        return footerCount;
    }

    @Override
    public void putEmptyReplaceHolderPage(int layoutID) {
        statusMap.put(EMPTY, layoutID);
    }

    @Override
    public void putEmptyReplaceHolderPage(View replaceView) {

    }

}

