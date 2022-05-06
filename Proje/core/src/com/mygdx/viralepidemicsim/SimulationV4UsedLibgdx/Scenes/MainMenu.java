package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.viralepidemicsim.FirstVersion.FinalVariables;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap.GridMap;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.MyLibgdxTester.GameMain;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Population.Population;



public class MainMenu implements Screen, ContactListener{

    private GameMain game;

    private Texture bg;

    private Population population;
    
    private World world;

    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;
    private Sound sound;

    float clock = 0;

    GridMap abstractMap;

    Texture hospital;
    Texture house;

    Texture[] buildings;

    public MainMenu(GameMain game){
        this.game = game;

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH/GameInfo.PPM, GameInfo.HEIGHT/GameInfo.PPM);
        box2DCamera.position.set((GameInfo.WIDTH/2f)/GameInfo.PPM , (GameInfo.HEIGHT/2f)/GameInfo.PPM,0);

        debugRenderer = new Box2DDebugRenderer(); 

        world = new World(new Vector2(0,0), true);

        world.setContactListener(this);

        bg = new Texture("BlackBg.png");


        population = new Population(world,abstractMap,1000);
        //sound = Gdx.audio.newSound(Gdx.files.internal("Age Of War song.mp3"));
        population.getPopulation()[0].makePatientZero();
        box2DCamera.update();
        //sound.play();
        //sound.loop();
        createBuildings();


