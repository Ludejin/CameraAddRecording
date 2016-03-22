package com.creawor.addcamera.module.setting.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.creawor.addcamera.R;
import com.creawor.addcamera.app.Base2ndActivity;
import com.creawor.addcamera.common.SharedPreferencesUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class SetServerUrl extends Base2ndActivity implements View.OnClickListener {

    public static final String SERVER_URL = "server_url";

    private Context mContext;

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.edt_server_url)
    EditText edtServerUrl;
    @Bind(R.id.btn_ok)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_set_server);
        ButterKnife.bind(this);

        mContext = this;

        initToolbar();

        initData();
        initEvent();
    }

    private void initEvent() {
        btnOk.setOnClickListener(this);
    }

    private void initData() {
        toolbarTitle.setText(getTitle());

        edtServerUrl.setText(SharedPreferencesUtils.getString(mContext, SERVER_URL, ""));
    }

    @Override
    public void onClick(View v) {
        String mServerUrl = edtServerUrl.getText().toString();
        if (!TextUtils.isEmpty(mServerUrl)) {
            SharedPreferencesUtils.putString(mContext, SERVER_URL, mServerUrl);
            Toast.makeText(mContext, "设置成功", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(mContext, "请输入服务地址", Toast.LENGTH_SHORT).show();
        }
    }
}
