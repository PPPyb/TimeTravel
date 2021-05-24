package com.mygdx.game.Actor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.*;

public abstract class NPC extends Sprite {
    protected World world;
    protected PlayScreen screen;
    protected OutsidegambleRoomScreen screen1;
    protected OutsideweaponRoomScreen screen2;
    protected OutsidepowerRoomScreen  screen3;
    protected OutsiderepairmanHomeScreen screen4;
    protected gambleRoomScreen screen5;
    public Body b2body;
    public NPC(PlayScreen screen, float x, float y){
        this.world=screen.getWorld();
        this.screen=screen;
        setPosition(x,y);
        defineNPC(480,200);
    }
    public NPC(OutsidegambleRoomScreen screen1, float x, float y){
        this.world=screen1.getWorld();
        this.screen1=screen1;
        setPosition(x,y);
        defineNPC(900,200);
    }
    public NPC(OutsideweaponRoomScreen screen2, float x, float y){
        this.world=screen2.getWorld();
        this.screen2=screen2;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(OutsidepowerRoomScreen screen3, float x, float y){
        this.world=screen3.getWorld();
        this.screen3=screen3;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(OutsiderepairmanHomeScreen screen4, float x, float y){
        this.world=screen4.getWorld();
        this.screen4=screen4;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(gambleRoomScreen screen5, float x, float y){
        this.world=screen5.getWorld();
        this.screen5=screen5;
        setPosition(x,y);
        defineNPC(460,100);
    }
    protected abstract void defineNPC(int x,int y);
    public abstract void hitOnNPC();
}
