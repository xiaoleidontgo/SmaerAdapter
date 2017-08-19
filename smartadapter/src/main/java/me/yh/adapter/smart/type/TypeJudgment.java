package me.yh.adapter.smart.type;

import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/19.
 * <p>
 * 对于同一实体类，不同的item(根据Type等字段区分)时，由此类判别不同的item并指向不同的Provider
 */

public interface TypeJudgment<T> {

    IProvider onJudge(T t);

}
