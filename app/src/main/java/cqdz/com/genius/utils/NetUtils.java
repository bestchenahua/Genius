package cqdz.com.genius.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cqdz.com.genius.app.Genius;

public class NetUtils {
    public static boolean checkNetWork(){
        try{
            ConnectivityManager connectactivity = (ConnectivityManager) Genius.getInstance().getAppContext().
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectactivity != null){
//                获知网络管理的对象
                NetworkInfo info = connectactivity.getActiveNetworkInfo();
//                判断当前网络是否已经连接
                if(info.getState() == NetworkInfo.State.CONNECTED){
                    return true ;
                }
            }
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return false ;
    }
}
