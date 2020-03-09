package com.bawei.wangyi20200309.Model;

import com.bawei.wangyi20200309.Contract.IHonePageContract;
import com.bawei.wangyi20200309.Utils.VolleyUtils;

import java.util.HashMap;

/**
 * m层
 */
public class HomePageModel implements IHonePageContract.IModel {
    @Override
    public void onLogin(String url, HashMap<String, String> map, final ILoginCallBack callBack) {
        VolleyUtils.getInstance().doPost(url, map, new VolleyUtils.ICallBack() {
            @Override
            public void Success(String json) {
                callBack.onSuccess(json);
            }

            @Override
            public void Error(String msg) {
                callBack.onError(msg);

            }
        });
    }
}
