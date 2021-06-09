package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTitanic extends Bullets{

    public BulletTitanic(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/titanic.jpg")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 200;
        MPConsume = 40f;
        speed = 600;
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
        collideEnemy();
    }
}
