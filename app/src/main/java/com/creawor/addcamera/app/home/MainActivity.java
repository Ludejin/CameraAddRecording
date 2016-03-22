package com.creawor.addcamera.app.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.creawor.addcamera.R;
import com.creawor.addcamera.app.BaseActivity;
import com.creawor.addcamera.module.add.ui.AddCameraActivity;
import com.creawor.addcamera.widget.ConfirmDialogFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Context mContext;

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.main_menu_01)
    LinearLayout mainMenu01;
    @Bind(R.id.main_menu_02)
    LinearLayout mainMenu02;
    @Bind(R.id.main_menu_03)
    LinearLayout mainMenu03;
    @Bind(R.id.main_menu_04)
    LinearLayout mainMenu04;
    @Bind(R.id.main_menu_05)
    LinearLayout mainMenu05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);

        mContext = this;

        initToolbar();

        initData();
        initEvent();
    }

    private void initEvent() {
        mainMenu01.setOnClickListener(this);
        mainMenu02.setOnClickListener(this);
        mainMenu03.setOnClickListener(this);
        mainMenu04.setOnClickListener(this);
        mainMenu05.setOnClickListener(this);
    }

    private void initData() {
        toolbarTitle.setText(getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            mDialogFactory.showConfirmDialog("提示", "是否真的注销？", true,
                    new ConfirmDialogFragment.ConfirmDialogListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                        }
                    });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.main_menu_01:
                intent.setClass(mContext, AddCameraActivity.class);
                startActivity(intent);
                break;
            case R.id.main_menu_02:
                break;
            case R.id.main_menu_03:
                break;
            case R.id.main_menu_04:
                break;
            case R.id.main_menu_05:
                break;
        }
    }
}
