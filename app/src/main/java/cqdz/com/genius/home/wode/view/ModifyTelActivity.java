package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ModifyTelActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_send)
    Button btn_send;
    @BindView(R.id.btn_done)
    Button btn_done;

    @BindView(R.id.ed_vercode)
    EditText ed_vercode;
    private CountDownTimer mTimer;

    @Override
    protected int getLayout() {
        return R.layout.activity_modifytel;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("身份验证");
        btn_done.setOnClickListener(this);
        btn_done.setEnabled(false);
        ed_vercode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(ed_vercode.getText().toString().trim()))
                {
                    btn_done.setBackgroundResource(R.drawable.rad5_50d8c0);
                    btn_done.setTextColor(Color.parseColor("#FFFFFF"));
                    btn_done.setEnabled(true);
                }
                else {
                    btn_done.setBackgroundResource(R.drawable.rad5_d2d2d2);
                    btn_done.setTextColor(Color.parseColor("#666666"));
                    btn_done.setEnabled(false);
                }
            }
        });

        btn_send.setOnClickListener(this);
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
                    btn_send.setBackgroundResource(R.drawable.rad5_50d8c0);
                    btn_send.setTextColor(Color.parseColor("#ffffff"));
                    btn_send.setText("获取验证码");
                }
            };
            mTimer.start();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                mToast.showShort("验证码已发送至您的手机");
                startCountDown();
                btn_send.setClickable(false);
                btn_send.setBackgroundResource(R.drawable.rad5_d2d2d2);
                btn_send.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.btn_done:
                startActivity(new Intent(mContext,ModifyTelActivity2.class));
                finish();
                break;
        }
    }
}
