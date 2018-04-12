package com.example.tanping.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tanping.myapplication.cart.CartFragment;

public class MainActivity extends AppCompatActivity {

    RedPointImageView redPointImageView;

    CartFragment cartFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartFragment = new CartFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_demo,cartFragment).commit();
    }
}
