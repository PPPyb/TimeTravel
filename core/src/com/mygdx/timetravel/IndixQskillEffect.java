package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class IndixQskillEffect extends Bullets{

    TextureRegion[] effect;
    Animation effectAni;
    float heidongfanwei = 1000;

    public IndixQskillEffect(float x, float y, Level level)
    {
        super(x,y,level);
        stateTime = 0;
        damage = 500;
        penetrate = true;
        MPConsume = 300;
        speed = 0;
        niubi = true;
    }

    @Override
    public void initAnime() {

        effect = new TextureRegion[21];

        for(int i = 0;i < 21;i++)
        {
        	Texture temp = new Texture(Gdx.files.internal("effects/darkhole/"+i+".png"));
        	effect[i] = new TextureRegion(temp);
        }

        effectAni = new Animation(0.2f, effect);
        effectAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = effect[0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        stateTime += Gdx.graphics.getDeltaTime();
        curFrame = (TextureRegion) effectAni.getKeyFrame(level.magicHelper.indixQ.castTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
        laiwoshenbian();

    }

    public void laiwoshenbian()
    {
        float centerX = getX()+width/2;
        float centerY = getY()+height/2;
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            float monsterX = level.testMonster[i].getX();
            float monsterY = level.testMonster[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.testMonster[i].setVelocity(new Vector2(10*(centerX-monsterX),10*(centerY-monsterY)));
        }
        for(int i = 0;i < level.beefsCnt;i++)
        {
            float monsterX = level.beefs[i].getX();
            float monsterY = level.beefs[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.beefs[i].setVelocity(new Vector2(10*(centerX-monsterX),10*(centerY-monsterY)));
        }
        for(int i = 0;i < level.zeusCnt;i++)
        {
            float monsterX = level.zeus[i].getX();
            float monsterY = level.zeus[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.zeus[i].setVelocity(new Vector2(10*(centerX-monsterX),10*(centerY-monsterY)));
        }
    }

    public void quandoushipaomo()
    {
        float centerX = getX()+width/2;
        float centerY = getY()+height/2;
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            float monsterX = level.testMonster[i].getX();
            float monsterY = level.testMonster[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei/4)
                level.testMonster[i].loseHP(damage);
        }
        for(int i = 0;i < level.beefsCnt;i++)
        {
            float monsterX = level.beefs[i].getX();
            float monsterY = level.beefs[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei/4)
                level.beefs[i].loseHP(damage);
        }
        for(int i = 0;i < level.zeusCnt;i++)
        {
            float monsterX = level.zeus[i].getX();
            float monsterY = level.zeus[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei/4)
                level.zeus[i].loseHP(damage);
        }
    }

    public void shoujidangma()
    {
        float centerX = getX()+width/2;
        float centerY = getY()+height/2;
        for(int i = 0;i < level.bulletDangMasCnt;i++)
        {
            float monsterX = level.bulletDangMas[i].getX();
            float monsterY = level.bulletDangMas[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.bulletDangMas[i].setVelocity(new Vector2(4*(centerX-monsterX),4*(centerY-monsterY)));
        }
        for(int i = 0;i < level.bulletTestPenetrateCnt;i++)
        {
            float monsterX = level.bulletTestPenetrate[i].getX();
            float monsterY = level.bulletTestPenetrate[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.bulletTestPenetrate[i].setVelocity(new Vector2(4*(centerX-monsterX),4*(centerY-monsterY)));
        }
        for(int i = 0;i < level.bulletTestCnt;i++)
        {
            float monsterX = level.bulletTest[i].getX();
            float monsterY = level.bulletTest[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.bulletTest[i].setVelocity(new Vector2(4*(centerX-monsterX),4*(centerY-monsterY)));
        }
        for(int i = 0;i < level.bulletTestEnemiesCnt;i++)
        {
            float monsterX = level.bulletTestEnemies[i].getX();
            float monsterY = level.bulletTestEnemies[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< heidongfanwei)
                level.bulletTestEnemies[i].setVelocity(new Vector2(4*(centerX-monsterX),4*(centerY-monsterY)));
        }
        for(int i = 0;i < level.bulletTestEnemiesCnt;i++)
        {
            float monsterX = level.bulletTestEnemies[i].getX();
            float monsterY = level.bulletTestEnemies[i].getY();
            if(Math.sqrt((centerX-monsterX)*(centerX-monsterX)+(centerY-monsterY)*(centerY-monsterY) )< 300)
                level.bulletTestEnemies[i].destructed();
        }
    }
}
