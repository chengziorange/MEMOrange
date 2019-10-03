package top.orange233.memorange.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.orange233.memorange.R;
import top.orange233.memorange.bean.MemoBean;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    private List<MemoBean> mMemoBeanList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            //TODO 添加item的布局
        }
    }

    public MemoAdapter(List<MemoBean> memoBeanList) {
        this.mMemoBeanList = memoBeanList;
    }

    public void addMemo(int position,MemoBean memoBean) {
        mMemoBeanList.add(position,memoBean);
        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    public void removeMemo(int position) {
        mMemoBeanList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_memo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemoBean memoBean = mMemoBeanList.get(position);
        //TODO 设置item里的元素
    }

    @Override
    public int getItemCount() {
        return mMemoBeanList.size();
    }
}
