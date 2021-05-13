package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Kirito extends Player{

    TextureRegion[] walkFrames;
    TextureRegion[] walkFrames2;
    Animation walkAni;
    Animation walkAni2;

    public Kirito(float x, float y)
    {
        super(x,y);
        name = "KIRITO";
        stateTime = 0;

        img = new Texture(Gdx.files.internal("testMap/kirito.png"));
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
        this.setAcceleration(Constants.GRAVITY);
        curHP = maxHP = 200;
        walkSpeed = 400;
    }

    public void update(float deltaTime,Level level) {
        super.update(deltaTime,level);



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
            shoot(500,0,level);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.K))
        {
            shoot(500,500,level);
        }

    }

    public void shoot(float x, float y,Level level)
    {
        level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(getX(),getY());
        level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2(x,y));
        level.bulletTestPenetrateCnt++;
    }

    public void draw(Batch batch)
    {
        super.draw(batch);

    }
}
