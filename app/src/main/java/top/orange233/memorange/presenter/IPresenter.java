package top.orange233.memorange.presenter;

import top.orange233.memorange.view.IView;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void detachView();

    boolean isViewAttached();
}
