package com.bawei.wangyi20200309.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangyi20200309.base.App;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络工具类
 */
public class VolleyUtils {
    RequestQueue queue;
    //单例模式
    private VolleyUtils(){
        queue = Volley.newRequestQueue(App.getAppContext());
    }
    //静态内部类
    private static class SingleInstance{
        private static VolleyUtils INSTANCE=new VolleyUtils();
    }

    public static VolleyUtils getInstance() {
        return SingleInstance.INSTANCE;
    }
    //网络判断
    public boolean isNet(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if(info!=null){
            return true;
        }
        return false;
    }
    //接口回调
    public interface ICallBack{
        void Success(String json);
        void Error(String msg);
    }

    //get请求
    public void doGet(String url, final ICallBack callBack){
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               callBack.Success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.Error(error.getMessage());

            }
        });
        queue.add(request);
    }
    //post请求
    public void doPost(String url, final HashMap<String,String> map, final ICallBack callBack){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               callBack.Success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.Error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }


}
