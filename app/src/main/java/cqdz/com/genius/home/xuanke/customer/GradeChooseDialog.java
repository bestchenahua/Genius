package cqdz.com.genius.home.xuanke.customer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.R;

public class GradeChooseDialog extends Dialog implements View.OnClickListener {


    public GradeChooseDialog(Context context, int requestCode,String name,GradeChooseDialog.OnDialogButtonClickListener listener) {
        super(context);
        this.requestCode=requestCode;
        this.listener=listener;
        this.name = name;
    }
    public interface OnDialogButtonClickListener {
        /**
         * 点击按钮的回调方法
         *
         * @param requestCode
         * @param select
         */
        void onDialogButtonClick(int requestCode, String select);
    }
    private int requestCode;
    private GradeChooseDialog.OnDialogButtonClickListener listener;

    private TextView tv_primary1;
    private TextView tv_primary2;
    private TextView tv_primary3;
    private TextView tv_primary4;
    private TextView tv_primary5;
    private TextView tv_primary6;

    private TextView tv_secondary1;
    private TextView tv_secondary2;
    private TextView tv_secondary3;

    private TextView tv_high1;
    private TextView tv_high2;
    private TextView tv_high3;

    private String name;
    private int mNum;
    List<TextView> tv_grade;

    private TextView tv_confirm;
    private ImageView iv_close;

    private String content;
    private String positive;
    private String negative;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_gradechoose);
//        setCancelable(false);//设置点击对话框外部和按返回键都不可以取消
//        setCanceledOnTouchOutside(false);//设置点击对话框外部是否可以取消，默认是不可以取消（但是点返回键可以取消）
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        tv_grade = new ArrayList<>();
        tv_primary1= (TextView) findViewById(R.id.tv_primary1);
        tv_primary2= (TextView) findViewById(R.id.tv_primary2);
        tv_primary3= (TextView) findViewById(R.id.tv_primary3);
        tv_primary4= (TextView) findViewById(R.id.tv_primary4);
        tv_primary5= (TextView) findViewById(R.id.tv_primary5);
        tv_primary6= (TextView) findViewById(R.id.tv_primary6);

        tv_secondary1= (TextView) findViewById(R.id.tv_secondary1);
        tv_secondary2= (TextView) findViewById(R.id.tv_secondary2);
        tv_secondary3= (TextView) findViewById(R.id.tv_secondary3);

        tv_high1= (TextView) findViewById(R.id.tv_high1);
        tv_high2= (TextView) findViewById(R.id.tv_high2);
        tv_high3= (TextView) findViewById(R.id.tv_high3);

        tv_grade.add(tv_primary1);
        tv_grade.add(tv_primary2);
        tv_grade.add(tv_primary3);
        tv_grade.add(tv_primary4);
        tv_grade.add(tv_primary5);
        tv_grade.add(tv_primary6);

        tv_grade.add(tv_secondary1);
        tv_grade.add(tv_secondary2);
        tv_grade.add(tv_secondary3);

        tv_grade.add(tv_high1);
        tv_grade.add(tv_high2);
        tv_grade.add(tv_high3);
        for(int i = 0 ;i<tv_grade.size();i++)
        {
            tv_grade.get(i).setOnClickListener(this);
        }
        setSelect(name2Num(name));
        tv_confirm= (TextView) findViewById(R.id.tv_confirm);
        iv_close= (ImageView) findViewById(R.id.iv_close);
        tv_confirm.setOnClickListener(this);
        iv_close.setOnClickListener(this);
    }

    private String num2Name(int num)
    {
        String name = "一年级" ;
        if(num==0)
        {
            name = "一年级" ;
        }
        else if(num==1)
        {
            name = "二年级" ;
        }
        else if(num==2)
        {
            name = "三年级" ;
        }
        else if(num==3)
        {
            name = "四年级" ;
        }
        else if(num==4)
        {
            name = "五年级" ;
        }
        else if(num==5)
        {
            name = "六年级" ;
        }
        else if(num==6)
        {
            name = "初一" ;
        }
        else if(num==7)
        {
            name = "初二" ;
        }
        else if(num==8)
        {
            name = "初三" ;
        }
        else if(num==9)
        {
            name = "高一" ;
        }
        else if(num==10)
        {
            name = "高二" ;
        }
        else if(num==11)
        {
            name = "高三" ;
        }
        return  name;
    }
    private int name2Num(String name)
    {
        int num = 0 ;
        if(name.equals("一年级"))
        {
            num = 0 ;
        }
        else if(name.equals("二年级"))
        {
            num = 1;
        }
        else if(name.equals("三年级"))
        {
            num = 2;
        }
        else if(name.equals("四年级"))
        {
            num = 3;
        }
        else if(name.equals("五年级"))
        {
            num = 4;
        }
        else if(name.equals("六年级"))
        {
            num = 5;
        }
        else if(name.equals("初一"))
        {
            num = 6;
        }
        else if(name.equals("初二"))
        {
            num = 7;
        }
        else if(name.equals("初三"))
        {
            num = 8;
        }
        else if(name.equals("高一"))
        {
            num = 9;
        }
        else if(name.equals("高二"))
        {
            num = 10;
        }
        else if(name.equals("高三"))
        {
            num = 11;
        }
        return  num;
    }

    private void setSelect(int j)
    {
        for(int i = 0 ;i<tv_grade.size();i++)
        {
            if(j==i)
            {
                tv_grade.get(i).setTextColor(Color.parseColor("#ffffff"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_50d8c0);
                mNum = i;
            }
            else {
                tv_grade.get(i).setTextColor(Color.parseColor("#515151"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_f8f8f8);
            }
        }
    }
    private void selectGrade(View v)
    {
        for(int i = 0 ;i<tv_grade.size();i++)
        {
            if(v.getId()==tv_grade.get(i).getId())
            {
                tv_grade.get(i).setTextColor(Color.parseColor("#ffffff"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_50d8c0);
                mNum = i;
            }
            else {
                tv_grade.get(i).setTextColor(Color.parseColor("#515151"));
                tv_grade.get(i).setBackgroundResource(R.drawable.rad14_f8f8f8);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
            case R.id.tv_confirm:
                //确定按钮
                listener.onDialogButtonClick(requestCode,num2Name(mNum)+"");
                break;
            case R.id.iv_close:
                //确定按钮
                dismiss();
                break;
        }

    }
}
