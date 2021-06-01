package com.mygdx.game;

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
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actor.Mario;
import com.mygdx.game.Actor.NormalPeople;
import com.mygdx.game.Actor.Repairman;
import com.mygdx.game.Actor.SnowBall;
import com.mygdx.game.tools.B2WorldCreator;
import com.mygdx.game.tools.WorldContactListener;
import com.mygdx.timetravel.MusicManager;

public class PlayScreen implements Screen {
    public static MyGdxGame game;
    private Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private NpcCommunication npcCommunication;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Mario mario;
    private TextureAtlas atlas;
    private TextureAtlas atlasRepairman;
    private TextureAtlas atlasSnowBall;
    private Music music;
    private Repairman repairman;
    private NormalPeople normalPeople1;
    private NormalPeople normalPeople2;
    private SnowBall snowBall;
    private shopInterface shopInterface;
    private ChangeMapInterface changeMapInterface;
    private bagInterface bagInterface;
    private openBagInterface openBagInterface;
    public static int collisionFlag = 0;
    public static int PlayScreenFlag = 0;
    public static int PortalCollisionFlag = 0;
    public PlayScreen(MyGdxGame game,int x,int y) {
        atlas = new TextureAtlas("character/zhy.pack");
        atlasRepairman = new TextureAtlas("character/repairman.pack");
        atlasSnowBall= new TextureAtlas("character/Ball.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //texture=new Texture("5.png");
        hud = new Hud(game.batch);
        npcCommunication = new NpcCommunication(game.batch);
        //shopInterface = new shopInterface(game.batch);
        changeMapInterface=new ChangeMapInterface(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("maps/7.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();
        new B2WorldCreator(world, map);
        mario = new Mario(world, this,x,y);
        snowBall=new SnowBall(this,32f,32f);
        world.setContactListener(new WorldContactListener());
        repairman = new Repairman(this, 32f, 32f);
        normalPeople1 = new NormalPeople(this, 600, 500);
        normalPeople2 = new NormalPeople(this, 600, 600);
        bagInterface=new bagInterface();
        openBagInterface=new openBagInterface();
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }
    public TextureAtlas getSnowBallAtlas() {
        return atlasSnowBall;
    }

    public TextureAtlas getRepairmanAtlas() {
        return atlasRepairman;
    }

    @Override
    public void show() {

    }

    public void update(float dt) {
        world.step(1 / 60f, 6, 2);
        mario.update(dt);
        repairman.update(dt);
        hud.update(dt);
        npcCommunication.update();
        normalPeople1.update(dt);
        normalPeople2.update(dt);
        snowBall.update(dt);
        if (mario.b2body.getPosition().y > 220 && mario.b2body.getPosition().y < 427 && mario.b2body.getPosition().x > 460 && mario.b2body.getPosition().x < 762)
            hud.updateToGarden();
        if (mario.b2body.getPosition().y > 122 && mario.b2body.getPosition().y < 452 && mario.b2body.getPosition().x > 100 && mario.b2body.getPosition().x < 410)
            hud.updateToEntertainmentArea();
        if (mario.b2body.getPosition().y > 125 && mario.b2body.getPosition().y < 350 && mario.b2body.getPosition().x > 820 && mario.b2body.getPosition().x < 1120)
            hud.updateToResidentialArea();
        if (mario.b2body.getPosition().y > 486 && mario.b2body.getPosition().y < 920 && mario.b2body.getPosition().x > 366 && mario.b2body.getPosition().x < 860)
            hud.updateToParkingArea();
        if (mario.b2body.getPosition().y > 560 && mario.b2body.getPosition().y < 805 && mario.b2body.getPosition().x > 885 && mario.b2body.getPosition().x < 1095)
            hud.updateToPowerSupplyArea();
        if (mario.b2body.getPosition().y > 557 && mario.b2body.getPosition().y < 812 && mario.b2body.getPosition().x > 120 && mario.b2body.getPosition().x < 355)
            hud.updateToWeaponSupplyArea();
        //System.out.println(mario.b2body.getPosition().x);
        //System.out.println(mario.b2body.getPosition().y);
        gamecam.position.x = mario.b2body.getPosition().x;
        gamecam.position.y = mario.b2body.getPosition().y;
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        MusicManager.playMusic(80);
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        b2dr.render(world, gamecam.combined);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        mario.draw(game.batch);
        repairman.draw(game.batch);
        normalPeople1.draw(game.batch);
        normalPeople2.draw(game.batch);
        snowBall.draw(game.batch);
        game.batch.end();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
//        if(NpcCommunication.communicationCount==5) {
//            Gdx.input.setInputProcessor(shopInterface.stage);
//            shopInterface.render();
//        }
        if(PortalCollisionFlag==1) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            hud.stage.dispose();
            PlayScreen.PlayScreenFlag=1;
            Gdx.input.setInputProcessor(changeMapInterface.stage);
            changeMapInterface.render();
        }
        //Gdx.input.setInputProcessor(bagInterface.stage);
        //bagInterface.render();
        if(bagInterface.bag_flag==0 && NpcCommunication.communicationCount==5 && PlayScreen.PlayScreenFlag==0) {
            Gdx.input.setInputProcessor(openBagInterface.stage);
            openBagInterface.render();
        }
        else if (bagInterface.bag_flag==1 && NpcCommunication.communicationCount==5 && PlayScreen.PlayScreenFlag==0){
            Gdx.input.setInputProcessor(bagInterface.stage);
            bagInterface.render();
        }
        hud.stage.draw();
        if (mario.b2body.getPosition().x <= 250 && mario.b2body.getPosition().x >= 239 && mario.b2body.getPosition().y > 704 && mario.b2body.getPosition().y < 711) {
            changeToWeaponRoomScreen();
            //weaponRoomScreen.weaponRoomCollisionFlag=1;
        }
        if (mario.b2body.getPosition().x <= 1005 && mario.b2body.getPosition().x >= 970 && mario.b2body.getPosition().y > 700 && mario.b2body.getPosition().y < 719) {
            changeToPowerRoomScreen();
        }
        if (mario.b2body.getPosition().x <= 1025 && mario.b2body.getPosition().x >= 993 && mario.b2body.getPosition().y > 344 && mario.b2body.getPosition().y < 360) {
            changeToRepairmanHomeScreen();
            PlayScreen.PlayScreenFlag = 1;
            //gambleRoomScreen.gambleRoomFlag = 1;
            repairmanHomeScreen.repairmanHomeFlag = 0;
        }
        if (mario.b2body.getPosition().x <= 281 && mario.b2body.getPosition().x >= 248 && mario.b2body.getPosition().y > 372 && mario.b2body.getPosition().y < 402) {
            changeToGambleRoomScreen();
            PlayScreen.PlayScreenFlag = 1;
            gambleRoomScreen.gambleRoomFlag = 0;
        }
        if (collisionFlag == 1 && NpcCommunication.communicationCount<5) {
            npcCommunication.render();
            npcCommunication.stage.draw();
        }
//        if(PortalCollisionFlag==1){
//            changeToFireMapScreen();
//        }



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
        bagInterface.dispose();
        openBagInterface.dispose();
        changeMapInterface.dispose();
        //shopInterface.dispose();
    }

    public World getWorld() {
        return this.world;
    }

    public static void changeToWeaponRoomScreen() {
        game.setScreen(new weaponRoomScreen(game));
    }

    public static void changeToPowerRoomScreen() {
        game.setScreen(new powerRoomScreen(game));
    }

    public static void changeToRepairmanHomeScreen() {
        game.setScreen(new repairmanHomeScreen(game));
    }

    public static void changeToGambleRoomScreen() {
        game.setScreen(new gambleRoomScreen(game));
    }
    public static void changeToFireMapScreen(){
        game.setScreen(new FireMapScreen(game));
    }
    public static void changeToSnowMapScreen(){
        game.setScreen(new SnowMapScreen(game,217,510));
    }
    public static void changeToGrassMapScreen(){
        game.setScreen(new GrassMapScreen(game,630,542));
    }
    public static void changeToPortalScreen() {
        game.setScreen(new PortalScreen(game));
    }
}

