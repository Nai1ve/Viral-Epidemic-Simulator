package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

public class CurfewScreen implements Screen{

    public static Texture background;
    private ImageButton turnBack;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private BitmapFont smallerFont;
    private BitmapFont buttonFont; // 添加一个用于按钮的字体
    public static Music nukeSound;
    private Texture buttonTexture = new Texture("MainTitle.png");
    private SpriteDrawable button1 = new SpriteDrawable(new Sprite(new Texture("SecondTitle.png")));
    private SpriteDrawable button3 = new SpriteDrawable(new Sprite(new Texture("ThirdTitle.png")));

    private SpriteDrawable button1red = new SpriteDrawable(new Sprite(new Texture("SecondTitleRed.png")));;
    private SpriteDrawable button3red = new SpriteDrawable(new Sprite(new Texture("ThirdTitleRed.png")));;


    private ImageButton[][] buttons = { {new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red), new ImageButton(button1,button1,button1red)},
                                        {new ImageButton(button3,button3,button3red), new ImageButton(button3,button3,button3red), new ImageButton(button3,button3,button3red), new ImageButton(button3,button3,button3red), new ImageButton(button3,button3,button3red), new ImageButton(button3,button3,button3red)} };
    public boolean days[] = {false, false, false, false, false, false, false};
    public boolean cases[] = {false, false, false, false, false, false};
    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;
    /**
     * Constructor
     * @param main the GameMain object which will store this screen
     */
    public CurfewScreen(GameMain main) {

        batch = new SpriteBatch();
        game = main;
        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(gameViewport,game.getBatch());
        camera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        createButtons();       
        addAllListeners();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(turnBack);
        for(int i = 0; i < buttons.length; i++) 
            for(int j = 0; j < buttons[i].length; j++)
                stage.addActor(buttons[i][j]);
        
        background = new Texture("BackgroundMain.jpg");
        smallerFont = new BitmapFont(Gdx.files.internal("InfoFont3.fnt"), false);
        FontLoader fontLoader = new FontLoader();
        buttonFont = fontLoader.getChineseFont(); // 使用中文字体创建按钮字体

        camera.position.set(GameInfo.WIDTH/2f, GameInfo.HEIGHT/2f, 0);


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
        game.getBatch().draw(background, 0, 0);
        game.getBatch().end();

        //Draws the names of the buttons on the buttons

        batch.begin();
        stage.draw();
        //font.draw(batch, "CURFEW OPTIONS", GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.03f);

        batch.draw(buttonTexture, GameInfo.WIDTH/3f-440, GameInfo.HEIGHT/1.2f-85);
        batch.draw(buttonTexture, GameInfo.WIDTH/2f-30, GameInfo.HEIGHT/1.2f-85);

        buttonFont.draw(batch, "指定日期", GameInfo.WIDTH/3f-100, GameInfo.HEIGHT/1.2f);

        buttonFont.draw(batch, "   周 一   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-100);
        buttonFont.draw(batch, "   周 二   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-200);
        buttonFont.draw(batch, "   周 三   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-300);
        buttonFont.draw(batch, "   周 四   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-400);
        buttonFont.draw(batch, "   周 五   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-500);
        buttonFont.draw(batch, "   周 六   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-600);
        buttonFont.draw(batch, "   周 日   ", GameInfo.WIDTH/3f-115, GameInfo.HEIGHT/1.2f-700);

        buttonFont.draw(batch, "   指定范围     ", GameInfo.WIDTH/2f+150, GameInfo.HEIGHT/1.2f);

        buttonFont.draw(batch, "年龄在0-18岁的", GameInfo.WIDTH/2f+180, GameInfo.HEIGHT/1.2f-100);
        buttonFont.draw(batch, "年龄在19-39岁的", GameInfo.WIDTH/2f+180, GameInfo.HEIGHT/1.2f-200);
        buttonFont.draw(batch, "年龄在40-65岁的", GameInfo.WIDTH/2f+180, GameInfo.HEIGHT/1.2f-300);
        buttonFont.draw(batch, "年龄在65岁以上的", GameInfo.WIDTH/2f+180, GameInfo.HEIGHT/1.2f-400);
        buttonFont.draw(batch, "关闭学校", GameInfo.WIDTH/2f+230, GameInfo.HEIGHT/1.2f-500);
        buttonFont.draw(batch, "关闭工作场所", GameInfo.WIDTH/2f+200, GameInfo.HEIGHT/1.2f-600);

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
        
    } 

    /**
     * Adds functionality to the button by adding listeners
     */
    void addAllListeners() {
        buttons[0][0].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-160);
        buttons[0][1].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-260);
        buttons[0][2].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-360);
        buttons[0][3].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-460);
        buttons[0][4].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-560);
        buttons[0][5].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-660);
        buttons[0][6].setPosition(GameInfo.WIDTH/3f-200, GameInfo.HEIGHT/1.2f-760);

        buttons[1][0].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-160);
        buttons[1][1].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-260);
        buttons[1][2].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-360);
        buttons[1][3].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-460);
        buttons[1][4].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-560);
        buttons[1][5].setPosition(GameInfo.WIDTH/1.2f-570 , GameInfo.HEIGHT/1.2f-660);
        turnBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                if(GameMain.beforeScreen == 2) {
                    GameMain.stage = GameMain.parametersScreen.getStage();
                    Gdx.input.setInputProcessor(GameMain.stage);
                    game.setScreen(GameMain.parametersScreen);
                }
                else {
                    GameMain.stage = GameMain.gameScreen.getStage();
                    Gdx.input.setInputProcessor(GameMain.stage);
                    game.setScreen(GameMain.gameScreen);
                }
                GameMain.gameScreen.curfews = cases;
            }
        });
        buttons[0][0].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttons[0][0].getStyle().down = button1;
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[0] = !days[0];
            }
        });
        buttons[0][1].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[1] = !days[1];
            }
        });
        buttons[0][2].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[2] = !days[2];
            }
        });
        buttons[0][3].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[3] = !days[3];
            }
        });
        buttons[0][4].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[4] = !days[4];
            }
        });
        buttons[0][5].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[5] = !days[5];
            }
        });
        buttons[0][6].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                days[6] = !days[6];
            }
        });
        buttons[1][0].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[0] = !cases[0];
            }
        });
        buttons[1][1].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[1] = !cases[1];
            }
        });
        buttons[1][2].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[2] = !cases[2];
            }
        });
        buttons[1][3].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[3] = !cases[3];
            }
        });
        buttons[1][4].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[4] = !cases[4];
            }
        });
        buttons[1][5].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.stop();
                GameMain.popSound.play();
                cases[5] = !cases[5];
            }
        });
    }

    /**
     * creates buttons 
     */
    void createButtons() {
        turnBack = new ImageButton(new SpriteDrawable(new Sprite(new Texture("TurnBack.png") )));
        turnBack.setPosition(170, GameInfo.HEIGHT*2/2f-60, Align.center);
    }
    

    public Stage getStage() {
        return stage;
    }

}
