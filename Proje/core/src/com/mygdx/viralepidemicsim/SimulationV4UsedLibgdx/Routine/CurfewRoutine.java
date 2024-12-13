package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Routine;

import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap.GridMap;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Simulation;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.Task;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Task.WaitTill;

public class CurfewRoutine implements Routine{

    public Task[] taskList;

    /**
     * constructor for curfew routine. Assigns 2 different tasks. waittills for 2 times
     * @param person Person whose routine will be determined
     * @param sim simulation object
     * @param gm GridMap object
     */
    public CurfewRoutine(Person person, Simulation menu, GridMap map) {

        taskList = new Task[2];

        taskList[0] = new WaitTill(person,10, menu);
        // 执行宵禁后，只在所处范围内活动
        taskList[1] = new WaitTill(person, 10, menu);


    }
    
}
