package com.bawei.wangyi20200309.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.wangyi20200309.R;

/**
 * 基类抽取
 */
public  abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        presenter= initPresenter();
        initView();
        initData();
    }
    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.decthView();
            presenter=null;
        }

    }

    protected abstract P initPresenter();

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();
}
