package cqdz.com.genius.login.view;

import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ReadClauseActivity extends MvpBaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_readclause;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("使用条款与隐私政策");
    }
}
