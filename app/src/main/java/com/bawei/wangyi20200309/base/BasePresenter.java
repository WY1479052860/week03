package com.bawei.wangyi20200309.base;

import java.lang.ref.WeakReference;

/**
 * BasePresenter
 */
public  abstract class BasePresenter <V extends IBaseView> {
    private WeakReference<V> weakReference;

    public BasePresenter(V v) {
        weakReference= new WeakReference<>(v);
        initModel();
    }

    protected abstract void initModel();
    public V getView(){
        if(weakReference!=null){
            weakReference.get();
        }
        return null;
    }
    public void decthView(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

}
