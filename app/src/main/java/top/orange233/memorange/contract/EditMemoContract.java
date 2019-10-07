package top.orange233.memorange.contract;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.view.IView;

public interface EditMemoContract {

    interface View extends IView {

        void showMemoSuccess(MemoBean memoBean);
    }

    interface Presenter {

        void showMemo(int index);

        void submitEdit(int index, String memoTitle, String memoContent);
    }
}
