import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        getInput();
        
    }

    private static void getInput() throws FileNotFoundException, IOException{
        ArrayList<Entry> list = new ArrayList<Entry>();
        try (Scanner reader = new Scanner(new File("./input.txt"))) {
            while(reader.hasNextLine()) {
                list.add(processLine(format(reader.nextLine())));
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    private static Entry processLine(String str) {
        String[] arr = str.split("\"");
        
        return new Entry(arr[1].trim(), arr[2].trim(), arr[3].trim(), arr[4].trim(), arr[5].trim(), Integer.parseInt(arr[6].trim()));
    }

    private static String format(String s) {
        s = s.replaceAll("[,.]", "");
        s = s.replaceAll("[\"][\"]", "\"");
        return s;
    }



}