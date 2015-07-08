/*
  Add an element to specified index of Java ArrayList Example
  This Java Example shows how to add an element at specified index of java
  ArrayList object using add method.
*/

import java.util.*;

/**
 * Created by Adam Cantor on 7/6/2015.
 * This file is intended to generate/populate a list of agents and parking lots. These lists will be populated
 * according to a given destination in later implemantion. For now we are assuming that there is one destination with
 * five parking lots.
 *
 */
public class Environment {

    public static double bees = 5;
    public static double lots = 5;

    public static class Bees {
        int beeID;
        double startTime;
        float beeOrigin;
        float beeLocation;
        float beeDestination;
        double parkTime;
        double exitTime;
    }
    public static class Lots {
        int lotID;
        int lotSpots;
        float lotLocation;
    }

    public static void main(String[] args) {
        //create an ArrayList object to hold the Vehicles and the Parking Lots
        ArrayList<Bees> beeList = new ArrayList<Bees>();
        ArrayList<Lots> lotList = new ArrayList<Lots>();



        for(int index=0; index < bees; index++) {
            // Generate a random number for simulation
            Random randGen = new Random();
            int randInt = randGen.nextInt(100);
            /*
            Add elements to place holder array

            NOTE: For this simulation we assume that all agents start at the same
            point and go to the same destination
            */

            Bees o = new Bees();
            o.beeID = index;
            o.startTime = 100*index;
            o.beeOrigin = 0;
            o.beeLocation = 0;
            o.beeDestination = 100;
            o.parkTime = o.startTime + randInt;
            o.exitTime = o.parkTime + randInt;

            //Add place holder array to overall beeList
            beeList.add(index, o);
        }

        for(int index=0; index < lots; index++) {
            // Generate a random number for simulation
            Random randGen = new Random();
            int randInt = randGen.nextInt(100);
            /*
            Add elements to place holder array
            */

            Lots p = new Lots();
            p.lotID = index;
            p.lotSpots = 100*index;
            p.lotLocation = 100*index/5;

            //Add place holder array to overall beeList
            lotList.add(index, p);
        }

        System.out.println("beeList contains...");
        //display elements of BeeList
        for(int index=0; index < beeList.size(); index++) {
            System.out.println(beeList.get(index).beeID);
        }
        System.out.println("lotList contains...");
        //display elements of BeeList
        for(int index=0; index < lotList.size(); index++) {
            System.out.println(lotList.get(index).lotID);
        }
    }
}
