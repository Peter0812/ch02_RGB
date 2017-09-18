package com.example.student.ch02_rgbdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,View.OnClickListener{
    private TextView tvBg,tvA,tvR,tvG,tvB,tvARGB;
    private SeekBar sbA,sbR,sbG,sbB;
    private Button[] btns = new Button[8];
    private int[] btnId = {R.id.btnA1,R.id.btnA2,R.id.btnR1,R.id.btnR2,R.id.btnG1,R.id.btnG2,R.id.btnB1,R.id.btnB2};

    private int a = 123, r = 123, g = 123, b = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewId();
    }

    private void findViewId() {
        tvBg = (TextView) findViewById(R.id.tvBg);
        tvA = (TextView) findViewById(R.id.tvA);
        tvR = (TextView) findViewById(R.id.tvR);
        tvG = (TextView) findViewById(R.id.tvG);
        tvB = (TextView) findViewById(R.id.tvB);
        tvARGB = (TextView) findViewById(R.id.tvARGB);

        sbA = (SeekBar)findViewById(R.id.sbA);
        sbR = (SeekBar)findViewById(R.id.sbR);
        sbG = (SeekBar)findViewById(R.id.sbG);
        sbB = (SeekBar)findViewById(R.id.sbB);
        sbA.setOnSeekBarChangeListener(this);
        sbR.setOnSeekBarChangeListener(this);
        sbG.setOnSeekBarChangeListener(this);
        sbB.setOnSeekBarChangeListener(this);

        for(int i=0;i<btns.length;i++){
            btns[i] = (Button)findViewById(btnId[i]);
            btns[i].setOnClickListener(this);
        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.sbA:
                a = progress;
                break;
            case R.id.sbR:
                r = progress;
                break;
            case R.id.sbG:
                g = progress;
                break;
            case R.id.sbB:
                b = progress;
                break;
        }
        colorInfo();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnA1:
                a = valueTest(--a);
                break;
            case R.id.btnA2:
                a = valueTest(++a);
                break;
            case R.id.btnR1:
                r = valueTest(--r);
                break;
            case R.id.btnR2:
                r = valueTest(++r);
                break;
            case R.id.btnG1:
                g = valueTest(--g);
                break;
            case R.id.btnG2:
                g = valueTest(++g);
                break;
            case R.id.btnB1:
                b = valueTest(--b);
                break;
            case R.id.btnB2:
                b = valueTest(++b);
                break;

        }
        sbA.setProgress(a);
        sbR.setProgress(r);
        sbG.setProgress(g);
        sbB.setProgress(b);
        colorInfo();

    }

    //測試按鈕數值
    private int valueTest(int value){
        if(value>=255) return 255;
        else if(value<=0) return 0;
        else return value;
    }

    private void colorInfo(){
        tvA.setText(a+"");
        tvR.setText(r+"");
        tvG.setText(g+"");
        tvB.setText(b+"");
        tvBg.setBackgroundColor(Color.argb(a,r,g,b));
        tvARGB.setText(String.format("#%02X%02X%02X%02X",a,r,g,b));
        if(r<70 && g<70 && b<70){
            tvARGB.setTextColor(Color.WHITE);
        }else{
            tvARGB.setTextColor(Color.BLACK);
        }

    }
}
