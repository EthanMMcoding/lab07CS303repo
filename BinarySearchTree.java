package lab07CS303repo;

import java.util.Stack;

/* this class will handle the methods for binary search trees */

public class BinarySearchTree {

    private BinarySearchNode root = null; // a static variable, the root will be the same for the whole tree
    private int count; //counting the number of nodes in the tree

    BinarySearchTree(){}

    /*inserts a node into its correct place in the tree, parameters are the tree where the node will be inserted and the new node */
    public void treeInsert(BinarySearchTree tree, BinarySearchNode node){ 
        BinarySearchNode y = null; //y is the parent of the node that will be inserted into the tree
        BinarySearchNode x = tree.getRoot(); //x is the current node that is being compared to find the inserted nodes correct position
        while(x != null){ //while x is not null keep searching down the tree until its spot is found
            y = x; //y is assigned x
            if(node.getKey() < x.getKey()){ //if the key of the node being inserted
                x = x.getLeftChild(); //x is assigned to its left child
            }
            else{
                x = x.getRightChild(); //x is assigned to its right child
            }
        } 
        node.setParent(y); //x is null at the position node will be inserted, y is node's parent
        if(y == null){ //if y is null x is null, the tree was empty
            this.root = node; //insert the node as the root
            count++; //extra variable to count the number of nodes in the tree
        }
        else if(node.getKey() < y.getKey()){ //if the key of the node is less than its parent's it is the left child
            y.setLeftChild(node); //set the node to be its left child
            count++; //increase count
        }
        else{ //the only other option is that node is the right child of y 
            y.setRightChild(node); //set the node to be y's right child
            count++; //increase count
        }
    }

    /* inOrderTreeWalk iteratively using a stack, parameter is the root node of the tree to print all of the elements in order */
    /* implemented the iterative version because the recursive version has a stack overflow issue in unbalanced trees */
    public void iterativeInOrderTreeWalk(BinarySearchNode rootNode){
        Stack<BinarySearchNode> nodeStack= new Stack<>(); //node stack for the nodes
        BinarySearchNode current = rootNode; //set a current node 

        while(current != null || !nodeStack.empty()){ //if the stack is not empty and the node is not  null
            while(current != null){ //making sure the node is not null, will continue until reaching bottom left of tree
                nodeStack.push(current); //push the current node onto the stack
                current = current.getLeftChild(); //set the current node to the left child
            }
            current = nodeStack.pop(); //set current to the left node
            System.out.println(current.getKey()); //print the parent of the left node
            current = current.getRightChild(); //current is equal to the right child
        }

    }

    /* method to print the keys in ascending order starting from the given node, parameter is the root node of the tree to provide in order traversal*/
    public void inOrderTreeWalk(BinarySearchNode node){
        if(node != null){  //ending condition 
            try{ //try catch block catches the stack overflow
                inOrderTreeWalk(node.getLeftChild()); //recursively call until the last left child (beginning of the order)
                System.out.println(node.getKey()); //print the key of the current node
                inOrderTreeWalk(node.getRightChild()); //recursively call until the last right child (end of the order)
            }
            catch(StackOverflowError e){ //catch stack over flow error
                System.out.println("Stack overflow");
            }   
        }
    }

    /* method to search for a specific node from a specific node (should be root), parameter is root node and the key of the node being searched for*/ 
    public BinarySearchNode iterativeTreeSearch(BinarySearchNode node, long key){
        //while loop checking to ensure that the tree has contents (if it the tree is empty or it ended) also checks to see if the node key is equal to target key
        while(node != null && key != node.getKey()){ //while the node is not null and the key of the node is not the key being searched for, loop until node is found or every node is searched
            if(key < node.getKey()){ //if the key is less than the nodes key, node is equal to its left child
                node = node.getLeftChild();
            }
            else{ //else node is equal to its right child
                node = node.getRightChild();
            }
        }
        return node;
    }

    /*returns the root node of the tree */
    public BinarySearchNode getRoot(){ 
        return this.root;
    }

    /*method returns count of nodes in a tree */
    public int getCount(){
        return this.count;
    }
}
