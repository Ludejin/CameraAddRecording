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
import android.widget.EditText;

import com.creawor.addcamera.R;

/**
 * Created by Jin_ on 2016/3/22
 * 邮箱：dejin_lu@creawor.com
 */
public class LongTextDialogFragment extends BaseDialogFragment {
    private onOkListener mListener;
    private String defStr;

    public interface onOkListener extends BaseDialogListener {
        void doOk(String txtInfo);
    }

    public static LongTextDialogFragment newInstance(String title,String defStr, boolean cancelable) {
        LongTextDialogFragment dialog = new LongTextDialogFragment();
        Bundle bundle = new Bundle();
        putTitleParam(bundle, title);
        putMessageParam(bundle,defStr);
        putCancelableParam(bundle, cancelable);
        putIsCustomParam(bundle,false);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    protected void onReceiveDialogListener(BaseDialogListener listener) {
        if (listener instanceof onOkListener) {
            mListener = (onOkListener) listener;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (!mIsCustomDialog) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_long_text,null);
            final EditText edtLongTextInfo = (EditText) view.findViewById(R.id.edt_long_text_info);
            edtLongTextInfo.setText(defStr == null ? "" : defStr);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setView(view)
                    .setTitle(mTitle == null ?getString(R.string.app_name) : mTitle)
                    .setPositiveButton(getString(R.string.btn_Ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mListener.doOk(edtLongTextInfo.getText().toString());
                        }
                    })
                    .setNegativeButton(getString(R.string.btn_Cancel), null);
            return builder.create();
        } else {
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
        if (mIsCustomDialog) {
            View view = inflater.inflate(R.layout.dialog_long_text, container, false);
            //启用窗体的扩展特性。
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            return view;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    protected void parseArgs(Bundle args) {
        super.parseArgs(args);
        defStr = parseMessageParam();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
