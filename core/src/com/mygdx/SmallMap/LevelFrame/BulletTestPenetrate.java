package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestPenetrate extends Bullets{

    TextureRegion[] boom;
    Animation boomAni;

    ParticleEffect fire;
    public BulletTestPenetrate(float x, float y, Level level)
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
        curFrame = new TextureRegion();
        curFrame = MyTextrue.doreamon;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {

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

    @Override
    public void dispose() {
        super.dispose();
        fire.dispose();
    }
}
