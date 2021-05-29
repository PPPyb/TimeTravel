package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IndixQskillEffect extends Bullets{

    TextureRegion[] effect;
    Animation effectAni;

    public IndixQskillEffect(float x, float y, Level level)
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
        
        effect = new TextureRegion[21];

        for(int i = 0;i < 21;i++)
        {
        	Texture temp = new Texture(Gdx.files.internal("effects/darkhole/"+i+".png"));
        	effect[i] = new TextureRegion(temp);
        }

        effectAni = new Animation(0.1f, effect);
        effectAni.setPlayMode(Animation.PlayMode.LOOP);
        curFrame = new TextureRegion();
        curFrame = effect[0];
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    @Override
    public void updateAnime() {
        stateTime += Gdx.graphics.getDeltaTime();
        curFrame = (TextureRegion) effectAni.getKeyFrame(level.indix.qingTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
        //collideEnemy();

    }
}
