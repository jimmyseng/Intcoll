//CREATED BY: JIMMY SENG
//LAST MODIFIED DATE: 9/22/15
//

/**
 *
 * @author Jimmy
 */
import java.util.*;

public class Intcoll5 {

    private int howmany;
    private LinkedList<Integer> c;//A linked list of Integer Objects

    public Intcoll5() {
        howmany = 0;
        c = new LinkedList<>();
    }

    public Intcoll5(int i) {
        howmany = 0;
        c = new LinkedList<>();
    }

    public boolean belongs(int i) {//Check to see if the passed parameter is in the linked list
        return c.contains(new Integer(i));//Make passed integer value an Integer object and use LinkedList function contains to see if that int is in the linked list
    }

    public void insert(int i) {
        while (!(this.belongs(i))) {//call the local belongs function and see if the integer belongs to linked list
            c.add(new Integer(i));//if the number does not belong to the linked list, insert the value into the end of the list as an Integer object
            howmany++;//increment howmany
        }
    }

    public void omit(int i) {
        if (this.belongs(i)) {//If the number is found in the list
            c.remove(new Integer(i));//remove it
            howmany--;//decrease how many
        }
    }

    public void print() {
        ListIterator<Integer> I = c.listIterator();//create a List interator to traverse the list
        while (I.hasNext()) {//If there is an item still in the list
            Integer n = I.next();//n will point to that node
            System.out.println(n.intValue());//display n's integer value
        }
    }

    public void copy(Intcoll5 obj) {
        if (this != obj) {//if these are the same objects
            howmany = obj.howmany;//local howmany will be set to equal object parameter's howmany
            c=new LinkedList<>();//local list will become a new list
            ListIterator<Integer> I = obj.c.listIterator();//initialize a list iterator to traverse the parameter object list
            
            while (I.hasNext()) {//while there are still items in the parameter object list
                Integer n = I.next();//n will point to the nodes in the parameter object list
                c.add(new Integer(n.intValue()));//copies values of the parameter object list to the local list, deep copy 
            }
        }
    }

    public int get_howmany() {
        return c.size();//get the number of items in the list
    }

    public boolean equals(Intcoll5 obj) {
        boolean result =true;
        if (this.howmany == obj.howmany) {//Check to see if both lists have same amount of items
            ListIterator<Integer> I = obj.c.listIterator();//create list iterator to traverse parameter object list
            while (I.hasNext()) {//while there are items in object list
                Integer n = I.next();//n will point to the nodes in parameter list 
                if (!(this.belongs(n.intValue()))) {//check to see if those values from parameter list are also present in the local list
                    result = false;//if parameter values are not found in the list, return false
                }
            }
        } else {
            result = false;//if local how many does not equal parameter object how many, not the same amount of items in lists
        }
        return result;
    }
}
