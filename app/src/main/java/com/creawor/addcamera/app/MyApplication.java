package com.creawor.addcamera.app;

import android.app.Application;
import android.content.Context;

import com.creawor.addcamera.common.Const;
import com.creawor.addcamera.common.SharedPreferencesUtils;
import com.creawor.addcamera.module.setting.ui.SetServerUrl;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static String getBaseUrl(){
        return SharedPreferencesUtils.getString(mContext, SetServerUrl.SERVER_URL, Const.BASE_URL);
    }
}
