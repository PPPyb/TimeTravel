package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class openBagInterface extends ApplicationAdapter {
    private Texture upTexture;
    private Texture downTexture;
    private Texture up1;
    private Texture down1;
    private Texture up2;
    private Texture down2;
    private Texture up3;
    private Texture down3;
    private Texture up4;
    private Texture down4;
    private Button button;
    private Button bt1;
    private Texture monkeyFace;
    private Button.ButtonStyle style = new Button.ButtonStyle();
    private Button.ButtonStyle style1 = new Button.ButtonStyle();
    private Button.ButtonStyle style2 = new Button.ButtonStyle();
    private Button.ButtonStyle style3 = new Button.ButtonStyle();
    private Button.ButtonStyle style4 = new Button.ButtonStyle();
    public Sprite sprite;
    public  SpriteBatch batch;
    private Viewport viewport;
    public Stage stage;
    public openBagInterface(){
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        batch=new SpriteBatch();
        monkeyFace=new Texture(Gdx.files.internal("Button/monkeyFace.png"));

        upTexture = new Texture(Gdx.files.internal("Button/bag1.png"));
        downTexture = new Texture(Gdx.files.internal("Button/bag1.2.png"));
        style.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        button = new Button(style);
        button.setPosition(173,15);//173,270
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("main","");
                bagInterface.bag_flag=1;
            }
        });
        stage.addActor(button);

        up1= new Texture(Gdx.files.internal("Button/spell1.png"));
        down1 = new Texture(Gdx.files.internal("Button/spell1.2.png"));
        style1.up = new TextureRegionDrawable(new TextureRegion(up1));
        style1.down = new TextureRegionDrawable(new TextureRegion(down1));
        bt1 = new Button(style1);
        bt1.setPosition(188,210);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("1","");
                //bagInterface.bag_flag=1;
            }
        });
        stage.addActor(bt1);

        up2= new Texture(Gdx.files.internal("Button/spell2.png"));
        down2 = new Texture(Gdx.files.internal("Button/spell2.2.png"));
        style2.up = new TextureRegionDrawable(new TextureRegion(up2));
        style2.down = new TextureRegionDrawable(new TextureRegion(down2));
        bt1 = new Button(style2);
        bt1.setPosition(225,209);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;
            }
        });
        stage.addActor(bt1);

        up3= new Texture(Gdx.files.internal("Button/spell3.png"));
        down3 = new Texture(Gdx.files.internal("Button/spell3.2.png"));
        style3.up = new TextureRegionDrawable(new TextureRegion(up3));
        style3.down = new TextureRegionDrawable(new TextureRegion(down3));
        bt1 = new Button(style3);
        bt1.setPosition(263,210);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("3","");
                //bagInterface.bag_flag=1;
            }
        });
        stage.addActor(bt1);


        up4= new Texture(Gdx.files.internal("Button/spell4.png"));
        down4 = new Texture(Gdx.files.internal("Button/spell4.2.png"));
        style4.up = new TextureRegionDrawable(new TextureRegion(up4));
        style4.down = new TextureRegionDrawable(new TextureRegion(down4));
        bt1 = new Button(style4);
        bt1.setPosition(300,210);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;
            }
        });
        stage.addActor(bt1);
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
        batch.begin();
        batch.draw(monkeyFace,0,570,150,150);
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

    }
}
