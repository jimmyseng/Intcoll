//*********************************************************************
//LAST MODIFIED BY: JIMMY SENG
//LAST MODIFIED DATE: 9/4/15
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

import java.util.*;

public class Intcoll1
{
   private int[] c; //array to hold integer values

   public Intcoll1()//Default Constructor, no input
   {
      	c = new int[500+1]; //Creates an array of length 501 with initial slot set to 0 to hold 500 integers
      	c[0] = 0;//0 will be used to mark the end of a collection of integers
   }

   public Intcoll1(int i)//Constructor with integer input parameter to specify length of array
   {
      	c = new int[i+1];//Creates specified length array +1 to include 0 end marker
    	c[0] = 0;
   }

   public void copy(Intcoll1 obj)//Make a copy of the parameter object's array
   {
      	if (this != obj)//If this object does not equal the parameter object		
      	{
		c = new int[obj.c.length];//Create a new array with the same length as the passed object array
		int j = 0;
		while (obj.c[j] != 0)//As long as the value from the object isn't 0
		{
			c[j] = obj.c[j]; j++;//copy the value from the object array into the new array at the matching index
		}
		c[j] = 0;//Add 0 as the last value in this array
	}
   }

   public boolean belongs(int i)//Check to see if the passed value is already in the array
   {
      	int j = 0;
      	while ((c[j] != 0)&&(c[j] != i)) j++;//Check through the values in array to see if the passed value is found, stop when you see 0 which denotes you've reached the end of the array
      	return ((i>0)&&(c[j] == i));// returns true if the value is positive and IS IN the array and false if the value negative or IS NOT in the array
   }

   public void insert(int i)//Insert passed value into the array
   {
      	if (i > 0)
	{
	 	int j = 0;
	     	while ((c[j] != 0) && (c[j] != i)) j++;//Look through array to see if the value being inserted already exists in the array
		if (c[j] == 0)
	     	{
			if (j == c.length - 1)//If there is no more room in the array
		   	{
                            int d[] =new int[c.length*2];
                            for(int k=0;k<c.length;k++){
                                d[k]=c[k];
                            }
                            c=d;
		   	}
		   	c[j] = i; c[j + 1] = 0;
		}
	}
   }

   public void omit(int i)//Given an integer parameter, remove it from the array
   {
	if (i>0)
	{
      		int j = 0;
      		while ((c[j] != 0)&&(c[j] != i)) j++;//See if the passed value is in the array
      		if (c[j] == i)//If the integer DOES exist in the array
      		{
         		int k = j+1;//K equals next item in the array
         		while (c[k] != 0) k++;//K goes to end of the array
         		c[j] = c[k-1]; c[k-1]=0;//Swap that integer out by replacing it with the last value before 0 in the array and input 0 a slot down
      		}
	}
   }

   public int get_howmany()//Count number of elements in the array and return that number
   {
      	int j=0, howmany=0;

      	while (c[j]!=0) {howmany++; j++;}//Increase howmany by the number of cells before 0 is found
      	return howmany;
   }

   public void print()//Print out elements of the array up to the first 0 value
   {
      	int j = 0;
      	System.out.println();
      	while (c[j] != 0)
      	{
         	System.out.println(c[j]); j++;
      	}
   }

   public boolean equals(Intcoll1 obj)//Check to see if the elements of this array equals the values of the passed object array
   {
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)//Traverse through the array
      	{
         	result = obj.belongs(c[j]); j++;//Check to see if the values in this object also belongs to the parameter object
      	}
      	j = 0;
      	while ((obj.c[j] != 0)&&result)//Traverse through the array
      	{
         	result = belongs(obj.c[j]); j++;//See if the values of the passed object array also belong to this array
      	}
      	return result;//result will be true it the items in each object's array belong in each other
   }
}


