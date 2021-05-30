package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class MisakaEskillEffect extends Bullets{

    TextureRegion[] effect;
    Animation effectAni;

    public MisakaEskillEffect(float x, float y, Level level)
    {
        super(x,y,level);
        stateTime = 0;
        damage = 0;
        penetrate = true;
        MPConsume = 200;
        speed = 0;
        niubi = true;
    }

    @Override
    public void initAnime() {
        
        effect = new TextureRegion[20];

        for(int i = 0;i < 20;i++)
        {
        	Texture temp = new Texture(Gdx.files.internal("effects/MisakaE/Thunder ("+(i+1)+").png"));
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
        damage = (int)(200 * deltaTime);
        collideEnemy();
        updateAnime();
        System.out.println(getX()+" "+getY());
    }

    @Override
    public void collideEnemy() {
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            TestMonster monster = level.testMonster[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                monster.loseHP(damage);
                monster.walkSpeed = 0;
                if(!penetrate)
                    this.destructed();
            }
        }
        for(int i = 0;i < level.beefsCnt;i++)
        {
            Beef monster = level.beefs[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                monster.loseHP(damage);
                monster.loseHP(damage);
                monster.walkSpeed = 0;
                if(!penetrate)
                    this.destructed();
            }
        }
        super.collideEnemy();
    }
}
