package com.mygdx.SmallMap.LevelFrame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Heart extends PropsCoin{

    public Heart(float x, float y, Level level) {
        super(x, y, level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("SnowLand/slice145.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
        collidePlayer();
    }
}
