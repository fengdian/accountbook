package com.wxf.accountbook.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxf.accountbook.R;
import com.wxf.accountbook.adapters.TypeSelectAdapter;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.serviceport.entry.IncomeType;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName AddChangeDialog
 * @date on 2017/12/19 16:13
 */

public class AddChangeDialog extends Dialog {
    EnsureClickListener listener;
    @BindView(R.id.ensure)
    Button ensure;
    @BindView(R.id.treasurename)
     TextView treasurename;
    @BindView(R.id.operate_type)
     TextView operate_type;
    @BindView(R.id.treasure_amount)
     TextView treasure_amount;
    @BindView(R.id.tv_message_title)
     TextView tv_message_title;
    @BindView(R.id.dialog_title_close)
     ImageView dialog_title_close;
    private List<IncomeType> incomeTypeList;
    private  Context context;
     IncomeType incomeType;
    PieTreasure pieTreasure;
    public AddChangeDialog(Context context, PieTreasure pieTreasure) {

        this(context, R.style.dialogstyle);
        this.pieTreasure = pieTreasure;
    }
    public  void setData(List<IncomeType> list){
             incomeTypeList.clear();
             incomeTypeList.addAll(list);
    }

    public void setListener(EnsureClickListener listener) {
        this.listener = listener;
    }
     public  void setTitle(String title){
          tv_message_title.setText(title);
     }
    public AddChangeDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        incomeTypeList = new ArrayList<>();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_addchange);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ButterKnife.bind(this);
        treasurename.setText("财富类型：\t"+pieTreasure.getTreasurename());
    }
    @OnClick(R.id.ensure)
    public  void addChange(View view){
        if(listener!=null){
           listener.onClick(incomeType.getId(),(int)(Float.parseFloat(treasure_amount.getText().toString().trim())*100),incomeType.getIncome());
        }

    }
    @OnClick(R.id.operate_type)
    public  void showType(View view){

        TypeSelectPopuWindow popuWindow = new TypeSelectPopuWindow(context, view.getWidth() - 12, new TypeSelectAdapter(context, incomeTypeList), new TypeSelectPopuWindow.ItemClickListerer() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                incomeType = incomeTypeList.get(pos);
                operate_type.setText(incomeTypeList.get(pos).getInfo());
            }
        });
        popuWindow.showPopupWindow(view);

    }
    @OnClick(R.id.dialog_title_close)
     public void  clickCose(){
          dismiss();
     }

     public interface  EnsureClickListener{
        public  void onClick(int type,int amount,int income);
     }
}
