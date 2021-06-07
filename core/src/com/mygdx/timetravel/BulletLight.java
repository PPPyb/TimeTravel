package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletLight extends Bullets{

    public BulletLight(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = MyTextrue.lighting;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 40;
//        MPConsume = 40f;
        speed = 10000;
        niubi = true;
        penetrate = true;
    }

    @Override
    public boolean onCollisionWithMap(float xOffset, float yOffset) {
        return false;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collidePlayer();
    }
}
