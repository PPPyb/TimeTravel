package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class WeatherStone extends WeatherBullets{
    public WeatherStone(float x, float y, Level level)
    {
        super(x,y,level);
    }

    ParticleEffect effect;
    TextureRegion[] boom;
    Animation boomAni;
    @Override
    public void initAnime() {
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("Weather/snow.png")));
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("particle/stonefire.particle"),Gdx.files.internal("particle"));
        effect.start();
        Texture tem = new Texture(Gdx.files.internal("testMap/NBbullet.png"));
        TextureRegion[][] temp = TextureRegion.split(tem,tem.getWidth()/4,tem.getHeight()/4);
        boom = new TextureRegion[16];

        for(int i = 0;i < 4;i++)
            for(int j = 0;j < 4;j++)
                boom[4*i+j] = temp[i][j];

        boomAni = new Animation(0.05f, boom);
        boomAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = temp[0][0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        super.updateAnime();
        curFrame = (TextureRegion) boomAni.getKeyFrame(stateTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        effect.setPosition(getX()+width/2,getY()+height/2);
        effect.update(deltaTime);

    }

    @Override
    public void draw(Batch batch) {
        effect.draw(batch);
        super.draw(batch);
    }

    @Override
    public void playerEffect(Player player) {
        for(int i = 0;i < 6;i++)
        {
            if(level.bulletDangMasCnt>900)
                level.bulletDangMasCnt = 0;
            level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX(), getY(),level);
            level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2((float)( -200+Math.random()*400), (float) (300+Math.random()*100)));
            level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(Constants.myGravatiy);
            level.bulletDangMasCnt++;
        }
    }
}
