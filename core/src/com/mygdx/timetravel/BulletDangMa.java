package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BulletDangMa extends Bullets{

    ParticleEffect effect;
    public BulletDangMa(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("effects/indixbullet/dangma.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 200;
        MPConsume = 40f;
        speed = 600;
        bounceAble = true;
        bounceMax = 2;
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("particle/dangma.particle"),Gdx.files.internal("particle"));
        effect.start();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        effect.setPosition(getX()+width/2,getY()+height/2);
        effect.update(deltaTime);
        collideEnemy();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        effect.draw(batch);
    }
}
