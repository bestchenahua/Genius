package cqdz.com.genius.mvpInterface;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cqdz.com.genius.R;
import cqdz.com.genius.app.Genius;
import cqdz.com.genius.customer.MyToast;

/**
 * MVP activity基类
 */
public abstract class MvpBaseActivity<T extends MvpPresenter> extends AppCompatActivity implements MvpView {
    public MyToast mToast;
    public RxPermissions rxPermissions = new RxPermissions(this);
    private ProgressDialog mProgressDialog;
    private Unbinder unbinder;
    public T mPresenter;
    public FragmentActivity mActivity;
    public Context mContext;

    public TextView action_bar_title;
    public TextView action_bar_right;

    @Override
    public void startActivity(Intent intent) {
        //把默认启动模式改为singleTop
        if(intent.getFlags()!=Intent.FLAG_ACTIVITY_CLEAR_TASK)
        {
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }
        super.startActivity(intent);
    }
    /**
     * 界面设置状态栏字体颜色
     */

    private void setAndroidNativeLightStatusBar(boolean dark) {
        View decor = mActivity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//继承AppCompatActivity使用
        setContentView(getLayout());
        /**
         * 强制竖屏
         */
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        /*
         *透明状态栏
         */

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
        mActivity = this;
        setAndroidNativeLightStatusBar(true);
        mContext=this;
        rxPermissions = new RxPermissions(mActivity);
        action_bar_title = findViewById(R.id.action_bar_title);
        action_bar_right = findViewById(R.id.action_bar_right);
        /*
         *初始化自定义toast
         **/
        mToast = new MyToast(mContext);
        unbinder = ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在请求数据...");
        mProgressDialog.setCancelable(false);
        mPresenter=getPresenter();
        if(mPresenter!=null)
        {
            mPresenter.attachView(this);
        }
        Genius.getInstance().addActivity(this);
        initMonitorAndData();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null)
            mPresenter.detachView();
        Genius.getInstance().removeActivity(mActivity);
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
        mToast.showText(msg+"");
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

    public void goBack(View view) {
        finish();
    }
}
