package cqdz.com.genius.login.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ForgetPwdActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.ed_tel)
    EditText ed_tel;
    @BindView(R.id.ed_pwd)
    EditText ed_pwd;
    @BindView(R.id.ed_pwd2)
    EditText ed_pwd2;
    @BindView(R.id.ed_code)
    EditText ed_code;
    @BindView(R.id.btn_register)
    Button btn_register;
    @BindView(R.id.btn_send)
    Button btn_send;
    private CountDownTimer mTimer;
    @Override
    protected int getLayout() {
        return R.layout.activity_forget;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("忘记密码");
        btn_register.setOnClickListener(this);
        btn_send.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_read:
                startActivity(new Intent(mContext, ReadClauseActivity.class));
                break;
            case R.id.btn_register:
                if(TextUtils.isEmpty(ed_tel.getText().toString().trim()))
                {
                    mToast.showText("请输入手机号码");
                    return;
                }

                if(TextUtils.isEmpty(ed_code.getText().toString().trim()))
                {
                    mToast.showText("请输入验证码");
                    return;
                }

                if(TextUtils.isEmpty(ed_pwd.getText().toString().trim()))
                {
                    mToast.showText("请输入密码");
                    return;
                }

                if(TextUtils.isEmpty(ed_pwd2.getText().toString().trim()))
                {
                    mToast.showText("请输入确认密码");
                    return;
                }
                startActivity(new Intent(mContext, RegisterResultActivity.class));
                break;
            case R.id.btn_send:
                if(TextUtils.isEmpty(ed_tel.getText().toString().trim()))
                {
                    mToast.showText("请输入手机号码");
                    return;
                }

                mToast.showShort("验证码已发送至您的手机");
                startCountDown();
                btn_send.setClickable(false);
                btn_send.setBackgroundResource(R.drawable.bor50d8c0_rad2_f8f8f8);
                break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }
    public void startCountDown() {
        if (mTimer == null) {
            mTimer = new CountDownTimer((long) (60 * 1000), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (!mActivity.isFinishing()) {
                        int remainTime = (int) (millisUntilFinished / 1000L);
                        btn_send.setText(remainTime + "s后再次获取");
                    }
                }
                @Override
                public void onFinish() {
                    btn_send.setClickable(true);
                    btn_send.setBackgroundResource(R.drawable.bor50d8c0_rad2_ffffff);
                    btn_send.setText("获取验证码");
                    mTimer=null;
                }
            };
            mTimer.start();
        }
    }
}
