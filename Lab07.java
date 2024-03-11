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
        // int fileArrLength = fileReader.readFile("input.dat").length;
        fileReader.printList(fileReader.readFile("input.dat"));
        // for(int i = 0; i < fileArrLength; i++){
            // System.out.println(fileReader.readFile("input.dat")[i]);
            // for(int k = 0; k < fileReader.readFile("input.dat")[i]; k++)
        // }
        // for(int i = 0; i < data.size(); i++){
        //     if(isInteger(data.get(i)));
        // }
        // System.out.println((fileReader.readFile("input.dat")[0].getClass()));

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
