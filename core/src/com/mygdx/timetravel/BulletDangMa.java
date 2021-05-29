package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletDangMa extends Bullets{

    public BulletDangMa(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("effects/indixbullet/dangma.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 200;
        MPConsume = 40f;
        speed = 600;
        bounceAble = true;
        bounceMax = 2;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collideEnemy();
    }
}
