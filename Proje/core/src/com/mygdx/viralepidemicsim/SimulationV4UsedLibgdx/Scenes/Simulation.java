package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.viralepidemicsim.FirstVersion.FinalVariables;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap.GridMap;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester.GameMain;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Population.Population;


public class Simulation implements Screen, ContactListener{

    private BitmapFont font;
    private GameMain game;
    private Texture bg;
    private Texture gui;
    private Population population;
    private World world;
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;
    protected static Music[] musics;
    private int currentMusic;
    private Stage stage;
    private Viewport viewport;
    private ImageButton settings;

    float clock = 0;

    GridMap abstractMap;

    Texture hospital;
    Texture house;

    Texture[] buildings;

    public float timeSeconds = 0f;
    public float period = 120f;
    public int dayCount;

    public Simulation(GameMain game){
        this.game = game;
        dayCount = 1;
        font = new BitmapFont(Gdx.files.internal("InfoFont.fnt"));
        viewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport);
        createMusics();
        createButtons();
        addAllListeners();
        stage.addActor(settings);
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH/GameInfo.PPM, GameInfo.HEIGHT/GameInfo.PPM);
        box2DCamera.position.set((GameInfo.WIDTH/2f)/GameInfo.PPM , (GameInfo.HEIGHT/2f)/GameInfo.PPM,0);

        debugRenderer = new Box2DDebugRenderer(); 

        world = new World(new Vector2(0,0), true);

        world.setContactListener(this);

        bg = new Texture("MapBackground.png");
        gui = new Texture("SimulationGui.png");

        abstractMap = new GridMap();

        population = new Population(world,abstractMap,504,this);
        //sound = Gdx.audio.newSound(Gdx.files.internal("Age Of War song.mp3"));
        population.getPopulation()[0].makePatientZero();
        population.infectedCount++;
        box2DCamera.update();
        //sound.play();
        //sound.loop();
        createBuildings();


        hospital = new Texture("firsthospital.png");
        house = new Texture("firstHouse.png");




    }

    private void addAllListeners() {
        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameMain.popSound.play();   
                GameMain.beforeScreen = 3;            
                GameMain.stage = (Stage) GameMain.settingsScreen.getStage();
                Gdx.input.setInputProcessor(GameMain.stage);
                game.setScreen(GameMain.settingsScreen);
            }
        });
    }

    private void createButtons() {
        settings = new ImageButton(new SpriteDrawable(new Sprite(new Texture("SettingsButton.png"))));
        settings.setPosition(GameInfo.WIDTH/2f+200, GameInfo.HEIGHT/2f+460);
    }

    public void createBuildings(){
        buildings = new Texture[31];
        buildings[0] = new Texture("0.png");
        buildings[1] = new Texture("vHouse1.png");
        buildings[2] = new Texture("vHouse2.png");
        buildings[3] = new Texture("vHouse3.png");
        buildings[4] = new Texture("vHouse4.png");
        buildings[5] = new Texture("vHouse5.png");
        buildings[6] = new Texture("6.png");
        buildings[7] = new Texture("7.png");
        buildings[8] = new Texture("vHouse6.png");
        buildings[9] = new Texture("vHouse7.png");
        buildings[10] = new Texture("vHouse8.png");
        buildings[11] = new Texture("vHouse9.png");
        buildings[12] = new Texture("vHouse10.png");
        buildings[13] = new Texture("13.png");
        buildings[14] = new Texture("14.png");
        buildings[15] = new Texture("15.png");
        buildings[16] = new Texture("16.png");
        buildings[17] = new Texture("17.png");
        buildings[18] = new Texture("18.png");
        buildings[19] = new Texture("31.png");
        buildings[20] = new Texture("20.png");
        buildings[21] = new Texture("21.png");
        buildings[22] = new Texture("22.png");
        buildings[23] = new Texture("23.png");
        buildings[24] = new Texture("24.png");
        buildings[25] = new Texture("25.png");
        buildings[26] = new Texture("26.png");
        buildings[27] = new Texture("27.png");
        buildings[28] = new Texture("28.png");
        buildings[29] = new Texture("29.png");
        buildings[30] = new Texture("30.png");
    }

    public void renderBuildings(){

        game.getBatch().draw(buildings[0], 45  +45, GameInfo.HEIGHT - 45 - buildings[0].getHeight()-90);
        game.getBatch().draw(buildings[1], 355 +45, GameInfo.HEIGHT - 45 - buildings[1].getHeight()-90);
        game.getBatch().draw(buildings[2], 520 +45, GameInfo.HEIGHT - 45- buildings[2].getHeight()-90);
        game.getBatch().draw(buildings[3], 685 +45, GameInfo.HEIGHT - 45- buildings[3].getHeight()-90);
        game.getBatch().draw(buildings[4], 850 +45, GameInfo.HEIGHT - 45- buildings[4].getHeight()-90);
        game.getBatch().draw(buildings[5], 1015+45, GameInfo.HEIGHT - 45- buildings[5].getHeight()-90);
        game.getBatch().draw(buildings[6], 1180+45, GameInfo.HEIGHT - 45 - buildings[6].getHeight()-90);
        game.getBatch().draw(buildings[7], 1540+45, GameInfo.HEIGHT - 45 - buildings[7].getHeight()-90);
        game.getBatch().draw(buildings[8], 355 +45, GameInfo.HEIGHT -160- buildings[8].getHeight()-90);
        game.getBatch().draw(buildings[9], 520 +45, GameInfo.HEIGHT -160- buildings[9].getHeight()-90);
        game.getBatch().draw(buildings[10], 685+45, GameInfo.HEIGHT -160- buildings[10].getHeight()-90);
        game.getBatch().draw(buildings[11], 850+45, GameInfo.HEIGHT -160- buildings[11].getHeight()-90);
        game.getBatch().draw(buildings[12],1015+45, GameInfo.HEIGHT -160- buildings[12].getHeight()-90);
        game.getBatch().draw(buildings[13],45  +45, GameInfo.HEIGHT - 380 - buildings[13].getHeight()-90);
        game.getBatch().draw(buildings[14], 355+45, GameInfo.HEIGHT - 320 - buildings[14].getHeight()-90);
        game.getBatch().draw(buildings[15],470 +45, GameInfo.HEIGHT - 320 - buildings[15].getHeight()-90);
        game.getBatch().draw(buildings[16], 830+45, GameInfo.HEIGHT - 320 - buildings[16].getHeight()-90);
        game.getBatch().draw(buildings[17],1095+45, GameInfo.HEIGHT - 320 - buildings[17].getHeight()-90);
        game.getBatch().draw(buildings[18],1290+45, GameInfo.HEIGHT - 320 - buildings[18].getHeight()-90);
        game.getBatch().draw(buildings[19],1290+45, GameInfo.HEIGHT - 425 - buildings[19].getHeight()-90);
        game.getBatch().draw(buildings[20],1540+45, GameInfo.HEIGHT - 320 - buildings[20].getHeight()-90);
        game.getBatch().draw(buildings[21],45  +45, GameInfo.HEIGHT - 545 - buildings[21].getHeight()-90);
        game.getBatch().draw(buildings[22], 45 +45, GameInfo.HEIGHT - 635 - buildings[22].getHeight()-90);
        game.getBatch().draw(buildings[23],355 +45, GameInfo.HEIGHT - 545 - buildings[23].getHeight()-90);
        game.getBatch().draw(buildings[24], 470+45, GameInfo.HEIGHT - 545 - buildings[24].getHeight()-90);
        game.getBatch().draw(buildings[25],830 +45, GameInfo.HEIGHT - 590 - buildings[25].getHeight()-90);
        game.getBatch().draw(buildings[26],1045+45, GameInfo.HEIGHT - 590 - buildings[26].getHeight()-90);
        game.getBatch().draw(buildings[27],1290+45, GameInfo.HEIGHT - 590 - buildings[27].getHeight()-90);
        game.getBatch().draw(buildings[28],  45+45, GameInfo.HEIGHT - 750 - buildings[28].getHeight()-90);
        game.getBatch().draw(buildings[29], 355+45, GameInfo.HEIGHT - 750 - buildings[29].getHeight()-90);
        game.getBatch().draw(buildings[30],1045+45, GameInfo.HEIGHT - 740 - buildings[30].getHeight()-90);
    }

    public void newDay(){
        population.startDay();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        
        //manually looping the music list
        if(!musics[currentMusic].isPlaying()) {
            if(currentMusic == 4)
                currentMusic = -1;
            musics[++currentMusic].play();
        }
        timeSeconds +=Gdx.graphics.getDeltaTime();
        System.out.println(timeSeconds);
        if(timeSeconds > period){
            timeSeconds-=period;
            timeSeconds = 0f;
            dayCount++;
            newDay();
        }

        population.updatePopulation();
        population.executeTask();

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Drawing the background
        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        renderBuildings();

        //Drawing the population one by one
        Person currentPerson;
        for(int i = 0; i < population.getNumberOfPeople(); i++){
            currentPerson = population.getPopulation()[i];

            game.getBatch().draw(currentPerson,(currentPerson.getX() - currentPerson.getWidth()/2), (currentPerson.getY() - currentPerson.getHeight()/2));
        }



        game.getBatch().draw(gui, 0, 0);


        
        font.draw(game.getBatch(), "Infected: " + population.infectedCount, 90, GameInfo.HEIGHT-35);
        font.draw(game.getBatch(), "Immune: " + population.immuneCount, 460, GameInfo.HEIGHT-35);
        font.draw(game.getBatch(), "Dead: " + population.deadCount, 830, GameInfo.HEIGHT-35);
        if((int) timeSeconds%(period/24) != 0) {
            if((int) ((int)timeSeconds/(period/24)) < 10)
                font.draw(game.getBatch(),"Day: " + dayCount + " / 0" + (int) ((int)timeSeconds/(period/24)) + ":" + (int) ((60/(period/24)) * (int) (timeSeconds%(period/24))), GameInfo.WIDTH-400, GameInfo.HEIGHT-35);
            else
                font.draw(game.getBatch(),"Day: " + dayCount + " / " + (int) ((int)timeSeconds/(period/24)) + ":", GameInfo.WIDTH-400, GameInfo.HEIGHT-35);
        }
        else {
            if((int) ((int)timeSeconds/(period/24)) < 10)
                font.draw(game.getBatch(),"Day: " + dayCount + " / 0" + (int) ((int)timeSeconds/(period/24)) + ":0" + (int) ((60/(period/24)) * (int) (timeSeconds%(period/24))), GameInfo.WIDTH-400, GameInfo.HEIGHT-35);
            else
                font.draw(game.getBatch(),"Day: " + dayCount + " / " + (int) ((int)timeSeconds/(period/24)) + ":0", GameInfo.WIDTH-400, GameInfo.HEIGHT-35);
        }

        game.getBatch().end();
        debugRenderer.render(world, box2DCamera.combined);


        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        box2DCamera.update();

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

    }

    @Override
    public void dispose() {

    }

    @Override
    public void beginContact(Contact contact) {
        Fixture firstBody = contact.getFixtureA();
        Fixture secondBody = contact.getFixtureB();
        
        String healthCondition1 = ((String) firstBody.getUserData()).substring(0,4);
        
        String healthCondition2 = ((String) secondBody.getUserData()).substring(0,4);

        
        
        if(healthCondition2.equals("Sick") && healthCondition1.equals("Heal") ){
            int healsIndex = Integer.parseInt(((String)firstBody.getUserData()).substring(4)); 
            population.infectedCount++;
            firstBody.setUserData("Sick" + healsIndex);
            population.getPopulation()[healsIndex].updateHealthCondition();
        }
        else if(healthCondition1.equals("Sick") && healthCondition2.equals("Heal") ){
            int healsIndex = Integer.parseInt(((String)secondBody.getUserData()).substring(4)); 
            population.infectedCount++;
            secondBody.setUserData("Sick" + healsIndex);
            population.getPopulation()[healsIndex].updateHealthCondition();
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    public World getWorld(){
        return world;
    }
    public void startMusic() {
        musics[currentMusic].play();
    }

    private void createMusics() {
        currentMusic = 0;
        musics = new Music[5];
        musics[0] = Gdx.audio.newMusic(Gdx.files.internal("music1.mp3"));
        musics[1] = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
        musics[2] = Gdx.audio.newMusic(Gdx.files.internal("music3.mp3"));
        musics[3] = Gdx.audio.newMusic(Gdx.files.internal("music4.mp3"));
        musics[4] = Gdx.audio.newMusic(Gdx.files.internal("music5.mp3"));

        for(int i = 0; i < musics.length; i++) 
            musics[i].setVolume(0.5f);
    }

    public Stage getStage() {
        return stage;
    }
}
