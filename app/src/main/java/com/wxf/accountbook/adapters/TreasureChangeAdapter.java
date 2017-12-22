package com.wxf.accountbook.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wxf.accountbook.R;
import com.wxf.accountbook.Utils;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName TreasureChangeAdapter
 * @date on 2017/12/20 15:48
 */

public class TreasureChangeAdapter extends BaseAdapter {
  List<TreasureChangeRes> changeList;
  Context context;
    DecimalFormat df = new DecimalFormat("0.00");

    public TreasureChangeAdapter(Context context) {
        this.context = context;
        changeList = new ArrayList<>();
    }
    public  void updateData(List<TreasureChangeRes> changes){
        changeList.clear();
        changeList.addAll(changes);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return changeList.size();
    }

    @Override
    public Object getItem(int i) {
        return changeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder =null;
        if(view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_treasurechange,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.updateView(changeList.get(i));

        return  view;
    }
    class  ViewHolder{
        @BindView(R.id.tv)
        TextView tv ;
        public  ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
        public  void updateView(TreasureChangeRes change){

            tv.setText(change.getCreatetime()+"\t"+ Utils.getIncomeInfo(change.getType())+"\t"+df.format(change.getMoney()*1.0/100)+"元");
            Log.i("wxf", "updateView更新数据: "+tv.getText().toString());
        }
    }
}
