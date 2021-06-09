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
import com.mygdx.game.Actor.BigMan;
import com.mygdx.game.tools.MyInputProcessor;

public class NpcCommunication implements Disposable {
    public Stage stage;
    private Viewport viewport;
    public static int communicationCount=0;
    public static int BigManCount=0;
    private Table table;
    private String[] CommunicationPlayScreenContents;
    private String[] CommunicationGambleScreenContents;
    private String[] CommunicationRepairmanHomeScreenContents;
    private String[] CommunicationPlayScreenNormalman1Contents;
    private String[] CommunicationPlayScreenNormalman2Contents;
    private String[] CommunicationFireMapScreenContents;
    private String[] CommunicationSnowMapScreenContents;
    private String[] CommunicationBigManContents;
    private String[] CommunicationBigManContents1;
    private String[] CommunicationPowerRoomScreenContents;
    private String[] CommunicationGrassRoomScreenContents;
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
        repairmanFace=new Texture("Button/dialogue.png");
        CommunicationPlayScreenContents=new String[100];
        //主屏第一次对话内容
        CommunicationPlayScreenContents[0]="Hello, my name is Bob.";
        CommunicationPlayScreenContents[1]="I have been working as a repairman in the space station for 20 years.";
        CommunicationPlayScreenContents[2]="If you want to know about the most interesting places in the city.";
        CommunicationPlayScreenContents[3]="You need meet me at gamble room.";
        CommunicationPlayScreenContents[4]="My home is quite big. Welcome to my home.";
        CommunicationPlayScreenContents[5]="";
        CommunicationGambleScreenContents=new String[100];
        //赌博室第一次对话内容
        CommunicationGambleScreenContents[0]="Actually, I was held hostage by the owner of the casino room .";
        CommunicationGambleScreenContents[1]="because I owed money";
        CommunicationGambleScreenContents[2]="Can you help me? ";
        CommunicationGambleScreenContents[3]="I can tell you some tips and tricks";
        CommunicationGambleScreenContents[4]="for venturing to other planets.";
        CommunicationGambleScreenContents[5]="";
        CommunicationFireMapScreenContents=new String[100];
        //火焰地图对话
        CommunicationFireMapScreenContents[0]="Are you an adventurer from another planet?";
        CommunicationFireMapScreenContents[1]="There are a lot of monsters in the flame hole";
        CommunicationFireMapScreenContents[2]="What?You want to go to the cave of fire.";
        CommunicationFireMapScreenContents[3]="The monsters in it are very scary.";
        CommunicationFireMapScreenContents[4]="You have to be careful.";
        CommunicationFireMapScreenContents[5]="Good luck to you.";
        CommunicationSnowMapScreenContents=new String[100];
        //冰雪地图对话
        CommunicationSnowMapScreenContents[0]="The monster on the ice field suddenly became much stronger.";
        CommunicationSnowMapScreenContents[1]="Many their people have been hurt.";
        CommunicationSnowMapScreenContents[2]="We're trying to get out of here.";
        CommunicationSnowMapScreenContents[3]="What?You want to go to the cave of ice field.";
        CommunicationSnowMapScreenContents[4]="You have to be careful.";
        CommunicationSnowMapScreenContents[5]="Good luck to you.";
        CommunicationRepairmanHomeScreenContents=new String[100];
        //家里对话
        CommunicationRepairmanHomeScreenContents[0]="First of all, thank you for your help.";
        CommunicationRepairmanHomeScreenContents[1]="You need to go to the store now to buy some skills.";
        CommunicationRepairmanHomeScreenContents[2]="We're going to other planets later.";
        CommunicationRepairmanHomeScreenContents[3]="Time travel,";
        CommunicationRepairmanHomeScreenContents[4]="here we come.";
        CommunicationRepairmanHomeScreenContents[5]="hh";
        CommunicationPowerRoomScreenContents=new String[100];
        //能源室
        CommunicationPowerRoomScreenContents[0]="Thank you for helping me.";
        CommunicationPowerRoomScreenContents[1]="You are now ready to teleport the matrix.";
        CommunicationPowerRoomScreenContents[2]="I've already told him.";
        CommunicationPowerRoomScreenContents[3]="You can go on an adventure.";
        CommunicationPowerRoomScreenContents[4]="Good luck to you.";
        CommunicationPowerRoomScreenContents[5]="hh";
        //守门人对话1
        CommunicationBigManContents=new String[100];
        CommunicationBigManContents[0]="This is the portal to the world of adventure.";
        CommunicationBigManContents[1]="I'm a doorman in the station.";
        CommunicationBigManContents[2]="Let me see if you have enough energy.";
        CommunicationBigManContents[3]="Your plane don't have enough energy access.";
        CommunicationBigManContents[4]="You need to go to the power room in the middle of the station.";
        CommunicationBigManContents[5]="Good luck.";
        //守门人对话2
        CommunicationBigManContents1=new String[100];
        CommunicationBigManContents1[0]="This is the portal to the world of adventure.";
        CommunicationBigManContents1[1]="I'm a doorman in the station.";
        CommunicationBigManContents1[2]="Let me see if you have enough energy.";
        CommunicationBigManContents1[3]="Your plane have enough energy access already";
        CommunicationBigManContents1[4]="Start your adventure!";
        CommunicationBigManContents1[5]="Good luck.";
        //草地图对话
        CommunicationGrassRoomScreenContents=new String[100];
        CommunicationGrassRoomScreenContents[0]="I am a native of this planet.";
        CommunicationGrassRoomScreenContents[1]="But recently minotaurs invaded us.";
        CommunicationGrassRoomScreenContents[2]="They robbed our planet of its jewels.";
        CommunicationGrassRoomScreenContents[3]="Adventurer, can you bring back our treasure?";
        CommunicationGrassRoomScreenContents[4]="Waiting for your good news.";
        CommunicationGrassRoomScreenContents[5]="Good luck.";
        table.setPosition(0,-130);
        table.setFillParent(true);
        BitmapFont font=new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        CommunicationLabel = new Label("", new Label.LabelStyle(font,Color.BLACK));
        table.add(CommunicationLabel).expandX();
        stage.addActor(table);
    }
    public void update(){
        Gdx.input.setInputProcessor(inputProcessor);
        if(PlayScreen.PlayScreenFlag==0 && powerRoomScreen.powerRoomScreenFlag==1 && SnowMapRoomScreen.SnowMapRoomFlag==1 && GrassMapRoomScreen.GrassMapRoomFlag==1) {
            CommunicationLabel.setText(CommunicationPlayScreenContents[communicationCount]);
        }
        if(PlayScreen.PlayScreenFlag==1 && gambleRoomScreen.gambleRoomFlag==0) {
            CommunicationLabel.setText(CommunicationGambleScreenContents[communicationCount]);
        }
        if(PlayScreen.PlayScreenFlag==1 && repairmanHomeScreen.repairmanHomeFlag==0)
            CommunicationLabel.setText(CommunicationRepairmanHomeScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && SnowMapRoomScreen.SnowMapRoomFlag==0)
            CommunicationLabel.setText(CommunicationSnowMapScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && SnowMapScreen.SnowMapFlag==0)
            CommunicationLabel.setText(CommunicationSnowMapScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && FireMapScreen.FireMapFlag==0)
            CommunicationLabel.setText(CommunicationFireMapScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && powerRoomScreen.powerRoomScreenFlag==0)
            CommunicationLabel.setText(CommunicationPowerRoomScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && GrassMapScreen.GrassScreenFlag==0)
            CommunicationLabel.setText(CommunicationGrassRoomScreenContents[communicationCount]);
        if(PlayScreen.PlayScreenFlag==1 && GrassMapRoomScreen.GrassMapRoomFlag==0)
            CommunicationLabel.setText(CommunicationGrassRoomScreenContents[communicationCount]);
        if(BigMan.BigManFlag==true && PlayScreen.PlayScreenFlag==0 && powerRoomScreen.powerRoomScreenFlag==1)
           CommunicationLabel.setText(CommunicationBigManContents[BigManCount]);
        if(BigMan.BigManFlag==true && PlayScreen.PlayScreenFlag==0 && powerRoomScreen.powerRoomScreenFlag==0 )
            CommunicationLabel.setText(CommunicationBigManContents1[BigManCount]);
        if(communicationCount>5){
            communicationCount=0;
            PlayScreen.collisionFlag=0;
            powerRoomScreen.powerRoomCollisionFlag=0;
        }
        if(BigManCount>5){
            BigManCount=0;
            BigMan.BigManFlag=false;
        }
    }
    public void render() {
        batch.begin();
        batch.draw(repairmanFace,0,0,1280,100);
        batch.end();
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}