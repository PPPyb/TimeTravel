package com.mygdx.BigMap.Screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Communication.Hud;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.BigMap.Interface.ChangeMapInterface;
import com.mygdx.BigMap.otherActor.Mario;
import com.mygdx.BigMap.NPC.Repairman;
import com.mygdx.BigMap.NPC.SnowBall;

public class changeInterfaceScreen implements Screen {
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
    private SnowBall snowBall;
    private com.mygdx.BigMap.Interface.shopInterface shopInterface;
    private ChangeMapInterface changeMapInterface;
    private com.mygdx.BigMap.Interface.bagInterface bagInterface;
    private com.mygdx.BigMap.Interface.openBagInterface openBagInterface;
    public changeInterfaceScreen(){
        changeMapInterface=new ChangeMapInterface(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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

    }
}
