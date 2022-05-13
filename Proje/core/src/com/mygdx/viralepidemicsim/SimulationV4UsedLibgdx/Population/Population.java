package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Population;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.viralepidemicsim.FirstVersion.FinalVariables;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap.GridMap;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Person.Person;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Scenes.Simulation;

public class Population {
    
    //instantiative variables
    public int infectedCount, immuneCount, deadCount;
    public int removedCount = immuneCount + deadCount;
    public int susceptibleCount = GameInfo.population - infectedCount - removedCount;

    public Person[] population;
    World world;
    GridMap map;
    public final static Texture EXPO_TEXTURE = new Texture("Expo.png");
    public final static Texture INFE_TEXTURE = new Texture("Infe.png");
    public final static Texture SUSP_TEXTURE = new Texture("Susp.png");
    public final static Texture IMMU_TEXTURE = new Texture("Immu.png");

    ArrayList<Person> youngArr;
    ArrayList<Person> youngAdultArr;
    ArrayList<Person> adultArr;
    ArrayList<Person> oldArr;
    

    /**
     * constructs the population objects
     * @param world world of the population
     * @param map map of the simulation
     * @param numberOfPeople desired number of the people
     * @param menu 
     */
    public Population(World world, GridMap map, int numberOfPeople, Simulation menu){
        population = new Person[numberOfPeople];
        this.world = world; 
        this.map = map;

        

        int houseCapacity = (numberOfPeople / 14);
        
        for(int i = 0; i < population.length ; i++){

            int randomBetween0to100 = GameInfo.randomBetween(0, 100);

        

            int[] houseIndexes = {1,2,3,4,8,9,11,12,18,19,21,23,28,30};

            int selectedHouse = i / houseCapacity;

            if(i / houseCapacity >= houseIndexes.length ){
                selectedHouse = houseIndexes.length-1;
            }


            int xPosition = (int)map.vertices[houseIndexes[selectedHouse]].getX();
            int yPosition = (int)map.vertices[houseIndexes[selectedHouse]].getY();

            


            if(randomBetween0to100 < 33.2) {
                population[i] = new Person(world,map,"Susp.png", xPosition , yPosition , FinalVariables.YOUNG_IMMUNITY,menu,houseIndexes[selectedHouse], "Young");
            }
            else if( randomBetween0to100 < 63.1) {
                population[i] = new Person(world,map,"Susp.png", xPosition, yPosition, FinalVariables.YOUNG_ADULT_IMMUNITY,menu,houseIndexes[selectedHouse], "YoungAdult");
            }
            else if( randomBetween0to100 < 86.2 ) {
                population[i] = new Person(world,map,"Susp.png", xPosition, yPosition, FinalVariables.ADULT_IMMUNITY,menu,houseIndexes[selectedHouse], "Adult");
            }
            else { //Old
                population[i] = new Person(world,map,"Susp.png", xPosition, yPosition, FinalVariables.OLD_IMMUNITY,menu,houseIndexes[selectedHouse], "Old");
            }

        }

        createYoungArrayList();
        createYoungAdultArrayList();
        createAdultArrayList();
        createOldArrayList();
    }

    /**
     * creates young arrL
     */
    public void createYoungArrayList(){
        youngArr = new ArrayList<>();
        for(int i = 0; i < population.length ; i++){
            if(population[i].type.equals("Young")){
                youngArr.add(population[i]);
            }
        }
    }

