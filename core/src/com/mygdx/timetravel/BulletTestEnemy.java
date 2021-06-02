package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletTestEnemy extends Bullets{


    ParticleEffect effect;
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
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("particle/ghost.particle"),Gdx.files.internal("particle"));
        effect.start();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        effect.setPosition(getX()+width/2,getY()+height/2);
        effect.update(deltaTime);
        collidePlayer();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        //effect.draw(batch);
    }
}
