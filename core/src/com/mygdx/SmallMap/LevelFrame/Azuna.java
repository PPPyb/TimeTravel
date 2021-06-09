package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;


public class Azuna extends Player {


    private static int countQ = 0;


    public Azuna(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Asuna";
        //属性
        strength = 15;
        agility = 15;
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
            if(level.bulletTestCnt>900)
                level.bulletTestCnt = 0;
            level.bulletTest[level.bulletTestCnt] = new BulletTest(getX()+width/2, getY()+height,level);
            level.bulletTest[level.bulletTestCnt].setVelocity(new Vector2(x, y));
            level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.myGravatiy);
            level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume);
        }

    }

    @Override
    //反重力术
    public void eventE() {
        if((Azuna.countQ%2)==0) {
            if(curMP- BulletTest.MPConsume*Gdx.graphics.getDeltaTime()>100) {
                level.magicHelper.azunaE.cast();
            }
        }
        else {
                level.magicHelper.azunaE.stop();
            }
        Azuna.countQ ++;

    }

    //大清复活术
    @Override
    public void eventQ() {
        level.magicHelper.azunaQ.cast();

        level.kirito.isAlive = true;
        if(level.kirito.curHP<0.3*level.kirito.maxHP)
            level.kirito.curHP = (float) (0.3*level.kirito.maxHP);
        level.indix.isAlive = true;
        if(level.indix.curHP<0.3*level.indix.maxHP)
            level.indix.curHP = (float) (0.3*level.indix.maxHP);
        level.misaka.isAlive = true;
        if(level.misaka.curHP<0.3*level.indix.maxHP)
            level.misaka.curHP = (float) (0.3*level.indix.maxHP);

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

    }

    @Override
    public void move(int speed) {
        if(!level.magicHelper.azunaQ.casting)
            super.move(speed);
    }

    @Override
    public void jump(int speed) {
        if(!level.magicHelper.azunaQ.casting)
            super.jump(speed);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);

    }
}
