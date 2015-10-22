/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @author Jimmy
 */

public class Intcoll6 {

    private int howmany;
    private btNode c;

    private static class btNode {

        private btNode left;
        private int info;
        private btNode right;

        private btNode() {
            left = null;
            info = 0;
            right = null;
        }

        private btNode(int s, btNode lt, btNode rt) {
            info = s;
            left = lt;
            right = rt;
        }
    }

    public Intcoll6() {
        howmany = 0;
        c = null;
    }

    public Intcoll6(int i) {
        howmany = 0;
        c = null;
    }

    public int get_howmany() {
        return howmany;
    }

    private static void printTree(btNode t) {
        btNode p = t;

        if (p != null) {
            printTree(t.left);
            System.out.println(t.info);
            printTree(t.right);

        }
    }

    public void print() {
        printTree(c);
    }

    public boolean belongs(int i) {
        btNode p = c;

        while ((p != null) && (p.info != i)) {
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (p != null);
    }

    public void insert(int i) {
        btNode p = c;
        btNode pred = null;

        while ((p != null) && (p.info != i)) {
            pred = p;
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            howmany++;
            p = new btNode(i, null, null);

            if (pred != null) {
                if (i < pred.info) {
                    pred.left = p;
                } else {
                    pred.right = p;
                }
            } else {
                c = p;
            }
        }
    }

    private static btNode copyTree(btNode t) {
        btNode L, R;
        btNode Root = null;

        if (t != null) {
            L = copyTree(t.left);
            R = copyTree(t.right);
            Root = new btNode(t.info, L, R);
        }
        return Root;
    }

    public void copy(Intcoll6 obj) {
        if (this != obj) {
            howmany = obj.howmany;
            c = new btNode();
            c = copyTree(obj.c);
        }
    }

    private static int toArray(btNode t, int[] a, int i) {
        int numNodes = 0;

        if (t != null) {
            numNodes = toArray(t.left, a, i);
            a[numNodes + i] = t.info;
            numNodes = numNodes + 1 + toArray(t.right, a, numNodes + i + 1);
        }
        return numNodes;
    }

    public boolean equals(Intcoll6 obj) {
        boolean result = (howmany == obj.howmany);

        if (this != obj) {
            if (result) {
                int[] a = new int[howmany];
                int[] b = new int[howmany];
                toArray(c, a, 0);
                toArray(c, b, 0);

                for (int i = 0; i < howmany; i++) {
                    if (a[i] != b[i]) {
                        return false;
                    }
                }
            }
        }
        return result;
    }

    public void omit(int i) {
        btNode p = c;
        btNode pred = null;
        btNode q = null;
        btNode predq = null;

        while ((p != null) && (p.info != i)) {
            pred = p;
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p != null) {//target to be omitted is found
            howmany--;
            
/**********Case 1: Main tree root node omit (1st node omit*********************/           
            if (pred == null) {//if target is main tree root node
                pred = p;
                if (p.left != null) {//if left subtree not empty
                    p = p.left;//go to left subtree
                    if (p.right != null) {//1st left node is not the largest item of the left subtree
                        while (p.right != null) {//then go to right most node in the left subtree(replacement node)
                            q = p;
                            p = p.right;
                        }
                        q.right = p.left;//replacement node predecessor now points to replacement node successor
                        p.left = pred.left;//replacement node connects to target node left subtree
                        p.right = pred.right;//replacement node connects to target node right subtree
                        c = p;//replacement node now inserted into main root of the tree
                    } else {//1st node in left subtree is the largest item of left subtree
                        c = p;
                        p.right = pred.right;
                    }
                } else if (p.right != null) {//if left subtree is null but right subtree is not null
                    c = p.right;
                } else {//target node is the only node in the tree
                    c = null;
                }//end main root case

/**************Case 2: Node has both left and right subtree*******************/
            } else if ((p.left != null) && (p.right != null)) {//double subtree root omit
                q = p.left;//go to left subtree
                if (q.right != null) {//1st left node is not the largest item of the left subtree
                    predq = p;
                    q = p.right;
                    while (q.right != null) {//then go to right most node in the left subtree(replacement node)
                        predq = predq.right;
                        q = q.right;
                    }
                    predq.right = q.left;
                    q.left = p.left;
                    q.right = p.right;
                    pred.right = q;

                } else {//1st node in left subtree is the largest item of left subtree
                    if (pred.info < q.info) {//check to see if the replacement node is larger than pred
                        pred.right = q;
                        q.right = p.right;
                    } else {//replacement node is smaller than pred
                        pred.left = q;
                        q.right = p.right;
                    }//end double subtree root omit
                }
                
/*****************Case 3: Node to be omitted only has left subtree**************/
            } else if (p.left != null) {//only left subtree node omit
                predq = p;
                q = p.left;
                if (q.right != null) {
                    while (q.right != null) {
                        predq = q;
                        q = q.right;
                    }
                    predq.right = q.left;
                    pred.right = q;
                    q.left = p.left;
                } else {
                    pred.right = q;
                }

/*****************Case 4: Node to omitted only has right subtree***************/
            } else if (p.right != null) {//only right subtree node omit
                pred.right = p.right;

                
/***************Case 5:  Leaf Node to be omitted*****************************/
            } else {//leaf node omit
                if (p == pred.left) {
                    pred.left = null;
                } else {
                    pred.right = null;
                }
            }

        }
    }
}
