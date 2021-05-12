package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

//CameraHelper类帮助测试相机
public class CameraHelper {
    private final float MAZ_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 10f;

    private Vector2 position;
    private float zoom;

    public CameraHelper()
    {
        position = new Vector2();
        zoom = 1.0f;
    }
    public void update(float deltaTime)
    {

    }
    public void trackTarget(AbstractGameObject target)
    {
        position.x =  target.getX();
        position.y =  target.getY();
    }
    public void applyTo(OrthographicCamera camera)
    {
        camera.position.x = this.position.x;
        camera.position.y = this.position.y;
        camera.zoom = zoom;
        camera.update();
    }
}
