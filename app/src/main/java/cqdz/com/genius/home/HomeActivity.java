package cqdz.com.genius.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.view.TabShangChengFm;
import cqdz.com.genius.home.view.TabWoDeFm;
import cqdz.com.genius.home.view.TabXuanKeFm;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

@BindEventBus
public class HomeActivity extends MvpBaseActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    List<Fragment> fragments;
    @BindView(R.id.frame)
    FrameLayout frameLayout;
    int showPosition = 0;
    HomeMessageEvent messageEvent;
    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }
    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        navigation.setItemIconTintList(null);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        switchFragment(0);
                        break;
                    case R.id.navigation_circle:
                        switchFragment(1);
                        break;
                    case R.id.navigation_mine:
                        switchFragment(2);
                        break;
//                    case R.id.navigation_nearby:
//                        if(messageEvent==null)
//                        {
//                            messageEvent = new HomeMessageEvent("getLocation");
//                        }
//                        EventBus.getDefault().postSticky(messageEvent);
//                        switchFragment(2);
//                        break;
//                    case R.id.navigation_mine:
//                        switchFragment(3);
////                        transaction.replace(R.id.frame, fragments.get(3)).commit();
//                        break;

                }

                return true;
            }
        });
        fragments = new ArrayList<>();
        fragments.add(new TabXuanKeFm());
        fragments.add(new TabShangChengFm());
        fragments.add(new TabWoDeFm());

//        fragments.add(new TabCircleFm());
//        fragments.add(new TabNearbyStore());
//        fragments.add(new TabMyFm());
        FragmentManager manager;
        FragmentTransaction transaction ;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        for(int i = 0 ;i<fragments.size();i++)
        {
            transaction.add(R.id.frame, fragments.get(i));
            if(showPosition!=i)
            {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }
    public void switchFragment(int position)
    {
        FragmentManager manager;
        FragmentTransaction transaction ;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        for(int i = 0 ;i<fragments.size();i++)
        {

            if(position==i)
            {
                transaction.show(fragments.get(i));
            }
            else
            {
                transaction.hide(fragments.get(i));
            }

        }
        transaction.commit();
    }
    @Subscribe
    public void onEvent(String event){
    }
    public class HomeMessageEvent{
        private String message;
        public  HomeMessageEvent(String message){
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
