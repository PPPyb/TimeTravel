package com.mygdx.BigMap.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;
import com.mygdx.BigMap.otherActor.NPC;
import com.mygdx.BigMap.MyGdxGame;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA=contact.getFixtureA();
        Fixture fixB=contact.getFixtureB();
        int cDef=fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
        if(fixA.getUserData()=="head"||fixB.getUserData()=="head"){
            Fixture head=fixA.getUserData()=="head"?fixA:fixB;
            Fixture object=head==fixA?fixB:fixA;
            if(object.getUserData()!=null&& InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onHeadHit();
            }
        }
        switch (cDef){
            case MyGdxGame.NPC_OBJECT_BIT | MyGdxGame.MARIO_BIT:
                if(fixA.getFilterData().categoryBits==MyGdxGame.NPC_OBJECT_BIT)
                    ((NPC)fixA.getUserData()).hitOnNPC();
                else if(fixB.getFilterData().categoryBits==MyGdxGame.NPC_OBJECT_BIT)
                    ((NPC)fixB.getUserData()).hitOnNPC();
        }
    }


    @Override
    public void endContact(Contact contact) {
        Gdx.app.log("End Contact","");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
