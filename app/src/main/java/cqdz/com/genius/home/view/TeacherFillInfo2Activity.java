package cqdz.com.genius.home.view;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TeacherFillInfo2Activity extends MvpBaseActivity {
    @BindView(R.id.btn_login)
    Button btn_login;
    @Override
    protected int getLayout() {
        return R.layout.activity_fillteacherdata2;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("填写资料");
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,TeacherRegisterResultActivity.class));
            }
        });
    }

}
