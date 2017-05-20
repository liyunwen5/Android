package wh.lyw.mvp;

import android.app.Application;

/**
 * Created by Nicholas on 2016/11/5.
 */

public class MyApplication extends Application {

    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    public static MyApplication getContext() {
        return mContext;
    }
}
