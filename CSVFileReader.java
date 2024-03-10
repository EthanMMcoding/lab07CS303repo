package lab07CS303repo;

import java.io.*;
// import java.lang.reflect.Array;
import java.util.*;

/*This class will read CSV file into an array delimiting by 2*/

public class CSVFileReader {

    private static String[] array;

    CSVFileReader(int arraySize){
        array = new String[arraySize];
    }

    public String[] readFile(String fileName)throws IOException{

        BufferedReader csvFileReader = new BufferedReader(new FileReader(fileName));

        try{
            List < List<String>> data = new ArrayList<>(); 
            String line = csvFileReader.readLine();
            // String[] stringArray = new String[array.length];
            while(line != null){

                List<String> lineData = Arrays.asList(line.split(",", 2));
                data.add(lineData);
                line = csvFileReader.readLine();
            }

            for(List<String> list : data){
                for(String str : list){
                    System.out.println(str + " ");
                }

            }

            // for(int i = 0; i < array.length; i++){
            //     array[i] = stringArray[i]; 
            // }

            // System.out.println("This is the stringArray's length: " + stringArray.length);
            // for(int i = 0; i < arraySize; i++){
            //     array[i] = stringArray[i];
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
