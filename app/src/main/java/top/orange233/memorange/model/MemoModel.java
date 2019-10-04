package top.orange233.memorange.model;

import top.orange233.memorange.utils.Callback;

public class MemoModel implements IMemoModel {

    @Override
    public void addMemo() {
        //TODO 将数据解析为Bean，并通过数据库存储
    }

    @Override
    public void editMemo(int index, String memoTitle, String memoContent, final Callback callback) {
        //TODO 从数据库中取出index处的Memo,修改后再存回。回调presenter，通知view
    }
}
