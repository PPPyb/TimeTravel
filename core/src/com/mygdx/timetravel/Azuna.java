package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Azuna extends Player{


    private static int countQ = 0;
    private boolean consumingQ;

    public Azuna(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Asuna";
        //属性
        strength = 5;
        agility = 20;
        intelligence = 20;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
        float sin = relativeX/relativeXY;
        float cos = relativeY/relativeXY;
        float velX = BulletTest.speed * sin;
        float velY = BulletTest.speed * cos;
        shoot(velX,velY);
    }

    public void shoot(float x, float y)
    {
        if(curMP- BulletTest.MPConsume>0) {
            level.bulletTest[level.bulletTestCnt] = new BulletTest(getX()+width/2, getY()+height,level);
            level.bulletTest[level.bulletTestCnt].setVelocity(new Vector2(x, y));
            level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.myGravatiy);
            level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume);
        }

    }

    @Override
    public void eventQ() {
        if((Azuna.countQ%2)==0) {
            if(curMP- BulletTest.MPConsume*Gdx.graphics.getDeltaTime()>100) {
                consumingQ = true;
            }
        }
        else {
                consumingQ = false;
            }

        Azuna.countQ ++;

    }

    @Override
    public void eventRight(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(curMP- BulletTest.MPConsume*5>0) {
        level.bulletTest[level.bulletTestCnt] = new BulletTest((float)absoluteX, (float)absoluteY,this.level);
        level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.myGravatiy);
        level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume*5);
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if(consumingQ) {
            level.azunaQskillEffect.setPosition(new Vector2((float) (getX()-width*2.9), getY()-height));
            loseMP(200 * Gdx.graphics.getDeltaTime());
            Constants.myGravatiy = new Vector2(0,10);
            if (curMP < 10)
                consumingQ = false;
        }
        else
        {
            level.azunaQskillEffect.setPosition(new Vector2(-10000.0f,-10000.0f));
            Constants.myGravatiy = new Vector2(0,-10);

        }

    }

}
