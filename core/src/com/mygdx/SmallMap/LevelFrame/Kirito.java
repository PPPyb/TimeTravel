package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Kirito extends Player {

    //E技能使用次数


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
        level.magicHelper.kiritoQ.cast();
    }

    public void eventE() {
        if(curMP-level.bulletFireWall.MPConsume>0) {
            if(!level.magicHelper.kiritoE.casting)
            {
                for(int i = 0;i < 6;i++)
                {
                    if(level.bulletTestPenetrateCnt>900)
                        level.bulletTestPenetrateCnt = 0;
                    level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(getX()+level.bulletFireWall.width/2, getY(),level);
                    level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2((float)( -200+Math.random()*400), (float) (300+Math.random()*100)));
                    level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setAcceleration(Constants.myGravatiy);
                    level.bulletTestPenetrateCnt++;
                }
                level.magicHelper.kiritoE.setCastPositon(getX(),getY());
            }
            level.magicHelper.kiritoE.cast();

            loseMP(level.bulletFireWall.MPConsume);
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);


    }
}
