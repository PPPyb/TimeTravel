package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletFireWall extends Bullets{

    TextureRegion[] boom;
    Animation boomAni;
    
    public BulletFireWall(float x, float y,Level level)
    {
        super(x,y,level);
        stateTime = 0;
        damage = 300;
        penetrate = true;
        MPConsume = 100;
        speed = 0;
        niubi = true;
    }

    @Override
    public void initAnime() {
        
        boom = new TextureRegion[7];

        for(int i = 0;i < 7;i++)
        {
        	System.out.println("fireA/600-1.png");
        	Texture temp = new Texture(Gdx.files.internal("fireA/"+(i+1)+".png"));
        	boom[i] = new TextureRegion(temp);
        }

        boomAni = new Animation(0.2f, boom);
        boomAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = boom[0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        stateTime += Gdx.graphics.getDeltaTime();
        curFrame = (TextureRegion) boomAni.getKeyFrame(level.magicHelper.kiritoE.castTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
    }
}
