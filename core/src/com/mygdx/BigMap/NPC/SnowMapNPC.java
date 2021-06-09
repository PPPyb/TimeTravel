package com.mygdx.BigMap.NPC;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Screen.PlayScreen;
import com.mygdx.BigMap.Screen.SnowMapRoomScreen;
import com.mygdx.BigMap.Screen.SnowMapScreen;
import com.mygdx.BigMap.otherActor.NPC;

public class SnowMapNPC extends NPC {
    private Animation SnowMapNPCLeftRun;
    private Animation SnowMapNPCRightRun;
    private Animation turnAround;
    private float stateTime;
    private Animation GambleRoomOwnerStand;
    private Array<TextureRegion> frames;
    public BodyDef bdef;
    private boolean back=true;
    public SnowMapNPC(SnowMapScreen screen, float x, float y) {
        super(screen, 800, 100);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,0,48,49));
        GambleRoomOwnerStand=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,49,48,49));
        SnowMapNPCLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,98,48,49));
        SnowMapNPCRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public SnowMapNPC(SnowMapRoomScreen screen, float x, float y) {
        super(screen, 300, 100);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,0,48,49));
        GambleRoomOwnerStand=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,49,48,49));
        SnowMapNPCLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,98,48,49));
        SnowMapNPCRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowMapAtlas().findRegion("SnowMapNPC"),48*i,0,48,49));
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
            setRegion((TextureRegion) SnowMapNPCRightRun.getKeyFrame(stateTime, true));
        }
        else {
            b2body.setLinearVelocity(-20,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) SnowMapNPCLeftRun.getKeyFrame(stateTime, true));
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
