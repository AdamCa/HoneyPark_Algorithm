import java.util.*;

/**
 * Created by Adam Cantor on 7/1/2015.
 * This file is intended to generate a single agent with random initialized HoneyAgent variables and
 * simulation parameters. These can be added ad infinitum to the simulation.
 *
 * The simplest individual HoneyAgent vehicle has 2 initial variables: Destination, and Time Intent
 * A single HoneyAgent also records the following situational data (stored by server): Time to Park, and Time Spent in Spot
 */
public class Bee {
    public static void main(String[] args) {

        /*
        NOTE: For this simulation we make the following assumptions:
        1) All agents start at the same point (beeOrigin = 0)
        2) All agents go to the same destination (beeDestination = 100)
        3) Time to reach dest from origin is a gaussian distribution with average of 100 and lower bound of 80.
        4) All parking events occur between 12 am and 12 pm (0 - 1440 minutes)
        */

        // Generate a random number for general simulation randomization
        Random randGen = new Random();
        int randGaus;
        double gausNum = randGen.nextGaussian();
        randGaus = (int) Math.abs(gausNum);

        // Generate a random number for travel time on a gaussian distribution with a minimum
        int tripGaus;
        do {
            double rawTripGaus = randGen.nextGaussian() * 100 + 100;
            tripGaus = (int) Math.round(rawTripGaus);
        } while (tripGaus <= 50);


        Bees CBee = new Bees();
        CBee.startTime = Math.round(1440*randGaus);
        CBee.beeOrigin = 0;
        CBee.beeLocation = 0;
        CBee.beeDestination = 100;
        CBee.parkTime = CBee.startTime + (CBee.beeLocation-CBee.beeDestination)*tripGaus;
        CBee.exitTime = CBee.parkTime + 60*tripGaus/100;
    }
}

