package com.example.thinkpad_e470.sqffjz;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    public static  final String tag="========";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //事件分发
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(tag, "MainActivity | dispatchTouchEvent --> " + Url.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    //事件响应
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(tag, "MainActivity | onTouchEvent --> " + Url.getTouchAction(event.getAction()));
        return super.onTouchEvent(event);
    }

}
