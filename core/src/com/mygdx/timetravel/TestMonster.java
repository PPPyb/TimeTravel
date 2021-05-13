package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class TestMonster extends Enemy{

    public TestMonster(float x,float y,Level level)
    {
        super(x, y,level);
        init();
    }

    @Override
    public void init() {
        initAnime();
        this.setAcceleration(Constants.GRAVITY);
        curHP = maxHP = 80f;
        walkSpeed = 50;
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
        if(!isAlive)
            return;
        super.update(deltaTime);
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
}
