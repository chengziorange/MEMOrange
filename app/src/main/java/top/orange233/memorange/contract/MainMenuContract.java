package top.orange233.memorange.contract;

import java.util.List;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.view.IView;

public interface MainMenuContract {

    interface View extends IView {

        void showSearchResult(List<MemoBean> memoBeans) ;
    }

    interface Presenter {

        void searchFor(String s);
    }
}
