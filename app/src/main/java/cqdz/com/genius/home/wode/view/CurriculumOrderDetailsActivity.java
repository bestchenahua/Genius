package cqdz.com.genius.home.wode.view;

import android.text.TextUtils;
import android.widget.TextView;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class CurriculumOrderDetailsActivity extends MvpBaseActivity {
    String order_state;
    @BindView(R.id.tv_state)
    TextView tv_state;

    @Override
    protected int getLayout() {
        return R.layout.activity_curr_order_details;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        order_state = getIntent().getStringExtra("state");
        if (!TextUtils.isEmpty(order_state)) {
            if (order_state.equals("已取消")) {
                tv_state.setText("已取消");
            } else if (order_state.equals("待支付")) {
                tv_state.setText("等待付款");
            } else if (order_state.equals("已支付")) {
                tv_state.setText("支付成功");
            }
        }
    }
}
