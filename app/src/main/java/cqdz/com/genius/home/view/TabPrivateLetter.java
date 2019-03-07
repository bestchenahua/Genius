package cqdz.com.genius.home.view;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.adapter.PrivateLetterAdapter;
import cqdz.com.genius.home.model.PriveteLetterModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TabPrivateLetter extends MvpBaseFragment implements View.OnClickListener {

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.action_bar_right)
    TextView action_bar_right;

    TextView tv_qunliao;
    TextView tv_haoyou;

    PrivateLetterAdapter adapter;
    List<PriveteLetterModel.Response.Data> mList;
    PopupWindow popupWindow;

    @Override
    protected int getLayout() {
        return R.layout.tab_privateletter;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        popupOverflowMenu(action_bar_right);
        action_bar_right.setOnClickListener(this);
        tv_qunliao.setOnClickListener(this);
        tv_haoyou.setOnClickListener(this);
        mList = new ArrayList<>();
        setData();
        adapter = new PrivateLetterAdapter(R.layout.item_private_letter, mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

    }

    public void setData() {
        PriveteLetterModel.Response.Data data = new PriveteLetterModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551960573495&di=d14369974cc981e84df6d046287bfb19&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2Fffe9735cdb517513b7de05d95767eef31abe3da9.jpg");
        data.setComtent("明天你还听吗?我明天有事来不了。");
        data.setName("张大帅");
        data.setNum("11");
        data.setTime("01-28");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }

    public void popupOverflowMenu(View view) {
        // 显示溢出菜单的时候设置背景半透明

        // 获取状态栏高度
        Rect frame = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        // 状态栏高度 frame.top

        View popView = getLayoutInflater().inflate(R.layout.actionbar_menu, null);
        tv_qunliao = popView.findViewById(R.id.textView9);
        tv_haoyou= popView.findViewById(R.id.textView13);
        // popView即popupWindow布局
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 必须设计BackgroundDrawable后setOutsideTouchable(true)才会有效。这里在XML中定义背景，所以这里为null
        popupWindow.setBackgroundDrawable(new ColorDrawable(0000000000));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true); // 点击外部关闭
        popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置Gravity,让它显示在右上角

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                // popupWindow消失时，设置为全透明
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_bar_right:
                popupWindow.showAsDropDown(action_bar_right);
                break;
            case R.id.textView9:
                mToast.showText("创建群聊");
                break;
            case R.id.textView13:
                mToast.showText("添加好友");
                break;
        }
    }
}
