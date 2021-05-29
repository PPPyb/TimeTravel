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
    Boolean recoverCasted = false;
    Boolean qing = false;//大清
    float qingTime = 0;

    public Azuna(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Asuna";
        //属性
        strength = 10;
        agility = 40;
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
    //反重力术
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

    //大清复活术
    @Override
    public void eventE() {

        if(recoverCasted)
            return;

         //pigeon helicopter
        //复活
        //level.azuna.isAlive = true;
        level.kirito.isAlive = true;
        //回复所有角色状态
        //if(level.azuna.curHP<0.3*level.azuna.maxHP)
            //level.azuna.curHP = (float) (0.3*level.azuna.maxHP);
        if(level.kirito.curHP<0.3*level.kirito.maxHP)
            level.kirito.curHP = (float) (0.3*level.kirito.maxHP);
        qing = true;

        recoverCasted = true;
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
        //System.out.println(recoverCasted);
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
        if(qing)
        {
            Vector2 vec = new Vector2((float) (getX()-width*1.7), getY()-height);
            this.level.azunaEskillEffectRecover.setPosition(vec);
            qingTime += deltaTime;
            if(qingTime > 3) {
                qing = false;
                level.azunaEskillEffectRecover.setPosition(new Vector2(-10000,-10000));
            }
        }

    }

    @Override
    public void move(int speed) {
        if(!qing)
            super.move(speed);
    }

    @Override
    public void jump(int speed) {
        if(!qing)
            super.jump(speed);
    }
}
