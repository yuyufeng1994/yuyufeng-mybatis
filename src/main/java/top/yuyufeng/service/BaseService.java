package top.yuyufeng.service;

import java.util.List;

/**
 * Created by yuyufeng on 2017/6/7.
 */
public abstract class BaseService<T> {
    abstract int add(T entity);

    abstract T query(T entity);

    abstract List<T> list();
}
