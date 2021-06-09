package com.mygdx.SmallMap.LevelFrame;

public class PropsCoinTest extends PropsCoin{
    public PropsCoinTest(float x, float y, Level level){
        super(x, y, level);
        curFrame = MyTextrue.coin;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    public void update(float deltaTime){
        super.update(deltaTime);
        collidePlayer();
    }
}
