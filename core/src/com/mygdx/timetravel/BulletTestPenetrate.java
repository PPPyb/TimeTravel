package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestPenetrate extends Bullets{

    TextureRegion[] boom;
    Animation boomAni;

    ParticleEffect fire;
    public BulletTestPenetrate(float x, float y,Level level)
    {
        super(x,y,level);

        damage = 10;
        penetrate = true;
        MPConsume = 40;
        speed = 1000;
        bounceAble = true;
        bounceMax = 1;
        fire = new ParticleEffect();
        fire.load(Gdx.files.internal("particle/fire.particle"),Gdx.files.internal("particle"));
        fire.start();
    }

    @Override
    public void initAnime() {
        
        Texture tem = new Texture(Gdx.files.internal("testMap/NBbullet.png"));
        TextureRegion[][] temp = TextureRegion.split(tem,tem.getWidth()/4,tem.getHeight()/4);
        boom = new TextureRegion[16];

        for(int i = 0;i < 4;i++)
            for(int j = 0;j < 4;j++)
                boom[4*i+j] = temp[i][j];

        boomAni = new Animation(0.05f, boom);
        boomAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = temp[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        curFrame = (TextureRegion) boomAni.getKeyFrame(stateTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
        fire.setPosition(getX()+width/2,getY()+height/2);
        fire.update(deltaTime);
        damage = (int)(200 * deltaTime);
        collideEnemy();
    }

    @Override
    public void draw(Batch batch) {
        fire.draw(batch);
    }
}
