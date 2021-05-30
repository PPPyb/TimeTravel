package com.mygdx.timetravel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Null;

public class Bullets extends AbstractGameObject{
    //子弹的图像
    Texture img;
    TextureRegion[][] frames;
    TextureRegion curFrame;
    //子弹被销毁
    Boolean isDestructed = false;
    //子弹可穿透单位
    Boolean penetrate = false;
    Boolean niubi = false;
    //MP消耗
    public static float MPConsume;
    //速度标量
    public static float speed;
    //伤害
    int damage;

    //可弹跳
    Boolean bounceAble = false;
    int bounceCnt = 0;
    int bounceMax = 0;

    float stateTime = 0;


    public Bullets(float x,float y,Level level)
    {
        super(x,y,level);
        initAnime();
    }

    public void update(float deltaTime) {
        if (isDestructed)
            return;
        stateTime += deltaTime;
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        float xOffset = velocity.x * deltaTime;
        float yOffset = velocity.y * deltaTime;

        if(this.onCollisionWithMap(xOffset,0)) {
            if(bounceAble && bounceCnt < bounceMax)
            {
                velocity.x = -velocity.x;
                position.x -= xOffset;
                bounceCnt++;
            }
            else
            {
            	if(!niubi)
            		this.destructed();
            }
        }
        else
            position.x += xOffset;

        if(this.onCollisionWithMap(0,yOffset)) {
            if(bounceAble && bounceCnt < bounceMax)
            {
                velocity.y = -velocity.y;
                position.y -= yOffset;
                bounceCnt++;
            }
            else
                this.destructed();
        }
        else
            position.y += yOffset;

        updateAnime();
    }
    public void initAnime(){}
    public void updateAnime(){}

    @Override
    public void draw(Batch batch)
    {
        batch.draw(curFrame,this.getX(),this.getY());
    }
    public void destructed()
    {
        this.setAcceleration(new Vector2(0,0));
        this.setVelocity(new Vector2(0,0));
        this.setPosition(new Vector2(-10000,-10000));
        isDestructed = true;
    }
    public void collideEnemy()
    {
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            TestMonster monster = level.testMonster[i];
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(monster.getX(),monster.getY(),monster.width,monster.height);
            if(Intersector.overlaps(r1,r2)) {
                monster.loseHP(damage);
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
                if(!penetrate)
                    this.destructed();
            }
        }
    }
    public void collidePlayer()
    {
        Player player = level.curPlayer;
        Rectangle r1 = new Rectangle(getX(),getY(),width,height);
        Rectangle r2 = new Rectangle(player.getX(),player.getY(),player.width,player.height);
        if(Intersector.overlaps(r1,r2)) {
            player.loseHP(damage);
            if(!penetrate)
                this.destructed();
        }
    }
}
