package com.example.tanping.myapplication.cart;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.tanping.myapplication.R;

import static com.example.tanping.myapplication.cart.CartAdapterEntity.EMPTY_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.HEAD_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.LIKE_GOODS;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.LIKE_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.OTHER_GOODS_TITLE;

/**
 * Created by tanping on 2018/3/19.
 * 购物车 分割
 */

public class CartAdapterOffsetDecoration extends RecyclerView.ItemDecoration  {
    /**
     * item之间的边距
     */
    private int margin;
    private boolean isOdd;
    int top;
    /**
     * 构造方法
     *
     * @param margin dp单位资源ID
     */
    public CartAdapterOffsetDecoration(int margin) {
        this.margin = margin;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int offset = margin;
        top = view.getResources().getDimensionPixelOffset(R.dimen.dp_8);

        //左到右
        ltr(outRect,view,parent,state);

    }

    public void ltr(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        RecyclerView.Adapter adapter =  parent.getAdapter();
        int postition = parent.getChildAdapterPosition(view);
        int viewType = adapter.getItemViewType(postition);

        final GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        final GridLayoutManager layoutManager1 = (GridLayoutManager) layoutManager;

        int spanCount = layoutManager1.getSpanCount();//获取当前布局列数
        int spanIndex = lp.getSpanIndex();//获取当前item的列索引

        if (viewType == LIKE_GOODS){//可能喜欢的商品
            if (spanIndex == 0){
                outRect.set(margin,margin,margin/2,0);
            }else {
                outRect.set(margin/2,margin,margin,0);
            }
        }else if (viewType == OTHER_GOODS_TITLE || viewType == EMPTY_TITLE  || viewType == LIKE_TITLE || viewType == HEAD_TITLE){
            outRect.set(0,top,0,0);
        }
    }

    public void rtl(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){

    }

}
