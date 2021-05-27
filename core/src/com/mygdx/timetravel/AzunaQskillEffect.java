package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AzunaQskillEffect extends Bullets{

    TextureRegion[] effect;
    Animation effectAni;

    public AzunaQskillEffect(float x, float y, Level level)
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
        
        effect = new TextureRegion[14];

        for(int i = 0;i < 14;i++)
        {
        	System.out.println("effects/AzunaQ/1743-1.png");
        	Texture temp = new Texture(Gdx.files.internal("effects/AzunaQ/7"+(i+1)+".png"));
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
        curFrame = (TextureRegion) effectAni.getKeyFrame(stateTime);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        updateAnime();
        //collideEnemy();

    }
}
