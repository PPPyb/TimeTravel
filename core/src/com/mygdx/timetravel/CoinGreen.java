package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CoinGreen extends PropsCoin{
    public CoinGreen(float x, float y, Level level) {
        super(x, y, level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("GreenMap/item/coin.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    public void update(float deltaTime){
        super.update(deltaTime);
        collidePlayer();
    }
}
