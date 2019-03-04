package cqdz.com.genius.home.view;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class OrderPayActivity extends MvpBaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_left)
    Button  btn_left;
    @BindView(R.id.btn_right)
    Button  btn_right;
    @Override
    protected int getLayout() {
        return R.layout.activity_pay_order;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("支付订单");
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_right:
                startActivity(new Intent(mContext,OrderResultActivity.class));
                break;
        }
    }
}
