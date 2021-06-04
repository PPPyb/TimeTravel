package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class WeatherBullets extends Bullets{

    public WeatherBullets(float x,float y,Level level)
    {
        super(x,y,level);
        initAnime();
    }

    @Override
    public boolean onCollisionWithMap(float xOffset, float yOffset) {
        return false;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        collideEnemy();
        collidePlayer();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    @Override
    public void collideEnemy() {
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            TestMonster monster = level.testMonster[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                enemyEffect(monster);
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
                enemyEffect(monster);
                if(!penetrate)
                    this.destructed();
            }
        }
        for(int i = 0;i < level.zeusCnt;i++)
        {
            Zeus monster = level.zeus[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                enemyEffect(monster);
                if(!penetrate)
                    this.destructed();
            }
        }
        for(int i = 0;i < level.alienCnt;i++)
        {
            Alien monster = level.alien[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                enemyEffect(monster);
                if(!penetrate)
                    this.destructed();
            }
        }
    }

    public void enemyEffect(Enemy enemy)
    {
    }

    @Override
    public void collidePlayer() {
        Player player = level.curPlayer;
        Rectangle r1 = new Rectangle(getX(),getY(),width,height);
        Rectangle r2 = new Rectangle(player.getX(),player.getY(),player.width,player.height);
        if(Intersector.overlaps(r1,r2)) {
           playerEffect(player);
            if(!penetrate)
                this.destructed();
        }
    }

    public void playerEffect(Player player){

    }
}
