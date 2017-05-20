package com.example.thinkpad_e470.sqffjz;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by 事件分发机制 on 2017/5/13.
 */

public class FatherLaout extends LinearLayout {
    public static  final String tag="========";

    public FatherLaout(Context context) {
        super(context);
    }

    public FatherLaout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherLaout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //如果传给当前view 此方法一定会被调用 是否消耗这个事件 “相当于团长”
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       Log.i(tag,getClass().toString()+"[dispatchTouchEvent"+Url.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    //上述方法内部被用来判断是否拦截某个事件，如果当前view被拦截的时候这个方法不会被调用
    //事件分发步骤
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(tag,getClass().toString()+"[onInterceptTouchEvent"+Url.getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    //这个处理事件执行
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(tag,getClass().toString()+"[onTouchEvent"+Url.getTouchAction(event.getAction()));
        return super.onTouchEvent(event);
    }


}
