package com.mygdx.BigMap.Interface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.MyGdxGame;

public class SmallMapShow implements Disposable {
    public Stage stage;
    public Stage stage1;
    public Stage stage2;
    public Stage stage3;
    private Viewport viewport;
    private Texture SmallMapBackground;
    private Texture SmallMapBackground1;
    private Texture SmallMapBackground2;
    private Texture SmallMapBackground3;
    private Texture sprite;
    private float timeCount;
    public static float CurrentX;
    public static float CurrentY;
    public static float CurrentX1;
    public static float CurrentY1;
    Label PowerRoomLabel;
    Label WeaponRoomLabel;
    Label GambleRoomLabel;
    Label BobHomeLabel;
    Label FiremanRoomLabel;
    Label SnowmanRoomLabel;
    Label GrassManRoomLabel;
    Label LocationLabel;
    Label LocationLabel1;
    Label LocationLabel2;
    Label LocationLabel3;
    private Batch batch;
    public SmallMapShow(SpriteBatch sb) {
        SmallMapBackground=new Texture(Gdx.files.internal("maps/8.png"));
        SmallMapBackground1=new Texture(Gdx.files.internal("maps/9.png"));
        SmallMapBackground2=new Texture(Gdx.files.internal("maps/10.png"));
        SmallMapBackground3=new Texture(Gdx.files.internal("maps/11.png"));
        sprite=new Texture(Gdx.files.internal("maps/sprite.png"));
        batch=new SpriteBatch();
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        stage1 = new Stage(viewport,sb);
        stage2 = new Stage(viewport,sb);
        stage3 = new Stage(viewport,sb);
        BitmapFont font=new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        LocationLabel = new Label("*", new Label.LabelStyle(font, Color.RED));
        LocationLabel1 = new Label("*", new Label.LabelStyle(font, Color.RED));
        LocationLabel2 = new Label("*", new Label.LabelStyle(font, Color.RED));
        LocationLabel3 = new Label("*", new Label.LabelStyle(font, Color.RED));
        PowerRoomLabel = new Label("Power Room", new Label.LabelStyle(font, Color.WHITE));
        WeaponRoomLabel = new Label("Weapon Room", new Label.LabelStyle(font, Color.WHITE));
        BobHomeLabel = new Label("Bob Room", new Label.LabelStyle(font, Color.WHITE));
        GambleRoomLabel = new Label("Gamble Room", new Label.LabelStyle(font, Color.WHITE));
        FiremanRoomLabel = new Label("Fireman Room", new Label.LabelStyle(font, Color.WHITE));
        GrassManRoomLabel = new Label("Grassman Room", new Label.LabelStyle(font, Color.WHITE));
        SnowmanRoomLabel =new Label("Snowman Room", new Label.LabelStyle(font, Color.WHITE));
        PowerRoomLabel.setPosition(425,210);
        WeaponRoomLabel.setPosition(50,200);
        GambleRoomLabel.setPosition(120,120);
        BobHomeLabel.setPosition(450,110);
        FiremanRoomLabel.setPosition(400,170);
        SnowmanRoomLabel.setPosition(200,270);
        GrassManRoomLabel.setPosition(30,250);
        stage.addActor(LocationLabel);
        stage.addActor(PowerRoomLabel);
        stage.addActor(WeaponRoomLabel);
        stage.addActor(GambleRoomLabel);
        stage.addActor(BobHomeLabel);
        stage1.addActor(LocationLabel1);
        stage1.addActor(FiremanRoomLabel);
        stage2.addActor(LocationLabel2);
        stage2.addActor(SnowmanRoomLabel);
        stage3.addActor(LocationLabel3);
        stage3.addActor(GrassManRoomLabel);
    }
    public void update(float dt) {
        timeCount+=dt;
        if(timeCount>=1) {
            //System.out.println((float)(CurrentX/(2.27)+CurrentX%2.27)+" "+(float)(CurrentX/(4.54)+CurrentY%4.54));
            LocationLabel.setPosition(CurrentX/2,CurrentY/4);
            LocationLabel1.setPosition(CurrentX1/2,CurrentY1/2);
            LocationLabel2.setPosition(CurrentX1/2,CurrentY1/2);
            LocationLabel3.setPosition(CurrentX1/2,CurrentY1/2);
        }//220,110
    }
    public void render1(){
        batch.begin();
        batch.draw(SmallMapBackground,0,0);
        batch.end();
        stage.draw();
    }
    public void render2(){
        batch.begin();
        batch.draw(SmallMapBackground1,0,0);
        batch.end();
        stage1.draw();
    }
    public void render3(){
        batch.begin();
        batch.draw(SmallMapBackground2,0,0);
        batch.end();
        stage2.draw();
    }
    public void render4(){
        batch.begin();
        batch.draw(SmallMapBackground3,0,0);
        batch.end();
        stage3.draw();
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}
