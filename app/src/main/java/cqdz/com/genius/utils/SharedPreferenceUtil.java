package cqdz.com.genius.utils;

import android.content.Context;
import android.content.SharedPreferences;

import cqdz.com.genius.app.Genius;


public class SharedPreferenceUtil {
    private static final String SHAREDPREFERENCES_NAME = "NDRestructure_sp";
    public static final String SP_ISFIRST = "isFirst";
    public static final String SP_USER_NAME = "SP_USER_NAME";
    public static final String SP_USER_PWD = "SP_USER_PWD";

    public static final String SP_AUTO_LOGIN = "SP_AUTO_LOGIN";

    public static final String SP_REMEBER_PWD = "SP_REMEBER_PWD";

    public static final String SP_APK_URL = "SP_APK_URL";

    public static String getString(String key)
    {
        return getAppSp().getString(key,"");
    }
    public static void setString(String key,String value)
    {
        getAppSp().edit().putString(key, value).commit();
    }
    public static int getInt(String key)
    {
        return getAppSp().getInt(key,0);
    }
    public static void setInt(String key,int value)
    {
        getAppSp().edit().putInt(key, value).commit();
    }
    public static boolean getBoolean(String key)
    {
        return getAppSp().getBoolean(key,true);
    }
    public static void setBoolean(String key,boolean value)
    {
        getAppSp().edit().putBoolean(key, value).commit();
    }
    private static SharedPreferences getAppSp()
    {
        return Genius.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
