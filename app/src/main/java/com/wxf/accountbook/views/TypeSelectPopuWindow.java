package com.wxf.accountbook.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.wxf.accountbook.R;


/**
 * Created by FB on 2016/11/14.
 */

public class TypeSelectPopuWindow extends PopupWindow {
    private BaseAdapter adapter ;
    private ListView lv ;
    private ItemClickListerer listener ;
    private View contentView;
    private Context context;

    public TypeSelectPopuWindow(Context context , int width, BaseAdapter adapter , ItemClickListerer listener) {
        this.adapter =adapter;
        this.context = context;
        this.listener = listener;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.layout_type_select, null);
        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(width);

        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        initView(contentView);
        onResponse();



    }
    private void initView(View contentView){
        lv =(ListView)contentView.findViewById(R.id.lv);
        lv.setAdapter(adapter);


    }
    private void onResponse(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listener !=null)
                  listener.onItemClick(adapterView,view,i,l);
                dismiss();
            }
        });
    }
    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 10);
        } else {
            this.dismiss();
        }
    }
   public interface  ItemClickListerer{

        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l);
    }

}
