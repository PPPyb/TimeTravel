package com.mygdx.SmallMap.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.SmallMap.LevelFrame.Constants;
import com.mygdx.SmallMap.LevelFrame.TimeTravelMain;

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
