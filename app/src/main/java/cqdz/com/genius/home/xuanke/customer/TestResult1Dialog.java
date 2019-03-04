package cqdz.com.genius.home.xuanke.customer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cqdz.com.genius.R;

public class TestResult1Dialog extends Dialog implements Runnable{

    private int requestCode;
    private Context mContext;

    TextView tv_result;
    TextView tv_right;
    TextView tv_total;
    TextView tv_score;

    public TestResult1Dialog(Context context, int requestCode) {
        super(context);
        this.requestCode=requestCode;
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_answerresult);
        setCancelable(false);//设置点击对话框外部和按返回键都不可以取消
//        setCanceledOnTouchOutside(false);//设置点击对话框外部是否可以取消，默认是不可以取消（但是点返回键可以取消）
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        tv_result = findViewById(R.id.tv_result);//100分
        tv_right= findViewById(R.id.tv_right);//答对题：58题
        tv_total = findViewById(R.id.tv_total);//总题数：60题
        tv_score= findViewById(R.id.tv_score);//本次课程共获得:4学分
        new Thread(this).start();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
