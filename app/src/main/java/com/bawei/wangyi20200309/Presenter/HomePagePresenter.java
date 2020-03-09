package com.bawei.wangyi20200309.Presenter;

import com.bawei.wangyi20200309.Contract.IHonePageContract;
import com.bawei.wangyi20200309.Model.HomePageModel;
import com.bawei.wangyi20200309.base.BasePresenter;
import com.bawei.wangyi20200309.base.IBaseView;

import java.util.HashMap;

/**
 * p层
 */
public class HomePagePresenter  extends BasePresenter implements IHonePageContract.IPresenter {
     HomePageModel model;

    public HomePagePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void onLogin(String url, HashMap<String, String> map) {
        model.onLogin(url, map, new IHonePageContract.IModel.ILoginCallBack() {
            @Override
            public void onSuccess(String str) {
                IBaseView view = getView();
                if(view!=null&&view instanceof IHonePageContract.IView){
                    IHonePageContract.IView IView= (IHonePageContract.IView) view;
                    IView.onSuccess(str);
                }
            }

            @Override
            public void onError(String str) {
                IBaseView view = getView();
                if(view!=null&&view instanceof IHonePageContract.IView){
                    IHonePageContract.IView IView= (IHonePageContract.IView) view;
                    IView.onError(str);
                }
            }
        });

    }

    @Override
    protected void initModel() {
        model = new HomePageModel();

    }

}
