package com.wxf.accountbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wxf.accountbook.R;
import com.wxf.serviceport.entry.IncomeType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TypeSelectAdapter
 * @date on 2017/12/19 17:34
 */

public class TypeSelectAdapter extends BaseAdapter {
    public Context context;
    public List<IncomeType> incomeTypeList;

    public TypeSelectAdapter(Context context, List<IncomeType> incomeTypeList) {
        this.context = context;
        this.incomeTypeList = incomeTypeList;
    }

    @Override
    public int getCount() {
        return incomeTypeList.size();
    }

    @Override
    public Object getItem(int i) {
        return incomeTypeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder holder = null;
          if(view == null){
              view = LayoutInflater.from(context).inflate(R.layout.item_type,null);
              holder = new ViewHolder(view);
              view.setTag(holder);
          }else {
              holder = (ViewHolder) view.getTag();
          }
          holder.updateView(incomeTypeList.get(i));
          return  view;
    }
    class ViewHolder{
        @BindView(R.id.typename)
        TextView typename;
        public  ViewHolder(View rootView){
            ButterKnife.bind(this,rootView);
        }
        public void updateView(IncomeType incomeType){
            typename.setText(incomeType.getInfo());
        }
    }
}
