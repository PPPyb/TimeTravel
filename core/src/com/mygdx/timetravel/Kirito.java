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
    Boolean qing = false;
    float qingTime = 0;
    float qingCD = 0;
    float originArmor = 0;
    int originWalkSpeed = 0;

    public Kirito(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Kirito";
        //属性
        strength = 20;
        agility = 18;
        intelligence = 12;

        init();
        originArmor = armor;
        originWalkSpeed = walkSpeed;
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

    @Override
    public void eventRight(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(curMP- BulletTest.MPConsume*2>0) {
            for(int i = 0;i < 12;i++)
             {
                 if(level.bulletTestPenetrateCnt>900)
                     level.bulletTestPenetrateCnt = 0;
                 int angle = 30*i;
                 double sin = Math.sin(angle);
                 double cos = Math.cos(angle);
                level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(absoluteX, absoluteY,this.level);
                level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2((float) sin*1000,(float) cos*1000));
                level.bulletTestPenetrateCnt++;

            }
            loseMP(BulletTestPenetrate.MPConsume*2);
        }
    }

    public void shoot(float x, float y)
    {
        if(curMP- BulletTest.MPConsume>0) {
            if(level.bulletTestPenetrateCnt>900)
                level.bulletTestPenetrateCnt = 0;
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(getX()+width/2, getY()+height,level);
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2(x, y));
            level.bulletTestPenetrateCnt++;
            loseMP(BulletTestPenetrate.MPConsume);
        }
    }

    //光翼展开
    @Override
    public void eventQ() {
        if(qingCD>0)
            return;
        qing = true;
        qingTime = 0;
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
        qingCD -= deltaTime;
        if (castingE) {
            if (walkState != "LEFT")
                level.bulletFireWall.setPosition(new Vector2(getX() + width, getY()));
            else
                level.bulletFireWall.setPosition(new Vector2(getX() - width, getY()));

            loseMP(200 * Gdx.graphics.getDeltaTime());
            if (curMP < 10)
                castingE = false;

        } else
            level.bulletFireWall.setPosition(new Vector2(-10000.0f, -10000.0f));

        if (qing) {
            //effect
            level.kiritoQskillEffect.setPosition(new Vector2(getX()-80,getY()-50));
            walkSpeed = 2 * originWalkSpeed;
            armor = 2 * originArmor;
            qingTime += deltaTime;
            restoreMP(10000);
            if(qingTime>5)
            {
                qing = false;
                qingTime = 0;
                qingCD = 15;
            }
        }
        else
        {
            level.kiritoQskillEffect.setPosition(new Vector2(-20000,-3000));
            armor = originArmor;
            walkSpeed = originWalkSpeed;
        }
    }
}
