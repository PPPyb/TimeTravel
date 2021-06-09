package com.mygdx.BigMap.otherActor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.BigMap.MyGdxGame;


public abstract class InteractiveTileObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;
    public InteractiveTileObject(World world, TiledMap map, Rectangle bounds){
        this.world=world;
        this.map=map;
        this.bounds=bounds;
        BodyDef bedef=new BodyDef();
        FixtureDef fdef=new FixtureDef();
        PolygonShape shape=new PolygonShape();

        bedef.type=BodyDef.BodyType.StaticBody;
        bedef.position.set((float)(bounds.getX()+bounds.getWidth()/2)/ MyGdxGame.PPM,(float)(bounds.getY()+bounds.getHeight()/2)/MyGdxGame.PPM);
        body=world.createBody(bedef);
        shape.setAsBox((float)bounds.getWidth()/2/MyGdxGame.PPM,(float)bounds.getHeight()/2/MyGdxGame.PPM);
        fdef.shape=shape;
        fixture=body.createFixture(fdef);
    }
    public abstract void onHeadHit();
    public void setCategoryFilter(short filterBit){
        Filter filter=new Filter();
        filter.categoryBits=filterBit;
        fixture.setFilterData(filter);
    }
    public TiledMapTileLayer.Cell getCell(){
        TiledMapTileLayer layer=(TiledMapTileLayer) map.getLayers().get(0);
        return layer.getCell(((int)body.getPosition().x/30),(int)body.getPosition().y/30);
    }

}
