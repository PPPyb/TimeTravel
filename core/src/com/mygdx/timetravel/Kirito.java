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
public class Kirito extends Player{

    TextureRegion[] walkFrames;
    TextureRegion[] walkFrames2;
    Animation walkAni;
    Animation walkAni2;

    public Kirito(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Kirito";
        //属性
        strength = 5;
        agility = 15;
        intelligence = 10;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
        float sin = relativeX/relativeXY;
        float cos = relativeY/relativeXY;
        float velX = BulletTestPenetrate.speed * sin;
        float velY = BulletTestPenetrate.speed * cos;
        shoot(velX,velY);
    }

    public void shoot(float x, float y)
    {
        if(curMP- BulletTest.MPConsume>0) {
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(getX()+width/2, getY()+height,level);
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2(x, y));
            level.bulletTestPenetrateCnt++;
            loseMP(BulletTestPenetrate.MPConsume);
        }
    }
}
