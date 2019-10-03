package top.orange233.memorange.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import top.orange233.memorange.presenter.IPresenter;

public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    protected void initPresenter() {
        mPresenter=createPresenter();
        if(mPresenter!=null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if(mPresenter!=null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    protected abstract T createPresenter();

    protected abstract void init();
}
