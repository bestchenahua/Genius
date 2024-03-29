package cqdz.com.genius.mvpInterface;

import cqdz.com.genius.utils.NetUtils;

/**
 * MVP Presenter 基类
 * @param <V 需绑定的MvpView的子类约束>
 */
public class MvpPresenter<V extends MvpView>{
    /**
     * 绑定的view
     */
    private V mvpView;
    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接 增加检查网络连接
     */
    public boolean isViewAttached(){
        if(!NetUtils.checkNetWork())
        {
            getView().showToast("网络连接不可用");
            return false;
        }
        else {
            return mvpView != null;
        }
    }
    /**
     * 获取连接的view
     */
    public V getView(){
        return mvpView;
    }

}
