package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Azuna extends Player{


    public Azuna(float x,float y,Level level)
    {
        super(x,y,level);
        name = "Asuna";
        //属性
        strength = 5;
        agility = 10;
        intelligence = 15;
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
            level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.GRAVITY);
            level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume);
        }

    }
}
