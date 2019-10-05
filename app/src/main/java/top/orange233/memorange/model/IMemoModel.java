package top.orange233.memorange.model;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.utils.Callback;

/**
 * MemoModel的接口
 */
public interface IMemoModel extends IModel {

    void editMemo(int index, String memoTitle, String memoContent);

    void showMemo(int index, final Callback<MemoBean,String> callback);
}
