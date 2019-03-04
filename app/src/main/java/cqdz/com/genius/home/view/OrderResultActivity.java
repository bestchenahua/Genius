package cqdz.com.genius.home.view;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class OrderResultActivity extends MvpBaseActivity {
    @BindView(R.id.btn_left)
    Button btn_left;

    @BindView(R.id.btn_right)
    Button btn_right;
    @BindView(R.id.iv_result)
    ImageView iv_result;
    @BindView(R.id.tv_result)
    TextView tv_result;

    @Override
    protected int getLayout() {
        return R.layout.activity_pay_result;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("支付结果");
        btn_right.setText("重新支付");
        tv_result.setText("支付失败");
        iv_result.setImageResource(R.drawable.pay_result_failed);
    }
}
