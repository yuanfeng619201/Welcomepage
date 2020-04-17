package com.example.welcomepage;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.VideoView;

/**
 * Created by  Icon on 2020/4/14 0014.
 */
public class CustomVideoView extends VideoView {
    //主要应用于直接New出来的对象
    public CustomVideoView(Context context) {
        super(context);
    }

    //主要用于xml中，支持自定义属性
    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //主要用于xml文件在，也支持自定义属性，同时支持style样式
    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //我们重新计算高度(这样就可以匹配不同手机的尺寸)：1.测试模式，2.测试大小
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
