package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actor.Mario;
import com.mygdx.game.MyGdxGame;




public class Hud implements Disposable {
    public static Stage stage;
    private Viewport viewport;
    private Integer worldTimer;
    private Integer worldTimerMinute;
    private float timeCount;
    private String currentLocation;
    //private Integer score;
    Label countdownLabel;
    Label currentLocationLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;

    public Hud(SpriteBatch sb) {
        worldTimer =0;
        timeCount = 0;
        //score = 0;
        worldTimerMinute=0;
        currentLocation="staircase";
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        BitmapFont font=new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        countdownLabel = new Label(String.format("%02d", worldTimer)+":"+String.format("%02d", worldTimerMinute),new Label.LabelStyle(font, Color.WHITE));
        currentLocationLabel = new Label(currentLocation,new Label.LabelStyle(font, Color.WHITE));
        timeLabel = new Label("Time", new Label.LabelStyle(font, Color.WHITE));
        levelLabel = new Label("1-1",new Label.LabelStyle(font, Color.WHITE) );
        worldLabel = new Label("Space Station",new Label.LabelStyle(font, Color.WHITE) );
        //marioLabel = new Label("Mario", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //table.add(marioLabel).expandX().pad(10);
        table.add(worldLabel).expandX().pad(10);
        table.add(timeLabel).expandX().pad(10);
        table.row();
        table.add(currentLocationLabel).expandX();
        //table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();
//        Gdx.input.setInputProcessor(stage);
//        upTexture = new Texture(Gdx.files.internal("Button/button1.png"));
//        SpriteDrawable upDraw = new SpriteDrawable(new Sprite(upTexture));
//        button = new ImageButton(upDraw);
//        button.setPosition(0,0);
         stage.addActor(table);
//        stage.addActor(button);
    }
    public void update(float dt){
        timeCount+=dt;
        if(timeCount>=1){
            worldTimerMinute++;
            countdownLabel.setText(String.format("%02d", worldTimer)+":"+String.format("%02d", worldTimerMinute));
            if(worldTimerMinute>=60){
                worldTimer++;
                worldTimerMinute=worldTimerMinute-60;
            }
            if(worldTimer>=24)
                worldTimer=0;
            timeCount=0;
        }

    }
    public void updateToGarden(){
        setCurrentLocation("Garden");
        currentLocationLabel.setText(currentLocation);
    }
    public void updateToResidentialArea(){
        setCurrentLocation("Residential Area");
        currentLocationLabel.setText(currentLocation);
    }
    public void updateToEntertainmentArea(){
        setCurrentLocation("Entertainment Area");
        currentLocationLabel.setText(currentLocation);
    }
    public void updateToPowerSupplyArea(){
        setCurrentLocation("Power Supply Area");
        currentLocationLabel.setText(currentLocation);
    }
    public void updateToWeaponSupplyArea(){
        setCurrentLocation("Weapon Supply Area");
        currentLocationLabel.setText(currentLocation);
    }
    public void updateToParkingArea(){
        setCurrentLocation("Parking Area");
        currentLocationLabel.setText(currentLocation);
    }


    public void setCurrentLocation(String currentLocation){
        this.currentLocation=currentLocation;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
