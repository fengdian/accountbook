package com.wxf.accountbook.bases;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.wxf.accountbook.R;

import butterknife.ButterKnife;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName BaseActivity
 * @date on 2017/12/11 11:37
 */

public abstract class BaseActivity extends Activity {
    public  static  final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=10001;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceId());
        ButterKnife.bind(this);
        onResponse();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
           ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }else{
            //
        }
    }

    public void backAnim() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    // 前进动画
    public void intoAnim() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public abstract int getContentResourceId ();
    public  abstract  void   onResponse();
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

}
