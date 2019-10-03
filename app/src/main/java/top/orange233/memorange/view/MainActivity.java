package top.orange233.memorange.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import top.orange233.memorange.R;
import top.orange233.memorange.contract.MemoContract;
import top.orange233.memorange.presenter.MemoPresenter;
import top.orange233.memorange.utils.MemoAdapter;

public class MainActivity extends BaseMVPActivity<MemoPresenter> implements MemoContract.View {

    RecyclerView recyclerView;
    MemoAdapter memoAdapter;

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(memoAdapter);
    }

    @Override
    protected MemoPresenter createPresenter() {
        return new MemoPresenter();
    }

    @Override
    public void addMemo() {
        //TODO 单击进入Fragment，文字编辑界面
        mPresenter.addMemo();
    }

    @Override
    public void removeMemo() {
        //TODO 长按多选删除/弹出删除气泡
    }
}
