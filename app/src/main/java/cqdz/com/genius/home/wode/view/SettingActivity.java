package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.customer.CustomerConfirmDialog;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class SettingActivity extends MvpBaseActivity implements View.OnClickListener {

    @BindView(R.id.ll_modifyTel)
    LinearLayout 修改手机号;
    @BindView(R.id.ll_setPwd)
    LinearLayout 设置密码;
    @BindView(R.id.ll_getVersion)
    LinearLayout 检测新版本;
    @BindView(R.id.btn_loginOut)
    Button btn_loginOut;


    CustomerConfirmDialog confirmDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("设置");
        修改手机号.setOnClickListener(this);
        设置密码.setOnClickListener(this);
        检测新版本.setOnClickListener(this);
        btn_loginOut.setOnClickListener(this);
        confirmDialog = new CustomerConfirmDialog(mContext, 101, "退出确认", "确定退出此账号?", "退出", "取消", new CustomerConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                mToast.showText(isPositive + "");
                confirmDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_modifyTel:
                startActivity(new Intent(mContext, ModifyTelActivity.class));
                break;
            case R.id.ll_setPwd:
                startActivity(new Intent(mContext, SetPwdActivity.class));
                break;
            case R.id.ll_getVersion:
                mToast.showText("当前已经是最新版本啦!");
                break;
            case R.id.btn_loginOut:
                confirmDialog.show();
                break;
        }
    }
}
