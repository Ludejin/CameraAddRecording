package com.creawor.addcamera.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.creawor.addcamera.R;

/**
 * Created by Jin_ on 2016/3/22
 * 邮箱：dejin_lu@creawor.com
 */
public class ListDialogFragment extends BaseDialogFragment {

    private static final String DATA_RESOURCE = "data_resource";

    private String[] mItemContents;
    private ListDialogListener mListener;

    public static interface ListDialogListener extends BaseDialogListener{
        void onItemClick(int position);
    }

    /**
     * @param itemContents
     * @param cancelable
     * @return
     */
    public static ListDialogFragment newInstance(String[] itemContents,boolean cancelable){

        ListDialogFragment dialog = new ListDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(DATA_RESOURCE, itemContents);
        putCancelableParam(bundle, cancelable);
        dialog.setArguments(bundle);
        return  dialog;
    }

    @Override
    protected void onReceiveDialogListener(BaseDialogListener listener) {
        super.onReceiveDialogListener(listener);
        if(listener instanceof ListDialogListener){
            mListener = (ListDialogListener)listener;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(!mIsCustomDialog){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setItems(mItemContents, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(mListener != null){
                        mListener.onItemClick(which);
                    }
                }
            });
            return builder.create();
        }else{
            return super.onCreateDialog(savedInstanceState);
        }
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mIsCustomDialog){
            View view = inflater.inflate(R.layout.dialog_cust_progress,container,false);
            //启用窗体的扩展特性。
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            return view;
        }else{
            return super.onCreateView(inflater,container,savedInstanceState);
        }
    }


    @Override
    protected void parseArgs(Bundle args) {
        super.parseArgs(args);
        mItemContents = args.getStringArray(DATA_RESOURCE);
    }
}
