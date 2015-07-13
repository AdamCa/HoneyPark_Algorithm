import java.util.*;

/**
 * Created by Adam Cantor on 7/1/2015.
 * This file is intended to generate a single agent and to add it to the swarm where they will move randomly given
 * the random initialized HoneyAgent variables and simulation parameters. These can be added to ad infinitum in this file
 *
 * The simplest individual HoneyAgent vehicle has 2 initial variables: Destination, and Time Intent
 * A single HoneyAgent also records the following situational data (stored by server): Time to Park, and Time Spent in Spot
 */
public class Bee {
        public static double bees = 5;

        public static class Bees {
            int beeID;
            double startTime;
            float beeOrigin;
            float beeLocation;
            float beeDestination;
            double parkTime;
            double exitTime;
        }

    public static void main(String[] args) {
        //create an ArrayList object to hold the Vehicles and the Parking Lots
        ArrayList<Bees> beeList = new ArrayList<Bees>();



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
    }
}
