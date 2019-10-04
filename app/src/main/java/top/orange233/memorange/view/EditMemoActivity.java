package top.orange233.memorange.view;

import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import top.orange233.memorange.R;
import top.orange233.memorange.contract.EditMemoContract;
import top.orange233.memorange.presenter.EditMemoPresenter;

public class EditMemoActivity extends BaseMVPActivity<EditMemoPresenter> implements EditMemoContract.View {

    EditText editTextContent;
    EditText editTextTitle;
    Toolbar toolbar;

    @Override
    protected void init() {
        setContentView(R.layout.activity_memo);
        editTextContent = findViewById(R.id.et_memo_content);
        editTextTitle = findViewById(R.id.et_memo_title);
        toolbar = findViewById(R.id.toolbar_memo);

        toolbar.setNavigationOnClickListener(v -> {
            submitEdit();
        });
    }

    @Override
    protected EditMemoPresenter createPresenter() {
        return new EditMemoPresenter();
    }

    @Override
    public void submitEdit() {
        String memoContent = editTextContent.getText().toString();
        String memoTitle = editTextTitle.getText().toString();
        //TODO 传递参数给mPresenter.submitEdit
    }
}
