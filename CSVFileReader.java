package lab07CS303repo;

import java.io.*;
import java.util.*;

/*This class will read CSV file into an array delimiting by 2*/

public class CSVFileReader {

    private List<String[]> listOfArrays = new ArrayList<>();

    CSVFileReader(){
    }

    /* readFile takes a file, reads it line by line into arrays, and stores those arrays into a list */
    public List<String[]> readFile(String fileName)throws IOException{

        BufferedReader csvFileReader = new BufferedReader(new FileReader(fileName));

        try{
            String line = csvFileReader.readLine();
            String[] lineData = new String[2]; //size 2 because I want to store each key value pair in the file in an array
            while(line != null){
                lineData = line.trim().split(",", 2);
                listOfArrays.add(lineData);
                line = csvFileReader.readLine();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        finally{
            csvFileReader.close();
        }
        
        return listOfArrays;
    }

    /*print out each individual array stored in the list, prints hexadecimal value */
    public void printListOfArrays(List<String[]> listOfArrays){
        System.out.println(listOfArrays);
        for(int i = 0; i < listOfArrays.size(); i++){
            System.out.println(listOfArrays.get(i));
        }
    }

    public void printListOfArrays(){
        for(String[] arr : listOfArrays){
            for(String str : arr){
                System.out.println(str + " ");
            }
        }
    }

    public List<String[]> getListOfArrays(){
        return this.listOfArrays;
    }

    public int getListArrSize(){
        return this.listOfArrays.size();
    }
}
