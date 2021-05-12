package com.mygdx.timetravel;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractGameObject{
    Vector2 position = new Vector2();

    public AbstractGameObject()
    {
        init(0,0);
    }
    public AbstractGameObject(float x,float y)
    {
        init(x,y);
    }

    public void init(float x,float y)
    {
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

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
