package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.tools.MyInputProcessor;

public class NpcCommunication implements Disposable {
    public Stage stage;
    private Viewport viewport;
    public static int communicationCount=0;
    private Table table;
    private String[] CommunicationPlayScreenContents;
    private String[] CommunicationGambleScreenContents;
    private MyInputProcessor inputProcessor;
    Label CommunicationLabel;
    public NpcCommunication(SpriteBatch sb) {
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        table = new Table();
        inputProcessor = new MyInputProcessor();
        CommunicationPlayScreenContents=new String[100];
        //主屏第一次对话内容
        CommunicationPlayScreenContents[0]="Hello, my name is Bob.";
        CommunicationPlayScreenContents[1]="I often run around the garden.";
        CommunicationPlayScreenContents[2]="I have been working as a repairman in the sky city for 20 years.";
        CommunicationPlayScreenContents[3]="If you want to know about the most interesting places in the city.";
        CommunicationPlayScreenContents[4]="you need meet me at gamble room.";
        CommunicationPlayScreenContents[5]="";
        CommunicationGambleScreenContents=new String[100];
        //赌博室第一次对话内容
        CommunicationGambleScreenContents[0]="hi";
        CommunicationGambleScreenContents[1]="zhy";
        CommunicationGambleScreenContents[2]="sb";
        CommunicationGambleScreenContents[3]="o";
        CommunicationGambleScreenContents[4]="hh";
        CommunicationGambleScreenContents[5]="hh";
        table.bottom();
        table.setFillParent(true);
        BitmapFont font=new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        CommunicationLabel = new Label("", new Label.LabelStyle(font,Color.WHITE));
        table.add(CommunicationLabel).expandX();
        stage.addActor(table);
    }
    public void update(){
        Gdx.input.setInputProcessor(inputProcessor);
        if(PlayScreen.PlayScreenFlag==0)
            CommunicationLabel.setText(CommunicationPlayScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && gambleRoomScreen.gambleRoomFlag==0)
            CommunicationLabel.setText(CommunicationGambleScreenContents[communicationCount]);
        if(communicationCount>5){
            communicationCount=0;
            PlayScreen.collisionFlag=0;
        }
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}