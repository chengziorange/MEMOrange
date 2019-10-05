package top.orange233.memorange.view;

import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import top.orange233.memorange.R;
import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.contract.EditMemoContract;
import top.orange233.memorange.presenter.EditMemoPresenter;
import top.orange233.memorange.utils.MyConstants;

public class EditMemoActivity extends BaseMVPActivity<EditMemoPresenter> implements EditMemoContract.View {

    EditText editTextContent;
    EditText editTextTitle;
    Toolbar toolbar;
    String behavior;
    int index;

    @Override
    protected void init() {
        setContentView(R.layout.activity_memo);
        behavior = getIntent().getStringExtra(MyConstants.KEY_EDIT_MEMO_BEHAVIOR);
        index = getIntent().getIntExtra(MyConstants.KEY_MEMO_ID, MyConstants.FLAG_ADD_NEW_MEMO);
        editTextContent = findViewById(R.id.et_memo_content);
        editTextTitle = findViewById(R.id.et_memo_title);
        toolbar = findViewById(R.id.toolbar_memo);

        Log.d("TAG", "" + index);
        mPresenter.showMemo(index);

        toolbar.setNavigationOnClickListener(v -> {
            String memoTitle = editTextTitle.getText().toString();
            String memoContent = editTextContent.getText().toString();

            mPresenter.submitEdit(index, memoTitle, memoContent);
        });
    }

    @Override
    protected EditMemoPresenter createPresenter() {
        return new EditMemoPresenter();
    }

    @Override
    public void showMemoSuccess(MemoBean memoBean) {
        editTextTitle.setText(memoBean.getTitle());
        editTextContent.setText(memoBean.getContent());
    }

    @Override
    public void showMemoFail() {

    }
}
