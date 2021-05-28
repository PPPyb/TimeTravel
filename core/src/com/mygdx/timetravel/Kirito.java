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

    //E技能使用次数
    private static int countE;
    boolean castingE = false;

    public Kirito(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Kirito";
        //属性
        strength = 15;
        agility = 20;
        intelligence = 20;

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

    @Override
    public void eventQ() {

    }

    public void eventE() {
        if((Kirito.countE%2)==0) {
            if (curMP - BulletTest.MPConsume*Gdx.graphics.getDeltaTime() > 100) {
                castingE = true;
            }
        }
        else
            {
                castingE =false;
            }
        Kirito.countE ++;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if(castingE) {
            if (walkState != "LEFT")
                level.bulletFireWall.setPosition(new Vector2(getX() + width, getY()));
            else
                level.bulletFireWall.setPosition(new Vector2(getX() - width, getY()));

            loseMP(200 * Gdx.graphics.getDeltaTime());
            if (curMP < 10)
                castingE = false;

        }
        else
            level.bulletFireWall.setPosition(new Vector2(-10000.0f,-10000.0f));
    }
}
