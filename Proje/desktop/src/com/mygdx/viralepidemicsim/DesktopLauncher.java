package com.mygdx.viralepidemicsim;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester.GameMain;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
		//new Lwjgl3Application(new ViralEpidemicSim(), config);
		config.useVsync(true);
		config.setTitle("呼吸道疾病模拟器");

		config.setWindowedMode(GameInfo.WIDTH, GameInfo.HEIGHT);

		Lwjgl3Application application = new Lwjgl3Application(new GameMain(), config);
		application.setLogLevel(Application.LOG_DEBUG);
	}
}
