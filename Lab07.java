package lab07CS303repo;

import java.io.*;
import java.util.*;

public class Lab07 {
    
    public static void main(String[] args)throws IOException {

        BinarySearchTree CSVTree = new BinarySearchTree(); // tree for the CSV file
        CSVFileReader fileReader = new CSVFileReader(); // file reader object that will read the csv file into a list of arrays 

        fileReader.readFile("UPC_lab07.csv"); // read the csv file into a list of arrays
        
        List<String[]> fileList = fileReader.getListOfArrays(); // the list storing the arrays of values from the file
        // int i = -1;
        for(String[] e : fileList){ // loop over the file list
            // BinarySearchNode parentNode = new BinarySearchNode(Integer.parseInt(fileList.get(i)[0]), fileList.get(i)[1]);
            BinarySearchNode newNode = new BinarySearchNode(Long.parseLong(e[0]), e[1]); // create a new node from each array in the list

            // i++;
            // newNode.setParent(newNode);

            CSVTree.treeInsert(CSVTree, newNode); // insert the node into the tree
        }
        BinarySearchNode CSVTreeRoot = CSVTree.getRoot(); 
        CSVTree.inOrderTreeWalk(CSVTreeRoot);
        System.out.println(CSVTree.iterativeTreeSearch(CSVTreeRoot, 28800290919L).getParent());
        System.out.println(CSVTree.getRoot());
        System.out.println(CSVTreeRoot);
        System.out.println(CSVTreeRoot.getRightChild());
        System.out.println(CSVTreeRoot.getRightChild().getParent());

        {
            // BinarySearchTree tree = new BinarySearchTree();
            // BinarySearchNode root = new BinarySearchNode(2, "beren");
            // BinarySearchNode node1 = new BinarySearchNode(6, "dior");
            // BinarySearchNode node2 = new BinarySearchNode(4, "elwing");
    
            // tree.treeInsert(tree, root);
            // tree.treeInsert(tree, node1);
            // tree.treeInsert(tree, node2);
    
    
            // System.out.println(tree.getRoot());
            // System.out.println(root.getRightChild());
            // System.out.println(node1.getLeftChild());
    
            // tree.inOrderTreeWalk(root);
            // System.out.println(tree.iterativeTreeSearch(root, 4));
        }
    
    }
}
