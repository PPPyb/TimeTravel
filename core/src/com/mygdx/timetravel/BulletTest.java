package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTest extends Bullets{

    public BulletTest(float x,float y)
    {
        super(x,y);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/love.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
    }
}
