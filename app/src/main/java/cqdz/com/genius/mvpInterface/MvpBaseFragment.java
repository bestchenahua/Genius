package cqdz.com.genius.mvpInterface;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cqdz.com.genius.customer.MyToast;

/**
 * MVP activity基类
 */
public abstract class MvpBaseFragment<T extends MvpPresenter> extends Fragment implements MvpView {
    public MyToast mToast;
    private ProgressDialog mProgressDialog;
    private Unbinder unbinder;
    public T mPresenter;
    public FragmentActivity mActivity;
    public Context mContext;
    public View mView;
    public Bundle mSavedInstanceState;
    @Override
    public void onAttach(Context context) {
        mActivity = (FragmentActivity) context;
        mContext = context;
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSavedInstanceState= savedInstanceState;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
        this.init();
    }

    @Override
    public void startActivity(Intent intent) {
        //把默认启动模式改为singleTop
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        super.startActivity(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null)
            mPresenter.detachView();
    }

    protected void init() {
        /*
         *初始化自定义toast
         **/
//        mToast = new ToastUtil(mContext);
        mToast = new MyToast(mContext);
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("正在请求数据...");
        mProgressDialog.setCancelable(false);
        mPresenter=getPresenter();
        if(mPresenter!=null)
        {
            mPresenter.attachView(this);
        }
        initMonitorAndData();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
    }
    protected abstract int getLayout();
    protected abstract T getPresenter();
    protected abstract void initMonitorAndData();
    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }
    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    public void showToast(String msg) {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mToast.showText(msg);
    }
    @Override
    public void showErr(String msg) {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        showToast(msg);
    }
    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onComplete() {

    }
}
