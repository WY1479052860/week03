package com.bawei.wangyi20200309.activity;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangyi20200309.Contract.IHonePageContract;
import com.bawei.wangyi20200309.Presenter.HomePagePresenter;
import com.bawei.wangyi20200309.R;
import com.bawei.wangyi20200309.Utils.VolleyUtils;
import com.bawei.wangyi20200309.base.BaseActivity;
import com.bawei.wangyi20200309.base.BasePresenter;
import com.bawei.wangyi20200309.bean.RegBean;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements IHonePageContract.IView {

    private EditText et1;
    private EditText et2;
    private Button bt1;
    String path="http://mobile.bwstudent.com/small/user/v1/register";
    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        bt1 = findViewById(R.id.bt1);
    }

    @Override
    protected void initData() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et1.getText().toString();
                String pwd   = et2.getText().toString();

                HashMap<String,String> map=new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);

                boolean net = VolleyUtils.getInstance().isNet(RegisterActivity.this);
                if(net){
                    VolleyUtils.getInstance().doPost(path, map, new VolleyUtils.ICallBack() {
                        @Override
                        public void Success(String json) {
                            Log.i("xxx",json);
                            Gson gson = new Gson();
                            RegBean bean = gson.fromJson(json, RegBean.class);
                            String message = bean.getMessage();
                            Toast.makeText(RegisterActivity.this, ""+message, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void Error(String msg) {
                            Log.i("xxx",msg);

                        }
                    });

                }else{
                    Toast.makeText(RegisterActivity.this, "无网络", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public void onSuccess(String str) {


    }

    @Override
    public void onError(String str) {

    }
}
