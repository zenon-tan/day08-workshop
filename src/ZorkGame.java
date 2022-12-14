import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ZorkGame {


    // Read file
    // Create constants to compare the line to
    // If line 

    public static void main(String[] args) throws Exception {

        String fileName = args[0];

        System.out.printf("Processing %s...\n", fileName);

        List<ArrayList<String>> allLocations = ReadFile.readFile(fileName);
        HashMap<String, Location> locationList = ReadFile.createRooms(allLocations);

        String currentLocStr = ReadFile.startingLoc;
        Location currentLoc = locationList.get(currentLocStr);

        Console cons = System.console();

        Boolean isQuit = false;

        System.out.println(currentLoc.toString());

        while(!isQuit) {

            System.out.printf(">>> ");

            String readline = cons.readLine().strip();


            if(readline.equals(ReadFile.EXIT)) {
                System.out.println("Program exiting...");
                System.out.println("Thanks for playing!");
                isQuit = true;
                break;
            }

            List<String> possibleDir = new ArrayList<>();

            for(String i : currentLoc.getDirection()) {
                String[] splitStr = i.split(" ");

                possibleDir.add(splitStr[0]);
                if(!possibleDir.contains(readline)) {
                    System.out.printf("You cannot go %s\n",readline);
                    System.out.printf("Please select a new direction:\n");
                    System.out.println(currentLoc.toString());


                } else {

                    currentLoc = locationList.get(splitStr[1]);
                    currentLocStr = currentLoc.getRoom();
                    System.out.println(currentLoc.toString());
                    break;


                }

            }



        }

    }
    
}
