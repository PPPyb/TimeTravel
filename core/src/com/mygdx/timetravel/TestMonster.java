package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class TestMonster extends Enemy{

    public TestMonster(float x,float y,Level level)
    {
        super(x, y,level);
        init();
    }

    @Override
    public void init() {
        initAnime();
        this.setAcceleration(Constants.myGravatiy);
        curHP = maxHP = 80f;
        walkSpeed = 500;
        enemyAI = new EnemyAITest(this);
    }

    @Override
    public void initAnime() {
        img = new Texture(Gdx.files.internal("testMap/monster.png"));
        frames = TextureRegion.split(img,img.getWidth(),img.getHeight());
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        setBounds();
    }

    @Override
    public void update(float deltaTime) {

        super.update(deltaTime);
        if(!isAlive)
            return;
        enemyAI.act();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        TextureRegion imgHP = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        batch.draw(imgHP,getX(),getY()+height+5,curHP*width/maxHP,5);
    }

    @Override
    public void die() {
        super.die();
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/coin.png")));
    }

    @Override
    public void attack() {
        float relativeX = (float) (Math.random()*100-50);
        float relativeY = (float) (Math.random()*100-50);
        float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
        float sin = relativeX/relativeXY;
        float cos = relativeY/relativeXY;
        float velX = BulletTestPenetrate.speed * sin;
        float velY = BulletTestPenetrate.speed * cos;
        shoot(velX,velY);
    }

    public void shoot(float x, float y)
    {
        if(level.bulletTestEnemiesCnt>980)
            level.bulletTestEnemiesCnt = 0;
            level.bulletTestEnemies[level.bulletTestEnemiesCnt] = new BulletTestEnemy(getX()+width/2, getY()+height,level);
            level.bulletTestEnemies[level.bulletTestEnemiesCnt].setVelocity(new Vector2(x, y));
            level.bulletTestEnemiesCnt++;

    }
}
