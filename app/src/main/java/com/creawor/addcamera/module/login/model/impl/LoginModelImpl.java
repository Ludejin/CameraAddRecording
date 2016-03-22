package com.creawor.addcamera.module.login.model.impl;

import com.creawor.addcamera.bean.UserInfoRes;
import com.creawor.addcamera.module.login.api.LoginHttpService;
import com.creawor.addcamera.module.login.model.LoginModel;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginModelImpl implements LoginModel {

    private LoginHttpService mService = new LoginHttpService();

    @Override
    public Observable<UserInfoRes> doLogin(final String name, final String pwd) {
        return Observable.create(new Observable.OnSubscribe<UserInfoRes>() {
            @Override
            public void call(Subscriber<? super UserInfoRes> subscriber) {
                subscriber.onNext(
                    mService.doLogin(name,pwd)
                );
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }
}
