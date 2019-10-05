package top.orange233.memorange.presenter;

import android.util.Log;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.contract.EditMemoContract;
import top.orange233.memorange.model.IMemoModel;
import top.orange233.memorange.model.MemoModel;
import top.orange233.memorange.utils.Callback;

public class EditMemoPresenter extends BasePresenter<EditMemoContract.View> implements EditMemoContract.Presenter {

    private final IMemoModel memoModel;

    public EditMemoPresenter() {
        this.memoModel = new MemoModel();
    }

    @Override
    public void submitEdit(int index, String memoTitle, String memoContent) {
        memoModel.editMemo(index, memoTitle, memoContent);
    }

    @Override
    public void showMemo(int index) {
        memoModel.showMemo(index, new Callback<MemoBean, String>() {
            @Override
            public void onSuccess(MemoBean memoBean) {
                Log.d("TAG", "show memo success");
                if (isViewAttached()) {
                    mView.showMemoSuccess(memoBean);
                }
            }

            @Override
            public void onFail(String data) {

            }
        });
    }
}
