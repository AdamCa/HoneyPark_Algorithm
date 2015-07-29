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
        int bees = 5;
        int lots = 3;

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
            System.out.print(", Location " + lotList.get(index).lotLocation);
            System.out.println(", Quality " + lotList.get(index).lotQuality);
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

        // display simulation start time
        System.out.println("Time " + time);

        /** Move the simulation forward in time by 1 time step until an action is triggered:
         * Agent reaches the destination
         * Agent Chooses a Parking Lot
         * Agent reaches a spot
         * Agent leaves a spot
         *
         * At each time step allow the number of empty spots in each lot to change randomly
         */

        do {
            // Increment the overall time variable until all agents have parked and exited
            time++;

            // Randomly change number of free spots to account for free agents. Use +/-10% of total spots
            for (int index = 0; index < lotList.size(); index++) {
                // Generate a random number to change available lot spots
                Random randGen = new Random(index);
                int intNum;
                intNum = randGen.nextInt(Math.round((float) lotList.get(index).lotSpots / 5)) - Math.round((float) lotList.get(index).lotSpots / 10);
                lotList.get(index).lotEmpty = +intNum;
            }

            // Move all agents forward by one time step if the agent has started and not parked
            for (int index = 0; index < beeList.size(); index++) {
                // Check to make sure that the agent is active in this time window
                if ((beeList.get(index).startTime >= time) && (beeList.get(index).parkTime == 0)) {
                    // Generate a random number to decide how far each vehicle moves per time step
                    Random randGen = new Random(index);
                    double gausNum;
                    int randLot;
                    do {
                        gausNum = randGen.nextGaussian() + 1;
                    } while ((gausNum < 0) && (gausNum > 1.8));

                    // Move agent towards destination
                    beeList.get(index).beeLocation = +gausNum;

                    // If an agent reaches their destination,
                    if (beeList.get(index).beeLocation >= beeList.get(index).beeDestination) {
                        // Check park indicator value of -1
                        if (beeList.get(index).parkTime == -1) {
                            // Record the time that the agent parked
                            beeList.get(index).parkTime = time;
                        } else {
                            // Choose next lot Randomly (Random Search)
                            randLot = randGen.nextInt(lots);
                            beeList.get(index).beeDestination = lotList.get(randLot).lotLocation;

                            // Choose closest lot to Destination (Greedy Search)


                            // Choose lot with highest quality given current location (HoneyPark)


                            // Set indicator value for parkTime to show that the agent is hunting
                            beeList.get(index).parkTime = -1;
                        }
                    }
                }
            }
        } while (time < 1440);

        // Display the final state of the environment
        System.out.println("lotList contains...");
        //display elements of lotList
        for(int index=0; index < lotList.size(); index++) {
            System.out.print("Lot# " + lotList.get(index).lotID);
            System.out.print(", Total Spots " + lotList.get(index).lotSpots);
            System.out.print(", Empty Spots " + lotList.get(index).lotEmpty);
            System.out.print(", Location " + lotList.get(index).lotLocation);
            System.out.println(", Quality " + lotList.get(index).lotQuality);
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

        // display simulation end time
        System.out.println("Time " + time);
    }
}
