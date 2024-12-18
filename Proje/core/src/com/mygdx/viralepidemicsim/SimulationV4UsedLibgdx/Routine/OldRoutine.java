package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Routine;
import java.util.Random;

import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap.GridMap;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Simulation;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.Moving;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.Task;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.WaitTill;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.Waiting;


public class OldRoutine implements Routine {
            

    public Task[] taskList;
    public int buildingList[] = new int[]{10,17,20,22,24,26,29};

    /**
     * constructor for adult routine. Assigns 7 different tasks. assigns tasks from the buildingList specified for the oldRoutine class
     * @param person Person whose routine will be determined
     * @param sim simulation object
     * @param gm GridMap object
     */
    public OldRoutine(Person person, Simulation sim,GridMap gm){

        taskList = new Task[7];

        int temp1;
        int temp2;

        Random rand = new Random();

        taskList[0] = new WaitTill(person,2,sim);

        temp1 = buildingList[rand.nextInt(buildingList.length)];

        taskList[1] = new Moving(person,gm , person.currentLoc , temp1);

        taskList[2] = new Waiting(person, 8, sim);

        temp2 = buildingList[rand.nextInt(buildingList.length)];
        taskList[3] = new Moving(person, gm, temp1, temp2);

        taskList[4] = new Waiting(person, 3, sim);

        taskList[5] = new Moving(person, gm, temp2, person.homeLocation);

        taskList[6] = new WaitTill(person, 5,sim);
    }
}
