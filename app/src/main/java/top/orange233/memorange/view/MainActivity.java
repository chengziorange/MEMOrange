package top.orange233.memorange.view;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import top.orange233.memorange.R;
import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.contract.MainMenuContract;
import top.orange233.memorange.presenter.MainMenuPresenter;
import top.orange233.memorange.utils.MemoAdapter;
import top.orange233.memorange.utils.MyConstants;

public class MainActivity extends BaseMVPActivity<MainMenuPresenter> implements MainMenuContract.View {

    RecyclerView recyclerView;
    EditText editTextSearchBar;
    MemoAdapter memoAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparent(this);
        StatusBarUtil.setLightMode(this);
        recyclerView = findViewById(R.id.recycler_view);
        editTextSearchBar = findViewById(R.id.et_search_bar);
        floatingActionButton = findViewById(R.id.floating_action_bar_add_memo);

        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        memoAdapter = new MemoAdapter();
        recyclerView.setAdapter(memoAdapter);

        floatingActionButton.setOnClickListener(v -> {
            memoAdapter.addMemo();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(this, EditMemoActivity.class);
            intent.putExtra(MyConstants.KEY_MEMO_ID, MyConstants.FLAG_ADD_NEW_MEMO);
            startActivity(intent);
        });

        editTextSearchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s != null) {
                    Log.d("TAG", "text watcher: s != null");
                    mPresenter.searchFor(s.toString());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.searchFor(s.toString());
            }
        });
    }

    @Override
    public void showSearchResultSuccess(List<MemoBean> memoBeans) {
        memoAdapter.showSearchResult(memoBeans);
        memoAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ("".equals(editTextSearchBar.getText().toString())) {
            memoAdapter.updateListChange();
            memoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected MainMenuPresenter createPresenter() {
        return new MainMenuPresenter();
    }
}
