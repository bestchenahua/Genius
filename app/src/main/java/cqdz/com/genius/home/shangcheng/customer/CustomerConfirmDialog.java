package cqdz.com.genius.home.shangcheng.customer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cqdz.com.genius.R;

public class CustomerConfirmDialog extends Dialog implements View.OnClickListener {
    public interface OnDialogButtonClickListener {
        /**
         * 点击按钮的回调方法
         *
         * @param requestCode
         * @param isPositive
         */
        void onDialogButtonClick(int requestCode, boolean isPositive);
    }
    private Context context;
    private int requestCode;
    private OnDialogButtonClickListener listener;

    public CustomerConfirmDialog(Context context, int requestCode, String title, String content,
                                 String positive, String negative, OnDialogButtonClickListener listener) {
        super(context);
        this.context = context;
        this.requestCode=requestCode;

        this.title=title;
        this.content=content;
        this.positive=positive;
        this.negative=negative;

        this.listener=listener;

    }
    private TextView tv_title;

    private TextView tv_content;

    private TextView positiveBtn;

    private TextView negativeBtn;

    private String title;
    private String content;
    private String positive;
    private String negative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_confirm_dialog);
//        setCancelable(false);//设置点击对话框外部和按返回键都不可以取消
//        setCanceledOnTouchOutside(false);//设置点击对话框外部是否可以取消，默认是不可以取消（但是点返回键可以取消）
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        tv_title= (TextView) findViewById(R.id.title);
        positiveBtn= (TextView) findViewById(R.id.positiveBtn);
        tv_content= (TextView) findViewById(R.id.content);
        negativeBtn= (TextView) findViewById(R.id.negativeBtn);
        tv_title.setText(title);
        tv_content.setText(content);
        positiveBtn.setText(positive);
        negativeBtn.setText(negative);

        positiveBtn.setOnClickListener(this);
        negativeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.negativeBtn:
                //确定按钮
                listener.onDialogButtonClick(requestCode,false);
                break;
            case R.id.positiveBtn:
                //确定按钮
                listener.onDialogButtonClick(requestCode,true);
                break;
        }
//        dismiss();
    }
}
