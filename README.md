# CardView 简单使用

Android 5.0 版本中新增了CardView，CardView 继承自FrameLayout类，并且可以设置圆角和阴影，使得控件具有立体性，也可以包含其他的布局容器和控件。

![CardView.gif](https://github.com/Siomt/CardViewDemo/blob/master/img/CardView.gif)


# 配置build.gradle

如果SDK低于5.0，仍旧要引入v7包。
```
dependencies {
    implementation 'com.android.support:appcompat-v7:26.1.0'
    compile "com.android.support:cardview-v7:26.1.0"
}
```

# 使用CardView

xml布局代码

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.siomt.cardviewdemo.MainActivity">

    <android.support.v7.widget.CardView
        android:id="@+id/card_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        app:cardCornerRadius="4dp"
        app:cardElevation="5dp"
        app:cardMaxElevation="10dp"
        app:cardPreventCornerOverlap="true"
        app:cardUseCompatPadding="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="100dp">

            <ImageView
                android:layout_width="150dp"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:layout_margin="5dp"
                android:src="@drawable/img" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:padding="5dp"
                    android:text="CardView"
                    android:textSize="18sp"
                    android:textStyle="bold" />

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:padding="5dp"
                    android:text="CardView的简单例子" />
            </LinearLayout>
        </LinearLayout>

    </android.support.v7.widget.CardView>


    <TextView
        android:id="@+id/tv_max"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="设置最大的阴影:10dp" />

    <SeekBar
        android:id="@+id/sb_max_elevation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="100"
        android:progress="10" />


    <TextView
        android:id="@+id/tv_now"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="设置阴影值:5" />


    <SeekBar
        android:id="@+id/sb_card_elevation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="100"
        android:progress="5" />

    <TextView
        android:id="@+id/tv_radius"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="设置边缘弧度数:4dp" />


    <SeekBar
        android:id="@+id/sb_corner_radius"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="100"
        android:progress="4" />

</LinearLayout>

```

java 代码

```java
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

```

# 相关属性

- app:cardCornerRadius="4dp"            &nbsp;&nbsp;  设置圆角半径
- app:cardElevation="5dp"               &nbsp;&nbsp;  设置阴影的大小
- app:cardMaxElevation="10dp"           &nbsp;&nbsp;    设置最大阴影的大小
- app:cardPreventCornerOverlap="true"   &nbsp;&nbsp;   是否使用PreventCornerOverlap
- app:cardBackgroundColor="@color/colorPrimary"    &nbsp;&nbsp; 设置背景颜色
- app:cardUseCompatPadding="true"  &nbsp;&nbsp; 是否使用CompatPadding设置内边距
- app:contentPadding=""  &nbsp;&nbsp;   Card View的padding没有用，要使用这个
- app:contentPaddingLeft=""   &nbsp;&nbsp;  内容的左padding
- app:contentPaddingTop=""  &nbsp;&nbsp;    内容的上padding
- app:contentPaddingRight=""  &nbsp;&nbsp;  内容的右padding
- app:contentPaddingBottom=""  &nbsp;&nbsp; 内容的下padding



