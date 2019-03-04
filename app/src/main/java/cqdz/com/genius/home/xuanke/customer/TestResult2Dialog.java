package cqdz.com.genius.home.xuanke.customer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.adapter.AnswerCardAdapter;

public class TestResult2Dialog extends Dialog implements View.OnClickListener {

    private TestResult2Dialog.OnDialogButtonClickListener listener;
    private int requestCode;
    private TextView tv_left;
    private TextView tv_right;
    private Context mContext;
    public TestResult2Dialog(Context context, int requestCode, TestResult2Dialog.OnDialogButtonClickListener listener) {
        super(context);
        this.requestCode=requestCode;
        this.listener=listener;
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_answerwait);
        setCancelable(false);//设置点击对话框外部和按返回键都不可以取消
//        setCanceledOnTouchOutside(false);//设置点击对话框外部是否可以取消，默认是不可以取消（但是点返回键可以取消）
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        tv_left = findViewById(R.id.tv_left);
        tv_right= findViewById(R.id.tv_right);


        tv_left.setOnClickListener(this);
        tv_right.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_left:
                listener.onDialogButtonClick(requestCode,true);
                break;
            case R.id.tv_right:
                listener.onDialogButtonClick(requestCode,false);
                break;
        }

    }
    public interface OnDialogButtonClickListener {
        /**
         * 点击按钮的回调方法
         *
         * @param requestCode
         */
        void onDialogButtonClick(int requestCode, boolean isLeft);
    }
}
