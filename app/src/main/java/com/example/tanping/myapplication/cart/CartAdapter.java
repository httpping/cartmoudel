package com.example.tanping.myapplication.cart;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.tanping.myapplication.R;

import java.util.List;

public class CartAdapter extends BaseMultiItemQuickAdapter<CartAdapterEntity,BaseViewHolder> {

    CartFragment fragment;

    public CartAdapter(List<CartAdapterEntity> data,CartFragment fragment) {
        super(data);
        //所有可能类型
        addItemType(CartAdapterEntity.AD, R.layout.cart_item_ad);
        addItemType(CartAdapterEntity.HEAD_TITLE, R.layout.cart_item_head_title);
        addItemType(CartAdapterEntity.GOODS, R.layout.cart_item_goods);
        addItemType(CartAdapterEntity.EMPTY_TITLE, R.layout.cart_item_empty_title);
        addItemType(CartAdapterEntity.EMPTY_GOODS, R.layout.cart_item_empty_goods);
        addItemType(CartAdapterEntity.LIKE_TITLE, R.layout.cart_item_like_title);
        addItemType(CartAdapterEntity.LIKE_GOODS, R.layout.cart_item_like_goods);
        addItemType(CartAdapterEntity.OTHER_GOODS_TITLE, R.layout.cart_item_other_goods_title);
        addItemType(CartAdapterEntity.ITEM_DIVIDER, R.layout.cart_item_divider_line);
        this.fragment = fragment;
    }

    @Override
    protected void convert(BaseViewHolder helper, CartAdapterEntity item) {
        View view =  helper.getView(R.id.goods_root);
        if (view !=null){
            view.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"xxx",0).show();
                }
            });
        }
    }
}
