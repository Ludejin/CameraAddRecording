package com.creawor.addcamera.module.add.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.creawor.addcamera.R;
import com.creawor.addcamera.module.add.view.SelectAreaCallback;

import java.util.ArrayList;
import java.util.List;

import creawor.wheel.adapter.ArrayWheelAdapter;
import creawor.wheel.bean.City;
import creawor.wheel.bean.Province;
import creawor.wheel.bean.Region;
import creawor.wheel.utils.GetCity;
import creawor.wheel.utils.GetProvince;
import creawor.wheel.utils.GetRegion;
import creawor.wheel.widget.OnWheelChangedListener;
import creawor.wheel.widget.WheelView;

/**
 * Created by Jin_ on 2016/3/22
 * 邮箱：dejin_lu@creawor.com
 */
public class AreaPopupWindow extends PopupWindow implements View.OnClickListener {
    private View mConvertView;
    private int provinceId = -1;
    private int cityId = -1;
    private int regionId = -1;
    private String provinceName = "";
    private String cityName = "";
    private String regionName = "";
    private WheelView wheelProvince;
    private WheelView wheelCity;
    private WheelView wheelRegion;
    private Button btnOk;
    private Button btnCancel;
    private List<Province> provinceList = new ArrayList<Province>();
    private List<City> cityList = new ArrayList<City>();
    private List<City> cityTempList = new ArrayList<City>();
    private List<Region> regionList = new ArrayList<Region>();
    private List<Region> regionTempList = new ArrayList<Region>();
    private String[] provinceArray;
    private String[] cityArray;
    private String[] regionArray;

    private SelectAreaCallback mListener;

    private Context mContext;

    public void setListener(SelectAreaCallback listener) {
        this.mListener = listener;
    }

    public AreaPopupWindow(Context context) {
        super(context);
        mContext = context;
        mConvertView = LayoutInflater.from(context).inflate(R.layout.popwin_area_sel, null);

        setContentView(mConvertView);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());

        setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });

        initView();
        initEvent();
        initData();
    }

    private void initData() {

        provinceList = new GetProvince().getProvinces(mContext);
        cityList = new GetCity().getCity(mContext);
        regionList = new GetRegion().getRegion(mContext);

        provinceArray = new String[provinceList.size()];
        int i = 0;
        for (Province a : provinceList) {
            if (a.getProvincename() != null) {
                provinceArray[i] = a.getProvincename();
            } else {
                provinceArray[i] = " ";
            }
            i++;
        }
        provinceName = provinceList.get(0).getProvincename();
        provinceId = provinceList.get(0).getProvinceid();

        wheelProvince.setViewAdapter(new ArrayWheelAdapter<String>(mContext,
                provinceArray));
        wheelProvince.setCurrentItem(0);
        wheelProvince.setVisibleItems(8);

        for (City a : cityList) {
            if (a.getParentid() == provinceId) {
                cityTempList.add(a);
            }
        }
        int j = 0;
        cityArray = new String[cityTempList.size()];
        for (City a : cityTempList) {
            if (a.getCityname() != null) {
                cityArray[j] = a.getCityname();
            } else {
                cityArray[j] = " ";
            }
            j++;
        }
        cityName = cityTempList.get(0).getCityname();
        cityId = cityTempList.get(0).getCityid();
        wheelCity.setViewAdapter(new ArrayWheelAdapter<String>(mContext, cityArray));
        wheelCity.setCurrentItem(0);
        wheelCity.setVisibleItems(8);

        for (Region a : regionList) {
            if (a.getParentid() == cityId) {
                regionTempList.add(a);
            }
        }
        int k = 0;
        regionArray = new String[regionTempList.size()];
        for (Region a : regionTempList) {
            if (a.getRegionname() != null) {
                regionArray[k] = a.getRegionname();
            } else {
                regionArray[k] = " ";
            }
            k++;
        }
        regionName = regionTempList.get(0).getRegionname();
        regionId = regionTempList.get(0).getRegionid();

        wheelRegion.setViewAdapter(new ArrayWheelAdapter<String>(mContext,
                regionArray));
        wheelRegion.setCurrentItem(0);
        wheelRegion.setVisibleItems(8);
    }

    private void initEvent() {
        WheelListener listener = new WheelListener();
        wheelProvince.addChangingListener(listener);
        wheelCity.addChangingListener(listener);
        wheelRegion.addChangingListener(listener);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    private void initView() {
        wheelProvince = (WheelView) mConvertView.findViewById(R.id.wheel_province);
        wheelCity = (WheelView) mConvertView.findViewById(R.id.wheel_city);
        wheelRegion = (WheelView) mConvertView.findViewById(R.id.wheel_region);
        btnCancel = (Button) mConvertView.findViewById(R.id.btn_cancel);
        btnOk = (Button) mConvertView.findViewById(R.id.btn_ok);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_ok:
                mListener.doOk(provinceName,cityName,regionName);
                break;
        }
    }

    class WheelListener implements OnWheelChangedListener {

        @Override
        public void onChanged(WheelView wheel, int oldValue, int newValue) {
            if (wheel == wheelProvince) {
                provinceName = provinceList.get(newValue).getProvincename();
                provinceId = provinceList.get(newValue).getProvinceid();

                cityTempList.clear();
                for (City city : cityList) {
                    if (city.getParentid() == provinceId) {
                        cityTempList.add(city);
                    }
                }
                int index = 0;
                cityArray = new String[cityTempList.size()];
                for (City city : cityTempList) {
                    if (city.getCityname() != null) {
                        cityArray[index] = city.getCityname();
                    } else {
                        cityArray[index] = " ";
                    }
                    index ++;
                }
                cityName = cityTempList.get(0).getCityname();
                cityId = cityTempList.get(0).getCityid();

                wheelCity.setViewAdapter(new ArrayWheelAdapter<String>(mContext,cityArray));
                wheelCity.setCurrentItem(0);

                regionTempList.clear();
                for (Region region : regionList) {
                    if (region.getParentid() == cityId) {
                        regionTempList.add(region);
                    }
                }
                int k = 0;
                regionArray = new String[regionTempList.size()];
                for (Region a : regionTempList) {
                    if (a.getRegionname() != null) {
                        regionArray[k] = a.getRegionname();
                    } else {
                        regionArray[k] = " ";
                    }
                    k++;
                }
                regionName = regionTempList.get(0).getRegionname();
                regionId = regionTempList.get(0).getRegionid();
                wheelRegion.setViewAdapter(new ArrayWheelAdapter<String>(mContext,
                        regionArray));
                wheelRegion.setCurrentItem(0);
            } else if (wheel == wheelCity) {
                cityName = cityTempList.get(newValue).getCityname();
                cityId = cityTempList.get(newValue).getCityid();
                regionTempList.clear();
                for (Region a : regionList) {
                    if (a.getParentid() == cityId) {
                        regionTempList.add(a);
                    }
                }
                int k = 0;
                regionArray = new String[regionTempList.size()];
                for (Region a : regionTempList) {
                    if (a.getRegionname() != null) {
                        regionArray[k] = a.getRegionname();
                    } else {
                        regionArray[k] = " ";
                    }
                    k++;
                }
                if (regionTempList.size() > 0) {
                    regionName = regionTempList.get(0).getRegionname();
                    regionId = regionTempList.get(0).getRegionid();
                } else {
                    regionName = "";
                    regionId = 0;
                }
                wheelRegion.setViewAdapter(new ArrayWheelAdapter<String>(mContext,
                        regionArray));
                wheelRegion.setCurrentItem(0);
            } else {
                regionName = regionTempList.get(newValue).getRegionname();
                regionId = regionTempList.get(newValue).getRegionid();
            }
        }
    }
}
