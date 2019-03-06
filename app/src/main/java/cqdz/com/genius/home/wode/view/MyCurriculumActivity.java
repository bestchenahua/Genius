package cqdz.com.genius.home.wode.view;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
@BindEventBus
public class MyCurriculumActivity extends MvpBaseActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<String> titles;
    List<Fragment> fragments;
    MyCurriculumActivity.MessageEvent messageEvent;
    @Override
    protected int getLayout() {
        return R.layout.activity_mycurriculum;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("我的课程");
        titles = new ArrayList<>();
        titles.add("语文");
        titles.add("数学");
        titles.add("英语");
        titles.add("家长课堂");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabIndicatorFullWidth(false);
        fragments = new ArrayList<>();
        for(int i = 0 ;i<titles.size();i++)
        {
            fragments.add(MyCurriculumFragment.getInstance(titles.get(i)));
        }
        initViewPager();
    }
    private void initViewPager()
    {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(messageEvent==null)
                {
                    messageEvent = new MyCurriculumActivity.MessageEvent(titles.get(i));
                }
                Logger.d("发送"+titles.get(i));
                EventBus.getDefault().postSticky(messageEvent);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setCurrentItem(0);
        if(messageEvent==null)
        {
            messageEvent = new MyCurriculumActivity.MessageEvent(titles.get(0));
        }
        EventBus.getDefault().postSticky(messageEvent);
    }
    @Subscribe
    public void onEvent(String event){
    }
    public class MessageEvent{
        private String message;
        public  MessageEvent(String message){
            this.message=message;
        }
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
