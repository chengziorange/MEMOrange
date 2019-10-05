package top.orange233.memorange.presenter;

import top.orange233.memorange.contract.MemoContract;
import top.orange233.memorange.model.MemoModel;

public class MemoPresenter extends BasePresenter<MemoContract.View> implements MemoContract.Presenter {

    private MemoModel memoModel;

    public MemoPresenter() {
        this.memoModel = new MemoModel();
    }

}
