package com.mygdx.BigMap.Screen;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.Communication.Hud;
import com.mygdx.BigMap.MyGdxGame;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.BigMap.otherActor.Mario;
import com.mygdx.BigMap.tools.B2WorldCreator;
import com.mygdx.BigMap.tools.WorldContactListener;
import com.mygdx.BigMap.NPC.powerRoomOwner;
import com.mygdx.BigMap.NPC.SnowBall;

public class powerRoomScreen implements Screen {
    public static MyGdxGame game;
    public static int powerRoomScreenFlag=1;
    public static int powerRoomScreenFlag2=1;
    private powerRoomOwner powerRoomOwner;
    private static NpcCommunication npcCommunication;
    private Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMap map1;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private TextureAtlas atlasSnowBall;
    private Mario mario;
    private TextureAtlas atlas;
    private Music music;
    private SnowBall snowBall;
    public static int powerRoomCollisionFlag=0;
    private TextureAtlas atlasPowerRoomOwner;

    public powerRoomScreen(MyGdxGame game){
        atlas = new TextureAtlas("character/zhy.pack");
        atlasPowerRoomOwner=new TextureAtlas("character/GambleRoomOwner.pack");
        atlasSnowBall=new TextureAtlas("character/Ball.pack");
        this.game=game;
        gamecam=new OrthographicCamera();
        gamePort=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //texture=new Texture("5.png");
        hud=new Hud(game.batch);
        npcCommunication=new NpcCommunication(game.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("maps/powerRoom.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
        world=new World(new Vector2(0,0),true);
        b2dr=new Box2DDebugRenderer();
        new B2WorldCreator(world,map);
        mario=new Mario(world,this);
        powerRoomOwner=new powerRoomOwner(this,170 ,200 );
        snowBall =new SnowBall(this, 226, 37);
        world.setContactListener(new WorldContactListener());

        //music=MyGdxGame.manager.get("music/backgroundMusic.mp3",Music.class);
        //music.setLooping(true);
       // music.play();
    }
    public TextureAtlas getAtlas(){
        return  atlas;
    }
    @Override
    public void show() {

    }
    public void update(float dt){
        world.step(1/60f,6,2);
        mario.update(dt);
        npcCommunication.update();
        powerRoomOwner.update(dt);
        snowBall.update(dt);
        System.out.println(mario.b2body.getPosition().x);
        System.out.println(mario.b2body.getPosition().y);
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
        b2dr.render(world, gamecam.combined);
        renderer.render();
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        mario.draw(game.batch);
        powerRoomOwner.draw(game.batch);
        if(powerRoomScreen.powerRoomScreenFlag2==0)
        snowBall.draw(game.batch);
        game.batch.end();
        if (snowBall.b2body.getPosition().x <= 180 && snowBall.b2body.getPosition().x >= 160 && snowBall.b2body.getPosition().y > 200 && snowBall.b2body.getPosition().y < 240) {
            snowBall.setBounds(0,0,0,0);
            powerRoomScreen.powerRoomScreenFlag=0;
        }
        if(powerRoomScreen.powerRoomCollisionFlag==1) {
            npcCommunication.render2();
            npcCommunication.stage.draw();

        }

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
    public World getWorld() {
        return this.world;
    }
    public static void changeToMainScreen(){
        game.setScreen(new PlayScreen(game,971,698));
    }
    public TextureAtlas getPowerRoomOwnerAtlas() {
        return this.atlasPowerRoomOwner;
    }

    public TextureAtlas getSnowBallAtlas() {return atlasSnowBall;
    }
}
