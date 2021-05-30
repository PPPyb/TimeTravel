package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Railgun extends Bullets{

    Boolean toRight;
    public Railgun(float x, float y, Level level,Boolean toRight)
    {
        super(x,y,level);
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("effects/railgun/0.png")));
        setWidth(curFrame.getRegionWidth()*2);
        setHeight(curFrame.getRegionHeight());
        damage = 0;
        MPConsume = 40f;
        speed = 5000;
        niubi = true;
        penetrate = true;
        this.toRight = toRight;
        if(!toRight)
            curFrame.flip(true,false);
    }

    @Override
    public boolean onCollisionWithMap(float xOffset, float yOffset) {
        return false;
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(curFrame,this.getX(),this.getY(),width,height);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        damage = (int)(200*deltaTime);
        collideEnemy();
    }
}
