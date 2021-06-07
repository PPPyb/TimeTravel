package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SmallMapShow implements Disposable {
    public static Stage stage;
    private Viewport viewport;
    private Texture SmallMapBackground;
    private Texture sprite;
    private float timeCount;
    public static float CurrentX;
    public static float CurrentY;
    Label PowerRoomLabel;
    Label WeaponRoomLabel;
    Label GambleRoomLabel;
    Label BobHomeLabel;
    Label LocationLabel;
    private Batch batch;
    public SmallMapShow(SpriteBatch sb) {
        SmallMapBackground=new Texture(Gdx.files.internal("maps/8.png"));
        sprite=new Texture(Gdx.files.internal("maps/sprite.png"));
        batch=new SpriteBatch();
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        BitmapFont font=new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        LocationLabel = new Label("*", new Label.LabelStyle(font, Color.RED));
        PowerRoomLabel = new Label("Power Room", new Label.LabelStyle(font, Color.WHITE));
        WeaponRoomLabel = new Label("Weapon Room", new Label.LabelStyle(font, Color.WHITE));
        BobHomeLabel = new Label("Bob Room", new Label.LabelStyle(font, Color.WHITE));
        GambleRoomLabel = new Label("Gamble Room", new Label.LabelStyle(font, Color.WHITE));
        PowerRoomLabel.setPosition(425,210);
        WeaponRoomLabel.setPosition(50,200);
        GambleRoomLabel.setPosition(120,120);
        BobHomeLabel.setPosition(450,110);
        stage.addActor(LocationLabel);
        stage.addActor(PowerRoomLabel);
        stage.addActor(WeaponRoomLabel);
        stage.addActor(GambleRoomLabel);
        stage.addActor(BobHomeLabel);
    }
    public void update(float dt) {
        timeCount+=dt;
        if(timeCount>=1) {
            //System.out.println((float)(CurrentX/(2.27)+CurrentX%2.27)+" "+(float)(CurrentX/(4.54)+CurrentY%4.54));
            LocationLabel.setPosition(CurrentX/2,CurrentY/4);
        }//220,110
    }
    public void render(){
        batch.begin();
        batch.draw(SmallMapBackground,0,0);
        batch.end();
        stage.draw();
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}
