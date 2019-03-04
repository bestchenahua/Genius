package cqdz.com.genius.home.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.adapter.TeachExpAdapter;
import cqdz.com.genius.home.model.TeachExpModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TeacherIntroduceFm extends MvpBaseFragment implements ScrollableHelper.ScrollableContainer {
    @BindView(R.id.linearLayout4)
    ScrollView scrollView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<TeachExpModel.Response.Data> mList;
    TeachExpAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_teacher_introduce;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        mList = new ArrayList<>();
        adapter = new TeachExpAdapter(R.layout.item_teach_experience,mList);
        setData();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
    public void setData()
    {
        TeachExpModel.Response.Data data = new TeachExpModel.Response.Data();
        data.setDate("2014年07月至2018年02月");
        data.setExperience("小学数学一对多辅导");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
    @Override
    public View getScrollableView() {
        return scrollView;
    }
}
