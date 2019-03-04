package cqdz.com.genius.home.view;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.cpoopc.scrollablelayoutlib.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TeacherInfoActivity extends MvpBaseActivity {

    @BindView(R.id.title)
    LinearLayout ll_title;

    @BindView(R.id.scrollablelayout)
    ScrollableLayout scrollablelayout;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    List<String>titles;
    FragmentPagerAdapter adapterVP;
    List<Fragment> fragmentList;
    @Override
    protected int getLayout() {
        return R.layout.activity_teacher_info;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("张么么");
        initTabLayout();
        initOnClickScroll();
        initFragment();
    }

    private void initTabLayout() {
        tab.setTabIndicatorFullWidth(false);
        titles = new ArrayList<>();
        titles.add("介绍");
        titles.add("课程");
        titles.add("评价");
//        for (int i = 0; i < titles.size(); i++) {
//            tab.addTab(tab.newTab().setText(titles.get(i)));
//        }

    }
    /*滚动监听*/
    private void initOnClickScroll() {
        scrollablelayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int i, int i1) {
                float alphaTop = (float) i / i1 * 180;
                LinearLayout.LayoutParams lp = new
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                lp.setMargins(0, (int) alphaTop, 0, 0);
                tab.setLayoutParams(lp);
            }
        });
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        TeacherIntroduceFm fragment1 = new TeacherIntroduceFm();
        TeacherCurriculumFm fragment2 = new TeacherCurriculumFm();
        TeacherIntroduceFm fragment3 = new TeacherIntroduceFm();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        adapterVP = new ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapterVP);
        tab.setupWithViewPager(vp);
        scrollablelayout.getHelper().setCurrentScrollableContainer((TeacherIntroduceFm) fragmentList.get(0));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    scrollablelayout.getHelper().setCurrentScrollableContainer((TeacherIntroduceFm) fragmentList.get(i));
                } else if (i == 1) {
                    scrollablelayout.getHelper().setCurrentScrollableContainer((TeacherCurriculumFm) fragmentList.get(i));
                }else if (i == 2) {
                    scrollablelayout.getHelper().setCurrentScrollableContainer((TeacherIntroduceFm) fragmentList.get(i));
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
