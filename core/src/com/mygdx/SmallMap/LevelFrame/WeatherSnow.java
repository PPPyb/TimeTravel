package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class WeatherSnow extends WeatherBullets{
    public WeatherSnow(float x, float y, Level level)
    {
        super(x,y,level);
    }

    @Override
    public void initAnime() {
        curFrame = MyTextrue.snow;
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
                monster.destructed();
                this.destructed();
            }
        }
        for(int i = 0;i < 1;i++)
        {
            Bullets monster = level.bulletFireWall;
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                monster.setAcceleration(new Vector2(0,0));
                monster.setVelocity(new Vector2(0,0));
                monster.setPosition(new Vector2(-10000,-10000));
                this.destructed();
            }
        }
    }
}
