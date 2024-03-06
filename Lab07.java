package lab07CS303repo;

import java.io.*;

public class Lab07 {
    
    public static void main(String[] args)throws IOException {

        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchNode root = new BinarySearchNode(2, "beren");
        BinarySearchNode node1 = new BinarySearchNode(6, "dior");
        BinarySearchNode node2 = new BinarySearchNode(4, "elwing");

        CSVFileReader fileReader = new CSVFileReader(17);

        // fileReader.readFile("input.dat", 17);
        fileReader.printArray(fileReader.readFile("input.dat", 17));
        System.out.println("Value from the string array: " + fileReader.getValueFromArray(0));

        BinarySearchTree.treeInsert(tree, root);
        BinarySearchTree.treeInsert(tree, node1);
        BinarySearchTree.treeInsert(tree, node2);

        System.out.println(tree.getRoot());
        System.out.println(root.getRightChild());
        System.out.println(node1.getLeftChild());

        tree.inOrderTreeWalk(root);
        System.out.println(tree.iterativeTreeSearch(root, 4));
    }
}
