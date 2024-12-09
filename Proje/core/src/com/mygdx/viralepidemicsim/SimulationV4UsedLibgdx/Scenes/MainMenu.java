package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Buttons.MainMenuButtons;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.FontLoader; // 引入 FontLoader
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester.GameMain;

public class MainMenu implements Screen {

    private BitmapFont font;
    private BitmapFont buttonFont; // 添加一个用于按钮的字体
    public static Texture background;
    private OrthographicCamera camera;
    private GameMain game;
    private MainMenuButtons buttons;
    private SpriteBatch batch;

    /**
     * Constructor
     * @param main the GameMain object which will store this screen
     */
    public MainMenu(GameMain main) {
        game = main;

        // 使用默认字体（可以用 TitleFont.fnt 继续使用）
        font = new BitmapFont(Gdx.files.internal("TitleFont.fnt"));

        // 实例化 FontLoader 并获取中文字体
        FontLoader fontLoader = new FontLoader();
        buttonFont = fontLoader.getChineseFont(); // 使用中文字体创建按钮字体

        buttons = new MainMenuButtons(game);
        camera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        batch = new SpriteBatch();

        background = new Texture("BackgroundMain.jpg");
        camera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Simulation.musicPlayer();
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
        game.getBatch().end();
        game.getBatch().setProjectionMatrix(buttons.getStage().getCamera().combined);
        buttons.getStage().draw();
        batch.begin();
        
     
        buttonFont.draw(batch, "呼吸道疾病\n  模拟器", GameInfo.WIDTH / 2.28f, GameInfo.HEIGHT / 1.4f);
        
        // 修改按钮的文本为中文
        buttonFont.draw(batch, " 开始模拟", GameInfo.WIDTH / 2.28f, GameInfo.HEIGHT / 2f - GameInfo.HEIGHT / 27f+3);
        buttonFont.draw(batch, " 使用帮助", GameInfo.WIDTH / 2f - GameInfo.WIDTH / 6.12f, GameInfo.HEIGHT / 2f - GameInfo.HEIGHT / 7.4f);
        buttonFont.draw(batch, "     关于我们", GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - GameInfo.HEIGHT / 7.4f);
        buttonFont.draw(batch, "   设置", GameInfo.WIDTH / 2f - GameInfo.WIDTH / 6.12f, GameInfo.HEIGHT / 2f - GameInfo.HEIGHT / 4.23f);
        buttonFont.draw(batch, "    退出到桌面", GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - GameInfo.HEIGHT / 4.23f);
        
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        font.dispose(); // 释放默认字体资源
        buttonFont.dispose(); // 释放中文字体资源
        background.dispose(); // 释放背景纹理资源
        batch.dispose(); // 释放 SpriteBatch 资源
    }

    public MainMenuButtons getButtons() {
        return buttons;
    }
}

