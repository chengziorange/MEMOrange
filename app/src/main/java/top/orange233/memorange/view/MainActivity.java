package top.orange233.memorange.view;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import top.orange233.memorange.R;
import top.orange233.memorange.contract.MemoContract;
import top.orange233.memorange.presenter.MemoPresenter;
import top.orange233.memorange.utils.MemoAdapter;

public class MainActivity extends BaseMVPActivity<MemoPresenter> implements MemoContract.View {

    RecyclerView recyclerView;
    MemoAdapter memoAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        floatingActionButton = findViewById(R.id.floating_action_bar_add_memo);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(memoAdapter);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditMemoActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected MemoPresenter createPresenter() {
        return new MemoPresenter();
    }

    @Override
    public void addMemo() {
        //TODO 单击进入文字编辑界面
        mPresenter.addMemo();
    }

    @Override
    public void removeMemo() {
        //TODO 长按多选删除/弹出删除气泡
    }
}
