package com.wxf.accountbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wxf.accountbook.Contracts.TreasureDistriContract;
import com.wxf.accountbook.R;
import com.wxf.accountbook.activity.TreasureDistriActivity;
import com.wxf.accountbook.entry.PieTreasure;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/18.
 *
 * @fileName TreasureTypeAdapter
 * @date on 2017/12/18 14:21
 */

public class TreasureTypeAdapter extends BaseAdapter {
    DecimalFormat df = new DecimalFormat("0.00");
    DecimalFormat dfM = new DecimalFormat("00.00");
    @Inject
   TreasureDistriActivity context;
     List<PieTreasure>  treasureList;


    @Inject
    public TreasureTypeAdapter() {
        treasureList = new ArrayList<>();
    }
     public  void  updateData(List<PieTreasure> list){

          treasureList= list;
     }

    @Override
    public int getCount() {
        return treasureList.size();
    }

    @Override
    public Object getItem(int i) {
        return treasureList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder =null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_treasure,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.update(treasureList.get(i));
        return view;
    }
    class ViewHolder{
        @BindView(R.id.treasure_typename)
        public TextView treasure_typename;
        @BindView(R.id.treasure_amount)
        public  TextView treasure_amount;
        public  ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
        public  void update(PieTreasure treasure){
              treasure_typename.setText(treasure.getTreasurename());
              treasure_amount.setText("占比："+dfM.format(treasure.getPercent()*100)+"%\t"+"金额："+df.format((treasure.getMoney()*1.0)/100)+"元");
        }
    }
}
