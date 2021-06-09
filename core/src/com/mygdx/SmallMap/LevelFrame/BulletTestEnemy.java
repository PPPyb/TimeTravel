package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class BulletTestEnemy extends Bullets{


    ParticleEffect effect;
    public BulletTestEnemy(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = MyTextrue.love;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
        MPConsume = 50f;
        speed = 300;
        bounceAble = true;
        bounceMax = 1;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collidePlayer();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }
}
