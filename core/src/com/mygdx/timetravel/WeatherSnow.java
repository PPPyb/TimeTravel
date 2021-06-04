package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class WeatherSnow extends WeatherBullets{
    public WeatherSnow(float x,float y,Level level)
    {
        super(x,y,level);
    }

    @Override
    public void initAnime() {
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("Weather/snow.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collideFire();
    }

    public void collideFire() {
        for(int i = 0;i < level.bulletTestPenetrateCnt;i++)
        {
            Bullets monster = level.bulletTestPenetrate[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                this.destructed();
            }
        }
        for(int i = 0;i < 1;i++)
        {
            Bullets monster = level.bulletFireWall;
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                this.destructed();
            }
        }
    }
}
