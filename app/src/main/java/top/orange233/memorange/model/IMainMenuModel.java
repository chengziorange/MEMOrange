package top.orange233.memorange.model;

import java.util.List;

import top.orange233.memorange.bean.MemoBean;
import top.orange233.memorange.utils.Callback;

public interface IMainMenuModel extends IModel {

    void searchFor(String s, final Callback<List<MemoBean>, String> callback);
}
