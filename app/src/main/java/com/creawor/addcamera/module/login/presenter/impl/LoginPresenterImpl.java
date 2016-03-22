package com.creawor.addcamera.module.login.presenter.impl;

import com.creawor.addcamera.bean.UserInfoRes;
import com.creawor.addcamera.module.login.model.LoginModel;
import com.creawor.addcamera.module.login.model.impl.LoginModelImpl;
import com.creawor.addcamera.module.login.presenter.LoginPresenter;
import com.creawor.addcamera.module.login.view.LoginCallBack;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel mModel;
    private LoginCallBack mCallback;

    public LoginPresenterImpl(LoginCallBack mCallback) {
        this.mCallback = mCallback;
        this.mModel = new LoginModelImpl();
    }

    @Override
    public void doLogin(String name, String pwd) {
        mModel.doLogin(name,pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserInfoRes>() {
                    @Override
                    public void call(UserInfoRes mRes) {
                        mCallback.doLoginSuc(mRes);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mCallback.doLoginFail("发生异常");
                    }
                });
    }
}
