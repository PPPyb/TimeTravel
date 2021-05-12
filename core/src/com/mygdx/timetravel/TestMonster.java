package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class TestMonster extends Enemy{
    public TestMonster(float x,float y)
    {
        super(x, y);
        stateTime = 0;

        img = new Texture(Gdx.files.internal("testMap/monster.png"));
        frames = TextureRegion.split(img,img.getWidth(),img.getHeight());
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        setBounds();
        //System.out.println(bounds);
        this.setAcceleration(Constants.gravity);
        curHP = maxHP = 20;
    }

    public void update(float deltaTime, Level level) {
        super.update(deltaTime,level);

        stateTime += Gdx.graphics.getDeltaTime();

        walkState = "IDLE";

        move(200);


        jump(200);

        curFrame = frames[0][0];
    }
}
