package cqdz.com.genius.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.HomeActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class LoginActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.ed_tel)
    EditText ed_tel;
    @BindView(R.id.ed_pwd)
    EditText ed_pwd;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.tv_register)
    TextView tv_register;
    @BindView(R.id.tv_forget)
    TextView tv_forget;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("登录");
        tv_forget.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_register:
                startActivity(new Intent(mContext, RegisterActivity.class));
                break;
            case R.id.btn_login:
                if(TextUtils.isEmpty(ed_tel.getText().toString().trim()))
                {
                    mToast.showText("请输入手机号码");
                    return;
                }

                if(TextUtils.isEmpty(ed_pwd.getText().toString().trim()))
                {
                    mToast.showText("请输入密码");
                    return;
                }
                startActivity(new Intent(mContext, HomeActivity.class));
                break;
            case R.id.tv_forget:
                startActivity(new Intent(mContext, ForgetPwdActivity.class));
                break;
        }
    }
}
