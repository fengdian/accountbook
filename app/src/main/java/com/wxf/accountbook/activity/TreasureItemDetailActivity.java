package com.wxf.accountbook.activity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wxf.accountbook.Contracts.TreasureItemContract;
import com.wxf.accountbook.R;
import com.wxf.accountbook.adapters.TreasureChangeAdapter;
import com.wxf.accountbook.bases.BaseActivity;
import com.wxf.accountbook.components.DaggerTreasureDetailComponent;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.accountbook.modules.TreasureDetailMoule;
import com.wxf.accountbook.presenter.TreasureDetailPresenter;
import com.wxf.accountbook.views.AddChangeDialog;
import com.wxf.serviceport.entry.IncomeType;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class TreasureItemDetailActivity extends BaseActivity  implements TreasureItemContract.ITreasureDetailView{
   @BindView(R.id.title)
    TextView title;
   @BindView(R.id.lv_changes)
    ListView lv_changes;
   @BindView(R.id.addtreasurechange)
   TextView addtreasurechange;
   @Inject
   TreasureDetailPresenter presenter;
   PieTreasure pieTreasure;
   TreasureChangeAdapter adapter;
    AddChangeDialog dialog;
    private int inCome;
    private  int money;
    private int tId;

    @Override
    public void toast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
     pieTreasure= (PieTreasure) getIntent().getBundleExtra("bundle").getSerializable("pieTreasure");
     DaggerTreasureDetailComponent.builder().treasureDetailMoule(new TreasureDetailMoule(this)).build().inject(this);
      presenter.loadTreasureChange(pieTreasure.getId(),1,10);
       adapter= new TreasureChangeAdapter(this);
       lv_changes.setAdapter(adapter);
       title.setText(pieTreasure.getTreasurename());

 }

    @Override
    public void addChangeSuccess(String message) {
        toast(message);
        dialog.dismiss();
        if(inCome ==0){
            if(tId==5){
                pieTreasure.setMoney(pieTreasure.getMoney()+money);
            }else  if(tId==6){
                pieTreasure.setMoney(pieTreasure.getMoney()-money);
            }
        }else if(inCome ==2){
            pieTreasure.setMoney(money);
        }else{
            pieTreasure.setMoney(pieTreasure.getMoney()+money*inCome);
        }
        presenter.loadTreasureChange(pieTreasure.getId(),1,10);
    }

    @Override
    public void loadTreasureChange(List<TreasureChangeRes> list) {
        adapter.updateData(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getIncomeTypes(List<IncomeType> typeList) {
        dialog = new AddChangeDialog(this,pieTreasure);
        dialog.show();
        dialog.setData(typeList);
        dialog.setTitle("添加记录");
        dialog.setListener(new AddChangeDialog.EnsureClickListener() {
            @Override
            public void onClick(int id, int amount,int income) {
                inCome = income;
                money = amount;
                tId = id;
               presenter.addTreasureChange(pieTreasure.getId(),amount,income,id);
            }
        });
    }

    @Override
    public int getContentResourceId() {
        return R.layout.activity_treasure_item_detail;
    }

    @Override
    public void onResponse() {

    }

    /**
     * 在这里
     */
    @OnClick(R.id.addtreasurechange)
    public  void addtreasurechange(){
       presenter.getIncomeTypes();
    }
}
