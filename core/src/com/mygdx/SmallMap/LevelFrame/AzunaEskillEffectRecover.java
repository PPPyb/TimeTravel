package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AzunaEskillEffectRecover extends Bullets{

    TextureRegion[] effect;
    Animation effectAni;

    public AzunaEskillEffectRecover(float x, float y, Level level)
    {
        super(x,y,level);
        stateTime = 0;
        damage = 0;
        penetrate = true;
        MPConsume = 100;
        speed = 0;
        niubi = true;
    }

    @Override
    public void initAnime() {
        
        effect = new TextureRegion[7];

        for(int i = 0;i < 7;i++)
        {
        	Texture temp = new Texture(Gdx.files.internal("effects/AzunaERecover/"+(i+3)+".png"));
        	effect[i] = new TextureRegion(temp);
        }

        effectAni = new Animation(0.3f, effect);
        effectAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = effect[0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        stateTime += Gdx.graphics.getDeltaTime();
        curFrame = (TextureRegion) effectAni.getKeyFrame(stateTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
        //collideEnemy();

    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
    }

}
