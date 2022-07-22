import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        getInput();
        
    }

    private static void getInput() throws FileNotFoundException, IOException{
        HashMap<String, ArrayList<Entry>> map = new HashMap<String, ArrayList<Entry>>();
        Entry e;
        try (Scanner reader = new Scanner(new File("./input.txt"))) {
            while(reader.hasNextLine()) {
                e = processLine(format(reader.nextLine()));
                if (!map.containsKey(e.getAddress().toLowerCase().trim())) {
                    ArrayList<Entry> list = new ArrayList<Entry>();
                    if (e.getAge() > 18) list.add(e);
                    map.put(e.getAddress().toLowerCase(), list);
                } else {
                    if (e.getAge() > 18) {
                        map.get(e.getAddress().toLowerCase()).add(e);
                    }
                }
            } 
            printResults(map);
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

    private static void printResults(HashMap<String, ArrayList<Entry>> map) {
        for (String st : map.keySet()) {
            if (map.get(st).size() > 0) {
                System.out.printf("%s:\n",st);
            }

            for (Entry en : map.get(st)) {
                if ((en.getAge() > 18)) {
                    en.printToString();
                }
            }
        }
    }


}