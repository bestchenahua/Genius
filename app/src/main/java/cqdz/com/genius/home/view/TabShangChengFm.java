package cqdz.com.genius.home.view;

import android.content.Intent;
import android.graphics.Rect;
import android.hardware.input.InputManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.ShoppingMenuAdapter;
import cqdz.com.genius.home.shangcheng.model.ShoppingClassifyBean;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class TabShangChengFm extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.ed_search)
    EditText ed_search;

    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.tab)
    PageNavigationView mTab;
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;
    InputMethodManager imm;
    private NavigationController mNavigationController;

    List<ShoppingClassifyBean> mList;

    List<ShoppingClassifyBean.ShoppingMenuBean> mShoppingMenuBeanList;
    ShoppingMenuAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.tab_shancgheng_fm;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        ed_search.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            //当键盘弹出隐藏的时候会 调用此方法。
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                //获取当前界面可视部分
                mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //获取屏幕的高度
                int screenHeight =  mActivity.getWindow().getDecorView().getRootView().getHeight();
                //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
                int heightDifference = screenHeight - r.bottom;

                if(heightDifference>0)//弹出
                {

                }
                else {
                    if(!TextUtils.isEmpty(ed_search.getText().toString().trim()))
                    {
                        Logger.d(ed_search.getText().toString().trim()+"");
                        ed_search.setText("");
                    }
                }
            }

        });
        iv_search.setOnClickListener(this);
        imm = (InputMethodManager) mContext.getSystemService(mContext.INPUT_METHOD_SERVICE);

        mList = new ArrayList<>();
        mShoppingMenuBeanList = new ArrayList<>();

        mAdapter = new ShoppingMenuAdapter(R.layout.item_shopping_menu, mShoppingMenuBeanList);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mRvContent.setLayoutManager(new GridLayoutManager(mContext, 2));
        mRvContent.setAdapter(mAdapter);


        setData();

        if (mList != null && !mList.isEmpty()) {
            PageNavigationView.CustomBuilder custom = mTab.custom();

            for (int i = 0; i < mList.size(); i++) {
                custom.addItem(new ShoppingTab(mContext, mList.get(i).typeName));
            }
            mNavigationController = custom.enableVerticalLayout().build();
            setMenu(0);
            mNavigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
                @Override
                public void onSelected(int index, int old) {
                    setMenu(index);
                }

                @Override
                public void onRepeat(int index) {

                }
            });

        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    public void setData()
    {
        ShoppingClassifyBean data = new ShoppingClassifyBean();

        ShoppingClassifyBean.ShoppingMenuBean seconed = new ShoppingClassifyBean.ShoppingMenuBean();
        seconed.setTypeName("子菜单一");
        seconed.setImg("http://imgsrc.baidu.com/baike/pic/item/8759287aee6b8fb32f73b31b.jpg");
        seconed.setId("2");
        List<ShoppingClassifyBean.ShoppingMenuBean> seconedList = new ArrayList<>();
        seconedList.add(seconed);
        seconedList.add(seconed);
        seconedList.add(seconed);
        seconedList.add(seconed);

        data.setTypeName("菜单一");
        data.setId("id1");
        data.setData(seconedList);

        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);

        Logger.d(mList.get(0).getData());
    }
    private void setMenu(int index) {
//        LogUtil.i("点击：" + index);
        if (!mList.isEmpty()) {
            mShoppingMenuBeanList.clear();
            if (mList.get(index).data != null) {
                Logger.d(mList.get(index).data.size());
                mShoppingMenuBeanList.addAll(mList.get(index).data);
                Logger.d(mShoppingMenuBeanList.size());
            }
            mAdapter.notifyDataSetChanged();
        }
        else {
            Logger.d("mList空"+index);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                break;
        }
    }
}
