package com.mygdx.BigMap.Screen;

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
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Communication.Hud;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.BigMap.Interface.ChangeMapInterface;
import com.mygdx.BigMap.Interface.SmallMapShow;
import com.mygdx.BigMap.otherActor.*;
import com.mygdx.BigMap.NPC.FireMapNPC;
import com.mygdx.BigMap.NPC.Repairman;
import com.mygdx.BigMap.NPC.SnowBall;
import com.mygdx.BigMap.tools.B2WorldCreator;
import com.mygdx.BigMap.tools.WorldContactListener;

public class FireMapScreen implements Screen {
    public static MyGdxGame game;
    public static int FireMapFlag=1;
    private Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private static NpcCommunication npcCommunication;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMap map1;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Mario mario;
    private TextureAtlas atlas;
    private Music music;
    private Repairman repairman;
    private SmallMapShow smallMapShow;
    private FireMapNPC fireMapNPC;
    private TextureAtlas atlasRepairman;
    private TextureAtlas atlasFireMapNPC;
    private TextureAtlas atlasSnowBall;
    private com.mygdx.BigMap.Interface.shopInterface shopInterface;
    private SnowBall[] snowBall;
    private ChangeMapInterface changeMapInterface;
    public static int smallFireMapCollisionFlag=0;
    public static int FireScreenFlag=1;
    public FireMapScreen(MyGdxGame game,int x,int y){
        atlas = new TextureAtlas("character/zhy.pack");
        atlasRepairman=new TextureAtlas("character/repairman.pack");
        atlasFireMapNPC=new TextureAtlas("character/FireMapNPC.pack");
        atlasSnowBall=new TextureAtlas("character/Ball.pack");
        this.game=game;
        gamecam=new OrthographicCamera();
        gamePort=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //texture=new Texture("5.png");
        hud=new Hud(game.batch);
        npcCommunication=new NpcCommunication(game.batch);
        changeMapInterface=new ChangeMapInterface(game.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("maps/fireMap.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
        world=new World(new Vector2(0,0),true);
        b2dr=new Box2DDebugRenderer();
        new B2WorldCreator(world,map);
        mario=new Mario(world,this,x,y);
        smallMapShow=new SmallMapShow(game.batch);
        snowBall=new SnowBall[5];
        for(int i=0;i<5;i++) {
            snowBall[i] = new SnowBall(this, 495, 20+30*i);
        }
        fireMapNPC=new FireMapNPC(this,32f,32f);
        world.setContactListener(new WorldContactListener());
        //gambleRoomOwner=new GambleRoomOwner(this,32f,32f);
        //music=MyGdxGame.manager.get("music/backgroundMusic.mp3",Music.class);
        //music.setLooping(true);
        // music.play();
    }
    public TextureAtlas getRepairmanAtlas(){
        return  atlasRepairman;
    }
    public TextureAtlas getFireMapAtlas(){
        return atlasFireMapNPC;
    }
    public TextureAtlas getAtlas(){
        return  atlas;
    }
    public TextureAtlas getSnowBallAtlas() {
        return atlasSnowBall;
    }
    @Override
    public void show() {

    }
    public void update(float dt){
        world.step(1/60f,6,2);
        mario.update(dt);
        npcCommunication.update();
        fireMapNPC.update(dt);
        smallMapShow.update(dt);
        for(int i=0;i<5;i++)
            snowBall[i].update(dt);
        //System.out.println(mario.b2body.getPosition().x);
        //System.out.println(mario.b2body.getPosition().y);
        gamecam.position.x =mario.b2body.getPosition().x;
        gamecam.position.y =mario.b2body.getPosition().y;
        gamecam.update();
        renderer.setView(gamecam);
        SmallMapShow.CurrentX1=mario.b2body.getPosition().x;
        SmallMapShow.CurrentY1=mario.b2body.getPosition().y;
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
        fireMapNPC.draw(game.batch);
        for(int i=0;i<5;i++)
            snowBall[i].draw(game.batch);
        //repairman.draw(game.batch);
        //gambleRoomOwner.draw(game.batch);
        game.batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.M))
            smallMapShow.render2();
        if(PlayScreen.collisionFlag==1) {
            npcCommunication.render1();
            npcCommunication.stage.draw();
        }
        if(mario.b2body.getPosition().x>=825 && mario.b2body.getPosition().x<=835 && mario.b2body.getPosition().y>220 && mario.b2body.getPosition().y<240) {
            //SnowMapRoomScreen.SnowMapRoomFlag=0;
            game.setScreen(new FireMapRoomScreen(game));
        }
        if(PlayScreen.PortalCollisionFlag==1) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            hud.stage.dispose();
            //PlayScreen.PlayScreenFlag=1;
            Gdx.input.setInputProcessor(changeMapInterface.stage);
            changeMapInterface.render();
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
        changeMapInterface.dispose();
    }

    public World getWorld() {
        return this.world;
    }
}

