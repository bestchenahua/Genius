package cqdz.com.genius.home.view;

import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class EditAddressActivity extends MvpBaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_edit_address;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("修改地址");
    }
}
