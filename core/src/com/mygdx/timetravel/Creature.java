package com.mygdx.timetravel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Creature extends AbstractGameObject{
    Texture img;

    public Creature(Texture img,int x,int y)
    {
        super(x,y);


    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public void update(float deltaTime,TiledMap map,String collisionLayer) {
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        float xOffset = velocity.x * deltaTime;
        float yOffset = velocity.y * deltaTime;

        if(this.onCollisionWithMap(map,collisionLayer,xOffset,0))
            velocity.x = 0;
        else
        position.x += xOffset;

        if(this.onCollisionWithMap(map,collisionLayer,0,yOffset))
            velocity.y = 0;
        else
        position.y += yOffset;

    }
    public void move(String state,int speed)
    {
        switch (state)
        {
            case "LEFT":
                this.velocity.set(-speed,this.velocity.y);
                break;
            case "RIGHT":
                this.velocity.set(speed,this.velocity.y);
                break;
            case "IDLE":
                this.velocity.set(0,this.velocity.y);
                break;
        }
    }

    public void jump(Boolean state,int speed)
    {
        if(state)
            this.velocity.y = speed;
    }

    public void draw(Batch batch)
    {
        //
        batch.draw(img,this.getX(),this.getY());
    }

    public boolean onCollisionWithMap(TiledMap map,String collisionLayer,float xOffset,float yOffset)
    {
        MapObjects objects =  map.getLayers().get(collisionLayer).getObjects();
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
