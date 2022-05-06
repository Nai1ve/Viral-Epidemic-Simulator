package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

public class OpeningScreenButtons {
    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;

    private ImageButton simulation;
    private ImageButton gamee;
    private ImageButton howTo;
    private ImageButton credits;
    private ImageButton settings;
    private ImageButton exit;

    private BitmapFont fontNames;
    
    /**
     * Constructor
     * @param main the GameMain object which will store this screen
     */
    public OpeningScreenButtons(GameMain game) {
        this.game = game;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(gameViewport,game.getBatch());
        createButtons();
        addAllListeners();
        
        fontNames = new BitmapFont(Gdx.files.internal("ButtonsFont.fnt"));
        Gdx.input.setInputProcessor(stage);

        stage.addActor(simulation);
        stage.addActor(gamee);
        stage.addActor(howTo);
        stage.addActor(credits);
        stage.addActor(settings);
        stage.addActor(exit);
    }
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Creating new buttons with their names and positioning them
     */
    void createButtons() {
        simulation = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));
        gamee = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));
        howTo = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));
        credits = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));
        settings = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));
        exit = new ImageButton(new SpriteDrawable(new Sprite(new Texture("BiggerMainButton.png"))));

        simulation.setPosition(GameInfo.WIDTH/2f-GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2f -GameInfo.HEIGHT/20f, Align.center);
        gamee.setPosition(GameInfo.WIDTH/2f +GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2f-GameInfo.HEIGHT/20f, Align.center);
        howTo.setPosition(GameInfo.WIDTH/2f-GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2f-3*GameInfo.HEIGHT/20f, Align.center);
        credits.setPosition(GameInfo.WIDTH/2f +GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2f-3*GameInfo.HEIGHT/20f, Align.center);
        settings.setPosition(GameInfo.WIDTH/2f-GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2f-5*GameInfo.HEIGHT/20f, Align.center);
        exit.setPosition(GameInfo.WIDTH/2f +GameInfo.WIDTH/9.6f, GameInfo.HEIGHT/2-5*GameInfo.HEIGHT/20f, Align.center);
    }
    void dispose() {

    }
    /**
     * Adding functionality to the buttons
     */
    void addAllListeners() {
        simulation.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(null);
                game.setScreen(GameMain.gameScreen);
                GameMain.gameScreen.startMusic();
            } 
        });
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
                System.exit(0);
            }
        });
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(GameMain.creditsScreen.getStage());
                GameMain.stage = (Stage) GameMain.creditsScreen.getStage();
                game.setScreen(GameMain.creditsScreen);
            }
        });
        howTo.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(GameMain.howToScreen.getStage());
                GameMain.stage = (Stage) GameMain.howToScreen.getStage();
                game.setScreen(GameMain.howToScreen);
            }
        });
    }

    public BitmapFont getFontNames() {
        return fontNames;
    }
}
