package com.creawor.addcamera.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.creawor.addcamera.R;
import com.creawor.addcamera.common.dialog.DialogFactory;
import com.creawor.addcamera.widget.BaseDialogFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class BaseActivity extends AppCompatActivity {

    protected DialogFactory mDialogFactory;

    public BaseDialogFragment.BaseDialogListener getDialogListener(){
        return mDialogFactory.mListenerHolder.getDialogListener();
    }

    /**
     * 清空DialogListenerHolder中的dialog listener
     */
    public void clearDialogListener(){
        mDialogFactory.mListenerHolder.setDialogListener(null);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mDialogFactory.mListenerHolder.saveDialogListenerKey(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDialogFactory = new DialogFactory(getSupportFragmentManager(),savedInstanceState);
        mDialogFactory.restoreDialogListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(this.getResources().getColor(R.color.colorPrimary));
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }

    protected void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setElevation(0);
        mActionBar.setDisplayShowTitleEnabled(false);
    }
}
