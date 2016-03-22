package com.creawor.addcamera.module.login.view;


import com.creawor.addcamera.bean.UserInfoRes;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public interface LoginCallBack {
    void doLoginFail(String msg);
    void doLoginSuc(UserInfoRes userInfo);
}
