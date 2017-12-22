package com.wxf.accountbook.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxf.accountbook.R;


/**
 * Created by FB on 2017/1/10.
 */

public class RemindDialog extends Dialog {
    private Context context ;
    private Button ensure;
    private ImageView cancel;
    private TextView dialogContent;
    private TextView tv_message_title;
    private EnsureLisenter lisenter;
    private CloseLisenter closeLisenter;

    public void setCloseLisenter(CloseLisenter closeLisenter) {
        this.closeLisenter = closeLisenter;
    }

    public void setLisenter(EnsureLisenter lisenter) {
        this.lisenter = lisenter;
    }
   public void setTitleMessage(String  title){
       tv_message_title.setText(title);

   }
    public RemindDialog(Context context) {

        this(context, R.style.dialogstyle);
    }

    public RemindDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_remind);
        getWindow().getDecorView().setPadding(36,0,36,0);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        initView();
        initData();
        response();
    }

    private void initView(){
        tv_message_title=(TextView) findViewById(R.id.tv_message_title);
        ensure = (Button) findViewById(R.id.ensure);
        cancel = (ImageView) findViewById(R.id.dialog_title_close);
        dialogContent = (TextView) findViewById(R.id.dialog_content);
    }
    public void setContent(String content){
        dialogContent.setText(content);
    }
    private void initData(){



    }
    private void  response(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(closeLisenter!=null){
                   closeLisenter.onClose();
                }
                dismiss();
            }
        });
        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lisenter!=null){
                    lisenter.ensure();
                }
                dismiss();



            }
        });

    }
   public   interface  EnsureLisenter{
        public abstract void ensure();
    }
    public  interface  CloseLisenter{
        public abstract void onClose();
    }

}
