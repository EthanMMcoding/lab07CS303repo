package lab07CS303repo;

public class BinarySearchNode {

    private int key;
    private BinarySearchNode left = null; // act like the pointers to the child nodes
    private BinarySearchNode right = null;
    private String value;

    BinarySearchNode(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public BinarySearchNode getLeftChild() {
        return left;
    }

    public BinarySearchNode getRightChild() {
        return right;
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
