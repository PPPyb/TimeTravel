package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletBeef extends Bullets{

    public BulletBeef(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/coin.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
        MPConsume = 50f;
        speed = 300;
        bounceAble = true;
        bounceMax = 3;
        niubi = true;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collidePlayer();
    }

}
