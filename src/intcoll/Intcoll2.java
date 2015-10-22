//*********************************************************************
//LAST MODIFIED BY: JIMMY SENG
//LAST MODIFIED DATE: 9/7/15
// FILE NAME    : Intcoll2.java
// DESCRIPTION  : This file contains the class Intcoll2.
//*********************************************************************

import java.util.*;

public class Intcoll2 {

    private int[] c;//Integer array to hold value
    private int howmany;//Counter to keep track of how many items are in the array

    public Intcoll2()//Default Constructor, no input
    {
        c = new int[500]; //Creates an array of length 500
        howmany = 0;//Initialized counter to 0
    }

    public Intcoll2(int i)//Constructor with integer input parameter to specify length of array
    {
        c = new int[i];//Creates specified length array
        howmany = 0;//Initialize counter to 0
    }

    public void copy(Intcoll2 obj)//Make a copy of the parameter object
    {
        if (this != obj)//If this object does not equal the parameter object		
        {
            c = new int[obj.howmany];//Create a new array with the same length as then number of items in the passed object
            int j = 0;
            while (j < obj.howmany)//copy the value from the object array into the new array
            {
                c[j] = obj.c[j];
                j++;
            }
            this.howmany = obj.howmany;//make sure this object's counter matches the passed object's counter
        }
    }

    public boolean belongs(int i)//Check to see if the passed value is already in the array
    {
        int j = 0;
        while ((j < howmany) && (c[j] != i)) {//Check through the values in array to see if the passed value is found
            j++;
        }
        return ((i > 0) && (c[j] == i));// returns true if the value is positive and IS IN the array and false if the value negative or IS NOT in the array
    }

    public void insert(int i)//Insert passed value into the array
    {
        if (i > 0) {
            int j = 0;
            while ((j < howmany) && (c[j] != i)) {//Look through array to see if the value being inserted already exists in the array
                j++;
            }
            if (j == howmany) {//If the passed value is not found by the end of the array, create a new array with an extra space to accomodate 
                int d[] = new int[howmany + 1];
                for (int k = 0; k < howmany; k++) {//Copy values from the old array into the new array
                    d[k] = c[k];
                }
                c = d;//Set old array to now point to new array
            }
            c[j] = i;//Add passed value into the last slot in the new array
            howmany++;//Increase counter by 1
        }
    }

    public void omit(int i)//Given an integer parameter, remove it from the array
    {
        if (i > 0) {
            int j = 0;
            while ((j < howmany) && (c[j] != i)) {//Traverse the array and see if the passed value is in the array
                j++;//See if the passed value is in the array
            }
            if (c[j] == i)//If the integer DOES exist in the array
            {
                int k = j + 1;//K equals next index in the array
                while (k < howmany) {//K goes to howmany
                    k++;
                }
                c[j] = c[k - 1]; //Replace passed value with the last value of the array
                howmany--;//Decrement counter by 1
            }
        }
    }

    public int get_howmany()//Count number of elements in the array
    {
        return howmany;//Return number of items in the array
    }

    public void print()//Print out elements of the array
    {
        int j = 0;
        System.out.println();
        while (j < howmany) {
            System.out.println(c[j]);
            j++;
        }
    }

    public boolean equals(Intcoll2 obj)//Check to see if the elements of this array equals the values of the passed object array
    {
        boolean result = false;

        if (this.howmany == obj.howmany) {//If the number of items in this object is equal to the number of items in the passed object
            int j = 0;
            result = true;

            while ((j < howmany) && result) {//Traverse the array
                result = obj.belongs(c[j]);//result variable will be true if local item array belongs in passed object array and false otherwise
                j++;
            }
        }

        return result;//Return true is all local items also belong to passed object array and false otherwise
    }
}
