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
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class gambleGameInterface extends ApplicationAdapter {
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
    private Texture up5;
    private Texture down5;
    private Texture up6;
    private Texture down6;
    private Button button;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Texture up7;
    private Texture down7;
    private Texture up8;
    private Texture down8;
    private Texture winImage;
    private Button.ButtonStyle style = new Button.ButtonStyle();
    private Button.ButtonStyle style1 = new Button.ButtonStyle();
    private Button.ButtonStyle style2 = new Button.ButtonStyle();
    private Button.ButtonStyle style3 = new Button.ButtonStyle();
    private Button.ButtonStyle style4 = new Button.ButtonStyle();
    private Button.ButtonStyle style5 = new Button.ButtonStyle();
    private Button.ButtonStyle style6 = new Button.ButtonStyle();
    private Button.ButtonStyle style7 = new Button.ButtonStyle();
    private Button.ButtonStyle style8 = new Button.ButtonStyle();
    public Sprite sprite;
    public SpriteBatch batch=new SpriteBatch();
    private Viewport viewport;
    public Stage stage;
    public int gamble_flag=0;
    public gambleGameInterface(){
        viewport = new FillViewport(1280, 720, new OrthographicCamera());
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        
        // 创建为纹理
        Texture texture = new Texture(Gdx.files.internal("Button/greenBoard.jpg"));
        // 创建 Image
        Image image = new Image(new TextureRegion(texture));
        // 设置 image 的相关属性
        image.setPosition(0, 0);
        // 添加 image 到舞台
        stage.addActor(image);

        
        up1= new Texture(Gdx.files.internal("Button/poker8.png"));
        down1 = new Texture(Gdx.files.internal("Button/poker8.png"));
        style1.up = new TextureRegionDrawable(new TextureRegion(up1));
        style1.down = new TextureRegionDrawable(new TextureRegion(down1));
        bt1 = new Button(style1);
        bt1.setPosition(300,400);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("1","");
                //gambleGameInterface.gamble_flag=1;
            }
        });
        stage.addActor(bt1);

        up2= new Texture(Gdx.files.internal("Button/blackpokerJ.png"));
        down2 = new Texture(Gdx.files.internal("Button/blackpokerJ.png"));
        style2.up = new TextureRegionDrawable(new TextureRegion(up2));
        style2.down = new TextureRegionDrawable(new TextureRegion(down2));
        bt2 = new Button(style2);
        bt2.setPosition(300,300);
        bt2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //gambleGameInterface.gamble_flag=1;
            }
        });
        stage.addActor(bt2);

        up3= new Texture(Gdx.files.internal("Button/blackpoker10.png"));
        down3 = new Texture(Gdx.files.internal("Button/blackpoker10.png"));
        style3.up = new TextureRegionDrawable(new TextureRegion(up3));
        style3.down = new TextureRegionDrawable(new TextureRegion(down3));
        bt3 = new Button(style3);
        bt3.setPosition(800,400);
        bt3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("3","");
                //gambleGameInterface.gamble_flag=1;
            }
        });
        stage.addActor(bt3);


        up4= new Texture(Gdx.files.internal("Button/poker10.png"));
        down4 = new Texture(Gdx.files.internal("Button/poker10.png"));
        style4.up = new TextureRegionDrawable(new TextureRegion(up4));
        style4.down = new TextureRegionDrawable(new TextureRegion(down4));
        bt4 = new Button(style4);
        bt4.setPosition(800,300);
        bt4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //gambleGameInterface.gamble_flag=1;
            }
        });
        stage.addActor(bt4);

        up5= new Texture(Gdx.files.internal("Button/blackpokerA.png"));
        down5 = new Texture(Gdx.files.internal("Button/blackpokerA.png"));
        style5.up = new TextureRegionDrawable(new TextureRegion(up5));
        style5.down = new TextureRegionDrawable(new TextureRegion(down5));
        bt5 = new Button(style5);
        bt5.setPosition(800,200);
        bt5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("5","");
                //gambleGameInterface.gamble_flag=1;

            }
        });


        up6 = new Texture(Gdx.files.internal("Button/deal.png"));
        down6 = new Texture(Gdx.files.internal("Button/deal.png"));
        style6.up = new TextureRegionDrawable(new TextureRegion(up6));
        style6.down = new TextureRegionDrawable(new TextureRegion(down6));
        bt6 = new Button(style6);
        bt6.setPosition(500,150);
        bt6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //gambleGameInterface.gamble_flag=1;
                stage.addActor(bt5);

            }
        });
        stage.addActor(bt6);

        up7 = new Texture(Gdx.files.internal("Button/end.png"));
        down7 = new Texture(Gdx.files.internal("Button/end.png"));
        style7.up = new TextureRegionDrawable(new TextureRegion(up7));
        style7.down = new TextureRegionDrawable(new TextureRegion(down7));
        bt7 = new Button(style7);
        bt7.setPosition(500,50);
        bt7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //gambleGameInterface.gamble_flag=1;
                stage.addActor(bt8);

            }
        });
        stage.addActor(bt7);

        up8 = new Texture(Gdx.files.internal("Button/greenBoard2.jpg"));
        down8 = new Texture(Gdx.files.internal("Button/greenBoard2.jpg"));
        style8.up = new TextureRegionDrawable(new TextureRegion(up8));
        style8.down = new TextureRegionDrawable(new TextureRegion(down8));
        bt8 = new Button(style8);
        bt8.setPosition(0,0);
        bt8.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                gamble_flag=1;

            }
        });

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
