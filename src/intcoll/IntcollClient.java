
//**********************************************************
// LAST MODIFIED BY: JIMMY SENG
// LAST MODIFIED DATE: 9/7/15
// FILE: NAME   : Intcollclient.java
// DESCRIPTION  : This is a client of class Intcoll classes.
//**********************************************************
import java.util.*;

public class IntcollClient {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {
        int value;
        Scanner keyboard = new Scanner(System.in);
        Intcoll6 P = new Intcoll6(5), N = new Intcoll6(5), L = new Intcoll6(5);

        System.out.println("Enter an integer to be inserted or 0 to quit:");
        value = keyboard.nextInt();
        while (value != SENTINEL) {
            if (value > 0) {
                P.insert(value);
                L.insert(value);
            } else {
                N.insert(-value);
                L.omit(-value);
            }
            System.out.println("Enter next integer to be inserted or 0 to quit:");
            value = keyboard.nextInt();
        }
        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("There are " + P.get_howmany() + " items in P.");
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("There are " + N.get_howmany() + " items in N.");
        System.out.println("\nThe values in collection L are:");
        L.print();
        System.out.println("There are " + L.get_howmany() + " items in L.");
        if (P.equals(N)) {
            System.out.println("\nP and N are equal.");
        } else {
            System.out.println("\nP and N are NOT equal.");
        }
        Intcoll6 A = new Intcoll6();
        A.copy(L);
        System.out.println("\nThe values in the copy of L are:");
        A.print();
    }

}
