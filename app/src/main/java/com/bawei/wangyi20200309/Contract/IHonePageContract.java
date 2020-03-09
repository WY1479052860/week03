package com.bawei.wangyi20200309.Contract;

import java.util.HashMap;

/**
 * 契约类
 */
public interface IHonePageContract {
    //View
    interface IView{
        void onSuccess(String str);
        void onError(String str);
    }
    interface IPresenter{
        void onLogin(String url, HashMap<String,String> map);
    }
    interface IModel{
        void onLogin(String url, HashMap<String,String> map,ILoginCallBack callBack);

        interface ILoginCallBack{
            void onSuccess(String str);
            void onError(String str);
        }

    }

}
