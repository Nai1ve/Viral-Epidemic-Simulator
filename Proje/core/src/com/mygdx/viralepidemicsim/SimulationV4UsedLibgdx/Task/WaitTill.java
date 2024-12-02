package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task;

import com.badlogic.gdx.Gdx;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Simulation;

public class WaitTill implements Task{

    //instantiative variables
    int targetTime;
    Person person;
    Simulation sim;

    /**
     * Person that will wait till
     * @param person Person object that will use this method
     * @param time Time to wait till
     * @param simulation Simulation object
     */
    public WaitTill(Person person, int time,Simulation simulation){
        targetTime = time;

        sim = simulation;

        this.person = person;
        

    }

    @Override
    public void executeTaskOnBody() {
        //Gdx.app.log("【WaitTill】",String.format("Person ID:%d,is In WaitingTill sim.timeSeconds:%f,targetTime%d", person.id,sim.timeSeconds,targetTime));
        person.getBody().setAwake(false);

    }

    @Override
    public boolean isTaskEnd() {
        return sim.timeSeconds > targetTime;

    }

    public String toString(){
        return "WT";
    }
    
}
