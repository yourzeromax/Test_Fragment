package com.yourzeromax.test_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yourzeromax.test_fragment.fragments.FragmentA;
import com.yourzeromax.test_fragment.fragments.FragmentB;
import com.yourzeromax.test_fragment.fragments.FragmentC;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtnFragmentA, mBtnFragmentB, mBtnFragmentC;
    Fragment mFragmentA, mFragmentB, mFragmentC;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        initFragments();
    }

    private void initButtons() {
        mBtnFragmentA = findViewById(R.id.btn_fragmentA);
        mBtnFragmentB = findViewById(R.id.btn_fragmentB);
        mBtnFragmentC = findViewById(R.id.btn_fragmentC);
        mBtnFragmentA.setOnClickListener(this);
        mBtnFragmentB.setOnClickListener(this);
        mBtnFragmentC.setOnClickListener(this);
    }

    private void initFragments() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        mFragmentC = new FragmentC();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fragmentA:
                mFragmentManager.beginTransaction().add(R.id.fl_contrainer, mFragmentA).commit();
                break;
            case R.id.btn_fragmentB:
               // mFragmentManager.beginTransaction().remove(mFragmentA).commit();
               // mFragmentManager.beginTransaction().add(R.id.fl_contrainer,mFragmentB).commit();
              //  mFragmentManager.beginTransaction().hide(mFragmentA).commit();
                mFragmentManager.beginTransaction().detach(mFragmentA).commit();
                break;
            case R.id.btn_fragmentC:
               // mFragmentTransaction.add(R.id.fl_contrainer, mFragmentC).commit();
                //mFragmentManager.beginTransaction().add(R.id.fl_contrainer,mFragmentC).commit();
              //  mFragmentManager.beginTransaction().replace(R.id.fl_contrainer,mFragmentB).commit();
               // mFragmentManager.beginTransaction().show(mFragmentA).commit();
                mFragmentManager.beginTransaction().attach(mFragmentA).commit();
                break;
        }
    }
}
