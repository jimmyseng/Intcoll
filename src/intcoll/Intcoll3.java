//*********************************************************************
// LAST MODIFIED BY: JIMMY SENG
// LAST MODIFIED DATE: 9/7/15
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
//*********************************************************************

import java.util.*;

public class Intcoll3 {

    private boolean[] c;//Array to hold integer values
    private int howmany;//Counter to track how many items are added to array

    public Intcoll3()//Default Constructor, no input
    {
        c = new boolean[500+1]; //Creates an array of length 501 to count for number 1-500
        howmany = 0;//Initialize counter to 0
    }

    public Intcoll3(int i)//Constructor with integer input parameter to specify length of array
    {
        c = new boolean[i+1];//Creates specified length array
        howmany = 0;//Initialize counter to 0
    }

    public void copy(Intcoll3 obj)//Make a copy of the parameter object
    {
        if (this != obj)//If this object does not equal the parameter object		
        {
            c = new boolean[obj.c.length];//Create a new array with the same length as the passed object
            int j = 0;
            while (j < obj.c.length)//Traverse through the array and copy each index of object array to local array
            {
                c[j] = obj.c[j];//copy all values of parameter object array into local array
                j++;
            }
            this.howmany = obj.howmany;//set counter to be the same as parameter object counter
        }
    }

    public boolean belongs(int i)//Check to see if the passed value is already in the array
    {
        return(c[i]);
    }

    public void insert(int i)//Insert passed value into the array
    {
        if(c.length<i+1){//If array does not go up to index of passed integer value
            boolean d[]=new boolean [i+1];//Create new array to index of passed integer value
            for (int j=0;j<c.length;j++){//Copy all values of original array into newly created array
                d[j]=c[j];
            }
            c=d;//Set c to point to newly created array
        }
        c[i]=true;//Set the passed value index into the array to true
        howmany++;//Increase counter by 1
    }

    public void omit(int i)//Given an integer parameter, remove it from the array
    {
        if(c[i]==true){//If passed value was in the array
            c[i]=false;//Set it to false, which removes it from the array
            howmany--;//Only if the value was changed from TRUE to FALSE do we need to decrement the counter
        }
    }

    public int get_howmany()//Count number of elements in the array
    {
        return howmany;//Return number of true values of the array
    }

    public void print()//Print out elements of the array
    {
        System.out.println();
        for(int j=0;j<c.length;j++){
            if(c[j]){
                System.out.println(j);
            }
        }
    }

    public boolean equals(Intcoll3 obj)//Check to see if the elements of this array equals the values of the passed object array
    {
        boolean result=false;
        
        if (this.howmany == obj.howmany) {//If this object contains the same number of TRUEs as the passed object
            for(int j=0;j<c.length;j++){//traverse both local and object arrays
                if(this.c[j]==obj.c[j]){//Check to see if the boolean at each index matches between the local and passed object arrays
                    result=true;//If they match, then true
                }else{
                    result=false;//If they don't match then result is false and you can break the loop since we know they aren't equal now
                    break;
                }
            }
        }
        return result;
    }
}
