package top.orange233.memorange.model;

import top.orange233.memorange.utils.Callback;

/**
 * MemoModel的接口
 */
public interface IMemoModel extends IModel {

    void addMemo();

    void editMemo(int index, String memoTitle, String memoContent, final Callback callback);
}
