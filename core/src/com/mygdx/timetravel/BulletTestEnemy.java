package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestEnemy extends Bullets{


    ParticleEffect rainbowEffect;
    public BulletTestEnemy(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/love.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 10;
        MPConsume = 50f;
        speed = 300;
        bounceAble = true;
        bounceMax = 1;
        rainbowEffect = new ParticleEffect();
        rainbowEffect.load(Gdx.files.internal("particle/rainbow.particle"),Gdx.files.internal("particle"));
        rainbowEffect.start();

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        rainbowEffect.setPosition(getX(),getY());
        rainbowEffect.update(deltaTime);
        collidePlayer();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        rainbowEffect.draw(batch);
    }
}
