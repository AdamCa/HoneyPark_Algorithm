import java.util.*;

/**
 * Created by Adam Cantor on 7/13/2015.
 *
 * This file creates the variable structure to define Car/Bee Agent parameters
 */
public class Bees {

    public int beeID;
    public double startTime;
    public float beeOrigin;
    public float beeLocation;
    public float beeDestination;
    public double parkTime;
    public double exitTime;

    public Bees(int ID) {
        /*
        NOTE: For this simulation we make the following assumptions:
        1) All agents start at the same point (beeOrigin = 0)
        2) All agents go to the same destination (beeDestination = 100)
        3) Time to reach dest from origin is a gaussian distribution with average of 100 and lower bound of 80.
        4) All parking events occur between 12 am and 12 pm (0 - 1440 minutes)
        */

        // Generate a random gaussian number for general simulation randomization
        Random randGen = new Random(ID);

        double gausNum = randGen.nextGaussian();
        double intNum = randGen.nextInt();
        double doubNum = randGen.nextDouble();

        int randStart = randGen.nextInt(1440);

        // Generate a random number for travel time and park time on a gaussian distribution with a minimum
        double tripGaus;
        double stayGaus;
        do {
            double rawTripGaus = randGen.nextGaussian();
            double rawStayGaus = randGen.nextGaussian();
            tripGaus = (int) Math.round(rawTripGaus);
            stayGaus = (int) Math.round(rawStayGaus);
        } while ((tripGaus < .8) && (tripGaus > 2) && (stayGaus < .5) && (stayGaus > 3));

        this.beeID = ID;
        this.startTime = randStart;
        this.beeOrigin = 0;
        this.beeLocation = 0;
        this.beeDestination = 100;
        this.parkTime = this.startTime + (this.beeDestination-this.beeLocation);
        this.exitTime = this.parkTime + 20 * stayGaus;
    }
}