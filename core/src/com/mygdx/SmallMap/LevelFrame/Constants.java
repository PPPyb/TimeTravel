package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.math.Vector2;

//这个类用来放常量，里面成员都是public static final
public class Constants {
    public static final int WINDOWS_WIDTH = 1280; //窗口宽度
    public static final int WINDOWS_HEIGHT = 720; //窗口高度

    public static final float HPRECHEIGHT = 20f;  //血条高度
    public static final float HPRECWIDTHRATE = 2f;//血条宽度比例

    public static final int PLAYERNUMBER = 4;//主角数量

    public static final float DASHRATE = 10f;//DASH重力加速率
    public static final float DSJPRATE = 4f;//DASH-JUMP动能转换率
    public static final float JPCONSUMEDRATE = 50f;//JUMP消耗JP动能率

    public static final Vector2 GRAVATIY = new Vector2(0,-10);
    public static Vector2 myGravatiy = GRAVATIY;//重力

    public static final float ENEMYJUMPRATE = 10f;//敌人跳跃功率
    public static final float VICTORYSHOWTIME = 5;
}
