package com.creawor.addcamera.module.add.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.creawor.addcamera.R;
import com.creawor.addcamera.app.Base2ndActivity;
import com.creawor.addcamera.module.add.view.SelectAreaCallback;
import com.creawor.addcamera.widget.ListDialogFragment;
import com.creawor.addcamera.widget.LongTextDialogFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class AddCameraActivity extends Base2ndActivity
        implements OnClickListener, LongTextDialogFragment.onOkListener
        ,ListDialogFragment.ListDialogListener,SelectAreaCallback{

    @Bind(R.id.btn_get_lon_lat)
    Button btnGetLonLat;
    @Bind(R.id.btn_get_orientation)
    Button btnGetOrientation;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.spn_vision_size)
    AppCompatSpinner spnVisionSize;
    @Bind(R.id.tv_install_type)
    TextView tvInstallType;
    @Bind(R.id.edt_height)
    EditText edtHeight;
    @Bind(R.id.edt_centre_dist_int)
    EditText edtCentreDistInt;
    @Bind(R.id.edt_centre_dist_dec)
    EditText edtCentreDistDec;
    @Bind(R.id.tv_longitude)
    TextView tvLongitude;
    @Bind(R.id.tv_latitude)
    TextView tvLatitude;
    @Bind(R.id.tv_orientation)
    TextView tvOrientation;
    @Bind(R.id.iv_take_snapshot)
    ImageView ivTakeSnapshot;
    @Bind(R.id.iv_snapshot)
    ImageView ivSnapshot;
    @Bind(R.id.tv_pro_city)
    TextView tvProCity;
    @Bind(R.id.btn_add)
    Button btnAdd;
    @Bind(R.id.tv_detail_address)
    TextView tvDetailAddress;

    private static final String TAG = "AddCamera";
    private static final int INSTALL_TYPE = 1;
    private static final int DETAIL_ADDRESS = 2;

    private Context mContext;
    private AreaPopupWindow mPopup;
    private String[] mInstallType;
    private int showType = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_add_camera);
        ButterKnife.bind(this);

        mContext = this;

        initToolbar();
        initData();
        initEvent();
    }

    private void initEvent() {
        tvInstallType.setOnClickListener(this);
        btnGetLonLat.setOnClickListener(this);
        btnGetOrientation.setOnClickListener(this);
        ivTakeSnapshot.setOnClickListener(this);
        ivSnapshot.setOnClickListener(this);
        tvProCity.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        tvDetailAddress.setOnClickListener(this);
        mPopup.setListener(this);
    }

    private void initData() {
        toolbarTitle.setText(getTitle());

        mPopup = new AreaPopupWindow(mContext);
        mPopup.setAnimationStyle(R.style.anim_popup_window);

        mInstallType = getResources().getStringArray(R.array.ary_install_type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_detail_address:
                showType = DETAIL_ADDRESS;
                mDialogFactory.showLongTextDialog("请输入摄像机地址",
                        tvDetailAddress.getText().toString(), true, AddCameraActivity.this);
                break;
            case R.id.btn_get_lon_lat:
                Toast.makeText(mContext, "哈哈哈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_install_type:
                mDialogFactory.showListDialog(mInstallType,true,AddCameraActivity.this);
                break;
            case R.id.tv_pro_city:
                mPopup.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM,
                        0, 0);
                break;

        }
    }

    @Override
    public void doOk(String txtInfo) {
        if (!TextUtils.isEmpty(txtInfo)) {
            if (DETAIL_ADDRESS == showType) {
                tvDetailAddress.setText(txtInfo);
            } else if (INSTALL_TYPE == showType) {
                tvInstallType.setText(txtInfo);
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        if (4 == position) {
            showType = INSTALL_TYPE;
            mDialogFactory.showLongTextDialog("请输入其他安装方式","",true,AddCameraActivity.this);
        } else {
            tvInstallType.setText(mInstallType[position]);
        }
    }

    @Override
    public void doOk(String provinceName, String cityName, String regionName) {
        mPopup.dismiss();
        tvProCity.setText(provinceName+cityName+regionName);
    }
}
