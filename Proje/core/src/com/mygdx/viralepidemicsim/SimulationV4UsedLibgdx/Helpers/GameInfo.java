package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers;

import com.badlogic.gdx.Gdx;

public class GameInfo {
    public static int WIDTH = 10000;
    public static int HEIGHT = 10000;
    public static float PPM = 50;
    public static void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
    }
}
