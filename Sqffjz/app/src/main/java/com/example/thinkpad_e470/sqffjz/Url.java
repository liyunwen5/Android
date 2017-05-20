package com.example.thinkpad_e470.sqffjz;

import android.view.MotionEvent;

/**
 * Created by Thinkpad-e470 on 2017/5/14.
 */

public class Url {
    public static String getTouchAction(int actionId){
        String actionName="Unknow:id="+actionId;
        switch (actionId){
            case MotionEvent.ACTION_DOWN:
                actionName = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                actionName="ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                actionName="ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                actionName="ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                actionName="ACTION_OUTSIDE";
                break;
        }
        return actionName;
    }
}
