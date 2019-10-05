package top.orange233.memorange.model;

import org.litepal.LitePal;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.data.MemoList;
import top.orange233.memorange.utils.Callback;
import top.orange233.memorange.utils.MyDateFormat;

public class MemoModel implements IMemoModel {

    @Override
    public void editMemo(int index, String memoTitle, String memoContent) {
        // 从数据库中取出index处的Memo,修改后再存回。回调presenter，通知view
        MemoBean memoBean;
        String memoDate = MyDateFormat.getInstance().getDate();
        if (index < 0) {
            memoBean = new MemoBean(MemoList.mMemoList.size() - 1, memoTitle, memoDate, memoContent);
            memoBean.save();
        } else {
            memoBean = LitePal.find(MemoBean.class, index);
            memoBean.setTitle(memoTitle);
            memoBean.setDate(memoDate);
            memoBean.setContent(memoContent);
            memoBean.save();
        }
    }

    @Override
    public void showMemo(int index, final Callback<MemoBean, String> callback) {
        MemoBean memoBean;
        String memoDate = MyDateFormat.getInstance().getDate();
        if (index < 0) {
            memoBean = new MemoBean();
            memoBean.save();
        } else {
            memoBean = LitePal.where("index = ?", String.valueOf(index)).find(MemoBean.class).get(0);
        }

        if (memoBean == null) {
            callback.onFail("出现错误");
        } else {
            callback.onSuccess(memoBean);
        }
    }
}
