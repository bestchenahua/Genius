package cqdz.com.genius.home.view;

import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class AddNewAddressActivity extends MvpBaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_addnew_address;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("新建地址");
    }
}
