package lab07CS303repo;

import java.io.*;
import java.util.*;

public class Lab07 {
    
    public static void main(String[] args)throws IOException {

        BinarySearchTree CSVTree = new BinarySearchTree(); // tree for the CSV random file
        BinarySearchTree UPCLab7Tree = new BinarySearchTree(); // using this tree for the lab7 CSV file 

        CSVFileReader UPCReader = new CSVFileReader(); // file reader object that will read the UPC file into a list of arrays 
        CSVFileReader inputDat = new CSVFileReader(); // for reading the inputDat file
        CSVFileReader UPCLab7Reader = new CSVFileReader(); //read the file into a list of arrays

        UPCReader.readFile("UPC-random.csv", ",", 2, 2); // read the csv file into a list of arrays
        inputDat.readFile("input.dat", ",", 2, 2);
        UPCLab7Reader.readFile("UPC_lab07.csv", ",", 2, 2);
        
        List<String[]> UPCList = UPCReader.getListOfArrays(); // list storing file list data
        List<String[]> inputDatList = inputDat.getListOfArrays(); //list storing inputDat data
        List<String[]> UPCLab7List = UPCLab7Reader.getListOfArrays(); // store the list of arrays

        for(String[] e : UPCList){ // loop over the file list
            BinarySearchNode newNode = new BinarySearchNode(Long.parseLong(e[0]), e[1]); // create a new node from each array in the list

            CSVTree.treeInsert(CSVTree, newNode); // insert the node into the tree
        }

        for(String[] p : UPCLab7List){
            BinarySearchNode nextNode = new BinarySearchNode(Long.parseLong(p[0]), p[1]);
            UPCLab7Tree.treeInsert(UPCLab7Tree, nextNode);
        }
        
        BinarySearchNode CSVTreeRoot = CSVTree.getRoot(); // variable to hold root of tree
        CSVTree.inOrderTreeWalk(CSVTreeRoot);
        // CSVTree.iterativeInOrderTreeWalk(CSVTreeRoot);
        /*here are a series a of tests */
        System.out.println("The total number of objects in the tree: " + CSVTree.getCount());
        System.out.println(CSVTree.iterativeTreeSearch(CSVTreeRoot, 28800290919L).getParent());
        System.out.println(CSVTree.getRoot());
        System.out.println(CSVTreeRoot);
        System.out.println(CSVTreeRoot.getLeftChild());
        System.out.println(CSVTreeRoot.getRightChild());
        System.out.println(CSVTreeRoot.getRightChild().getParent());
        System.out.println(CSVTree.iterativeTreeSearch(CSVTreeRoot, 2158769549L));

        /*for loop testing search on each key in the inputDat file and printing the run time */
        for(String[] z : inputDatList){
            long startTime = System.nanoTime();
            CSVTree.iterativeTreeSearch(CSVTree.getRoot(), Long.parseLong(z[0]));
            long runTime = System.nanoTime() - startTime;
            System.out.printf("The run time when searching for key: %d in the random file is %dns\n", Long.parseLong(z[0]), runTime);
        }

        for(String[] n : inputDatList){
            long startTime = System.nanoTime();
            CSVTree.iterativeTreeSearch(UPCLab7Tree.getRoot(), Long.parseLong(n[0]));
            long runTime = System.nanoTime() - startTime;
            System.out.printf("The run time when searching for key: %d in the sorted file is %dns\n", Long.parseLong(n[0]), runTime);
        }
    
    }
}
