package com.mygdx.timetravel;

public class Coins extends Bullets{

    public int numOfCoins;

    public Coins(float x,float y,Level level)
    {
        super(x,y,level);
        initAnime();
    }
}
