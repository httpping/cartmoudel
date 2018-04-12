package com.example.tanping.myapplication.cart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.tanping.myapplication.R;

import java.util.LinkedList;
import java.util.List;

import static com.example.tanping.myapplication.cart.CartAdapterEntity.AD;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.EMPTY_GOODS;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.EMPTY_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.GOODS;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.HEAD_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.ITEM_DIVIDER;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.LIKE_GOODS;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.LIKE_TITLE;
import static com.example.tanping.myapplication.cart.CartAdapterEntity.OTHER_GOODS_TITLE;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;


    List<CartAdapterEntity> mDatas = new LinkedList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_main_fragment,container);
        recyclerView = new RecyclerView(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        CartAdapterOffsetDecoration decoration = new CartAdapterOffsetDecoration(getResources().getDimensionPixelOffset(R.dimen.dp_16));
        recyclerView.addItemDecoration(decoration);

        createData();//创造数据

        CartAdapter adapter = new CartAdapter(mDatas,this);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                if (mDatas.get(position).type == LIKE_GOODS){
                    return  1;
                }
                return 2;
            }
        });
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }


    public void createData(){
        CartAdapterEntity entitylike = new CartAdapterEntity();
        entitylike.type = AD;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = HEAD_TITLE;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = ITEM_DIVIDER;
        mDatas.add(entitylike);


        entitylike = new CartAdapterEntity();
        entitylike.type = GOODS;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = GOODS;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = GOODS;
        mDatas.add(entitylike);


        entitylike = new CartAdapterEntity();
        entitylike.type = OTHER_GOODS_TITLE;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = ITEM_DIVIDER;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = GOODS;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = GOODS;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = EMPTY_TITLE;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = EMPTY_GOODS;
        mDatas.add(entitylike);
        entitylike = new CartAdapterEntity();
        entitylike.type = EMPTY_GOODS;
        mDatas.add(entitylike);





       /* for (int i = 0 ;i <8;i++){
            CartAdapterEntity entity = new CartAdapterEntity();
            entity.type = i % OTHER_GOODS_TITLE;
            mDatas.add(entity);
        }*/
         entitylike = new CartAdapterEntity();
        entitylike.type =LIKE_TITLE;
        mDatas.add(entitylike);
        for (int i = 0 ;i <30;i++){
            CartAdapterEntity entity = new CartAdapterEntity();
            entity.type = LIKE_GOODS;
            mDatas.add(entity);
        }

    }
}
