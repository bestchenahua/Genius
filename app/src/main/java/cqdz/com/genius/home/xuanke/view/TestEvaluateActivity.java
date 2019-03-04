package cqdz.com.genius.home.xuanke.view;

import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 考试评价
 */
public class TestEvaluateActivity extends MvpBaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_test_evaluate;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("评价");
    }
}
