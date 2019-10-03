package top.orange233.memorange.utils;

/**
 * 暂未使用，Adapter中暂不需要
 *
 * @param <K> 成功返回值/类
 * @param <V> 失败返回值/类
 */
public interface Callback<K, V> {

    void onSuccess(K data);

    void onFail(V data);
}
