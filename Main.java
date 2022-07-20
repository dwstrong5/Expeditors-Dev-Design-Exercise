import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        getInput();
        
    }

    private static void getInput() throws FileNotFoundException, IOException{
        try (Scanner reader = new Scanner(new File("./input.txt"))) {
            while(reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }



}