package cqdz.com.genius.home.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class FillOrderActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_sub)
    Button btn_sub;
    @BindView(R.id.ll_addr)
    LinearLayout ll_addr;

    @Override
    protected int getLayout() {
        return R.layout.activity_fillorder;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("填写订单");
        btn_sub.setOnClickListener(this);
        ll_addr.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_sub:
                break;
            case R.id.ll_addr:
                startActivity(new Intent(mContext,ChooseAddressActivity.class));
                break;
        }
    }
}
