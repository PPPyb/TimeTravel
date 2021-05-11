package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Azuna extends AbstractGameObject{
    Texture img;
    TextureRegion curFrame;
    TextureRegion[] walkFrames;
    TextureRegion[] walkFrames2;
    Animation walkAni;
    Animation walkAni2;
    int stateTime;
    String walkState;
    public Azuna()
    {
        walkState = new String("RIGHT");
        stateTime = 0;
        this.setX(0);
        this.setY(360);
        img = new Texture(Gdx.files.internal("testMap/azuna.png"));
        TextureRegion[][] frames = TextureRegion.split(img,img.getWidth()/4,img.getHeight()/4);
        walkFrames = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames[i] = frames[2][i];
        walkFrames2 = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames2[i] = frames[1][i];
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        walkAni = new Animation(0.2f,walkFrames);
        walkAni.setPlayMode(Animation.PlayMode.LOOP);
        walkAni2= new Animation(0.2f,walkFrames2);
        walkAni2.setPlayMode(Animation.PlayMode.LOOP);
    }

    @Override
    public void act(float delta) {
        stateTime += Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            walkState = "LEFT";
            this.setX(this.getX()-5);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            walkState = "RIGHT";
            this.setX(this.getX()+5);
        }
        if (walkState=="RIGHT")
            curFrame = (TextureRegion) walkAni.getKeyFrame(stateTime,true);
        else if(walkState=="LEFT")
            curFrame = (TextureRegion) walkAni2.getKeyFrame(stateTime,true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(curFrame,this.getX(),this.getY());
    }
}
