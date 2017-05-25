package dongting.bwei.com.recycleviewexercise;

import android.app.Application;

import org.xutils.x;

/**
 * 作者:${董婷}
 * 日期:2017/5/23
 * 描述:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.isDebug();
    }
}
