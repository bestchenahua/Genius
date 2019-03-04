package cqdz.com.genius.home.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.customer.GradeChooseDialog;
import cqdz.com.genius.home.xuanke.view.TabXuanKeChildDianB;
import cqdz.com.genius.home.xuanke.view.TabXuanKeChildSuc;
import cqdz.com.genius.home.xuanke.view.TabXuanKeChildTiKu;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SizeTransform;

@BindEventBus
public class TabXuanKeFm extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.grade)
    TextView grade;
    @BindView(R.id.frame)
    FrameLayout frameLayout;
    @BindView(R.id.ic_menu1)
    ImageView ic_menu1;
    @BindView(R.id.ic_menu2)
    ImageView ic_menu2;
    @BindView(R.id.ic_menu3)
    ImageView ic_menu3;
    @BindView(R.id.ic_menu4)
    ImageView ic_menu4;
    List<ImageView> ic_menus;
    List<String> titles;
    GradeChooseDialog gradeDialog;
    List<Fragment> fragments;
    int showPosition = 0;
    TabHomeMessageEvent messageEvent;
    @Override
    protected int getLayout() {
        return R.layout.tab_home_fm;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        grade.setOnClickListener(this);
        grade.setText("一年级");
        ic_menu1.setOnClickListener(this);
        ic_menu2.setOnClickListener(this);
        ic_menu3.setOnClickListener(this);
        ic_menu4.setOnClickListener(this);
        ic_menus = new ArrayList<>();
        ic_menus.add(ic_menu1);
        ic_menus.add(ic_menu2);
        ic_menus.add(ic_menu3);
        ic_menus.add(ic_menu4);
        initTabLayout();
        fragments = new ArrayList<>();
        fragments.add(new TabXuanKeChildSuc());
        fragments.add(new TabXuanKeChildDianB());
        fragments.add(new TabXuanKeChildTiKu());

        FragmentManager manager;
        FragmentTransaction transaction ;
        manager = getChildFragmentManager();
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
        sendMessage();
    }

    private void initTabLayout() {
        titles = new ArrayList<>();
        titles.add("语文");
        titles.add("数学");
        titles.add("英语");
        titles.add("艺体");
        titles.add("家长课堂");
        for (int i = 0; i < titles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Logger.d(titles.get(tab.getPosition())+"onTabSelected");
                sendMessage();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    public void selectICMenu(View v) {
        for (int i = 0; i < ic_menus.size(); i++) {
            if (v.getId() == ic_menus.get(i).getId()) {
                ic_menus.get(i).setLayoutParams(new LinearLayout.LayoutParams(SizeTransform.dip2px(mContext, 60f), SizeTransform.dip2px(mContext, 60f)));
                switchFragment(i);
            } else {
                ic_menus.get(i).setLayoutParams(new LinearLayout.LayoutParams(SizeTransform.dip2px(mContext, 50f), SizeTransform.dip2px(mContext, 50f)));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_menu1:
            case R.id.ic_menu2:
            case R.id.ic_menu3:
            case R.id.ic_menu4:
                selectICMenu(v);
                break;
            case R.id.grade:
                gradeDialog = new GradeChooseDialog(mContext, 110, grade.getText().toString().trim(), new GradeChooseDialog.OnDialogButtonClickListener() {
                    @Override
                    public void onDialogButtonClick(int requestCode, String select) {
                        if (requestCode == 110) {
                            grade.setText(select);
                            gradeDialog.dismiss();
                        }
                    }
                });
                gradeDialog.show();
                break;
        }
    }
    public void sendMessage()
    {
        messageEvent = new TabHomeMessageEvent(showPosition,titles.get(tabLayout.getSelectedTabPosition()));
        EventBus.getDefault().postSticky(messageEvent);
    }
    public void switchFragment(int position)
    {
        showPosition = position;
        sendMessage();
//        tabLayout.setScrollPosition(position,0f,false);
        FragmentManager manager;
        FragmentTransaction transaction ;
        manager = getChildFragmentManager();
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
    public class TabHomeMessageEvent{
        private int postion;
        private String tabName;

        public String getTabName() {
            return tabName;
        }

        public void setTabName(String tabName) {
            this.tabName = tabName;
        }

        public int getPostion() {
            return postion;
        }

        public void setPostion(int postion) {
            this.postion = postion;
        }

        public  TabHomeMessageEvent( int postion,String message){
            this.tabName=message;
            this.postion=postion;
        }

    }
}
