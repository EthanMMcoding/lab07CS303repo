package lab07CS303repo;

import java.io.*;
import java.util.*;

/*This class will read CSV file into an array delimiting by 2*/

public class CSVFileReader {

    private static String[] array;

    CSVFileReader(int arraySize){
        array = new String[arraySize];
    }

    public String[] readFile(String fileName, int arraySize)throws IOException{

        BufferedReader csvFileReader = new BufferedReader(new FileReader(fileName));

        try{
            String line = csvFileReader.readLine();
            String[] stringArray = new String[arraySize];
            int k = 0;
            while(line != null){
                stringArray = line.split(",", 2);
                line = csvFileReader.readLine();
                for(int i = 0; i < stringArray.length; i++){
                    array[k] = stringArray[i];
                    k++; 
                }
            }
            System.out.println("This is the stringArray's length: " + stringArray.length);
            // for(int k = 0; k < arraySize; k++){
            //     array[k] = stringArray[k];
            // }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            csvFileReader.close();
        }

        return array;
    }

    public String getValueFromArray(int index){
        return array[index];
    }

    public void printArray(String[] array){
        System.out.println(Arrays.deepToString(array));
    }

}
