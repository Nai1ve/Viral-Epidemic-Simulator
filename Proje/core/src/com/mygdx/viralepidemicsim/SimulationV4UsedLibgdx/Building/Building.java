package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Building;
import java.awt.Point;
import java.util.ArrayList;

import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
public class Building {
    
    Point location;
    int numberOfPerson;
    String name;
    //double size;
    ArrayList<Person> persons; 

    public Building(String name, Point location){
        this.name = name;
        this.location = location;
    }







}
