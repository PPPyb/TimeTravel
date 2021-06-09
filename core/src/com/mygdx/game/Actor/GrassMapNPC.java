package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.GrassMapRoomScreen;
import com.mygdx.game.GrassMapScreen;

public class GrassMapNPC extends NPC{
    private Animation GrassMapNPCLeftRun;
    private Animation GrassMapNPCRightRun;
    private Animation turnAround;
    private float stateTime;
    private Animation GambleRoomOwnerStand;
    private Array<TextureRegion> frames;
    public BodyDef bdef;
    private boolean back=true;
    public GrassMapNPC(GrassMapScreen screen, float x, float y) {
        super(screen, 257, 100);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,0,48,49));
        GambleRoomOwnerStand=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,49,48,49));
        GrassMapNPCLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,98,48,49));
        GrassMapNPCRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public GrassMapNPC(GrassMapRoomScreen screen, float x, float y) {
        super(screen, 300, 100);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,0,48,49));
        GambleRoomOwnerStand=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,49,48,49));
        GrassMapNPCLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,98,48,49));
        GrassMapNPCRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getGrassMapAtlas().findRegion("GrassMapNPC"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    @Override
    protected void defineNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.KinematicBody;
        b2body=world.createBody(bdef);

        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/ MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }
    public void update(float dt) {
        stateTime += dt;
        if(b2body.getPosition().x<430&&back){
            b2body.setLinearVelocity(20,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) GrassMapNPCRightRun.getKeyFrame(stateTime, true));
        }
        else {
            b2body.setLinearVelocity(-20,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) GrassMapNPCLeftRun.getKeyFrame(stateTime, true));
        }
        if(PlayScreen.collisionFlag==1){
            b2body.setLinearVelocity(0,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) turnAround.getKeyFrame(stateTime, true));
        }
        if(b2body.getPosition().x>430) {
            back = false;
        }
        else if(b2body.getPosition().x<300)
            back=true;
    }
    @Override
    public void hitOnNPC() {
        PlayScreen.collisionFlag=1;
    }
}