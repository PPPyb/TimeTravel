package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTest extends Bullets{

    public BulletTest(float x,float y,Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/ballBullet.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 100;
        MPConsume = 5f;
        speed = 600;
        bounceAble = true;
        bounceMax = 3;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collideEnemy();
    }
}
