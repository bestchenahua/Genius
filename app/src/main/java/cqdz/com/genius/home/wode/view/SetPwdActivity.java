package cqdz.com.genius.home.wode.view;

import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class SetPwdActivity extends MvpBaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_setpwd;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("设置密码");
    }
}