    /**
     * creates young adult arrL
     */
    public void createYoungAdultArrayList(){
        youngAdultArr = new ArrayList<>();
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("YoungAdult")){
                youngAdultArr.add(population[i]);
            }
        }
    }

    /**
     * creates adult arrayList
     */
    public void createAdultArrayList(){
        adultArr = new ArrayList<>();
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Adult")){
                adultArr.add(population[i]);
            }
        }
    }

    /**
     * creates old arrL
     */
    public void createOldArrayList(){
        oldArr = new ArrayList<>();
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Old")){
                oldArr.add(population[i]);
            }
        }
    }

    /**
     * Updates young arraylist 
     */
    public void updateYoungArrayList(){
        ArrayList<Person> newYoungArr = new ArrayList<>();
        for(int i = 0; i < youngArr.size() ; i++){
            if((youngArr.get(i).healthStatus.equals("Susp")||youngArr.get(i).healthStatus.equals("Expo"))){
                newYoungArr.add(youngArr.get(i));
            }
        }

        youngArr = newYoungArr;
    }

    /**
     * updates young adult arraylist
     */
    public void updateYoungAdultArrayList(){
        ArrayList<Person> newYoungAdultArr = new ArrayList<>();
        for(int i = 0; i < youngAdultArr.size(); i++){
            if((youngAdultArr.get(i).healthStatus.equals("Susp")||youngAdultArr.get(i).healthStatus.equals("Expo"))){
                newYoungAdultArr.add(youngAdultArr.get(i));
            }
        }

        youngAdultArr = newYoungAdultArr;
    }

    public void updateAdultArrayList(){
        ArrayList<Person> newAdultArr = new ArrayList<>();
        for(int i = 0; i < adultArr.size(); i++){
            if((adultArr.get(i).healthStatus.equals("Susp")||adultArr.get(i).healthStatus.equals("Expo"))){
                newAdultArr.add(adultArr.get(i));
            }
        }
        adultArr = newAdultArr;
    }

    /**
     * updates old arrayList
     */
    public void updateOldArrayList(){
        ArrayList<Person> newOldArr = new ArrayList<>();
        for(int i = 0; i < oldArr.size(); i++){
            if((oldArr.get(i).healthStatus.equals("Susp")||oldArr.get(i).healthStatus.equals("Expo"))){
                newOldArr.add(oldArr.get(i));
            }
        }

        oldArr = newOldArr;
    }

    /**
     * starts the day for every person of the population array
     */
    public void startDay(){
        for(int i = 0; i < population.length; i++){
            population[i].startDay();
        }
    }

    /**
     * calls the updatePerson() and executeCurrentTask() methods for every person object stored in the population array
     */
    public void updatePopulation(){
        for(int i = 0; i < population.length ; i++){
            population[i].updatePerson();
            population[i].executeCurrentTask();
        }
    }

    public int getNumberOfPeople(){
        return population.length;
    }

    public Person[] getPopulation(){
        return population;
    }

    public void healthUpdate(){
        for(int i = 0; i < population.length ; i++){
            population[i].updateHealthCondition();
        }
    }

    /**
     * gets every person under 18 in curfew
     */
    public void curfewUnder18(){
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Young")){
                population[i].isInCurfew = true;
            }
        }
    }

    /**
     * removes Curfew under 18
     */
    public void removeCurfewUnder18(){
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Young")){
                population[i].isInCurfew = false;
            }
        }
    }

    /**
     * starts curfew for the people ove 65 years
     */
    public void curfewOver65(){
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Old")){
                population[i].isInCurfew = true;
            }
        }
    }

    /**
     * cancels the remove for the people over the age of 65
     */
    public void removeCurfewOver65(){
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Old")){
                population[i].isInCurfew = false;
            }
        }
    }

    /**
     * gets everyone in the curfew
     */
    public void fullCurfew(){
        for(int i = 0; i < population.length; i++){
            population[i].isInCurfew = true;
        }
    }

    /**
     * removes curfew for every person
     */
    public void removeFullCurfew() {
        for(int i = 0; i < population.length; i++){
            population[i].isInCurfew = false;
        }
    }

    /**
     * @return if every one is in curfew
     */
    public boolean isFullCurfew() {
        for(int i = 0; i < population.length; i++){
            if(population[i].isInCurfew == false)
                return false;
        }
        return true;
    }

    public void curfew19to40() {
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("YoungAdult")){
                population[i].isInCurfew = true;
            }
        }
    }

    public void curfew40to65() {
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Adult")){
                population[i].isInCurfew = true;
            }
        }
    }

    public void removeCurfew40to65() {
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("Adult")){
                population[i].isInCurfew = false;
            }
        }
    }

    public void removeCurfew19to40() {
        for(int i = 0; i < population.length; i++){
            if(population[i].type.equals("YoungAdult")){
                population[i].isInCurfew = false;
            }
        }
    }

    public void randomVaccine(){
        
    }

    /**
     * vaccinates a randomly selected young person
     */
    public void randomYoungVaccine(){
        updateYoungArrayList();

        if(youngArr.size()>0){
            int randomNumber = GameInfo.randomBetween(0, youngArr.size());

            youngArr.get(randomNumber).getImmune();
        }

    }

    /**
     * vaccinates a randomly selected young adult person
     */
    public void randomYoungAdultVaccine(){
        updateYoungAdultArrayList();

        if(youngAdultArr.size()>0){
            int randomNumber = GameInfo.randomBetween(0, youngAdultArr.size());

            youngAdultArr.get(randomNumber).getImmune();
        }

    }

    /**
     * vaccinates a randomly selected adult person
     */
    public void randomAdultVaccine(){
        updateAdultArrayList();

        if(adultArr.size()>0){
            int randomNumber = GameInfo.randomBetween(0, adultArr.size());

            adultArr.get(randomNumber).getImmune();
        }

    }

    // public void createRandom() {
    //     population[]
    // }

    public void killRandom() {
        int ran = GameInfo.randomBetween(0, population.length);
        if (population[ran].body.isActive()) {
        population[ran].die();
        }
    }

    /**
     * vaccinates a randomly selected old person
     */
    public void randomOldVaccine(){
        updateOldArrayList();

        if(oldArr.size()>0){
            int randomNumber = GameInfo.randomBetween(0, oldArr.size());

            oldArr.get(randomNumber).getImmune();
        }
        
    }

    /**
     * vaccinates a randomly selected person
     */
    public void randomVaccination(int number){
        for(int i = 0; i < number; i++){
            int randNum = GameInfo.randomBetween(0, population.length);
            if((population[randNum].healthStatus.equals("Susp"))){
                population[randNum].getImmune();
            }
        }
    }

    /**
     * gets a random person infected
     * @param number
     */
    public void randomInfection(int number){
        for(int i = 0 ; i < number ; i++){
            population[GameInfo.randomBetween(0, population.length)].getInfected();
        }
    }

    public int isActiveCount() {
        int counter = 0;
        for (int i = 0; i<population.length; i++) {
            if (population[i].body.isActive()) {
                counter++;
            }
        }
        return counter;
    }

   
}
