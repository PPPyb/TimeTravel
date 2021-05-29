package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ChangeMapInterface extends ApplicationAdapter {
    private Texture upTexture;
    private Texture downTexture;
    private Texture upTexture1;
    private Texture downTexture1;
    private Texture interfaceBackground;
    private Button[] button;
    private Viewport viewport;
    public Stage stage;
    private Batch batch;
    private SpriteBatch spriteBatch;
    public ChangeMapInterface(SpriteBatch sb){
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage=new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);
        interfaceBackground=new Texture(Gdx.files.internal("maps/interfaceBackground.jpg"));
        upTexture = new Texture(Gdx.files.internal("Button/1.png"));
        downTexture = new Texture(Gdx.files.internal("Button/3.png"));
        upTexture1 = new Texture(Gdx.files.internal("Button/2.png"));
        downTexture1 = new Texture(Gdx.files.internal("Button/4.png"));
        batch=new SpriteBatch();
        Button.ButtonStyle style1 = new Button.ButtonStyle();
        Button.ButtonStyle style2 = new Button.ButtonStyle();
        style1.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style1.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        style2.up = new TextureRegionDrawable(new TextureRegion(upTexture1));
        style2.down = new TextureRegionDrawable(new TextureRegion(downTexture1));
        button=new Button[3];
        button[0] = new Button(style1);
        button[1] = new Button(style2);
        for(int i=0;i<2;i++) {
            button[i].setPosition(i*130, 0);
            stage.addActor(button[i]);
        }

        button[0].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.changeToFireMapScreen();
            }
        });
        button[1].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlayScreen.changeToSnowMapScreen();
            }
        });
//        button[2].addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                Gdx.app.log("1", "");
//            }
//        });
    }
    @Override
    public void create() {

    }
    @Override
    public void resize(int width, int height) {

    }
    public void update(){

    }
    @Override
    public void render() {
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(interfaceBackground,0,0);
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

