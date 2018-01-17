package com.siomt.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CardView cardView;
    private SeekBar sbElevation;
    private SeekBar sbCornerRadius;//边缘弧度数
    private SeekBar sbMaxElevation;
    private TextView tvMax;
    private TextView tvNow;
    private TextView tvRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        cardView = findViewById(R.id.card_view);
        sbElevation = findViewById(R.id.sb_card_elevation);
        sbMaxElevation = findViewById(R.id.sb_max_elevation);
        sbCornerRadius = findViewById(R.id.sb_corner_radius);
        tvMax = findViewById(R.id.tv_max);
        tvNow = findViewById(R.id.tv_now);
        tvRadius = findViewById(R.id.tv_radius);

        sbElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setCardElevation(progress);
                tvNow.setText("设置阴影值:"+progress+"dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbMaxElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setMaxCardElevation(progress);
                tvMax.setText("设置最大的阴影:"+progress+"dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbCornerRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setRadius(progress);
                tvRadius.setText("设置边缘弧度数:"+progress+"dp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
