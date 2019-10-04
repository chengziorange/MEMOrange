package top.orange233.memorange.contract;

import top.orange233.memorange.view.IView;

public interface EditMemoContract {

    interface View extends IView {

        void submitEdit();
    }

    interface Presenter {

        void submitEdit(int index, String memoTitle, String memoContent);
    }
}
