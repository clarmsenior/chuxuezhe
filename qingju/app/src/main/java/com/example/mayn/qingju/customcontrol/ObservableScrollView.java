package com.example.mayn.qingju.customcontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.ScrollView;


/**
 * 监听ScrollView的滑动数据
 * Create by: tsh
 * Date: 2017/8/21
 * time: 11:36
 *
 */
public class ObservableScrollView extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;

    public ObservableScrollView(Context context) {
        this(context,null);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    private OnObservableScrollViewScrollChanged mOnObservableScrollViewScrollChanged;

    public void setOnObservableScrollViewScrollChanged(OnObservableScrollViewScrollChanged mOnObservableScrollViewScrollChanged) {
        this.mOnObservableScrollViewScrollChanged = mOnObservableScrollViewScrollChanged;
    }


    public interface OnObservableScrollViewScrollChanged{
        void onObservableScrollViewScrollChanged(int l, int t, int oldl, int oldt);
    }

    /**
     * @param l Current horizontal scroll origin. 当前滑动的x轴距离
     * @param t Current vertical scroll origin. 当前滑动的y轴距离
     * @param oldl Previous horizontal scroll origin. 上一次滑动的x轴距离
     * @param oldt Previous vertical scroll origin. 上一次滑动的y轴距离
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mOnObservableScrollViewScrollChanged!=null){
            mOnObservableScrollViewScrollChanged.onObservableScrollViewScrollChanged(l,t,oldl,oldt);
        }
    }

    View view;


}
