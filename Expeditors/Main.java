package Expeditors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    // Expeditors.Main method
    public static void main(String[] args) throws FileNotFoundException, IOException{
        getInput();
    }

    // Method that reads input and calls processLine on each line of input file.
    private static void getInput() throws FileNotFoundException, IOException{
        HashMap<String, ArrayList<Entry>> map = new HashMap<String, ArrayList<Entry>>();
        Entry e;
        try (Scanner reader = new Scanner(new File("Expeditors/input.txt"))) {
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

    // Method that uses a single double-quote as a delimiter to obtain data about a single persons
    // record/entry. Uses that data to create and return a new Expeditors.Entry object containing data from
    // input line
    public static Entry processLine(String str) {
        String[] arr = str.split("\"");
        
        return new Entry(arr[1].trim(), arr[2].trim(), arr[3].trim(), arr[4].trim(), arr[5].trim(), Integer.parseInt(arr[6].trim()));
    }

    // Method that formats an input string by removing periods and commas, then replacing
    // consecutive double-quotes with a single double-quote to be used as a delimiter by
    // processLine.
    // Returns formatted string.
    public static String format(String s) {
        s = s.replaceAll("[,.]", "");
        s = s.replaceAll("[\"][\"]", "\"");
        return s;
    }

    // Prints the contents of a hashmap in the order of:
    // Address:
    //      Each individual residing at this address that is STRICTLY GREATER than 18 years old.
    // Next Address:
    //      Next individual...
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