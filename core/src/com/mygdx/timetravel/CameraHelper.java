package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

//CameraHelper类帮助调整相机
public class CameraHelper {
    private final float MAX_ZOOM_IN = 0.5f;
    private final float MAX_ZOOM_OUT = 2f;

    private Vector2 position;
    public float zoom;

    Boolean isBackGround;

    public CameraHelper(Boolean isBackGround)
    {
        position = new Vector2();
        this.isBackGround = isBackGround;
        zoom = 1.0f;
    }
    public void update(float deltaTime)
    {

    }
    public void zoom(float a)
    {
            zoom = a;
    }
    public void trackTarget(AbstractGameObject target)
    {

        if(isBackGround)
        {
            position.x = Constants.WINDOWS_WIDTH/2 + target.getX()/15;
            position.y = Constants.WINDOWS_HEIGHT/2 + target.getY()/15;
        }
        else
        {
            position.x = target.getX();
            position.y = target.getY();
        }
    }
    public void applyTo(OrthographicCamera camera)
    {
        camera.position.x = this.position.x;
        camera.position.y = this.position.y;
        camera.zoom = zoom;
        camera.update();
    }
}
