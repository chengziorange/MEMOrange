package top.orange233.memorange.presenter;

import java.util.List;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.contract.MainMenuContract;
import top.orange233.memorange.model.MainMenuModel;
import top.orange233.memorange.utils.Callback;

public class MainMenuPresenter extends BasePresenter<MainMenuContract.View> implements MainMenuContract.Presenter {

    private MainMenuModel mainMenuModel;

    public MainMenuPresenter() {
        this.mainMenuModel = new MainMenuModel();
    }

    @Override
    public void searchFor(String s) {
        mainMenuModel.searchFor(s, new Callback<List<MemoBean>, String>() {
            @Override
            public void onSuccess(List<MemoBean> memoBeans) {
                mView.showSearchResultSuccess(memoBeans);
            }

            @Override
            public void onFail(String data) {

            }
        });
    }
}
