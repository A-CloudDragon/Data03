package com.jiyun.data03;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.anim_img)
    ImageView mAnimImg;
    @BindView(R.id.anim_tv)
    TextView mAnimTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.s);
        mAnimImg.startAnimation(animation);

          new CountDownTimer(10000,100){

                      @Override
                      public void onTick(long millisUntilFinished) {
                          mAnimTv.setText(millisUntilFinished/1000+"");
                      }

                      @Override
                      public void onFinish() {
                          startActivity(new Intent(MainActivity.this,Main2Activity.class));

                      }
                  }.start();
    }
}
