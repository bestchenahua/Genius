package cqdz.com.genius.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil extends Toast {
    Toast toast;
    Context mContext;
    public ToastUtil(Context context) {
        super(context);
//        toast = new Toast(context);
        mContext = context;
    }
    public void showShort(String msg)
    {
        if(toast!=null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }
    public void showLong(String msg)
    {
        if(toast!=null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(mContext, msg, Toast.LENGTH_LONG);
        toast.setText(msg);
        toast.show();
    }
    public void cancel()
    {
        toast.cancel();
    }
}
