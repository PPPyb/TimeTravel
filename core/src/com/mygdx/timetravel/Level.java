package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
//import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;

public class Level {
    float stateTime = 0;
    Boolean failed = false;
    float failedEffect = 1;
    Boolean victory = false;
    float victoryTime = -1;

    //绘制
    SpriteBatch batch;
    OrthographicCamera camera;
    CameraHelper cameraHelper;

    SpriteBatch backGroundBatch;
    OrthographicCamera backGroundCamera;
    CameraHelper backGroundCameraHelper;

    SpriteBatch guiBatch;
    OrthographicCamera guiCamera;
    GUIRenderer guiRenderer;
    //地图
    MagicHelper magicHelper;
    TiledMap map;
    OrthogonalTiledMapRenderer mapRenderer;

    TiledMap backGround;
    OrthogonalTiledMapRenderer backGroundRender;
    //主角
    int playerNum = 0;
    Player curPlayer;
    Azuna azuna;
    Kirito kirito;
    Indix indix;
    Jack jack;
    Miku miku;
    Misaka misaka;
    //敌人
    TestMonster[] testMonster;
    int testMonsterCnt;
    Beef[] beefs;
    int beefsCnt;
    Zeus[] zeus;
    int zeusCnt;
    //子弹和技能特效
    BulletTest[] bulletTest;
    int bulletTestCnt;
    BulletTestPenetrate[] bulletTestPenetrate;
    int bulletTestPenetrateCnt;
    BulletTestEnemy[] bulletTestEnemies;
    int bulletTestEnemiesCnt;
    BulletFireWall bulletFireWall;

    AzunaQskillEffect azunaQskillEffect;
    AzunaEskillEffectRecover azunaEskillEffectRecover;

    BulletBeef[] bulletBeef;
    int bulletBeefCnt;
    KiritoQskillEffect kiritoQskillEffect;

    BulletDangMa[] bulletDangMas;
    int bulletDangMasCnt=0;
    IndixQskillEffect indixQskillEffect;
    BulletTitanic bulletTitanic;

    Railgun railgun[];
    MisakaEskillEffect misakaEskillEffect;
    int railgunCut;


    public Level(String mapRoute,String backGroundRoute)
    {
        //绘制
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Constants.WINDOWS_WIDTH,Constants.WINDOWS_HEIGHT);
        cameraHelper = new CameraHelper(false);

        backGroundBatch = new SpriteBatch();
        backGroundCamera = new OrthographicCamera();
        backGroundCamera.setToOrtho(false,Constants.WINDOWS_WIDTH,Constants.WINDOWS_HEIGHT);
        backGroundCameraHelper = new CameraHelper(true);

        guiBatch = new SpriteBatch();
        guiCamera = new OrthographicCamera();
        guiCamera.setToOrtho(false,Constants.WINDOWS_WIDTH,Constants.WINDOWS_HEIGHT);
        guiRenderer = new GUIRenderer(this);
        //地图
        map = new TmxMapLoader().load(mapRoute);
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        backGround = new TmxMapLoader().load(backGroundRoute);
        backGroundRender = new OrthogonalTiledMapRenderer(backGround);
        //主角
        curPlayer = new Player(0,0,this);
        azuna = new Azuna(0,0,this);
        kirito = new Kirito(0,0,this);
        indix = new Indix(0,0,this);
        jack = new Jack(0,0,this);
        miku = new Miku(0,0,this);
        misaka = new Misaka(0,0,this);
        //敌人
        testMonster = new TestMonster[100];
        testMonsterCnt = 0;
        beefs = new Beef[100];
        beefsCnt = 0;
        zeus = new Zeus[100];
        zeusCnt = 0;
        //子弹
        bulletTest = new BulletTest[1000];
        bulletTestCnt = 0;
        bulletTestPenetrate = new BulletTestPenetrate[1000];
        bulletTestPenetrateCnt = 0;
        bulletTestEnemies = new BulletTestEnemy[1000];
        bulletTestEnemiesCnt = 0;
        bulletTitanic  = new BulletTitanic(-10000,-10000,this);
        bulletBeef = new BulletBeef[1000];
        bulletBeefCnt = 0;
        bulletFireWall = new BulletFireWall(-10000,-10000,this);
        azunaQskillEffect = new AzunaQskillEffect(-10000,-10000,this);
        azunaEskillEffectRecover = new AzunaEskillEffectRecover(-10000,-10000,this);
        kiritoQskillEffect = new KiritoQskillEffect(-10000,-10000,this);
        bulletDangMas = new BulletDangMa[1000];
        indixQskillEffect = new IndixQskillEffect(-10000,-10000,this);
        misakaEskillEffect = new MisakaEskillEffect(-10000,-10000,this);
        railgun = new Railgun[1000];

