package com.mygdx.timetravel;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

//游戏中的抽象物体
public abstract class AbstractGameObject{
    Vector2 position = new Vector2();//位置
    Vector2 velocity = new Vector2();//速度
    Vector2 acceleration = new Vector2();//加速度
    int width;//宽
    int height;//高
    Rectangle bounds;
    //系统时间
    float stateTime;
    Level level;

    public AbstractGameObject(float x,float y,Level level)
    {
        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2();
        this.position.x = x;
        this.position.y = y;
        setBounds();
        this.level = level;
    }

    public void setX(float x)
    {
        this.position.x = x;
    }

    public void setY(float y)
    {
        this.position.y = y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setVelocity(Vector2 vec)
    {
        this.velocity.x = vec.x;
        this.velocity.y = vec.y;
    }
    public void setAcceleration(Vector2 vec)
    {
        this.acceleration.x = vec.x;
        this.acceleration.y = vec.y;
    }

    public void setBounds() {
        this.bounds = new Rectangle(getX(),getY(),width,height);
    }

    public void update(float deltaTime)
    {
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;
        setBounds();
        stateTime += deltaTime;
    }
    public void draw(Batch batch){}
    public boolean onCollisionWithMap(float xOffset, float yOffset)
    {
        MapObjects objects =  level.map.getLayers().get("CollisionLayer").getObjects();
        for(RectangleMapObject recObj: objects.getByType(RectangleMapObject.class))
        {

            Rectangle r1 = new Rectangle(this.getX()+xOffset,this.getY()+yOffset,this.width,this.height);
            Rectangle r2 = recObj.getRectangle();
            if(Intersector.overlaps(r1,r2)) {
                return true;
            }
        }
        return false;
    }

}
