package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
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
import com.mygdx.game.tools.MyInputProcessor;

public class NpcCommunication implements Disposable {
    public Stage stage;
    private Viewport viewport;
    public static int communicationCount=0;
    private Table table;
    private String[] CommunicationPlayScreenContents;
    private String[] CommunicationGambleScreenContents;
    private String[] CommunicationRepairmanHomeScreenContents;
    private MyInputProcessor inputProcessor;
    public  Texture repairmanFace;
    private Batch batch;
    Label CommunicationLabel;
    public NpcCommunication(SpriteBatch sb) {
        viewport = new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        table = new Table();
        inputProcessor = new MyInputProcessor();
        batch=new SpriteBatch();
        repairmanFace=new Texture("character/repairmanFace.png");
        CommunicationPlayScreenContents=new String[100];
        //主屏第一次对话内容
        CommunicationPlayScreenContents[0]="Hello, my name is Bob.";
        CommunicationPlayScreenContents[1]="I have been working as a repairman in the space station for 20 years.";
        CommunicationPlayScreenContents[2]="If you want to know about the most interesting places in the city.";
        CommunicationPlayScreenContents[3]="you need meet me at gamble room.";
        CommunicationPlayScreenContents[4]="Oh, this is your first time here. Here's a backpack for you.";
        CommunicationPlayScreenContents[5]="";
        CommunicationGambleScreenContents=new String[100];
        //赌博室第一次对话内容
        CommunicationGambleScreenContents[0]="Actually, I was held hostage by the owner of the casino room .";
        CommunicationGambleScreenContents[1]="because I owed money";
        CommunicationGambleScreenContents[2]="Can you help me? ";
        CommunicationGambleScreenContents[3]="I can tell you some tips and tricks";
        CommunicationGambleScreenContents[4]="for venturing to other planets.";
        CommunicationGambleScreenContents[5]="";
        CommunicationRepairmanHomeScreenContents=new String[100];
        //家里对话
        CommunicationRepairmanHomeScreenContents[0]="First of all, thank you for your help.";
        CommunicationRepairmanHomeScreenContents[1]="You need to go to the store now to buy some skills.";
        CommunicationRepairmanHomeScreenContents[2]="We're going to other planets later.";
        CommunicationRepairmanHomeScreenContents[3]="Time travel,";
        CommunicationRepairmanHomeScreenContents[4]="here we come.";
        CommunicationRepairmanHomeScreenContents[5]="hh";
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
        if(PlayScreen.PlayScreenFlag==0) {
            CommunicationLabel.setText(CommunicationPlayScreenContents[communicationCount]);
        }
        if(PlayScreen.PlayScreenFlag==1 && gambleRoomScreen.gambleRoomFlag==0) {
            CommunicationLabel.setText(CommunicationGambleScreenContents[communicationCount]);
        }
        if(PlayScreen.PlayScreenFlag==1 && repairmanHomeScreen.repairmanHomeFlag==0)
            CommunicationLabel.setText(CommunicationRepairmanHomeScreenContents[communicationCount]);
        if(communicationCount>5){
            communicationCount=0;
            PlayScreen.collisionFlag=0;
        }
    }
    public void render() {
        batch.begin();
        batch.draw(repairmanFace,100,-20,456,134);
        batch.end();
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}