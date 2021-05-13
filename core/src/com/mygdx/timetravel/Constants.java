package com.mygdx.timetravel;

import com.badlogic.gdx.math.Vector2;

//这个类用来放常量，里面成员都是public static final
public class Constants {
    public static final int WINDOWS_WIDTH = 1920; //窗口宽度
    public static final int WINDOWS_HEIGHT = 1080; //窗口高度
    public static final float HPRECHEIGHT = 20f;  //血条高度
    public static final float HPRECWIDTHRATE = 2f;//血条宽度比例
    public static final int PLAYERNUMBER = 2;//主角数量
    public static final float DASHRATE = 10f;//DASH重力加速率
    public static final float DSJPRATE = 4f;//DASH-JUMP动能转换率
    public static final float JPCONSUMEDRATE = 50f;//JUMP消耗JP动能率
    public static final Vector2 GRAVITY = new Vector2(0,-10);//重力
}
