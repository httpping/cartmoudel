package com.example.tanping.myapplication.cart;

import android.widget.Checkable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 购物车 adapter
 */
public class CartAdapterEntity implements MultiItemEntity,Checkable{

    public static final int AD= 0; //广告
    public static final int HEAD_TITLE= 1;
    public static final int GOODS= 2;
    public static final int EMPTY_TITLE= 3;
    public static final int EMPTY_GOODS= 4;
    public static final int LIKE_TITLE= 5;
    public static final int LIKE_GOODS= 6;
    public static final int OTHER_GOODS_TITLE= 7;
    public static final int ITEM_DIVIDER= 8;



    public boolean cheked;//是否选择
    public boolean isEnableChecked = false; //是否可选
    public int type ;

    @Override
    public int getItemType() {
        return type;
    }

    @Override
    public void setChecked(boolean checked) {
        this.cheked =checked;
    }

    @Override
    public boolean isChecked() {
        return cheked & isEnableChecked;
    }

    @Override
    public void toggle() {
        if (isEnableChecked) {
            cheked = !cheked;
        }
    }
}
