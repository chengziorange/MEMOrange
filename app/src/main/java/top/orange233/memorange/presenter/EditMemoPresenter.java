package top.orange233.memorange.presenter;

import top.orange233.memorange.contract.EditMemoContract;
import top.orange233.memorange.model.MemoModel;
import top.orange233.memorange.utils.Callback;

public class EditMemoPresenter extends BasePresenter<EditMemoContract.View> implements EditMemoContract.Presenter {

    private MemoModel memoModel;

    @Override
    public void submitEdit(int index, String memoTitle, String memoContent) {
        memoModel.editMemo(index, memoTitle, memoContent, new Callback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFail(Object data) {

            }
        });
    }
}
