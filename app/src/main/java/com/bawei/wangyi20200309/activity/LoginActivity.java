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
import com.bawei.wangyi20200309.bean.LogBean;
import com.bawei.wangyi20200309.bean.SBean;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements IHonePageContract.IView {
    private EditText et1;
    private EditText et2;
    private Button bt2;
    String path="http://mobile.bwstudent.com/small/user/v1/login";
    String str="http://mobile.bwstudent.com/small/user/v1/login?phone=13211114444&pwd=ww123456";

    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        bt2 = findViewById(R.id.bt2);
    }

    @Override
    protected void initData() {
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone  = et1.getText().toString();
                String pwd = et2.getText().toString();

                HashMap<String,String> map=new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                boolean net = VolleyUtils.getInstance().isNet(LoginActivity.this);
                if(net) {
                    VolleyUtils.getInstance().doPost(path, map, new VolleyUtils.ICallBack() {
                        @Override
                        public void Success(String json) {
                            Log.i("xxx",json);
                            Gson gson = new Gson();
                            SBean bean = gson.fromJson(json, SBean.class);
                            SBean.ResultBean result = bean.getResult();
                            String headPic = result.getHeadPic();
                            String nickName = result.getNickName();
                            String message = bean.getMessage();
                            Toast.makeText(LoginActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("name",nickName);
                            intent.putExtra("pic",headPic);
                            startActivity(intent);
                        }

                        @Override
                        public void Error(String msg) {
                            Log.i("xxx",msg);

                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this, "无网络", Toast.LENGTH_SHORT).show();
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
