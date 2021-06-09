package com.mygdx.BigMap.Interface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class shopInterface extends ApplicationAdapter {
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
    private Button bt1,bt2,bt3,bt4;
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
    public static int bt1_flag=0;
    public  static int bt2_flag=0;
    public  static int bt3_flag=0;
    public static int bt4_flag=0;
    public int shop_flag =0;
    public shopInterface(){
        viewport = new FillViewport(1280, 720, new OrthographicCamera());
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        batch=new SpriteBatch();
        monkeyFace=new Texture(Gdx.files.internal("Button/monkeyFace.png"));

        upTexture = new Texture(Gdx.files.internal("Button/shop.png"));
        downTexture = new Texture(Gdx.files.internal("Button/shop.png"));
        style.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        button = new Button(style);
        button.setPosition(600,10);//173,270
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("main","");
                button.setPosition(10000, 10000);
                shop_flag=1;
            }
        });
        stage.addActor(button);

        up1= new Texture(Gdx.files.internal("Button/skill1.png"));
        down1 = new Texture(Gdx.files.internal("Button/skill1.png"));
        style1.up = new TextureRegionDrawable(new TextureRegion(up1));
        style1.down = new TextureRegionDrawable(new TextureRegion(down1));
        bt1 = new Button(style1);
        bt1.setPosition(689,430);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("1","");
                bt1.setPosition(10000, 10000);

                bt1_flag=1;
                System.out.println(bt1_flag+"88888888888");

            }
        });
        stage.addActor(bt1);

        up2= new Texture(Gdx.files.internal("Button/skill2.png"));
        down2 = new Texture(Gdx.files.internal("Button/skill2.png"));
        style2.up = new TextureRegionDrawable(new TextureRegion(up2));
        style2.down = new TextureRegionDrawable(new TextureRegion(down2));
        bt2 = new Button(style2);
        bt2.setPosition(814,430);
        bt2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                bt2.setPosition(10000, 10000);
                bt2_flag=1;
            }
        });
        stage.addActor(bt2);

        up3= new Texture(Gdx.files.internal("Button/skill3.png"));
        down3 = new Texture(Gdx.files.internal("Button/skill3.png"));
        style3.up = new TextureRegionDrawable(new TextureRegion(up3));
        style3.down = new TextureRegionDrawable(new TextureRegion(down3));
        bt3 = new Button(style3);
        bt3.setPosition(949,430);
        bt3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("3","");
                bt3.setPosition(10000, 10000);
                bt3_flag=1;
            }
        });
        stage.addActor(bt3);


        up4= new Texture(Gdx.files.internal("Button/skill4.png"));
        down4 = new Texture(Gdx.files.internal("Button/skill4.png"));
        style4.up = new TextureRegionDrawable(new TextureRegion(up4));
        style4.down = new TextureRegionDrawable(new TextureRegion(down4));
        bt4 = new Button(style4);
        bt4.setPosition(1079,430);
        bt4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                bt4.setPosition(10000, 10000);
                bt4_flag=1;
                //weaponRoomScreen.weaponRoomCollisionFlag=0;
            }
        });
        stage.addActor(bt4);
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
        batch.draw(monkeyFace,0,588,456,134);
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
