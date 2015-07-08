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
 * four parking lots.
 *
 *
 *
 */
public class Environment {

    public static double bees = 5;
    public static double lots = 5;

    public static void main(String[] args) {
        //create an ArrayList object to hold the Vehicles and the Parking Lots
        ArrayList beeList = new ArrayList();
        ArrayList lotList = new ArrayList();

        for(int index=0; index < bees; index++) {
            //Add elements to beeList
            Bottles o = new Bottles();
            o.setbottleID(bottleIntMap.get("bottleID"+i));
            o.setname_abbr(bottleNamesMap.get("name"+i));
            o.setorigin(bottleNamesMap.get("origin"+i));
            o.setbottlePicture(bottleNamesMap.get("bottlePicture"+i));
            o.setprice_reported(bottleNamesMap.get("price"+i));
            o.setdistillery(bottleNamesMap.get("distillery"+i));
            o.setagg_score(bottleIntMap.get("aggscore"+i));
            beeList.add(index, o);
        }
    /*
      To add an element at the specified index of ArrayList use
      void add(int index, Object obj) method.
      This method inserts the specified element at the specified index in the
      ArrayList.

      Please note that add method DOES NOT overwrites the element previously
      at the specified index in the list. It shifts the elements to right side
      and increasing the list size by 1.
    */
        for(int index=0; index < lots; index++) {
            //Add elements to lotList
            lotList.add(index, new ArrayList());
        }

        System.out.println("beeList contains...");
        //display elements of BeeList
        for(int index=0; index < beeList.size(); index++) {
            System.out.println(beeList.get(index));
        }
        System.out.println("lotList contains...");
        //display elements of BeeList
        for(int index=0; index < lotList.size(); index++) {
            System.out.println(lotList.get(index));
        }
    }
}

/*
Output would be
ArrayList contains...
1
INSERTED ELEMENT
2
3
*/