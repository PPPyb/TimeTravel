package com.mygdx.timetravel;

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

    public AbstractGameObject(float x,float y)
    {
        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2();
        this.position.x = x;
        this.position.y = y;
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
        this.velocity = vec;
    }
    public void setAcceleration(Vector2 vec)
    {
        this.acceleration = vec;
    }

    public void update(float deltaTime)
    {
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;
    }
}
