package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester.GameMain;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.FontLoader; // 引入 FontLoader

public class CreditsScreen implements Screen{

    public static Texture background;
    private SpriteBatch batch;
    private ImageButton turnBack;
    private OrthographicCamera camera;
    private BitmapFont fontCredits;
    private BitmapFont fontNames;
    private BitmapFont nameFont; // 添加一个用于按钮的字体
    private String creditsString;
    private String faik, tarik, emre, tuna, gun, captain, member1, member2;
    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;

    /**
     * Constructor
     * @param main the GameMain object which will store this screen
     */
    public CreditsScreen(GameMain main) {
        batch = new SpriteBatch();
        game = main;
        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(gameViewport, game.getBatch());
        camera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        createButtons();
        addAllListeners();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(turnBack);
        background = new Texture("xingkong.png");

        camera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);
        fontCredits = new BitmapFont(Gdx.files.internal("CreditsFont.fnt"));
        fontNames = new BitmapFont(Gdx.files.internal("NamesFont.fnt"));
        FontLoader fontLoader = new FontLoader();
        nameFont = fontLoader.getChineseFont(); // 使用中文字体创建按钮字体
        creditsString = "制作团队:";  
        
        captain = "刘沛泽";
        member1 = "王道冲";
        member2 = "王顺意";
}


    @Override
    public void show() {
        
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Simulation.musicPlayer();
        //Draws the background
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0,GameInfo.WIDTH, GameInfo.HEIGHT);
        game.getBatch().end();

        //Draws the names of the buttons on the buttons
        batch.begin();
        nameFont.draw(batch, creditsString, GameInfo.WIDTH/2.8f, GameInfo.HEIGHT/1.6f);
        
        nameFont.draw(batch, captain, GameInfo.WIDTH / 2.5f, GameInfo.HEIGHT / 1.8f - GameInfo.HEIGHT / 20);
        nameFont.draw(batch, member1, GameInfo.WIDTH / 2.5f, GameInfo.HEIGHT / 1.8f - 2 * GameInfo.HEIGHT / 20);
        nameFont.draw(batch, member2, GameInfo.WIDTH / 2.5f, GameInfo.HEIGHT / 1.8f - 3 * GameInfo.HEIGHT / 20);
        batch.end();

        //Draws the stage and the buttons in it
        stage.draw();
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
        dispose();
    }

    @Override
    public void dispose() {
    } 

    /**
     * Creates the buttons required to return to the OpeningScreen
     */
    void createButtons() {
        turnBack = new ImageButton(new SpriteDrawable(new Sprite(new Texture("TurnBack.png") )));
        turnBack.setPosition(170, GameInfo.HEIGHT*2/2f-60, Align.center);
    }

    /**
     * Adds functionality to the button
     */
    void addAllListeners() {
        turnBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                GameMain.stage = GameMain.openingScreen.getButtons().getStage();
                game.setScreen(GameMain.openingScreen);
                Gdx.input.setInputProcessor(GameMain.openingScreen.getButtons().getStage());
            }
        });
    }

    public Stage getStage() {
        return stage;
    }

}
