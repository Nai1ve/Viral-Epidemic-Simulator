package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Building;
import java.awt.Point;
import java.util.ArrayList;

import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
public class Building {
    
    Point location;
    int numberOfPerson;
    String name;
    //double size;
    ArrayList<Person> persons = new ArrayList<Person>(); 

    public Building(String name, Point location){
        this.name = name;
        this.location = location;
    }

    public void addPerson(Person person) {
        persons.add(person);
        System.out.println("building " + name + " has " + persons.size() + " people and 1 person entered");
    }

    public void removePerson(Person person) {
        persons.remove(person);
        System.out.println("building " + name + " has " + persons.size() + " people and 1 person exited");
    }







}
