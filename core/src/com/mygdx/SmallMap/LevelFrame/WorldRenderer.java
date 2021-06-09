package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.utils.Disposable;

//这个类用来渲染世界
public class WorldRenderer implements Disposable {

    private WorldController worldController;

    public WorldRenderer(WorldController worldController)
    {
        this.worldController = worldController;
    }

    public void render()
    {
        worldController.render();
    }
    public void resize(int width,int height)
    {

    }

    @Override
    public void dispose()
    {

    }
}
