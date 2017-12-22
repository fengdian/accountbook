package com.wxf.accountbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.wxf.accountbook.Contracts.TreasureDistriContract;
import com.wxf.accountbook.R;
import com.wxf.accountbook.adapters.TreasureTypeAdapter;
import com.wxf.accountbook.bases.BaseActivity;
import com.wxf.accountbook.components.DaggerTreasureDistriCompont;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.accountbook.modules.TreasureDistriModule;
import com.wxf.accountbook.presenter.TreasureDistriPresenter;
import com.wxf.accountbook.views.PieView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnItemClick;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistriActivity
 * @date on 2017/12/15 15:08
 */

public class TreasureDistriActivity extends BaseActivity implements TreasureDistriContract.TreasureDistriView {

    @BindView(R.id.pieview)
    PieView pieView;
    @BindView(R.id.lv_treasure)
    ListView lv_treasure;
    @Inject
    TreasureDistriPresenter presenter;
    @Inject
    TreasureTypeAdapter adapter;
    @Override
    public int getContentResourceId() {
        return R.layout.activity_treasuredistri;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerTreasureDistriCompont.builder().treasureDistriModule(new TreasureDistriModule(this)).build().inject(this);
        presenter.loadTreasure();
        lv_treasure.setAdapter(adapter);
    }

    @Override
    public void onResponse() {

    }

    @Override
    public void toast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadTreasure(List<PieTreasure> list) {
        pieView.setData(list);
        Log.i("wxf", "loadTreasure: "+list.size());
        adapter.updateData(list);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void clickTreasure(String id) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.loadTreasure();
    }

    @OnItemClick(R.id.lv_treasure)
    public  void itemClick(int pos){
        Log.i("wxf", "itemClick: 点击了"+((PieTreasure)adapter.getItem(pos)).getTreasurename());
        Intent intent = new Intent(this,TreasureItemDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pieTreasure",(PieTreasure)adapter.getItem(pos));
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}
