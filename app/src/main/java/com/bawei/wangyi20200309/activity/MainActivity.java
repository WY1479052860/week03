package com.bawei.wangyi20200309.activity;


import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangyi20200309.Contract.IHonePageContract;
import com.bawei.wangyi20200309.Presenter.HomePagePresenter;
import com.bawei.wangyi20200309.R;
import com.bawei.wangyi20200309.base.BaseActivity;
import com.bawei.wangyi20200309.base.BasePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity{


    private TextView tv_name;
    private ImageView iv;

    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tv_name = findViewById(R.id.tv_name);
        iv = findViewById(R.id.iv);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pic = intent.getStringExtra("pic");
        tv_name.setText(name);
        Glide.with(MainActivity.this).load(pic).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);


    }

}
