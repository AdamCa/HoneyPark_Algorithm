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
    public static void main(String[] args) {

        //Create a variable to hold the time
        int time = 0;

        //Create an ArrayList object to hold the Vehicles and the Parking Lots
        ArrayList<Bees> beeList = new ArrayList<Bees>();
        ArrayList<Lots> lotList = new ArrayList<Lots>();

        //Choose the size of simulation environment
        double bees = 5;
        double lots = 3;

        for(int index=0; index < bees; index++) {
            //Generate individual bee agents and add them to place holder array
            Bees holdBee = new Bees(index);
            //Add place holder array to overall beeList
            beeList.add(index, holdBee);
        }
        for(int index=0; index < lots; index++) {
            //Generate individual lots and add them to place holder array
            Lots p = new Lots(index);
            //Add place holder array to overall lotList
            lotList.add(index, p);
        }

        // Display the current state of the environment
        System.out.println("lotList contains...");
        //display elements of lotList
        for(int index=0; index < lotList.size(); index++) {
            System.out.print("Lot# " + lotList.get(index).lotID);
            System.out.print(", Total Spots " + lotList.get(index).lotSpots);
            System.out.print(", Empty Spots " + lotList.get(index).lotEmpty);
            System.out.println(", Location " + lotList.get(index).lotLocation);
        }

        System.out.println("beeList contains...");
        //display elements of BeeList
        for(int index=0; index < beeList.size(); index++) {
            System.out.print("Agent# " + beeList.get(index).beeID);
            System.out.print(", Start " + beeList.get(index).startTime);
            System.out.print(", Origin " + beeList.get(index).beeOrigin);
            System.out.print(", Current " + beeList.get(index).beeLocation);
            System.out.print(", Destination " + beeList.get(index).beeDestination);
            System.out.print(", Parked " + beeList.get(index).parkTime);
            System.out.println(", Exit " + beeList.get(index).exitTime);
        }

        /** Move the simulation forward in time by 1 time step until an action is triggered:
         * Agent reaches the destination
         * Agent reaches a spot
         * Agent leaves a spot
         *
         * At each time step allow the number of empty spots in each lot to change randomly
        */

        // Increment the overall time variable
        time++;
        for (int index=0; index < beeList.size(); index++) {
            // Generate a random number to decide how far each vehicle moves
            Random randGen = new Random(index);


        }
    }
}
