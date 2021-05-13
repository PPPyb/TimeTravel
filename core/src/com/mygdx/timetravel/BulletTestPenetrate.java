package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestPenetrate extends Bullets{

    public BulletTestPenetrate(float x, float y,Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/ghost.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
        penetrate = true;
        MPConsume = 100;
        speed = 400;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collideEnemy();
    }
}
