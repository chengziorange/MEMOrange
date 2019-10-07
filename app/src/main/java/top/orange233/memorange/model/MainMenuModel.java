package top.orange233.memorange.model;

import android.util.Log;

import org.litepal.LitePal;

import java.util.List;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.utils.Callback;

public class MainMenuModel implements IMainMenuModel {
    @Override
    public void searchFor(String s, final Callback<List<MemoBean>, String> callback) {
        List<MemoBean> tmpList = LitePal
                .where("title like ? or content like ?", "%" + s + "%", "%" + s + "%")
                .order("number")
                .find(MemoBean.class);
        Log.d("TAG","MainMenuModel tmpList size = "+tmpList.size());
        callback.onSuccess(tmpList);
    }
}