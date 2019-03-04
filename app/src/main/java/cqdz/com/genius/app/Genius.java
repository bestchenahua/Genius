package cqdz.com.genius.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cqdz.com.genius.R;


public class Genius extends Application {
    private static Genius instance;
    private Map<String,String> commonparts;
    private Set<Activity> allActivities;
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("DongPengApp")
                .build();
        //打印日志
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//        FormatStrategy formatStrategy = CsvFormatStrategy.newBuilder()
//                .tag("NDRestructure")
//                .build()
//        保存日志到本地文件logger
//        Logger.addLogAdapter(new DiskLogAdapter(formatStrategy));
//        Bugly.init(getApplicationContext(), "3dee6816b9", false);
    }
    public static synchronized Genius getInstance() {
        return instance;
    }
    public Map<String,String> getCommonParts()
    {
        if(commonparts!=null)
        {
            return commonparts;
        }
        else
        {
            return new HashMap<String,String>();
        }
    }
    public void setCommonParts(String token,String timestamp,String userid,String roleid)
    {
        commonparts=new HashMap<String,String>();
        commonparts.put("token",token);
        commonparts.put("timestamp",timestamp);
        commonparts.put("userid",userid);
        commonparts.put("roleid",roleid);
    }
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }
    public Context getAppContext()
    {
        return this;
    }
    /**
     * 退出
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
