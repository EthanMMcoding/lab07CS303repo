package lab07CS303repo;

/* this class will handle the methods for binary search trees */

public class BinarySearchTree {

    public static BinarySearchNode root = null; // a static variable, the root will be the same for the whole tree

    BinarySearchTree(){}

    /*returns the root node of the tree */
    public BinarySearchNode getRoot(){ // method to return the root of the tree
        return root;
    }

    /*inserts a node into its correct place in the tree */
    public static void treeInsert(BinarySearchTree tree, BinarySearchNode node){
        BinarySearchNode y = null;
        BinarySearchNode x = root;
        while(x != null){
            y = x;
            if(node.getKey() < x.getKey()){
                x = x.getLeftChild();
            }
            else{
                x = x.getRightChild();
            }
        }
        // is it necessary to assign the new nodes parent to y? 

        if(y == null){
            root = node;
            System.out.println("root value: "+ root.getValue());
        }
        else if(node.getKey() < y.getKey()){
            y.setLeftChild(node);
            System.out.println("value of the parent of the new left node: "+ y.getValue());
        }
        else{
            y.setRightChild(node);;
            System.out.println("Value of the parent of the new right node: " +y.getValue());
        }
    }

    /* method to print the keys in ascending order starting from the given node*/
    public void inOrderTreeWalk(BinarySearchNode rootNode){
        if(rootNode != null){
            inOrderTreeWalk(rootNode.getLeftChild());
            System.out.println(rootNode.getKey());
            inOrderTreeWalk(rootNode.getRightChild());
        }
    }
    /* method to search for a specific node*/ 
    public BinarySearchNode iterativeTreeSearch(BinarySearchNode rootNode, int key){
        while(rootNode != null && key != rootNode.getKey()){
            if(key < rootNode.getKey()){
                rootNode = rootNode.getLeftChild();
            }
            else{
                rootNode = rootNode.getRightChild();
            }
        }
        return rootNode;
    }
}
