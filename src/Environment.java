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

    public static void main(String[] args) {
        //create an ArrayList object to hold the Vehicles and the Parking Lots
        ArrayList beeList = new ArrayList();

        //Add elements to Arraylist
        beeList.add("1");
        beeList.add("2");
        beeList.add("3");

    /*
      To add an element at the specified index of ArrayList use
      void add(int index, Object obj) method.
      This method inserts the specified element at the specified index in the
      ArrayList.
    */
        beeList.add(1,"INSERTED ELEMENT");

    /*
      Please note that add method DOES NOT overwrites the element previously
      at the specified index in the list. It shifts the elements to right side
      and increasing the list size by 1.
    */

        System.out.println("BeeList contains...");
        //display elements of BeeList
        for(int index=0; index < beeList.size(); index++)
            System.out.println(beeList.get(index));

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