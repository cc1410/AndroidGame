package com.example.chen.mycustomviews.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;

import android.util.AttributeSet;


/**
 * Created by chen on 18/01/2018.
 */

public class UserScoreView extends AppCompatImageView {

    protected int score;

    public UserScoreView(Context context) { this(context,attrs: null, defStylrAttr: 0 ); }

    public UserScoreView(Context context, @Nullable AttributeSet attrs) { this(context, attrs, defStyleAttr: 0);}

    public UserScoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScore(int score){ this.score = score;}
    public void getScore(){ this.score = score;}
}
