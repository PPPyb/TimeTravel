package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;
/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Azuna extends Player{

    TextureRegion[] walkFrames;
    TextureRegion[] walkFrames2;
    Animation walkAni;
    Animation walkAni2;
    BulletTest[] bulletTest;
    int bulletCnt;
    public Azuna(float x,float y)
    {
        super(x,y);
        stateTime = 0;
        bulletTest = new BulletTest[1000];
        bulletCnt = 0;
        img = new Texture(Gdx.files.internal("testMap/azuna.png"));
        frames = TextureRegion.split(img,img.getWidth()/4,img.getHeight()/4);
        walkFrames = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames[i] = frames[2][i];
        walkFrames2 = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames2[i] = frames[1][i];
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        walkAni = new Animation(0.2f,walkFrames);
        walkAni.setPlayMode(Animation.PlayMode.LOOP);
        walkAni2= new Animation(0.2f,walkFrames2);
        walkAni2.setPlayMode(Animation.PlayMode.LOOP);
        this.setAcceleration(Constants.gravity);
        curHP = maxHP = 100;
    }

    public void update(float deltaTime,Level level) {
        super.update(deltaTime,level);

        move(200);
        jump(200);

        if(jumpState=="JUMPING")
            curFrame =frames[0][0];
        else if (walkState=="RIGHT")
            curFrame = (TextureRegion) walkAni.getKeyFrame(stateTime,true);
        else if(walkState=="LEFT")
            curFrame = (TextureRegion) walkAni2.getKeyFrame(stateTime,true);
        else
            curFrame = frames[0][0];

        if(Gdx.input.isKeyJustPressed(Input.Keys.J))
        {
            shoot(500,0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.K))
        {
            shoot(500,500);
        }
        for(int i = 0;i < bulletCnt;i++)
            bulletTest[i].update(deltaTime,level);
    }

    public void shoot(float x, float y)
    {
        bulletTest[bulletCnt] = new BulletTest(getX(),getY());
        bulletTest[bulletCnt].setVelocity(new Vector2(x,y));
        bulletTest[bulletCnt].setAcceleration(Constants.gravity);
        bulletCnt++;
    }

    public void draw(Batch batch)
    {
        super.draw(batch);
        for(int i = 0;i < bulletCnt;i++)
            bulletTest[i].draw(batch);
    }
}
