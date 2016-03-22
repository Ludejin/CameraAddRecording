package com.creawor.addcamera.module.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.creawor.addcamera.R;
import com.creawor.addcamera.app.BaseActivity;
import com.creawor.addcamera.app.home.MainActivity;
import com.creawor.addcamera.bean.UserInfoRes;
import com.creawor.addcamera.module.login.presenter.LoginPresenter;
import com.creawor.addcamera.module.login.presenter.impl.LoginPresenterImpl;
import com.creawor.addcamera.module.login.view.LoginCallBack;
import com.creawor.addcamera.module.setting.ui.SettingActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener,LoginCallBack {

    @Bind(R.id.edt_name)
    EditText edtName;
    @Bind(R.id.edt_password)
    EditText edtPassword;
    @Bind(R.id.btn_doLogin)
    Button btnDoLogin;

    private Context mContext;
    private LoginPresenter mPresenter;

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);

        mContext = this;
        mPresenter = new LoginPresenterImpl(this);

        initToolbar();
        initData();
        initEvent();
    }

    private void initEvent() {
        btnDoLogin.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(mContext, SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        toolbarTitle.setText(getResources().getString(R.string.title_user_login));
    }

    @Override
    public void onClick(View v) {
        String userName = edtName.getText().toString();
        String password = edtPassword.getText().toString();

        mDialogFactory.showProgressDialog("登录中...",true);
        mPresenter.doLogin(userName,password);
    }

    @Override
    public void doLoginFail(String msg) {
        mDialogFactory.dissProgressDialog();
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doLoginSuc(UserInfoRes mRes) {
        mDialogFactory.dissProgressDialog();
        if (mRes.getCode() == 0) {
            Intent intent = new Intent();
            intent.setClass(mContext, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(mContext,"用户名或密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
