package cqdz.com.genius.customer;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cqdz.com.genius.R;

public class MyToast extends Toast {
    private MyToast toast;
    Context mContext;
    private ImageView iv;
    public MyToast(Context context) {
        super(context);
        mContext=context;
    }
    public void showText(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }
    public void showShort(String msg)
    {
        showToast(msg, Toast.LENGTH_SHORT);
    }
    public void showTextWithPic(CharSequence text) {
        showToastWithPic(text, Toast.LENGTH_SHORT);
    }
    private void showToast(CharSequence text, int time) {
        // 初始化一个新的Toast对象
        initToast(mContext, text);
        // 设置显示时长
        if (time == Toast.LENGTH_LONG) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
    private void showToastWithPic(CharSequence text, int time) {
        // 初始化一个新的Toast对象
        initToast(mContext, text);
        // 设置显示时长
        iv.setVisibility(View.VISIBLE);
        if (time == Toast.LENGTH_LONG) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
    /**
     * 初始化Toast
     *
     * @param context 上下文
     * @param text    显示的文本
     */
    private void initToast(Context context, CharSequence text) {
        try {
            cancelToast();
            toast = new MyToast(context);

            // 获取LayoutInflater对象
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 由layout文件创建一个View对象
            View layout = inflater.inflate(R.layout.toast_style, null);

            // 吐司上的文字
            TextView toast_text = (TextView) layout.findViewById(R.id.content);
            iv = (ImageView) layout.findViewById(R.id.image);
            toast_text.setText(text);
            toast.setView(layout);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏当前Toast
     */
    public void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public void cancel() {
        try {
            super.cancel();
        } catch (Exception e) {

        }
    }

    @Override
    public void show() {
        try {
            super.show();
        } catch (Exception e) {

        }
    }
}
