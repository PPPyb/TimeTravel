package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actor.Mario;
import com.mygdx.game.Actor.Repairman;
import com.mygdx.game.tools.B2WorldCreator;
import com.mygdx.game.tools.WorldContactListener;

public class PlayScreen implements Screen {
    public static MyGdxGame game;
    private Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private static npcCommunication npcCommunication;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Mario mario;
    private TextureAtlas atlas;
    private TextureAtlas atlasRepairman;
    private Music music;
    private Repairman repairman;
    public static int flag=0;

    public PlayScreen(MyGdxGame game){
        atlas = new TextureAtlas("character/zhy.pack");
        atlasRepairman=new TextureAtlas("character/repairman.pack");
        this.game=game;
        gamecam=new OrthographicCamera();
        gamePort=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //texture=new Texture("5.png");
        hud=new Hud(game.batch);
        npcCommunication=new npcCommunication(game.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("maps/6.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
        world=new World(new Vector2(0,0),true);
        b2dr=new Box2DDebugRenderer();
        new B2WorldCreator(world,map);
        mario=new Mario(world,this);
        world.setContactListener(new WorldContactListener());
        music=MyGdxGame.manager.get("music/backgroundMusic.mp3",Music.class);
        music.setLooping(true);
        music.play();
        repairman=new Repairman(this,32f,32f);
    }

    public TextureAtlas getAtlas(){
        return  atlas;
    }
    public TextureAtlas getRepairmanAtlas(){
        return  atlasRepairman;
    }
    @Override
    public void show() {

    }
    public void handleInput(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            mario.b2body.applyLinearImpulse(new Vector2(0,20f),mario.b2body.getWorldCenter(),true);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            mario.b2body.applyLinearImpulse(new Vector2(0,-40f),mario.b2body.getWorldCenter(),true);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) ) {
            mario.b2body.applyLinearImpulse(new Vector2(50f,0), mario.b2body.getWorldCenter(),true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
            mario.b2body.applyLinearImpulse(new Vector2(-100f,0), mario.b2body.getWorldCenter(),true);
        }
    }
    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);
        mario.update(dt);
        repairman.update(dt);
        hud.update(dt);
        npcCommunication.update();
        if(mario.b2body.getPosition().y>220 && mario.b2body.getPosition().y<427 && mario.b2body.getPosition().x>460 &&mario.b2body.getPosition().x<762)
            hud.updateToGarden();
        if(mario.b2body.getPosition().y>122 && mario.b2body.getPosition().y<452 && mario.b2body.getPosition().x>100 &&mario.b2body.getPosition().x<410)
            hud.updateToEntertainmentArea();
        if(mario.b2body.getPosition().y>125 && mario.b2body.getPosition().y<350 && mario.b2body.getPosition().x>820 &&mario.b2body.getPosition().x<1120)
            hud.updateToResidentialArea();
        if(mario.b2body.getPosition().y>486 && mario.b2body.getPosition().y<920 && mario.b2body.getPosition().x>366 &&mario.b2body.getPosition().x<860)
            hud.updateToParkingArea();
        if(mario.b2body.getPosition().y>560 && mario.b2body.getPosition().y<805 && mario.b2body.getPosition().x>885 &&mario.b2body.getPosition().x<1095)
            hud.updateToPowerSupplyArea();
        if(mario.b2body.getPosition().y>557 && mario.b2body.getPosition().y<812 && mario.b2body.getPosition().x>120 &&mario.b2body.getPosition().x<355)
            hud.updateToWeaponSupplyArea();
        //System.out.println(mario.b2body.getPosition().x);
        //System.out.println(mario.b2body.getPosition().y);
        gamecam.position.x =mario.b2body.getPosition().x;
        gamecam.position.y =mario.b2body.getPosition().y;
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        b2dr.render(world, gamecam.combined);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        mario.draw(game.batch);
        repairman.draw(game.batch);
        game.batch.end();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        if(mario.b2body.getPosition().x<=235 && mario.b2body.getPosition().x>=220 && mario.b2body.getPosition().y>708 && mario.b2body.getPosition().y<711 ) {
            changeToWeaponRoomScreen();
        }
        if(mario.b2body.getPosition().x<=1005 && mario.b2body.getPosition().x>=985 && mario.b2body.getPosition().y>713 && mario.b2body.getPosition().y<719) {
            changeToPowerRoomScreen();
        }
        if(mario.b2body.getPosition().x<=1025 && mario.b2body.getPosition().x>=1010 && mario.b2body.getPosition().y>350 && mario.b2body.getPosition().y<360) {
            changeToRepairmanHomeScreen();
        }
        if(mario.b2body.getPosition().x<=281 && mario.b2body.getPosition().x>=267 && mario.b2body.getPosition().y>395 && mario.b2body.getPosition().y<402) {
            changeToGambleRoomScreen();
        }
       if(flag==1) {
           npcCommunication.stage.draw();
       }



        //if(Gdx.input.isKeyPressed(Input.Keys.U))
        //changeScreen();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        world.dispose();
        renderer.dispose();
        b2dr.dispose();
        hud.dispose();
    }
    public static void changeToWeaponRoomScreen(){
        game.setScreen(new weaponRoomScreen(game));
    }
    public static void changeToPowerRoomScreen(){
        game.setScreen(new powerRoomScreen(game));
    }
    public static void changeToRepairmanHomeScreen(){
        game.setScreen(new repairmanHomeScreen(game));
    }
    public static void changeToGambleRoomScreen(){
        game.setScreen(new gambleRoomScreen(game));
    }

    public World getWorld() {
        return this.world;
    }
}
