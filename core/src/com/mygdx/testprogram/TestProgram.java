package com.mygdx.testprogram;

import com.badlogic.gdx.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestProgram extends ApplicationAdapter {

	SpriteBatch batch;
	//OrthographicCamera camera;
	Player[] player;
	Texture img;
	int mapBound[] = new int[1601];
	int obstacle[][] = new int[1601][900];

	BitmapFont myfont;
	BitmapFont myfpsfont;

	Music testMusic;
	Boolean musicplayed = false;
	Music music2;
	Music rag;
	Sound biu;
	//510
	Texture azuna;
	Animation ani;
	TextureRegion[] azunaWalk;
	double stateTime = 0;
	@Override
	public void create() {
		azuna = new Texture("azuna.png");
		TextureRegion[][] tempp1 = TextureRegion.split(azuna,azuna.getWidth()/4,azuna.getHeight()/4);
		azunaWalk = new TextureRegion[4];
		for(int i = 0;i < 4;i++)
			azunaWalk[i] = tempp1[0][i];
		ani = new Animation(0.15f,azunaWalk);
		ani.setPlayMode(Animation.PlayMode.LOOP);

		testMusic =  Gdx.audio.newMusic(Gdx.files.internal("TestBGM.mp3"));
		music2 = Gdx.audio.newMusic(Gdx.files.internal("killbill.mp3"));
		biu =  Gdx.audio.newSound(Gdx.files.internal("biu.mp3"));
		rag =  Gdx.audio.newMusic(Gdx.files.internal("rag.mp3"));

		batch = new SpriteBatch();
		player = new Player[3];

		player[1] = new Player(60, 600,1);
		player[2] = new Player(1400, 600,2);
		for (int i = 700; i <= 1600; i++)
			mapBound[i] = 105;
		for (int i = 1200; i <= 1600; i++)
			mapBound[i] = 305;
		for (int i = 700; i <= 1600; i++)
			for (int j = 0; j < 105; j++)
				obstacle[i][j] = 1;
		for (int i = 1200; i <= 1600; i++)
			for (int j = 0; j < 305; j++)
				obstacle[i][j] = 1;
		img = new Texture("map.png");
		myfont = new BitmapFont(Gdx.files.internal("myfont.fnt"),false);
		myfpsfont = new BitmapFont(Gdx.files.internal("myfont.fnt"),false);

	}
	private void renderGuiLive(SpriteBatch batch,Player player)
	{
		float x = player.x - 50;
		float y = player.y + 200;

		batch.draw(new Texture("HP.png"),x,y);
		batch.draw(new Texture("HPda.png"),x+2*player.HP,y);
		batch.draw(new Texture("HPcv.png"),x+200,y);
		myfont.draw(batch,"Player "+player.id+" Bullets:"+(24-player.bulnum2)+"/24",x,y+100);
		myfont.draw(batch,"HP:"+player.HP+"/100",x+215,y+40);
		myfont.draw(batch,"Angle:"+((int)((double)player.angel*100/(double)15))/(double)100,x,y+150);
	}
	private void renderGuiFpsCnt(SpriteBatch batch)
	{
		int x = 15;
		int y = 885;
		int fps = Gdx.graphics.getFramesPerSecond();

		myfpsfont.draw(batch,"FPS:"+stateTime,x,y);
		myfpsfont.setColor(0,1,0,1);
	}
	private void renderGuiExplain(SpriteBatch batch)
	{
		int x = 15;
		int y = 800;
		int fps = Gdx.graphics.getFramesPerSecond();
		myfont.draw(batch,"Player1:\nMove:A/D\nJump:Space\nShoot&Reload:J/K\nChange angle:Q/E",x,y);
		myfont.draw(batch,"Player2:\nMove:LEFT/RIGHT\nJump:UP\nShoot&Reload:MOUSE1/2\nChange angle:PgUp/PgDn",x+400,y);
		myfont.setColor(0,0,0,1);
	}

	@Override
	public void render() {
		stateTime += Gdx.graphics.getDeltaTime();
		if(!testMusic.isPlaying()&&!musicplayed&&!music2.isPlaying())
		{
			testMusic.play();
			musicplayed = true;
		}
	/*	if(!testMusic.isPlaying()&&!music2.isPlaying()) {
			music2.play();
		}*/
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//camera.update();
		batch.begin();

		batch.draw(img, 0, 0);

		TextureRegion curFrame = (TextureRegion) ani.getKeyFrame((float)stateTime,true);

		batch.draw(curFrame,900,100,azuna.getWidth(),azuna.getHeight());
		for (int i = 0; i < player[1].bulnum; i++)
			batch.draw(player[1].bullet[i].img, (int) player[1].bullet[i].x, (int) player[1].bullet[i].y);
		for (int i = 0; i < player[2].bulnum; i++)
			batch.draw(player[2].bullet[i].img, (int) player[2].bullet[i].x, (int) player[2].bullet[i].y);
		batch.draw(player[1].img, player[1].x, player[1].y);
		batch.draw(player[2].img, player[2].x, player[2].y);
		renderGuiLive(batch,player[1]);
		renderGuiLive(batch,player[2]);
		renderGuiFpsCnt(batch);
		renderGuiExplain(batch);
		//renderGuiExplain2(batch);
		batch.end();

		player[1].breath(rag);
		if (player[1].x <= 1600 && player[1].x >= 0&&player[1].alive) {

			if (Gdx.input.isKeyPressed(Keys.A)) {
				int newx = (int) (player[1].x - 250 * Gdx.graphics.getDeltaTime());
				if (newx >= 0)
					if (obstacle[newx][player[1].y] != 1) {
						player[1].x = newx;
						player[1].setImg(2);
					}
			}
			if (Gdx.input.isKeyPressed(Keys.D)) {
				int newx = (int) (player[1].x + 250 * Gdx.graphics.getDeltaTime());
				if (newx <= 1600 - 100)
					if (obstacle[newx][player[1].y] != 1) {
						player[1].x = newx;
						player[1].setImg(1);
					}
			}
			if (Gdx.input.isKeyPressed(Keys.Q))
				player[1].anpl();
			if (Gdx.input.isKeyPressed(Keys.E))
				player[1].anmi();
			if (Gdx.input.isKeyPressed(Keys.SPACE)) player[1].startJumping();
			player[1].jump(mapBound[player[1].x]);
			player[1].drop(mapBound[player[1].x]);
			if (Gdx.input.isKeyJustPressed(Keys.K))
				player[1].shoot(1,biu);
			else if (Gdx.input.isKeyJustPressed(Keys.J))
				player[1].shoot(2,biu);
			for (int i = 0; i < player[1].bulnum; i++)
				player[1].bullet[i].move(player[2]);
		}
		player[2].breath(rag);
		if (player[2].x <= 1600 && player[2].x >= 0&&player[2].alive) {

			if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				int newx = (int) (player[2].x - 250 * Gdx.graphics.getDeltaTime());
				if (newx >= 0)
					if (obstacle[newx][player[2].y] != 1) {
						player[2].x = newx;
						player[2].setImg(2);
					}
			}
			if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				int newx = (int) (player[2].x + 250 * Gdx.graphics.getDeltaTime());
				if (newx <= 1600 - 100)
					if (obstacle[newx][player[2].y] != 1) {
						player[2].x = newx;
						player[2].setImg(1);
					}
			}
			if (Gdx.input.isKeyPressed(Keys.PAGE_UP))
				player[2].anpl();
			if (Gdx.input.isKeyPressed(Keys.PAGE_DOWN))
				player[2].anmi();
			if (Gdx.input.isKeyJustPressed(Keys.UP)) player[2].startJumping();
			player[2].jump(mapBound[player[2].x]);
			player[2].drop(mapBound[player[2].x]);
			if (Gdx.input.isButtonJustPressed(Buttons.RIGHT))
				player[2].shoot(1,biu);
			else if (Gdx.input.isButtonJustPressed(Buttons.LEFT))
				player[2].shoot(2,biu);
			for (int i = 0; i < player[2].bulnum; i++)
				player[2].bullet[i].move(player[1]);
		}
	}



	
	@Override
	public void dispose () {
		batch.dispose();
		testMusic.dispose();
	}
}
