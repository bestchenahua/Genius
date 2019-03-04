package cqdz.com.genius;
import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import com.orhanobut.logger.Logger;

import cqdz.com.genius.home.HomeActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SharedPreferenceUtil;

import static cqdz.com.genius.utils.SharedPreferenceUtil.SP_ISFIRST;

public class MainActivity extends MvpBaseActivity {
    //是否是第一次使用
    private boolean isFirst;

    Handler handler;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        Integer time = 1000;    //设置等待时间，单位为毫秒
        handler = new Handler();
        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirst = SharedPreferenceUtil.getBoolean(SP_ISFIRST);
                /**
                 *如果用户不是第一次使用则直接调转到显示界面,否则调转到引导界面
                 */
                if (isFirst) {
                    getPermissions();
                } else {
                    Logger.d("1");
//            startActivity(new Intent(mContext, HandlerActivity.class));
//                    startActivity(new Intent(mContext, LoginActivity.class));
                    startActivity(new Intent(mContext, HomeActivity.class));
                    finish();
                }
            }
        }, time);
    }

    public void getPermissions()
    {
        //需要动态申请的权限
//        group:android.permission-group.CONTACTS
//        permission:android.permission.WRITE_CONTACTS
//        permission:android.permission.GET_ACCOUNTS
//        permission:android.permission.READ_CONTACTS
//
//        group:android.permission-group.PHONE
//        permission:android.permission.READ_CALL_LOG
//        permission:android.permission.READ_PHONE_STATE
//        permission:android.permission.CALL_PHONE
//        permission:android.permission.WRITE_CALL_LOG
//        permission:android.permission.USE_SIP
//        permission:android.permission.PROCESS_OUTGOING_CALLS
//        permission:com.android.voicemail.permission.ADD_VOICEMAIL
//
//        group:android.permission-group.CALENDAR
//        permission:android.permission.READ_CALENDAR
//        permission:android.permission.WRITE_CALENDAR
//
//        group:android.permission-group.CAMERA
//        permission:android.permission.CAMERA
//
//        group:android.permission-group.SENSORS
//        permission:android.permission.BODY_SENSORS
//
//        group:android.permission-group.LOCATION
//        permission:android.permission.ACCESS_FINE_LOCATION
//        permission:android.permission.ACCESS_COARSE_LOCATION
//
//        group:android.permission-group.STORAGE
//        permission:android.permission.READ_EXTERNAL_STORAGE
//        permission:android.permission.WRITE_EXTERNAL_STORAGE
//
//        group:android.permission-group.MICROPHONE
//        permission:android.permission.RECORD_AUDIO
//
//        group:android.permission-group.SMS
//        permission:android.permission.READ_SMS
//        permission:android.permission.RECEIVE_WAP_PUSH
//        permission:android.permission.RECEIVE_MMS
//        permission:android.permission.RECEIVE_SMS
//        permission:android.permission.SEND_SMS
//        permission:android.permission.READ_CELL_BROADCASTS
        rxPermissions
                .requestEachCombined(Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe(permission -> { // will emit 1 Permission object
                    if (permission.granted) {
                        // 所有权限都被同意
//                        startActivity(new Intent(mContext, GuideActivity.class));
                        startActivity(new Intent(mContext, HomeActivity.class));
                        finish();
                        //保存是否第一次登陆
                        SharedPreferenceUtil.setBoolean(SP_ISFIRST,false);
                    }
                    else if (permission.shouldShowRequestPermissionRationale)
                    {
                        //有至少一个权限没有同意
//                        startActivity(new Intent(mContext, GuideActivity.class));
                        startActivity(new Intent(mContext, HomeActivity.class));
                        finish();

                        //保存是否第一次登陆
                        SharedPreferenceUtil.setBoolean(SP_ISFIRST,false);
                    }
                    else {
                        //有至少一个权限没有同意且勾选了不在提示
//                        startActivity(new Intent(mContext, GuideActivity.class));
                        startActivity(new Intent(mContext, HomeActivity.class));
                        finish();
                        //保存是否第一次登陆
                        SharedPreferenceUtil.setBoolean(SP_ISFIRST,false);

                    }
                });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
