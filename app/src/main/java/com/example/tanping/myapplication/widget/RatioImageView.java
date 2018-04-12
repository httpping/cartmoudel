package com.example.tanping.myapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.bumptech.glide.request.target.Target;
import com.example.tanping.myapplication.R;

/**
 *
 * @Created by tanping
 *
 * 不能加载动画，会有bug。除非高度限高
 *
 * 三种模式 ：
 * ratio = 0 普通image
 * ratio >0  按比例
 * ratio <0  根据图片适配高度
 *
 */

public class RatioImageView extends android.support.v7.widget.AppCompatImageView  {
    //宽高比，由我们自己设定
    private float ratio;
    String imageUrl ;
    boolean isLoadSuccess ;
    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        //根据属性名称获取对应的值，属性名称的格式为类名_属性名
        ratio = typedArray.getFloat(R.styleable.RatioImageView_ratio, 0.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (ratio == 0.0){
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        }else if (ratio > 0){
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = Math.round(width/ratio);
            setMeasuredDimension(width,height);
        }else { // radio <0 高度随图片变
            Drawable d = getDrawable();
            if (d != null) {
                // ceil not round - avoid thin vertical gaps along the left/right edges
                int width = MeasureSpec.getSize(widthMeasureSpec);
                //宽度定- 高度根据使得图片的宽度充满屏幕
                int height = (int) Math.ceil((float) width * (float) d.getIntrinsicHeight() / (float) d.getIntrinsicWidth());
                setMeasuredDimension(width, height);
            }
        }
    }

    /**
     * 设置宽高比
     * @param ratio
     */
    public void setRatio(float ratio){
        this.ratio = ratio;
    }


    /**
     * 宽高比
     * @param width
     * @param height
     */
    public void setRatio(float width,float height){
        if (height == 0 ){
            ratio = -1;
            return;
        }
        ratio = width / height;
        requestLayout();
    }

    public float getRatio(){
        return  ratio;
    }


    public boolean isLoadSuccess() {
        return isLoadSuccess;
    }


}