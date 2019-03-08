package cqdz.com.genius.login.view;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.HomeActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class GradeChooseActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_primary1)
    TextView tv_primary1;
    @BindView(R.id.tv_primary2)
    TextView tv_primary2;
    @BindView(R.id.tv_primary3)
    TextView tv_primary3;
    @BindView(R.id.tv_primary4)
    TextView tv_primary4;
    @BindView(R.id.tv_primary5)
    TextView tv_primary5;
    @BindView(R.id.tv_primary6)
    TextView tv_primary6;

    @BindView(R.id.tv_secondary1)
    TextView tv_secondary1;
    @BindView(R.id.tv_secondary2)
    TextView tv_secondary2;
    @BindView(R.id.tv_secondary3)
    TextView tv_secondary3;

    @BindView(R.id.tv_high1)
    TextView tv_high1;
    @BindView(R.id.tv_high2)
    TextView tv_high2;
    @BindView(R.id.tv_high3)
    TextView tv_high3;
    List<TextView> tv_grade;
    @BindView(R.id.btn_confirm)
    Button tv_confirm;

    @Override
    protected int getLayout() {
        return R.layout.activity_gradechoose;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("选择年级");
        tv_grade = new ArrayList<>();
        tv_primary1.setOnClickListener(this);
        tv_primary2.setOnClickListener(this);
        tv_primary3.setOnClickListener(this);
        tv_primary4.setOnClickListener(this);
        tv_primary5.setOnClickListener(this);
        tv_primary6.setOnClickListener(this);

        tv_grade.add(tv_primary1);
        tv_grade.add(tv_primary2);
        tv_grade.add(tv_primary3);
        tv_grade.add(tv_primary4);
        tv_grade.add(tv_primary5);
        tv_grade.add(tv_primary6);

        tv_secondary1.setOnClickListener(this);
        tv_secondary2.setOnClickListener(this);
        tv_secondary3.setOnClickListener(this);

        tv_grade.add(tv_secondary1);
        tv_grade.add(tv_secondary2);
        tv_grade.add(tv_secondary3);

        tv_high1.setOnClickListener(this);
        tv_high2.setOnClickListener(this);
        tv_high3.setOnClickListener(this);

        tv_grade.add(tv_high1);
        tv_grade.add(tv_high2);
        tv_grade.add(tv_high3);

        tv_confirm.setOnClickListener(this);
        selectGrade(tv_primary1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_primary1:
            case R.id.tv_primary2:
            case R.id.tv_primary3:
            case R.id.tv_primary4:
            case R.id.tv_primary5:
            case R.id.tv_primary6:

            case R.id.tv_high1:
            case R.id.tv_high2:
            case R.id.tv_high3:

            case R.id.tv_secondary1:
            case R.id.tv_secondary2:
            case R.id.tv_secondary3:
                selectGrade(v);
                break;
            case R.id.btn_confirm:
                startActivity(new Intent(mContext, FillDataActivity.class));
                break;
        }

    }

    private void selectGrade(View v) {
        for (int i = 0; i < tv_grade.size(); i++) {
            if (v.getId() == tv_grade.get(i).getId()) {
                tv_grade.get(i).setTextColor(Color.parseColor("#ffffff"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_50d8c0);
            } else {
                tv_grade.get(i).setTextColor(Color.parseColor("#515151"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_f8f8f8);
            }
        }
    }
}
