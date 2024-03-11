package lab07CS303repo;

import java.io.*;
// import java.lang.reflect.Array;
import java.util.*;

/*This class will read CSV file into an array delimiting by 2*/

public class CSVFileReader {

    private static String[] array;
    private List<List<String>> listOfLists = new ArrayList<>();

    CSVFileReader(int arraySize){
        array = new String[arraySize];
    }

    public List<List<String>> readFile(String fileName)throws IOException{

        BufferedReader csvFileReader = new BufferedReader(new FileReader(fileName));

        try{
            String line = csvFileReader.readLine();
            while(line != null){
                List<String> lineData = Arrays.asList(line.split(",", 2));
                listOfLists.add(lineData);
                line = csvFileReader.readLine();
            }
            for(List<String> list : listOfLists){
                for(String str : list){
                    System.out.println(str + " ");
                }
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        finally{
            csvFileReader.close();
        }

        return listOfLists;
    }

    // public void printListOfListValues(List<List<String>> data){
    //     for(List<String> list : data){
    //         for(String str : list){
    //             System.out.println(str + " ");
    //         }
    //     }
    // }

    public String getValueFromArray(int index){
        return array[index];
    }

    public void printList(List<List<String>> listOflists){
        System.out.println(listOflists);
    }

    public List<List<String>> getListOfLists(){
        return listOfLists;
    }
}
