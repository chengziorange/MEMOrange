package top.orange233.memorange.model;

import org.litepal.LitePal;

import java.util.List;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.utils.Callback;
import top.orange233.memorange.utils.MyDateFormat;

public class MemoModel implements IMemoModel {

    @Override
    public void editMemo(int index, String memoTitle, String memoContent) {
        // 从数据库中取出index处的Memo,修改后再存回。回调presenter，通知view
        MemoBean memoBean;
        String memoDate = MyDateFormat.getInstance().getDate();
        List<MemoBean> tmpMemoBeanList = LitePal
                .where("number = ?", "" + index)
                .order("number")
                .find(MemoBean.class);
        memoBean = tmpMemoBeanList.get(0);
        memoBean.setTitle(memoTitle);
        memoBean.setDate(memoDate);
        memoBean.setContent(memoContent);
        memoBean.save();

    }

    @Override
    public void showMemo(int number, final Callback<MemoBean, String> callback) {
        MemoBean memoBean;
        List<MemoBean> tmpMemoBeanList = LitePal
                .where("number = ?", "" + number)
                .order("number")
                .find(MemoBean.class);
        memoBean = tmpMemoBeanList.get(0);

        if (memoBean == null) {
            callback.onFail("出现错误");
        } else {
            callback.onSuccess(memoBean);
        }
    }
}