        initPlayer();
        initEnemies();

        magicHelper = new MagicHelper(this);
    }
    public void update(float deltaTime)
    {
        stateTime += deltaTime;
        //Music(!magicHelper.magicIsCasting()) {

            if (victory)
                MusicManager.playMusic(92);
            else if (failed)
                MusicManager.playMusic(91);
            else if(!magicHelper.magicIsCasting())
                MusicManager.playMusic(90);

        //判断胜负
        victoryOrFailed();
        if(victory&&stateTime>victoryTime+Constants.VICTORYSHOWTIME)
            CurState.curLevelNum = 1;
        if(failed&&failedEffect>0.2)
            failedEffect -= deltaTime/10;
        if(victory||failed)
            return;

        //update主角
        choosePlayer();
        curPlayer.update(Gdx.graphics.getDeltaTime());
        magicHelper.update(deltaTime);
        //回复所有角色状态
        azuna.restore();
        kirito.restore();
        indix.restore();
        jack.restore();
        miku.restore();
        misaka.restore();
        //update怪物
        updateObjects(testMonster,testMonsterCnt,deltaTime);
        updateObjects(beefs,beefsCnt,deltaTime);
        updateObjects(zeus,zeusCnt,deltaTime);
        //update子弹
        updateObjects(bulletTest,bulletTestCnt,deltaTime);
        updateObjects(bulletTestPenetrate,bulletTestPenetrateCnt,deltaTime);
        updateObjects(bulletTestEnemies,bulletTestEnemiesCnt,deltaTime);
        updateObjects(bulletBeef,bulletBeefCnt,deltaTime);
        updateObjects(bulletDangMas,bulletDangMasCnt,deltaTime);
        updateObjects(railgun,railgunCut,deltaTime);
        bulletFireWall.update(deltaTime);
        azunaQskillEffect.update(deltaTime);
        azunaEskillEffectRecover.update(deltaTime);
        kiritoQskillEffect.update(deltaTime);
        indixQskillEffect.update(deltaTime);
        bulletTitanic.update(deltaTime);
        misakaEskillEffect.update(deltaTime);

        //update相机
        backGroundCameraHelper.update(deltaTime);
        backGroundCameraHelper.trackTarget(curPlayer);
        backGroundCameraHelper.applyTo(backGroundCamera);
        backGroundCamera.update();

        cameraHelper.update(deltaTime);
        cameraHelper.trackTarget(curPlayer);
        cameraHelper.applyTo(camera);
        camera.update();

        backGroundBatch.setProjectionMatrix(backGroundCamera.combined);
        batch.setProjectionMatrix(camera.combined);
        guiBatch.setProjectionMatrix(guiCamera.combined);
        backGroundRender.setView(backGroundCamera);
        mapRenderer.setView(camera);
    }
    public void draw()
    {
        batch.begin();
        //画地图
        backGroundRender.render();
        mapRenderer.render();
        //画怪物
        drawObjects(testMonster,testMonsterCnt,batch);
        drawObjects(beefs,beefsCnt,batch);
        drawObjects(zeus, zeusCnt, batch);
        //画子弹
        drawObjects(bulletTest,bulletTestCnt,batch);
        drawObjects(bulletTestPenetrate,bulletTestPenetrateCnt,batch);
        drawObjects(bulletTestEnemies,bulletTestEnemiesCnt,batch);
        drawObjects(bulletBeef,bulletBeefCnt,batch);
        drawObjects(bulletDangMas,bulletDangMasCnt,batch);
        drawObjects(railgun,railgunCut,batch);
        bulletFireWall.draw(batch);
        azunaQskillEffect.draw(batch);
        azunaEskillEffectRecover.draw(batch);
        kiritoQskillEffect.draw(batch);
        indixQskillEffect.draw(batch);
        bulletTitanic.draw(batch);
        misakaEskillEffect.draw(batch);

        //画角色
        curPlayer.draw(batch);

        batch.end();

        //绘制GUI
        guiBatch.begin();
        //
        guiRenderer.render(guiBatch);
        //
        if(failed) {
            guiRenderer.failedRender(failedEffect);
        }
        if(victory)
            guiRenderer.victoryRender();
        guiBatch.end();
    }
    public void render()
    {
        update(Gdx.graphics.getDeltaTime());
        draw();
    }
    public void initPlayer()
    {
        MapObjects objects = map.getLayers().get("PlayerLayer").getObjects();
        for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

            Rectangle r = recObj.getRectangle();
            curPlayer.setPosition(new Vector2(r.x,r.y));
        }
    }
    public void initEnemies()
    {
        if(map.getLayers().get("EnemyLayer")!=null) {
            MapObjects objects = map.getLayers().get("EnemyLayer").getObjects();
            for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

                Rectangle r = recObj.getRectangle();
                System.out.println(r);
                testMonster[testMonsterCnt++] = new TestMonster(r.x, r.y, this);
            }
        }
        if(map.getLayers().get("BeefLayer")!=null)
        {
            MapObjects objects = map.getLayers().get("BeefLayer").getObjects();
            for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

                Rectangle r = recObj.getRectangle();
                System.out.println(r);
                beefs[beefsCnt++] = new Beef(r.x, r.y, this);
            }
        }
        if(map.getLayers().get("ZeusLayer")!=null)
        {
            MapObjects objects = map.getLayers().get("ZeusLayer").getObjects();
            for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

                Rectangle r = recObj.getRectangle();
                System.out.println(r);
                zeus[zeusCnt++] = new Zeus(r.x, r.y, this);
            }
        }
    }
    public void choosePlayer()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.TAB))
        {
            if(playerNum >= Constants.PLAYERNUMBER - 1)
                playerNum = 0;
            else
                playerNum++;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.F1))
        {
            playerNum = 11;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.F2))
        {
            playerNum = 12;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1))
        {
            playerNum = 0;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2))
        {
            playerNum = 1;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3))
        {
            playerNum = 2;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4))
        {
            playerNum = 3;
        }
        switch(playerNum)
        {
            case 0:
                azuna.setPosition(curPlayer.position);
                azuna.setVelocity(curPlayer.velocity);
                curPlayer = azuna;
                break;
            case 1:
                kirito.setPosition(curPlayer.position);
                kirito.setVelocity(curPlayer.velocity);
                curPlayer = kirito;
                break;
            case 2:
                indix.setPosition(curPlayer.position);
                indix.setVelocity(curPlayer.velocity);
                curPlayer = indix;
                break;
            case 3:
                misaka.setPosition(curPlayer.position);
                misaka.setVelocity(curPlayer.velocity);
                curPlayer = misaka;
                break;
            case 11:
                jack.setPosition(curPlayer.position);
                jack.setVelocity(curPlayer.velocity);
                curPlayer = jack;
                break;
            case 12:
                miku.setPosition(curPlayer.position);
                miku.setVelocity(curPlayer.velocity);
                curPlayer = miku;
                break;
            default:
                break;
        }
    }
    public void updateObjects(AbstractGameObject[] objects,int cnt,float deltaTime)
    {
        for(int i = 0;i < cnt;i++)
            objects[i].update(deltaTime);
    }
    public void drawObjects(AbstractGameObject[] objects, int cnt, Batch batch)
    {
        for(int i = 0;i < cnt;i++)
            objects[i].draw(batch);
    }
    public void victoryOrFailed() {
        //Cheating
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)&&Gdx.input.isKeyPressed(Input.Keys.V)){
            victory = true;

            if(victoryTime < 0)
                victoryTime = stateTime;
            return;
        }
        //Failed
        if(!azuna.isAlive&&!kirito.isAlive) {
            ;
            failed = true;
            return;
        }
        //Victory
        for(int i = 0;i < testMonsterCnt;i++) {
            if (testMonster[i].isAlive)
                return;
        }
        for(int i = 0;i < beefsCnt;i++) {
            if (beefs[i].isAlive)
                return;
        }
        for(int i = 0;i < zeusCnt;i++) {
            if (zeus[i].isAlive)
                return;
        }
        //victory achieved
        victory = true;
        if(victoryTime < 0)
            victoryTime = stateTime;

    }
}
