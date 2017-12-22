package com.wxf.accountbook.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wxf.accountbook.R;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.serviceport.entry.Treasure;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName PieView
 * @date on 2017/12/15 11:22
 * 自定义饼状图
 *
 */

public class PieView <T extends Treasure>extends View {
    private Paint dataPaint;
    private Paint centerTextPaint;
    private  Paint mPaint;
    private Paint defaultPaint;
    float centerTextSize;
    float dataTextSize;
    int  centerTextColor;
    int  dataTextColor;
    String centerText;
    private int width;
    private int height;
    private int reslutWidth;
    private int resultHeight;
    private  String defaultStr="暂无数据";
    List<T> datas;
    private int sum= 0;

    private int[] mColors = {0xFF9CaF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PieView);
          centerTextSize =a.getDimension(R.styleable.PieView_centerTextSize,18F);
          dataTextSize   = a.getDimension(R.styleable.PieView_dataTextSize,16F);
         centerTextColor = a.getColor(R.styleable.PieView_centerTextColor,0x00000000);
         dataTextColor   = a.getColor(R.styleable.PieView_dataTextColor,0x00000000);
         centerText    = a.getString(R.styleable.PieView_centerText);
        centerTextPaint= new Paint();
        centerTextPaint.setColor(centerTextColor);
        centerTextPaint.setTextSize(centerTextSize);
        centerTextPaint.setStyle(Paint.Style.FILL);
        centerTextPaint.setAntiAlias(true);
        dataPaint =new Paint();
        dataPaint.setColor(dataTextColor);
        dataPaint.setTextSize(dataTextSize);
        dataPaint.setStyle(Paint.Style.FILL);
        dataPaint.setAntiAlias(true);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        defaultPaint=new Paint();
        defaultPaint.setStyle(Paint.Style.FILL);
        defaultPaint.setAntiAlias(true);
       /* List<PieTreasure> pieTreasureList = new ArrayList<>();
        for(int i=0;i<6;i++){
            PieTreasure pieTreasure = new PieTreasure();
            pieTreasure.setMoney(i*7+9);
            pieTreasure.setTreasurename("支付宝"+i);
            pieTreasureList.add(pieTreasure);
        }
        this.datas =(ArrayList<T>)pieTreasureList;
        updateData();*/

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width=w;
        this.height =h;
    }
    public void setData(List<T> datas) {
        this.datas = datas;
        if(datas == null){
            return;
        }
        updateData();
       invalidate();
    }

    /**
     * 完成数据的占比和颜色的确定
     */
    private void  updateData(){
        sum = 0;
        for(int  i =0;i<datas.size();i++){
            sum+=datas.get(i).getMoney();
            ((PieTreasure)datas.get(i)).setColor(mColors[i%mColors.length]);
        }
        for(int i =0;i<datas.size();i++){
            if(sum==0){
                ((PieTreasure) datas.get(0)).setPercent(0);
                ((PieTreasure) datas.get(0)).setAngle(360);
            }else {
                ((PieTreasure) datas.get(i)).setPercent((float) (datas.get(i).getMoney() * 1.0 / sum));
                ((PieTreasure) datas.get(i)).setAngle((float) (((PieTreasure) datas.get(i)).getPercent() * 360));
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int widthMode = MeasureSpec.getMode(widthMeasureSpec);
       int heightMode =MeasureSpec.getMode(heightMeasureSpec);
        int widthSize =MeasureSpec.getSize(widthMeasureSpec);
        int heightSize =MeasureSpec.getSize(heightMeasureSpec);

        if(MeasureSpec.AT_MOST==widthMode &&MeasureSpec.AT_MOST==heightMode){
            reslutWidth = 80 ;
            resultHeight = 80;
        }else if(MeasureSpec.AT_MOST==widthMode){
            reslutWidth = 80;
            resultHeight = heightSize;
        }else if(MeasureSpec.AT_MOST==heightMode){
            resultHeight = widthSize;
            reslutWidth =80;
        }else {
            reslutWidth =Math.min(widthSize,heightSize);
            resultHeight=Math.min(widthSize,heightSize);
        }
        resultHeight = Math.max(reslutWidth,resultHeight);
        reslutWidth = Math.max(reslutWidth,resultHeight);
        setMeasuredDimension(reslutWidth,resultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(Math.min(reslutWidth/2,resultHeight/2),Math.min(reslutWidth/2,resultHeight/2));
        if(datas==null||datas.size()==0){
            defaultPaint.setTextSize(centerTextSize);
            defaultPaint.setColor(mColors[0]);
            defaultPaint.setAntiAlias(true);
            canvas.drawText(defaultStr,0- defaultPaint.measureText(defaultStr)/2,0,defaultPaint);
            return;

        }
        float radius =(float) (Math.min(reslutWidth-getPaddingLeft()-getPaddingRight(),resultHeight)/2-getPaddingTop()-getPaddingBottom());
        RectF rect = new RectF(-radius, -radius, radius, radius);
        float currentStartAngle = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        for(int i = 0;i<datas.size();i++){

            PieTreasure pie= (PieTreasure) datas.get(i);
            if(pie.getAngle()<1){
                continue;
            }
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect,currentStartAngle,pie.getAngle(),true,mPaint);
            float textAngle= currentStartAngle+pie.getAngle()/2;
            currentStartAngle += pie.getAngle();
            double x =  Math.cos(textAngle/180*Math.PI)*radius*0.75;
            double y = Math.sin(textAngle/180*Math.PI)*radius*0.75;
            Rect textRect = new Rect();
            dataPaint.getTextBounds(pie.getTreasurename(), 0, pie.getTreasurename().length(), textRect);
            int width = textRect.width();//文字宽
            int height = textRect.height();//文字高
            canvas.drawText(pie.getTreasurename(),(float) (x-width/2),(float) (y-height/2),dataPaint);
            canvas.drawText(df.format(pie.getPercent() * 100) + "%",(float) x+-width/2+5,(float) y+height,dataPaint);

        }
        mPaint.setColor(0xFFFFFFFF);
        canvas.drawCircle(0, 0,radius/2,mPaint);

        float len = centerTextPaint.measureText(centerText+df.format((sum*1.0)/100));
        canvas.drawText(centerText+df.format((sum*1.0)/100),0-len/2,0,centerTextPaint);




    }
}
