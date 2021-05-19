package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.tools.MyInputProcessor;

public class npcCommunication implements Disposable {
    public Stage stage;
    private Viewport viewport;
    public static int Count=0;
    private Table table;
    private String[] CommunicationContents;
    private MyInputProcessor inputProcessor;
    Label CommunicationLabel;
    public npcCommunication(SpriteBatch sb) {
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        table = new Table();
        inputProcessor = new MyInputProcessor();
        CommunicationContents=new String[10];
        CommunicationContents[0]="Communicate with repairman";
        CommunicationContents[1]="hello";
        CommunicationContents[2]="czp";
        CommunicationContents[3]="sb";
        table.bottom();
        table.setFillParent(true);
        CommunicationLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(CommunicationLabel).expandX();
        stage.addActor(table);
    }
    public void update(){
           Gdx.input.setInputProcessor(inputProcessor);
           CommunicationLabel.setText(CommunicationContents[Count]);
           if(Count>3){
               Count=0;
               PlayScreen.flag=0;
           }
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}
