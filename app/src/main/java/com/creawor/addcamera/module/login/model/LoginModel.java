package com.creawor.addcamera.module.login.model;

import com.creawor.addcamera.bean.UserInfoRes;

import rx.Observable;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public interface LoginModel {
    Observable<UserInfoRes> doLogin(String name, String pwd);
}
