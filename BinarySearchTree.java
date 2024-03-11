package lab07CS303repo;

/* this class will handle the methods for binary search trees */

public class BinarySearchTree {

    public BinarySearchNode root = null; // a static variable, the root will be the same for the whole tree

    BinarySearchTree(){}

    /*inserts a node into its correct place in the tree */
    public void treeInsert(BinarySearchTree tree, BinarySearchNode node){
        BinarySearchNode y = null;
        BinarySearchNode x = this.root;
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
        node.setParent(y);
        if(y == null){
            this.root = node;
            System.out.println("root value: "+ this.root.getValue());
        }
        else if(node.getKey() < y.getKey()){
            y.setLeftChild(node); //LCP == left child parent, RCP == right child parent
            // System.out.println("LCP key: " + y.getKey() +" LCP value: "+ y.getValue());
        }
        else{
            y.setRightChild(node);;
            // System.out.println("RCP key: " + y.getKey() + " RCP value: " + y.getValue());
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
    public BinarySearchNode iterativeTreeSearch(BinarySearchNode rootNode, long key){
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

    /*returns the root node of the tree */
    public BinarySearchNode getRoot(){ 
        return root;
    }
}
