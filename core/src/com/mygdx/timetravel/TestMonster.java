package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class TestMonster extends Enemy{
    public TestMonster(float x,float y,Level level)
    {
        super(x, y,level);
        stateTime = 0;

        img = new Texture(Gdx.files.internal("testMap/monster.png"));
        frames = TextureRegion.split(img,img.getWidth(),img.getHeight());
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        setBounds();
        //System.out.println(bounds);
        this.setAcceleration(Constants.GRAVITY);
        curHP = maxHP = 80f;
    }

    public void update(float deltaTime) {
        if(!isAlive)
            return;
        super.update(deltaTime);

        walkState = "IDLE";

        move(200);


        jump(200);

        curFrame = frames[0][0];
    }

    @Override
    public void die() {
        super.die();
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/coin.png")));
    }
}
