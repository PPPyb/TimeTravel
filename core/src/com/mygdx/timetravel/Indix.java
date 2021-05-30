package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Indix extends Player{


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
            Boolean toRight;
            if(relativeX>0)
                toRight = true;
            else
                toRight = false;

                if(level.bulletDangMasCnt>900)
                    level.bulletDangMasCnt = 0;
                level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX()+width/2, getY()+height,level);
                level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2(0, 0));
                if(toRight)
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(10, 0));
                else
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(-10, 0));
                level.bulletDangMasCnt++;
            loseMP(BulletDangMa.MPConsume);
        }
    }

    @Override
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY) {
        if(level.magicHelper.indixQ.casting) {
            if (curMP - BulletDangMa.MPConsume * 5 > 0) {
                for (int i = 0; i < 10; i++) {
                    if (level.bulletDangMasCnt > 900)
                        level.bulletDangMasCnt = 0;
                    int angle = (int) (Math.random() * 360);
                    double sin = Math.sin(angle);
                    double cos = Math.cos(angle);
                    level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX(), getY(), this.level);
                    level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2((float) sin * 400, (float) cos * 400));
                    level.bulletDangMasCnt++;

                }
                loseMP(BulletDangMa.MPConsume * 5);
            }
        }
    }

    @Override
    public void eventQ() {
        if (curMP - level.indixQskillEffect.MPConsume > 0)
        {
            level.magicHelper.indixQ.cast();
            level.magicHelper.indixQ.setCastPositon(getX(),getY());
            loseMP(level.indixQskillEffect.MPConsume);
        }
    }

    @Override
    public void eventE() {
        if(level.magicHelper.indixQ.casting)
        {
            if (curMP - level.indixQskillEffect.MPConsume > 0)
            {
                level.indixQskillEffect.shoujidangma();
                loseMP(level.indixQskillEffect.MPConsume);
            }
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

    }
}
