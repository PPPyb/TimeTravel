package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestPenetrate extends Bullets{

    public BulletTestPenetrate(float x, float y)
    {
        super(x,y);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/ghost.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
        penetrate = true;
    }

    @Override
    public void update(float deltaTime, Level level) {
        super.update(deltaTime, level);
        collideEnemy(level);
    }
}
