package top.orange233.memorange.view;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import com.jaeger.library.StatusBarUtil;

import top.orange233.memorange.R;
import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.contract.EditMemoContract;
import top.orange233.memorange.presenter.EditMemoPresenter;
import top.orange233.memorange.utils.MyConstants;

public class EditMemoActivity extends BaseMVPActivity<EditMemoPresenter> implements EditMemoContract.View {

    EditText editTextContent;
    EditText editTextTitle;
    Toolbar toolbar;
    int index;

    @Override
    protected void init() {
        setContentView(R.layout.activity_memo);
        StatusBarUtil.setTransparent(this);
        StatusBarUtil.setLightMode(this);
        index = getIntent().getIntExtra(MyConstants.KEY_MEMO_ID, MyConstants.FLAG_ADD_NEW_MEMO);
        Log.d("TAG", "EditMemoAcitivity index = " + index);
        editTextContent = findViewById(R.id.et_memo_content);
        editTextTitle = findViewById(R.id.et_memo_title);
        toolbar = findViewById(R.id.toolbar_memo);

        mPresenter.showMemo(index);

        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    protected EditMemoPresenter createPresenter() {
        return new EditMemoPresenter();
    }

    @Override
    public void showMemoSuccess(MemoBean memoBean) {
        editTextTitle.setText(memoBean.getTitle());
        editTextTitle.setSelection(memoBean.getTitle().length());
        editTextContent.setText(memoBean.getContent());
        if (memoBean.getContent() != null) {
            editTextContent.setSelection(memoBean.getContent().length());
        }
    }

    @Override
    public void showMemoFail() {

    }

    @Override
    public void onBackPressed() {
        String memoTitle = editTextTitle.getText().toString();
        String memoContent = editTextContent.getText().toString();

        mPresenter.submitEdit(index, memoTitle, memoContent);

        super.onBackPressed();
    }
}
