package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.view.FillOrderActivity;
import cqdz.com.genius.home.wode.adapter.MyCourseSheetAdapter;
import cqdz.com.genius.home.wode.model.CourseSheetModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyCourseSheetActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.btn_jiesuan)
    Button btn_jiesuan;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.line)
    View line;

    MyCourseSheetAdapter adapter;
    List<CourseSheetModel.Response.Data> mList;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @Override
    protected int getLayout() {
        return R.layout.activity_my_coursesheet;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("我的选课单");
        action_bar_right.setText("编辑");
        action_bar_right.setOnClickListener(this);
        btn_jiesuan.setOnClickListener(this);
        mList = new ArrayList<>();
        checkbox.setChecked(true);
        setData();
        adapter = new MyCourseSheetAdapter(mList);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                boolean isAll =true;
                MyCourseSheetAdapter courseSheetAdapter = (MyCourseSheetAdapter)adapter;
                if(view.getId()==R.id.checkbox)
                {
                    mList = courseSheetAdapter.getData();
                    if(mList.get(position).isChecked())
                    {
                        for(int j = 0 ;j<mList.size();j++)
                        {
                            if(!mList.get(j).isChecked())
                            {
                                isAll = false;
                            }
                        }
                    }
                    else {
                        isAll = false;
                    }
                    checkbox.setChecked(isAll);
                }
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i<mList.size();i++)
                {
                    if(mList.get(i).getItemType()==0)
                    {
                        mList.get(i).setChecked(checkbox.isChecked());
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
    public void setData()
    {
        CourseSheetModel.Response.Data data = new CourseSheetModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551852028569&di=c847c0244500a277594b5c06f3426ba0&imgtype=0&src=http%3A%2F%2Fcdn.onlinewebfonts.com%2Fsvg%2Fimg_326384.png");
        data.setName("张三");
        data.setNum("1802");
        data.setPrice("20元/每课时");
        data.setTitle("唱歌也能记单词？一起趣学英语！");
        data.setValid(0);

        CourseSheetModel.Response.Data data2 = new CourseSheetModel.Response.Data();
        data2.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551852028569&di=c847c0244500a277594b5c06f3426ba0&imgtype=0&src=http%3A%2F%2Fcdn.onlinewebfonts.com%2Fsvg%2Fimg_326384.png");
        data2.setName("李四");
        data2.setNum("1802");
        data2.setPrice("20元/每课时");
        data2.setTitle("唱歌也能记单词？一起趣学英语！");
        data2.setValid(0);


        CourseSheetModel.Response.Data data1 = new CourseSheetModel.Response.Data();
        data1.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551852028569&di=c847c0244500a277594b5c06f3426ba0&imgtype=0&src=http%3A%2F%2Fcdn.onlinewebfonts.com%2Fsvg%2Fimg_326384.png");
        data1.setName("张三");
        data1.setNum("1802");
        data1.setPrice("20元/每课时");
        data1.setTitle("唱歌也能记单词？一起趣学英语！");
        data1.setValid(1);

        mList.add(data);
        mList.add(data2);
        mList.add(data1);
        mList.add(data1);
        mList.add(data1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_jiesuan:
                startActivity(new Intent(mContext,FillOrderActivity.class));
                break;
            case  R.id.action_bar_right:
                if(action_bar_right.getText().toString().trim().equals("编辑"))
                {
                    line.setVisibility(View.INVISIBLE);
                    tv_price.setVisibility(View.INVISIBLE);
                    action_bar_right.setText("完成");
                    btn_jiesuan.setText("删除");
                }
                else {
                    line.setVisibility(View.VISIBLE);
                    tv_price.setVisibility(View.VISIBLE);
                    action_bar_right.setText("编辑");
                    btn_jiesuan.setText("结算");
                }
                break;
        }
    }
}
