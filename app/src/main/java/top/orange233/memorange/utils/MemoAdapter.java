package top.orange233.memorange.utils;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import top.orange233.memorange.R;
import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.view.EditMemoActivity;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MyViewHolder> {

    private List<MemoBean> mMemoBeanList;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        View memoItemView;
        TextView tvMemoTitle;
        TextView tvMemoContent;
        TextView tvMemoDate;

        public MyViewHolder(View view) {
            super(view);
            memoItemView = view;
            tvMemoTitle = view.findViewById(R.id.tv_title);
            tvMemoContent = view.findViewById(R.id.tv_content);
            tvMemoDate = view.findViewById(R.id.tv_date);
        }
    }

    public MemoAdapter() {
        if (!(LitePal.isExist(MemoBean.class))) {
            this.mMemoBeanList = new ArrayList<>();
        } else {
            this.mMemoBeanList = LitePal.where("number > ?", "-1").order("number").find(MemoBean.class);
        }
    }

    public MemoAdapter(List<MemoBean> mMemoBeanList) {
        this.mMemoBeanList = mMemoBeanList;
    }

    public void addMemo() {
        List<MemoBean> tmpList = LitePal.where("number > ?", "-1").order("number").find(MemoBean.class);
        for (int i = 0; i < tmpList.size(); i++) {
            tmpList.get(i).setNumber(i + 1);
            tmpList.get(i).save();
        }
        MemoBean memoBean = new MemoBean();
        memoBean.setNumber(0);
        memoBean.save();
        memoBean = LitePal.where("number = ?", "0").find(MemoBean.class).get(0);
        mMemoBeanList.clear();
        mMemoBeanList.add(memoBean);
        mMemoBeanList.addAll(tmpList);
        notifyItemInserted(0);
        notifyDataSetChanged();
    }

    public void removeMemo(int position) {
        mMemoBeanList = LitePal.order("number").find(MemoBean.class);
        Log.d("REMOVE", "mList size before " + mMemoBeanList.size());
        mMemoBeanList.get(position).delete();
        mMemoBeanList.remove(position);
        Log.d("REMOVE", "position " + position);
        Log.d("REMOVE", "mList size after " + mMemoBeanList.size());
        for (int i = 0; i < mMemoBeanList.size(); i++) {
            mMemoBeanList.get(i).setNumber(i);
            mMemoBeanList.get(i).save();
        }
        updateListChange();
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_memo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MemoBean memoBean = mMemoBeanList.get(position);
        holder.tvMemoTitle.setText(memoBean.getTitle());
        holder.tvMemoContent.setText(memoBean.getContent());
        holder.tvMemoDate.setText(memoBean.getDate());

        holder.memoItemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EditMemoActivity.class);
            Log.d("TAG", "pos = " + holder.getAdapterPosition());
            int index = mMemoBeanList.get(holder.getAdapterPosition()).getNumber();
            Log.d("TAG", "index = " + index);
            Log.d("TAG", "index2 = " + mMemoBeanList.get(holder.getAdapterPosition()).getContent());
            intent.putExtra(MyConstants.KEY_MEMO_ID, index);
            v.getContext().startActivity(intent);
        });

        holder.memoItemView.setOnLongClickListener(v -> {
            initPopWindow(v, holder);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return mMemoBeanList.size();
    }

    public void updateListChange() {
        mMemoBeanList = LitePal.order("number").find(MemoBean.class);
    }

    public void showSearchResult(List<MemoBean> searchResultList) {
        mMemoBeanList = searchResultList;
    }

    // ctrl c v 大法
    private void initPopWindow(View v, MyViewHolder holder) {
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.popup_delete, null, false);
        Button btnDelete = view.findViewById(R.id.btn_popup_delete);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setAnimationStyle(R.anim.anim_popup_delete);  //设置加载动画

        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor((view1, event) -> {
            // 这里如果返回true的话，touch事件将被拦截
            // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            return false;
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效


        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popupWindow.showAsDropDown(v, 150, -233);

        //设置popupWindow里的按钮的事件
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeMemo(holder.getAdapterPosition());
                popupWindow.dismiss();
            }
        });
    }
}
