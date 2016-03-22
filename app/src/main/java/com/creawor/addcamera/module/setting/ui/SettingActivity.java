package com.creawor.addcamera.module.setting.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creawor.addcamera.R;
import com.creawor.addcamera.app.Base2ndActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class SettingActivity extends Base2ndActivity implements View.OnClickListener {

    private Context mContext;

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.rl_setting_server)
    RelativeLayout rlSettingServer;
    @Bind(R.id.rl_offline_map)
    RelativeLayout rlOfflineMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        ButterKnife.bind(this);
        mContext = this;

        initToolbar();
        initData();
        initEvent();
    }

    private void initEvent() {
        rlOfflineMap.setOnClickListener(this);
        rlSettingServer.setOnClickListener(this);
    }

    private void initData() {
        toolbarTitle.setText(getTitle());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.rl_offline_map:
                break;
            case R.id.rl_setting_server:
                intent.setClass(mContext, SetServerUrl.class);
                startActivity(intent);
                break;
        }
    }
}
