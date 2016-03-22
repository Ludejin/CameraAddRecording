package com.creawor.addcamera.module.login.api;


import com.creawor.addcamera.bean.UserInfoRes;
import com.creawor.addcamera.common.Const;
import com.creawor.addcamera.common.http.BaseHttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginHttpService {
    private LoginHttpInterface mService;

    public LoginHttpService() {
        this.mService = BaseHttpClient.newInstance().create(LoginHttpInterface.class);
    }

    public UserInfoRes doLogin(String name, String pwd){
        UserInfoRes mRes = null;

        Map<String, RequestBody> params = new HashMap<>();

        RequestBody p_name = RequestBody.create(MediaType.parse(Const.REQ_TYPE_TEXT), name);
        RequestBody p_pwd = RequestBody.create(MediaType.parse(Const.REQ_TYPE_TEXT), pwd);

        params.put("accountNo",p_name);
        params.put("pwd",p_pwd);


        try {
            mRes = mService.doLogin(params).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mRes;
    }

}
