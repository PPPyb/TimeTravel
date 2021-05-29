package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Indix extends Player{


    Boolean qing = false;
    float qingTime = 0;
    float qingCD = 0;
    Boolean qBoomboom =false;

    public Indix(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Indix";
        //属性
        strength = 10;
        agility = 15;
        intelligence = 25;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(curMP- BulletDangMa.MPConsume>0) {
            float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
            float sin = relativeX/relativeXY;
            float cos = relativeY/relativeXY;
            float velX = BulletDangMa.speed * sin;
            float velY = BulletDangMa.speed * cos;
            if(level.bulletDangMasCnt>900)
                level.bulletDangMasCnt = 0;
            level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX()+width/2, getY()+height,level);
            level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2(velX, velY));
            level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(Constants.myGravatiy);
            level.bulletDangMasCnt++;
            loseMP(BulletDangMa.MPConsume);
        }
    }

    @Override
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY) {
        if(curMP- BulletDangMa.MPConsume*3>0) {
            Boolean toRight;
            if(relativeX>0)
                toRight = true;
            else
                toRight = false;
            for(int i = 0;i < 3;i++)
            {
                if(level.bulletDangMasCnt>900)
                    level.bulletDangMasCnt = 0;
                level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX()+width/2, getY()+i*height,level);
                level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2(0, 0));
                if(toRight)
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(10, 0));
                else
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(-10, 0));
                level.bulletDangMasCnt++;
            }

            loseMP(BulletDangMa.MPConsume*3);
        }
    }

    @Override
    public void eventQ() {
        if(qingCD>0)
            return;
        qing = true;
        qingTime = 0;
        qBoomboom =false;
    }

    @Override
    public void eventE() {

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        qingCD-=deltaTime;
        if (qing) {
            qingTime+=deltaTime;
            level.indixQskillEffect.setPosition(new Vector2(getX()-80,getY()-50));
            if(qingTime>1.2&&!qBoomboom)
            {
                qBoomboom =true;
                level.indixQskillEffect.quandoushipaomo();
            }
            if(qingTime>2.1)
            {
                qing = false;
                qingTime = 0;
                qingCD = 5;

            }
        }
        else
        {
            level.indixQskillEffect.setPosition(new Vector2(-20000,-3000));
        }

    }
}
