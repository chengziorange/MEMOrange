package top.orange233.memorange.contract;

import top.orange233.memorange.view.IView;

public interface MemoContract {

    interface View extends IView {

        void addMemo();

        void removeMemo();
    }

    interface Presenter {

        void addMemo();
    }
}
