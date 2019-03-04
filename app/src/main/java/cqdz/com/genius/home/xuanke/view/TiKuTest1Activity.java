package cqdz.com.genius.home.xuanke.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TiKuTest1Activity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_start)
    Button btn_start;
    @Override
    protected int getLayout() {
        return R.layout.activity_tiku_test;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("测试");
        btn_start.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_start:
                startActivity(new Intent(mContext,TiKuTest2Activity.class));
                break;
        }
    }
}
