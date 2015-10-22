//CREATED BY: JIMMY SENG
//LAST MODIFIED DATE: 9/22/15
//

/**
 *
 * @author Jimmy
 */
public class Intcoll4 {

    private int howmany;
    private ListNode c;

    private class ListNode {

        private int info;
        private ListNode link;

        public ListNode() {
            info = 0;
            link = null;
        }
    }

    public Intcoll4() {
        howmany = 0;
        c = null;
    }

    public Intcoll4(int i) {
        howmany = 0;
        c = null;
    }

    public boolean belongs(int i) {//Check to see if the passed parameter is in the linked list
        ListNode p = c;

        while ((p != null) && (p.info != i)) {//As long as p is not null means it is pointing to anoter ListNode and if that ListNode's item does not equal the passed value
            p = p.link;//P will equal the link that is in the object it is pointing to to progress through the linked list
        }
        return (p != null);//If p is null, then it has reached the end of the list and has not found the passed value thus returning FALSE
        //If p does not equal null, then it has found a ListNode where the item equals the passed value and would return TRUE
    }

    public void insert(int i) {
        ListNode p = c;

        while ((p != null) && (p.info != i)) {
            p = p.link;
        }//When loop finishes, p will either be null and at the position of the last ListNode of the list or pointing to the ListNode where the passed value already exists
        if (p == null) {//If p is at the end of the list
            p = new ListNode();//create a new ListNode
            p.info = i;//Set the item equal to the passed value
            p.link = c;//Set the link in the new ListNode to point to where c used to point to (the former first ListNode)
            c = p;//Set c to point to this new ListNode which inserts the passed value as the new first item in the list and shifts every other item down 1
            howmany++;
        }
    }

    public void omit(int i) {
        ListNode p = c;
        ListNode pred = null;

        while ((p != null) && (p.info != i)) {
            pred = p;//predecessor keeps track of node before traversal node
            p = p.link;
        }
        if (p != null) {//target is found
            howmany--;//decrement howmany
            if (pred!=null){//if there is a node before target node
            p = p.link;//point to next node after target node
            pred.link = p;//make prededessor node point to node after target node
            }else{//number to be omitted is in first node
                c=p.link;//c will be null
            }
        }
    }
    
    public void print() {
        ListNode p = c;
        while (p != null) {
            System.out.println(p.info);
            p = p.link;
        }
    }

    public void copy(Intcoll4 obj) {
        if (this != obj) {//if these are the same types of objects
            howmany = obj.howmany;//copy howmany
            ListNode p = c;//p is the traversal node
            ListNode i = c;//i will be the predecessor node
            ListNode q = obj.c;//q is the traversal node for the parameter object list

            //Used for initial node copy
            if (q != null) {//If parameter object list is not empty
                p = new ListNode();//create new node
                p.info = q.info;//copy value of object node
                c = p;//this object node now points to newly created copied node
                i = p;
                q = q.link;//traverse to next node in paramter object list
            }
            while ((q != null)) {//continue copying paramter object list until end
                p = new ListNode();
                p.info = q.info;
                i.link = p;
                i = i.link;
                q = q.link;
            }
        }
    }

    public int get_howmany() {
        return howmany;
    }

    public boolean equals(Intcoll4 obj) {
        ListNode p = c;//traversal node for local list
        ListNode q = obj.c;//traversal node for paramter object list

        if (this.howmany == obj.howmany) {//Check to see if both lists have same amount of items
            while (p != null) {//while we did not reach end of list
                if (obj.belongs(p.info)) {//Check to see if local values are found in parameter object list
                    p = p.link;
                } else {
                    return false;//If local value not found in parameter object list, return not equal
                }

            }
        } else {//If local list does not contain same amount of items, return not equal
            return false;
        }
        return true;
    }
}
