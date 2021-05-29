package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.gambleRoomScreen;
import com.mygdx.game.repairmanHomeScreen;

public class NormalPeople extends NPC {
    private float stateTime;
    private Animation NormalPeopleRightRun;
    private Animation turnAround;
    private Animation NormalPeopleLeftRun;
    private Animation NormalPeopleUpRun;
    private Animation NormalPeopleDownRun;
    private Array<TextureRegion> frames;
    private boolean Stop=true;
    private boolean back=true;
    public BodyDef bdef;
    public NormalPeople(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        NormalPeopleRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
        NormalPeopleLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
        NormalPeopleUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        NormalPeopleDownRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public void update(float dt) {
        stateTime+=dt;
        if(b2body.getPosition().x<700&&back) {
            b2body.setLinearVelocity(10, 0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) NormalPeopleRightRun.getKeyFrame(stateTime, true));
        }
        else {
            b2body.setLinearVelocity(-10, 0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) NormalPeopleLeftRun.getKeyFrame(stateTime, true));
        }
        if(b2body.getPosition().x<700&&back) {
            b2body.setLinearVelocity(10, 0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) NormalPeopleRightRun.getKeyFrame(stateTime, true));
        }
        else {
            b2body.setLinearVelocity(-10, 0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) NormalPeopleLeftRun.getKeyFrame(stateTime, true));
        }
        if(b2body.getPosition().x>700)
            back=false;
        else if(b2body.getPosition().x<500)
            back=true;
    }
    @Override
    protected void defineNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.KinematicBody;
        bdef.linearVelocity.set(20,0);//731,199,731,446
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

    @Override
    public void hitOnNPC() {

    }
}
