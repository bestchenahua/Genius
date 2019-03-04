package cqdz.com.genius.home.xuanke.customer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.adapter.AnswerCardAdapter;

public class AnswerCardDialog extends Dialog implements View.OnClickListener {

    private AnswerCardDialog.OnDialogButtonClickListener listener;
    private int requestCode;
    private Button btn_jiaojuan;
    private Button btn_close;

    private TextView tv_total;
    private TextView tv_done;
    private TextView tv_nodone;

    private int clickNum=0;
    private Context mContext;
    List<Data> mList;
    RecyclerView recyclerView;
    AnswerCardAdapter adapter;
    public AnswerCardDialog(Context context, int requestCode, List<Data> data,AnswerCardDialog.OnDialogButtonClickListener listener) {
        super(context);
        this.requestCode=requestCode;
        this.listener=listener;
        this.mList = data;
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_answercard);
//        setCancelable(false);//设置点击对话框外部和按返回键都不可以取消
//        setCanceledOnTouchOutside(false);//设置点击对话框外部是否可以取消，默认是不可以取消（但是点返回键可以取消）
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        recyclerView = findViewById(R.id.recyclerView);
        btn_jiaojuan = findViewById(R.id.btn_jiaojuan);
        btn_close= findViewById(R.id.btn_close);

        tv_total= findViewById(R.id.tv_total);
        tv_done= findViewById(R.id.tv_done);
        tv_nodone= findViewById(R.id.tv_nodone);

        btn_jiaojuan.setOnClickListener(this);
        btn_close.setOnClickListener(this);

        tv_total.setText("本次考试共"+mList.size()+"题");
        int done = 0;
        for(int i = 0 ;i<mList.size();i++)
        {
            if(mList.get(i).isDone)
            {
                done++;
            }
        }
        tv_done.setText("已答"+done+"题");
        int nodone = mList.size()-done;
        tv_nodone.setText("未答"+nodone+"题");

        adapter = new AnswerCardAdapter(R.layout.item_answercard,mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                listener.onDialogButtonClick(requestCode,mList.get(position).getSerial());
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,5));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jiaojuan:
                //交卷
                listener.onDialogButtonClick(requestCode,-1);
                break;
            case R.id.btn_close:
                //关闭
                dismiss();
                break;
        }

    }
    public interface OnDialogButtonClickListener {
        /**
         * 点击按钮的回调方法
         *
         * @param requestCode
         */
        void onDialogButtonClick(int requestCode,int num);
    }
    public static class Data
    {
        int serial=-1;
        boolean isDone=false;

        public int getSerial() {
            return serial;
        }

        public void setSerial(int serial) {
            this.serial = serial;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }
    }
}
