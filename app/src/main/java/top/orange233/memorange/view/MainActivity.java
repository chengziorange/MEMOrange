package top.orange233.memorange.view;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import top.orange233.memorange.R;
import top.orange233.memorange.contract.MemoContract;
import top.orange233.memorange.presenter.MemoPresenter;
import top.orange233.memorange.utils.MemoAdapter;
import top.orange233.memorange.utils.MyConstants;

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
            intent.putExtra(MyConstants.KEY_EDIT_MEMO_BEHAVIOR, MyConstants.BEHAVIOR_ADD_NEW_MEMO);
            intent.putExtra(MyConstants.KEY_MEMO_ID, MyConstants.FLAG_ADD_NEW_MEMO);
            startActivity(intent);
        });
    }

    @Override
    protected MemoPresenter createPresenter() {
        return new MemoPresenter();
    }

    @Override
    public void addMemo() {
        //TODO 单击右下角按钮触发
    }

    @Override
    public void editMemo() {
        //TODO 点击Item后触发
        Intent intent = new Intent(this, EditMemoActivity.class);
        intent.putExtra(MyConstants.KEY_EDIT_MEMO_BEHAVIOR, MyConstants.BEHAVIOR_EDIT_EXISTING_MEMO);
        intent.putExtra(MyConstants.KEY_MEMO_ID, "REPLACE_HERE_WITH_MEMO_ID");
        startActivity(intent);
    }

    @Override
    public void removeMemo() {
        //TODO 长按Item多选删除/弹出删除气泡
    }
}
