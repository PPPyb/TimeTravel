package com.mygdx.BigMap.Interface;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class bagInterface extends ApplicationAdapter {
    private Texture upTexture;
    private Texture downTexture;
    private Button button;
    private Viewport viewport;
    public Stage stage;
    public static int bag_flag=1;
    openBagInterface shopInterface;
    public bagInterface(){
        viewport = new FillViewport(1280, 720, new OrthographicCamera());
        stage=new Stage(viewport);
        shopInterface=new openBagInterface();
        Gdx.input.setInputProcessor(stage);
        upTexture = new Texture(Gdx.files.internal("Button/interface.png"));
        downTexture = new Texture(Gdx.files.internal("Button/interface.png"));
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        button = new Button(style);
        button.setPosition(0,0);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("1","");
                Gdx.gl.glClearColor(1, 1, 1, 1);
                bag_flag=0;
                System.out.println(bag_flag);

            }
        });
        stage.addActor(button);
    }
    @Override
    public void create() {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        //System.out.println(1);
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    }
}
