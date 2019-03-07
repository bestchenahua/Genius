package cqdz.com.genius.home.wode.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyCollectionActivity extends MvpBaseActivity
{
    @BindView(R.id.tl_1)
    SegmentTabLayout tabLayout_1;
    List<Fragment> fragments;
    @BindView(R.id.frame)
    FrameLayout frameLayout;
    int showPosition = 0;
    @Override
    protected int getLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        String[] mTitles = {"商品", "店铺"};
        tabLayout_1.setTabData(mTitles);
        tabLayout_1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        fragments = new ArrayList<>();
        fragments.add(new CollectionCommodityFm());
        fragments.add(new CollectionShopFm());
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
}
