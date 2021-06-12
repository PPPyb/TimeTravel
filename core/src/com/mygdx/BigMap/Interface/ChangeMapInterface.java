package com.mygdx.BigMap.Interface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.MyGdxGame;
import com.mygdx.BigMap.Screen.*;

public class ChangeMapInterface extends ApplicationAdapter {
    private Texture upTexture;
    private Texture downTexture;
    private Texture upTexture1;
    private Texture downTexture1;
    private Texture upTexture2;
    private Texture downTexture2;
    private Texture upTexture3;
    private Texture downTexture3;
    private Texture interfaceBackground;
    private Button[] button;
    private Viewport viewport;
    public Stage stage;
    private Batch batch;
    private SpriteBatch spriteBatch;
    private static float stateTime;
    ParticleEffect starEffect;
    public ChangeMapInterface(SpriteBatch sb){
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage=new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);
        interfaceBackground=new Texture(Gdx.files.internal("maps/5.jpg"));
        upTexture = new Texture(Gdx.files.internal("Button/1.png"));
        downTexture = new Texture(Gdx.files.internal("Button/2.png"));
        upTexture1 = new Texture(Gdx.files.internal("Button/3.png"));
        downTexture1 = new Texture(Gdx.files.internal("Button/4.png"));
        upTexture2 = new Texture(Gdx.files.internal("Button/5.png"));
        downTexture2 = new Texture(Gdx.files.internal("Button/6.png"));
        upTexture3 = new Texture(Gdx.files.internal("Button/7.png"));
        downTexture3 = new Texture(Gdx.files.internal("Button/8.png"));
        batch=new SpriteBatch();
        Button.ButtonStyle style1 = new Button.ButtonStyle();
        Button.ButtonStyle style2 = new Button.ButtonStyle();
        Button.ButtonStyle style3 = new Button.ButtonStyle();
        Button.ButtonStyle style4 = new Button.ButtonStyle();
        style1.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style1.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        style2.up = new TextureRegionDrawable(new TextureRegion(upTexture1));
        style2.down = new TextureRegionDrawable(new TextureRegion(downTexture1));
        style3.up = new TextureRegionDrawable(new TextureRegion(upTexture2));
        style3.down = new TextureRegionDrawable(new TextureRegion(downTexture2));
        style4.up = new TextureRegionDrawable(new TextureRegion(upTexture3));
        style4.down = new TextureRegionDrawable(new TextureRegion(downTexture3));
        button=new Button[4];
        button[0] = new Button(style1);
        button[1] = new Button(style2);
        button[2] = new Button(style3);
        button[3] = new Button(style4);
            button[0].setPosition(250, 50);
            button[1].setPosition(150,100);
            button[2].setPosition(0,200);
            button[3].setPosition(0,0);
            for(int i=0;i<4;i++) {
                stage.addActor(button[i]);
            }

        button[0].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.PlayScreenFlag=1;
                PlayScreen.PortalCollisionFlag=0;
                FireMapScreen.FireMapFlag=0;
                GrassMapScreen.GrassScreenFlag=1;
                SnowMapScreen.SnowMapFlag=1;
                PortalScreen.PortalScreenFlag=1;
                PlayScreen.changeToFireMapScreen();
            }
        });
        button[1].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.PlayScreenFlag=1;
                PlayScreen.PortalCollisionFlag=0;
                FireMapScreen.FireMapFlag=1;
                SnowMapScreen.SnowMapFlag=1;
                GrassMapScreen.GrassScreenFlag=0;
                PortalScreen.PortalScreenFlag=1;
                PlayScreen.changeToGrassMapScreen();
            }
        });
        button[2].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.PlayScreenFlag=1;
                PlayScreen.PortalCollisionFlag=0;
                FireMapScreen.FireMapFlag=1;
                GrassMapScreen.GrassScreenFlag=1;
                SnowMapScreen.SnowMapFlag=0;
                PortalScreen.PortalScreenFlag=1;
                PlayScreen.changeToSnowMapScreen();
            }
        });
        button[3].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.PlayScreenFlag=1;
                FireMapScreen.FireMapFlag=1;
                GrassMapScreen.GrassScreenFlag=1;
                SnowMapScreen.SnowMapFlag=1;
                PlayScreen.PortalCollisionFlag=0;
                PortalScreen.PortalScreenFlag=0;
                PlayScreen.changeToPortalScreen();
            }
        });
        starEffect = new ParticleEffect();
        starEffect.load(Gdx.files.internal("particle/starBigMap.particle"),Gdx.files.internal("particle"));
        starEffect.start();
    }
    @Override
    public void create() {

    }
    @Override
    public void resize(int width, int height) {

    }
    public void update(float dt){
        //stateTime+=dt;
        starEffect.setPosition(0,0);
        starEffect.update(dt);
    }
    @Override
    public void render() {
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(interfaceBackground,0,0);
        starEffect.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        if (upTexture != null) {
            upTexture.dispose();
        }
        if (downTexture != null) {
            downTexture.dispose();
        }
        stage.dispose();
    }
}

