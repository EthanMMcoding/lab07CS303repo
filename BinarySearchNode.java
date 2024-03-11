package lab07CS303repo;

public class BinarySearchNode {

    private long key;
    private BinarySearchNode left = null; //the pointers to the child nodes, implementing a linked list
    private BinarySearchNode right = null;
    private BinarySearchNode parent = null;
    private String value;

    BinarySearchNode(long key, String value){
        this.key = key;
        this.value = value;
    }

    public long getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public BinarySearchNode getParent(){
        return parent;
    }
    public BinarySearchNode getLeftChild() {
        return left;
    }

    public BinarySearchNode getRightChild() {
        return right;
    }

    public void setParent(BinarySearchNode parent){
        this.parent = parent;
    }
    public void setLeftChild(BinarySearchNode left) { //set a node to be this nodes left child
        this.left = left;
    }

    public void setRightChild(BinarySearchNode right) { //set a node to be this nodes right child
        this.right = right;
    }
    
    @Override
    public String toString() {
        return "key: " + this.getKey() + " value: " + this.getValue();
    }

}
