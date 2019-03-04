package cqdz.com.genius.utils;

import android.content.Context;

import cqdz.com.genius.app.Genius;

public class SizeTransform {
    public static int dip2px(Context context, float dpValue) {
        if(context==null)
        {
            context = Genius.getInstance().getAppContext();
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
