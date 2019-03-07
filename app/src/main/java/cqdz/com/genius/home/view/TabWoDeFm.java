package cqdz.com.genius.home.view;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.view.MyCollectionActivity;
import cqdz.com.genius.home.wode.view.MyCourseSheetActivity;
import cqdz.com.genius.home.wode.view.MyCreditActivity;
import cqdz.com.genius.home.wode.view.MyCurriculumActivity;
import cqdz.com.genius.home.wode.view.MyErrorBookActivity;
import cqdz.com.genius.home.wode.view.MyFollowActivity;
import cqdz.com.genius.home.wode.view.MyLearningBeans2Activity;
import cqdz.com.genius.home.wode.view.MyLearningBeansActivity;
import cqdz.com.genius.home.wode.view.MyLearningCurrencyActivity;
import cqdz.com.genius.home.wode.view.MyLotteryActivity;
import cqdz.com.genius.home.wode.view.MyOrderActivity;
import cqdz.com.genius.home.wode.view.PersonalInfoActivity;
import cqdz.com.genius.home.wode.view.SettingActivity;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TabWoDeFm extends MvpBaseFragment implements View.OnClickListener {

    @BindView(R.id.linearLayout8)
    LinearLayout 个人信息;
    @BindView(R.id.ll_dindgan)
    LinearLayout 我的订单;
    @BindView(R.id.ll_wodekecheng)
    LinearLayout 我的课程;
    @BindView(R.id.ll_xuankedan)
    LinearLayout 我的选课单;
    @BindView(R.id.ll_errorbook)
    LinearLayout 我的错题本;
    @BindView(R.id.ll_guanzhu)
    LinearLayout 我的关注;
    @BindView(R.id.ll_setting)
    LinearLayout 设置;
    @BindView(R.id.ll_xuexidou)
    LinearLayout 学习豆;
    @BindView(R.id.ll_xuexib)
    LinearLayout 学习币;
    @BindView(R.id.ll_xuexidou2)
    LinearLayout 学习豆2;
    @BindView(R.id.ll_xuefen)
    LinearLayout 学分;
    @BindView(R.id.ll_jiangquan)
    LinearLayout 我的奖券;
    @BindView(R.id.ll_collection)
    LinearLayout 我的收藏;

    @Override
    protected int getLayout() {
        return R.layout.tab_wode_fm;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        个人信息.setOnClickListener(this);
        我的订单.setOnClickListener(this);
        我的课程.setOnClickListener(this);
        我的选课单.setOnClickListener(this);
        我的错题本.setOnClickListener(this);
        我的关注.setOnClickListener(this);
        设置.setOnClickListener(this);
        学习豆.setOnClickListener(this);
        学习币.setOnClickListener(this);
        学习豆2.setOnClickListener(this);
        学分.setOnClickListener(this);
        我的奖券.setOnClickListener(this);
        我的收藏.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearLayout8:
                startActivity(new Intent(mContext, PersonalInfoActivity.class));
                break;
            case R.id.ll_dindgan:
                startActivity(new Intent(mContext, MyOrderActivity.class));
                break;
            case R.id.ll_wodekecheng:
                startActivity(new Intent(mContext, MyCurriculumActivity.class));
                break;
            case R.id.ll_xuankedan:
                startActivity(new Intent(mContext, MyCourseSheetActivity.class));
                break;
            case R.id.ll_guanzhu:
                startActivity(new Intent(mContext, MyFollowActivity.class));
                break;
            case R.id.ll_setting:
                startActivity(new Intent(mContext, SettingActivity.class));
                break;
            case R.id.ll_errorbook:
                startActivity(new Intent(mContext, MyErrorBookActivity.class));
                break;
            case R.id.ll_xuexidou:
                startActivity(new Intent(mContext, MyLearningBeansActivity.class));
                break;
            case R.id.ll_xuexib:
                startActivity(new Intent(mContext, MyLearningCurrencyActivity.class));
                break;
            case R.id.ll_xuexidou2:
                startActivity(new Intent(mContext, MyLearningBeans2Activity.class));
                break;
            case R.id.ll_xuefen:
                startActivity(new Intent(mContext, MyCreditActivity.class));
                break;
            case R.id.ll_jiangquan:
                startActivity(new Intent(mContext, MyLotteryActivity.class));
                break;
            case R.id.ll_collection:
                startActivity(new Intent(mContext, MyCollectionActivity.class));
                break;
        }
    }
}
