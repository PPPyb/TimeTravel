package com.mygdx.timetravel.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.timetravel.Constants;
import com.mygdx.timetravel.TimeTravelMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Time Travel";
		config.width = Constants.WINDOWS_WIDTH;
		config.height = Constants.WINDOWS_HEIGHT;
		config.fullscreen = false;
		new LwjglApplication(new TimeTravelMain(), config);
	}
}
