package com.wxf.accountbook.bases;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wxf.accountbook.R;

import butterknife.ButterKnife;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName BaseActivity
 * @date on 2017/12/11 11:37
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceId());
        ButterKnife.bind(this);
        onResponse();
    }

    public void backAnim() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    // 前进动画
    public void intoAnim() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public abstract int getContentResourceId ();
    public  abstract  void   onResponse();;

}
