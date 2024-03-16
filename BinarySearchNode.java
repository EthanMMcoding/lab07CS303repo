package lab07CS303repo;

public class BinarySearchNode {

    private long key;
    private BinarySearchNode left = null; //the pointers to the child nodes, implementing a linked list
    private BinarySearchNode right = null;
    private BinarySearchNode parent = null; //pointer to the parent to make it a doubly linked list
    private String value;

    BinarySearchNode(long key, String value){ //create a new node
        this.key = key;
        this.value = value;
    }

    public long getKey(){ //get key of the node
        return key;
    }

    public String getValue(){ //get value of the node
        return value;
    }

    public BinarySearchNode getParent(){ //get parent of the node
        return parent;
    }
    public BinarySearchNode getLeftChild() { //get left child of the node
        return left;
    }

    public BinarySearchNode getRightChild() { //get right child of the node
        return right;
    }

    public void setParent(BinarySearchNode parent){ //set the parent of a node
        this.parent = parent;
    }
    public void setLeftChild(BinarySearchNode left) { //set a node to be this nodes left child
        this.left = left;
    }

    public void setRightChild(BinarySearchNode right) { //set a node to be this nodes right child
        this.right = right;
    }
    
    @Override
    public String toString() { //to string overridden to give a string value for each node
        return "key: " + this.getKey() + " value: " + this.getValue();
    }

}