        hospital = new Texture("firsthospital.png");
        house = new Texture("firstHouse.png");




    }

    public void createBuildings(){
        buildings = new Texture[31];
        buildings[0] = new Texture("0.png");
        buildings[1] = new Texture("vHouse0.png");
        buildings[2] = new Texture("vHouse0.png");
        buildings[3] = new Texture("vHouse2.png");
        buildings[4] = new Texture("vHouse0.png");
        buildings[5] = new Texture("vHouse0.png");
        buildings[6] = new Texture("6.png");
        buildings[7] = new Texture("7.png");
        buildings[8] = new Texture("vHouse0.png");
        buildings[9] = new Texture("vHouse0.png");
        buildings[10] = new Texture("vHouse0.png");
        buildings[11] = new Texture("vHouse0.png");
        buildings[12] = new Texture("vHouse0.png");
        buildings[13] = new Texture("13.png");
        buildings[14] = new Texture("14.png");
        buildings[15] = new Texture("15.png");
        buildings[16] = new Texture("16.png");
        buildings[17] = new Texture("17.png");
        buildings[18] = new Texture("18.png");
        buildings[19] = new Texture("18.png");
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

        game.getBatch().draw(buildings[0], 45, GameInfo.HEIGHT - 45 - buildings[0].getHeight());
        game.getBatch().draw(buildings[1], 355, GameInfo.HEIGHT - 45 - buildings[1].getHeight());
        game.getBatch().draw(buildings[2], 520, GameInfo.HEIGHT - 45- buildings[2].getHeight());
        game.getBatch().draw(buildings[3], 685, GameInfo.HEIGHT - 45- buildings[3].getHeight());
        game.getBatch().draw(buildings[4], 850, GameInfo.HEIGHT - 45- buildings[4].getHeight());
        game.getBatch().draw(buildings[5], 1015, GameInfo.HEIGHT - 45- buildings[5].getHeight());
        game.getBatch().draw(buildings[6], 1180, GameInfo.HEIGHT - 45 - buildings[6].getHeight());
        game.getBatch().draw(buildings[7], 1540, GameInfo.HEIGHT - 45 - buildings[7].getHeight());
        game.getBatch().draw(buildings[8], 355, GameInfo.HEIGHT -160- buildings[8].getHeight());
        game.getBatch().draw(buildings[9], 520, GameInfo.HEIGHT -160- buildings[9].getHeight());
        game.getBatch().draw(buildings[10], 685, GameInfo.HEIGHT -160- buildings[10].getHeight());
        game.getBatch().draw(buildings[11], 850, GameInfo.HEIGHT -160- buildings[11].getHeight());
        game.getBatch().draw(buildings[12], 1015, GameInfo.HEIGHT -160- buildings[12].getHeight());
        game.getBatch().draw(buildings[13],45 , GameInfo.HEIGHT - 380 - buildings[13].getHeight());
        game.getBatch().draw(buildings[14], 355, GameInfo.HEIGHT - 320 - buildings[14].getHeight());
        game.getBatch().draw(buildings[15],470 , GameInfo.HEIGHT - 320 - buildings[15].getHeight());
        game.getBatch().draw(buildings[16], 830, GameInfo.HEIGHT - 320 - buildings[16].getHeight());
        game.getBatch().draw(buildings[17], 1095, GameInfo.HEIGHT - 320 - buildings[17].getHeight());
        game.getBatch().draw(buildings[18],1290, GameInfo.HEIGHT - 320 - buildings[18].getHeight());
        game.getBatch().draw(buildings[19], 1290, GameInfo.HEIGHT - 425 - buildings[19].getHeight());
        game.getBatch().draw(buildings[20], 1540, GameInfo.HEIGHT - 320 - buildings[20].getHeight());
        game.getBatch().draw(buildings[21],45 , GameInfo.HEIGHT - 545 - buildings[21].getHeight());
        game.getBatch().draw(buildings[22], 45, GameInfo.HEIGHT - 635 - buildings[22].getHeight());
        game.getBatch().draw(buildings[23],355 , GameInfo.HEIGHT - 545 - buildings[23].getHeight());
        game.getBatch().draw(buildings[24], 470, GameInfo.HEIGHT - 545 - buildings[24].getHeight());
        game.getBatch().draw(buildings[25],830 , GameInfo.HEIGHT - 590 - buildings[25].getHeight());
        game.getBatch().draw(buildings[26], 1045, GameInfo.HEIGHT - 590 - buildings[26].getHeight());
        game.getBatch().draw(buildings[27], 1290, GameInfo.HEIGHT - 590 - buildings[27].getHeight());
        game.getBatch().draw(buildings[28], 45, GameInfo.HEIGHT - 750 - buildings[28].getHeight());
        game.getBatch().draw(buildings[29], 355, GameInfo.HEIGHT - 750 - buildings[29].getHeight());
        game.getBatch().draw(buildings[30], 1045, GameInfo.HEIGHT - 740 - buildings[30].getHeight());
        
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(float delta) {
        
        

        population.updatePopulation();

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        renderBuildings();
        Person currentPerson;
        for(int i = 0; i < population.getNumberOfPeople(); i++){
            currentPerson = population.getPopulation()[i];

            game.getBatch().draw(currentPerson,(currentPerson.getX() - currentPerson.getWidth()/2), (currentPerson.getY() - currentPerson.getHeight()/2));
        }

        


        

        game.getBatch().end();
        
        debugRenderer.render(world, box2DCamera.combined);

        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        box2DCamera.update();

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        sound.stop();
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture firstBody = contact.getFixtureA();
        Fixture secondBody = contact.getFixtureB();
        
        String healthCondition1 = ((String) firstBody.getUserData()).substring(0,4);
        
        String healthCondition2 = ((String) secondBody.getUserData()).substring(0,4);

        
        
        if(healthCondition2.equals("Sick") && healthCondition1.equals("Heal") ){
            int healsIndex = Integer.parseInt(((String)firstBody.getUserData()).substring(4)); 
            firstBody.setUserData("Sick" + healsIndex);
            population.getPopulation()[healsIndex].updateHealthCondition();
        }
        else if(healthCondition1.equals("Sick") && healthCondition2.equals("Heal") ){
            int healsIndex = Integer.parseInt(((String)secondBody.getUserData()).substring(4)); 
            secondBody.setUserData("Sick" + healsIndex);
            population.getPopulation()[healsIndex].updateHealthCondition();
        }

    }

    @Override
    public void endContact(Contact contact) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // TODO Auto-generated method stub
        
    }

    public World getWorld(){
        return world;
    }

    
}
