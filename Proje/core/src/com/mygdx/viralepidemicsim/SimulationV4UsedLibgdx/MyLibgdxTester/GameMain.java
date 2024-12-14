package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Buttons.MainMenuButtons;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.CreditsScreen;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.CurfewScreen;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.HowToScreen;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Simulation;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.VaccinatedInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.MainMenu;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Parameters;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Settings;




import java.io.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class GameMain extends Game{

    //instantiative variables
    public SpriteBatch batch;

    //static variables
    public static MainMenu openingScreen; // 0
    public static CreditsScreen creditsScreen; // 1
    public static HowToScreen howToScreen; // 2
    public static Simulation gameScreen; // 3
    public static Settings settingsScreen; // 4
    public static CurfewScreen curfewScreen;
    public static Parameters parametersScreen;
    public static VaccinatedInfo vaccinated;
    public static Stage stage;
    public static Music popSound;
    public static int beforeScreen;

    @Override
    /**
     * creates pixmap
     * creates cursor
     * sets cursor
     * disposes pixmap
     * calls createScreen method
     * starts music
     */
    public void create() {
        Pixmap pixmap = new Pixmap(Gdx.files.internal("cursor.png"));
        Cursor cursor = Gdx.graphics.newCursor(pixmap, 0, 0);
        Gdx.graphics.setCursor(cursor);
        pixmap.dispose();
        popSound = Gdx.audio.newMusic(Gdx.files.internal("popSound.mp3"));
        Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
        //Gdx.app.log("Screen Width", String.valueOf(displayMode.width));
        //Gdx.app.log("Screen Height", String.valueOf(displayMode.height));
        //Gdx.graphics.setFullscreenMode(displayMode);

        batch = new SpriteBatch();
        GameInfo.create();
        createScreens();
        gameScreen.startMusic();
    }

    public void render() {
        super.render();
    }

    public SpriteBatch getBatch(){
        return this.batch;
    }

    /**
     * creates screens of the game
     */
    void createScreens() {
        curfewScreen = new CurfewScreen(this);
        creditsScreen = new CreditsScreen(this);
        gameScreen = new Simulation(this);
        vaccinated = new VaccinatedInfo(this);
        settingsScreen = new Settings(this);
        parametersScreen = new Parameters(this);
        howToScreen = new HowToScreen(this);
        openingScreen = new MainMenu(this);
        setScreen(openingScreen);
    }

    public void dispose() {
        createExcel();
        super.dispose();
    }

    private void createExcel() {

        if(MainMenuButtons.simInitialized){

            Map<String, List> statisticalInfo = gameScreen.statisticalInfo;
            List normalList = statisticalInfo.get("normal");
            List closeContactList = statisticalInfo.get("close_contact");
            List infectedList = statisticalInfo.get("infected");
            List<String[]> policyList = statisticalInfo.get("policy");

            StringBuilder normalStringBuilder = new StringBuilder();
            StringBuilder closeContactStringBuilder = new StringBuilder();
            StringBuilder infectedStringBuilder = new StringBuilder();
            StringBuilder policyStringBuilder = new StringBuilder();

            buildStringFromList(normalList,normalStringBuilder);
            buildStringFromList(closeContactList,closeContactStringBuilder);
            buildStringFromList(infectedList,infectedStringBuilder);


            // 正常人数数据
            String normal = normalStringBuilder.toString();
            // 密接人数数据
            String close_contact = closeContactStringBuilder.toString();
            // 感染人数数据
            String infected = infectedStringBuilder.toString();

            for (int i = 0; i < policyList.size(); i++) {
                // 假设 normalList 中的元素都是数字类型，并且要转换为字符串
                String[] objs = policyList.get(i);
                policyStringBuilder.append(objs[1]).append(":").append(objs[0]);

                // 如果不是最后一个元素，添加逗号
                if (i < policyList.size() - 1) {
                    policyStringBuilder.append(",");
                }
            }

            String policy = policyStringBuilder.toString();

            try {
                String pythonScriptPath =Gdx.files.internal("script.py").file().getAbsolutePath();
                Gdx.app.log("日志",pythonScriptPath);
                // 去除路径中的前导'/'（在Windows下可能不需要这一步，在Linux下如果不处理会导致路径错误）
                String command = "python " + pythonScriptPath + " "  + normal + " " + close_contact + " " + infected + " " + policy;
                Gdx.app.log("command",command);
                // Python脚本路径
                Process process = Runtime.getRuntime().exec(command);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine())!= null) {
                    Gdx.app.log("日志",line);
                }


                int exitCode = process.waitFor();
                if (exitCode!= 0) {
                    Gdx.app.error("[error]","Python脚本执行失败，退出码: " + exitCode);
                }
            } catch (IOException | InterruptedException e) {
                Gdx.app.debug("[debug]","Python脚本执行失败,堆栈信息" + e.toString());
            }


        }

    }

    private void buildStringFromList(List list, StringBuilder stringBuilder) {
        for (int i = 0; i < list.size(); i++) {
            // 假设 normalList 中的元素都是数字类型，并且要转换为字符串
            stringBuilder.append(list.get(i).toString());

            // 如果不是最后一个元素，添加逗号
            if (i < list.size() - 1) {
                stringBuilder.append(",");
            }
        }
    }



}