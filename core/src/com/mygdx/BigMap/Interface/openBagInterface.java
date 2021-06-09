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
import com.mygdx.SmallMap.LevelFrame.Level;

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
    private Texture up5;
    private Texture down5;
    private Texture up6;
    private Texture down6;
    private Texture up7;
    private Texture down7;
    private Button button;
    public Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    private Texture monkeyFace;
    private Button.ButtonStyle style = new Button.ButtonStyle();
    private Button.ButtonStyle style1 = new Button.ButtonStyle();
    private Button.ButtonStyle style2 = new Button.ButtonStyle();
    private Button.ButtonStyle style3 = new Button.ButtonStyle();
    private Button.ButtonStyle style4 = new Button.ButtonStyle();
    private Button.ButtonStyle style5 = new Button.ButtonStyle();
    private Button.ButtonStyle style6 = new Button.ButtonStyle();
    private Button.ButtonStyle style7 = new Button.ButtonStyle();
    public Sprite sprite;
    public  SpriteBatch batch;
    private Viewport viewport;
    public Stage stage;
    public com.mygdx.BigMap.Interface.shopInterface shopInterface;
    public openBagInterface(){
        viewport = new FillViewport(1280, 720, new OrthographicCamera());
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        batch=new SpriteBatch();
        shopInterface=new shopInterface();
        monkeyFace=new Texture(Gdx.files.internal("Button/monkeyFace.png"));

        upTexture = new Texture(Gdx.files.internal("Button/bag.png"));
        downTexture = new Texture(Gdx.files.internal("Button/bag.png"));
        style.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(downTexture));
        button = new Button(style);
        button.setPosition(555,54);//173,270
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("main","");
                bagInterface.bag_flag=1;

            }
        });
        stage.addActor(button);

        up1= new Texture(Gdx.files.internal("Button/spell1.png"));
        down1 = new Texture(Gdx.files.internal("Button/spell12.png"));
        style1.up = new TextureRegionDrawable(new TextureRegion(up1));
        style1.down = new TextureRegionDrawable(new TextureRegion(down1));
        bt1 = new Button(style1);
        bt1.setPosition(624,382);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("1","");
                //bagInterface.bag_flag=1;


            }
        });


        up2= new Texture(Gdx.files.internal("Button/spell2.png"));
        down2 = new Texture(Gdx.files.internal("Button/spell22.png"));
        style2.up = new TextureRegionDrawable(new TextureRegion(up2));
        style2.down = new TextureRegionDrawable(new TextureRegion(down2));
        bt2 = new Button(style2);
        bt2.setPosition(698,382);
        bt2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;
                System.out.println(shopInterface.bt2_flag);

            }
        });

        up3= new Texture(Gdx.files.internal("Button/spell3.png"));
        down3 = new Texture(Gdx.files.internal("Button/spell32.png"));
        style3.up = new TextureRegionDrawable(new TextureRegion(up3));
        style3.down = new TextureRegionDrawable(new TextureRegion(down3));
        bt3 = new Button(style3);
        bt3.setPosition(776,382);
        bt3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("3","");
                //bagInterface.bag_flag=1;

            }
        });


        up4= new Texture(Gdx.files.internal("Button/spell4.png"));
        down4 = new Texture(Gdx.files.internal("Button/spell42.png"));
        style4.up = new TextureRegionDrawable(new TextureRegion(up4));
        style4.down = new TextureRegionDrawable(new TextureRegion(down4));
        bt4 = new Button(style4);
        bt4.setPosition(855,382);
        bt4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;

            }
        });
        up5 =new Texture(Gdx.files.internal("Button/gemGreen.png"));
        down5 = new Texture(Gdx.files.internal("Button/gemGreen.png"));
        style5.up = new TextureRegionDrawable(new TextureRegion(up5));
        style5.down = new TextureRegionDrawable(new TextureRegion(down5));
        bt5 = new Button(style5);
        bt5.setPosition(933,382);
        bt5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;

            }
        });
        up6= new Texture(Gdx.files.internal("Button/gemBlue.png"));
        down6 = new Texture(Gdx.files.internal("Button/gemBlue.png"));
        style6.up = new TextureRegionDrawable(new TextureRegion(up6));
        style6.down = new TextureRegionDrawable(new TextureRegion(down6));
        bt6 = new Button(style6);
        bt6.setPosition(1011,382);
        bt6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;

            }
        });
        up7= new Texture(Gdx.files.internal("Button/gemRed.png"));
        down7 = new Texture(Gdx.files.internal("Button/gemRed.png"));
        style7.up = new TextureRegionDrawable(new TextureRegion(up7));
        style7.down = new TextureRegionDrawable(new TextureRegion(down7));
        bt7 = new Button(style7);
        bt7.setPosition(1089,382);
        bt7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("2","");
                //bagInterface.bag_flag=1;

            }
        });
        if(shopInterface.bt1_flag==1)
        {
            stage.addActor(bt1);
        }
        if(shopInterface.bt2_flag==1)
        {
            stage.addActor(bt2);
        }
        if(shopInterface.bt3_flag==1)
        {
            stage.addActor(bt3);
        }
        if(shopInterface.bt4_flag==1)
        {
            stage.addActor(bt4);
        }
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
        if(Level.flagGreen ==1)
        {
            stage.addActor(bt5);
        }
        if(Level.flagBlue==1)
        {
            stage.addActor(bt6);
        }
        if(Level.flagRed==1)
        {
            stage.addActor(bt7);
        }
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

    }
}
